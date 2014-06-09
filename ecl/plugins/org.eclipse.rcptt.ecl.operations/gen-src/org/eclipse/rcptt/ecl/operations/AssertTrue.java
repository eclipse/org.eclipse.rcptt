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
package org.eclipse.rcptt.ecl.operations;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert True</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.AssertTrue#isInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.AssertTrue#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAssertTrue()
 * @model annotation="http://www.eclipse.org/ecl/docs description='If input is not true, fails' returns='Nothing' example='...get-tree | get-item Project | get-property childCount -raw | gt 3 | assert-true -message \"Child count is not greater then 3!\" '"
 * @generated
 */
public interface AssertTrue extends Command {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(boolean)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAssertTrue_Input()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Input value. Must be true.'"
	 * @generated
	 */
	boolean isInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.AssertTrue#isInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #isInput()
	 * @generated
	 */
	void setInput(boolean value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAssertTrue_Message()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Message to fail with when input is not true'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.AssertTrue#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // AssertTrue
