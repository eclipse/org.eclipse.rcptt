/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.workspace;

import org.eclipse.rcptt.core.scenario.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.WorkspaceContext#isClearWorkspace <em>Clear Workspace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WorkspaceContext#getIgnoredByClearPattern <em>Ignored By Clear Pattern</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceContext()
 * @model
 * @generated
 */
public interface WorkspaceContext extends Context, WorkspaceData {
	/**
	 * Returns the value of the '<em><b>Clear Workspace</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear Workspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Workspace</em>' attribute.
	 * @see #setClearWorkspace(boolean)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceContext_ClearWorkspace()
	 * @model default="true"
	 * @generated
	 */
	boolean isClearWorkspace();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WorkspaceContext#isClearWorkspace <em>Clear Workspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Workspace</em>' attribute.
	 * @see #isClearWorkspace()
	 * @generated
	 */
	void setClearWorkspace(boolean value);

	/**
	 * Returns the value of the '<em><b>Ignored By Clear Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignored By Clear Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignored By Clear Pattern</em>' attribute.
	 * @see #setIgnoredByClearPattern(String)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWorkspaceContext_IgnoredByClearPattern()
	 * @model
	 * @generated
	 */
	String getIgnoredByClearPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WorkspaceContext#getIgnoredByClearPattern <em>Ignored By Clear Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignored By Clear Pattern</em>' attribute.
	 * @see #getIgnoredByClearPattern()
	 * @generated
	 */
	void setIgnoredByClearPattern(String value);

} // WorkspaceContext
