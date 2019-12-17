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
package org.eclipse.rcptt.core.launching.events;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.launching.events.EventsPackage
 * @generated
 */
public interface EventsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventsFactory eINSTANCE = org.eclipse.rcptt.core.launching.events.impl.EventsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Aut Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Event</em>'.
	 * @generated
	 */
	AutEvent createAutEvent();

	/**
	 * Returns a new object of class '<em>Aut Event Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Event Init</em>'.
	 * @generated
	 */
	AutEventInit createAutEventInit();

	/**
	 * Returns a new object of class '<em>Aut Event Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Event Start</em>'.
	 * @generated
	 */
	AutEventStart createAutEventStart();

	/**
	 * Returns a new object of class '<em>Aut Bundle State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Bundle State</em>'.
	 * @generated
	 */
	AutBundleState createAutBundleState();

	/**
	 * Returns a new object of class '<em>Aut Event Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Event Location</em>'.
	 * @generated
	 */
	AutEventLocation createAutEventLocation();

	/**
	 * Returns a new object of class '<em>Aut Event Ping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Event Ping</em>'.
	 * @generated
	 */
	AutEventPing createAutEventPing();

	/**
	 * Returns a new object of class '<em>Aut Event Ping Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Event Ping Response</em>'.
	 * @generated
	 */
	AutEventPingResponse createAutEventPingResponse();

	/**
	 * Returns a new object of class '<em>Aut Send Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Send Event</em>'.
	 * @generated
	 */
	AutSendEvent createAutSendEvent();

	/**
	 * Returns a new object of class '<em>Aut Reconnect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aut Reconnect</em>'.
	 * @generated
	 */
	AutReconnect createAutReconnect();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventsPackage getEventsPackage();

} //EventsFactory
