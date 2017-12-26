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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.workspace.WorkspaceFactory
 * @model kind="package"
 * @generated
 */
public interface WorkspacePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workspace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/ctx/workspace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ctx.workspace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkspacePackage eINSTANCE = org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.WorkspaceData <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.WorkspaceData
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWorkspaceData()
	 * @generated
	 */
	int WORKSPACE_DATA = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA__CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WorkspaceContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WorkspaceContextImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWorkspaceContext()
	 * @generated
	 */
	int WORKSPACE_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__NAME = ScenarioPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__VERSION = ScenarioPackage.CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__ID = ScenarioPackage.CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__DESCRIPTION = ScenarioPackage.CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__TAGS = ScenarioPackage.CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__ATTACHMENTS = ScenarioPackage.CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__CONTENT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__LOCATION = ScenarioPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clear Workspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__CLEAR_WORKSPACE = ScenarioPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ignored By Clear Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT__IGNORED_BY_CLEAR_PATTERN = ScenarioPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_CONTEXT_FEATURE_COUNT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSResourceImpl <em>WS Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSResourceImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSResource()
	 * @generated
	 */
	int WS_RESOURCE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSContainerImpl <em>WS Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSContainerImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSContainer()
	 * @generated
	 */
	int WS_CONTAINER = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSFileImpl <em>WS File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSFileImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFile()
	 * @generated
	 */
	int WS_FILE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSFolderImpl <em>WS Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSFolderImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFolder()
	 * @generated
	 */
	int WS_FOLDER = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSProjectImpl <em>WS Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSProjectImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSProject()
	 * @generated
	 */
	int WS_PROJECT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSRootImpl <em>WS Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSRootImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSRoot()
	 * @generated
	 */
	int WS_ROOT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSLinkImpl <em>WS Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSLinkImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSLink()
	 * @generated
	 */
	int WS_LINK = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSFileLinkImpl <em>WS File Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSFileLinkImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFileLink()
	 * @generated
	 */
	int WS_FILE_LINK = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSFolderLinkImpl <em>WS Folder Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSFolderLinkImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFolderLink()
	 * @generated
	 */
	int WS_FOLDER_LINK = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WSProjectLinkImpl <em>WS Project Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WSProjectLinkImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSProjectLink()
	 * @generated
	 */
	int WS_PROJECT_LINK = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl <em>Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl
	 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWorkspaceVerification()
	 * @generated
	 */
	int WORKSPACE_VERIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__NAME = ScenarioPackage.VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__VERSION = ScenarioPackage.VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__ID = ScenarioPackage.VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__DESCRIPTION = ScenarioPackage.VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__TAGS = ScenarioPackage.VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__ATTACHMENTS = ScenarioPackage.VERIFICATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__CONTENT = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__LOCATION = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allow Uncaptured Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ignored Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__IGNORED_LINES = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ignore White Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION__IGNORE_WHITE_SPACE = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_VERIFICATION_FEATURE_COUNT = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_RESOURCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>WS Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_CONTAINER__NAME = WS_RESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>WS Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_CONTAINER_FEATURE_COUNT = WS_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE__NAME = WS_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Content URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE__CONTENT_URI = WS_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE__CONTENT = WS_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE__EXECUTABLE = WS_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>WS File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE_FEATURE_COUNT = WS_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER__NAME = WS_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER__FILES = WS_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER__FOLDERS = WS_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Folder Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER__FOLDER_LINKS = WS_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER__FILE_LINKS = WS_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>WS Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_FEATURE_COUNT = WS_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT__NAME = WS_FOLDER__NAME;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT__FILES = WS_FOLDER__FILES;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT__FOLDERS = WS_FOLDER__FOLDERS;

	/**
	 * The feature id for the '<em><b>Folder Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT__FOLDER_LINKS = WS_FOLDER__FOLDER_LINKS;

	/**
	 * The feature id for the '<em><b>File Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT__FILE_LINKS = WS_FOLDER__FILE_LINKS;

	/**
	 * The number of structural features of the '<em>WS Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_FEATURE_COUNT = WS_FOLDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_ROOT__NAME = WS_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_ROOT__PROJECTS = WS_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_ROOT__PROJECT_LINKS = WS_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>WS Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_ROOT_FEATURE_COUNT = WS_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_LINK__NAME = WS_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_LINK__PROJECT = WS_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_LINK__PATH = WS_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>WS Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_LINK_FEATURE_COUNT = WS_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE_LINK__NAME = WS_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE_LINK__PROJECT = WS_LINK__PROJECT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE_LINK__PATH = WS_LINK__PATH;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE_LINK__CONTENT = WS_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>WS File Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FILE_LINK_FEATURE_COUNT = WS_LINK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_LINK__NAME = WS_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_LINK__PROJECT = WS_LINK__PROJECT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_LINK__PATH = WS_LINK__PATH;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_LINK__FOLDERS = WS_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_LINK__FILES = WS_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>WS Folder Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_FOLDER_LINK_FEATURE_COUNT = WS_LINK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_LINK__NAME = WS_FOLDER_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_LINK__PROJECT = WS_FOLDER_LINK__PROJECT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_LINK__PATH = WS_FOLDER_LINK__PATH;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_LINK__FOLDERS = WS_FOLDER_LINK__FOLDERS;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_LINK__FILES = WS_FOLDER_LINK__FILES;

	/**
	 * The number of structural features of the '<em>WS Project Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WS_PROJECT_LINK_FEATURE_COUNT = WS_FOLDER_LINK_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WorkspaceData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceData
	 * @generated
	 */
	EClass getWorkspaceData();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.workspace.WorkspaceData#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceData#getContent()
	 * @see #getWorkspaceData()
	 * @generated
	 */
	EReference getWorkspaceData_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WorkspaceData#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceData#getLocation()
	 * @see #getWorkspaceData()
	 * @generated
	 */
	EAttribute getWorkspaceData_Location();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WorkspaceContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceContext
	 * @generated
	 */
	EClass getWorkspaceContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WorkspaceContext#isClearWorkspace <em>Clear Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Workspace</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceContext#isClearWorkspace()
	 * @see #getWorkspaceContext()
	 * @generated
	 */
	EAttribute getWorkspaceContext_ClearWorkspace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WorkspaceContext#getIgnoredByClearPattern <em>Ignored By Clear Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignored By Clear Pattern</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceContext#getIgnoredByClearPattern()
	 * @see #getWorkspaceContext()
	 * @generated
	 */
	EAttribute getWorkspaceContext_IgnoredByClearPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSResource <em>WS Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Resource</em>'.
	 * @see org.eclipse.rcptt.workspace.WSResource
	 * @generated
	 */
	EClass getWSResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.workspace.WSResource#getName()
	 * @see #getWSResource()
	 * @generated
	 */
	EAttribute getWSResource_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSContainer <em>WS Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Container</em>'.
	 * @see org.eclipse.rcptt.workspace.WSContainer
	 * @generated
	 */
	EClass getWSContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSFile <em>WS File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS File</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFile
	 * @generated
	 */
	EClass getWSFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSFile#getContentURI <em>Content URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content URI</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFile#getContentURI()
	 * @see #getWSFile()
	 * @generated
	 */
	EAttribute getWSFile_ContentURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSFile#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFile#getContent()
	 * @see #getWSFile()
	 * @generated
	 */
	EAttribute getWSFile_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSFile#isExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFile#isExecutable()
	 * @see #getWSFile()
	 * @generated
	 */
	EAttribute getWSFile_Executable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSFolder <em>WS Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Folder</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolder
	 * @generated
	 */
	EClass getWSFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSFolder#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolder#getFiles()
	 * @see #getWSFolder()
	 * @generated
	 */
	EReference getWSFolder_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSFolder#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolder#getFolders()
	 * @see #getWSFolder()
	 * @generated
	 */
	EReference getWSFolder_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSFolder#getFolderLinks <em>Folder Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folder Links</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolder#getFolderLinks()
	 * @see #getWSFolder()
	 * @generated
	 */
	EReference getWSFolder_FolderLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSFolder#getFileLinks <em>File Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File Links</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolder#getFileLinks()
	 * @see #getWSFolder()
	 * @generated
	 */
	EReference getWSFolder_FileLinks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSProject <em>WS Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Project</em>'.
	 * @see org.eclipse.rcptt.workspace.WSProject
	 * @generated
	 */
	EClass getWSProject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSRoot <em>WS Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Root</em>'.
	 * @see org.eclipse.rcptt.workspace.WSRoot
	 * @generated
	 */
	EClass getWSRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSRoot#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see org.eclipse.rcptt.workspace.WSRoot#getProjects()
	 * @see #getWSRoot()
	 * @generated
	 */
	EReference getWSRoot_Projects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSRoot#getProjectLinks <em>Project Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Project Links</em>'.
	 * @see org.eclipse.rcptt.workspace.WSRoot#getProjectLinks()
	 * @see #getWSRoot()
	 * @generated
	 */
	EReference getWSRoot_ProjectLinks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSLink <em>WS Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Link</em>'.
	 * @see org.eclipse.rcptt.workspace.WSLink
	 * @generated
	 */
	EClass getWSLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSLink#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see org.eclipse.rcptt.workspace.WSLink#getProject()
	 * @see #getWSLink()
	 * @generated
	 */
	EAttribute getWSLink_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSLink#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.workspace.WSLink#getPath()
	 * @see #getWSLink()
	 * @generated
	 */
	EAttribute getWSLink_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSFileLink <em>WS File Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS File Link</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFileLink
	 * @generated
	 */
	EClass getWSFileLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WSFileLink#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFileLink#getContent()
	 * @see #getWSFileLink()
	 * @generated
	 */
	EAttribute getWSFileLink_Content();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSFolderLink <em>WS Folder Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Folder Link</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolderLink
	 * @generated
	 */
	EClass getWSFolderLink();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSFolderLink#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolderLink#getFolders()
	 * @see #getWSFolderLink()
	 * @generated
	 */
	EReference getWSFolderLink_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.workspace.WSFolderLink#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see org.eclipse.rcptt.workspace.WSFolderLink#getFiles()
	 * @see #getWSFolderLink()
	 * @generated
	 */
	EReference getWSFolderLink_Files();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WSProjectLink <em>WS Project Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WS Project Link</em>'.
	 * @see org.eclipse.rcptt.workspace.WSProjectLink
	 * @generated
	 */
	EClass getWSProjectLink();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.workspace.WorkspaceVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceVerification
	 * @generated
	 */
	EClass getWorkspaceVerification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WorkspaceVerification#isAllowUncapturedFiles <em>Allow Uncaptured Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Uncaptured Files</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceVerification#isAllowUncapturedFiles()
	 * @see #getWorkspaceVerification()
	 * @generated
	 */
	EAttribute getWorkspaceVerification_AllowUncapturedFiles();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WorkspaceVerification#getIgnoredLines <em>Ignored Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignored Lines</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceVerification#getIgnoredLines()
	 * @see #getWorkspaceVerification()
	 * @generated
	 */
	EAttribute getWorkspaceVerification_IgnoredLines();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.workspace.WorkspaceVerification#isIgnoreWhiteSpace <em>Ignore White Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore White Space</em>'.
	 * @see org.eclipse.rcptt.workspace.WorkspaceVerification#isIgnoreWhiteSpace()
	 * @see #getWorkspaceVerification()
	 * @generated
	 */
	EAttribute getWorkspaceVerification_IgnoreWhiteSpace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkspaceFactory getWorkspaceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.WorkspaceData <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.WorkspaceData
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWorkspaceData()
		 * @generated
		 */
		EClass WORKSPACE_DATA = eINSTANCE.getWorkspaceData();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_DATA__CONTENT = eINSTANCE.getWorkspaceData_Content();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_DATA__LOCATION = eINSTANCE.getWorkspaceData_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WorkspaceContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WorkspaceContextImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWorkspaceContext()
		 * @generated
		 */
		EClass WORKSPACE_CONTEXT = eINSTANCE.getWorkspaceContext();

		/**
		 * The meta object literal for the '<em><b>Clear Workspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_CONTEXT__CLEAR_WORKSPACE = eINSTANCE.getWorkspaceContext_ClearWorkspace();

		/**
		 * The meta object literal for the '<em><b>Ignored By Clear Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_CONTEXT__IGNORED_BY_CLEAR_PATTERN = eINSTANCE.getWorkspaceContext_IgnoredByClearPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSResourceImpl <em>WS Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSResourceImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSResource()
		 * @generated
		 */
		EClass WS_RESOURCE = eINSTANCE.getWSResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_RESOURCE__NAME = eINSTANCE.getWSResource_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSContainerImpl <em>WS Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSContainerImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSContainer()
		 * @generated
		 */
		EClass WS_CONTAINER = eINSTANCE.getWSContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSFileImpl <em>WS File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSFileImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFile()
		 * @generated
		 */
		EClass WS_FILE = eINSTANCE.getWSFile();

		/**
		 * The meta object literal for the '<em><b>Content URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_FILE__CONTENT_URI = eINSTANCE.getWSFile_ContentURI();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_FILE__CONTENT = eINSTANCE.getWSFile_Content();

		/**
		 * The meta object literal for the '<em><b>Executable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_FILE__EXECUTABLE = eINSTANCE.getWSFile_Executable();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSFolderImpl <em>WS Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSFolderImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFolder()
		 * @generated
		 */
		EClass WS_FOLDER = eINSTANCE.getWSFolder();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_FOLDER__FILES = eINSTANCE.getWSFolder_Files();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_FOLDER__FOLDERS = eINSTANCE.getWSFolder_Folders();

		/**
		 * The meta object literal for the '<em><b>Folder Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_FOLDER__FOLDER_LINKS = eINSTANCE.getWSFolder_FolderLinks();

		/**
		 * The meta object literal for the '<em><b>File Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_FOLDER__FILE_LINKS = eINSTANCE.getWSFolder_FileLinks();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSProjectImpl <em>WS Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSProjectImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSProject()
		 * @generated
		 */
		EClass WS_PROJECT = eINSTANCE.getWSProject();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSRootImpl <em>WS Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSRootImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSRoot()
		 * @generated
		 */
		EClass WS_ROOT = eINSTANCE.getWSRoot();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_ROOT__PROJECTS = eINSTANCE.getWSRoot_Projects();

		/**
		 * The meta object literal for the '<em><b>Project Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_ROOT__PROJECT_LINKS = eINSTANCE.getWSRoot_ProjectLinks();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSLinkImpl <em>WS Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSLinkImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSLink()
		 * @generated
		 */
		EClass WS_LINK = eINSTANCE.getWSLink();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_LINK__PROJECT = eINSTANCE.getWSLink_Project();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_LINK__PATH = eINSTANCE.getWSLink_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSFileLinkImpl <em>WS File Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSFileLinkImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFileLink()
		 * @generated
		 */
		EClass WS_FILE_LINK = eINSTANCE.getWSFileLink();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WS_FILE_LINK__CONTENT = eINSTANCE.getWSFileLink_Content();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSFolderLinkImpl <em>WS Folder Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSFolderLinkImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSFolderLink()
		 * @generated
		 */
		EClass WS_FOLDER_LINK = eINSTANCE.getWSFolderLink();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_FOLDER_LINK__FOLDERS = eINSTANCE.getWSFolderLink_Folders();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WS_FOLDER_LINK__FILES = eINSTANCE.getWSFolderLink_Files();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WSProjectLinkImpl <em>WS Project Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WSProjectLinkImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWSProjectLink()
		 * @generated
		 */
		EClass WS_PROJECT_LINK = eINSTANCE.getWSProjectLink();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl <em>Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl
		 * @see org.eclipse.rcptt.workspace.impl.WorkspacePackageImpl#getWorkspaceVerification()
		 * @generated
		 */
		EClass WORKSPACE_VERIFICATION = eINSTANCE.getWorkspaceVerification();

		/**
		 * The meta object literal for the '<em><b>Allow Uncaptured Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES = eINSTANCE.getWorkspaceVerification_AllowUncapturedFiles();

		/**
		 * The meta object literal for the '<em><b>Ignored Lines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_VERIFICATION__IGNORED_LINES = eINSTANCE.getWorkspaceVerification_IgnoredLines();

		/**
		 * The meta object literal for the '<em><b>Ignore White Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE_VERIFICATION__IGNORE_WHITE_SPACE = eINSTANCE.getWorkspaceVerification_IgnoreWhiteSpace();

	}

} //WorkspacePackage
