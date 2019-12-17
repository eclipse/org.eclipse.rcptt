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
package org.eclipse.rcptt.tesla.ecl.model;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Equals#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Equals#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getEquals()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Compares &lt;code&gt;input&lt;/code&gt; with &lt;code&gt;value&lt;/code&gt;' input='EObject input' returns='true if values are equal or false otherwise' example='get-view \"Q7 Explorer\" | get-tree | get-item Project | get-property childCount | equals 3 | verify-true'"
 * @generated
 */
public interface Equals extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getEquals_Input()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/input"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Property value extracted with &lt;code&gt;get-property&lt;/code&gt;'"
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Equals#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getEquals_Value()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Expected property value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Equals#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Equals
