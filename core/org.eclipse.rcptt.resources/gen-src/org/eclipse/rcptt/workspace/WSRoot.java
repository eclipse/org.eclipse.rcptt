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
package org.eclipse.rcptt.workspace;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.WSRoot#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WSRoot#getProjectLinks <em>Project Links</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSRoot()
 * @model
 * @generated
 */
public interface WSRoot extends WSContainer {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.workspace.WSProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSRoot_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<WSProject> getProjects();

	/**
	 * Returns the value of the '<em><b>Project Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.workspace.WSProjectLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Links</em>' containment reference list.
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSRoot_ProjectLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<WSProjectLink> getProjectLinks();

} // WSRoot
