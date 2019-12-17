/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.perf.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.ecl.perf.ConstrainMax;
import org.eclipse.rcptt.ecl.perf.PerfPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrain Max</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl#getCounter <em>Counter</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.perf.impl.ConstrainMaxImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstrainMaxImpl extends CommandImpl implements ConstrainMax {
	/**
	 * The cached value of the '{@link #getCounter() <em>Counter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounter()
	 * @generated
	 * @ordered
	 */
	protected EObject counter;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected String property = PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstrainMaxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PerfPackage.Literals.CONSTRAIN_MAX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getCounter() {
		if (counter != null && counter.eIsProxy()) {
			InternalEObject oldCounter = (InternalEObject)counter;
			counter = eResolveProxy(oldCounter);
			if (counter != oldCounter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PerfPackage.CONSTRAIN_MAX__COUNTER, oldCounter, counter));
			}
		}
		return counter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetCounter() {
		return counter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCounter(EObject newCounter) {
		EObject oldCounter = counter;
		counter = newCounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerfPackage.CONSTRAIN_MAX__COUNTER, oldCounter, counter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(String newProperty) {
		String oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerfPackage.CONSTRAIN_MAX__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerfPackage.CONSTRAIN_MAX__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PerfPackage.CONSTRAIN_MAX__COUNTER:
				if (resolve) return getCounter();
				return basicGetCounter();
			case PerfPackage.CONSTRAIN_MAX__PROPERTY:
				return getProperty();
			case PerfPackage.CONSTRAIN_MAX__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PerfPackage.CONSTRAIN_MAX__COUNTER:
				setCounter((EObject)newValue);
				return;
			case PerfPackage.CONSTRAIN_MAX__PROPERTY:
				setProperty((String)newValue);
				return;
			case PerfPackage.CONSTRAIN_MAX__VALUE:
				setValue((Integer)newValue);
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
			case PerfPackage.CONSTRAIN_MAX__COUNTER:
				setCounter((EObject)null);
				return;
			case PerfPackage.CONSTRAIN_MAX__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case PerfPackage.CONSTRAIN_MAX__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case PerfPackage.CONSTRAIN_MAX__COUNTER:
				return counter != null;
			case PerfPackage.CONSTRAIN_MAX__PROPERTY:
				return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
			case PerfPackage.CONSTRAIN_MAX__VALUE:
				return value != VALUE_EDEFAULT;
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
		result.append(" (property: ");
		result.append(property);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ConstrainMaxImpl
