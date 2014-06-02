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
package org.eclipse.rcptt.tesla.ecl.model.diagram;

import org.eclipse.rcptt.tesla.ecl.model.Button;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mouse Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getMask <em>Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Emulates mouse actions'"
 * @generated
 */
public interface MouseAction extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Canvas, edit part or figure.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getControl <em>Control</em>}' reference.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_X()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='X coordinate relative to left top corner of the control.'"
	 * @generated
	 */
	Integer getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getX <em>X</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_Y()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Y coordinate relative to left top corner of the control.'"
	 * @generated
	 */
	Integer getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(Integer value);

	/**
	 * Returns the value of the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mask</em>' attribute.
	 * @see #setMask(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_Mask()
	 * @model annotation="http://www.eclipse.org/ecl/docs default='0'"
	 * @generated
	 */
	String getMask();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getMask <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mask</em>' attribute.
	 * @see #getMask()
	 * @generated
	 */
	void setMask(String value);

	/**
	 * Returns the value of the '<em><b>Button</b></em>' attribute.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_Button()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Mouse button pressed. Must be one of followings: none, button1, button2, button3.' default='none'"
	 * @generated
	 */
	Button getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Button
	 * @see #getButton()
	 * @generated
	 */
	void setButton(Button value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_Height()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Height of the control.' default='0'"
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage#getMouseAction_Width()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Width of the control.' default='0'"
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Integer value);

} // MouseAction
