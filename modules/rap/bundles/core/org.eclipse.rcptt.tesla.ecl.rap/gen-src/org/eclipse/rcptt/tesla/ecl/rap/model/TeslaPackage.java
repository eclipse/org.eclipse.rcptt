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
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.TeslaFactory
 * @model kind="package"
 * @generated
 */
public interface TeslaPackage extends EPackage {
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
	TeslaPackage eINSTANCE = org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl <em>Run Js</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.RunJsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getRunJs()
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
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getExecWithoutJs()
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
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.SetDownloadResultFileImpl <em>Set Download Result File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.SetDownloadResultFileImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getSetDownloadResultFile()
	 * @generated
	 */
	int SET_DOWNLOAD_RESULT_FILE = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DOWNLOAD_RESULT_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DOWNLOAD_RESULT_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DOWNLOAD_RESULT_FILE__FILE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Download Result File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DOWNLOAD_RESULT_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.VerifyDownloadFileImpl <em>Verify Download File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.VerifyDownloadFileImpl
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getVerifyDownloadFile()
	 * @generated
	 */
	int VERIFY_DOWNLOAD_FILE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_DOWNLOAD_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_DOWNLOAD_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_DOWNLOAD_FILE__URL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Verify Download File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_DOWNLOAD_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;


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
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile <em>Set Download Result File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Download Result File</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile
	 * @generated
	 */
	EClass getSetDownloadResultFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile#getFile()
	 * @see #getSetDownloadResultFile()
	 * @generated
	 */
	EAttribute getSetDownloadResultFile_File();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile <em>Verify Download File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verify Download File</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile
	 * @generated
	 */
	EClass getVerifyDownloadFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile#getUrl()
	 * @see #getVerifyDownloadFile()
	 * @generated
	 */
	EAttribute getVerifyDownloadFile_Url();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TeslaFactory getTeslaFactory();

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
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getRunJs()
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
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getExecWithoutJs()
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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.SetDownloadResultFileImpl <em>Set Download Result File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.SetDownloadResultFileImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getSetDownloadResultFile()
		 * @generated
		 */
		EClass SET_DOWNLOAD_RESULT_FILE = eINSTANCE.getSetDownloadResultFile();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_DOWNLOAD_RESULT_FILE__FILE = eINSTANCE.getSetDownloadResultFile_File();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.VerifyDownloadFileImpl <em>Verify Download File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.VerifyDownloadFileImpl
		 * @see org.eclipse.rcptt.tesla.ecl.rap.model.impl.TeslaPackageImpl#getVerifyDownloadFile()
		 * @generated
		 */
		EClass VERIFY_DOWNLOAD_FILE = eINSTANCE.getVerifyDownloadFile();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_DOWNLOAD_FILE__URL = eINSTANCE.getVerifyDownloadFile_Url();

	}

} //TeslaPackage
