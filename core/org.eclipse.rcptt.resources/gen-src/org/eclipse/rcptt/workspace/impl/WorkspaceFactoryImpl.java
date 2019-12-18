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
package org.eclipse.rcptt.workspace.impl;

import org.eclipse.rcptt.workspace.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkspaceFactoryImpl extends EFactoryImpl implements WorkspaceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkspaceFactory init() {
		try {
			WorkspaceFactory theWorkspaceFactory = (WorkspaceFactory)EPackage.Registry.INSTANCE.getEFactory(WorkspacePackage.eNS_URI);
			if (theWorkspaceFactory != null) {
				return theWorkspaceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkspaceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorkspacePackage.WORKSPACE_CONTEXT: return createWorkspaceContext();
			case WorkspacePackage.WORKSPACE_VERIFICATION: return createWorkspaceVerification();
			case WorkspacePackage.WS_FILE: return createWSFile();
			case WorkspacePackage.WS_FOLDER: return createWSFolder();
			case WorkspacePackage.WS_PROJECT: return createWSProject();
			case WorkspacePackage.WS_ROOT: return createWSRoot();
			case WorkspacePackage.WS_LINK: return createWSLink();
			case WorkspacePackage.WS_FILE_LINK: return createWSFileLink();
			case WorkspacePackage.WS_FOLDER_LINK: return createWSFolderLink();
			case WorkspacePackage.WS_PROJECT_LINK: return createWSProjectLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceContext createWorkspaceContext() {
		WorkspaceContextImpl workspaceContext = new WorkspaceContextImpl();
		return workspaceContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSFile createWSFile() {
		WSFileImpl wsFile = new WSFileImpl();
		return wsFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSFolder createWSFolder() {
		WSFolderImpl wsFolder = new WSFolderImpl();
		return wsFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSProject createWSProject() {
		WSProjectImpl wsProject = new WSProjectImpl();
		return wsProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSRoot createWSRoot() {
		WSRootImpl wsRoot = new WSRootImpl();
		return wsRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSLink createWSLink() {
		WSLinkImpl wsLink = new WSLinkImpl();
		return wsLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSFileLink createWSFileLink() {
		WSFileLinkImpl wsFileLink = new WSFileLinkImpl();
		return wsFileLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSFolderLink createWSFolderLink() {
		WSFolderLinkImpl wsFolderLink = new WSFolderLinkImpl();
		return wsFolderLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSProjectLink createWSProjectLink() {
		WSProjectLinkImpl wsProjectLink = new WSProjectLinkImpl();
		return wsProjectLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceVerification createWorkspaceVerification() {
		WorkspaceVerificationImpl workspaceVerification = new WorkspaceVerificationImpl();
		return workspaceVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspacePackage getWorkspacePackage() {
		return (WorkspacePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorkspacePackage getPackage() {
		return WorkspacePackage.eINSTANCE;
	}

} //WorkspaceFactoryImpl
