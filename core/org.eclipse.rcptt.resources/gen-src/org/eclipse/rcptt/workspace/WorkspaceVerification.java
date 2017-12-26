/*******************************************************************************
 * Copyright (c) 2009, 2017 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.workspace;

import org.eclipse.rcptt.core.scenario.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.WorkspaceVerification#isAllowUncapturedFiles <em>Allow Uncaptured Files</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WorkspaceVerification#getIgnoredLines <em>Ignored Lines</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WorkspaceVerification#isIgnoreWhiteSpace <em>Ignore White Space</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceVerification()
 * @model
 * @generated
 */
public interface WorkspaceVerification extends Verification, WorkspaceData {

	/**
	 * Returns the value of the '<em><b>Allow Uncaptured Files</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Uncaptured Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Uncaptured Files</em>' attribute.
	 * @see #setAllowUncapturedFiles(boolean)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceVerification_AllowUncapturedFiles()
	 * @model default="true"
	 * @generated
	 */
	boolean isAllowUncapturedFiles();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WorkspaceVerification#isAllowUncapturedFiles <em>Allow Uncaptured Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Uncaptured Files</em>' attribute.
	 * @see #isAllowUncapturedFiles()
	 * @generated
	 */
	void setAllowUncapturedFiles(boolean value);

	/**
	 * Returns the value of the '<em><b>Ignored Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignored Lines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignored Lines</em>' attribute.
	 * @see #setIgnoredLines(String)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceVerification_IgnoredLines()
	 * @model
	 * @generated
	 */
	String getIgnoredLines();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WorkspaceVerification#getIgnoredLines <em>Ignored Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignored Lines</em>' attribute.
	 * @see #getIgnoredLines()
	 * @generated
	 */
	void setIgnoredLines(String value);

	/**
	 * Returns the value of the '<em><b>Ignore White Space</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore White Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore White Space</em>' attribute.
	 * @see #setIgnoreWhiteSpace(boolean)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceVerification_IgnoreWhiteSpace()
	 * @model default="false"
	 * @generated
	 */
	boolean isIgnoreWhiteSpace();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WorkspaceVerification#isIgnoreWhiteSpace <em>Ignore White Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore White Space</em>' attribute.
	 * @see #isIgnoreWhiteSpace()
	 * @generated
	 */
	void setIgnoreWhiteSpace(boolean value);
} // WorkspaceVerification
