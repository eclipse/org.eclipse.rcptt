/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getContainChildren <em>Contain Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectCommand()
 * @model
 * @generated
 */
public interface SelectCommand extends Command {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(SelectData)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectCommand_Data()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SelectData getData();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(SelectData value);

	/**
	 * Returns the value of the '<em><b>Contain Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.SelectData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contain Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contain Children</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectCommand_ContainChildren()
	 * @model containment="true"
	 * @generated
	 */
	EList<SelectData> getContainChildren();

} // SelectCommand
