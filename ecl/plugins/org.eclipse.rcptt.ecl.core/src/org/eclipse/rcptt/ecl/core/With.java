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
 * A representation of the model object '<em><b>With</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.With#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.With#getDo <em>Do</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getWith()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Executes a &lt;code&gt;do&lt;/code&gt; script by passing given &lt;code&gt;object&lt;/code&gt; to each command inside &lt;code&gt;do&lt;/code&gt;. The primary use case for this command is to extract a common prefix for a sequence of commands.' returns='Output of a &lt;code&gt;do&lt;/code&gt; command' example='get-view \"Package Explorer\" | get-button \"Collapse All (M1+M2+Numpad_Divide)\" | click\nget-view \"Package Explorer\" | get-button \"Link with Editor\" | click\n// can be shorten to:\nwith [get-view \"Package Explorer\"] {\n    get-button \"Collapse All (M1+M2+Numpad_Divide)\" | click\n    get-button \"Link with Editor\" | click\n}\n'"
 * @generated
 */
public interface With extends Command {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(EObject)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getWith_Object()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.With#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Do</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Do</em>' containment reference.
	 * @see #setDo(Command)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getWith_Do()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Command getDo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.With#getDo <em>Do</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do</em>' containment reference.
	 * @see #getDo()
	 * @generated
	 */
	void setDo(Command value);

} // With
