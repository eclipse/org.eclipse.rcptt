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
package org.eclipse.rcptt.testing.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.Eval#getAutId <em>Aut Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.Eval#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getEval()
 * @model
 * @generated
 */
public interface Eval extends Command {
	/**
	 * Returns the value of the '<em><b>Aut Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aut Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aut Id</em>' attribute.
	 * @see #setAutId(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getEval_AutId()
	 * @model required="true"
	 * @generated
	 */
	String getAutId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.Eval#getAutId <em>Aut Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aut Id</em>' attribute.
	 * @see #getAutId()
	 * @generated
	 */
	void setAutId(String value);

	/**
	 * Returns the value of the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' attribute.
	 * @see #setScript(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getEval_Script()
	 * @model required="true"
	 * @generated
	 */
	String getScript();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.Eval#getScript <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script</em>' attribute.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(String value);

} // Eval
