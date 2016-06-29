/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory
 * @model kind="package"
 * @generated
 */
public interface RapTeslaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/ecl/rap";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.ecl.rap";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RapTeslaPackage eINSTANCE = org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl <em>Run Js</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getRunJs()
	 * @generated
	 */
	int RUN_JS = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_JS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_JS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Js Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_JS__JS_CODE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Run Js</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_JS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.ExecWithoutJsImpl <em>Exec Without Js</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.ExecWithoutJsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getExecWithoutJs()
	 * @generated
	 */
	int EXEC_WITHOUT_JS = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITHOUT_JS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITHOUT_JS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITHOUT_JS__COMMAND = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exec Without Js</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITHOUT_JS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.MarkDownloadHandlerImpl <em>Mark Download Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.MarkDownloadHandlerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getMarkDownloadHandler()
	 * @generated
	 */
	int MARK_DOWNLOAD_HANDLER = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK_DOWNLOAD_HANDLER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK_DOWNLOAD_HANDLER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK_DOWNLOAD_HANDLER__HANDLER = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mark Download Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK_DOWNLOAD_HANDLER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.UploadFileImpl <em>Upload File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.UploadFileImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getUploadFile()
	 * @generated
	 */
	int UPLOAD_FILE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_FILE__FILE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base64</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_FILE__BASE64 = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Upload File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.DownloadFileImpl <em>Download File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.DownloadFileImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getDownloadFile()
	 * @generated
	 */
	int DOWNLOAD_FILE = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Handler Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FILE__HANDLER_ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FILE__URL = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Download File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.ToStringImpl <em>To String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.ToStringImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getToString()
	 * @generated
	 */
	int TO_STRING = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STRING__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STRING__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Encode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STRING__ENCODE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STRING__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>To String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STRING_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.MatchBinaryImpl <em>Match Binary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.MatchBinaryImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getMatchBinary()
	 * @generated
	 */
	int MATCH_BINARY = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_BINARY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_BINARY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Base64</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_BINARY__BASE64 = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_BINARY__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_BINARY__FILE_PATH = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Match Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_BINARY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.RunJs <em>Run Js</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Js</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RunJs
	 * @generated
	 */
	EClass getRunJs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.RunJs#getJsCode <em>Js Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Js Code</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RunJs#getJsCode()
	 * @see #getRunJs()
	 * @generated
	 */
	EAttribute getRunJs_JsCode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs <em>Exec Without Js</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Without Js</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs
	 * @generated
	 */
	EClass getExecWithoutJs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs#getCommand()
	 * @see #getExecWithoutJs()
	 * @generated
	 */
	EReference getExecWithoutJs_Command();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler <em>Mark Download Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mark Download Handler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler
	 * @generated
	 */
	EClass getMarkDownloadHandler();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Handler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler#getHandler()
	 * @see #getMarkDownloadHandler()
	 * @generated
	 */
	EAttribute getMarkDownloadHandler_Handler();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile <em>Upload File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upload File</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile
	 * @generated
	 */
	EClass getUploadFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getFile()
	 * @see #getUploadFile()
	 * @generated
	 */
	EAttribute getUploadFile_File();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getBase64 <em>Base64</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base64</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getBase64()
	 * @see #getUploadFile()
	 * @generated
	 */
	EAttribute getUploadFile_Base64();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile <em>Download File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Download File</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile
	 * @generated
	 */
	EClass getDownloadFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile#getHandlerId <em>Handler Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Handler Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile#getHandlerId()
	 * @see #getDownloadFile()
	 * @generated
	 */
	EAttribute getDownloadFile_HandlerId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile#getUrl()
	 * @see #getDownloadFile()
	 * @generated
	 */
	EAttribute getDownloadFile_Url();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString <em>To String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To String</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.ToString
	 * @generated
	 */
	EClass getToString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getEncode <em>Encode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encode</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getEncode()
	 * @see #getToString()
	 * @generated
	 */
	EAttribute getToString_Encode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.ToString#getInput()
	 * @see #getToString()
	 * @generated
	 */
	EReference getToString_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary <em>Match Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Binary</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary
	 * @generated
	 */
	EClass getMatchBinary();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary#getBase64 <em>Base64</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base64</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary#getBase64()
	 * @see #getMatchBinary()
	 * @generated
	 */
	EAttribute getMatchBinary_Base64();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary#getInput()
	 * @see #getMatchBinary()
	 * @generated
	 */
	EReference getMatchBinary_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary#getFilePath <em>File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Path</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary#getFilePath()
	 * @see #getMatchBinary()
	 * @generated
	 */
	EAttribute getMatchBinary_FilePath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RapTeslaFactory getRapTeslaFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl <em>Run Js</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getRunJs()
		 * @generated
		 */
		EClass RUN_JS = eINSTANCE.getRunJs();

		/**
		 * The meta object literal for the '<em><b>Js Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_JS__JS_CODE = eINSTANCE.getRunJs_JsCode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.ExecWithoutJsImpl <em>Exec Without Js</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.ExecWithoutJsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getExecWithoutJs()
		 * @generated
		 */
		EClass EXEC_WITHOUT_JS = eINSTANCE.getExecWithoutJs();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_WITHOUT_JS__COMMAND = eINSTANCE.getExecWithoutJs_Command();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.MarkDownloadHandlerImpl <em>Mark Download Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.MarkDownloadHandlerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getMarkDownloadHandler()
		 * @generated
		 */
		EClass MARK_DOWNLOAD_HANDLER = eINSTANCE.getMarkDownloadHandler();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARK_DOWNLOAD_HANDLER__HANDLER = eINSTANCE.getMarkDownloadHandler_Handler();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.UploadFileImpl <em>Upload File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.UploadFileImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getUploadFile()
		 * @generated
		 */
		EClass UPLOAD_FILE = eINSTANCE.getUploadFile();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOAD_FILE__FILE = eINSTANCE.getUploadFile_File();

		/**
		 * The meta object literal for the '<em><b>Base64</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOAD_FILE__BASE64 = eINSTANCE.getUploadFile_Base64();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.DownloadFileImpl <em>Download File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.DownloadFileImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getDownloadFile()
		 * @generated
		 */
		EClass DOWNLOAD_FILE = eINSTANCE.getDownloadFile();

		/**
		 * The meta object literal for the '<em><b>Handler Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD_FILE__HANDLER_ID = eINSTANCE.getDownloadFile_HandlerId();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD_FILE__URL = eINSTANCE.getDownloadFile_Url();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.ToStringImpl <em>To String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.ToStringImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getToString()
		 * @generated
		 */
		EClass TO_STRING = eINSTANCE.getToString();

		/**
		 * The meta object literal for the '<em><b>Encode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TO_STRING__ENCODE = eINSTANCE.getToString_Encode();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_STRING__INPUT = eINSTANCE.getToString_Input();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.MatchBinaryImpl <em>Match Binary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.MatchBinaryImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaPackageImpl#getMatchBinary()
		 * @generated
		 */
		EClass MATCH_BINARY = eINSTANCE.getMatchBinary();

		/**
		 * The meta object literal for the '<em><b>Base64</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_BINARY__BASE64 = eINSTANCE.getMatchBinary_Base64();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_BINARY__INPUT = eINSTANCE.getMatchBinary_Input();

		/**
		 * The meta object literal for the '<em><b>File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_BINARY__FILE_PATH = eINSTANCE.getMatchBinary_FilePath();

	}

} //RapTeslaPackage
