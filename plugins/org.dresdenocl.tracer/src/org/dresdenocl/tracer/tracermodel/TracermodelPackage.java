/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.dresdenocl.tracer.tracermodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.dresdenocl.tracer.tracermodel.TracermodelFactory
 * @model kind="package"
 * @generated
 */
public interface TracermodelPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tracermodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.tu-dresden.de/ocl20/pivot/2011/tracermodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tracermodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	TracermodelPackage eINSTANCE =
			org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl
					.init();

	/**
	 * The meta object id for the '{@link org.dresdenocl.tracer.tracermodel.impl.TracerItemImpl <em>Tracer Item</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracerItemImpl
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getTracerItem()
	 * @generated
	 */
	int TRACER_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM__RESULT = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM__PARENT = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM__CHILDREN = 3;

	/**
	 * The feature id for the '<em><b>UUID</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM__UUID = 4;

	/**
	 * The feature id for the '<em><b>Model Instance Element</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM__MODEL_INSTANCE_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Tracer Item</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ITEM_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.dresdenocl.tracer.tracermodel.impl.TracerRootImpl <em>Tracer Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracerRootImpl
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getTracerRoot()
	 * @generated
	 */
	int TRACER_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Root Items</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ROOT__ROOT_ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Tracer Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACER_ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>IModel Instance Element</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.dresdenocl.modelinstancetype.types.IModelInstanceElement
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getIModelInstanceElement()
	 * @generated
	 */
	int IMODEL_INSTANCE_ELEMENT = 2;

	/**
	 * The meta object id for the '<em>Ocl Any</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.dresdenocl.essentialocl.standardlibrary.OclAny
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getOclAny()
	 * @generated
	 */
	int OCL_ANY = 3;

	/**
	 * The meta object id for the '<em>UUID</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see java.util.UUID
	 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getUUID()
	 * @generated
	 */
	int UUID = 4;

	/**
	 * Returns the meta object for class '{@link org.dresdenocl.tracer.tracermodel.TracerItem <em>Tracer Item</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tracer Item</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem
	 * @generated
	 */
	EClass getTracerItem();

	/**
	 * Returns the meta object for the reference '{@link org.dresdenocl.tracer.tracermodel.TracerItem#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem#getExpression()
	 * @see #getTracerItem()
	 * @generated
	 */
	EReference getTracerItem_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.dresdenocl.tracer.tracermodel.TracerItem#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem#getResult()
	 * @see #getTracerItem()
	 * @generated
	 */
	EAttribute getTracerItem_Result();

	/**
	 * Returns the meta object for the reference '{@link org.dresdenocl.tracer.tracermodel.TracerItem#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem#getParent()
	 * @see #getTracerItem()
	 * @generated
	 */
	EReference getTracerItem_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.dresdenocl.tracer.tracermodel.TracerItem#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem#getChildren()
	 * @see #getTracerItem()
	 * @generated
	 */
	EReference getTracerItem_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.dresdenocl.tracer.tracermodel.TracerItem#getUUID <em>UUID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UUID</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem#getUUID()
	 * @see #getTracerItem()
	 * @generated
	 */
	EAttribute getTracerItem_UUID();

	/**
	 * Returns the meta object for the attribute '{@link org.dresdenocl.tracer.tracermodel.TracerItem#getModelInstanceElement <em>Model Instance Element</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Instance Element</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerItem#getModelInstanceElement()
	 * @see #getTracerItem()
	 * @generated
	 */
	EAttribute getTracerItem_ModelInstanceElement();

	/**
	 * Returns the meta object for class '{@link org.dresdenocl.tracer.tracermodel.TracerRoot <em>Tracer Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tracer Root</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerRoot
	 * @generated
	 */
	EClass getTracerRoot();

	/**
	 * Returns the meta object for the reference list '{@link org.dresdenocl.tracer.tracermodel.TracerRoot#getRootItems <em>Root Items</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Items</em>'.
	 * @see org.dresdenocl.tracer.tracermodel.TracerRoot#getRootItems()
	 * @see #getTracerRoot()
	 * @generated
	 */
	EReference getTracerRoot_RootItems();

	/**
	 * Returns the meta object for data type '{@link org.dresdenocl.modelinstancetype.types.IModelInstanceElement <em>IModel Instance Element</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for data type '<em>IModel Instance Element</em>'.
	 * @see org.dresdenocl.modelinstancetype.types.IModelInstanceElement
	 * @model instanceClass="org.dresdenocl.modelinstancetype.types.IModelInstanceElement"
	 * @generated
	 */
	EDataType getIModelInstanceElement();

	/**
	 * Returns the meta object for data type '{@link org.dresdenocl.essentialocl.standardlibrary.OclAny <em>Ocl Any</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ocl Any</em>'.
	 * @see org.dresdenocl.essentialocl.standardlibrary.OclAny
	 * @model instanceClass="org.dresdenocl.essentialocl.standardlibrary.OclAny"
	 * @generated
	 */
	EDataType getOclAny();

	/**
	 * Returns the meta object for data type '{@link java.util.UUID <em>UUID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID</em>'.
	 * @see java.util.UUID
	 * @model instanceClass="java.util.UUID"
	 * @generated
	 */
	EDataType getUUID();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TracermodelFactory getTracermodelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '
		 * {@link org.dresdenocl.tracer.tracermodel.impl.TracerItemImpl
		 * <em>Tracer Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracerItemImpl
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getTracerItem()
		 * @generated
		 */
		EClass TRACER_ITEM = eINSTANCE.getTracerItem();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACER_ITEM__EXPRESSION = eINSTANCE.getTracerItem_Expression();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACER_ITEM__RESULT = eINSTANCE.getTracerItem_Result();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACER_ITEM__PARENT = eINSTANCE.getTracerItem_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACER_ITEM__CHILDREN = eINSTANCE.getTracerItem_Children();

		/**
		 * The meta object literal for the '<em><b>UUID</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACER_ITEM__UUID = eINSTANCE.getTracerItem_UUID();

		/**
		 * The meta object literal for the '<em><b>Model Instance Element</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACER_ITEM__MODEL_INSTANCE_ELEMENT = eINSTANCE
				.getTracerItem_ModelInstanceElement();

		/**
		 * The meta object literal for the '
		 * {@link org.dresdenocl.tracer.tracermodel.impl.TracerRootImpl
		 * <em>Tracer Root</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracerRootImpl
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getTracerRoot()
		 * @generated
		 */
		EClass TRACER_ROOT = eINSTANCE.getTracerRoot();

		/**
		 * The meta object literal for the '<em><b>Root Items</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACER_ROOT__ROOT_ITEMS = eINSTANCE.getTracerRoot_RootItems();

		/**
		 * The meta object literal for the '<em>IModel Instance Element</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.dresdenocl.modelinstancetype.types.IModelInstanceElement
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getIModelInstanceElement()
		 * @generated
		 */
		EDataType IMODEL_INSTANCE_ELEMENT = eINSTANCE.getIModelInstanceElement();

		/**
		 * The meta object literal for the '<em>Ocl Any</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.dresdenocl.essentialocl.standardlibrary.OclAny
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getOclAny()
		 * @generated
		 */
		EDataType OCL_ANY = eINSTANCE.getOclAny();

		/**
		 * The meta object literal for the '<em>UUID</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.util.UUID
		 * @see org.dresdenocl.tracer.tracermodel.impl.TracermodelPackageImpl#getUUID()
		 * @generated
		 */
		EDataType UUID = eINSTANCE.getUUID();

	}

} // TracermodelPackage
