/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Switch#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Switch#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Switch#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Reads object from input pipe or &lt;code&gt;input&lt;/code&gt; parameter and executes a &lt;code&gt;case&lt;/code&gt; part with matching &lt;code&gt;condition&lt;/code&gt; parameter (if any) sending &lt;code&gt;input&lt;/code&gt; parameter as an input. If no &lt;code&gt;case&lt;/code&gt; matched, the &lt;code&gt;default&lt;code&gt; block (if any) will be executed.' returns='An output of executed block (&lt;code&gt;case&lt;/code&gt; command or &lt;code&gt;-default&lt;/code&gt; block). If nothing is executed, no output will be produced.' example='list 1 2 3 | get 0 | switch [case 1 {\n\techo \"Found 1\"\n}] [case 2 {\n\techo \"Found 2\"\n}] - default {\n\techo \"Unknown item\"\n} | equals \"Found 1\" | verify-true\n\n///////////\n\nproc \"set-schedules-view-value\" [val view] [val date] [val direction] {\n// First, determine View to set desired Date value in\nget-view Schedules | get-section $view | get-property \"getText()\" -raw | switch\n[case \"Year View\" {\necho \"The YEAR View is being Evaluated!\"\n// Second, determine if the desired Date is already set\nset-view-value $view \"\\d\\d\\d\\d\" $date $direction }]\n[case \"Month View\" {\necho \"The MONTH View is being Evaluated!\"\nset-view-value $view \"(January|February|March|April|May|June|July|August|September|October|November|December), \\d+\" $date $direction}]\n[case \"Week View\" {\necho \"The WEEK View is being Evaluated!\"\nset-view-value $view \"Week \\d+, \\d+\" $date $direction }]\n[case \"Day View\" {\necho \"The DAY View is being Evaluated!\"\nset-view-value $view \"(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), .*? \\d+, \\d+\" $date $direction}]\n-default {\necho \"The View Value specified in NOT Supported!\"\n}\n}\n'"
 * @generated
 */
public interface Switch extends Command {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Case}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch_Items()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='One or more &lt;code&gt;case&lt;/code&gt; blocks. Block with a condition matching the input will be executed.'"
	 * @generated
	 */
	EList<Case> getItems();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Command)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch_Default()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Optional parameter. The block which will be executed in case no &lt;code&gt;case&lt;/code&gt; block is executed.'"
	 * @generated
	 */
	Command getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Switch#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Command value);

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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSwitch_Input()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/input"
	 *        annotation="http://www.eclipse.org/ecl/docs description='The input object to match.'"
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Switch#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

} // Switch
