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
package org.eclipse.rcptt.ecl.core.impl;


import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.EclException;
import org.eclipse.rcptt.ecl.core.ProcessStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessStatusImpl extends EObjectImpl implements ProcessStatus {
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
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final int SEVERITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected int severity = SEVERITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected EclException exception;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessStatus> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.PROCESS_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluginId(String newPluginId) {
		String oldPluginId = pluginId;
		pluginId = newPluginId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_STATUS__PLUGIN_ID, oldPluginId, pluginId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_STATUS__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_STATUS__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeverity(int newSeverity) {
		int oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_STATUS__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EclException getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetException(EclException newException, NotificationChain msgs) {
		EclException oldException = exception;
		exception = newException;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_STATUS__EXCEPTION, oldException, newException);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setException(EclException newException) {
		if (newException != exception) {
			NotificationChain msgs = null;
			if (exception != null)
				msgs = ((InternalEObject)exception).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PROCESS_STATUS__EXCEPTION, null, msgs);
			if (newException != null)
				msgs = ((InternalEObject)newException).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PROCESS_STATUS__EXCEPTION, null, msgs);
			msgs = basicSetException(newException, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PROCESS_STATUS__EXCEPTION, newException, newException));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessStatus> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<ProcessStatus>(ProcessStatus.class, this, CorePackage.PROCESS_STATUS__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.PROCESS_STATUS__EXCEPTION:
				return basicSetException(null, msgs);
			case CorePackage.PROCESS_STATUS__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case CorePackage.PROCESS_STATUS__PLUGIN_ID:
				return getPluginId();
			case CorePackage.PROCESS_STATUS__CODE:
				return getCode();
			case CorePackage.PROCESS_STATUS__MESSAGE:
				return getMessage();
			case CorePackage.PROCESS_STATUS__SEVERITY:
				return getSeverity();
			case CorePackage.PROCESS_STATUS__EXCEPTION:
				return getException();
			case CorePackage.PROCESS_STATUS__CHILDREN:
				return getChildren();
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
			case CorePackage.PROCESS_STATUS__PLUGIN_ID:
				setPluginId((String)newValue);
				return;
			case CorePackage.PROCESS_STATUS__CODE:
				setCode((Integer)newValue);
				return;
			case CorePackage.PROCESS_STATUS__MESSAGE:
				setMessage((String)newValue);
				return;
			case CorePackage.PROCESS_STATUS__SEVERITY:
				setSeverity((Integer)newValue);
				return;
			case CorePackage.PROCESS_STATUS__EXCEPTION:
				setException((EclException)newValue);
				return;
			case CorePackage.PROCESS_STATUS__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ProcessStatus>)newValue);
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
			case CorePackage.PROCESS_STATUS__PLUGIN_ID:
				setPluginId(PLUGIN_ID_EDEFAULT);
				return;
			case CorePackage.PROCESS_STATUS__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case CorePackage.PROCESS_STATUS__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case CorePackage.PROCESS_STATUS__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case CorePackage.PROCESS_STATUS__EXCEPTION:
				setException((EclException)null);
				return;
			case CorePackage.PROCESS_STATUS__CHILDREN:
				getChildren().clear();
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
			case CorePackage.PROCESS_STATUS__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
			case CorePackage.PROCESS_STATUS__CODE:
				return code != CODE_EDEFAULT;
			case CorePackage.PROCESS_STATUS__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case CorePackage.PROCESS_STATUS__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case CorePackage.PROCESS_STATUS__EXCEPTION:
				return exception != null;
			case CorePackage.PROCESS_STATUS__CHILDREN:
				return children != null && !children.isEmpty();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (pluginId: ");
		result.append(pluginId);
		result.append(", code: ");
		result.append(code);
		result.append(", message: ");
		result.append(message);
		result.append(", severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} //ProcessStatusImpl
