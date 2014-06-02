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

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ruler Double Click</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickRuler()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Double clicks ruler on given line with specified modifiers and mouse button' returns='value of control parameter'"
 * @generated
 */
public interface DoubleClickRuler extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickRuler_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Editor ruler'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickRuler_Line()
	 * @model
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Button</b></em>' attribute.
	 * The default value is <code>"Left"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Button</em>' attribute.
	 * @see #setButton(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickRuler_Button()
	 * @model default="Left"
	 *        annotation="http://www.eclipse.org/ecl/docs desciption='Mouse button: Left, Right or Middle'"
	 * @generated
	 */
	String getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see #getButton()
	 * @generated
	 */
	void setButton(String value);

	/**
	 * Returns the value of the '<em><b>With</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With</em>' attribute.
	 * @see #setWith(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getDoubleClickRuler_With()
	 * @model default=""
	 *        annotation="http://www.eclipse.org/ecl/docs desciption='Modfier keys joined by \'+\', for example \'M1+M2\', or \'M3\'. '"
	 * @generated
	 */
	String getWith();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getWith <em>With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With</em>' attribute.
	 * @see #getWith()
	 * @generated
	 */
	void setWith(String value);

} // RulerDoubleClick
