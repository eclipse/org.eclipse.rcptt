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
package org.eclipse.rcptt.core.launching.events.util;

import org.eclipse.rcptt.core.launching.events.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.launching.events.EventsPackage
 * @generated
 */
public class EventsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsSwitch() {
		if (modelPackage == null) {
			modelPackage = EventsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EventsPackage.AUT_EVENT: {
				AutEvent autEvent = (AutEvent)theEObject;
				T result = caseAutEvent(autEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_EVENT_INIT: {
				AutEventInit autEventInit = (AutEventInit)theEObject;
				T result = caseAutEventInit(autEventInit);
				if (result == null) result = caseAutEvent(autEventInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_EVENT_START: {
				AutEventStart autEventStart = (AutEventStart)theEObject;
				T result = caseAutEventStart(autEventStart);
				if (result == null) result = caseAutEvent(autEventStart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_BUNDLE_STATE: {
				AutBundleState autBundleState = (AutBundleState)theEObject;
				T result = caseAutBundleState(autBundleState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_EVENT_LOCATION: {
				AutEventLocation autEventLocation = (AutEventLocation)theEObject;
				T result = caseAutEventLocation(autEventLocation);
				if (result == null) result = caseAutEvent(autEventLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_EVENT_PING: {
				AutEventPing autEventPing = (AutEventPing)theEObject;
				T result = caseAutEventPing(autEventPing);
				if (result == null) result = caseAutEvent(autEventPing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_EVENT_PING_RESPONSE: {
				AutEventPingResponse autEventPingResponse = (AutEventPingResponse)theEObject;
				T result = caseAutEventPingResponse(autEventPingResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_SEND_EVENT: {
				AutSendEvent autSendEvent = (AutSendEvent)theEObject;
				T result = caseAutSendEvent(autSendEvent);
				if (result == null) result = caseCommand(autSendEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.AUT_RECONNECT: {
				AutReconnect autReconnect = (AutReconnect)theEObject;
				T result = caseAutReconnect(autReconnect);
				if (result == null) result = caseCommand(autReconnect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutEvent(AutEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Event Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Event Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutEventInit(AutEventInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Event Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Event Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutEventStart(AutEventStart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Bundle State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Bundle State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutBundleState(AutBundleState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Event Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Event Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutEventLocation(AutEventLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Event Ping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Event Ping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutEventPing(AutEventPing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Event Ping Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Event Ping Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutEventPingResponse(AutEventPingResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Send Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Send Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutSendEvent(AutSendEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aut Reconnect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aut Reconnect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutReconnect(AutReconnect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EventsSwitch
