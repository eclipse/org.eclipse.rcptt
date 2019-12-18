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


import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Val;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Loop#getVals <em>Vals</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Loop#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getLoop()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Executes recursive looping of a body. Allows to emulate \'while\' and \'for\' loops while preserving variable immutability. The idea is taken from Clojure\'s &lt;a href=\"http://clojure.org/functional_programming#Functional%20Programming--Recursive%20Looping\"&gt;loop/recur&lt;/a&gt; approach. Also see &lt;a href=\"#recur\"&gt;recur&lt;/a&gt; command.' example='// Example 1. returns how many times a 81 is divisible by 3\nloop [val count 0] [val n 81] {\n    if [mod $n 3 | eq 0] {\n        recur [$count | plus 1] [$n | div 3]\n    } -else {\n        log [format \"The answer is %d\" $count] //prints \'The answer is 4\'\n    }\n}\n\n\n// Example 2. deletes all elements from a tree\nproc \"get-my-tree\" { get-view \"My View\" | get-tree }\n\nproc \"has-elements\" {\n    get-my-tree | get-property itemCount -raw | int | gt 0\n}\n\nloop {\n    if [has-elements] {\n        // Selects a first top-level item and invokes \"Delete\" from context menu\n        get-my-tree | select \".*\" | get-menu \"Delete\" | click\n        // Confirms a removal in popup dialog\n        get-window \"Confirm Delete\" | get-button OK | click\n        // Continues execution from the beginning of loop body\n        recur\n    }\n}'"
 * @generated
 */
public interface Loop extends Command {
	/**
	 * Returns the value of the '<em><b>Vals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Val}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vals</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getLoop_Vals()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Valus which are going to be modified during iterations. All initial values must be set.'"
	 * @generated
	 */
	EList<Val> getVals();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' reference.
	 * @see #setBody(Command)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getLoop_Body()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='A script to execute. Whenever script invokes &lt;a href=\"#recur\"&gt;recur&lt;/a&gt; command, an execution jumps to the beginning of loop body script.'"
	 * @generated
	 */
	Command getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Loop#getBody <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Command value);

} // Loop
