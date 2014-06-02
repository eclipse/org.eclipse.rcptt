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
package org.eclipse.rcptt.ecl.interop;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Process Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getExitCode <em>Exit Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStdout <em>Stdout</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStderr <em>Stderr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getExecProcessResult()
 * @model
 * @generated
 */
public interface ExecProcessResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Exit Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Code</em>' attribute.
	 * @see #setExitCode(int)
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getExecProcessResult_ExitCode()
	 * @model
	 * @generated
	 */
	int getExitCode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getExitCode <em>Exit Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Code</em>' attribute.
	 * @see #getExitCode()
	 * @generated
	 */
	void setExitCode(int value);

	/**
	 * Returns the value of the '<em><b>Stdout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stdout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stdout</em>' attribute.
	 * @see #setStdout(String)
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getExecProcessResult_Stdout()
	 * @model
	 * @generated
	 */
	String getStdout();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStdout <em>Stdout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stdout</em>' attribute.
	 * @see #getStdout()
	 * @generated
	 */
	void setStdout(String value);

	/**
	 * Returns the value of the '<em><b>Stderr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stderr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stderr</em>' attribute.
	 * @see #setStderr(String)
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getExecProcessResult_Stderr()
	 * @model
	 * @generated
	 */
	String getStderr();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.ExecProcessResult#getStderr <em>Stderr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stderr</em>' attribute.
	 * @see #getStderr()
	 * @generated
	 */
	void setStderr(String value);

} // ExecProcessResult
