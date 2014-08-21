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

package org.eclipse.rcptt.ecl.filesystem.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.ecl.filesystem.CopyFile;
import org.eclipse.rcptt.ecl.filesystem.DeleteFile;
import org.eclipse.rcptt.ecl.filesystem.File;
import org.eclipse.rcptt.ecl.filesystem.FilesystemFactory;
import org.eclipse.rcptt.ecl.filesystem.FilesystemPackage;
import org.eclipse.rcptt.ecl.filesystem.GetFile;
import org.eclipse.rcptt.ecl.filesystem.UriFromPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FilesystemPackageImpl extends EPackageImpl implements FilesystemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriFromPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteFileEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FilesystemPackageImpl() {
		super(eNS_URI, FilesystemFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FilesystemPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FilesystemPackage init() {
		if (isInited) return (FilesystemPackage)EPackage.Registry.INSTANCE.getEPackage(FilesystemPackage.eNS_URI);

		// Obtain or create and register package
		FilesystemPackageImpl theFilesystemPackage = (FilesystemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FilesystemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FilesystemPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFilesystemPackage.createPackageContents();

		// Initialize created meta-data
		theFilesystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFilesystemPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FilesystemPackage.eNS_URI, theFilesystemPackage);
		return theFilesystemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopyFile() {
		return copyFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyFile_Source() {
		return (EAttribute)copyFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyFile_Destination() {
		return (EAttribute)copyFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyFile_Name() {
		return (EAttribute)copyFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUriFromPath() {
		return uriFromPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUriFromPath_Path() {
		return (EAttribute)uriFromPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetFile() {
		return getFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetFile_Uri() {
		return (EAttribute)getFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFile() {
		return fileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_Uri() {
		return (EAttribute)fileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteFile() {
		return deleteFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeleteFile_Path() {
		return (EAttribute)deleteFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilesystemFactory getFilesystemFactory() {
		return (FilesystemFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		copyFileEClass = createEClass(COPY_FILE);
		createEAttribute(copyFileEClass, COPY_FILE__SOURCE);
		createEAttribute(copyFileEClass, COPY_FILE__DESTINATION);
		createEAttribute(copyFileEClass, COPY_FILE__NAME);

		uriFromPathEClass = createEClass(URI_FROM_PATH);
		createEAttribute(uriFromPathEClass, URI_FROM_PATH__PATH);

		getFileEClass = createEClass(GET_FILE);
		createEAttribute(getFileEClass, GET_FILE__URI);

		fileEClass = createEClass(FILE);
		createEAttribute(fileEClass, FILE__URI);

		deleteFileEClass = createEClass(DELETE_FILE);
		createEAttribute(deleteFileEClass, DELETE_FILE__PATH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		copyFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		uriFromPathEClass.getESuperTypes().add(theCorePackage.getCommand());
		getFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		deleteFileEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(copyFileEClass, CopyFile.class, "CopyFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCopyFile_Source(), theEcorePackage.getEString(), "source", null, 1, 1, CopyFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyFile_Destination(), theEcorePackage.getEString(), "destination", null, 1, 1, CopyFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyFile_Name(), theEcorePackage.getEString(), "name", null, 0, 1, CopyFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uriFromPathEClass, UriFromPath.class, "UriFromPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUriFromPath_Path(), theEcorePackage.getEString(), "path", null, 1, 1, UriFromPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getFileEClass, GetFile.class, "GetFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetFile_Uri(), theEcorePackage.getEString(), "uri", null, 1, 1, GetFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileEClass, File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFile_Uri(), theEcorePackage.getEString(), "uri", null, 1, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteFileEClass, DeleteFile.class, "DeleteFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeleteFile_Path(), theEcorePackage.getEString(), "path", null, 1, 1, DeleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/docs</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocsAnnotations() {
		String source = "http://www.eclipse.org/ecl/docs";	
		addAnnotation
		  (copyFileEClass, 
		   source, 
		   new String[] {
			 "description", "Copies <code>source</code> file or directory into <code>destination</code> directory, optionally giving it a new <code>name</code>.",
			 "returns", "Nothing.",
			 "example", "copy-file -source \"/Users/Ulik_MacAir/aut-Q7-1.3.12-B2/Project/t.test\" \n-destination \"/Users/Ulik_MacAir/aut-Q7-1.3.12-B2/Project/Folder\" -name \"Clone.test\""
		   });	
		addAnnotation
		  (getCopyFile_Source(), 
		   source, 
		   new String[] {
			 "description", "Source file or directory."
		   });	
		addAnnotation
		  (getCopyFile_Destination(), 
		   source, 
		   new String[] {
			 "description", "Destination directory under which the <code>source</code> file or directory will be stored."
		   });	
		addAnnotation
		  (getCopyFile_Name(), 
		   source, 
		   new String[] {
			 "description", "New name for the <code>source</code> file or directory."
		   });	
		addAnnotation
		  (uriFromPathEClass, 
		   source, 
		   new String[] {
			 "returns", "URI string. Platform independent (can be used on every OS).",
			 "example", "get-file [uri-from-path \"C:\\windows\"] | get exists"
		   });	
		addAnnotation
		  (getUriFromPath_Path(), 
		   source, 
		   new String[] {
			 "description", "Platform-dependednt filesystem path.",
			 "example", "C:\\windows\\system32"
		   });	
		addAnnotation
		  (getFileEClass, 
		   source, 
		   new String[] {
			 "returns", "A File object.  Properties: uri, name, exists, children.",
			 "description", "Creates a file object by its URI.",
			 "example", "get-file \"file:/C:/Windows/System32\"  | get exists"
		   });	
		addAnnotation
		  (getGetFile_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI of a file or directory. Can be created manually, or with uri-from-path.",
			 "example", "file:/C:/windows/system32"
		   });	
		addAnnotation
		  (deleteFileEClass, 
		   source, 
		   new String[] {
			 "description", "Deletes file or folder",
			 "returns", "Nothing",
			 "example", "delete-file \"C:/temp/t.test\""
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/input</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInputAnnotations() {
		String source = "http://www.eclipse.org/ecl/input";	
		addAnnotation
		  (getUriFromPath_Path(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getGetFile_Uri(), 
		   source, 
		   new String[] {
		   });
	}

} //FilesystemPackageImpl
