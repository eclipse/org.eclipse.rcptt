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
package org.eclipse.rcptt.ecl.operations;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert Non Empty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.AssertNonEmpty#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAssertNonEmpty()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Asserts that input pipe contain something' returns='Nothing' example='find-in-workspace -path \"Project/.*\" | assert-non-empty'"
 * @generated
 */
public interface AssertNonEmpty extends Command {
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
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAssertNonEmpty_Message()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Message to fail with when input is empty'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.AssertNonEmpty#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // AssertNonEmpty
