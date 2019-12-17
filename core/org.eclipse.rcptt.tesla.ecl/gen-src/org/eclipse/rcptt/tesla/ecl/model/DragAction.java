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
 * A representation of the model object '<em><b>Drag Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getMask <em>Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getDetail <em>Detail</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Emulates drag action event.' returns='value of &lt;code&gt;control&lt;/code&gt; parameter'"
 * @generated
 */
public interface DragAction extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Any control is appropriate.'"
	 *        annotation="http://www.eclipse.org/ecl/input"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_X()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='X coordinate relative to left top corner of the control.' default='0'"
	 * @generated
	 */
	Integer getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Integer value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_Y()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Y coordinate relative to left top corner of the control.' default='0'"
	 * @generated
	 */
	Integer getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(Integer value);

	/**
	 * Returns the value of the '<em><b>Detail</b></em>' attribute.
	 * The default value is <code>"none"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detail</em>' attribute.
	 * @see #setDetail(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_Detail()
	 * @model default="none"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Kind of DND operation to perform: &lt;code&gt;copy&lt;/code&gt;, &lt;code&gt;move&lt;/code&gt;, &lt;code&gt;link&lt;/code&gt;, &lt;code&gt;target-move&lt;/code&gt; (move to non-SWT application) or &lt;code&gt;none&lt;/code&gt; (if not applicable).'"
	 * @generated
	 */
	String getDetail();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getDetail <em>Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detail</em>' attribute.
	 * @see #getDetail()
	 * @generated
	 */
	void setDetail(String value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_Operation()
	 * @model default="-1"
	 * @generated
	 */
	Integer getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Integer value);

	/**
	 * Returns the value of the '<em><b>Mask</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mask</em>' attribute.
	 * @see #setMask(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_Mask()
	 * @model default=""
	 *        annotation="http://www.eclipse.org/ecl/docs default='0' description='Plus-separated pressed metakeys. Example: ALT+SHIFT'"
	 * @generated
	 */
	String getMask();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getMask <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mask</em>' attribute.
	 * @see #getMask()
	 * @generated
	 */
	void setMask(String value);

	/**
	 * Returns the value of the '<em><b>Button</b></em>' attribute.
	 * The default value is <code>"none"</code>.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.ecl.model.Button}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Button</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Button
	 * @see #setButton(Button)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDragAction_Button()
	 * @model default="none"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Mouse button pressed. Must be one of followings: none, button1, button2, button3.' default='none'"
	 * @generated
	 */
	Button getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Button
	 * @see #getButton()
	 * @generated
	 */
	void setButton(Button value);

} // DragAction
