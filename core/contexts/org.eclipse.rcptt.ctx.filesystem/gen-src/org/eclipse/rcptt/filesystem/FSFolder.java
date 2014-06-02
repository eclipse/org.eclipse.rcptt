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
package org.eclipse.rcptt.filesystem;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FS Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.filesystem.FSFolder#getFolders <em>Folders</em>}</li>
 *   <li>{@link org.eclipse.rcptt.filesystem.FSFolder#getFiles <em>Files</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFSFolder()
 * @model
 * @generated
 */
public interface FSFolder extends FSResource {
	/**
	 * Returns the value of the '<em><b>Folders</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.filesystem.FSFolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' containment reference list.
	 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFSFolder_Folders()
	 * @model containment="true"
	 * @generated
	 */
	EList<FSFolder> getFolders();

	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.filesystem.FSFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFSFolder_Files()
	 * @model containment="true"
	 * @generated
	 */
	EList<FSFile> getFiles();

} // FSFolder
