/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.log.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.rcptt.verifications.log.LogEntryPredicate;
import org.eclipse.rcptt.verifications.log.LogPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl#getSeverityMask <em>Severity Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl#getPluginPattern <em>Plugin Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl#getMessagePattern <em>Message Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LogEntryPredicateImpl extends MinimalEObjectImpl.Container implements LogEntryPredicate {
	/**
	 * The default value of the '{@link #getSeverityMask() <em>Severity Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverityMask()
	 * @generated
	 * @ordered
	 */
	protected static final int SEVERITY_MASK_EDEFAULT = 7;

	/**
	 * The cached value of the '{@link #getSeverityMask() <em>Severity Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverityMask()
	 * @generated
	 * @ordered
	 */
	protected int severityMask = SEVERITY_MASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final int CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected int code = CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluginPattern() <em>Plugin Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_PATTERN_EDEFAULT = ".*";

	/**
	 * The cached value of the '{@link #getPluginPattern() <em>Plugin Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginPattern()
	 * @generated
	 * @ordered
	 */
	protected String pluginPattern = PLUGIN_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessagePattern() <em>Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_PATTERN_EDEFAULT = ".*";

	/**
	 * The cached value of the '{@link #getMessagePattern() <em>Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected String messagePattern = MESSAGE_PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogEntryPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.LOG_ENTRY_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSeverityMask() {
		return severityMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeverityMask(int newSeverityMask) {
		int oldSeverityMask = severityMask;
		severityMask = newSeverityMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY_PREDICATE__SEVERITY_MASK, oldSeverityMask, severityMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCode(int newCode) {
		int oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY_PREDICATE__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluginPattern() {
		return pluginPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluginPattern(String newPluginPattern) {
		String oldPluginPattern = pluginPattern;
		pluginPattern = newPluginPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY_PREDICATE__PLUGIN_PATTERN, oldPluginPattern, pluginPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessagePattern() {
		return messagePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessagePattern(String newMessagePattern) {
		String oldMessagePattern = messagePattern;
		messagePattern = newMessagePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ENTRY_PREDICATE__MESSAGE_PATTERN, oldMessagePattern, messagePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.LOG_ENTRY_PREDICATE__SEVERITY_MASK:
				return getSeverityMask();
			case LogPackage.LOG_ENTRY_PREDICATE__CODE:
				return getCode();
			case LogPackage.LOG_ENTRY_PREDICATE__PLUGIN_PATTERN:
				return getPluginPattern();
			case LogPackage.LOG_ENTRY_PREDICATE__MESSAGE_PATTERN:
				return getMessagePattern();
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
			case LogPackage.LOG_ENTRY_PREDICATE__SEVERITY_MASK:
				setSeverityMask((Integer)newValue);
				return;
			case LogPackage.LOG_ENTRY_PREDICATE__CODE:
				setCode((Integer)newValue);
				return;
			case LogPackage.LOG_ENTRY_PREDICATE__PLUGIN_PATTERN:
				setPluginPattern((String)newValue);
				return;
			case LogPackage.LOG_ENTRY_PREDICATE__MESSAGE_PATTERN:
				setMessagePattern((String)newValue);
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
			case LogPackage.LOG_ENTRY_PREDICATE__SEVERITY_MASK:
				setSeverityMask(SEVERITY_MASK_EDEFAULT);
				return;
			case LogPackage.LOG_ENTRY_PREDICATE__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case LogPackage.LOG_ENTRY_PREDICATE__PLUGIN_PATTERN:
				setPluginPattern(PLUGIN_PATTERN_EDEFAULT);
				return;
			case LogPackage.LOG_ENTRY_PREDICATE__MESSAGE_PATTERN:
				setMessagePattern(MESSAGE_PATTERN_EDEFAULT);
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
			case LogPackage.LOG_ENTRY_PREDICATE__SEVERITY_MASK:
				return severityMask != SEVERITY_MASK_EDEFAULT;
			case LogPackage.LOG_ENTRY_PREDICATE__CODE:
				return code != CODE_EDEFAULT;
			case LogPackage.LOG_ENTRY_PREDICATE__PLUGIN_PATTERN:
				return PLUGIN_PATTERN_EDEFAULT == null ? pluginPattern != null : !PLUGIN_PATTERN_EDEFAULT.equals(pluginPattern);
			case LogPackage.LOG_ENTRY_PREDICATE__MESSAGE_PATTERN:
				return MESSAGE_PATTERN_EDEFAULT == null ? messagePattern != null : !MESSAGE_PATTERN_EDEFAULT.equals(messagePattern);
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
		result.append(" (severityMask: ");
		result.append(severityMask);
		result.append(", code: ");
		result.append(code);
		result.append(", pluginPattern: ");
		result.append(pluginPattern);
		result.append(", messagePattern: ");
		result.append(messagePattern);
		result.append(')');
		return result.toString();
	}

} //LogEntryPredicateImpl
