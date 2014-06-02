/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus;
import org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl#getProgress <em>Progress</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl#getStatusKind <em>Status Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionStatusImpl extends EObjectImpl implements ExecutionStatus {
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
	 * The default value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected static final int PROGRESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected int progress = PROGRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatusKind() <em>Status Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusKind()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStatusKind STATUS_KIND_EDEFAULT = ExecutionStatusKind.STARTED;

	/**
	 * The cached value of the '{@link #getStatusKind() <em>Status Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusKind()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStatusKind statusKind = STATUS_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.EXECUTION_STATUS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.EXECUTION_STATUS__MESSAGE, oldMessage,
					message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProgress() {
		return progress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgress(int newProgress) {
		int oldProgress = progress;
		progress = newProgress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.EXECUTION_STATUS__PROGRESS, oldProgress,
					progress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStatusKind getStatusKind() {
		return statusKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusKind(ExecutionStatusKind newStatusKind) {
		ExecutionStatusKind oldStatusKind = statusKind;
		statusKind = newStatusKind == null ? STATUS_KIND_EDEFAULT : newStatusKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.EXECUTION_STATUS__STATUS_KIND,
					oldStatusKind, statusKind));
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
		case RawPackage.EXECUTION_STATUS__MESSAGE:
			return getMessage();
		case RawPackage.EXECUTION_STATUS__PROGRESS:
			return getProgress();
		case RawPackage.EXECUTION_STATUS__STATUS_KIND:
			return getStatusKind();
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
		case RawPackage.EXECUTION_STATUS__MESSAGE:
			setMessage((String) newValue);
			return;
		case RawPackage.EXECUTION_STATUS__PROGRESS:
			setProgress((Integer) newValue);
			return;
		case RawPackage.EXECUTION_STATUS__STATUS_KIND:
			setStatusKind((ExecutionStatusKind) newValue);
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
		case RawPackage.EXECUTION_STATUS__MESSAGE:
			setMessage(MESSAGE_EDEFAULT);
			return;
		case RawPackage.EXECUTION_STATUS__PROGRESS:
			setProgress(PROGRESS_EDEFAULT);
			return;
		case RawPackage.EXECUTION_STATUS__STATUS_KIND:
			setStatusKind(STATUS_KIND_EDEFAULT);
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
		case RawPackage.EXECUTION_STATUS__MESSAGE:
			return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
		case RawPackage.EXECUTION_STATUS__PROGRESS:
			return progress != PROGRESS_EDEFAULT;
		case RawPackage.EXECUTION_STATUS__STATUS_KIND:
			return statusKind != STATUS_KIND_EDEFAULT;
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
		result.append(" (message: ");
		result.append(message);
		result.append(", progress: ");
		result.append(progress);
		result.append(", statusKind: ");
		result.append(statusKind);
		result.append(')');
		return result.toString();
	}

} //ExecutionStatusImpl
