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
 * A representation of the model object '<em><b>Click</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Click#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Click#isNowait <em>Nowait</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Click#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Click#isArrow <em>Arrow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClick()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Clicks on a control.' returns='value of <code>control</code> parameter' recorded='true' example='get-editor TestSuite | get-section \"Test Cases\" | get-button \"Add Test Case\" | click'"
 * @generated
 */
public interface Click extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClick_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Any control is appropriate.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Click#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>Nowait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nowait</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nowait</em>' attribute.
	 * @see #setNowait(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClick_Nowait()
	 * @model annotation="http://www.eclipse.org/ecl/depricated description='Specifies if execution must wait for all UI jobs to complete after clicking.' default='false'"
	 * @generated
	 */
	boolean isNowait();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Click#isNowait <em>Nowait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nowait</em>' attribute.
	 * @see #isNowait()
	 * @generated
	 */
	void setNowait(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClick_Default()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Specifies if clicking causes default selection.' default='false'"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Click#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Arrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow</em>' attribute.
	 * @see #setArrow(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClick_Arrow()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Specifies arrow button behavior.' default='false'"
	 * @generated
	 */
	boolean isArrow();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Click#isArrow <em>Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrow</em>' attribute.
	 * @see #isArrow()
	 * @generated
	 */
	void setArrow(boolean value);

} // Click
