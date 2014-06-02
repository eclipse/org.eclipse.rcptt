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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Between</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Between#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Between#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Between#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getBetween()
 * @model annotation="http://www.eclipse.org/ecl/docs description='<p>returns <code>true</code> if <code>input</code> is greater than or equal to <code>left</code> and less than or equal to <code>right</code></p>\n\n<p>Before performing an operation, arguments are converted according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n'"
 * @generated
 */
public interface Between extends Command {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' reference.
	 * @see #setInput(EObject)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getBetween_Input()
	 * @model
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Between#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(EObject)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getBetween_Left()
	 * @model
	 * @generated
	 */
	EObject getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Between#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(EObject value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(EObject)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getBetween_Right()
	 * @model
	 * @generated
	 */
	EObject getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Between#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(EObject value);

} // Between
