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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Click Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getButton <em>Button</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickText()
 * @model annotation="http://www.eclipse.org/ecl/docs description='<p>Double-clicks on editbox to set cursor position and/or selection. More verbosely, it does the following:</p>\r\n<ol>\r\n  <li>Sets focus to editbox if not yet focused</li>\r\n  <li>Sends double-click event</li>\r\n</ol>\r\n<p>\r\n  <code>position</code> argument have different form depending on editbox kind:\r\n  <ul>\r\n    <li>For single line editboxes &ndash; 1-based indices in text (e.g. <code>1</code>, <code>5</code>)</li>\r\n    <li>For multi line editboxes &ndash; 1-based line and colum indices separated by colon (e.g <code>1:32</code>, <code>30:1</code>).</li>\r\n  </ul>\r\n</p>' returns='input item'"
 * @generated
 */
public interface DoubleClickText extends ControlCommand {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickText_Position()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Cursor location where the double-click will occur.'"
	 * @generated
	 */
	String getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getPosition <em>Position</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickText_Button()
	 * @model default="left"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Mouse button: left, right or middle.'"
	 * @generated
	 */
	String getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see #getButton()
	 * @generated
	 */
	void setButton(String value);

} // DoubleClickText
