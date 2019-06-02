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
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Proc#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Proc#getVals <em>Vals</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Proc#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProc()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Declares a new procedure in a context of current ECL session, which can later be accessed as a usual command.' returns='An output of a &lt;code&gt;body&lt;/code&gt; script' example='// example 1\n// declaration:\nproc \"click-button\" [val window] [val button] {\n   get-window $window | get-button $button | click\n}\n\n// usage\nclick-button \"New Project\" \"Cancel\"\n\n// example #2, using input argument and default value\n// declaration:\nproc \"set-text-after-label\" [val parent -input] [val label] [val text \"\"] {\n\t$parent | get-editbox -after [get-label $label] | set-text $text\n}\n\n// usage:\nwith [get-window \"New Project\"] {\n   set-text-after-label \"Name:\" \"Sample Project\"\n}\nget-editor | set-text-after-label \"Text\"'"
 * @generated
 */
public interface Proc extends Command {
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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProc_Name()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Procedure name. Must be unique in a context of current ECL session'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Proc#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProc_Vals()
	 * @model containment="true"
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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProc_Body()
	 * @model containment="true"
	 * @generated
	 */
	Command getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Proc#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Command value);

} // Proc
