/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.scenario.impl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteImpl#isManuallyOrdered <em>Manually Ordered</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSuiteImpl extends NamedElementImpl implements TestSuite {
	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<TestSuiteItem> items;

	/**
	 * The default value of the '{@link #isManuallyOrdered() <em>Manually Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManuallyOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANUALLY_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isManuallyOrdered() <em>Manually Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManuallyOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean manuallyOrdered = MANUALLY_ORDERED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.TEST_SUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestSuiteItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<TestSuiteItem>(TestSuiteItem.class, this, ScenarioPackage.TEST_SUITE__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isManuallyOrdered() {
		return manuallyOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManuallyOrdered(boolean newManuallyOrdered) {
		boolean oldManuallyOrdered = manuallyOrdered;
		manuallyOrdered = newManuallyOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.TEST_SUITE__MANUALLY_ORDERED, oldManuallyOrdered, manuallyOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.TEST_SUITE__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
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
			case ScenarioPackage.TEST_SUITE__ITEMS:
				return getItems();
			case ScenarioPackage.TEST_SUITE__MANUALLY_ORDERED:
				return isManuallyOrdered();
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
			case ScenarioPackage.TEST_SUITE__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends TestSuiteItem>)newValue);
				return;
			case ScenarioPackage.TEST_SUITE__MANUALLY_ORDERED:
				setManuallyOrdered((Boolean)newValue);
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
			case ScenarioPackage.TEST_SUITE__ITEMS:
				getItems().clear();
				return;
			case ScenarioPackage.TEST_SUITE__MANUALLY_ORDERED:
				setManuallyOrdered(MANUALLY_ORDERED_EDEFAULT);
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
			case ScenarioPackage.TEST_SUITE__ITEMS:
				return items != null && !items.isEmpty();
			case ScenarioPackage.TEST_SUITE__MANUALLY_ORDERED:
				return manuallyOrdered != MANUALLY_ORDERED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (manuallyOrdered: ");
		result.append(manuallyOrdered);
		result.append(')');
		return result.toString();
	}

} //TestSuiteImpl
