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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.workspace.WSContainer;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFileLink;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSFolderLink;
import org.eclipse.rcptt.workspace.WSLink;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSProjectLink;
import org.eclipse.rcptt.workspace.WSResource;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceContext;
import org.eclipse.rcptt.workspace.WorkspaceData;
import org.eclipse.rcptt.workspace.WorkspaceFactory;
import org.eclipse.rcptt.workspace.WorkspacePackage;
import org.eclipse.rcptt.workspace.WorkspaceVerification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkspacePackageImpl extends EPackageImpl implements WorkspacePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsFileLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsFolderLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsProjectLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceVerificationEClass = null;

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
	 * @see org.eclipse.rcptt.workspace.WorkspacePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkspacePackageImpl() {
		super(eNS_URI, WorkspaceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WorkspacePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkspacePackage init() {
		if (isInited) return (WorkspacePackage)EPackage.Registry.INSTANCE.getEPackage(WorkspacePackage.eNS_URI);

		// Obtain or create and register package
		WorkspacePackageImpl theWorkspacePackage = (WorkspacePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkspacePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorkspacePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ScenarioPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWorkspacePackage.createPackageContents();

		// Initialize created meta-data
		theWorkspacePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkspacePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorkspacePackage.eNS_URI, theWorkspacePackage);
		return theWorkspacePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceData() {
		return workspaceDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceData_Content() {
		return (EReference)workspaceDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceData_Location() {
		return (EAttribute)workspaceDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceContext() {
		return workspaceContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceContext_ClearWorkspace() {
		return (EAttribute)workspaceContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceContext_IgnoredByClearPattern() {
		return (EAttribute)workspaceContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSResource() {
		return wsResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSResource_Name() {
		return (EAttribute)wsResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSContainer() {
		return wsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSFile() {
		return wsFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSFile_ContentURI() {
		return (EAttribute)wsFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSFile_Content() {
		return (EAttribute)wsFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSFile_Executable() {
		return (EAttribute)wsFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSFolder() {
		return wsFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSFolder_Files() {
		return (EReference)wsFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSFolder_Folders() {
		return (EReference)wsFolderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSFolder_FolderLinks() {
		return (EReference)wsFolderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSFolder_FileLinks() {
		return (EReference)wsFolderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSProject() {
		return wsProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSRoot() {
		return wsRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSRoot_Projects() {
		return (EReference)wsRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSRoot_ProjectLinks() {
		return (EReference)wsRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSLink() {
		return wsLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSLink_Project() {
		return (EAttribute)wsLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSLink_Path() {
		return (EAttribute)wsLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSFileLink() {
		return wsFileLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSFileLink_Content() {
		return (EAttribute)wsFileLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSFolderLink() {
		return wsFolderLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSFolderLink_Folders() {
		return (EReference)wsFolderLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSFolderLink_Files() {
		return (EReference)wsFolderLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSProjectLink() {
		return wsProjectLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceVerification() {
		return workspaceVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceVerification_AllowUncapturedFiles() {
		return (EAttribute)workspaceVerificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceVerification_NotAllowedPatterns() {
		return (EAttribute)workspaceVerificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceVerification_IgnoredLines() {
		return (EAttribute)workspaceVerificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspaceVerification_IgnoreWhiteSpace() {
		return (EAttribute)workspaceVerificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceFactory getWorkspaceFactory() {
		return (WorkspaceFactory)getEFactoryInstance();
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
		workspaceDataEClass = createEClass(WORKSPACE_DATA);
		createEReference(workspaceDataEClass, WORKSPACE_DATA__CONTENT);
		createEAttribute(workspaceDataEClass, WORKSPACE_DATA__LOCATION);

		workspaceContextEClass = createEClass(WORKSPACE_CONTEXT);
		createEAttribute(workspaceContextEClass, WORKSPACE_CONTEXT__CLEAR_WORKSPACE);
		createEAttribute(workspaceContextEClass, WORKSPACE_CONTEXT__IGNORED_BY_CLEAR_PATTERN);

		workspaceVerificationEClass = createEClass(WORKSPACE_VERIFICATION);
		createEAttribute(workspaceVerificationEClass, WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES);
		createEAttribute(workspaceVerificationEClass, WORKSPACE_VERIFICATION__NOT_ALLOWED_PATTERNS);
		createEAttribute(workspaceVerificationEClass, WORKSPACE_VERIFICATION__IGNORED_LINES);
		createEAttribute(workspaceVerificationEClass, WORKSPACE_VERIFICATION__IGNORE_WHITE_SPACE);

		wsResourceEClass = createEClass(WS_RESOURCE);
		createEAttribute(wsResourceEClass, WS_RESOURCE__NAME);

		wsContainerEClass = createEClass(WS_CONTAINER);

		wsFileEClass = createEClass(WS_FILE);
		createEAttribute(wsFileEClass, WS_FILE__CONTENT_URI);
		createEAttribute(wsFileEClass, WS_FILE__CONTENT);
		createEAttribute(wsFileEClass, WS_FILE__EXECUTABLE);

		wsFolderEClass = createEClass(WS_FOLDER);
		createEReference(wsFolderEClass, WS_FOLDER__FILES);
		createEReference(wsFolderEClass, WS_FOLDER__FOLDERS);
		createEReference(wsFolderEClass, WS_FOLDER__FOLDER_LINKS);
		createEReference(wsFolderEClass, WS_FOLDER__FILE_LINKS);

		wsProjectEClass = createEClass(WS_PROJECT);

		wsRootEClass = createEClass(WS_ROOT);
		createEReference(wsRootEClass, WS_ROOT__PROJECTS);
		createEReference(wsRootEClass, WS_ROOT__PROJECT_LINKS);

		wsLinkEClass = createEClass(WS_LINK);
		createEAttribute(wsLinkEClass, WS_LINK__PROJECT);
		createEAttribute(wsLinkEClass, WS_LINK__PATH);

		wsFileLinkEClass = createEClass(WS_FILE_LINK);
		createEAttribute(wsFileLinkEClass, WS_FILE_LINK__CONTENT);

		wsFolderLinkEClass = createEClass(WS_FOLDER_LINK);
		createEReference(wsFolderLinkEClass, WS_FOLDER_LINK__FOLDERS);
		createEReference(wsFolderLinkEClass, WS_FOLDER_LINK__FILES);

		wsProjectLinkEClass = createEClass(WS_PROJECT_LINK);
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
		ScenarioPackage theScenarioPackage = (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		workspaceContextEClass.getESuperTypes().add(theScenarioPackage.getContext());
		workspaceContextEClass.getESuperTypes().add(this.getWorkspaceData());
		workspaceVerificationEClass.getESuperTypes().add(theScenarioPackage.getVerification());
		workspaceVerificationEClass.getESuperTypes().add(this.getWorkspaceData());
		wsContainerEClass.getESuperTypes().add(this.getWSResource());
		wsFileEClass.getESuperTypes().add(this.getWSResource());
		wsFolderEClass.getESuperTypes().add(this.getWSContainer());
		wsProjectEClass.getESuperTypes().add(this.getWSFolder());
		wsRootEClass.getESuperTypes().add(this.getWSContainer());
		wsLinkEClass.getESuperTypes().add(this.getWSResource());
		wsFileLinkEClass.getESuperTypes().add(this.getWSLink());
		wsFolderLinkEClass.getESuperTypes().add(this.getWSLink());
		wsProjectLinkEClass.getESuperTypes().add(this.getWSFolderLink());

		// Initialize classes and features; add operations and parameters
		initEClass(workspaceDataEClass, WorkspaceData.class, "WorkspaceData", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspaceData_Content(), this.getWSRoot(), null, "content", null, 0, 1, WorkspaceData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspaceData_Location(), ecorePackage.getEString(), "location", null, 0, 1, WorkspaceData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workspaceContextEClass, WorkspaceContext.class, "WorkspaceContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkspaceContext_ClearWorkspace(), ecorePackage.getEBoolean(), "clearWorkspace", "true", 0, 1, WorkspaceContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspaceContext_IgnoredByClearPattern(), ecorePackage.getEString(), "ignoredByClearPattern", null, 0, 1, WorkspaceContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workspaceVerificationEClass, WorkspaceVerification.class, "WorkspaceVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkspaceVerification_AllowUncapturedFiles(), ecorePackage.getEBoolean(), "allowUncapturedFiles", "true", 0, 1, WorkspaceVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspaceVerification_NotAllowedPatterns(), ecorePackage.getEString(), "notAllowedPatterns", null, 0, 1, WorkspaceVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspaceVerification_IgnoredLines(), ecorePackage.getEString(), "ignoredLines", null, 0, 1, WorkspaceVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspaceVerification_IgnoreWhiteSpace(), ecorePackage.getEBoolean(), "ignoreWhiteSpace", "false", 0, 1, WorkspaceVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsResourceEClass, WSResource.class, "WSResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWSResource_Name(), ecorePackage.getEString(), "name", null, 0, 1, WSResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsContainerEClass, WSContainer.class, "WSContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wsFileEClass, WSFile.class, "WSFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWSFile_ContentURI(), ecorePackage.getEString(), "contentURI", null, 0, 1, WSFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWSFile_Content(), ecorePackage.getEByteArray(), "content", null, 0, 1, WSFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWSFile_Executable(), ecorePackage.getEBoolean(), "executable", "false", 0, 1, WSFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsFolderEClass, WSFolder.class, "WSFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWSFolder_Files(), this.getWSFile(), null, "files", null, 0, -1, WSFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSFolder_Folders(), this.getWSFolder(), null, "folders", null, 0, -1, WSFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSFolder_FolderLinks(), this.getWSFolderLink(), null, "folderLinks", null, 0, -1, WSFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSFolder_FileLinks(), this.getWSFileLink(), null, "fileLinks", null, 0, -1, WSFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsProjectEClass, WSProject.class, "WSProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wsRootEClass, WSRoot.class, "WSRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWSRoot_Projects(), this.getWSProject(), null, "projects", null, 0, -1, WSRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSRoot_ProjectLinks(), this.getWSProjectLink(), null, "projectLinks", null, 0, -1, WSRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsLinkEClass, WSLink.class, "WSLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWSLink_Project(), ecorePackage.getEString(), "project", null, 1, 1, WSLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWSLink_Path(), ecorePackage.getEString(), "path", null, 1, 1, WSLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsFileLinkEClass, WSFileLink.class, "WSFileLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWSFileLink_Content(), ecorePackage.getEByteArray(), "content", null, 1, 1, WSFileLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsFolderLinkEClass, WSFolderLink.class, "WSFolderLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWSFolderLink_Folders(), this.getWSFolderLink(), null, "folders", null, 0, -1, WSFolderLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSFolderLink_Files(), this.getWSFileLink(), null, "files", null, 0, -1, WSFolderLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsProjectLinkEClass, WSProjectLink.class, "WSProjectLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //WorkspacePackageImpl
