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
package org.eclipse.rcptt.tesla.core.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Browser</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Browser#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Browser#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Browser#getPlainText <em>Plain Text</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getBrowser()
 * @model
 * @generated
 */
public interface Browser extends Control {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getBrowser_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Browser#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getBrowser_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Browser#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Plain Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plain Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plain Text</em>' attribute.
	 * @see #setPlainText(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getBrowser_PlainText()
	 * @model
	 * @generated
	 */
	String getPlainText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Browser#getPlainText <em>Plain Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plain Text</em>' attribute.
	 * @see #getPlainText()
	 * @generated
	 */
	void setPlainText(String value);

} // Browser
