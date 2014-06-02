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

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aut Reconnect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutReconnect#getQ7EclPort <em>Q7 Ecl Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutReconnect#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutReconnect()
 * @model
 * @generated
 */
public interface AutReconnect extends Command {
	/**
	 * Returns the value of the '<em><b>Q7 Ecl Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Q7 Ecl Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Q7 Ecl Port</em>' attribute.
	 * @see #setQ7EclPort(int)
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutReconnect_Q7EclPort()
	 * @model
	 * @generated
	 */
	int getQ7EclPort();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.launching.events.AutReconnect#getQ7EclPort <em>Q7 Ecl Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Q7 Ecl Port</em>' attribute.
	 * @see #getQ7EclPort()
	 * @generated
	 */
	void setQ7EclPort(int value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutReconnect_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.launching.events.AutReconnect#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // AutReconnect
