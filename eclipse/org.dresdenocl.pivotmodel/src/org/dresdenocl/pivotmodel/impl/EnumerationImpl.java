/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
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
 *
 * $Id$
 */
package org.dresdenocl.pivotmodel.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.dresdenocl.pivotmodel.Enumeration;
import org.dresdenocl.pivotmodel.EnumerationLiteral;
import org.dresdenocl.pivotmodel.PivotModelFactory;
import org.dresdenocl.pivotmodel.PivotModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Enumeration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.dresdenocl.pivotmodel.impl.EnumerationImpl#getOwnedLiteral <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationImpl extends TypeImpl implements Enumeration {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EnumerationImpl.class);

	/**
	 * The cached value of the '{@link #getOwnedLiteral() <em>Owned Literal</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOwnedLiteral()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> ownedLiteral;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationImpl() {

		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return PivotModelPackage.Literals.ENUMERATION;
	}

	/**
	 * The implementation in this class simply redirects to {
	 * {@link #getOwnedLiteralGen()} which contains the code generated by EMF.
	 * Client may, however, override this method to provide specific behaviour,
	 * e.g., adapt to other model repositories.
	 * 
	 * @generated NOT
	 */
	public List<EnumerationLiteral> getOwnedLiteral() {

		return getOwnedLiteralGen();
	}

	/**
	 * <!-- begin-user-doc -->The code generated for {{@link #getOwnedParameter()}
	 * is redirected to this method. <!-- end-user-doc -->
	 * @generated
	 */
	protected final List<EnumerationLiteral> getOwnedLiteralGen() {

		if (ownedLiteral == null) {
			ownedLiteral =
					new EObjectContainmentWithInverseEList<EnumerationLiteral>(
							EnumerationLiteral.class, this,
							PivotModelPackage.ENUMERATION__OWNED_LITERAL,
							PivotModelPackage.ENUMERATION_LITERAL__ENUMERATION);
		}
		return ownedLiteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Enumeration addLiteral(EnumerationLiteral literal) {

		if (logger.isDebugEnabled()) {
			logger.debug("addLiteral(literal=" + literal + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// use the generated method and not the other one that may be overridden by
		// clients
		getOwnedLiteralGen().add(literal);

		if (logger.isDebugEnabled()) {
			logger.debug("addLiteral() - exit"); //$NON-NLS-1$
		}

		return this;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EnumerationLiteral lookupLiteral(String name) {

		if (logger.isDebugEnabled()) {
			logger.debug("lookupLiteral(name=" + name + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		EnumerationLiteral literal = null;

		for (EnumerationLiteral l : getOwnedLiteral()) {
			if (l.getName().equals(name)) {
				literal = l;
				break;
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("lookupLiteral() - exit - return value=" + literal); //$NON-NLS-1$
		}

		return literal;
	}

	/**
	 * Overridden to additionally clone the {@link #getOwnedLiteral() enumeration
	 * literals} of this <code>Enumeration</code>.
	 * 
	 * @see org.dresdenocl.pivotmodel.impl.TypeImpl#clone()
	 */
	@Override
	public Enumeration clone() {

		return initialize(PivotModelFactory.eINSTANCE.createEnumeration());
	}

	/**
	 * Helper method that initializes a cloned <code>Enumeration</code>
	 * 
	 * @see org.dresdenocl.pivotmodel.impl.TypeImpl#initialize(org.dresdenocl.pivotmodel.Type)
	 */
	protected Enumeration initialize(Enumeration clone) {

		super.initialize(clone);

		// additionally clone the enumeration literals
		for (EnumerationLiteral literal : getOwnedLiteral()) {
			clone.addLiteral(literal.clone());
		}

		return clone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {

		switch (featureID) {
		case PivotModelPackage.ENUMERATION__OWNED_LITERAL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedLiteral())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {

		switch (featureID) {
		case PivotModelPackage.ENUMERATION__OWNED_LITERAL:
			return ((InternalEList<?>) getOwnedLiteral()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
		case PivotModelPackage.ENUMERATION__OWNED_LITERAL:
			return getOwnedLiteral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
		case PivotModelPackage.ENUMERATION__OWNED_LITERAL:
			getOwnedLiteral().clear();
			getOwnedLiteral().addAll(
					(Collection<? extends EnumerationLiteral>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
		case PivotModelPackage.ENUMERATION__OWNED_LITERAL:
			getOwnedLiteral().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
		case PivotModelPackage.ENUMERATION__OWNED_LITERAL:
			return ownedLiteral != null && !ownedLiteral.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // EnumerationImpl
