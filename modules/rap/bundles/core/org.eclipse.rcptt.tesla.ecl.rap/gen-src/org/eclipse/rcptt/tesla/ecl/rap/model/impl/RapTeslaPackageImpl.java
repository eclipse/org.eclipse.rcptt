/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

import org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage;
import org.eclipse.rcptt.tesla.ecl.rap.model.RunJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RapTeslaPackageImpl extends EPackageImpl implements RapTeslaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runJsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execWithoutJsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setDownloadResultFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verifyDownloadFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markDownloadHandlerEClass = null;

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
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RapTeslaPackageImpl() {
		super(eNS_URI, RapTeslaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RapTeslaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RapTeslaPackage init() {
		if (isInited) return (RapTeslaPackage)EPackage.Registry.INSTANCE.getEPackage(RapTeslaPackage.eNS_URI);

		// Obtain or create and register package
		RapTeslaPackageImpl theRapTeslaPackage = (RapTeslaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RapTeslaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RapTeslaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRapTeslaPackage.createPackageContents();

		// Initialize created meta-data
		theRapTeslaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRapTeslaPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RapTeslaPackage.eNS_URI, theRapTeslaPackage);
		return theRapTeslaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunJs() {
		return runJsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunJs_JsCode() {
		return (EAttribute)runJsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecWithoutJs() {
		return execWithoutJsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecWithoutJs_Command() {
		return (EReference)execWithoutJsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetDownloadResultFile() {
		return setDownloadResultFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetDownloadResultFile_File() {
		return (EAttribute)setDownloadResultFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVerifyDownloadFile() {
		return verifyDownloadFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyDownloadFile_Url() {
		return (EAttribute)verifyDownloadFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyDownloadFile_Handler() {
		return (EAttribute)verifyDownloadFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarkDownloadHandler() {
		return markDownloadHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarkDownloadHandler_Handler() {
		return (EAttribute)markDownloadHandlerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RapTeslaFactory getRapTeslaFactory() {
		return (RapTeslaFactory)getEFactoryInstance();
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
		runJsEClass = createEClass(RUN_JS);
		createEAttribute(runJsEClass, RUN_JS__JS_CODE);

		execWithoutJsEClass = createEClass(EXEC_WITHOUT_JS);
		createEReference(execWithoutJsEClass, EXEC_WITHOUT_JS__COMMAND);

		setDownloadResultFileEClass = createEClass(SET_DOWNLOAD_RESULT_FILE);
		createEAttribute(setDownloadResultFileEClass, SET_DOWNLOAD_RESULT_FILE__FILE);

		verifyDownloadFileEClass = createEClass(VERIFY_DOWNLOAD_FILE);
		createEAttribute(verifyDownloadFileEClass, VERIFY_DOWNLOAD_FILE__URL);
		createEAttribute(verifyDownloadFileEClass, VERIFY_DOWNLOAD_FILE__HANDLER);

		markDownloadHandlerEClass = createEClass(MARK_DOWNLOAD_HANDLER);
		createEAttribute(markDownloadHandlerEClass, MARK_DOWNLOAD_HANDLER__HANDLER);
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
		runJsEClass.getESuperTypes().add(theCorePackage.getCommand());
		execWithoutJsEClass.getESuperTypes().add(theCorePackage.getCommand());
		setDownloadResultFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		verifyDownloadFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		markDownloadHandlerEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(runJsEClass, RunJs.class, "RunJs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRunJs_JsCode(), theEcorePackage.getEString(), "jsCode", null, 1, 1, RunJs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execWithoutJsEClass, ExecWithoutJs.class, "ExecWithoutJs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecWithoutJs_Command(), theCorePackage.getCommand(), null, "command", null, 1, 1, ExecWithoutJs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setDownloadResultFileEClass, SetDownloadResultFile.class, "SetDownloadResultFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetDownloadResultFile_File(), theEcorePackage.getEString(), "file", null, 1, 1, SetDownloadResultFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verifyDownloadFileEClass, VerifyDownloadFile.class, "VerifyDownloadFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVerifyDownloadFile_Url(), theEcorePackage.getEString(), "url", null, 1, 1, VerifyDownloadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyDownloadFile_Handler(), theEcorePackage.getEString(), "handler", null, 1, 1, VerifyDownloadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markDownloadHandlerEClass, MarkDownloadHandler.class, "MarkDownloadHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMarkDownloadHandler_Handler(), theEcorePackage.getEString(), "handler", null, 1, -1, MarkDownloadHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RapTeslaPackageImpl
