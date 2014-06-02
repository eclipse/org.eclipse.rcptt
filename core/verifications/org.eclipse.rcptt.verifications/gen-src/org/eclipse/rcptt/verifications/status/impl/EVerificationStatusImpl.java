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
package org.eclipse.rcptt.verifications.status.impl;

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

import org.eclipse.rcptt.verifications.status.EVerificationStatus;
import org.eclipse.rcptt.verifications.status.StatusPackage;
import org.eclipse.rcptt.verifications.status.VerificationStatusData;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EVerification Status</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EVerificationStatusImpl extends EObjectImpl implements EVerificationStatus {
	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected String resource = RESOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationStatusData> data;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected String pluginId = PLUGIN_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final int SEVERITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected int severity = SEVERITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EVerificationStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatusPackage.Literals.EVERIFICATION_STATUS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(String newResource) {
		String oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.EVERIFICATION_STATUS__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VerificationStatusData> getData() {
		if (data == null) {
			data = new EObjectContainmentEList<VerificationStatusData>(VerificationStatusData.class, this, StatusPackage.EVERIFICATION_STATUS__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.EVERIFICATION_STATUS__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginId(String newPluginId) {
		String oldPluginId = pluginId;
		pluginId = newPluginId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.EVERIFICATION_STATUS__PLUGIN_ID, oldPluginId, pluginId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(int newSeverity) {
		int oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.EVERIFICATION_STATUS__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatusPackage.EVERIFICATION_STATUS__DATA:
				return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatusPackage.EVERIFICATION_STATUS__RESOURCE:
				return getResource();
			case StatusPackage.EVERIFICATION_STATUS__DATA:
				return getData();
			case StatusPackage.EVERIFICATION_STATUS__MESSAGE:
				return getMessage();
			case StatusPackage.EVERIFICATION_STATUS__PLUGIN_ID:
				return getPluginId();
			case StatusPackage.EVERIFICATION_STATUS__SEVERITY:
				return getSeverity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatusPackage.EVERIFICATION_STATUS__RESOURCE:
				setResource((String)newValue);
				return;
			case StatusPackage.EVERIFICATION_STATUS__DATA:
				getData().clear();
				getData().addAll((Collection<? extends VerificationStatusData>)newValue);
				return;
			case StatusPackage.EVERIFICATION_STATUS__MESSAGE:
				setMessage((String)newValue);
				return;
			case StatusPackage.EVERIFICATION_STATUS__PLUGIN_ID:
				setPluginId((String)newValue);
				return;
			case StatusPackage.EVERIFICATION_STATUS__SEVERITY:
				setSeverity((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StatusPackage.EVERIFICATION_STATUS__RESOURCE:
				setResource(RESOURCE_EDEFAULT);
				return;
			case StatusPackage.EVERIFICATION_STATUS__DATA:
				getData().clear();
				return;
			case StatusPackage.EVERIFICATION_STATUS__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case StatusPackage.EVERIFICATION_STATUS__PLUGIN_ID:
				setPluginId(PLUGIN_ID_EDEFAULT);
				return;
			case StatusPackage.EVERIFICATION_STATUS__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StatusPackage.EVERIFICATION_STATUS__RESOURCE:
				return RESOURCE_EDEFAULT == null ? resource != null : !RESOURCE_EDEFAULT.equals(resource);
			case StatusPackage.EVERIFICATION_STATUS__DATA:
				return data != null && !data.isEmpty();
			case StatusPackage.EVERIFICATION_STATUS__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case StatusPackage.EVERIFICATION_STATUS__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
			case StatusPackage.EVERIFICATION_STATUS__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resource: ");
		result.append(resource);
		result.append(", message: ");
		result.append(message);
		result.append(", pluginId: ");
		result.append(pluginId);
		result.append(", severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} // EVerificationStatusImpl
