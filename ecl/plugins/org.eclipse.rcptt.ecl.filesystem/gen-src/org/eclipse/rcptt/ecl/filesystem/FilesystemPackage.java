/*******************************************************************************
 * Copyright (c) 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.filesystem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.rcptt.ecl.core.CorePackage;

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
 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemFactory
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
	String eNS_URI = "http://www.eclipse.org/ecl/filesystem.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FilesystemPackage eINSTANCE = org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.CopyFileImpl <em>Copy File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.CopyFileImpl
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getCopyFile()
	 * @generated
	 */
	int COPY_FILE = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FILE__SOURCE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FILE__DESTINATION = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FILE__NAME = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Copy File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.UriFromPathImpl <em>Uri From Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.UriFromPathImpl
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getUriFromPath()
	 * @generated
	 */
	int URI_FROM_PATH = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_FROM_PATH__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_FROM_PATH__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_FROM_PATH__PATH = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Uri From Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_FROM_PATH_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.GetFileImpl <em>Get File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.GetFileImpl
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getGetFile()
	 * @generated
	 */
	int GET_FILE = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.FileImpl
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__URI = 0;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.DeleteFileImpl <em>Delete File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.DeleteFileImpl
	 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getDeleteFile()
	 * @generated
	 */
	int DELETE_FILE = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.filesystem.CopyFile <em>Copy File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copy File</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.CopyFile
	 * @generated
	 */
	EClass getCopyFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.CopyFile#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.CopyFile#getSource()
	 * @see #getCopyFile()
	 * @generated
	 */
	EAttribute getCopyFile_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.CopyFile#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.CopyFile#getDestination()
	 * @see #getCopyFile()
	 * @generated
	 */
	EAttribute getCopyFile_Destination();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.CopyFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.CopyFile#getName()
	 * @see #getCopyFile()
	 * @generated
	 */
	EAttribute getCopyFile_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.filesystem.UriFromPath <em>Uri From Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uri From Path</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.UriFromPath
	 * @generated
	 */
	EClass getUriFromPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.UriFromPath#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.UriFromPath#getPath()
	 * @see #getUriFromPath()
	 * @generated
	 */
	EAttribute getUriFromPath_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.filesystem.GetFile <em>Get File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get File</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.GetFile
	 * @generated
	 */
	EClass getGetFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.GetFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.GetFile#getUri()
	 * @see #getGetFile()
	 * @generated
	 */
	EAttribute getGetFile_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.filesystem.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.File#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.File#getUri()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.filesystem.DeleteFile <em>Delete File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete File</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.DeleteFile
	 * @generated
	 */
	EClass getDeleteFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.filesystem.DeleteFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.filesystem.DeleteFile#getUri()
	 * @see #getDeleteFile()
	 * @generated
	 */
	EAttribute getDeleteFile_Uri();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.CopyFileImpl <em>Copy File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.CopyFileImpl
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getCopyFile()
		 * @generated
		 */
		EClass COPY_FILE = eINSTANCE.getCopyFile();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_FILE__SOURCE = eINSTANCE.getCopyFile_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_FILE__DESTINATION = eINSTANCE.getCopyFile_Destination();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_FILE__NAME = eINSTANCE.getCopyFile_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.UriFromPathImpl <em>Uri From Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.UriFromPathImpl
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getUriFromPath()
		 * @generated
		 */
		EClass URI_FROM_PATH = eINSTANCE.getUriFromPath();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_FROM_PATH__PATH = eINSTANCE.getUriFromPath_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.GetFileImpl <em>Get File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.GetFileImpl
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getGetFile()
		 * @generated
		 */
		EClass GET_FILE = eINSTANCE.getGetFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_FILE__URI = eINSTANCE.getGetFile_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.FileImpl
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__URI = eINSTANCE.getFile_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.filesystem.impl.DeleteFileImpl <em>Delete File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.DeleteFileImpl
		 * @see org.eclipse.rcptt.ecl.filesystem.impl.FilesystemPackageImpl#getDeleteFile()
		 * @generated
		 */
		EClass DELETE_FILE = eINSTANCE.getDeleteFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETE_FILE__URI = eINSTANCE.getDeleteFile_Uri();

	}

} //FilesystemPackage
