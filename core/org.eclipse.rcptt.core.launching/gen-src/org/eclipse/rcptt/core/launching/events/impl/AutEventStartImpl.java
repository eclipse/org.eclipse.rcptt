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
package org.eclipse.rcptt.core.launching.events.impl;

import org.eclipse.rcptt.core.launching.events.AutEventStart;
import org.eclipse.rcptt.core.launching.events.AutStartState;
import org.eclipse.rcptt.core.launching.events.EventsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aut Event Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl#getEclPort <em>Ecl Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl#getTeslaPort <em>Tesla Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutEventStartImpl extends AutEventImpl implements AutEventStart {
	/**
	 * The default value of the '{@link #getEclPort() <em>Ecl Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEclPort()
	 * @generated
	 * @ordered
	 */
	protected static final int ECL_PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEclPort() <em>Ecl Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEclPort()
	 * @generated
	 * @ordered
	 */
	protected int eclPort = ECL_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTeslaPort() <em>Tesla Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeslaPort()
	 * @generated
	 * @ordered
	 */
	protected static final int TESLA_PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTeslaPort() <em>Tesla Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeslaPort()
	 * @generated
	 * @ordered
	 */
	protected int teslaPort = TESLA_PORT_EDEFAULT;

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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final AutStartState STATE_EDEFAULT = AutStartState.OK;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected AutStartState state = STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutEventStartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.AUT_EVENT_START;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEclPort() {
		return eclPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEclPort(int newEclPort) {
		int oldEclPort = eclPort;
		eclPort = newEclPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.AUT_EVENT_START__ECL_PORT, oldEclPort, eclPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTeslaPort() {
		return teslaPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeslaPort(int newTeslaPort) {
		int oldTeslaPort = teslaPort;
		teslaPort = newTeslaPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.AUT_EVENT_START__TESLA_PORT, oldTeslaPort, teslaPort));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.AUT_EVENT_START__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutStartState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(AutStartState newState) {
		AutStartState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.AUT_EVENT_START__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.AUT_EVENT_START__ECL_PORT:
				return getEclPort();
			case EventsPackage.AUT_EVENT_START__TESLA_PORT:
				return getTeslaPort();
			case EventsPackage.AUT_EVENT_START__MESSAGE:
				return getMessage();
			case EventsPackage.AUT_EVENT_START__STATE:
				return getState();
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
			case EventsPackage.AUT_EVENT_START__ECL_PORT:
				setEclPort((Integer)newValue);
				return;
			case EventsPackage.AUT_EVENT_START__TESLA_PORT:
				setTeslaPort((Integer)newValue);
				return;
			case EventsPackage.AUT_EVENT_START__MESSAGE:
				setMessage((String)newValue);
				return;
			case EventsPackage.AUT_EVENT_START__STATE:
				setState((AutStartState)newValue);
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
			case EventsPackage.AUT_EVENT_START__ECL_PORT:
				setEclPort(ECL_PORT_EDEFAULT);
				return;
			case EventsPackage.AUT_EVENT_START__TESLA_PORT:
				setTeslaPort(TESLA_PORT_EDEFAULT);
				return;
			case EventsPackage.AUT_EVENT_START__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case EventsPackage.AUT_EVENT_START__STATE:
				setState(STATE_EDEFAULT);
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
			case EventsPackage.AUT_EVENT_START__ECL_PORT:
				return eclPort != ECL_PORT_EDEFAULT;
			case EventsPackage.AUT_EVENT_START__TESLA_PORT:
				return teslaPort != TESLA_PORT_EDEFAULT;
			case EventsPackage.AUT_EVENT_START__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case EventsPackage.AUT_EVENT_START__STATE:
				return state != STATE_EDEFAULT;
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
		result.append(" (eclPort: ");
		result.append(eclPort);
		result.append(", teslaPort: ");
		result.append(teslaPort);
		result.append(", message: ");
		result.append(message);
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //AutEventStartImpl
