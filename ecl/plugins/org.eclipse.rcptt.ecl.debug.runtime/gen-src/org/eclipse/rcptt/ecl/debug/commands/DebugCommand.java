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
package org.eclipse.rcptt.ecl.debug.commands;

import java.util.Map;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getSession <em>Session</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPaths <em>Paths</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.debug.commands.CommandsPackage#getDebugCommand()
 * @model
 * @generated
 */
public interface DebugCommand extends Command {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.rcptt.ecl.debug.commands.CommandsPackage#getDebugCommand_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' attribute.
	 * @see #setSession(String)
	 * @see org.eclipse.rcptt.ecl.debug.commands.CommandsPackage#getDebugCommand_Session()
	 * @model
	 * @generated
	 */
	String getSession();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getSession <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' attribute.
	 * @see #getSession()
	 * @generated
	 */
	void setSession(String value);

	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' containment reference.
	 * @see #setCommand(Command)
	 * @see org.eclipse.rcptt.ecl.debug.commands.CommandsPackage#getDebugCommand_Command()
	 * @model containment="true"
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getCommand <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' containment reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

	/**
	 * Returns the value of the '<em><b>Paths</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paths</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paths</em>' map.
	 * @see org.eclipse.rcptt.ecl.debug.commands.CommandsPackage#getDebugCommand_Paths()
	 * @model mapType="org.eclipse.rcptt.ecl.debug.commands.PathsMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getPaths();

} // DebugCommand
