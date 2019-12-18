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
package org.eclipse.rcptt.filesystem;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.rcptt.filesystem.FilesystemFactory
 * @model kind="package"
 * @generated
 */
public interface FilesystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "filesystem";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/ctx/filesystem";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ctx.filesystem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FilesystemPackage eINSTANCE = org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.filesystem.impl.FilesystemContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.filesystem.impl.FilesystemContextImpl
	 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFilesystemContext()
	 * @generated
	 */
	int FILESYSTEM_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__NAME = ScenarioPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__VERSION = ScenarioPackage.CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__ID = ScenarioPackage.CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__DESCRIPTION = ScenarioPackage.CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__TAGS = ScenarioPackage.CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__ATTACHMENTS = ScenarioPackage.CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__PATH = ScenarioPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__ROOT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT__CLEAR = ScenarioPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_CONTEXT_FEATURE_COUNT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.filesystem.impl.FSResourceImpl <em>FS Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.filesystem.impl.FSResourceImpl
	 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSResource()
	 * @generated
	 */
	int FS_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_RESOURCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>FS Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.filesystem.impl.FSFileImpl <em>FS File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.filesystem.impl.FSFileImpl
	 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSFile()
	 * @generated
	 */
	int FS_FILE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FILE__NAME = FS_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FILE__DATA = FS_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FS File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FILE_FEATURE_COUNT = FS_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.filesystem.impl.FSFolderImpl <em>FS Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.filesystem.impl.FSFolderImpl
	 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSFolder()
	 * @generated
	 */
	int FS_FOLDER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FOLDER__NAME = FS_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FOLDER__FOLDERS = FS_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FOLDER__FILES = FS_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FS Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_FOLDER_FEATURE_COUNT = FS_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.filesystem.impl.FSCaptureParamImpl <em>FS Capture Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.filesystem.impl.FSCaptureParamImpl
	 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSCaptureParam()
	 * @generated
	 */
	int FS_CAPTURE_PARAM = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_CAPTURE_PARAM__PATH = 0;

	/**
	 * The feature id for the '<em><b>Clear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_CAPTURE_PARAM__CLEAR = 1;

	/**
	 * The number of structural features of the '<em>FS Capture Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FS_CAPTURE_PARAM_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.filesystem.FilesystemContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.rcptt.filesystem.FilesystemContext
	 * @generated
	 */
	EClass getFilesystemContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.filesystem.FilesystemContext#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.filesystem.FilesystemContext#getPath()
	 * @see #getFilesystemContext()
	 * @generated
	 */
	EAttribute getFilesystemContext_Path();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.filesystem.FilesystemContext#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see org.eclipse.rcptt.filesystem.FilesystemContext#getRoot()
	 * @see #getFilesystemContext()
	 * @generated
	 */
	EReference getFilesystemContext_Root();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.filesystem.FilesystemContext#isClear <em>Clear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear</em>'.
	 * @see org.eclipse.rcptt.filesystem.FilesystemContext#isClear()
	 * @see #getFilesystemContext()
	 * @generated
	 */
	EAttribute getFilesystemContext_Clear();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.filesystem.FSResource <em>FS Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FS Resource</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSResource
	 * @generated
	 */
	EClass getFSResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.filesystem.FSResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSResource#getName()
	 * @see #getFSResource()
	 * @generated
	 */
	EAttribute getFSResource_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.filesystem.FSFile <em>FS File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FS File</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSFile
	 * @generated
	 */
	EClass getFSFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.filesystem.FSFile#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSFile#getData()
	 * @see #getFSFile()
	 * @generated
	 */
	EAttribute getFSFile_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.filesystem.FSFolder <em>FS Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FS Folder</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSFolder
	 * @generated
	 */
	EClass getFSFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.filesystem.FSFolder#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSFolder#getFolders()
	 * @see #getFSFolder()
	 * @generated
	 */
	EReference getFSFolder_Folders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.filesystem.FSFolder#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSFolder#getFiles()
	 * @see #getFSFolder()
	 * @generated
	 */
	EReference getFSFolder_Files();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.filesystem.FSCaptureParam <em>FS Capture Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FS Capture Param</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSCaptureParam
	 * @generated
	 */
	EClass getFSCaptureParam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.filesystem.FSCaptureParam#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSCaptureParam#getPath()
	 * @see #getFSCaptureParam()
	 * @generated
	 */
	EAttribute getFSCaptureParam_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.filesystem.FSCaptureParam#isClear <em>Clear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear</em>'.
	 * @see org.eclipse.rcptt.filesystem.FSCaptureParam#isClear()
	 * @see #getFSCaptureParam()
	 * @generated
	 */
	EAttribute getFSCaptureParam_Clear();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FilesystemFactory getFilesystemFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.filesystem.impl.FilesystemContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.filesystem.impl.FilesystemContextImpl
		 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFilesystemContext()
		 * @generated
		 */
		EClass FILESYSTEM_CONTEXT = eINSTANCE.getFilesystemContext();
		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILESYSTEM_CONTEXT__PATH = eINSTANCE.getFilesystemContext_Path();
		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILESYSTEM_CONTEXT__ROOT = eINSTANCE.getFilesystemContext_Root();
		/**
		 * The meta object literal for the '<em><b>Clear</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILESYSTEM_CONTEXT__CLEAR = eINSTANCE.getFilesystemContext_Clear();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.filesystem.impl.FSResourceImpl <em>FS Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.filesystem.impl.FSResourceImpl
		 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSResource()
		 * @generated
		 */
		EClass FS_RESOURCE = eINSTANCE.getFSResource();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FS_RESOURCE__NAME = eINSTANCE.getFSResource_Name();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.filesystem.impl.FSFileImpl <em>FS File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.filesystem.impl.FSFileImpl
		 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSFile()
		 * @generated
		 */
		EClass FS_FILE = eINSTANCE.getFSFile();
		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FS_FILE__DATA = eINSTANCE.getFSFile_Data();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.filesystem.impl.FSFolderImpl <em>FS Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.filesystem.impl.FSFolderImpl
		 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSFolder()
		 * @generated
		 */
		EClass FS_FOLDER = eINSTANCE.getFSFolder();
		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FS_FOLDER__FOLDERS = eINSTANCE.getFSFolder_Folders();
		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FS_FOLDER__FILES = eINSTANCE.getFSFolder_Files();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.filesystem.impl.FSCaptureParamImpl <em>FS Capture Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.filesystem.impl.FSCaptureParamImpl
		 * @see org.eclipse.rcptt.filesystem.impl.FilesystemPackageImpl#getFSCaptureParam()
		 * @generated
		 */
		EClass FS_CAPTURE_PARAM = eINSTANCE.getFSCaptureParam();
		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FS_CAPTURE_PARAM__PATH = eINSTANCE.getFSCaptureParam_Path();
		/**
		 * The meta object literal for the '<em><b>Clear</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FS_CAPTURE_PARAM__CLEAR = eINSTANCE.getFSCaptureParam_Clear();

	}

} //FilesystemPackage
