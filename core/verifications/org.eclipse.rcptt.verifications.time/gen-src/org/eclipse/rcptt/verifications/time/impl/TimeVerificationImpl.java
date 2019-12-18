/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.time.impl;

import org.eclipse.rcptt.core.scenario.impl.VerificationImpl;

import org.eclipse.rcptt.verifications.time.TimePackage;
import org.eclipse.rcptt.verifications.time.TimeVerification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl#getMinutes <em>Minutes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl#getSeconds <em>Seconds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl#isIncludeContexts <em>Include Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeVerificationImpl extends VerificationImpl implements TimeVerification {
	/**
	 * The default value of the '{@link #getMinutes() <em>Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinutes()
	 * @generated
	 * @ordered
	 */
	protected static final int MINUTES_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getMinutes() <em>Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinutes()
	 * @generated
	 * @ordered
	 */
	protected int minutes = MINUTES_EDEFAULT;
	/**
	 * The default value of the '{@link #getSeconds() <em>Seconds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeconds()
	 * @generated
	 * @ordered
	 */
	protected static final int SECONDS_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getSeconds() <em>Seconds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeconds()
	 * @generated
	 * @ordered
	 */
	protected int seconds = SECONDS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncludeContexts() <em>Include Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeContexts()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_CONTEXTS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIncludeContexts() <em>Include Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeContexts()
	 * @generated
	 * @ordered
	 */
	protected boolean includeContexts = INCLUDE_CONTEXTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeVerificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.TIME_VERIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinutes(int newMinutes) {
		int oldMinutes = minutes;
		minutes = newMinutes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIME_VERIFICATION__MINUTES, oldMinutes, minutes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeconds(int newSeconds) {
		int oldSeconds = seconds;
		seconds = newSeconds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIME_VERIFICATION__SECONDS, oldSeconds, seconds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeContexts() {
		return includeContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeContexts(boolean newIncludeContexts) {
		boolean oldIncludeContexts = includeContexts;
		includeContexts = newIncludeContexts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIME_VERIFICATION__INCLUDE_CONTEXTS, oldIncludeContexts, includeContexts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.TIME_VERIFICATION__MINUTES:
				return getMinutes();
			case TimePackage.TIME_VERIFICATION__SECONDS:
				return getSeconds();
			case TimePackage.TIME_VERIFICATION__INCLUDE_CONTEXTS:
				return isIncludeContexts();
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
			case TimePackage.TIME_VERIFICATION__MINUTES:
				setMinutes((Integer)newValue);
				return;
			case TimePackage.TIME_VERIFICATION__SECONDS:
				setSeconds((Integer)newValue);
				return;
			case TimePackage.TIME_VERIFICATION__INCLUDE_CONTEXTS:
				setIncludeContexts((Boolean)newValue);
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
			case TimePackage.TIME_VERIFICATION__MINUTES:
				setMinutes(MINUTES_EDEFAULT);
				return;
			case TimePackage.TIME_VERIFICATION__SECONDS:
				setSeconds(SECONDS_EDEFAULT);
				return;
			case TimePackage.TIME_VERIFICATION__INCLUDE_CONTEXTS:
				setIncludeContexts(INCLUDE_CONTEXTS_EDEFAULT);
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
			case TimePackage.TIME_VERIFICATION__MINUTES:
				return minutes != MINUTES_EDEFAULT;
			case TimePackage.TIME_VERIFICATION__SECONDS:
				return seconds != SECONDS_EDEFAULT;
			case TimePackage.TIME_VERIFICATION__INCLUDE_CONTEXTS:
				return includeContexts != INCLUDE_CONTEXTS_EDEFAULT;
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
		result.append(" (minutes: ");
		result.append(minutes);
		result.append(", seconds: ");
		result.append(seconds);
		result.append(", includeContexts: ");
		result.append(includeContexts);
		result.append(')');
		return result.toString();
	}

} //TimeVerificationImpl
