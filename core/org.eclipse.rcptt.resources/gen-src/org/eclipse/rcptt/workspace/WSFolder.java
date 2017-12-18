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
 * A representation of the model object '<em><b>WS Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFolder#getFiles <em>Files</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFolder#getFolders <em>Folders</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFolder#getFolderLinks <em>Folder Links</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFolder#getFileLinks <em>File Links</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFolder()
 * @model
 * @generated
 */
public interface WSFolder extends WSContainer {
	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.workspace.WSFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFolder_Files()
	 * @model containment="true"
	 * @generated
	 */
	EList<WSFile> getFiles();

	/**
	 * Returns the value of the '<em><b>Folders</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.workspace.WSFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' containment reference list.
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFolder_Folders()
	 * @model containment="true"
	 * @generated
	 */
	EList<WSFolder> getFolders();

	/**
	 * Returns the value of the '<em><b>Folder Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.workspace.WSFolderLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folder Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder Links</em>' containment reference list.
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFolder_FolderLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<WSFolderLink> getFolderLinks();

	/**
	 * Returns the value of the '<em><b>File Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.workspace.WSFileLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Links</em>' containment reference list.
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFolder_FileLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<WSFileLink> getFileLinks();

} // WSFolder
