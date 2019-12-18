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
package org.eclipse.rcptt.core.launching.events.impl;

import org.eclipse.rcptt.core.launching.events.AutReconnect;
import org.eclipse.rcptt.core.launching.events.EventsPackage;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aut Reconnect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutReconnectImpl#getQ7EclPort <em>Q7 Ecl Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutReconnectImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AutReconnectImpl extends CommandImpl implements AutReconnect {
	/**
	 * The default value of the '{@link #getQ7EclPort() <em>Q7 Ecl Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQ7EclPort()
	 * @generated
	 * @ordered
	 */
	protected static final int Q7_ECL_PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQ7EclPort() <em>Q7 Ecl Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQ7EclPort()
	 * @generated
	 * @ordered
	 */
	protected int q7EclPort = Q7_ECL_PORT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutReconnectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.AUT_RECONNECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQ7EclPort() {
		return q7EclPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQ7EclPort(int newQ7EclPort) {
		int oldQ7EclPort = q7EclPort;
		q7EclPort = newQ7EclPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.AUT_RECONNECT__Q7_ECL_PORT, oldQ7EclPort, q7EclPort));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.AUT_RECONNECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.AUT_RECONNECT__Q7_ECL_PORT:
				return getQ7EclPort();
			case EventsPackage.AUT_RECONNECT__ID:
				return getId();
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
			case EventsPackage.AUT_RECONNECT__Q7_ECL_PORT:
				setQ7EclPort((Integer)newValue);
				return;
			case EventsPackage.AUT_RECONNECT__ID:
				setId((String)newValue);
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
			case EventsPackage.AUT_RECONNECT__Q7_ECL_PORT:
				setQ7EclPort(Q7_ECL_PORT_EDEFAULT);
				return;
			case EventsPackage.AUT_RECONNECT__ID:
				setId(ID_EDEFAULT);
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
			case EventsPackage.AUT_RECONNECT__Q7_ECL_PORT:
				return q7EclPort != Q7_ECL_PORT_EDEFAULT;
			case EventsPackage.AUT_RECONNECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (q7EclPort: ");
		result.append(q7EclPort);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //AutReconnectImpl
