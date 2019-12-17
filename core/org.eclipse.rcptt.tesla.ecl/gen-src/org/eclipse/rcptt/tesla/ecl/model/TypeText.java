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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#isDisplay <em>Display</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getTypeText()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Types text to the control.' returns='value of &lt;code&gt;control&lt;/code&gt; parameter' example='get-editor \"Test scenario\" | get-section Script | get-editbox |  type-text \"wait 200\"'"
 * @generated
 */
public interface TypeText extends Command {
	/**
	 * Returns the value of the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control</em>' reference.
	 * @see #setControl(ControlHandler)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getTypeText_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/input"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Any control is appropriate.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getTypeText_Text()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Text to type.'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display</em>' attribute.
	 * @see #setDisplay(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getTypeText_Display()
	 * @model
	 * @generated
	 */
	boolean isDisplay();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#isDisplay <em>Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display</em>' attribute.
	 * @see #isDisplay()
	 * @generated
	 */
	void setDisplay(boolean value);

} // TypeText
