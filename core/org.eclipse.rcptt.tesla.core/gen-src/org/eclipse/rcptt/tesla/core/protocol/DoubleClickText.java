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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Click Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getButton <em>Button</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDoubleClickText()
 * @model
 * @generated
 */
public interface DoubleClickText extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDoubleClickText_Position()
	 * @model default=""
	 * @generated
	 */
	String getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(String value);

	/**
	 * Returns the value of the '<em><b>Button</b></em>' attribute.
	 * The default value is <code>"left"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Button</em>' attribute.
	 * @see #setButton(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDoubleClickText_Button()
	 * @model default="left"
	 * @generated
	 */
	String getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see #getButton()
	 * @generated
	 */
	void setButton(String value);

} // DoubleClickText
