/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Control Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getUpdateControlCommand()
 * @model
 * @generated
 */
public interface UpdateControlCommand extends Command {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference.
	 * @see #setElements(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getUpdateControlCommand_Elements()
	 * @model containment="true"
	 * @generated
	 */
	Element getElements();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand#getElements <em>Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elements</em>' containment reference.
	 * @see #getElements()
	 * @generated
	 */
	void setElements(Element value);

} // UpdateControlCommand
