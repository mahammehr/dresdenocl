/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Ronny Brandt (Ronny_Brandt@web.de).                    *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package tudresden.ocl20.pivot.standardlibrary.java.internal.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBag;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclUnsortedCollection;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceCollection;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceFactory;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.base.BasisJavaModelInstanceFactory;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.base.PrimitiveAndCollectionTypeConstants;

/**
 * <p>
 * Provides an implementation of {@link OclUnsortedCollection} in Java.
 * </p>
 * 
 * @author Ronny Brandt
 * @author Michael Thiele
 */
@SuppressWarnings("unchecked")
public abstract class JavaOclUnsortedCollection<T extends OclRoot> extends
		JavaOclCollection<T> implements OclUnsortedCollection<T> {

	public JavaOclUnsortedCollection(
			IModelInstanceCollection<IModelInstanceElement> adaptedCollection) {

		super(adaptedCollection);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclUnsortedCollection
	 * #union(tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBag)
	 */
	public OclBag<T> union(OclBag<T> aBag) {

		OclBag<T> result;

		/* Check if this collection is undefined. */
		if (this.isOclUndefined().isTrue()) {
			result = new JavaOclBag<T>(null);
			result.setUndefinedreason(getUndefinedreason());
		}

		/* Else check if the given bag is undefined. */
		else if (aBag.isOclUndefined().isTrue()) {
			result = aBag;
		}

		/* Else compute the result. */
		else {
			Collection<IModelInstanceElement> resultList =
					new ArrayList<IModelInstanceElement>();

			resultList.addAll(this.imiCollection.getCollection());
			resultList.addAll(aBag.getAdaptedCollection().getCollection());

			IModelInstanceCollection<IModelInstanceElement> resultIMICollection =
					BasisJavaModelInstanceFactory.createModelInstanceCollection(
							resultList, PrimitiveAndCollectionTypeConstants.MODEL_TYPE_BAG);

			result = new JavaOclBag<T>(resultIMICollection);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclUnsortedCollection
	 * #intersection(tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet)
	 */
	public OclSet<T> intersection(OclSet<T> aSet) {

		OclSet<T> result;

		/* Check if this collection is undefined. */
		if (isOclUndefined().isTrue()) {
			result = new JavaOclSet<T>(null);
			result.setUndefinedreason(getUndefinedreason());
		}

		/* Else check if the given set is undefined. */
		else if (aSet.isOclUndefined().isTrue()) {
			result = aSet;
		}

		/* Else compute the result. */
		else {
			List<IModelInstanceElement> thisSetAsList;
			List<IModelInstanceElement> resultList;

			thisSetAsList =
					new ArrayList<IModelInstanceElement>(this.imiCollection
							.getCollection());

			resultList = new ArrayList<IModelInstanceElement>();

			for (IModelInstanceElement anElement : aSet.getAdaptedCollection()
					.getCollection()) {
				if (thisSetAsList.contains(anElement)
						&& !resultList.contains(anElement)) {
					resultList.add(anElement);
				}
			}

			IModelInstanceCollection<IModelInstanceElement> resultIMICollection =
					BasisJavaModelInstanceFactory.createModelInstanceCollection(
							resultList, PrimitiveAndCollectionTypeConstants.MODEL_TYPE_SET);

			result = new JavaOclSet<T>(resultIMICollection);
		}

		return result;
	}
}
