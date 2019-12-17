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

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl#getAdvancedInformation <em>Advanced Information</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponseImpl extends EObjectImpl implements Response {
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ResponseStatus STATUS_EDEFAULT = ResponseStatus.OK;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ResponseStatus status = STATUS_EDEFAULT;

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
	 * The cached value of the '{@link #getAdvancedInformation() <em>Advanced Information</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedInformation()
	 * @generated
	 * @ordered
	 */
	protected AdvancedInformation advancedInformation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(ResponseStatus newStatus) {
		ResponseStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RESPONSE__STATUS, oldStatus, status));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RESPONSE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedInformation getAdvancedInformation() {
		return advancedInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdvancedInformation(
			AdvancedInformation newAdvancedInformation, NotificationChain msgs) {
		AdvancedInformation oldAdvancedInformation = advancedInformation;
		advancedInformation = newAdvancedInformation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RawPackage.RESPONSE__ADVANCED_INFORMATION, oldAdvancedInformation, newAdvancedInformation);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedInformation(
			AdvancedInformation newAdvancedInformation) {
		if (newAdvancedInformation != advancedInformation)
		{
			NotificationChain msgs = null;
			if (advancedInformation != null)
				msgs = ((InternalEObject) advancedInformation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- RawPackage.RESPONSE__ADVANCED_INFORMATION, null, msgs);
			if (newAdvancedInformation != null)
				msgs = ((InternalEObject) newAdvancedInformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- RawPackage.RESPONSE__ADVANCED_INFORMATION, null, msgs);
			msgs = basicSetAdvancedInformation(newAdvancedInformation, msgs);
			if (msgs != null)
				msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RESPONSE__ADVANCED_INFORMATION,
					newAdvancedInformation, newAdvancedInformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
		case RawPackage.RESPONSE__ADVANCED_INFORMATION:
			return basicSetAdvancedInformation(null, msgs);
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
		switch (featureID)
		{
		case RawPackage.RESPONSE__STATUS:
			return getStatus();
		case RawPackage.RESPONSE__MESSAGE:
			return getMessage();
		case RawPackage.RESPONSE__ADVANCED_INFORMATION:
			return getAdvancedInformation();
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
		case RawPackage.RESPONSE__STATUS:
			setStatus((ResponseStatus) newValue);
			return;
		case RawPackage.RESPONSE__MESSAGE:
			setMessage((String) newValue);
			return;
		case RawPackage.RESPONSE__ADVANCED_INFORMATION:
			setAdvancedInformation((AdvancedInformation) newValue);
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
		case RawPackage.RESPONSE__STATUS:
			setStatus(STATUS_EDEFAULT);
			return;
		case RawPackage.RESPONSE__MESSAGE:
			setMessage(MESSAGE_EDEFAULT);
			return;
		case RawPackage.RESPONSE__ADVANCED_INFORMATION:
			setAdvancedInformation((AdvancedInformation) null);
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
		case RawPackage.RESPONSE__STATUS:
			return status != STATUS_EDEFAULT;
		case RawPackage.RESPONSE__MESSAGE:
			return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
		case RawPackage.RESPONSE__ADVANCED_INFORMATION:
			return advancedInformation != null;
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
		result.append(" (status: ");
		result.append(status);
		result.append(", message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //ResponseImpl
