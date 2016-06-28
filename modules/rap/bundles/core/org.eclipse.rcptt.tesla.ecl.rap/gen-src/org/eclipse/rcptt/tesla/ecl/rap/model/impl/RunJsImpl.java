/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage;
import org.eclipse.rcptt.tesla.ecl.rap.model.RunJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.TeslaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Js</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl#getJsCode <em>Js Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RunJsImpl extends CommandImpl implements RunJs {
	/**
	 * The default value of the '{@link #getJsCode() <em>Js Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsCode()
	 * @generated
	 * @ordered
	 */
	protected static final String JS_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJsCode() <em>Js Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsCode()
	 * @generated
	 * @ordered
	 */
	protected String jsCode = JS_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunJsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapTeslaPackage.Literals.RUN_JS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJsCode() {
		return jsCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJsCode(String newJsCode) {
		String oldJsCode = jsCode;
		jsCode = newJsCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapTeslaPackage.RUN_JS__JS_CODE, oldJsCode, jsCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapTeslaPackage.RUN_JS__JS_CODE:
				return getJsCode();
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
			case RapTeslaPackage.RUN_JS__JS_CODE:
				setJsCode((String)newValue);
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
			case RapTeslaPackage.RUN_JS__JS_CODE:
				setJsCode(JS_CODE_EDEFAULT);
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
			case RapTeslaPackage.RUN_JS__JS_CODE:
				return JS_CODE_EDEFAULT == null ? jsCode != null : !JS_CODE_EDEFAULT.equals(jsCode);
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
		result.append(" (jsCode: ");
		result.append(jsCode);
		result.append(')');
		return result.toString();
	}

} //RunJsImpl
