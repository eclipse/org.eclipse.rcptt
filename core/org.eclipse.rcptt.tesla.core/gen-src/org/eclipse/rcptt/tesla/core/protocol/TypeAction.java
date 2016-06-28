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
package org.eclipse.rcptt.tesla.core.protocol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.TypeAction#getActionId <em>Action Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getTypeAction()
 * @model
 * @generated
 */
public interface TypeAction extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Id</em>' attribute.
	 * @see #setActionId(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getTypeAction_ActionId()
	 * @model
	 * @generated
	 */
	String getActionId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.TypeAction#getActionId <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Id</em>' attribute.
	 * @see #getActionId()
	 * @generated
	 */
	void setActionId(String value);

} // TypeAction
