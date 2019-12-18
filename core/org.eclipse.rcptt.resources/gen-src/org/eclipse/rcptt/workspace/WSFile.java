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
package org.eclipse.rcptt.workspace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WS File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFile#getContentURI <em>Content URI</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFile#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.WSFile#isExecutable <em>Executable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFile()
 * @model
 * @generated
 */
public interface WSFile extends WSResource {
	/**
	 * Returns the value of the '<em><b>Content URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content URI</em>' attribute.
	 * @see #setContentURI(String)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFile_ContentURI()
	 * @model
	 * @generated
	 */
	String getContentURI();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WSFile#getContentURI <em>Content URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content URI</em>' attribute.
	 * @see #getContentURI()
	 * @generated
	 */
	void setContentURI(String value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(byte[])
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFile_Content()
	 * @model
	 * @generated
	 */
	byte[] getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WSFile#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(byte[] value);

	/**
	 * Returns the value of the '<em><b>Executable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable</em>' attribute.
	 * @see #setExecutable(boolean)
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#getWSFile_Executable()
	 * @model default="false"
	 * @generated
	 */
	boolean isExecutable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.workspace.WSFile#isExecutable <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable</em>' attribute.
	 * @see #isExecutable()
	 * @generated
	 */
	void setExecutable(boolean value);

} // WSFile
