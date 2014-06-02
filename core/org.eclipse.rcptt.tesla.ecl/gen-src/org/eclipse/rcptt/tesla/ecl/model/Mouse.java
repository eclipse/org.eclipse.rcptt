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
 * A representation of the model object '<em><b>Mouse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getWith <em>With</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Sends a mouse event to control. Returns the same control, so that mouse commands can be chained: <pre>... | get-text \"Foo\" | mouse down -button Right | mouse up -buton Right</pre>' returns='value of control parameter'"
 * @generated
 */
public interface Mouse extends ControlCommand {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute.
	 * @see #setEvent(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse_Event()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Mouse event: <ul><li>up</li><li>down</li><li>move</li><li>enter</li><li>exit</li><li>hover</li><li>double-click</li></ul>'"
	 * @generated
	 */
	String getEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(String value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse_Button()
	 * @model default="Left"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Mouse button: Left, Right or Middle'"
	 * @generated
	 */
	String getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getButton <em>Button</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse_With()
	 * @model default=""
	 *        annotation="http://www.eclipse.org/ecl/docs description='Modfier keys and holded mouse buttons joined by \'+\', for example \'M1+M2\', or \'M3\'. '"
	 * @generated
	 */
	String getWith();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getWith <em>With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With</em>' attribute.
	 * @see #getWith()
	 * @generated
	 */
	void setWith(String value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse_Count()
	 * @model default="-1"
	 *        annotation="http://www.eclipse.org/ecl/docs description='The \'count\' to be set in mouse event. When omitted, reasonable default is used'"
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"-2147483648"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse_X()
	 * @model default="-2147483648"
	 *        annotation="http://www.eclipse.org/ecl/docs description='The \'x\' coordinate of mouse event. Can be omitted'"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"-2147483648"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getMouse_Y()
	 * @model default="-2147483648"
	 *        annotation="http://www.eclipse.org/ecl/docs description='The \'y\' coordinate of mouse event. Can be omitted'"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

} // Mouse
