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
package org.eclipse.rcptt.ecl.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Listen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Listen#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Listen#getWhile <em>While</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getListen()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Listens for state changes while executing commands.' returns='State difference before and after execution.' example='// assert no new errors while clicking on the button\r\nlisten errorLog {\r\n\tget-button OK | click\r\n} | assert-empty'"
 * @generated
 */
public interface Listen extends Command {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getListen_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Source to listen for, for example, <code>errorLog</code>.'"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Listen#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>While</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>While</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>While</em>' reference.
	 * @see #setWhile(Command)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getListen_While()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Commands to execute while listening for the source.'"
	 * @generated
	 */
	Command getWhile();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Listen#getWhile <em>While</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>While</em>' reference.
	 * @see #getWhile()
	 * @generated
	 */
	void setWhile(Command value);

} // Listen
