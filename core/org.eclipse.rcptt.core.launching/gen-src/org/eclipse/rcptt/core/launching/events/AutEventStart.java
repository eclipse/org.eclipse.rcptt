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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aut Event Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getEclPort <em>Ecl Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getTeslaPort <em>Tesla Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventStart()
 * @model
 * @generated
 */
public interface AutEventStart extends AutEvent {
	/**
	 * Returns the value of the '<em><b>Ecl Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecl Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecl Port</em>' attribute.
	 * @see #setEclPort(int)
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventStart_EclPort()
	 * @model
	 * @generated
	 */
	int getEclPort();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getEclPort <em>Ecl Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecl Port</em>' attribute.
	 * @see #getEclPort()
	 * @generated
	 */
	void setEclPort(int value);

	/**
	 * Returns the value of the '<em><b>Tesla Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tesla Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tesla Port</em>' attribute.
	 * @see #setTeslaPort(int)
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventStart_TeslaPort()
	 * @model
	 * @generated
	 */
	int getTeslaPort();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getTeslaPort <em>Tesla Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tesla Port</em>' attribute.
	 * @see #getTeslaPort()
	 * @generated
	 */
	void setTeslaPort(int value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventStart_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.core.launching.events.AutStartState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.eclipse.rcptt.core.launching.events.AutStartState
	 * @see #setState(AutStartState)
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventStart_State()
	 * @model
	 * @generated
	 */
	AutStartState getState();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.launching.events.AutEventStart#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.eclipse.rcptt.core.launching.events.AutStartState
	 * @see #getState()
	 * @generated
	 */
	void setState(AutStartState value);

} // AutEventStart
