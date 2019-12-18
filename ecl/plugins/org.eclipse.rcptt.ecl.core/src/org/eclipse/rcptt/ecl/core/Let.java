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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Let#getVals <em>Vals</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Let#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getLet()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Defines variables and evaluates &lt;code&gt;body&lt;/code&gt; script. Variable declarations are only visible from withing a body script and cannot be accessed after \'let\' command. If some variable has &lt;code&gt;-input&lt;/code&gt; flag, then &lt;code&gt;let&lt;/code&gt; command must be used in a pipeline (see example 2). ' returns='An output of a &lt;code&gt;body&lt;/code&gt; script' example='// example #1, simple usage of two variables\nlet [val foo \"hello\"]\n     [val bar \"world!\"] {\n\tformat \"%s, %s\" $foo $bar | show-alert\n}\n\n// example #2, using input argument\nget-window \"New Project\" | let [val window -input] [val button OK] {\n    $window | get-button $button | click\n}\n'"
 * @generated
 */
public interface Let extends Command {
	/**
	 * Returns the value of the '<em><b>Vals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vals</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getLet_Vals()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='List of variables'"
	 * @generated
	 */
	EList<Declaration> getVals();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Command)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getLet_Body()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Script to be executed'"
	 * @generated
	 */
	Command getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Let#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Command value);

} // Let
