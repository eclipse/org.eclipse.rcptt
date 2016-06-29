/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

import org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler;
import org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage;
import org.eclipse.rcptt.tesla.ecl.rap.model.RunJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.ToString;
import org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile;

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
	private EClass markDownloadHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uploadFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass downloadFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchBinaryEClass = null;

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
	public EClass getUploadFile() {
		return uploadFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadFile_File() {
		return (EAttribute)uploadFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadFile_Base64() {
		return (EAttribute)uploadFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDownloadFile() {
		return downloadFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadFile_HandlerId() {
		return (EAttribute)downloadFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadFile_Url() {
		return (EAttribute)downloadFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToString() {
		return toStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToString_Encode() {
		return (EAttribute)toStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToString_Input() {
		return (EReference)toStringEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchBinary() {
		return matchBinaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchBinary_Base64() {
		return (EAttribute)matchBinaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchBinary_Input() {
		return (EReference)matchBinaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchBinary_FilePath() {
		return (EAttribute)matchBinaryEClass.getEStructuralFeatures().get(2);
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

		markDownloadHandlerEClass = createEClass(MARK_DOWNLOAD_HANDLER);
		createEAttribute(markDownloadHandlerEClass, MARK_DOWNLOAD_HANDLER__HANDLER);

		uploadFileEClass = createEClass(UPLOAD_FILE);
		createEAttribute(uploadFileEClass, UPLOAD_FILE__FILE);
		createEAttribute(uploadFileEClass, UPLOAD_FILE__BASE64);

		downloadFileEClass = createEClass(DOWNLOAD_FILE);
		createEAttribute(downloadFileEClass, DOWNLOAD_FILE__HANDLER_ID);
		createEAttribute(downloadFileEClass, DOWNLOAD_FILE__URL);

		toStringEClass = createEClass(TO_STRING);
		createEAttribute(toStringEClass, TO_STRING__ENCODE);
		createEReference(toStringEClass, TO_STRING__INPUT);

		matchBinaryEClass = createEClass(MATCH_BINARY);
		createEAttribute(matchBinaryEClass, MATCH_BINARY__BASE64);
		createEReference(matchBinaryEClass, MATCH_BINARY__INPUT);
		createEAttribute(matchBinaryEClass, MATCH_BINARY__FILE_PATH);
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
		markDownloadHandlerEClass.getESuperTypes().add(theCorePackage.getCommand());
		uploadFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		downloadFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		toStringEClass.getESuperTypes().add(theCorePackage.getCommand());
		matchBinaryEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(runJsEClass, RunJs.class, "RunJs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRunJs_JsCode(), theEcorePackage.getEString(), "jsCode", null, 1, 1, RunJs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execWithoutJsEClass, ExecWithoutJs.class, "ExecWithoutJs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecWithoutJs_Command(), theCorePackage.getCommand(), null, "command", null, 1, 1, ExecWithoutJs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markDownloadHandlerEClass, MarkDownloadHandler.class, "MarkDownloadHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMarkDownloadHandler_Handler(), theEcorePackage.getEString(), "handler", null, 1, -1, MarkDownloadHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uploadFileEClass, UploadFile.class, "UploadFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUploadFile_File(), theEcorePackage.getEString(), "file", null, 0, 1, UploadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadFile_Base64(), theEcorePackage.getEString(), "base64", null, 0, 1, UploadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(downloadFileEClass, DownloadFile.class, "DownloadFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDownloadFile_HandlerId(), theEcorePackage.getEString(), "handlerId", null, 1, 1, DownloadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDownloadFile_Url(), theEcorePackage.getEString(), "url", null, 1, 1, DownloadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toStringEClass, ToString.class, "ToString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToString_Encode(), theEcorePackage.getEString(), "encode", "UTF-8", 0, 1, ToString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToString_Input(), theEcorePackage.getEObject(), null, "input", null, 1, 1, ToString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchBinaryEClass, MatchBinary.class, "MatchBinary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchBinary_Base64(), theEcorePackage.getEString(), "base64", null, 0, 1, MatchBinary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchBinary_Input(), theEcorePackage.getEObject(), null, "input", null, 1, 1, MatchBinary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchBinary_FilePath(), theEcorePackage.getEString(), "filePath", null, 0, 1, MatchBinary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
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
		  (getToString_Input(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getMatchBinary_Input(), 
		   source, 
		   new String[] {
		   });
	}

} //RapTeslaPackageImpl
