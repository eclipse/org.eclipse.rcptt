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
package org.eclipse.rcptt.core.launching.events;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.rcptt.ecl.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.launching.events.EventsFactory
 * @model kind="package"
 * @generated
 */
public interface EventsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "events";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/core/launching.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.core.launching";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventsPackage eINSTANCE = org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventImpl <em>Aut Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEvent()
	 * @generated
	 */
	int AUT_EVENT = 0;

	/**
	 * The number of structural features of the '<em>Aut Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventInitImpl <em>Aut Event Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventInitImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventInit()
	 * @generated
	 */
	int AUT_EVENT_INIT = 1;

	/**
	 * The feature id for the '<em><b>Bundle State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_INIT__BUNDLE_STATE = AUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aut Event Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_INIT_FEATURE_COUNT = AUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl <em>Aut Event Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventStart()
	 * @generated
	 */
	int AUT_EVENT_START = 2;

	/**
	 * The feature id for the '<em><b>Ecl Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_START__ECL_PORT = AUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tesla Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_START__TESLA_PORT = AUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_START__MESSAGE = AUT_EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_START__STATE = AUT_EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Aut Event Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_START_FEATURE_COUNT = AUT_EVENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutBundleStateImpl <em>Aut Bundle State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutBundleStateImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutBundleState()
	 * @generated
	 */
	int AUT_BUNDLE_STATE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_BUNDLE_STATE__ID = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_BUNDLE_STATE__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_BUNDLE_STATE__STATE = 2;

	/**
	 * The number of structural features of the '<em>Aut Bundle State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_BUNDLE_STATE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventLocationImpl <em>Aut Event Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventLocationImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventLocation()
	 * @generated
	 */
	int AUT_EVENT_LOCATION = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_LOCATION__LOCATION = AUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aut Event Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_LOCATION_FEATURE_COUNT = AUT_EVENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventPingImpl <em>Aut Event Ping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventPingImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventPing()
	 * @generated
	 */
	int AUT_EVENT_PING = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_PING__LOCATION = AUT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aut Event Ping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_PING_FEATURE_COUNT = AUT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventPingResponseImpl <em>Aut Event Ping Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventPingResponseImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventPingResponse()
	 * @generated
	 */
	int AUT_EVENT_PING_RESPONSE = 6;

	/**
	 * The number of structural features of the '<em>Aut Event Ping Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_EVENT_PING_RESPONSE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutSendEventImpl <em>Aut Send Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutSendEventImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutSendEvent()
	 * @generated
	 */
	int AUT_SEND_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_SEND_EVENT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_SEND_EVENT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_SEND_EVENT__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_SEND_EVENT__EVENT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aut Send Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_SEND_EVENT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutReconnectImpl <em>Aut Reconnect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.impl.AutReconnectImpl
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutReconnect()
	 * @generated
	 */
	int AUT_RECONNECT = 8;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_RECONNECT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_RECONNECT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Q7 Ecl Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_RECONNECT__Q7_ECL_PORT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_RECONNECT__ID = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aut Reconnect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUT_RECONNECT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.launching.events.AutStartState <em>Aut Start State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.launching.events.AutStartState
	 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutStartState()
	 * @generated
	 */
	int AUT_START_STATE = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutEvent <em>Aut Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Event</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEvent
	 * @generated
	 */
	EClass getAutEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutEventInit <em>Aut Event Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Event Init</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventInit
	 * @generated
	 */
	EClass getAutEventInit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.launching.events.AutEventInit#getBundleState <em>Bundle State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundle State</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventInit#getBundleState()
	 * @see #getAutEventInit()
	 * @generated
	 */
	EReference getAutEventInit_BundleState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutEventStart <em>Aut Event Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Event Start</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventStart
	 * @generated
	 */
	EClass getAutEventStart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getEclPort <em>Ecl Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ecl Port</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventStart#getEclPort()
	 * @see #getAutEventStart()
	 * @generated
	 */
	EAttribute getAutEventStart_EclPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getTeslaPort <em>Tesla Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tesla Port</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventStart#getTeslaPort()
	 * @see #getAutEventStart()
	 * @generated
	 */
	EAttribute getAutEventStart_TeslaPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventStart#getMessage()
	 * @see #getAutEventStart()
	 * @generated
	 */
	EAttribute getAutEventStart_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventStart#getState()
	 * @see #getAutEventStart()
	 * @generated
	 */
	EAttribute getAutEventStart_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutBundleState <em>Aut Bundle State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Bundle State</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutBundleState
	 * @generated
	 */
	EClass getAutBundleState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutBundleState#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutBundleState#getId()
	 * @see #getAutBundleState()
	 * @generated
	 */
	EAttribute getAutBundleState_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutBundleState#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutBundleState#getLocation()
	 * @see #getAutBundleState()
	 * @generated
	 */
	EAttribute getAutBundleState_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutBundleState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutBundleState#getState()
	 * @see #getAutBundleState()
	 * @generated
	 */
	EAttribute getAutBundleState_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutEventLocation <em>Aut Event Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Event Location</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventLocation
	 * @generated
	 */
	EClass getAutEventLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutEventLocation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventLocation#getLocation()
	 * @see #getAutEventLocation()
	 * @generated
	 */
	EAttribute getAutEventLocation_Location();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutEventPing <em>Aut Event Ping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Event Ping</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventPing
	 * @generated
	 */
	EClass getAutEventPing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutEventPing#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventPing#getLocation()
	 * @see #getAutEventPing()
	 * @generated
	 */
	EAttribute getAutEventPing_Location();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutEventPingResponse <em>Aut Event Ping Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Event Ping Response</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutEventPingResponse
	 * @generated
	 */
	EClass getAutEventPingResponse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutSendEvent <em>Aut Send Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Send Event</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutSendEvent
	 * @generated
	 */
	EClass getAutSendEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutSendEvent#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutSendEvent#getId()
	 * @see #getAutSendEvent()
	 * @generated
	 */
	EAttribute getAutSendEvent_Id();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.launching.events.AutSendEvent#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutSendEvent#getEvent()
	 * @see #getAutSendEvent()
	 * @generated
	 */
	EReference getAutSendEvent_Event();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.launching.events.AutReconnect <em>Aut Reconnect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aut Reconnect</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutReconnect
	 * @generated
	 */
	EClass getAutReconnect();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutReconnect#getQ7EclPort <em>Q7 Ecl Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Q7 Ecl Port</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutReconnect#getQ7EclPort()
	 * @see #getAutReconnect()
	 * @generated
	 */
	EAttribute getAutReconnect_Q7EclPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.launching.events.AutReconnect#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutReconnect#getId()
	 * @see #getAutReconnect()
	 * @generated
	 */
	EAttribute getAutReconnect_Id();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.core.launching.events.AutStartState <em>Aut Start State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aut Start State</em>'.
	 * @see org.eclipse.rcptt.core.launching.events.AutStartState
	 * @generated
	 */
	EEnum getAutStartState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventsFactory getEventsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventImpl <em>Aut Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEvent()
		 * @generated
		 */
		EClass AUT_EVENT = eINSTANCE.getAutEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventInitImpl <em>Aut Event Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventInitImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventInit()
		 * @generated
		 */
		EClass AUT_EVENT_INIT = eINSTANCE.getAutEventInit();

		/**
		 * The meta object literal for the '<em><b>Bundle State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUT_EVENT_INIT__BUNDLE_STATE = eINSTANCE.getAutEventInit_BundleState();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl <em>Aut Event Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventStartImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventStart()
		 * @generated
		 */
		EClass AUT_EVENT_START = eINSTANCE.getAutEventStart();

		/**
		 * The meta object literal for the '<em><b>Ecl Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_EVENT_START__ECL_PORT = eINSTANCE.getAutEventStart_EclPort();

		/**
		 * The meta object literal for the '<em><b>Tesla Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_EVENT_START__TESLA_PORT = eINSTANCE.getAutEventStart_TeslaPort();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_EVENT_START__MESSAGE = eINSTANCE.getAutEventStart_Message();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_EVENT_START__STATE = eINSTANCE.getAutEventStart_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutBundleStateImpl <em>Aut Bundle State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutBundleStateImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutBundleState()
		 * @generated
		 */
		EClass AUT_BUNDLE_STATE = eINSTANCE.getAutBundleState();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_BUNDLE_STATE__ID = eINSTANCE.getAutBundleState_Id();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_BUNDLE_STATE__LOCATION = eINSTANCE.getAutBundleState_Location();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_BUNDLE_STATE__STATE = eINSTANCE.getAutBundleState_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventLocationImpl <em>Aut Event Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventLocationImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventLocation()
		 * @generated
		 */
		EClass AUT_EVENT_LOCATION = eINSTANCE.getAutEventLocation();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_EVENT_LOCATION__LOCATION = eINSTANCE.getAutEventLocation_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventPingImpl <em>Aut Event Ping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventPingImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventPing()
		 * @generated
		 */
		EClass AUT_EVENT_PING = eINSTANCE.getAutEventPing();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_EVENT_PING__LOCATION = eINSTANCE.getAutEventPing_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutEventPingResponseImpl <em>Aut Event Ping Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutEventPingResponseImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutEventPingResponse()
		 * @generated
		 */
		EClass AUT_EVENT_PING_RESPONSE = eINSTANCE.getAutEventPingResponse();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutSendEventImpl <em>Aut Send Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutSendEventImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutSendEvent()
		 * @generated
		 */
		EClass AUT_SEND_EVENT = eINSTANCE.getAutSendEvent();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_SEND_EVENT__ID = eINSTANCE.getAutSendEvent_Id();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUT_SEND_EVENT__EVENT = eINSTANCE.getAutSendEvent_Event();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.impl.AutReconnectImpl <em>Aut Reconnect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.impl.AutReconnectImpl
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutReconnect()
		 * @generated
		 */
		EClass AUT_RECONNECT = eINSTANCE.getAutReconnect();

		/**
		 * The meta object literal for the '<em><b>Q7 Ecl Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_RECONNECT__Q7_ECL_PORT = eINSTANCE.getAutReconnect_Q7EclPort();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUT_RECONNECT__ID = eINSTANCE.getAutReconnect_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.launching.events.AutStartState <em>Aut Start State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.launching.events.AutStartState
		 * @see org.eclipse.rcptt.core.launching.events.impl.EventsPackageImpl#getAutStartState()
		 * @generated
		 */
		EEnum AUT_START_STATE = eINSTANCE.getAutStartState();

	}

} //EventsPackage
