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
package org.eclipse.rcptt.core.launching.events.impl;

import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.core.launching.events.AutEventInit;
import org.eclipse.rcptt.core.launching.events.EventsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aut Event Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutEventInitImpl#getBundleState <em>Bundle State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutEventInitImpl extends AutEventImpl implements AutEventInit {
	/**
	 * The cached value of the '{@link #getBundleState() <em>Bundle State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleState()
	 * @generated
	 * @ordered
	 */
	protected EList<AutBundleState> bundleState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutEventInitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.AUT_EVENT_INIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AutBundleState> getBundleState() {
		if (bundleState == null) {
			bundleState = new EObjectContainmentEList<AutBundleState>(AutBundleState.class, this, EventsPackage.AUT_EVENT_INIT__BUNDLE_STATE);
		}
		return bundleState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.AUT_EVENT_INIT__BUNDLE_STATE:
				return ((InternalEList<?>)getBundleState()).basicRemove(otherEnd, msgs);
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
			case EventsPackage.AUT_EVENT_INIT__BUNDLE_STATE:
				return getBundleState();
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
			case EventsPackage.AUT_EVENT_INIT__BUNDLE_STATE:
				getBundleState().clear();
				getBundleState().addAll((Collection<? extends AutBundleState>)newValue);
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
			case EventsPackage.AUT_EVENT_INIT__BUNDLE_STATE:
				getBundleState().clear();
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
			case EventsPackage.AUT_EVENT_INIT__BUNDLE_STATE:
				return bundleState != null && !bundleState.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AutEventInitImpl
