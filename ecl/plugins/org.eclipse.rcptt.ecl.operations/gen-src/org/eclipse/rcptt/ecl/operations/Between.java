/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Between#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Between#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Between#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getBetween()
 * @model annotation="http://www.eclipse.org/ecl/docs description='&lt;p&gt;returns &lt;code&gt;true&lt;/code&gt; if &lt;code&gt;input&lt;/code&gt; is greater than or equal to &lt;code&gt;left&lt;/code&gt; and less than or equal to &lt;code&gt;right&lt;/code&gt;&lt;/p&gt;\n\n&lt;p&gt;Before performing an operation, arguments are converted according to the following rules:&lt;/p&gt;\n&lt;ol&gt;\n  &lt;li&gt;&lt;code&gt;string&lt;/code&gt; arguments converted to &lt;code&gt;long&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;&lt;code&gt;boolean&lt;/code&gt; arguments converted to &lt;code&gt;long&lt;/code&gt; (1 for &lt;code&gt;true&lt;/code&gt; and 0 for &lt;code&gt;false&lt;/code&gt;)&lt;/li&gt;\n  &lt;li&gt;If one of arguments is &lt;code&gt;double&lt;/code&gt;, converts the other one to &lt;code&gt;double&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;If one of arguments is &lt;code&gt;float&lt;/code&gt;, converts the other one to &lt;code&gt;float&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;If one of arguments is &lt;code&gt;long&lt;/code&gt;, converts the other one to &lt;code&gt;long&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;Otherwise (in case of &lt;code&gt;byte&lt;/code&gt;, &lt;code&gt;char&lt;/code&gt;, or &lt;code&gt;short&lt;/code&gt;) converts both arguments to &lt;code&gt;int&lt;/code&gt;&lt;/li&gt;\n&lt;/ol&gt;\n' example='int 10 | between 7 12 | verify-true'"
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
