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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.workspace.WorkspacePackage
 * @generated
 */
public interface WorkspaceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkspaceFactory eINSTANCE = org.eclipse.rcptt.workspace.impl.WorkspaceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	WorkspaceContext createWorkspaceContext();

	/**
	 * Returns a new object of class '<em>WS File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS File</em>'.
	 * @generated
	 */
	WSFile createWSFile();

	/**
	 * Returns a new object of class '<em>WS Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS Folder</em>'.
	 * @generated
	 */
	WSFolder createWSFolder();

	/**
	 * Returns a new object of class '<em>WS Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS Project</em>'.
	 * @generated
	 */
	WSProject createWSProject();

	/**
	 * Returns a new object of class '<em>WS Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS Root</em>'.
	 * @generated
	 */
	WSRoot createWSRoot();

	/**
	 * Returns a new object of class '<em>WS Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS Link</em>'.
	 * @generated
	 */
	WSLink createWSLink();

	/**
	 * Returns a new object of class '<em>WS File Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS File Link</em>'.
	 * @generated
	 */
	WSFileLink createWSFileLink();

	/**
	 * Returns a new object of class '<em>WS Folder Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS Folder Link</em>'.
	 * @generated
	 */
	WSFolderLink createWSFolderLink();

	/**
	 * Returns a new object of class '<em>WS Project Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WS Project Link</em>'.
	 * @generated
	 */
	WSProjectLink createWSProjectLink();

	/**
	 * Returns a new object of class '<em>Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verification</em>'.
	 * @generated
	 */
	WorkspaceVerification createWorkspaceVerification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorkspacePackage getWorkspacePackage();

} //WorkspaceFactory
