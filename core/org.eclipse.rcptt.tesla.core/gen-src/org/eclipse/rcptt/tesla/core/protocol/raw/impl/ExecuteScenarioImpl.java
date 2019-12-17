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
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecuteScenarioImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecuteScenarioImpl#getExecuteMode <em>Execute Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteScenarioImpl extends EObjectImpl implements ExecuteScenario {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecuteMode() <em>Execute Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecuteMode()
	 * @generated
	 * @ordered
	 */
	protected static final ExecuteMode EXECUTE_MODE_EDEFAULT = ExecuteMode.IMMEDIATE;

	/**
	 * The cached value of the '{@link #getExecuteMode() <em>Execute Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecuteMode()
	 * @generated
	 * @ordered
	 */
	protected ExecuteMode executeMode = EXECUTE_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecuteScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.EXECUTE_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.EXECUTE_SCENARIO__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecuteMode getExecuteMode() {
		return executeMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecuteMode(ExecuteMode newExecuteMode) {
		ExecuteMode oldExecuteMode = executeMode;
		executeMode = newExecuteMode == null ? EXECUTE_MODE_EDEFAULT : newExecuteMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.EXECUTE_SCENARIO__EXECUTE_MODE,
					oldExecuteMode, executeMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case RawPackage.EXECUTE_SCENARIO__ID:
			return getId();
		case RawPackage.EXECUTE_SCENARIO__EXECUTE_MODE:
			return getExecuteMode();
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
		switch (featureID)
		{
		case RawPackage.EXECUTE_SCENARIO__ID:
			setId((String) newValue);
			return;
		case RawPackage.EXECUTE_SCENARIO__EXECUTE_MODE:
			setExecuteMode((ExecuteMode) newValue);
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
		switch (featureID)
		{
		case RawPackage.EXECUTE_SCENARIO__ID:
			setId(ID_EDEFAULT);
			return;
		case RawPackage.EXECUTE_SCENARIO__EXECUTE_MODE:
			setExecuteMode(EXECUTE_MODE_EDEFAULT);
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
		switch (featureID)
		{
		case RawPackage.EXECUTE_SCENARIO__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case RawPackage.EXECUTE_SCENARIO__EXECUTE_MODE:
			return executeMode != EXECUTE_MODE_EDEFAULT;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", executeMode: ");
		result.append(executeMode);
		result.append(')');
		return result.toString();
	}

} //ExecuteScenarioImpl
