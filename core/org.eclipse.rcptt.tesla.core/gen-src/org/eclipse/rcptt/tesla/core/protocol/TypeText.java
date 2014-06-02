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
 * A representation of the model object '<em><b>Type Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#isFromDisplay <em>From Display</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getTypeText()
 * @model
 * @generated
 */
public interface TypeText extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getTypeText_State()
	 * @model
	 * @generated
	 */
	Integer getState();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(Integer value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getTypeText_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>From Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Display</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Display</em>' attribute.
	 * @see #setFromDisplay(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getTypeText_FromDisplay()
	 * @model
	 * @generated
	 */
	boolean isFromDisplay();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#isFromDisplay <em>From Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Display</em>' attribute.
	 * @see #isFromDisplay()
	 * @generated
	 */
	void setFromDisplay(boolean value);

} // TypeText
