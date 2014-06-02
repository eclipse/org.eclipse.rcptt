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
 * A representation of the model object '<em><b>Click Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getButton <em>Button</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickText()
 * @model annotation="http://www.eclipse.org/ecl/docs description='<p>Clicks on editbox to set cursor position (when only <code>start</code> argument specified) or text selection (when both <code>start</code> and <code>end</code> are set). When no arguments given, sets cursor in the beginning of an editbox. More verbosely, it does the following:</p>\r\n<ol>\r\n  <li>Sets focus to editbox if not yet focused</li>\r\n  <li>Sends mouse down and up events</li>\r\n  <li>Sets caret position or text selection based on arguments</li>\r\n</ol>\r\n<p>\r\n  <code>start</code> and <code>end</code> arguments have different forms depending on editbox kind:\r\n  <ul>\r\n    <li>For single line editboxes &ndash; 1-based indices in text (e.g. <code>1</code>, <code>5</code>)</li>\r\n    <li>For multi line editboxes &ndash; 1-based line and colum indices separated by colon (e.g <code>1:32</code>, <code>30:1</code>).</li>\r\n  </ul>\r\n</p>' returns='input item'"
 * @generated
 */
public interface ClickText extends ControlCommand {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickText_Start()
	 * @model default=""
	 *        annotation="http://www.eclipse.org/ecl/docs description='Cursor location when <code>end</code> is not set or selection start otherwise'"
	 * @generated
	 */
	String getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(String value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickText_End()
	 * @model default=""
	 *        annotation="http://www.eclipse.org/ecl/docs description='Selection end'"
	 * @generated
	 */
	String getEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(String value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickText_Button()
	 * @model default="left"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Mouse button: left, right or middle.'"
	 * @generated
	 */
	String getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see #getButton()
	 * @generated
	 */
	void setButton(String value);

} // ClickText
