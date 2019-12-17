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
package org.eclipse.rcptt.tesla.core.protocol.raw;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command To Raw Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getRawEvents <em>Raw Events</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getCommandToRawEntry()
 * @model
 * @generated
 */
public interface CommandToRawEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Raw Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Events</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getCommandToRawEntry_RawEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<RawEvent> getRawEvents();

	/**
	 * Returns the value of the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' reference.
	 * @see #setCommand(Command)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getCommandToRawEntry_Command()
	 * @model
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getCommand <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

} // CommandToRawEntry
