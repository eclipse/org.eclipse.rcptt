/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.core.impl;

import java.util.Collection;


import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.Proc;
import org.eclipse.rcptt.ecl.core.SessionState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Session State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.SessionStateImpl#getProcs <em>Procs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.SessionStateImpl#getDecls <em>Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SessionStateImpl extends EObjectImpl implements SessionState {
	/**
	 * The cached value of the '{@link #getProcs() <em>Procs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcs()
	 * @generated
	 * @ordered
	 */
	protected EList<Proc> procs;

	/**
	 * The cached value of the '{@link #getDecls() <em>Decls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecls()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> decls;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SessionStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SESSION_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Proc> getProcs() {
		if (procs == null) {
			procs = new EObjectContainmentEList<Proc>(Proc.class, this, CorePackage.SESSION_STATE__PROCS);
		}
		return procs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getDecls() {
		if (decls == null) {
			decls = new EObjectContainmentEList<Declaration>(Declaration.class, this, CorePackage.SESSION_STATE__DECLS);
		}
		return decls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.SESSION_STATE__PROCS:
				return ((InternalEList<?>)getProcs()).basicRemove(otherEnd, msgs);
			case CorePackage.SESSION_STATE__DECLS:
				return ((InternalEList<?>)getDecls()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.SESSION_STATE__PROCS:
				return getProcs();
			case CorePackage.SESSION_STATE__DECLS:
				return getDecls();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.SESSION_STATE__PROCS:
				getProcs().clear();
				getProcs().addAll((Collection<? extends Proc>)newValue);
				return;
			case CorePackage.SESSION_STATE__DECLS:
				getDecls().clear();
				getDecls().addAll((Collection<? extends Declaration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.SESSION_STATE__PROCS:
				getProcs().clear();
				return;
			case CorePackage.SESSION_STATE__DECLS:
				getDecls().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.SESSION_STATE__PROCS:
				return procs != null && !procs.isEmpty();
			case CorePackage.SESSION_STATE__DECLS:
				return decls != null && !decls.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SessionStateImpl
