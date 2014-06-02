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

import org.eclipse.rcptt.core.scenario.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.filesystem.FilesystemContext#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.filesystem.FilesystemContext#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.rcptt.filesystem.FilesystemContext#isClear <em>Clear</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFilesystemContext()
 * @model
 * @generated
 */
public interface FilesystemContext extends Context {

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
	 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFilesystemContext_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.filesystem.FilesystemContext#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(FSFolder)
	 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFilesystemContext_Root()
	 * @model containment="true"
	 * @generated
	 */
	FSFolder getRoot();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.filesystem.FilesystemContext#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(FSFolder value);

	/**
	 * Returns the value of the '<em><b>Clear</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear</em>' attribute.
	 * @see #setClear(boolean)
	 * @see org.eclipse.rcptt.filesystem.FilesystemPackage#getFilesystemContext_Clear()
	 * @model default="true"
	 * @generated
	 */
	boolean isClear();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.filesystem.FilesystemContext#isClear <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear</em>' attribute.
	 * @see #isClear()
	 * @generated
	 */
	void setClear(boolean value);
} // FilesystemContext
