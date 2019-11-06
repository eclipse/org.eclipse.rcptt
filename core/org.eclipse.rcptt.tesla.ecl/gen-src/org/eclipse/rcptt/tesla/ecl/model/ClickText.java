/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getButton <em>Button</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickText()
 * @model annotation="http://www.eclipse.org/ecl/docs description='&lt;p&gt;Clicks on editbox to set cursor position (when only &lt;code&gt;start&lt;/code&gt; argument specified) or text selection (when both &lt;code&gt;start&lt;/code&gt; and &lt;code&gt;end&lt;/code&gt; are set). When no arguments given, sets cursor in the beginning of an editbox. More verbosely, it does the following:&lt;/p&gt;\r\n&lt;ol&gt;\r\n  &lt;li&gt;Sets focus to editbox if not yet focused&lt;/li&gt;\r\n  &lt;li&gt;Sends mouse down and up events&lt;/li&gt;\r\n  &lt;li&gt;Sets caret position or text selection based on arguments&lt;/li&gt;\r\n&lt;/ol&gt;\r\n&lt;p&gt;\r\n  &lt;code&gt;start&lt;/code&gt; and &lt;code&gt;end&lt;/code&gt; arguments have different forms depending on editbox kind:\r\n  &lt;ul&gt;\r\n    &lt;li&gt;For single line editboxes &amp;ndash; 1-based indices in text (e.g. &lt;code&gt;1&lt;/code&gt;, &lt;code&gt;5&lt;/code&gt;)&lt;/li&gt;\r\n    &lt;li&gt;For multi line editboxes &amp;ndash; 1-based line and colum indices separated by colon (e.g &lt;code&gt;1:32&lt;/code&gt;, &lt;code&gt;30:1&lt;/code&gt;).&lt;/li&gt;\r\n  &lt;/ul&gt;\r\n&lt;/p&gt;' returns='input item' example='with [get-editbox -after [get-label \"Location:\"]] {\n        click-text 3\n    }'"
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
	 *        annotation="http://www.eclipse.org/ecl/docs description='Cursor location when &lt;code&gt;end&lt;/code&gt; is not set or selection start otherwise'"
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
