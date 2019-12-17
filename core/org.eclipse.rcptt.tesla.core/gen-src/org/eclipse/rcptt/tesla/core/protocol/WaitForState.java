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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait For State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.WaitForState#getState <em>State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getWaitForState()
 * @model
 * @generated
 */
public interface WaitForState extends Command {
	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference.
	 * @see #setState(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getWaitForState_State()
	 * @model containment="true"
	 * @generated
	 */
	Element getState();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.WaitForState#getState <em>State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' containment reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(Element value);

} // WaitForState
