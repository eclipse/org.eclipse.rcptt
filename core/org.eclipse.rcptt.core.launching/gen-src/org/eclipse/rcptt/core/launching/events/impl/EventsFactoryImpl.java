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
package org.eclipse.rcptt.core.launching.events.impl;

import org.eclipse.rcptt.core.launching.events.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventsFactoryImpl extends EFactoryImpl implements EventsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsFactory init() {
		try {
			EventsFactory theEventsFactory = (EventsFactory)EPackage.Registry.INSTANCE.getEFactory(EventsPackage.eNS_URI);
			if (theEventsFactory != null) {
				return theEventsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EventsPackage.AUT_EVENT: return createAutEvent();
			case EventsPackage.AUT_EVENT_INIT: return createAutEventInit();
			case EventsPackage.AUT_EVENT_START: return createAutEventStart();
			case EventsPackage.AUT_BUNDLE_STATE: return createAutBundleState();
			case EventsPackage.AUT_EVENT_LOCATION: return createAutEventLocation();
			case EventsPackage.AUT_EVENT_PING: return createAutEventPing();
			case EventsPackage.AUT_EVENT_PING_RESPONSE: return createAutEventPingResponse();
			case EventsPackage.AUT_SEND_EVENT: return createAutSendEvent();
			case EventsPackage.AUT_RECONNECT: return createAutReconnect();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EventsPackage.AUT_START_STATE:
				return createAutStartStateFromString(eDataType, initialValue);
			case EventsPackage.PLATFORM:
				return createPlatformFromString(eDataType, initialValue);
			case EventsPackage.CAPABILITY:
				return createCapabilityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EventsPackage.AUT_START_STATE:
				return convertAutStartStateToString(eDataType, instanceValue);
			case EventsPackage.PLATFORM:
				return convertPlatformToString(eDataType, instanceValue);
			case EventsPackage.CAPABILITY:
				return convertCapabilityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutEvent createAutEvent() {
		AutEventImpl autEvent = new AutEventImpl();
		return autEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutEventInit createAutEventInit() {
		AutEventInitImpl autEventInit = new AutEventInitImpl();
		return autEventInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutEventStart createAutEventStart() {
		AutEventStartImpl autEventStart = new AutEventStartImpl();
		return autEventStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutBundleState createAutBundleState() {
		AutBundleStateImpl autBundleState = new AutBundleStateImpl();
		return autBundleState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutEventLocation createAutEventLocation() {
		AutEventLocationImpl autEventLocation = new AutEventLocationImpl();
		return autEventLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutEventPing createAutEventPing() {
		AutEventPingImpl autEventPing = new AutEventPingImpl();
		return autEventPing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutEventPingResponse createAutEventPingResponse() {
		AutEventPingResponseImpl autEventPingResponse = new AutEventPingResponseImpl();
		return autEventPingResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutSendEvent createAutSendEvent() {
		AutSendEventImpl autSendEvent = new AutSendEventImpl();
		return autSendEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutReconnect createAutReconnect() {
		AutReconnectImpl autReconnect = new AutReconnectImpl();
		return autReconnect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutStartState createAutStartStateFromString(EDataType eDataType, String initialValue) {
		AutStartState result = AutStartState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAutStartStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform createPlatformFromString(EDataType eDataType, String initialValue) {
		Platform result = Platform.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPlatformToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Capability createCapabilityFromString(EDataType eDataType, String initialValue) {
		Capability result = Capability.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCapabilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsPackage getEventsPackage() {
		return (EventsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventsPackage getPackage() {
		return EventsPackage.eINSTANCE;
	}

} //EventsFactoryImpl
