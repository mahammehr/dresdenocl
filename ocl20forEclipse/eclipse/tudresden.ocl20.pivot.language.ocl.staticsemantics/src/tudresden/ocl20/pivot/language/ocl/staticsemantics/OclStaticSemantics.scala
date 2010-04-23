package tudresden.ocl20.pivot.language.ocl.staticsemantics

import org.eclipse.emf.ecore._
import tudresden.attributegrammar.integration.kiama._
import tudresden.ocl20.pivot.language.ocl.semantics._
import tudresden.ocl20.pivot.pivotmodel._
import tudresden.ocl20.pivot.essentialocl._
import expressions._
import types._
import factory._
import tudresden.ocl20.pivot.model._

import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp._

import tudresden.attributegrammar.integration.kiama.util.CollectionConverterS2J._
import tudresden.attributegrammar.integration.kiama.util.CollectionConverterJ2S._

class OclStaticSemantics(model : IModel, oclLibrary : OclLibrary, resource : OclResource) extends semantics.OclAttributeMaker {
  /*
   * For cached attributes.
   */
  import kiama.attribution.Attribution._
  
  private def yieldError(message : String, element : EObject, cause : Throwable) = {
    resource.addError(message, element)
    throw new OclStaticSemanticsException(message, cause)
  }
  
  private val env : Attributable ==> Environment =
    childAttr {
      case child => {
        // root node -> create a new and empty environment
        case null => new {val model = this.model; val oclLibrary = this.oclLibrary} with Environment(None, model.getRootNamespace, None, None, collection.mutable.Set())
        
        case p@PackageDeclarationCS(packageName, _) => {
          val environment = env(p)
          var currentNS = environment.getNamespace
          var oldNS = currentNS
          pathName2String(packageName).takeWhile {pn =>
            oldNS = currentNS
            currentNS = currentNS.lookupNamespace(pn) 
            if (currentNS == null) {
              resource.addError("Cannot find nested Namespace " + pn + " in " + oldNS.getQualifiedName, packageName)
              false
            } else
              true
          }
          if (currentNS != null)
            environment.nestedEnvironment(currentNS)
          else
            environment.nestedEnvironment(oldNS)
        }
        
        /*
         * @see OperationContextDeclarationCS
         */
        case c@ClassifierContextDeclarationCS(typeName, _) if child != typeName && child.prev != null => {
          env(child.prev)
        }
        case c@ClassifierContextDeclarationCS(typeName, _) => {
          val environment = env(c)
          environment.lookup(pathName2String(typeName)) match {
            case Some(tipe) => {
              val self = environment.factory.createVariable("self", tipe, null)
              environment.nestedEnvironment(self)
            }
            case None => {
              resource.addError("Cannot find type " + typeName + " in Namespace " + environment.getNamespace.getQualifiedName + ".", typeName)
              environment.nestedEnvironment
            }
          }
        }
        
        /* 
         * Check if the child is the operation definition;
         * if yes, simply return the parent environment to avoid cycles.
         */
        case o@OperationContextDeclarationCS(operation, _) if child == operation => {
          env(o)
        }
        /*
         * For efficiency reasons: all pre- and post-conditions as well as body
         * declarations share the same environment.
         */
        case o@OperationContextDeclarationCS(_, _) if child.prev != null => {
          env(child.prev)
        }
        case o@OperationContextDeclarationCS(operation, _) => {
          val environment = env(o)
          try {
	          operation match {
	            case OperationCS(name, parameters, tipeName) => {
	              val opName = pathName2String(name)
	              val typeAndOperation = opName.splitAt(opName.size - 1)
	              environment.lookup(typeAndOperation._1) match {
	                case Some(tipe) => {
	                  val self = environment.factory.createVariable("self", tipe, null)
	                  val parameterTypes = parameters.map(p => computeType(p.getParameterType))
	                  tipe.lookupOperation(typeAndOperation._2.first, parameterTypes) match {
	                    case null => yieldError("Cannot find operation " + operation + " on type " +
	                                              tipe.getQualifiedName + ".", operation, null)
	                    case o : Operation => {
	                      val result = environment.nestedEnvironment(self, o.getType)
	                      if (tipeName != null) {
	                        if (!computeType(tipeName).conformsTo(o.getType)) yieldError(
	                        		"Cannot find operation " + operation + " with return type " +
	                             computeType(tipeName).getQualifiedName +
	                             " on type " + tipe.getQualifiedName + ".", operation, null)
	                      }
	                      parameters.zip(parameterTypes).foreach {p =>
	                        val variable = environment.factory.createVariable(p._1.getParameterName.getSimpleName, p._2, null)
	                        result.addExplicitVariable(variable)
	                      }
                        result
	                    }
	                  }
	                }
	                case None => yieldError("Cannot find type " + typeAndOperation._1 + " in Namespace " + 
	                                          environment.getNamespace + ".", name, null)
	              }
		          }
	          }
          } catch {
            case e : OclStaticSemanticsException => throw new OclStaticSemanticsContextException
          }
        }
        
        case p@PostConditionDeclarationCS(_, _) => {
          val environment = env(p)
          environment.addExplicitVariable(environment.factory.createVariable("result", environment.getContext, null))
          environment
        }
        
        /*
         * For all other elements, simply forward to parent's environment. 
         */
        case unknown => env(unknown)
      }
    }
  
  private val computeOclExpression : Attributable ==> OclExpression =
    attr {
      case i@IntegerLiteralExpCS(integerLiteral) => {
        env(i).factory.createIntegerLiteralExp(integerLiteral)
      }
      case r@RealLiteralExpCS(value) => {
        // TODO: parse Double, but use Float
        env(r).factory.createRealLiteralExp(value.toFloat)
      }
      case s@StringLiteralExpCS(value) => {
        env(s).factory.createStringLiteralExp(value)
      }
  	  case b@BooleanLiteralExpCS(value) => {
  	    env(b).factory.createBooleanLiteralExp(value)
  	  }
     
  	  
  	  case o@OperationCallBinaryExpCS(source, target, isMarkedPre, operationName) => {
  	    val sourceEOcl = computeOclExpression(source)
  	    val targetEOcl = computeOclExpression(target)
  	    try {
  	      env(o).factory.createOperationCallExp(sourceEOcl, operationName, targetEOcl)
  	    } catch {
  	      case e : IllegalArgumentException => yieldError(e.getMessage, o, e)
  	    }
  	  }
     
  	  case c@CollectionLiteralExpCS(collectionType, collectionLiteralParts) => {
  	  	val collectionTypeEOcl = computeType(collectionType).asInstanceOf[CollectionType]
  	    val collectionKind = collectionTypeEOcl.getKind
  	    val collectionLiteralPartsEOcl = collectionLiteralParts.map(computeCollectionLiteralPart(_)).toArray
  	    val result = env(c).factory.createCollectionLiteralExp(collectionKind, collectionLiteralPartsEOcl : _*)
  	    if (!result.getType.conformsTo(collectionTypeEOcl)) {
  	      yieldError("Collection type " + result.getType.getName + 
                      " is not conformant with expected type " + 
                      collectionTypeEOcl.getName + ".", collectionType, null)
  	    }
  	    result
  	  }
     
  	  case u@UnaryOperationCallExpCS(target, operationName) => {
  	    val targetEOcl = computeOclExpression(target)
  	    try { 
  	    	env(u).factory.createOperationCallExp(targetEOcl, operationName)
  	    } catch {
  	    	case e : IllegalArgumentException => yieldError(e.getMessage, u, e)
  	    }
  	  }
     
  	  case l@LogicalNotOperationCallExpCS(target, operationName) => {
  	    val targetEOcl = computeOclExpression(target)
  	    env(l).factory.createOperationCallExp(targetEOcl, operationName)
  	  }
     
  	  case v@VariableOrStaticPropertyOrEnumLiteralExpCS(name) => {
  	    val environment = env(v)
  	    // the name does not contain "::" -> variable or property
  	    if (name.getPathName == null) {
  	      environment.lookupExplicitVariable(name.getSimpleName) match {
  	        case Some(variable) => {
  	          environment.factory.createVariableExp(variable)
  	        }
  	        case None => {
              // can be a property
              try {
	              val selfExp = environment.factory.createVariableExp(environment.getSelf)
	              environment.factory.createPropertyCallExp(selfExp, name.getSimpleName.getSimpleName, null)
              } catch {
  	            case e : EssentialOclFactoryException => yieldError(e.getMessage, name, e)
  	          }
  	        }
  	      }
  	    }
        else {
          yieldError("Cannot find something", name, null)
        }
  	  }
      
  	  case unknown => {
  	    unknown match {
  	      case u : AttributableEObject => resource.addError("unknown element", u)
  	      case _ => //ignore
  	    }
  	    throw new OclStaticSemanticsException("unknown element: " + unknown)
      }
    }
  
  val computeConstraint : Attributable ==> Constraint =
    attr {
      case i@InvariantExpCS(name, oclExpression) => {
  		if (oclExpression == null)
  		  yieldError("Invariant has no expression.", i, null)
        val oclExpressionEOcl = computeOclExpression(oclExpression)
        oclExpressionEOcl.getType match {
          case pt : PrimitiveType => if (pt.getKind != PrimitiveTypeKind.BOOLEAN) 
        	  							yieldError("Invariants must result in boolean type and not " + 
        	  										pt.getKind + ".", oclExpression, null)
          case otherType => yieldError("Invariants must result in boolean type and not " + 
                                         otherType.getName + ".", oclExpression, null)
        }
        val environment = env(i)
        val expression = environment.factory.createExpressionInOcl(
        	oclExpression.toString, oclExpressionEOcl, environment.getSelf, null)
        var constraintName : String = ""
        if (name != null)
          constraintName = name.getSimpleName
        val constraint = environment.factory.createConstraint(
        	constraintName, ConstraintKind.INVARIANT, expression, null, environment.getSelf.getType)
        constraint
  	  }
      
      case d@DefinitionExpCS(name, oclExpression, variable, operation, static) => {
        if (oclExpression == null)
           yieldError("Definition has no expression.", d, null)
        val environment = env(d)
        val oclExpressionEOcl = computeOclExpression(oclExpression)
        
        if (environment.lookupPropertyOnType(variable, static).isDefined)
          yieldError("Property " + variable + " is already defined on " + 
                       environment.getSelf.getType, variable, null)
        
        val expression = environment.factory.createExpressionInOcl(
        	oclExpression.toString, oclExpressionEOcl, environment.getSelf, null)
        
        val property = PivotModelFactory.INSTANCE.createProperty
        property.setName(variable.getSimpleName)
        // TODO: does not work yet for nested collections
        determineFeatureType(oclExpressionEOcl.getType, property)
        property.setStatic(static)
        
        var constraintName : String = ""
        if (name != null)
          constraintName = name.getSimpleName
        val constraint = environment.factory.createConstraint(
        	constraintName, ConstraintKind.DEFINITION, expression, property, environment.getSelf.getType)
        constraint
      }
           
      case p@PrePostOrBodyDeclarationCS(name, oclExpression) => {
        if (oclExpression == null)
          throw new OclStaticSemanticsException("Pre, Post or Body definition is null")
        val environment = env(p)
        val oclExpressionEOcl = computeOclExpression(oclExpression)
        // check whether the return type of the expression is OK
        p match {
          case _ : PreConditionDeclarationCS | _ : PostConditionDeclarationCS => {
            if (!oclExpressionEOcl.getType.conformsTo(oclLibrary.getOclBoolean)) {
              yieldError("Pre- or Postcondition has wrong type " + 
                           oclExpressionEOcl.getType.getQualifiedName +
            							"; expected 'Boolean'.", oclExpression, null)
            }
          }
          case _ : BodyDeclarationCS => {
            if (!oclExpressionEOcl.getType.conformsTo(environment.getContext)) {
            	yieldError("Body definition has wrong type " + 
                          oclExpressionEOcl.getType.getQualifiedName +
            							"; expected " + environment.getContext + ".", oclExpression, null)
            }
          }
        }
        
        val expression = environment.factory.createExpressionInOcl(
        	oclExpression.toString, oclExpressionEOcl, environment.getSelf, null)
        var constraintName : String = ""
        if (name != null)
          constraintName = name.getSimpleName
        val constraint = environment.factory.createConstraint(
        	constraintName, p match {
        	  case p : PreConditionDeclarationCS => ConstraintKind.PRECONDITION
        	  case p : PostConditionDeclarationCS => ConstraintKind.POSTCONDITION
        	  case b : BodyDeclarationCS => ConstraintKind.BODY
        	}, expression, null, environment.getSelf.getType)
        constraint
      }
      
      case unknown => {
  	    unknown match {
  	      case u : AttributableEObject => resource.addError("unknown element", u)
  	      case _ => //ignore
  	    }
  	    throw new OclStaticSemanticsException("unknown element: " + unknown)
      }
    }
  
  val computeConstraints : Attributable ==> List[Constraint] =
    attr {
      case PackageDeclarationCS(_, contextDeclarations) => {
        val result = new collection.mutable.ListBuffer[Constraint]
        contextDeclarations.foreach{ cd =>
          try {
            result ++= computeConstraints(cd)
	  	  } catch {
	  	    case e : OclStaticSemanticsException => // ignore 
	  	  }
        }
        result.toList
  	  }
  	  case c@ClassifierContextDeclarationCS(_, invAndDefs) => {
  	    import collection.mutable.Set
  	    val result = new collection.mutable.ListBuffer[Constraint]
  	    val definitions = new collection.mutable.HashMap[String, Set[List[Type]]] with collection.mutable.MultiMap[String, List[Type]]
  	    invAndDefs.foreach{ iad =>
  	      try {
  	    	val constraint = computeConstraint(iad)
  	    	// test if there are definitions of properties with the same name
  	    	if (constraint.getDefinedFeature != null) {
  	    	  definitions.get(constraint.getDefinedFeature.getName) match {
  	    	    case Some(typeSet) => constraint.getDefinedFeature match {
  	    	      case p : Property => yieldError("Cannot define properties with same name: " + 
                                                	constraint.getDefinedFeature.getName, iad, null)
  	    	      case o : Operation => {
  	    	        typeSet.foreach { types =>
  	    	          if (types == o.getInputParameter.map(_.getType))
  	    	        	yieldError("Cannot define operations with same name: " + 
  	    	        				constraint.getDefinedFeature.getName, iad, null)
  	    	          definitions.add(constraint.getDefinedFeature.getName, types)
  	    	        }
  	    	      }
  	    	    }
  	    	    case None => definitions.add(constraint.getDefinedFeature.getName, Nil)
  	    	  }
  	    	}
  	    	result += constraint
  	      } catch {
  	        case e : OclStaticSemanticsContextException => throw new OclStaticSemanticsException(e)
  	      	case e : OclStaticSemanticsException => // ignore 
  	      }
        }
  	    result.toList
  	  }
      case o@OperationContextDeclarationCS(_, prePostOrBodyDecl) => {
        val result = new collection.mutable.ListBuffer[Constraint]
        // TODO: addWarning for multiple body definitions
        prePostOrBodyDecl.foreach {ppbd =>
          try {
            result += computeConstraint(ppbd)
          } catch {
            case e : OclStaticSemanticsContextException => throw new OclStaticSemanticsException(e)
            case e : OclStaticSemanticsException => // ignore
          }
        }
        result.toList
      }
    }
  
  private val computeCollectionLiteralPart : Attributable ==> CollectionLiteralPart =
	attr {
	  case c@CollectionRangeCS(from, to) => {
  	    val fromEOcl = computeOclExpression(from)
  	    val toEOcl = computeOclExpression(to)
  	    env(c).factory.createCollectionRange(fromEOcl, toEOcl)
  	  }
	  case c@CollectionLiteralPartsOclExpCS(oclExpression) => {
  	    val oclExpressionEOcl = computeOclExpression(oclExpression)
  	    env(c).factory.createCollectionItem(oclExpressionEOcl)
  	}
	  case unknown => {
	    unknown match {
	      case u : AttributableEObject => resource.addError("Unknown collection literal part.", u)
	      case _ => //ignore
	    }
	    throw new OclStaticSemanticsException("Unknown collection literal part: " + unknown)
    }
  }
  
  /**
   * Compute the PivotModel Type for a given TypeCS.
   */
  private val computeType : Attributable ==> Type =
    attr {
      case c@CollectionTypeIdentifierCS(genericType, collectionTypeName) => {
		    val genType = if (genericType != null) computeType(genericType) else null
		    collectionTypeName match {
		      case "Set" => {
		        if(genType != null)
		          oclLibrary.getSetType(genType)
		        else
		          oclLibrary.getOclSet
		      }
		      case "Bag" =>  {
		        if(genType != null)
		          oclLibrary.getBagType(genType)
		        else
		          oclLibrary.getOclBag
		      }
		      case "Sequence" =>  {
		        if(genType != null)
		          oclLibrary.getSequenceType(genType)
		        else
		          oclLibrary.getOclSequence
		      }
		      case "Collection" =>  {
		        if(genType != null)
		          oclLibrary.getCollectionType(genType)
		        else
		          oclLibrary.getOclCollection
		      }
		      case "OrderedSet" =>  {
		        if(genType != null)
		          oclLibrary.getOrderedSetType(genType)
		        else
		          oclLibrary.getOclOrderedSet
		      }
		      case unknown => yieldError("Unknown Collection type " + unknown + ".", c, null)
		   }
    } 
	  case t@TupleTypeCS(variableDeclarationList) => {
	    null
	  }
	  case t@TypePathNameCS(pathName) => {
	     env(t).lookup(pathName2String(pathName)) match {
	       case Some(tipe) => tipe
	       case None => yieldError("Cannot find type " + pathName + " in namespace " + env(t).getNamespace.getQualifiedName, pathName, null)
	     }
	  }
   
    // TODO: for testing purposes only:
	  case p@PathNameCS(_, _) => {
	    env(p).lookup(pathName2String(p)) match {
	       case Some(tipe) => tipe
	       case None => yieldError("Cannot find type " + p + " in namespace " + env(p).getNamespace.getQualifiedName, p, null)
	     }
	  }
   
	  case unknown => {
	    unknown match {
	      case u : AttributableEObject => resource.addError("Unknown type.", u)
	      case _ => //ignore
	    }
	    throw new OclStaticSemanticsException("Unknown type: " + unknown)
    }
  }
  
  /**
   * Returnes a List of String that the given PathNameCS represents.
   */
  def pathName2String(pathName : PathNameCS) : List[String] = {
    val result = new collection.mutable.ListBuffer[String]()
    if (pathName != null) {
      if (pathName.getSimpleName != null)
        result += pathName.getSimpleName.getSimpleName
      result ++= pathName2String(pathName.getPathName)
      }
    result.toList
  }
  
  /**
   * If the given type is a CollectionType, set MuliplicityElement features
   */
  private def determineFeatureType(tipe : Type, feature : Feature) = {
    tipe match {
      case c : CollectionType => {
        feature.setMultiple(true)
        feature.setType(c.getElementType)
        if (c.getKind == CollectionKind.SET) {
          feature.setUnique(true)
        } else if (c.getKind == CollectionKind.SEQUENCE) {
          feature.setOrdered(true)
        } else if (c.getKind == CollectionKind.ORDERED_SET) {
          feature.setUnique(true)
          feature.setOrdered(true)
        }
      }
      case _ => feature.setType(tipe)
    }
  }
  
  @throws(classOf[OclStaticSemanticsException])
  def cs2EssentialOcl(attributable : Attributable) : java.util.List[Constraint] = {
    OclStaticSemanticsTransactions.startStaticSemanticsAnalysis(model, resource)
    val constraints = computeConstraints(attributable)
    // to avoid the conversion of Scala List to Java List multiple times
    val result : java.util.List[Constraint] = constraints
    OclStaticSemanticsTransactions.endStaticSemanticsAnalysis(model, resource, result)
    result
  }
  
  @throws(classOf[OclStaticSemanticsException])
  def computeTypeFor(typeName : Attributable) : Type = {
    computeType(typeName)
  }
}
