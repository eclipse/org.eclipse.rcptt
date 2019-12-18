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
package org.eclipse.rcptt.ecl.platform.objects.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.rcptt.ecl.platform.objects.LogMessage;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl#getDateText <em>Date Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogMessageImpl extends EObjectImpl implements LogMessage {
	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final String SEVERITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected String severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateText() <em>Date Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateText()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateText() <em>Date Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateText()
	 * @generated
	 * @ordered
	 */
	protected String dateText = DATE_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected String pluginId = PLUGIN_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectsPackage.Literals.LOG_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(String newSeverity) {
		String oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.LOG_MESSAGE__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.LOG_MESSAGE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateText() {
		return dateText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateText(String newDateText) {
		String oldDateText = dateText;
		dateText = newDateText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.LOG_MESSAGE__DATE_TEXT, oldDateText, dateText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginId(String newPluginId) {
		String oldPluginId = pluginId;
		pluginId = newPluginId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.LOG_MESSAGE__PLUGIN_ID, oldPluginId, pluginId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectsPackage.LOG_MESSAGE__SEVERITY:
				return getSeverity();
			case ObjectsPackage.LOG_MESSAGE__MESSAGE:
				return getMessage();
			case ObjectsPackage.LOG_MESSAGE__DATE_TEXT:
				return getDateText();
			case ObjectsPackage.LOG_MESSAGE__PLUGIN_ID:
				return getPluginId();
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
			case ObjectsPackage.LOG_MESSAGE__SEVERITY:
				setSeverity((String)newValue);
				return;
			case ObjectsPackage.LOG_MESSAGE__MESSAGE:
				setMessage((String)newValue);
				return;
			case ObjectsPackage.LOG_MESSAGE__DATE_TEXT:
				setDateText((String)newValue);
				return;
			case ObjectsPackage.LOG_MESSAGE__PLUGIN_ID:
				setPluginId((String)newValue);
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
			case ObjectsPackage.LOG_MESSAGE__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case ObjectsPackage.LOG_MESSAGE__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ObjectsPackage.LOG_MESSAGE__DATE_TEXT:
				setDateText(DATE_TEXT_EDEFAULT);
				return;
			case ObjectsPackage.LOG_MESSAGE__PLUGIN_ID:
				setPluginId(PLUGIN_ID_EDEFAULT);
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
			case ObjectsPackage.LOG_MESSAGE__SEVERITY:
				return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals(severity);
			case ObjectsPackage.LOG_MESSAGE__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ObjectsPackage.LOG_MESSAGE__DATE_TEXT:
				return DATE_TEXT_EDEFAULT == null ? dateText != null : !DATE_TEXT_EDEFAULT.equals(dateText);
			case ObjectsPackage.LOG_MESSAGE__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
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
		result.append(" (severity: ");
		result.append(severity);
		result.append(", message: ");
		result.append(message);
		result.append(", dateText: ");
		result.append(dateText);
		result.append(", pluginId: ");
		result.append(pluginId);
		result.append(')');
		return result.toString();
	}

} //LogMessageImpl
