/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.operations;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Try#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Try#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Try#getFinally <em>Finally</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Try#getTimes <em>Times</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Try#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getTry()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Try to execute command, retry times with delay if command are failed.\nExecute catch if all operations is not succesfull. Execute finally in anyway.' returns='return\'s -command output if command is successed.' example='try -times 10 -delay 100 -command {\r\n\t// some ECL scripts\r\n}'"
 * @generated
 */
public interface Try extends Command {
	/**
	 * Returns the value of the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' reference.
	 * @see #setCommand(Command)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getTry_Command()
	 * @model
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Try#getCommand <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

	/**
	 * Returns the value of the '<em><b>Catch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch</em>' reference.
	 * @see #setCatch(Command)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getTry_Catch()
	 * @model
	 * @generated
	 */
	Command getCatch();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Try#getCatch <em>Catch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch</em>' reference.
	 * @see #getCatch()
	 * @generated
	 */
	void setCatch(Command value);

	/**
	 * Returns the value of the '<em><b>Finally</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally</em>' reference.
	 * @see #setFinally(Command)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getTry_Finally()
	 * @model
	 * @generated
	 */
	Command getFinally();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Try#getFinally <em>Finally</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally</em>' reference.
	 * @see #getFinally()
	 * @generated
	 */
	void setFinally(Command value);

	/**
	 * Returns the value of the '<em><b>Times</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Times</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Times</em>' attribute.
	 * @see #setTimes(Integer)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getTry_Times()
	 * @model default="1"
	 * @generated
	 */
	Integer getTimes();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Try#getTimes <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Times</em>' attribute.
	 * @see #getTimes()
	 * @generated
	 */
	void setTimes(Integer value);

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(Integer)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getTry_Delay()
	 * @model default="0"
	 * @generated
	 */
	Integer getDelay();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Try#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(Integer value);

} // Try
