/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.testing.commands.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.testing.commands.CommandsPackage;
import org.eclipse.rcptt.testing.commands.Eval;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.EvalImpl#getAutId <em>Aut Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.EvalImpl#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvalImpl extends CommandImpl implements Eval {
	/**
	 * The default value of the '{@link #getAutId() <em>Aut Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutId()
	 * @generated
	 * @ordered
	 */
	protected static final String AUT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutId() <em>Aut Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutId()
	 * @generated
	 * @ordered
	 */
	protected String autId = AUT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected String script = SCRIPT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandsPackage.Literals.EVAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutId() {
		return autId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutId(String newAutId) {
		String oldAutId = autId;
		autId = newAutId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.EVAL__AUT_ID, oldAutId, autId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScript(String newScript) {
		String oldScript = script;
		script = newScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.EVAL__SCRIPT, oldScript, script));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommandsPackage.EVAL__AUT_ID:
				return getAutId();
			case CommandsPackage.EVAL__SCRIPT:
				return getScript();
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
			case CommandsPackage.EVAL__AUT_ID:
				setAutId((String)newValue);
				return;
			case CommandsPackage.EVAL__SCRIPT:
				setScript((String)newValue);
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
			case CommandsPackage.EVAL__AUT_ID:
				setAutId(AUT_ID_EDEFAULT);
				return;
			case CommandsPackage.EVAL__SCRIPT:
				setScript(SCRIPT_EDEFAULT);
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
			case CommandsPackage.EVAL__AUT_ID:
				return AUT_ID_EDEFAULT == null ? autId != null : !AUT_ID_EDEFAULT.equals(autId);
			case CommandsPackage.EVAL__SCRIPT:
				return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT.equals(script);
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
		result.append(" (autId: ");
		result.append(autId);
		result.append(", script: ");
		result.append(script);
		result.append(')');
		return result.toString();
	}

} //EvalImpl
