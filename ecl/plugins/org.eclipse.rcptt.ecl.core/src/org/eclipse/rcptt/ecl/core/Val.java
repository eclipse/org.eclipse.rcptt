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
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Val#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Val#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Val#isInput <em>Input</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getVal()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Creates a new variable declaration. This command can be used only with &lt;a href=\"#let\"&gt;let&lt;/a&gt; and &lt;a href=\"#proc\"&gt;proc&lt;/a&gt;.' returns='An internal object, describing a variable' example='let [val button [get-button OK]] {\n    $button | click\n}'"
 * @generated
 */
public interface Val extends Declaration {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getVal_Name()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Variable name. Later this name can be used to refer to a variable value by prepending a dollar sign, i.e. $varName. If variable with the same name already defined in outer scope, then it will be hidden by inner variable with the same name.'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Val#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(boolean)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getVal_Input()
	 * @model default="false"
	 *        annotation="http://www.eclipse.org/ecl/docs description='An option to indicate that variable value should be taken from input pipe. '"
	 * @generated
	 */
	boolean isInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Val#isInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #isInput()
	 * @generated
	 */
	void setInput(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EObject)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getVal_Value()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Variable value. When variable is defined in &lt;a href=\"#proc\"&gt;proc&lt;/a&gt; block, this value denotes the default parameter value.'"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Val#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

} // Val
