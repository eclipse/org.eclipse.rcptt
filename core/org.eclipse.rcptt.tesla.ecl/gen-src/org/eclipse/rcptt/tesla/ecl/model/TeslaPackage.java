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
package org.eclipse.rcptt.tesla.ecl.model;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaFactory
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
	String eNS_URI = "http://eclipse.org/rcptt/tesla/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TeslaPackage eINSTANCE = org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.WaitImpl <em>Wait</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.WaitImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getWait()
	 * @generated
	 */
	int WAIT = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__MS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetupPlayerImpl <em>Setup Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetupPlayerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetupPlayer()
	 * @generated
	 */
	int SETUP_PLAYER = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETUP_PLAYER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETUP_PLAYER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Setup Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETUP_PLAYER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShoutdownPlayerImpl <em>Shoutdown Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShoutdownPlayerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShoutdownPlayer()
	 * @generated
	 */
	int SHOUTDOWN_PLAYER = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOUTDOWN_PLAYER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOUTDOWN_PLAYER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Shoutdown Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOUTDOWN_PLAYER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TeslaProcessStatusImpl <em>Process Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaProcessStatusImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTeslaProcessStatus()
	 * @generated
	 */
	int TESLA_PROCESS_STATUS = 3;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__PLUGIN_ID = CorePackage.PROCESS_STATUS__PLUGIN_ID;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__CODE = CorePackage.PROCESS_STATUS__CODE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__MESSAGE = CorePackage.PROCESS_STATUS__MESSAGE;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__SEVERITY = CorePackage.PROCESS_STATUS__SEVERITY;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__EXCEPTION = CorePackage.PROCESS_STATUS__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__CHILDREN = CorePackage.PROCESS_STATUS__CHILDREN;

	/**
	 * The feature id for the '<em><b>Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS__INFO = CorePackage.PROCESS_STATUS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_PROCESS_STATUS_FEATURE_COUNT = CorePackage.PROCESS_STATUS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.WrapperImpl <em>Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.WrapperImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getWrapper()
	 * @generated
	 */
	int WRAPPER = 4;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRAPPER__OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRAPPER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyImpl <em>Get Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetProperty()
	 * @generated
	 */
	int GET_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY__INDEX = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raw</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY__RAW = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Get Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyTrueImpl <em>Verify True</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyTrueImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyTrue()
	 * @generated
	 */
	int VERIFY_TRUE = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TRUE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TRUE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TRUE__CONDITION = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Verify True</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TRUE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyFalseImpl <em>Verify False</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyFalseImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyFalse()
	 * @generated
	 */
	int VERIFY_FALSE = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_FALSE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_FALSE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_FALSE__CONDITION = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Verify False</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_FALSE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyHandlerImpl <em>Verify Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyHandlerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyHandler()
	 * @generated
	 */
	int VERIFY_HANDLER = 8;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_HANDLER__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_HANDLER__ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_HANDLER__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_HANDLER__KIND = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_HANDLER__INDEX = 4;

	/**
	 * The number of structural features of the '<em>Verify Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_HANDLER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyErrorImpl <em>Verify Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyErrorImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyError()
	 * @generated
	 */
	int VERIFY_ERROR = 9;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_ERROR__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_ERROR__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_ERROR__COMMAND = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Verify Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_ERROR_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.EqualsImpl <em>Equals</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.EqualsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getEquals()
	 * @generated
	 */
	int EQUALS = 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Equals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImpl <em>Contains</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getContains()
	 * @generated
	 */
	int CONTAINS = 11;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contains</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MatchesImpl <em>Matches</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MatchesImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMatches()
	 * @generated
	 */
	int MATCHES = 12;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHES__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHES__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Matches</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.IsEmptyImpl <em>Is Empty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.IsEmptyImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getIsEmpty()
	 * @generated
	 */
	int IS_EMPTY = 13;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Empty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.UnsupportedImpl <em>Unsupported</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.UnsupportedImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getUnsupported()
	 * @generated
	 */
	int UNSUPPORTED = 14;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED__DESC = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unsupported</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ControlNotFoundImpl <em>Control Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ControlNotFoundImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getControlNotFound()
	 * @generated
	 */
	int CONTROL_NOT_FOUND = 15;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NOT_FOUND__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NOT_FOUND__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NOT_FOUND__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NOT_FOUND_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ControlHandlerImpl <em>Control Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ControlHandlerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getControlHandler()
	 * @generated
	 */
	int CONTROL_HANDLER = 16;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__KIND = 0;

	/**
	 * The feature id for the '<em><b>Custom Kind Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__CUSTOM_KIND_ID = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__TEXT = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__INDEX = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__PATH = 5;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__INDEXES = 6;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__AFTER = 7;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__PARENT = 8;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__RESOLVED = 9;

	/**
	 * The feature id for the '<em><b>Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__ROW = 10;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__COLUMN = 11;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__X = 12;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__Y = 13;

	/**
	 * The feature id for the '<em><b>Raw Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER__RAW_IMAGE = 14;

	/**
	 * The number of structural features of the '<em>Control Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_HANDLER_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.Selector <em>Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelector()
	 * @generated
	 */
	int SELECTOR = 18;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__AFTER = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__TYPE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__INDEX = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR__PARENT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetEclipseWindowImpl <em>Get Eclipse Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetEclipseWindowImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetEclipseWindow()
	 * @generated
	 */
	int GET_ECLIPSE_WINDOW = 17;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Eclipse Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ECLIPSE_WINDOW_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.PathSelector <em>Path Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.PathSelector
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getPathSelector()
	 * @generated
	 */
	int PATH_SELECTOR = 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR__PATH = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.TextSelector <em>Text Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.TextSelector
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTextSelector()
	 * @generated
	 */
	int TEXT_SELECTOR = 20;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR__TEXT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetControlImpl <em>Get Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetControlImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetControl()
	 * @generated
	 */
	int GET_CONTROL = 21;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__PATH = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL__KIND = TEXT_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONTROL_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetButtonImpl <em>Get Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetButtonImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetButton()
	 * @generated
	 */
	int GET_BUTTON = 22;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUTTON_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCanvasImpl <em>Get Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCanvasImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCanvas()
	 * @generated
	 */
	int GET_CANVAS = 23;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CANVAS_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCheckboxImpl <em>Get Checkbox</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCheckboxImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCheckbox()
	 * @generated
	 */
	int GET_CHECKBOX = 24;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Checkbox</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CHECKBOX_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetComboImpl <em>Get Combo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetComboImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCombo()
	 * @generated
	 */
	int GET_COMBO = 25;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Combo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetEditboxImpl <em>Get Editbox</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetEditboxImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetEditbox()
	 * @generated
	 */
	int GET_EDITBOX = 26;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Editbox</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITBOX_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetGroupImpl <em>Get Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetGroupImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetGroup()
	 * @generated
	 */
	int GET_GROUP = 27;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_GROUP_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetItemImpl <em>Get Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetItemImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetItem()
	 * @generated
	 */
	int GET_ITEM = 28;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__PATH = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM__COLUMN = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLabelImpl <em>Get Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLabelImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLabel()
	 * @generated
	 */
	int GET_LABEL = 29;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LABEL_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLinkImpl <em>Get Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLinkImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLink()
	 * @generated
	 */
	int GET_LINK = 30;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LINK_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetListImpl <em>Get List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetListImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetList()
	 * @generated
	 */
	int GET_LIST = 31;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LIST_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetMenuImpl <em>Get Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetMenuImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetMenu()
	 * @generated
	 */
	int GET_MENU = 32;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__HOST = PATH_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__BINDINGS = PATH_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__ID = PATH_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__AFTER = PATH_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__TYPE = PATH_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__INDEX = PATH_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__PARENT = PATH_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU__PATH = PATH_SELECTOR__PATH;

	/**
	 * The number of structural features of the '<em>Get Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_MENU_FEATURE_COUNT = PATH_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTabFolderImpl <em>Get Tab Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTabFolderImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTabFolder()
	 * @generated
	 */
	int GET_TAB_FOLDER = 33;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Tab Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_FOLDER_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTabItemImpl <em>Get Tab Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTabItemImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTabItem()
	 * @generated
	 */
	int GET_TAB_ITEM = 34;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Tab Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TAB_ITEM_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTableImpl <em>Get Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTableImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTable()
	 * @generated
	 */
	int GET_TABLE = 35;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetToolbarImpl <em>Get Toolbar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetToolbarImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetToolbar()
	 * @generated
	 */
	int GET_TOOLBAR = 36;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Toolbar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TOOLBAR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTreeImpl <em>Get Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTreeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTree()
	 * @generated
	 */
	int GET_TREE = 37;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TREE_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetWindowImpl <em>Get Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetWindowImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetWindow()
	 * @generated
	 */
	int GET_WINDOW = 38;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__TEXT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__FROM = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW__CLASS = SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Get Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WINDOW_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetViewImpl <em>Get View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetViewImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetView()
	 * @generated
	 */
	int GET_VIEW = 39;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEW_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetEditorImpl <em>Get Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetEditorImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetEditor()
	 * @generated
	 */
	int GET_EDITOR = 40;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDITOR_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetSectionImpl <em>Get Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetSectionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetSection()
	 * @generated
	 */
	int GET_SECTION = 41;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SECTION_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetBannerImpl <em>Get Banner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetBannerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetBanner()
	 * @generated
	 */
	int GET_BANNER = 42;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Banner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BANNER_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCoolbarImpl <em>Get Coolbar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCoolbarImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCoolbar()
	 * @generated
	 */
	int GET_COOLBAR = 43;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Coolbar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COOLBAR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetColorSelectorImpl <em>Get Color Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetColorSelectorImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetColorSelector()
	 * @generated
	 */
	int GET_COLOR_SELECTOR = 44;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Color Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCellImpl <em>Get Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCellImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCell()
	 * @generated
	 */
	int GET_CELL = 45;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__ROW = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL__COLUMN = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CELL_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickImpl <em>Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClick()
	 * @generated
	 */
	int CLICK = 46;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nowait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__NOWAIT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__DEFAULT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Arrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__ARROW = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Meta Keys</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__META_KEYS = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickImpl <em>Double Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDoubleClick()
	 * @generated
	 */
	int DOUBLE_CLICK = 47;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__HOST = CLICK__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__BINDINGS = CLICK__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__CONTROL = CLICK__CONTROL;

	/**
	 * The feature id for the '<em><b>Nowait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__NOWAIT = CLICK__NOWAIT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__DEFAULT = CLICK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Arrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__ARROW = CLICK__ARROW;

	/**
	 * The feature id for the '<em><b>Meta Keys</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__META_KEYS = CLICK__META_KEYS;

	/**
	 * The number of structural features of the '<em>Double Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_FEATURE_COUNT = CLICK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTextImpl <em>Get Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetText()
	 * @generated
	 */
	int GET_TEXT = 48;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.IsDisabledImpl <em>Is Disabled</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.IsDisabledImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getIsDisabled()
	 * @generated
	 */
	int IS_DISABLED = 49;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISABLED__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISABLED__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISABLED__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Disabled</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISABLED_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.IsDisposedImpl <em>Is Disposed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.IsDisposedImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getIsDisposed()
	 * @generated
	 */
	int IS_DISPOSED = 50;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is Disposed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TypeTextImpl <em>Type Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TypeTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTypeText()
	 * @generated
	 */
	int TYPE_TEXT = 51;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__TEXT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__DISPLAY = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.KeyTypeImpl <em>Key Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.KeyTypeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getKeyType()
	 * @generated
	 */
	int KEY_TYPE = 52;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__KEY = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__CHAR = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__DISPLAY = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE__TIMES = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Key Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_TYPE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TypeCommandKeyImpl <em>Type Command Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TypeCommandKeyImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTypeCommandKey()
	 * @generated
	 */
	int TYPE_COMMAND_KEY = 53;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_COMMAND_KEY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_COMMAND_KEY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_COMMAND_KEY__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Command Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_COMMAND_KEY__COMMAND_ID = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Command Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_COMMAND_KEY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetTextImpl <em>Set Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetText()
	 * @generated
	 */
	int SET_TEXT = 54;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__TEXT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetTextSelectionImpl <em>Set Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetTextSelection()
	 * @generated
	 */
	int SET_TEXT_SELECTION = 55;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__OFFSET = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__LENGTH = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__START_LINE = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__END_LINE = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__END_OFFSET = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Set Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetTextOffsetImpl <em>Set Text Offset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetTextOffsetImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetTextOffset()
	 * @generated
	 */
	int SET_TEXT_OFFSET = 56;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__LINE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Text Offset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CheckImpl <em>Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CheckImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCheck()
	 * @generated
	 */
	int CHECK = 57;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.UncheckImpl <em>Uncheck</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.UncheckImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getUncheck()
	 * @generated
	 */
	int UNCHECK = 58;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCHECK__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCHECK__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCHECK__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Uncheck</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCHECK_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SelectImpl <em>Select</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SelectImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelect()
	 * @generated
	 */
	int SELECT = 59;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__ITEMS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__ALL = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CellEditImpl <em>Cell Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CellEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCellEdit()
	 * @generated
	 */
	int CELL_EDIT = 60;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_EDIT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_EDIT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_EDIT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cell Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_EDIT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ActivateCellEditImpl <em>Activate Cell Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ActivateCellEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getActivateCellEdit()
	 * @generated
	 */
	int ACTIVATE_CELL_EDIT = 61;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT__HOST = CELL_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT__BINDINGS = CELL_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT__CONTROL = CELL_EDIT__CONTROL;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT__COLUMN = CELL_EDIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT__TYPE = CELL_EDIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT__BUTTON = CELL_EDIT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Activate Cell Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDIT_FEATURE_COUNT = CELL_EDIT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ApplyCellEditImpl <em>Apply Cell Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ApplyCellEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getApplyCellEdit()
	 * @generated
	 */
	int APPLY_CELL_EDIT = 62;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDIT__HOST = CELL_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDIT__BINDINGS = CELL_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDIT__CONTROL = CELL_EDIT__CONTROL;

	/**
	 * The feature id for the '<em><b>Deactivate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDIT__DEACTIVATE = CELL_EDIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Apply Cell Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDIT_FEATURE_COUNT = CELL_EDIT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CancelCellEditImpl <em>Cancel Cell Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CancelCellEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCancelCellEdit()
	 * @generated
	 */
	int CANCEL_CELL_EDIT = 63;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDIT__HOST = CELL_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDIT__BINDINGS = CELL_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDIT__CONTROL = CELL_EDIT__CONTROL;

	/**
	 * The number of structural features of the '<em>Cancel Cell Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDIT_FEATURE_COUNT = CELL_EDIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DeactivateCellEditImpl <em>Deactivate Cell Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DeactivateCellEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDeactivateCellEdit()
	 * @generated
	 */
	int DEACTIVATE_CELL_EDIT = 64;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDIT__HOST = CELL_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDIT__BINDINGS = CELL_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDIT__CONTROL = CELL_EDIT__CONTROL;

	/**
	 * The number of structural features of the '<em>Deactivate Cell Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDIT_FEATURE_COUNT = CELL_EDIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CloseImpl <em>Close</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CloseImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClose()
	 * @generated
	 */
	int CLOSE = 65;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Close</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ReturnFromOsDialogImpl <em>Return From Os Dialog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ReturnFromOsDialogImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getReturnFromOsDialog()
	 * @generated
	 */
	int RETURN_FROM_OS_DIALOG = 66;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FROM_OS_DIALOG__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FROM_OS_DIALOG__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FROM_OS_DIALOG__KIND = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FROM_OS_DIALOG__RESULT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Return From Os Dialog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FROM_OS_DIALOG_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.WaitUntilEclipseIsReadyImpl <em>Wait Until Eclipse Is Ready</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.WaitUntilEclipseIsReadyImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getWaitUntilEclipseIsReady()
	 * @generated
	 */
	int WAIT_UNTIL_ECLIPSE_IS_READY = 67;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL_ECLIPSE_IS_READY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL_ECLIPSE_IS_READY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Wait Until Eclipse Is Ready</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL_ECLIPSE_IS_READY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShowContentAssistImpl <em>Show Content Assist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShowContentAssistImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShowContentAssist()
	 * @generated
	 */
	int SHOW_CONTENT_ASSIST = 68;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Show Content Assist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragActionImpl <em>Drag Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragActionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragAction()
	 * @generated
	 */
	int DRAG_ACTION = 69;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__X = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__Y = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__BUTTON = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__MASK = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__DETAIL = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION__OPERATION = CorePackage.COMMAND_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Drag Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACTION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragStartImpl <em>Drag Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragStartImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragStart()
	 * @generated
	 */
	int DRAG_START = 70;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_START_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragEndImpl <em>Drag End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragEndImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragEnd()
	 * @generated
	 */
	int DRAG_END = 71;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_END_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragEnterImpl <em>Drag Enter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragEnterImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragEnter()
	 * @generated
	 */
	int DRAG_ENTER = 72;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Enter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ENTER_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragExitImpl <em>Drag Exit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragExitImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragExit()
	 * @generated
	 */
	int DRAG_EXIT = 73;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Exit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_EXIT_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragSetDataImpl <em>Drag Set Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragSetDataImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragSetData()
	 * @generated
	 */
	int DRAG_SET_DATA = 74;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Set Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_SET_DATA_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragAcceptImpl <em>Drag Accept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragAcceptImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragAccept()
	 * @generated
	 */
	int DRAG_ACCEPT = 75;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Accept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_ACCEPT_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragDetectImpl <em>Drag Detect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragDetectImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragDetect()
	 * @generated
	 */
	int DRAG_DETECT = 76;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Detect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_DETECT_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragOverImpl <em>Drag Over</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragOverImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragOver()
	 * @generated
	 */
	int DRAG_OVER = 77;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drag Over</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_OVER_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DropImpl <em>Drop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DropImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDrop()
	 * @generated
	 */
	int DROP = 78;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__HOST = DRAG_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__BINDINGS = DRAG_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__CONTROL = DRAG_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__X = DRAG_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__Y = DRAG_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__BUTTON = DRAG_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__MASK = DRAG_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__DETAIL = DRAG_ACTION__DETAIL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP__OPERATION = DRAG_ACTION__OPERATION;

	/**
	 * The number of structural features of the '<em>Drop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_FEATURE_COUNT = DRAG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeImpl <em>Recognize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRecognize()
	 * @generated
	 */
	int RECOGNIZE = 79;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__IMAGE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__X = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__Y = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__WIDTH = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE__HEIGHT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Recognize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeResponseImpl <em>Recognize Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeResponseImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRecognizeResponse()
	 * @generated
	 */
	int RECOGNIZE_RESPONSE = 80;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE_RESPONSE__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Recognize Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOGNIZE_RESPONSE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImageImpl <em>Contains Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImageImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getContainsImage()
	 * @generated
	 */
	int CONTAINS_IMAGE = 81;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_IMAGE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_IMAGE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_IMAGE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_IMAGE__IMAGE_URI = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Raw Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_IMAGE__RAW_IMAGE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contains Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_IMAGE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionTextImpl <em>Get Region Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRegionText()
	 * @generated
	 */
	int GET_REGION_TEXT = 82;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__X = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__Y = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__SX = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__SY = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__WIDTH = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__HEIGHT = CorePackage.COMMAND_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Get Region Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionImpl <em>Get Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRegion()
	 * @generated
	 */
	int GET_REGION = 83;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__X = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__Y = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__IMAGE_URI = SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raw Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION__RAW_IMAGE = SELECTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Get Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetAdvancedInfoImpl <em>Get Advanced Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetAdvancedInfoImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetAdvancedInfo()
	 * @generated
	 */
	int GET_ADVANCED_INFO = 84;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ADVANCED_INFO__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ADVANCED_INFO__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Advanced Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ADVANCED_INFO_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetAboutMenuImpl <em>Get About Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetAboutMenuImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetAboutMenu()
	 * @generated
	 */
	int GET_ABOUT_MENU = 85;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ABOUT_MENU__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ABOUT_MENU__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get About Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ABOUT_MENU_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPreferencesMenuImpl <em>Get Preferences Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPreferencesMenuImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetPreferencesMenu()
	 * @generated
	 */
	int GET_PREFERENCES_MENU = 86;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PREFERENCES_MENU__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PREFERENCES_MENU__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Preferences Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PREFERENCES_MENU_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetDateTimeImpl <em>Get Date Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetDateTimeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetDateTime()
	 * @generated
	 */
	int GET_DATE_TIME = 87;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DATE_TIME_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetSliderImpl <em>Get Slider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetSliderImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetSlider()
	 * @generated
	 */
	int GET_SLIDER = 88;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SLIDER_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetValueImpl <em>Set Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetValueImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetValue()
	 * @generated
	 */
	int SET_VALUE = 89;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MinimizeImpl <em>Minimize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MinimizeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMinimize()
	 * @generated
	 */
	int MINIMIZE = 90;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Minimize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MaximizeImpl <em>Maximize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MaximizeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMaximize()
	 * @generated
	 */
	int MAXIMIZE = 91;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Maximize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RestoreImpl <em>Restore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RestoreImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRestore()
	 * @generated
	 */
	int RESTORE = 92;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Restore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShowTabListImpl <em>Show Tab List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShowTabListImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShowTabList()
	 * @generated
	 */
	int SHOW_TAB_LIST = 93;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Show Tab List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.OptionsImpl <em>Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.OptionsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getOptions()
	 * @generated
	 */
	int OPTIONS = 94;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Allow Status Dialog</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__ALLOW_STATUS_DIALOG = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__COMMAND = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ExecWithOptionsImpl <em>Exec With Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ExecWithOptionsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getExecWithOptions()
	 * @generated
	 */
	int EXEC_WITH_OPTIONS = 95;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITH_OPTIONS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITH_OPTIONS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITH_OPTIONS__COMMAND = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allow Status Dialog</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITH_OPTIONS__ALLOW_STATUS_DIALOG = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Disable Job Waiting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITH_OPTIONS__DISABLE_JOB_WAITING = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Exec With Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_WITH_OPTIONS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShutdownAutImpl <em>Shutdown Aut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShutdownAutImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShutdownAut()
	 * @generated
	 */
	int SHUTDOWN_AUT = 96;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_AUT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_AUT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Shutdown Aut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_AUT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetDialogResultImpl <em>Set Dialog Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetDialogResultImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetDialogResult()
	 * @generated
	 */
	int SET_DIALOG_RESULT = 97;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DIALOG_RESULT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DIALOG_RESULT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DIALOG_RESULT__KIND = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DIALOG_RESULT__RESULT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Dialog Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_DIALOG_RESULT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyNodesImpl <em>Get Property Nodes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyNodesImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetPropertyNodes()
	 * @generated
	 */
	int GET_PROPERTY_NODES = 98;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_NODES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_NODES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_NODES__ELEMENT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_NODES__NODE_PATH = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Property Nodes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_NODES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetByOsImpl <em>Get By Os</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetByOsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetByOs()
	 * @generated
	 */
	int GET_BY_OS = 99;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS__DEFAULT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS__WIN = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Linux</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS__LINUX = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Macosx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS__MACOSX = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Get By Os</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BY_OS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.FromRawKeyImpl <em>From Raw Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.FromRawKeyImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getFromRawKey()
	 * @generated
	 */
	int FROM_RAW_KEY = 100;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_RAW_KEY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_RAW_KEY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_RAW_KEY__MASK = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_RAW_KEY__KEY_CODE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_RAW_KEY__META = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>From Raw Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_RAW_KEY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.HoverAtTextOffsetImpl <em>Hover At Text Offset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.HoverAtTextOffsetImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getHoverAtTextOffset()
	 * @generated
	 */
	int HOVER_AT_TEXT_OFFSET = 101;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__OFFSET = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__LINE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hover At Text Offset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTextViewerImpl <em>Get Text Viewer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTextViewerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTextViewer()
	 * @generated
	 */
	int GET_TEXT_VIEWER = 102;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Text Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_VIEWER_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SelectRangeImpl <em>Select Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SelectRangeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelectRange()
	 * @generated
	 */
	int SELECT_RANGE = 103;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__LINE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__END_LINE = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE__END_COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Select Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RANGE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetCaretPosImpl <em>Set Caret Pos</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetCaretPosImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetCaretPos()
	 * @generated
	 */
	int SET_CARET_POS = 104;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POS__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POS__LINE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POS__COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Caret Pos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.HoverTextImpl <em>Hover Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.HoverTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getHoverText()
	 * @generated
	 */
	int HOVER_TEXT = 105;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT__LINE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT__COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT__WITH = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Hover Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_TEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.OpenDeclarationImpl <em>Open Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.OpenDeclarationImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getOpenDeclaration()
	 * @generated
	 */
	int OPEN_DECLARATION = 106;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetVerticalRulerImpl <em>Get Vertical Ruler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetVerticalRulerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetVerticalRuler()
	 * @generated
	 */
	int GET_VERTICAL_RULER = 107;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Vertical Ruler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VERTICAL_RULER_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLeftRulerImpl <em>Get Left Ruler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLeftRulerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLeftRuler()
	 * @generated
	 */
	int GET_LEFT_RULER = 108;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Left Ruler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LEFT_RULER_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRulerColumnImpl <em>Get Ruler Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRulerColumnImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRulerColumn()
	 * @generated
	 */
	int GET_RULER_COLUMN = 109;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__PARENT = SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN__TEXT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Ruler Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RULER_COLUMN_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRightRulerImpl <em>Get Right Ruler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRightRulerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRightRuler()
	 * @generated
	 */
	int GET_RIGHT_RULER = 110;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Right Ruler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RIGHT_RULER_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickRulerImpl <em>Click Ruler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickRulerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickRuler()
	 * @generated
	 */
	int CLICK_RULER = 111;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER__LINE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER__BUTTON = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER__WITH = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Click Ruler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_RULER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickRulerImpl <em>Double Click Ruler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickRulerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDoubleClickRuler()
	 * @generated
	 */
	int DOUBLE_CLICK_RULER = 112;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER__LINE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER__BUTTON = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER__WITH = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Double Click Ruler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_RULER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.HoverRulerImpl <em>Hover Ruler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.HoverRulerImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getHoverRuler()
	 * @generated
	 */
	int HOVER_RULER = 113;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_RULER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_RULER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_RULER__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_RULER__LINE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_RULER__WITH = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hover Ruler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_RULER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ControlCommandImpl <em>Control Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ControlCommandImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getControlCommand()
	 * @generated
	 */
	int CONTROL_COMMAND = 114;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_COMMAND__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_COMMAND__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_COMMAND__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_COMMAND_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickLinkImpl <em>Click Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickLinkImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickLink()
	 * @generated
	 */
	int CLICK_LINK = 115;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__REF = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Click Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ExpandImpl <em>Expand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ExpandImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getExpand()
	 * @generated
	 */
	int EXPAND = 116;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Expand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CollapseImpl <em>Collapse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CollapseImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCollapse()
	 * @generated
	 */
	int COLLAPSE = 117;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Collapse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetFocusImpl <em>Set Focus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetFocusImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetFocus()
	 * @generated
	 */
	int SET_FOCUS = 118;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Set Focus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTableDataImpl <em>Get Table Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTableDataImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTableData()
	 * @generated
	 */
	int GET_TABLE_DATA = 119;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_DATA__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_DATA__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_DATA__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Include Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_DATA__INCLUDE_CHECKED = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exclude Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_DATA__EXCLUDE_HIDDEN = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Table Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_DATA_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickColumnImpl <em>Click Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickColumnImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickColumn()
	 * @generated
	 */
	int CLICK_COLUMN = 120;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__NAME = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__INDEX = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Click Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TraceImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 121;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__MESSAGE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MouseImpl <em>Mouse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MouseImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMouse()
	 * @generated
	 */
	int MOUSE = 122;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__EVENT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__BUTTON = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__WITH = CONTROL_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__COUNT = CONTROL_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__X = CONTROL_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__Y = CONTROL_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mouse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetObjectImpl <em>Get Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetObjectImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetObject()
	 * @generated
	 */
	int GET_OBJECT = 123;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_OBJECT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_OBJECT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_OBJECT__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_OBJECT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetItemsImpl <em>Get Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetItemsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetItems()
	 * @generated
	 */
	int GET_ITEMS = 124;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEMS__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEMS__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEMS__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Get Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEMS_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ExpandAllImpl <em>Expand All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ExpandAllImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getExpandAll()
	 * @generated
	 */
	int EXPAND_ALL = 125;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ALL__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ALL__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ALL__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Expand All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ALL_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CollapseAllImpl <em>Collapse All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CollapseAllImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCollapseAll()
	 * @generated
	 */
	int COLLAPSE_ALL = 126;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE_ALL__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE_ALL__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE_ALL__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Collapse All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE_ALL_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TakeScreenshotImpl <em>Take Screenshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TakeScreenshotImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTakeScreenshot()
	 * @generated
	 */
	int TAKE_SCREENSHOT = 127;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAKE_SCREENSHOT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAKE_SCREENSHOT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAKE_SCREENSHOT__MESSAGE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Take Screenshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAKE_SCREENSHOT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SelectItemImpl <em>Select Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SelectItemImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelectItem()
	 * @generated
	 */
	int SELECT_ITEM = 128;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ITEM__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ITEM__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ITEM__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Select Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ITEM_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetWidgetDetailsImpl <em>Get Widget Details</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetWidgetDetailsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetWidgetDetails()
	 * @generated
	 */
	int GET_WIDGET_DETAILS = 129;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WIDGET_DETAILS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WIDGET_DETAILS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WIDGET_DETAILS__ELEMENT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Widget Details</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WIDGET_DETAILS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickTextImpl <em>Click Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickText()
	 * @generated
	 */
	int CLICK_TEXT = 130;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__START = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__END = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__BUTTON = CONTROL_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Click Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetQuickAccessImpl <em>Get Quick Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetQuickAccessImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetQuickAccess()
	 * @generated
	 */
	int GET_QUICK_ACCESS = 131;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__HOST = SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__BINDINGS = SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__ID = SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__AFTER = SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__TYPE = SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__INDEX = SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS__PARENT = SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Quick Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_QUICK_ACCESS_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetColumnHeaderImpl <em>Get Column Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetColumnHeaderImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetColumnHeader()
	 * @generated
	 */
	int GET_COLUMN_HEADER = 132;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Column Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLUMN_HEADER_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetPositionImpl <em>Set Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetPositionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetPosition()
	 * @generated
	 */
	int SET_POSITION = 133;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__INDEX = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetWidthImpl <em>Set Width</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetWidthImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetWidth()
	 * @generated
	 */
	int SET_WIDTH = 134;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__WIDTH = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Width</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyTabImpl <em>Get Property Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyTabImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetPropertyTab()
	 * @generated
	 */
	int GET_PROPERTY_TAB = 135;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__HOST = TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__BINDINGS = TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__ID = TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__AFTER = TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__TYPE = TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__INDEX = TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__PARENT = TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB__TEXT = TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Property Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_TAB_FEATURE_COUNT = TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShowAlertImpl <em>Show Alert</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShowAlertImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShowAlert()
	 * @generated
	 */
	int SHOW_ALERT = 136;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_ALERT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_ALERT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_ALERT__MESSAGE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Show Alert</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_ALERT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickTextImpl <em>Double Click Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickTextImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDoubleClickText()
	 * @generated
	 */
	int DOUBLE_CLICK_TEXT = 137;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__POSITION = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__BUTTON = CONTROL_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Click Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ToControlHandleImpl <em>To Control Handle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ToControlHandleImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getToControlHandle()
	 * @generated
	 */
	int TO_CONTROL_HANDLE = 138;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_CONTROL_HANDLE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_CONTROL_HANDLE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_CONTROL_HANDLE__WIDGET = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>To Control Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_CONTROL_HANDLE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.BoundControlHandleImpl <em>Bound Control Handle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.BoundControlHandleImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getBoundControlHandle()
	 * @generated
	 */
	int BOUND_CONTROL_HANDLE = 139;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__KIND = CONTROL_HANDLER__KIND;

	/**
	 * The feature id for the '<em><b>Custom Kind Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__CUSTOM_KIND_ID = CONTROL_HANDLER__CUSTOM_KIND_ID;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__TEXT = CONTROL_HANDLER__TEXT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__TYPE = CONTROL_HANDLER__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__INDEX = CONTROL_HANDLER__INDEX;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__PATH = CONTROL_HANDLER__PATH;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__INDEXES = CONTROL_HANDLER__INDEXES;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__AFTER = CONTROL_HANDLER__AFTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__PARENT = CONTROL_HANDLER__PARENT;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__RESOLVED = CONTROL_HANDLER__RESOLVED;

	/**
	 * The feature id for the '<em><b>Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__ROW = CONTROL_HANDLER__ROW;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__COLUMN = CONTROL_HANDLER__COLUMN;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__X = CONTROL_HANDLER__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__Y = CONTROL_HANDLER__Y;

	/**
	 * The feature id for the '<em><b>Raw Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__RAW_IMAGE = CONTROL_HANDLER__RAW_IMAGE;

	/**
	 * The feature id for the '<em><b>Widget Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE__WIDGET_ID = CONTROL_HANDLER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bound Control Handle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_CONTROL_HANDLE_FEATURE_COUNT = CONTROL_HANDLER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.UnfocusImpl <em>Unfocus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.UnfocusImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getUnfocus()
	 * @generated
	 */
	int UNFOCUS = 140;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNFOCUS__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNFOCUS__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNFOCUS__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Unfocus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNFOCUS_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DecryptImpl <em>Decrypt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DecryptImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDecrypt()
	 * @generated
	 */
	int DECRYPT = 141;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECRYPT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECRYPT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECRYPT__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decrypt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECRYPT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DecryptResultImpl <em>Decrypt Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DecryptResultImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDecryptResult()
	 * @generated
	 */
	int DECRYPT_RESULT = 142;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECRYPT_RESULT__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Decrypt Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECRYPT_RESULT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RestartAutImpl <em>Restart Aut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RestartAutImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRestartAut()
	 * @generated
	 */
	int RESTART_AUT = 143;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTART_AUT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTART_AUT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Restart Aut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTART_AUT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MessageBoxInfoImpl <em>Message Box Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MessageBoxInfoImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMessageBoxInfo()
	 * @generated
	 */
	int MESSAGE_BOX_INFO = 144;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BOX_INFO__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BOX_INFO__MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Message Box Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BOX_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLastMessageBoxImpl <em>Get Last Message Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLastMessageBoxImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLastMessageBox()
	 * @generated
	 */
	int GET_LAST_MESSAGE_BOX = 145;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LAST_MESSAGE_BOX__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LAST_MESSAGE_BOX__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Last Message Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LAST_MESSAGE_BOX_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CheckDownloadResultImpl <em>Check Download Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CheckDownloadResultImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCheckDownloadResult()
	 * @generated
	 */
	int CHECK_DOWNLOAD_RESULT = 146;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_DOWNLOAD_RESULT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_DOWNLOAD_RESULT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Content On Base64</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_DOWNLOAD_RESULT__CONTENT_ON_BASE64 = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_DOWNLOAD_RESULT__FILE_NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Check Download Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_DOWNLOAD_RESULT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRuntimeTargetImpl <em>Get Runtime Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRuntimeTargetImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRuntimeTarget()
	 * @generated
	 */
	int GET_RUNTIME_TARGET = 147;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RUNTIME_TARGET__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RUNTIME_TARGET__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Runtime Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_RUNTIME_TARGET_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTestCaseNameImpl <em>Get Test Case Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTestCaseNameImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTestCaseName()
	 * @generated
	 */
	int GET_TEST_CASE_NAME = 148;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEST_CASE_NAME__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEST_CASE_NAME__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Test Case Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEST_CASE_NAME_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetComboItemsImpl <em>Get Combo Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetComboItemsImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetComboItems()
	 * @generated
	 */
	int GET_COMBO_ITEMS = 149;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO_ITEMS__HOST = CONTROL_COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO_ITEMS__BINDINGS = CONTROL_COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO_ITEMS__CONTROL = CONTROL_COMMAND__CONTROL;

	/**
	 * The number of structural features of the '<em>Get Combo Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COMBO_ITEMS_FEATURE_COUNT = CONTROL_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.Button <em>Button</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.Button
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 150;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.ActivationEventType <em>Activation Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.ActivationEventType
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getActivationEventType()
	 * @generated
	 */
	int ACTIVATION_EVENT_TYPE = 151;

	/**
	 * The meta object id for the '<em>Element Kind</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.ElementKind
	 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getElementKind()
	 * @generated
	 */
	int ELEMENT_KIND = 152;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Wait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Wait
	 * @generated
	 */
	EClass getWait();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Wait#getMs <em>Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ms</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Wait#getMs()
	 * @see #getWait()
	 * @generated
	 */
	EAttribute getWait_Ms();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetupPlayer <em>Setup Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setup Player</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetupPlayer
	 * @generated
	 */
	EClass getSetupPlayer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ShoutdownPlayer <em>Shoutdown Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shoutdown Player</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShoutdownPlayer
	 * @generated
	 */
	EClass getShoutdownPlayer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus <em>Process Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Status</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus
	 * @generated
	 */
	EClass getTeslaProcessStatus();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus#getInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Info</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus#getInfo()
	 * @see #getTeslaProcessStatus()
	 * @generated
	 */
	EReference getTeslaProcessStatus_Info();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Wrapper <em>Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wrapper</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Wrapper
	 * @generated
	 */
	EClass getWrapper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Wrapper#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Wrapper#getObject()
	 * @see #getWrapper()
	 * @generated
	 */
	EAttribute getWrapper_Object();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetProperty <em>Get Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Property</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetProperty
	 * @generated
	 */
	EClass getGetProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.GetProperty#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetProperty#getObject()
	 * @see #getGetProperty()
	 * @generated
	 */
	EReference getGetProperty_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetProperty#getName()
	 * @see #getGetProperty()
	 * @generated
	 */
	EAttribute getGetProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetProperty#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetProperty#getIndex()
	 * @see #getGetProperty()
	 * @generated
	 */
	EAttribute getGetProperty_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetProperty#isRaw <em>Raw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetProperty#isRaw()
	 * @see #getGetProperty()
	 * @generated
	 */
	EAttribute getGetProperty_Raw();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyTrue <em>Verify True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verify True</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyTrue
	 * @generated
	 */
	EClass getVerifyTrue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyTrue#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyTrue#getCondition()
	 * @see #getVerifyTrue()
	 * @generated
	 */
	EReference getVerifyTrue_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyFalse <em>Verify False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verify False</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyFalse
	 * @generated
	 */
	EClass getVerifyFalse();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyFalse#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyFalse#getCondition()
	 * @see #getVerifyFalse()
	 * @generated
	 */
	EReference getVerifyFalse_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler <em>Verify Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verify Handler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyHandler
	 * @generated
	 */
	EClass getVerifyHandler();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getElement()
	 * @see #getVerifyHandler()
	 * @generated
	 */
	EReference getVerifyHandler_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getAttribute()
	 * @see #getVerifyHandler()
	 * @generated
	 */
	EAttribute getVerifyHandler_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getValue()
	 * @see #getVerifyHandler()
	 * @generated
	 */
	EAttribute getVerifyHandler_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getKind()
	 * @see #getVerifyHandler()
	 * @generated
	 */
	EAttribute getVerifyHandler_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getIndex()
	 * @see #getVerifyHandler()
	 * @generated
	 */
	EAttribute getVerifyHandler_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyError <em>Verify Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verify Error</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyError
	 * @generated
	 */
	EClass getVerifyError();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyError#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.VerifyError#getCommand()
	 * @see #getVerifyError()
	 * @generated
	 */
	EReference getVerifyError_Command();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Equals <em>Equals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equals</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Equals
	 * @generated
	 */
	EClass getEquals();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Equals#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Equals#getInput()
	 * @see #getEquals()
	 * @generated
	 */
	EReference getEquals_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Equals#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Equals#getValue()
	 * @see #getEquals()
	 * @generated
	 */
	EAttribute getEquals_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Contains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Contains
	 * @generated
	 */
	EClass getContains();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Contains#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Contains#getInput()
	 * @see #getContains()
	 * @generated
	 */
	EReference getContains_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Contains#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Contains#getValue()
	 * @see #getContains()
	 * @generated
	 */
	EAttribute getContains_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Matches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matches</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Matches
	 * @generated
	 */
	EClass getMatches();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Matches#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Matches#getInput()
	 * @see #getMatches()
	 * @generated
	 */
	EReference getMatches_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Matches#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Matches#getValue()
	 * @see #getMatches()
	 * @generated
	 */
	EAttribute getMatches_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.IsEmpty <em>Is Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Empty</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.IsEmpty
	 * @generated
	 */
	EClass getIsEmpty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.IsEmpty#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.IsEmpty#getInput()
	 * @see #getIsEmpty()
	 * @generated
	 */
	EReference getIsEmpty_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Unsupported <em>Unsupported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unsupported</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Unsupported
	 * @generated
	 */
	EClass getUnsupported();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Unsupported#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Unsupported#getDesc()
	 * @see #getUnsupported()
	 * @generated
	 */
	EAttribute getUnsupported_Desc();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ControlNotFound <em>Control Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Not Found</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlNotFound
	 * @generated
	 */
	EClass getControlNotFound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlNotFound#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlNotFound#getId()
	 * @see #getControlNotFound()
	 * @generated
	 */
	EAttribute getControlNotFound_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler <em>Control Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Handler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler
	 * @generated
	 */
	EClass getControlHandler();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getKind()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getCustomKindId <em>Custom Kind Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Kind Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getCustomKindId()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_CustomKindId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getText()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getType()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndex()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getPath()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndexes <em>Indexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indexes</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndexes()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Indexes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>After</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getAfter()
	 * @see #getControlHandler()
	 * @generated
	 */
	EReference getControlHandler_After();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getParent()
	 * @see #getControlHandler()
	 * @generated
	 */
	EReference getControlHandler_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getResolved()
	 * @see #getControlHandler()
	 * @generated
	 */
	EReference getControlHandler_Resolved();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Row</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRow()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Row();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getColumn()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getX()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getY()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRawImage <em>Raw Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Image</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRawImage()
	 * @see #getControlHandler()
	 * @generated
	 */
	EAttribute getControlHandler_RawImage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetEclipseWindow <em>Get Eclipse Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Eclipse Window</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetEclipseWindow
	 * @generated
	 */
	EClass getGetEclipseWindow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Selector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selector</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector
	 * @generated
	 */
	EClass getSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Selector#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector#getId()
	 * @see #getSelector()
	 * @generated
	 */
	EAttribute getSelector_Id();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Selector#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>After</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector#getAfter()
	 * @see #getSelector()
	 * @generated
	 */
	EReference getSelector_After();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Selector#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector#getType()
	 * @see #getSelector()
	 * @generated
	 */
	EAttribute getSelector_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Selector#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector#getIndex()
	 * @see #getSelector()
	 * @generated
	 */
	EAttribute getSelector_Index();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Selector#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector#getParent()
	 * @see #getSelector()
	 * @generated
	 */
	EReference getSelector_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.PathSelector <em>Path Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Selector</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.PathSelector
	 * @generated
	 */
	EClass getPathSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.PathSelector#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.PathSelector#getPath()
	 * @see #getPathSelector()
	 * @generated
	 */
	EAttribute getPathSelector_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.TextSelector <em>Text Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Selector</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TextSelector
	 * @generated
	 */
	EClass getTextSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.TextSelector#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TextSelector#getText()
	 * @see #getTextSelector()
	 * @generated
	 */
	EAttribute getTextSelector_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetControl <em>Get Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetControl
	 * @generated
	 */
	EClass getGetControl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetControl#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetControl#getKind()
	 * @see #getGetControl()
	 * @generated
	 */
	EAttribute getGetControl_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetButton <em>Get Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetButton
	 * @generated
	 */
	EClass getGetButton();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetCanvas <em>Get Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Canvas</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCanvas
	 * @generated
	 */
	EClass getGetCanvas();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetCheckbox <em>Get Checkbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Checkbox</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCheckbox
	 * @generated
	 */
	EClass getGetCheckbox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetCombo <em>Get Combo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Combo</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCombo
	 * @generated
	 */
	EClass getGetCombo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetEditbox <em>Get Editbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Editbox</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetEditbox
	 * @generated
	 */
	EClass getGetEditbox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetGroup <em>Get Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Group</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetGroup
	 * @generated
	 */
	EClass getGetGroup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetItem <em>Get Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Item</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetItem
	 * @generated
	 */
	EClass getGetItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetItem#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetItem#getPath()
	 * @see #getGetItem()
	 * @generated
	 */
	EAttribute getGetItem_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetItem#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetItem#getColumn()
	 * @see #getGetItem()
	 * @generated
	 */
	EAttribute getGetItem_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetLabel <em>Get Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Label</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetLabel
	 * @generated
	 */
	EClass getGetLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetLink <em>Get Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Link</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetLink
	 * @generated
	 */
	EClass getGetLink();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetList <em>Get List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get List</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetList
	 * @generated
	 */
	EClass getGetList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetMenu <em>Get Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Menu</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetMenu
	 * @generated
	 */
	EClass getGetMenu();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTabFolder <em>Get Tab Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Tab Folder</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTabFolder
	 * @generated
	 */
	EClass getGetTabFolder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTabItem <em>Get Tab Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Tab Item</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTabItem
	 * @generated
	 */
	EClass getGetTabItem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTable <em>Get Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Table</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTable
	 * @generated
	 */
	EClass getGetTable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetToolbar <em>Get Toolbar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Toolbar</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetToolbar
	 * @generated
	 */
	EClass getGetToolbar();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTree <em>Get Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Tree</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTree
	 * @generated
	 */
	EClass getGetTree();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetWindow <em>Get Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Window</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetWindow
	 * @generated
	 */
	EClass getGetWindow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetWindow#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetWindow#getText()
	 * @see #getGetWindow()
	 * @generated
	 */
	EAttribute getGetWindow_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetWindow#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetWindow#getFrom()
	 * @see #getGetWindow()
	 * @generated
	 */
	EAttribute getGetWindow_From();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetWindow#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetWindow#getClass_()
	 * @see #getGetWindow()
	 * @generated
	 */
	EAttribute getGetWindow_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetView <em>Get View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get View</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetView
	 * @generated
	 */
	EClass getGetView();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetEditor <em>Get Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Editor</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetEditor
	 * @generated
	 */
	EClass getGetEditor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetSection <em>Get Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Section</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetSection
	 * @generated
	 */
	EClass getGetSection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetBanner <em>Get Banner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Banner</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetBanner
	 * @generated
	 */
	EClass getGetBanner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetCoolbar <em>Get Coolbar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Coolbar</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCoolbar
	 * @generated
	 */
	EClass getGetCoolbar();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetColorSelector <em>Get Color Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Color Selector</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetColorSelector
	 * @generated
	 */
	EClass getGetColorSelector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetCell <em>Get Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Cell</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCell
	 * @generated
	 */
	EClass getGetCell();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetCell#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Row</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCell#getRow()
	 * @see #getGetCell()
	 * @generated
	 */
	EAttribute getGetCell_Row();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetCell#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetCell#getColumn()
	 * @see #getGetCell()
	 * @generated
	 */
	EAttribute getGetCell_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Click <em>Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Click
	 * @generated
	 */
	EClass getClick();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Click#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Click#getControl()
	 * @see #getClick()
	 * @generated
	 */
	EReference getClick_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Click#isNowait <em>Nowait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nowait</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Click#isNowait()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_Nowait();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Click#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Click#isDefault()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Click#isArrow <em>Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrow</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Click#isArrow()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_Arrow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Click#getMetaKeys <em>Meta Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Keys</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Click#getMetaKeys()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_MetaKeys();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClick <em>Double Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Click</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClick
	 * @generated
	 */
	EClass getDoubleClick();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetText <em>Get Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetText
	 * @generated
	 */
	EClass getGetText();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.GetText#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetText#getControl()
	 * @see #getGetText()
	 * @generated
	 */
	EReference getGetText_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.IsDisabled <em>Is Disabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Disabled</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.IsDisabled
	 * @generated
	 */
	EClass getIsDisabled();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.IsDisabled#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.IsDisabled#getControl()
	 * @see #getIsDisabled()
	 * @generated
	 */
	EReference getIsDisabled_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.IsDisposed <em>Is Disposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Disposed</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.IsDisposed
	 * @generated
	 */
	EClass getIsDisposed();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.IsDisposed#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.IsDisposed#getControl()
	 * @see #getIsDisposed()
	 * @generated
	 */
	EReference getIsDisposed_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText <em>Type Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeText
	 * @generated
	 */
	EClass getTypeText();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeText#getControl()
	 * @see #getTypeText()
	 * @generated
	 */
	EReference getTypeText_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeText#getText()
	 * @see #getTypeText()
	 * @generated
	 */
	EAttribute getTypeText_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.TypeText#isDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeText#isDisplay()
	 * @see #getTypeText()
	 * @generated
	 */
	EAttribute getTypeText_Display();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.KeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Type</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.KeyType
	 * @generated
	 */
	EClass getKeyType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.KeyType#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.KeyType#getControl()
	 * @see #getKeyType()
	 * @generated
	 */
	EReference getKeyType_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.KeyType#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.KeyType#getKey()
	 * @see #getKeyType()
	 * @generated
	 */
	EAttribute getKeyType_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.KeyType#getChar <em>Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Char</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.KeyType#getChar()
	 * @see #getKeyType()
	 * @generated
	 */
	EAttribute getKeyType_Char();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.KeyType#isDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.KeyType#isDisplay()
	 * @see #getKeyType()
	 * @generated
	 */
	EAttribute getKeyType_Display();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.KeyType#getTimes <em>Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.KeyType#getTimes()
	 * @see #getKeyType()
	 * @generated
	 */
	EAttribute getKeyType_Times();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey <em>Type Command Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Command Key</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey
	 * @generated
	 */
	EClass getTypeCommandKey();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey#getControl()
	 * @see #getTypeCommandKey()
	 * @generated
	 */
	EReference getTypeCommandKey_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey#getCommandId <em>Command Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey#getCommandId()
	 * @see #getTypeCommandKey()
	 * @generated
	 */
	EAttribute getTypeCommandKey_CommandId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetText <em>Set Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetText
	 * @generated
	 */
	EClass getSetText();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.SetText#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetText#getControl()
	 * @see #getSetText()
	 * @generated
	 */
	EReference getSetText_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetText#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetText#getText()
	 * @see #getSetText()
	 * @generated
	 */
	EAttribute getSetText_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection <em>Set Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection
	 * @generated
	 */
	EClass getSetTextSelection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getControl()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EReference getSetTextSelection_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getOffset()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getLength()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getStartLine()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndLine()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndOffset <em>End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndOffset()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_EndOffset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextOffset <em>Set Text Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextOffset
	 * @generated
	 */
	EClass getSetTextOffset();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextOffset#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextOffset#getControl()
	 * @see #getSetTextOffset()
	 * @generated
	 */
	EReference getSetTextOffset_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextOffset#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextOffset#getValue()
	 * @see #getSetTextOffset()
	 * @generated
	 */
	EAttribute getSetTextOffset_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextOffset#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetTextOffset#getLine()
	 * @see #getSetTextOffset()
	 * @generated
	 */
	EAttribute getSetTextOffset_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Check
	 * @generated
	 */
	EClass getCheck();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Check#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Check#getControl()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Uncheck <em>Uncheck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uncheck</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Uncheck
	 * @generated
	 */
	EClass getUncheck();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Uncheck#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Uncheck#getControl()
	 * @see #getUncheck()
	 * @generated
	 */
	EReference getUncheck_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Select
	 * @generated
	 */
	EClass getSelect();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Select#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Select#getControl()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Control();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.ecl.model.Select#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Select#getItems()
	 * @see #getSelect()
	 * @generated
	 */
	EAttribute getSelect_Items();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Select#isAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Select#isAll()
	 * @see #getSelect()
	 * @generated
	 */
	EAttribute getSelect_All();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Select#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Select#getColumn()
	 * @see #getSelect()
	 * @generated
	 */
	EAttribute getSelect_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.CellEdit <em>Cell Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CellEdit
	 * @generated
	 */
	EClass getCellEdit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.CellEdit#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CellEdit#getControl()
	 * @see #getCellEdit()
	 * @generated
	 */
	EReference getCellEdit_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit <em>Activate Cell Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activate Cell Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit
	 * @generated
	 */
	EClass getActivateCellEdit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit#getColumn()
	 * @see #getActivateCellEdit()
	 * @generated
	 */
	EAttribute getActivateCellEdit_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit#getType()
	 * @see #getActivateCellEdit()
	 * @generated
	 */
	EAttribute getActivateCellEdit_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit#getButton()
	 * @see #getActivateCellEdit()
	 * @generated
	 */
	EAttribute getActivateCellEdit_Button();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit <em>Apply Cell Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apply Cell Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit
	 * @generated
	 */
	EClass getApplyCellEdit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit#isDeactivate <em>Deactivate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deactivate</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit#isDeactivate()
	 * @see #getApplyCellEdit()
	 * @generated
	 */
	EAttribute getApplyCellEdit_Deactivate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.CancelCellEdit <em>Cancel Cell Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cancel Cell Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CancelCellEdit
	 * @generated
	 */
	EClass getCancelCellEdit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DeactivateCellEdit <em>Deactivate Cell Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deactivate Cell Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DeactivateCellEdit
	 * @generated
	 */
	EClass getDeactivateCellEdit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Close <em>Close</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Close
	 * @generated
	 */
	EClass getClose();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Close#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Close#getControl()
	 * @see #getClose()
	 * @generated
	 */
	EReference getClose_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog <em>Return From Os Dialog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return From Os Dialog</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog
	 * @generated
	 */
	EClass getReturnFromOsDialog();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog#getKind()
	 * @see #getReturnFromOsDialog()
	 * @generated
	 */
	EAttribute getReturnFromOsDialog_Kind();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Result</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog#getResult()
	 * @see #getReturnFromOsDialog()
	 * @generated
	 */
	EAttribute getReturnFromOsDialog_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.WaitUntilEclipseIsReady <em>Wait Until Eclipse Is Ready</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Until Eclipse Is Ready</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.WaitUntilEclipseIsReady
	 * @generated
	 */
	EClass getWaitUntilEclipseIsReady();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ShowContentAssist <em>Show Content Assist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Content Assist</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShowContentAssist
	 * @generated
	 */
	EClass getShowContentAssist();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ShowContentAssist#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShowContentAssist#getControl()
	 * @see #getShowContentAssist()
	 * @generated
	 */
	EReference getShowContentAssist_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction <em>Drag Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Action</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction
	 * @generated
	 */
	EClass getDragAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getControl()
	 * @see #getDragAction()
	 * @generated
	 */
	EReference getDragAction_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getX()
	 * @see #getDragAction()
	 * @generated
	 */
	EAttribute getDragAction_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getY()
	 * @see #getDragAction()
	 * @generated
	 */
	EAttribute getDragAction_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getButton()
	 * @see #getDragAction()
	 * @generated
	 */
	EAttribute getDragAction_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getMask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getMask()
	 * @see #getDragAction()
	 * @generated
	 */
	EAttribute getDragAction_Mask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getDetail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detail</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getDetail()
	 * @see #getDragAction()
	 * @generated
	 */
	EAttribute getDragAction_Detail();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DragAction#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAction#getOperation()
	 * @see #getDragAction()
	 * @generated
	 */
	EAttribute getDragAction_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragStart <em>Drag Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Start</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragStart
	 * @generated
	 */
	EClass getDragStart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragEnd <em>Drag End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag End</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragEnd
	 * @generated
	 */
	EClass getDragEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragEnter <em>Drag Enter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Enter</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragEnter
	 * @generated
	 */
	EClass getDragEnter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragExit <em>Drag Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Exit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragExit
	 * @generated
	 */
	EClass getDragExit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragSetData <em>Drag Set Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Set Data</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragSetData
	 * @generated
	 */
	EClass getDragSetData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragAccept <em>Drag Accept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Accept</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragAccept
	 * @generated
	 */
	EClass getDragAccept();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragDetect <em>Drag Detect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Detect</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragDetect
	 * @generated
	 */
	EClass getDragDetect();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DragOver <em>Drag Over</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Over</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DragOver
	 * @generated
	 */
	EClass getDragOver();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Drop <em>Drop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drop</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Drop
	 * @generated
	 */
	EClass getDrop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Recognize <em>Recognize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recognize</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Recognize
	 * @generated
	 */
	EClass getRecognize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Recognize#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Recognize#getImage()
	 * @see #getRecognize()
	 * @generated
	 */
	EAttribute getRecognize_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Recognize#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Recognize#getX()
	 * @see #getRecognize()
	 * @generated
	 */
	EAttribute getRecognize_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Recognize#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Recognize#getY()
	 * @see #getRecognize()
	 * @generated
	 */
	EAttribute getRecognize_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Recognize#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Recognize#getWidth()
	 * @see #getRecognize()
	 * @generated
	 */
	EAttribute getRecognize_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Recognize#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Recognize#getHeight()
	 * @see #getRecognize()
	 * @generated
	 */
	EAttribute getRecognize_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.RecognizeResponse <em>Recognize Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recognize Response</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.RecognizeResponse
	 * @generated
	 */
	EClass getRecognizeResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.RecognizeResponse#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.RecognizeResponse#getText()
	 * @see #getRecognizeResponse()
	 * @generated
	 */
	EAttribute getRecognizeResponse_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage <em>Contains Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains Image</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ContainsImage
	 * @generated
	 */
	EClass getContainsImage();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getControl()
	 * @see #getContainsImage()
	 * @generated
	 */
	EReference getContainsImage_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getImageURI <em>Image URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image URI</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getImageURI()
	 * @see #getContainsImage()
	 * @generated
	 */
	EAttribute getContainsImage_ImageURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getRawImage <em>Raw Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Image</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getRawImage()
	 * @see #getContainsImage()
	 * @generated
	 */
	EAttribute getContainsImage_RawImage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText <em>Get Region Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Region Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText
	 * @generated
	 */
	EClass getGetRegionText();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getControl()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EReference getGetRegionText_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getX()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getY()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSx <em>Sx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sx</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSx()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Sx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSy <em>Sy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sy</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSy()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Sy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getWidth()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getHeight()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion <em>Get Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Region</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegion
	 * @generated
	 */
	EClass getGetRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegion#getX()
	 * @see #getGetRegion()
	 * @generated
	 */
	EAttribute getGetRegion_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegion#getY()
	 * @see #getGetRegion()
	 * @generated
	 */
	EAttribute getGetRegion_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getImageURI <em>Image URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image URI</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegion#getImageURI()
	 * @see #getGetRegion()
	 * @generated
	 */
	EAttribute getGetRegion_ImageURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getRawImage <em>Raw Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Image</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRegion#getRawImage()
	 * @see #getGetRegion()
	 * @generated
	 */
	EAttribute getGetRegion_RawImage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetAdvancedInfo <em>Get Advanced Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Advanced Info</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetAdvancedInfo
	 * @generated
	 */
	EClass getGetAdvancedInfo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetAboutMenu <em>Get About Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get About Menu</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetAboutMenu
	 * @generated
	 */
	EClass getGetAboutMenu();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetPreferencesMenu <em>Get Preferences Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Preferences Menu</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetPreferencesMenu
	 * @generated
	 */
	EClass getGetPreferencesMenu();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetDateTime <em>Get Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Date Time</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetDateTime
	 * @generated
	 */
	EClass getGetDateTime();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetSlider <em>Get Slider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Slider</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetSlider
	 * @generated
	 */
	EClass getGetSlider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetValue <em>Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetValue
	 * @generated
	 */
	EClass getSetValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.SetValue#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetValue#getControl()
	 * @see #getSetValue()
	 * @generated
	 */
	EReference getSetValue_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetValue#getValue()
	 * @see #getSetValue()
	 * @generated
	 */
	EAttribute getSetValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Minimize <em>Minimize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minimize</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Minimize
	 * @generated
	 */
	EClass getMinimize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Minimize#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Minimize#getControl()
	 * @see #getMinimize()
	 * @generated
	 */
	EReference getMinimize_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Maximize <em>Maximize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maximize</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Maximize
	 * @generated
	 */
	EClass getMaximize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Maximize#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Maximize#getControl()
	 * @see #getMaximize()
	 * @generated
	 */
	EReference getMaximize_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Restore <em>Restore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restore</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Restore
	 * @generated
	 */
	EClass getRestore();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Restore#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Restore#getControl()
	 * @see #getRestore()
	 * @generated
	 */
	EReference getRestore_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ShowTabList <em>Show Tab List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Tab List</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShowTabList
	 * @generated
	 */
	EClass getShowTabList();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ShowTabList#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShowTabList#getControl()
	 * @see #getShowTabList()
	 * @generated
	 */
	EReference getShowTabList_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Options <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Options</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Options
	 * @generated
	 */
	EClass getOptions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Options#isAllowStatusDialog <em>Allow Status Dialog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Status Dialog</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Options#isAllowStatusDialog()
	 * @see #getOptions()
	 * @generated
	 */
	EAttribute getOptions_AllowStatusDialog();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.Options#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Options#getCommand()
	 * @see #getOptions()
	 * @generated
	 */
	EReference getOptions_Command();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions <em>Exec With Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec With Options</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions
	 * @generated
	 */
	EClass getExecWithOptions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions#getCommand()
	 * @see #getExecWithOptions()
	 * @generated
	 */
	EReference getExecWithOptions_Command();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions#isAllowStatusDialog <em>Allow Status Dialog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Status Dialog</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions#isAllowStatusDialog()
	 * @see #getExecWithOptions()
	 * @generated
	 */
	EAttribute getExecWithOptions_AllowStatusDialog();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions#isDisableJobWaiting <em>Disable Job Waiting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disable Job Waiting</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions#isDisableJobWaiting()
	 * @see #getExecWithOptions()
	 * @generated
	 */
	EAttribute getExecWithOptions_DisableJobWaiting();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ShutdownAut <em>Shutdown Aut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shutdown Aut</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShutdownAut
	 * @generated
	 */
	EClass getShutdownAut();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetDialogResult <em>Set Dialog Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Dialog Result</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetDialogResult
	 * @generated
	 */
	EClass getSetDialogResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetDialogResult#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetDialogResult#getKind()
	 * @see #getSetDialogResult()
	 * @generated
	 */
	EAttribute getSetDialogResult_Kind();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.ecl.model.SetDialogResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Result</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetDialogResult#getResult()
	 * @see #getSetDialogResult()
	 * @generated
	 */
	EAttribute getSetDialogResult_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes <em>Get Property Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Property Nodes</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes
	 * @generated
	 */
	EClass getGetPropertyNodes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getElement()
	 * @see #getGetPropertyNodes()
	 * @generated
	 */
	EReference getGetPropertyNodes_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getNodePath <em>Node Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Path</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getNodePath()
	 * @see #getGetPropertyNodes()
	 * @generated
	 */
	EAttribute getGetPropertyNodes_NodePath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs <em>Get By Os</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get By Os</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetByOs
	 * @generated
	 */
	EClass getGetByOs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetByOs#getDefault()
	 * @see #getGetByOs()
	 * @generated
	 */
	EAttribute getGetByOs_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getWin <em>Win</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Win</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetByOs#getWin()
	 * @see #getGetByOs()
	 * @generated
	 */
	EAttribute getGetByOs_Win();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getLinux <em>Linux</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linux</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetByOs#getLinux()
	 * @see #getGetByOs()
	 * @generated
	 */
	EAttribute getGetByOs_Linux();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getMacosx <em>Macosx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Macosx</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetByOs#getMacosx()
	 * @see #getGetByOs()
	 * @generated
	 */
	EAttribute getGetByOs_Macosx();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey <em>From Raw Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From Raw Key</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.FromRawKey
	 * @generated
	 */
	EClass getFromRawKey();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMask()
	 * @see #getFromRawKey()
	 * @generated
	 */
	EAttribute getFromRawKey_Mask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getKeyCode <em>Key Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Code</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getKeyCode()
	 * @see #getFromRawKey()
	 * @generated
	 */
	EAttribute getFromRawKey_KeyCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMeta()
	 * @see #getFromRawKey()
	 * @generated
	 */
	EAttribute getFromRawKey_Meta();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset <em>Hover At Text Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hover At Text Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset
	 * @generated
	 */
	EClass getHoverAtTextOffset();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getControl()
	 * @see #getHoverAtTextOffset()
	 * @generated
	 */
	EReference getHoverAtTextOffset_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getOffset()
	 * @see #getHoverAtTextOffset()
	 * @generated
	 */
	EAttribute getHoverAtTextOffset_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getLine()
	 * @see #getHoverAtTextOffset()
	 * @generated
	 */
	EAttribute getHoverAtTextOffset_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTextViewer <em>Get Text Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Viewer</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTextViewer
	 * @generated
	 */
	EClass getGetTextViewer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SelectRange <em>Select Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Range</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectRange
	 * @generated
	 */
	EClass getSelectRange();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.SelectRange#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectRange#getControl()
	 * @see #getSelectRange()
	 * @generated
	 */
	EReference getSelectRange_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SelectRange#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectRange#getLine()
	 * @see #getSelectRange()
	 * @generated
	 */
	EAttribute getSelectRange_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SelectRange#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectRange#getColumn()
	 * @see #getSelectRange()
	 * @generated
	 */
	EAttribute getSelectRange_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SelectRange#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectRange#getEndLine()
	 * @see #getSelectRange()
	 * @generated
	 */
	EAttribute getSelectRange_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SelectRange#getEndColumn <em>End Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectRange#getEndColumn()
	 * @see #getSelectRange()
	 * @generated
	 */
	EAttribute getSelectRange_EndColumn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetCaretPos <em>Set Caret Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Caret Pos</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetCaretPos
	 * @generated
	 */
	EClass getSetCaretPos();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.SetCaretPos#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetCaretPos#getControl()
	 * @see #getSetCaretPos()
	 * @generated
	 */
	EReference getSetCaretPos_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetCaretPos#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetCaretPos#getLine()
	 * @see #getSetCaretPos()
	 * @generated
	 */
	EAttribute getSetCaretPos_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetCaretPos#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetCaretPos#getColumn()
	 * @see #getSetCaretPos()
	 * @generated
	 */
	EAttribute getSetCaretPos_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.HoverText <em>Hover Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hover Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverText
	 * @generated
	 */
	EClass getHoverText();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.HoverText#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverText#getControl()
	 * @see #getHoverText()
	 * @generated
	 */
	EReference getHoverText_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverText#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverText#getLine()
	 * @see #getHoverText()
	 * @generated
	 */
	EAttribute getHoverText_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverText#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverText#getColumn()
	 * @see #getHoverText()
	 * @generated
	 */
	EAttribute getHoverText_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverText#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverText#getWith()
	 * @see #getHoverText()
	 * @generated
	 */
	EAttribute getHoverText_With();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.OpenDeclaration <em>Open Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Declaration</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.OpenDeclaration
	 * @generated
	 */
	EClass getOpenDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.OpenDeclaration#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.OpenDeclaration#getControl()
	 * @see #getOpenDeclaration()
	 * @generated
	 */
	EReference getOpenDeclaration_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetVerticalRuler <em>Get Vertical Ruler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Vertical Ruler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetVerticalRuler
	 * @generated
	 */
	EClass getGetVerticalRuler();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetLeftRuler <em>Get Left Ruler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Left Ruler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetLeftRuler
	 * @generated
	 */
	EClass getGetLeftRuler();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetRulerColumn <em>Get Ruler Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Ruler Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRulerColumn
	 * @generated
	 */
	EClass getGetRulerColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetRulerColumn#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRulerColumn#getText()
	 * @see #getGetRulerColumn()
	 * @generated
	 */
	EAttribute getGetRulerColumn_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetRightRuler <em>Get Right Ruler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Right Ruler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRightRuler
	 * @generated
	 */
	EClass getGetRightRuler();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ClickRuler <em>Click Ruler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Ruler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickRuler
	 * @generated
	 */
	EClass getClickRuler();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getControl()
	 * @see #getClickRuler()
	 * @generated
	 */
	EReference getClickRuler_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getLine()
	 * @see #getClickRuler()
	 * @generated
	 */
	EAttribute getClickRuler_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getButton()
	 * @see #getClickRuler()
	 * @generated
	 */
	EAttribute getClickRuler_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickRuler#getWith()
	 * @see #getClickRuler()
	 * @generated
	 */
	EAttribute getClickRuler_With();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler <em>Double Click Ruler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Click Ruler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler
	 * @generated
	 */
	EClass getDoubleClickRuler();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getControl()
	 * @see #getDoubleClickRuler()
	 * @generated
	 */
	EReference getDoubleClickRuler_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getLine()
	 * @see #getDoubleClickRuler()
	 * @generated
	 */
	EAttribute getDoubleClickRuler_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getButton()
	 * @see #getDoubleClickRuler()
	 * @generated
	 */
	EAttribute getDoubleClickRuler_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler#getWith()
	 * @see #getDoubleClickRuler()
	 * @generated
	 */
	EAttribute getDoubleClickRuler_With();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.HoverRuler <em>Hover Ruler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hover Ruler</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverRuler
	 * @generated
	 */
	EClass getHoverRuler();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.HoverRuler#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverRuler#getControl()
	 * @see #getHoverRuler()
	 * @generated
	 */
	EReference getHoverRuler_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverRuler#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverRuler#getLine()
	 * @see #getHoverRuler()
	 * @generated
	 */
	EAttribute getHoverRuler_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.HoverRuler#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.HoverRuler#getWith()
	 * @see #getHoverRuler()
	 * @generated
	 */
	EAttribute getHoverRuler_With();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ControlCommand <em>Control Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Command</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlCommand
	 * @generated
	 */
	EClass getControlCommand();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.ControlCommand#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ControlCommand#getControl()
	 * @see #getControlCommand()
	 * @generated
	 */
	EReference getControlCommand_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ClickLink <em>Click Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Link</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickLink
	 * @generated
	 */
	EClass getClickLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickLink#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickLink#getRef()
	 * @see #getClickLink()
	 * @generated
	 */
	EAttribute getClickLink_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Expand <em>Expand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Expand
	 * @generated
	 */
	EClass getExpand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Collapse <em>Collapse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collapse</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Collapse
	 * @generated
	 */
	EClass getCollapse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetFocus <em>Set Focus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Focus</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetFocus
	 * @generated
	 */
	EClass getSetFocus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData <em>Get Table Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Table Data</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTableData
	 * @generated
	 */
	EClass getGetTableData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData#isIncludeChecked <em>Include Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Checked</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTableData#isIncludeChecked()
	 * @see #getGetTableData()
	 * @generated
	 */
	EAttribute getGetTableData_IncludeChecked();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData#isExcludeHidden <em>Exclude Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exclude Hidden</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTableData#isExcludeHidden()
	 * @see #getGetTableData()
	 * @generated
	 */
	EAttribute getGetTableData_ExcludeHidden();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn <em>Click Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickColumn
	 * @generated
	 */
	EClass getClickColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getName()
	 * @see #getClickColumn()
	 * @generated
	 */
	EAttribute getClickColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getIndex()
	 * @see #getClickColumn()
	 * @generated
	 */
	EAttribute getClickColumn_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Trace#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Trace#getMessage()
	 * @see #getTrace()
	 * @generated
	 */
	EAttribute getTrace_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse <em>Mouse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse
	 * @generated
	 */
	EClass getMouse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse#getEvent()
	 * @see #getMouse()
	 * @generated
	 */
	EAttribute getMouse_Event();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse#getButton()
	 * @see #getMouse()
	 * @generated
	 */
	EAttribute getMouse_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse#getWith()
	 * @see #getMouse()
	 * @generated
	 */
	EAttribute getMouse_With();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse#getCount()
	 * @see #getMouse()
	 * @generated
	 */
	EAttribute getMouse_Count();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse#getX()
	 * @see #getMouse()
	 * @generated
	 */
	EAttribute getMouse_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Mouse#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Mouse#getY()
	 * @see #getMouse()
	 * @generated
	 */
	EAttribute getMouse_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetObject <em>Get Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Object</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetObject
	 * @generated
	 */
	EClass getGetObject();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.GetObject#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetObject#getObject()
	 * @see #getGetObject()
	 * @generated
	 */
	EReference getGetObject_Object();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetItems <em>Get Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Items</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetItems
	 * @generated
	 */
	EClass getGetItems();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ExpandAll <em>Expand All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand All</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ExpandAll
	 * @generated
	 */
	EClass getExpandAll();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.CollapseAll <em>Collapse All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collapse All</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CollapseAll
	 * @generated
	 */
	EClass getCollapseAll();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.TakeScreenshot <em>Take Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Take Screenshot</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TakeScreenshot
	 * @generated
	 */
	EClass getTakeScreenshot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.TakeScreenshot#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TakeScreenshot#getMessage()
	 * @see #getTakeScreenshot()
	 * @generated
	 */
	EAttribute getTakeScreenshot_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SelectItem <em>Select Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Item</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SelectItem
	 * @generated
	 */
	EClass getSelectItem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetWidgetDetails <em>Get Widget Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Widget Details</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetWidgetDetails
	 * @generated
	 */
	EClass getGetWidgetDetails();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.GetWidgetDetails#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetWidgetDetails#getElement()
	 * @see #getGetWidgetDetails()
	 * @generated
	 */
	EReference getGetWidgetDetails_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText <em>Click Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickText
	 * @generated
	 */
	EClass getClickText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickText#getStart()
	 * @see #getClickText()
	 * @generated
	 */
	EAttribute getClickText_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickText#getEnd()
	 * @see #getClickText()
	 * @generated
	 */
	EAttribute getClickText_End();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ClickText#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ClickText#getButton()
	 * @see #getClickText()
	 * @generated
	 */
	EAttribute getClickText_Button();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetQuickAccess <em>Get Quick Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Quick Access</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetQuickAccess
	 * @generated
	 */
	EClass getGetQuickAccess();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetColumnHeader <em>Get Column Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Column Header</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetColumnHeader
	 * @generated
	 */
	EClass getGetColumnHeader();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetPosition <em>Set Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Position</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetPosition
	 * @generated
	 */
	EClass getSetPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetPosition#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetPosition#getIndex()
	 * @see #getSetPosition()
	 * @generated
	 */
	EAttribute getSetPosition_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.SetWidth <em>Set Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Width</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetWidth
	 * @generated
	 */
	EClass getSetWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.SetWidth#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.SetWidth#getWidth()
	 * @see #getSetWidth()
	 * @generated
	 */
	EAttribute getSetWidth_Width();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyTab <em>Get Property Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Property Tab</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetPropertyTab
	 * @generated
	 */
	EClass getGetPropertyTab();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ShowAlert <em>Show Alert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Alert</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShowAlert
	 * @generated
	 */
	EClass getShowAlert();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ShowAlert#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ShowAlert#getMessage()
	 * @see #getShowAlert()
	 * @generated
	 */
	EAttribute getShowAlert_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText <em>Double Click Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Click Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickText
	 * @generated
	 */
	EClass getDoubleClickText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getPosition()
	 * @see #getDoubleClickText()
	 * @generated
	 */
	EAttribute getDoubleClickText_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DoubleClickText#getButton()
	 * @see #getDoubleClickText()
	 * @generated
	 */
	EAttribute getDoubleClickText_Button();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.ToControlHandle <em>To Control Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Control Handle</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ToControlHandle
	 * @generated
	 */
	EClass getToControlHandle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.ToControlHandle#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Widget</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ToControlHandle#getWidget()
	 * @see #getToControlHandle()
	 * @generated
	 */
	EAttribute getToControlHandle_Widget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle <em>Bound Control Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Control Handle</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle
	 * @generated
	 */
	EClass getBoundControlHandle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle#getWidgetId <em>Widget Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Widget Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle#getWidgetId()
	 * @see #getBoundControlHandle()
	 * @generated
	 */
	EAttribute getBoundControlHandle_WidgetId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Unfocus <em>Unfocus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unfocus</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Unfocus
	 * @generated
	 */
	EClass getUnfocus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.Decrypt <em>Decrypt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decrypt</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Decrypt
	 * @generated
	 */
	EClass getDecrypt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.Decrypt#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Decrypt#getValue()
	 * @see #getDecrypt()
	 * @generated
	 */
	EAttribute getDecrypt_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.DecryptResult <em>Decrypt Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decrypt Result</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DecryptResult
	 * @generated
	 */
	EClass getDecryptResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.DecryptResult#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.DecryptResult#getValue()
	 * @see #getDecryptResult()
	 * @generated
	 */
	EAttribute getDecryptResult_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.RestartAut <em>Restart Aut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restart Aut</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.RestartAut
	 * @generated
	 */
	EClass getRestartAut();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo <em>Message Box Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Box Info</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo
	 * @generated
	 */
	EClass getMessageBoxInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo#getTitle()
	 * @see #getMessageBoxInfo()
	 * @generated
	 */
	EAttribute getMessageBoxInfo_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo#getMessage()
	 * @see #getMessageBoxInfo()
	 * @generated
	 */
	EAttribute getMessageBoxInfo_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetLastMessageBox <em>Get Last Message Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Last Message Box</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetLastMessageBox
	 * @generated
	 */
	EClass getGetLastMessageBox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult <em>Check Download Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Download Result</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult
	 * @generated
	 */
	EClass getCheckDownloadResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getContentOnBase64 <em>Content On Base64</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content On Base64</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getContentOnBase64()
	 * @see #getCheckDownloadResult()
	 * @generated
	 */
	EAttribute getCheckDownloadResult_ContentOnBase64();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getFileName()
	 * @see #getCheckDownloadResult()
	 * @generated
	 */
	EAttribute getCheckDownloadResult_FileName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetRuntimeTarget <em>Get Runtime Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Runtime Target</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetRuntimeTarget
	 * @generated
	 */
	EClass getGetRuntimeTarget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetTestCaseName <em>Get Test Case Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Test Case Name</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetTestCaseName
	 * @generated
	 */
	EClass getGetTestCaseName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.GetComboItems <em>Get Combo Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Combo Items</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.GetComboItems
	 * @generated
	 */
	EClass getGetComboItems();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.ecl.model.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Button
	 * @generated
	 */
	EEnum getButton();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.ecl.model.ActivationEventType <em>Activation Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Activation Event Type</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.ActivationEventType
	 * @generated
	 */
	EEnum getActivationEventType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.rcptt.tesla.core.protocol.ElementKind <em>Element Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Element Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ElementKind
	 * @model instanceClass="org.eclipse.rcptt.tesla.core.protocol.ElementKind"
	 * @generated
	 */
	EDataType getElementKind();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.WaitImpl <em>Wait</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.WaitImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getWait()
		 * @generated
		 */
		EClass WAIT = eINSTANCE.getWait();

		/**
		 * The meta object literal for the '<em><b>Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT__MS = eINSTANCE.getWait_Ms();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetupPlayerImpl <em>Setup Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetupPlayerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetupPlayer()
		 * @generated
		 */
		EClass SETUP_PLAYER = eINSTANCE.getSetupPlayer();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShoutdownPlayerImpl <em>Shoutdown Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShoutdownPlayerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShoutdownPlayer()
		 * @generated
		 */
		EClass SHOUTDOWN_PLAYER = eINSTANCE.getShoutdownPlayer();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TeslaProcessStatusImpl <em>Process Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaProcessStatusImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTeslaProcessStatus()
		 * @generated
		 */
		EClass TESLA_PROCESS_STATUS = eINSTANCE.getTeslaProcessStatus();

		/**
		 * The meta object literal for the '<em><b>Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESLA_PROCESS_STATUS__INFO = eINSTANCE.getTeslaProcessStatus_Info();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.WrapperImpl <em>Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.WrapperImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getWrapper()
		 * @generated
		 */
		EClass WRAPPER = eINSTANCE.getWrapper();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRAPPER__OBJECT = eINSTANCE.getWrapper_Object();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyImpl <em>Get Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetProperty()
		 * @generated
		 */
		EClass GET_PROPERTY = eINSTANCE.getGetProperty();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_PROPERTY__OBJECT = eINSTANCE.getGetProperty_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY__NAME = eINSTANCE.getGetProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY__INDEX = eINSTANCE.getGetProperty_Index();

		/**
		 * The meta object literal for the '<em><b>Raw</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY__RAW = eINSTANCE.getGetProperty_Raw();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyTrueImpl <em>Verify True</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyTrueImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyTrue()
		 * @generated
		 */
		EClass VERIFY_TRUE = eINSTANCE.getVerifyTrue();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFY_TRUE__CONDITION = eINSTANCE.getVerifyTrue_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyFalseImpl <em>Verify False</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyFalseImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyFalse()
		 * @generated
		 */
		EClass VERIFY_FALSE = eINSTANCE.getVerifyFalse();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFY_FALSE__CONDITION = eINSTANCE.getVerifyFalse_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyHandlerImpl <em>Verify Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyHandlerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyHandler()
		 * @generated
		 */
		EClass VERIFY_HANDLER = eINSTANCE.getVerifyHandler();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFY_HANDLER__ELEMENT = eINSTANCE.getVerifyHandler_Element();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_HANDLER__ATTRIBUTE = eINSTANCE.getVerifyHandler_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_HANDLER__VALUE = eINSTANCE.getVerifyHandler_Value();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_HANDLER__KIND = eINSTANCE.getVerifyHandler_Kind();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_HANDLER__INDEX = eINSTANCE.getVerifyHandler_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.VerifyErrorImpl <em>Verify Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.VerifyErrorImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getVerifyError()
		 * @generated
		 */
		EClass VERIFY_ERROR = eINSTANCE.getVerifyError();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFY_ERROR__COMMAND = eINSTANCE.getVerifyError_Command();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.EqualsImpl <em>Equals</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.EqualsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getEquals()
		 * @generated
		 */
		EClass EQUALS = eINSTANCE.getEquals();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUALS__INPUT = eINSTANCE.getEquals_Input();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUALS__VALUE = eINSTANCE.getEquals_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImpl <em>Contains</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getContains()
		 * @generated
		 */
		EClass CONTAINS = eINSTANCE.getContains();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINS__INPUT = eINSTANCE.getContains_Input();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINS__VALUE = eINSTANCE.getContains_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MatchesImpl <em>Matches</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MatchesImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMatches()
		 * @generated
		 */
		EClass MATCHES = eINSTANCE.getMatches();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHES__INPUT = eINSTANCE.getMatches_Input();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCHES__VALUE = eINSTANCE.getMatches_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.IsEmptyImpl <em>Is Empty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.IsEmptyImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getIsEmpty()
		 * @generated
		 */
		EClass IS_EMPTY = eINSTANCE.getIsEmpty();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IS_EMPTY__INPUT = eINSTANCE.getIsEmpty_Input();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.UnsupportedImpl <em>Unsupported</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.UnsupportedImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getUnsupported()
		 * @generated
		 */
		EClass UNSUPPORTED = eINSTANCE.getUnsupported();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNSUPPORTED__DESC = eINSTANCE.getUnsupported_Desc();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ControlNotFoundImpl <em>Control Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ControlNotFoundImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getControlNotFound()
		 * @generated
		 */
		EClass CONTROL_NOT_FOUND = eINSTANCE.getControlNotFound();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_NOT_FOUND__ID = eINSTANCE.getControlNotFound_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ControlHandlerImpl <em>Control Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ControlHandlerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getControlHandler()
		 * @generated
		 */
		EClass CONTROL_HANDLER = eINSTANCE.getControlHandler();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__KIND = eINSTANCE.getControlHandler_Kind();

		/**
		 * The meta object literal for the '<em><b>Custom Kind Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__CUSTOM_KIND_ID = eINSTANCE.getControlHandler_CustomKindId();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__TEXT = eINSTANCE.getControlHandler_Text();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__TYPE = eINSTANCE.getControlHandler_Type();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__INDEX = eINSTANCE.getControlHandler_Index();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__PATH = eINSTANCE.getControlHandler_Path();

		/**
		 * The meta object literal for the '<em><b>Indexes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__INDEXES = eINSTANCE.getControlHandler_Indexes();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_HANDLER__AFTER = eINSTANCE.getControlHandler_After();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_HANDLER__PARENT = eINSTANCE.getControlHandler_Parent();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_HANDLER__RESOLVED = eINSTANCE.getControlHandler_Resolved();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__ROW = eINSTANCE.getControlHandler_Row();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__COLUMN = eINSTANCE.getControlHandler_Column();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__X = eINSTANCE.getControlHandler_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__Y = eINSTANCE.getControlHandler_Y();

		/**
		 * The meta object literal for the '<em><b>Raw Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_HANDLER__RAW_IMAGE = eINSTANCE.getControlHandler_RawImage();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetEclipseWindowImpl <em>Get Eclipse Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetEclipseWindowImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetEclipseWindow()
		 * @generated
		 */
		EClass GET_ECLIPSE_WINDOW = eINSTANCE.getGetEclipseWindow();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.Selector <em>Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.Selector
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelector()
		 * @generated
		 */
		EClass SELECTOR = eINSTANCE.getSelector();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR__ID = eINSTANCE.getSelector_Id();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTOR__AFTER = eINSTANCE.getSelector_After();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR__TYPE = eINSTANCE.getSelector_Type();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR__INDEX = eINSTANCE.getSelector_Index();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTOR__PARENT = eINSTANCE.getSelector_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.PathSelector <em>Path Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.PathSelector
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getPathSelector()
		 * @generated
		 */
		EClass PATH_SELECTOR = eINSTANCE.getPathSelector();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_SELECTOR__PATH = eINSTANCE.getPathSelector_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.TextSelector <em>Text Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.TextSelector
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTextSelector()
		 * @generated
		 */
		EClass TEXT_SELECTOR = eINSTANCE.getTextSelector();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_SELECTOR__TEXT = eINSTANCE.getTextSelector_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetControlImpl <em>Get Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetControlImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetControl()
		 * @generated
		 */
		EClass GET_CONTROL = eINSTANCE.getGetControl();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_CONTROL__KIND = eINSTANCE.getGetControl_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetButtonImpl <em>Get Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetButtonImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetButton()
		 * @generated
		 */
		EClass GET_BUTTON = eINSTANCE.getGetButton();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCanvasImpl <em>Get Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCanvasImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCanvas()
		 * @generated
		 */
		EClass GET_CANVAS = eINSTANCE.getGetCanvas();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCheckboxImpl <em>Get Checkbox</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCheckboxImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCheckbox()
		 * @generated
		 */
		EClass GET_CHECKBOX = eINSTANCE.getGetCheckbox();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetComboImpl <em>Get Combo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetComboImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCombo()
		 * @generated
		 */
		EClass GET_COMBO = eINSTANCE.getGetCombo();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetEditboxImpl <em>Get Editbox</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetEditboxImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetEditbox()
		 * @generated
		 */
		EClass GET_EDITBOX = eINSTANCE.getGetEditbox();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetGroupImpl <em>Get Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetGroupImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetGroup()
		 * @generated
		 */
		EClass GET_GROUP = eINSTANCE.getGetGroup();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetItemImpl <em>Get Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetItemImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetItem()
		 * @generated
		 */
		EClass GET_ITEM = eINSTANCE.getGetItem();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_ITEM__PATH = eINSTANCE.getGetItem_Path();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_ITEM__COLUMN = eINSTANCE.getGetItem_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLabelImpl <em>Get Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLabelImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLabel()
		 * @generated
		 */
		EClass GET_LABEL = eINSTANCE.getGetLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLinkImpl <em>Get Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLinkImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLink()
		 * @generated
		 */
		EClass GET_LINK = eINSTANCE.getGetLink();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetListImpl <em>Get List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetListImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetList()
		 * @generated
		 */
		EClass GET_LIST = eINSTANCE.getGetList();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetMenuImpl <em>Get Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetMenuImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetMenu()
		 * @generated
		 */
		EClass GET_MENU = eINSTANCE.getGetMenu();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTabFolderImpl <em>Get Tab Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTabFolderImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTabFolder()
		 * @generated
		 */
		EClass GET_TAB_FOLDER = eINSTANCE.getGetTabFolder();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTabItemImpl <em>Get Tab Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTabItemImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTabItem()
		 * @generated
		 */
		EClass GET_TAB_ITEM = eINSTANCE.getGetTabItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTableImpl <em>Get Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTableImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTable()
		 * @generated
		 */
		EClass GET_TABLE = eINSTANCE.getGetTable();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetToolbarImpl <em>Get Toolbar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetToolbarImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetToolbar()
		 * @generated
		 */
		EClass GET_TOOLBAR = eINSTANCE.getGetToolbar();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTreeImpl <em>Get Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTreeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTree()
		 * @generated
		 */
		EClass GET_TREE = eINSTANCE.getGetTree();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetWindowImpl <em>Get Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetWindowImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetWindow()
		 * @generated
		 */
		EClass GET_WINDOW = eINSTANCE.getGetWindow();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_WINDOW__TEXT = eINSTANCE.getGetWindow_Text();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_WINDOW__FROM = eINSTANCE.getGetWindow_From();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_WINDOW__CLASS = eINSTANCE.getGetWindow_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetViewImpl <em>Get View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetViewImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetView()
		 * @generated
		 */
		EClass GET_VIEW = eINSTANCE.getGetView();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetEditorImpl <em>Get Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetEditorImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetEditor()
		 * @generated
		 */
		EClass GET_EDITOR = eINSTANCE.getGetEditor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetSectionImpl <em>Get Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetSectionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetSection()
		 * @generated
		 */
		EClass GET_SECTION = eINSTANCE.getGetSection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetBannerImpl <em>Get Banner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetBannerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetBanner()
		 * @generated
		 */
		EClass GET_BANNER = eINSTANCE.getGetBanner();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCoolbarImpl <em>Get Coolbar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCoolbarImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCoolbar()
		 * @generated
		 */
		EClass GET_COOLBAR = eINSTANCE.getGetCoolbar();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetColorSelectorImpl <em>Get Color Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetColorSelectorImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetColorSelector()
		 * @generated
		 */
		EClass GET_COLOR_SELECTOR = eINSTANCE.getGetColorSelector();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetCellImpl <em>Get Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetCellImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetCell()
		 * @generated
		 */
		EClass GET_CELL = eINSTANCE.getGetCell();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_CELL__ROW = eINSTANCE.getGetCell_Row();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_CELL__COLUMN = eINSTANCE.getGetCell_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickImpl <em>Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClick()
		 * @generated
		 */
		EClass CLICK = eINSTANCE.getClick();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLICK__CONTROL = eINSTANCE.getClick_Control();

		/**
		 * The meta object literal for the '<em><b>Nowait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__NOWAIT = eINSTANCE.getClick_Nowait();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__DEFAULT = eINSTANCE.getClick_Default();

		/**
		 * The meta object literal for the '<em><b>Arrow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__ARROW = eINSTANCE.getClick_Arrow();

		/**
		 * The meta object literal for the '<em><b>Meta Keys</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__META_KEYS = eINSTANCE.getClick_MetaKeys();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickImpl <em>Double Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDoubleClick()
		 * @generated
		 */
		EClass DOUBLE_CLICK = eINSTANCE.getDoubleClick();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTextImpl <em>Get Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetText()
		 * @generated
		 */
		EClass GET_TEXT = eINSTANCE.getGetText();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_TEXT__CONTROL = eINSTANCE.getGetText_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.IsDisabledImpl <em>Is Disabled</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.IsDisabledImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getIsDisabled()
		 * @generated
		 */
		EClass IS_DISABLED = eINSTANCE.getIsDisabled();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IS_DISABLED__CONTROL = eINSTANCE.getIsDisabled_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.IsDisposedImpl <em>Is Disposed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.IsDisposedImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getIsDisposed()
		 * @generated
		 */
		EClass IS_DISPOSED = eINSTANCE.getIsDisposed();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IS_DISPOSED__CONTROL = eINSTANCE.getIsDisposed_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TypeTextImpl <em>Type Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TypeTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTypeText()
		 * @generated
		 */
		EClass TYPE_TEXT = eINSTANCE.getTypeText();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TEXT__CONTROL = eINSTANCE.getTypeText_Control();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEXT__TEXT = eINSTANCE.getTypeText_Text();

		/**
		 * The meta object literal for the '<em><b>Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEXT__DISPLAY = eINSTANCE.getTypeText_Display();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.KeyTypeImpl <em>Key Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.KeyTypeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getKeyType()
		 * @generated
		 */
		EClass KEY_TYPE = eINSTANCE.getKeyType();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_TYPE__CONTROL = eINSTANCE.getKeyType_Control();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_TYPE__KEY = eINSTANCE.getKeyType_Key();

		/**
		 * The meta object literal for the '<em><b>Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_TYPE__CHAR = eINSTANCE.getKeyType_Char();

		/**
		 * The meta object literal for the '<em><b>Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_TYPE__DISPLAY = eINSTANCE.getKeyType_Display();

		/**
		 * The meta object literal for the '<em><b>Times</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_TYPE__TIMES = eINSTANCE.getKeyType_Times();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TypeCommandKeyImpl <em>Type Command Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TypeCommandKeyImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTypeCommandKey()
		 * @generated
		 */
		EClass TYPE_COMMAND_KEY = eINSTANCE.getTypeCommandKey();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_COMMAND_KEY__CONTROL = eINSTANCE.getTypeCommandKey_Control();

		/**
		 * The meta object literal for the '<em><b>Command Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_COMMAND_KEY__COMMAND_ID = eINSTANCE.getTypeCommandKey_CommandId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetTextImpl <em>Set Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetText()
		 * @generated
		 */
		EClass SET_TEXT = eINSTANCE.getSetText();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TEXT__CONTROL = eINSTANCE.getSetText_Control();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT__TEXT = eINSTANCE.getSetText_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetTextSelectionImpl <em>Set Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetTextSelection()
		 * @generated
		 */
		EClass SET_TEXT_SELECTION = eINSTANCE.getSetTextSelection();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TEXT_SELECTION__CONTROL = eINSTANCE.getSetTextSelection_Control();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__OFFSET = eINSTANCE.getSetTextSelection_Offset();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__LENGTH = eINSTANCE.getSetTextSelection_Length();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__START_LINE = eINSTANCE.getSetTextSelection_StartLine();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__END_LINE = eINSTANCE.getSetTextSelection_EndLine();

		/**
		 * The meta object literal for the '<em><b>End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__END_OFFSET = eINSTANCE.getSetTextSelection_EndOffset();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetTextOffsetImpl <em>Set Text Offset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetTextOffsetImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetTextOffset()
		 * @generated
		 */
		EClass SET_TEXT_OFFSET = eINSTANCE.getSetTextOffset();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TEXT_OFFSET__CONTROL = eINSTANCE.getSetTextOffset_Control();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_OFFSET__VALUE = eINSTANCE.getSetTextOffset_Value();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_OFFSET__LINE = eINSTANCE.getSetTextOffset_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CheckImpl <em>Check</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CheckImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCheck()
		 * @generated
		 */
		EClass CHECK = eINSTANCE.getCheck();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__CONTROL = eINSTANCE.getCheck_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.UncheckImpl <em>Uncheck</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.UncheckImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getUncheck()
		 * @generated
		 */
		EClass UNCHECK = eINSTANCE.getUncheck();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNCHECK__CONTROL = eINSTANCE.getUncheck_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SelectImpl <em>Select</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SelectImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelect()
		 * @generated
		 */
		EClass SELECT = eINSTANCE.getSelect();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__CONTROL = eINSTANCE.getSelect_Control();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT__ITEMS = eINSTANCE.getSelect_Items();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT__ALL = eINSTANCE.getSelect_All();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT__COLUMN = eINSTANCE.getSelect_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CellEditImpl <em>Cell Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CellEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCellEdit()
		 * @generated
		 */
		EClass CELL_EDIT = eINSTANCE.getCellEdit();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL_EDIT__CONTROL = eINSTANCE.getCellEdit_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ActivateCellEditImpl <em>Activate Cell Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ActivateCellEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getActivateCellEdit()
		 * @generated
		 */
		EClass ACTIVATE_CELL_EDIT = eINSTANCE.getActivateCellEdit();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDIT__COLUMN = eINSTANCE.getActivateCellEdit_Column();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDIT__TYPE = eINSTANCE.getActivateCellEdit_Type();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDIT__BUTTON = eINSTANCE.getActivateCellEdit_Button();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ApplyCellEditImpl <em>Apply Cell Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ApplyCellEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getApplyCellEdit()
		 * @generated
		 */
		EClass APPLY_CELL_EDIT = eINSTANCE.getApplyCellEdit();

		/**
		 * The meta object literal for the '<em><b>Deactivate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLY_CELL_EDIT__DEACTIVATE = eINSTANCE.getApplyCellEdit_Deactivate();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CancelCellEditImpl <em>Cancel Cell Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CancelCellEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCancelCellEdit()
		 * @generated
		 */
		EClass CANCEL_CELL_EDIT = eINSTANCE.getCancelCellEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DeactivateCellEditImpl <em>Deactivate Cell Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DeactivateCellEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDeactivateCellEdit()
		 * @generated
		 */
		EClass DEACTIVATE_CELL_EDIT = eINSTANCE.getDeactivateCellEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CloseImpl <em>Close</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CloseImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClose()
		 * @generated
		 */
		EClass CLOSE = eINSTANCE.getClose();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOSE__CONTROL = eINSTANCE.getClose_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ReturnFromOsDialogImpl <em>Return From Os Dialog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ReturnFromOsDialogImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getReturnFromOsDialog()
		 * @generated
		 */
		EClass RETURN_FROM_OS_DIALOG = eINSTANCE.getReturnFromOsDialog();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RETURN_FROM_OS_DIALOG__KIND = eINSTANCE.getReturnFromOsDialog_Kind();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RETURN_FROM_OS_DIALOG__RESULT = eINSTANCE.getReturnFromOsDialog_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.WaitUntilEclipseIsReadyImpl <em>Wait Until Eclipse Is Ready</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.WaitUntilEclipseIsReadyImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getWaitUntilEclipseIsReady()
		 * @generated
		 */
		EClass WAIT_UNTIL_ECLIPSE_IS_READY = eINSTANCE.getWaitUntilEclipseIsReady();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShowContentAssistImpl <em>Show Content Assist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShowContentAssistImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShowContentAssist()
		 * @generated
		 */
		EClass SHOW_CONTENT_ASSIST = eINSTANCE.getShowContentAssist();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHOW_CONTENT_ASSIST__CONTROL = eINSTANCE.getShowContentAssist_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragActionImpl <em>Drag Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragActionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragAction()
		 * @generated
		 */
		EClass DRAG_ACTION = eINSTANCE.getDragAction();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAG_ACTION__CONTROL = eINSTANCE.getDragAction_Control();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_ACTION__X = eINSTANCE.getDragAction_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_ACTION__Y = eINSTANCE.getDragAction_Y();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_ACTION__BUTTON = eINSTANCE.getDragAction_Button();

		/**
		 * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_ACTION__MASK = eINSTANCE.getDragAction_Mask();

		/**
		 * The meta object literal for the '<em><b>Detail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_ACTION__DETAIL = eINSTANCE.getDragAction_Detail();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_ACTION__OPERATION = eINSTANCE.getDragAction_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragStartImpl <em>Drag Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragStartImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragStart()
		 * @generated
		 */
		EClass DRAG_START = eINSTANCE.getDragStart();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragEndImpl <em>Drag End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragEndImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragEnd()
		 * @generated
		 */
		EClass DRAG_END = eINSTANCE.getDragEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragEnterImpl <em>Drag Enter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragEnterImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragEnter()
		 * @generated
		 */
		EClass DRAG_ENTER = eINSTANCE.getDragEnter();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragExitImpl <em>Drag Exit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragExitImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragExit()
		 * @generated
		 */
		EClass DRAG_EXIT = eINSTANCE.getDragExit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragSetDataImpl <em>Drag Set Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragSetDataImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragSetData()
		 * @generated
		 */
		EClass DRAG_SET_DATA = eINSTANCE.getDragSetData();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragAcceptImpl <em>Drag Accept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragAcceptImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragAccept()
		 * @generated
		 */
		EClass DRAG_ACCEPT = eINSTANCE.getDragAccept();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragDetectImpl <em>Drag Detect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragDetectImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragDetect()
		 * @generated
		 */
		EClass DRAG_DETECT = eINSTANCE.getDragDetect();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DragOverImpl <em>Drag Over</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DragOverImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDragOver()
		 * @generated
		 */
		EClass DRAG_OVER = eINSTANCE.getDragOver();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DropImpl <em>Drop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DropImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDrop()
		 * @generated
		 */
		EClass DROP = eINSTANCE.getDrop();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeImpl <em>Recognize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRecognize()
		 * @generated
		 */
		EClass RECOGNIZE = eINSTANCE.getRecognize();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOGNIZE__IMAGE = eINSTANCE.getRecognize_Image();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOGNIZE__X = eINSTANCE.getRecognize_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOGNIZE__Y = eINSTANCE.getRecognize_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOGNIZE__WIDTH = eINSTANCE.getRecognize_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOGNIZE__HEIGHT = eINSTANCE.getRecognize_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeResponseImpl <em>Recognize Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RecognizeResponseImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRecognizeResponse()
		 * @generated
		 */
		EClass RECOGNIZE_RESPONSE = eINSTANCE.getRecognizeResponse();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOGNIZE_RESPONSE__TEXT = eINSTANCE.getRecognizeResponse_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImageImpl <em>Contains Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ContainsImageImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getContainsImage()
		 * @generated
		 */
		EClass CONTAINS_IMAGE = eINSTANCE.getContainsImage();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINS_IMAGE__CONTROL = eINSTANCE.getContainsImage_Control();

		/**
		 * The meta object literal for the '<em><b>Image URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINS_IMAGE__IMAGE_URI = eINSTANCE.getContainsImage_ImageURI();

		/**
		 * The meta object literal for the '<em><b>Raw Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINS_IMAGE__RAW_IMAGE = eINSTANCE.getContainsImage_RawImage();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionTextImpl <em>Get Region Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRegionText()
		 * @generated
		 */
		EClass GET_REGION_TEXT = eINSTANCE.getGetRegionText();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_REGION_TEXT__CONTROL = eINSTANCE.getGetRegionText_Control();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__X = eINSTANCE.getGetRegionText_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__Y = eINSTANCE.getGetRegionText_Y();

		/**
		 * The meta object literal for the '<em><b>Sx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__SX = eINSTANCE.getGetRegionText_Sx();

		/**
		 * The meta object literal for the '<em><b>Sy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__SY = eINSTANCE.getGetRegionText_Sy();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__WIDTH = eINSTANCE.getGetRegionText_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__HEIGHT = eINSTANCE.getGetRegionText_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionImpl <em>Get Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRegionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRegion()
		 * @generated
		 */
		EClass GET_REGION = eINSTANCE.getGetRegion();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION__X = eINSTANCE.getGetRegion_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION__Y = eINSTANCE.getGetRegion_Y();

		/**
		 * The meta object literal for the '<em><b>Image URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION__IMAGE_URI = eINSTANCE.getGetRegion_ImageURI();

		/**
		 * The meta object literal for the '<em><b>Raw Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION__RAW_IMAGE = eINSTANCE.getGetRegion_RawImage();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetAdvancedInfoImpl <em>Get Advanced Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetAdvancedInfoImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetAdvancedInfo()
		 * @generated
		 */
		EClass GET_ADVANCED_INFO = eINSTANCE.getGetAdvancedInfo();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetAboutMenuImpl <em>Get About Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetAboutMenuImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetAboutMenu()
		 * @generated
		 */
		EClass GET_ABOUT_MENU = eINSTANCE.getGetAboutMenu();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPreferencesMenuImpl <em>Get Preferences Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPreferencesMenuImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetPreferencesMenu()
		 * @generated
		 */
		EClass GET_PREFERENCES_MENU = eINSTANCE.getGetPreferencesMenu();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetDateTimeImpl <em>Get Date Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetDateTimeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetDateTime()
		 * @generated
		 */
		EClass GET_DATE_TIME = eINSTANCE.getGetDateTime();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetSliderImpl <em>Get Slider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetSliderImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetSlider()
		 * @generated
		 */
		EClass GET_SLIDER = eINSTANCE.getGetSlider();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetValueImpl <em>Set Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetValueImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetValue()
		 * @generated
		 */
		EClass SET_VALUE = eINSTANCE.getSetValue();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VALUE__CONTROL = eINSTANCE.getSetValue_Control();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VALUE__VALUE = eINSTANCE.getSetValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MinimizeImpl <em>Minimize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MinimizeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMinimize()
		 * @generated
		 */
		EClass MINIMIZE = eINSTANCE.getMinimize();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MINIMIZE__CONTROL = eINSTANCE.getMinimize_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MaximizeImpl <em>Maximize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MaximizeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMaximize()
		 * @generated
		 */
		EClass MAXIMIZE = eINSTANCE.getMaximize();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAXIMIZE__CONTROL = eINSTANCE.getMaximize_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RestoreImpl <em>Restore</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RestoreImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRestore()
		 * @generated
		 */
		EClass RESTORE = eINSTANCE.getRestore();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTORE__CONTROL = eINSTANCE.getRestore_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShowTabListImpl <em>Show Tab List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShowTabListImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShowTabList()
		 * @generated
		 */
		EClass SHOW_TAB_LIST = eINSTANCE.getShowTabList();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHOW_TAB_LIST__CONTROL = eINSTANCE.getShowTabList_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.OptionsImpl <em>Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.OptionsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getOptions()
		 * @generated
		 */
		EClass OPTIONS = eINSTANCE.getOptions();

		/**
		 * The meta object literal for the '<em><b>Allow Status Dialog</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIONS__ALLOW_STATUS_DIALOG = eINSTANCE.getOptions_AllowStatusDialog();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIONS__COMMAND = eINSTANCE.getOptions_Command();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ExecWithOptionsImpl <em>Exec With Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ExecWithOptionsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getExecWithOptions()
		 * @generated
		 */
		EClass EXEC_WITH_OPTIONS = eINSTANCE.getExecWithOptions();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_WITH_OPTIONS__COMMAND = eINSTANCE.getExecWithOptions_Command();

		/**
		 * The meta object literal for the '<em><b>Allow Status Dialog</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_WITH_OPTIONS__ALLOW_STATUS_DIALOG = eINSTANCE.getExecWithOptions_AllowStatusDialog();

		/**
		 * The meta object literal for the '<em><b>Disable Job Waiting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_WITH_OPTIONS__DISABLE_JOB_WAITING = eINSTANCE.getExecWithOptions_DisableJobWaiting();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShutdownAutImpl <em>Shutdown Aut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShutdownAutImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShutdownAut()
		 * @generated
		 */
		EClass SHUTDOWN_AUT = eINSTANCE.getShutdownAut();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetDialogResultImpl <em>Set Dialog Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetDialogResultImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetDialogResult()
		 * @generated
		 */
		EClass SET_DIALOG_RESULT = eINSTANCE.getSetDialogResult();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_DIALOG_RESULT__KIND = eINSTANCE.getSetDialogResult_Kind();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_DIALOG_RESULT__RESULT = eINSTANCE.getSetDialogResult_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyNodesImpl <em>Get Property Nodes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyNodesImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetPropertyNodes()
		 * @generated
		 */
		EClass GET_PROPERTY_NODES = eINSTANCE.getGetPropertyNodes();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_PROPERTY_NODES__ELEMENT = eINSTANCE.getGetPropertyNodes_Element();

		/**
		 * The meta object literal for the '<em><b>Node Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY_NODES__NODE_PATH = eINSTANCE.getGetPropertyNodes_NodePath();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetByOsImpl <em>Get By Os</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetByOsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetByOs()
		 * @generated
		 */
		EClass GET_BY_OS = eINSTANCE.getGetByOs();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_BY_OS__DEFAULT = eINSTANCE.getGetByOs_Default();

		/**
		 * The meta object literal for the '<em><b>Win</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_BY_OS__WIN = eINSTANCE.getGetByOs_Win();

		/**
		 * The meta object literal for the '<em><b>Linux</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_BY_OS__LINUX = eINSTANCE.getGetByOs_Linux();

		/**
		 * The meta object literal for the '<em><b>Macosx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_BY_OS__MACOSX = eINSTANCE.getGetByOs_Macosx();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.FromRawKeyImpl <em>From Raw Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.FromRawKeyImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getFromRawKey()
		 * @generated
		 */
		EClass FROM_RAW_KEY = eINSTANCE.getFromRawKey();

		/**
		 * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_RAW_KEY__MASK = eINSTANCE.getFromRawKey_Mask();

		/**
		 * The meta object literal for the '<em><b>Key Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_RAW_KEY__KEY_CODE = eINSTANCE.getFromRawKey_KeyCode();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FROM_RAW_KEY__META = eINSTANCE.getFromRawKey_Meta();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.HoverAtTextOffsetImpl <em>Hover At Text Offset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.HoverAtTextOffsetImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getHoverAtTextOffset()
		 * @generated
		 */
		EClass HOVER_AT_TEXT_OFFSET = eINSTANCE.getHoverAtTextOffset();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOVER_AT_TEXT_OFFSET__CONTROL = eINSTANCE.getHoverAtTextOffset_Control();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT_OFFSET__OFFSET = eINSTANCE.getHoverAtTextOffset_Offset();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT_OFFSET__LINE = eINSTANCE.getHoverAtTextOffset_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTextViewerImpl <em>Get Text Viewer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTextViewerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTextViewer()
		 * @generated
		 */
		EClass GET_TEXT_VIEWER = eINSTANCE.getGetTextViewer();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SelectRangeImpl <em>Select Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SelectRangeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelectRange()
		 * @generated
		 */
		EClass SELECT_RANGE = eINSTANCE.getSelectRange();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_RANGE__CONTROL = eINSTANCE.getSelectRange_Control();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_RANGE__LINE = eINSTANCE.getSelectRange_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_RANGE__COLUMN = eINSTANCE.getSelectRange_Column();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_RANGE__END_LINE = eINSTANCE.getSelectRange_EndLine();

		/**
		 * The meta object literal for the '<em><b>End Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_RANGE__END_COLUMN = eINSTANCE.getSelectRange_EndColumn();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetCaretPosImpl <em>Set Caret Pos</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetCaretPosImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetCaretPos()
		 * @generated
		 */
		EClass SET_CARET_POS = eINSTANCE.getSetCaretPos();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_CARET_POS__CONTROL = eINSTANCE.getSetCaretPos_Control();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CARET_POS__LINE = eINSTANCE.getSetCaretPos_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CARET_POS__COLUMN = eINSTANCE.getSetCaretPos_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.HoverTextImpl <em>Hover Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.HoverTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getHoverText()
		 * @generated
		 */
		EClass HOVER_TEXT = eINSTANCE.getHoverText();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOVER_TEXT__CONTROL = eINSTANCE.getHoverText_Control();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_TEXT__LINE = eINSTANCE.getHoverText_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_TEXT__COLUMN = eINSTANCE.getHoverText_Column();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_TEXT__WITH = eINSTANCE.getHoverText_With();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.OpenDeclarationImpl <em>Open Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.OpenDeclarationImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getOpenDeclaration()
		 * @generated
		 */
		EClass OPEN_DECLARATION = eINSTANCE.getOpenDeclaration();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPEN_DECLARATION__CONTROL = eINSTANCE.getOpenDeclaration_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetVerticalRulerImpl <em>Get Vertical Ruler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetVerticalRulerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetVerticalRuler()
		 * @generated
		 */
		EClass GET_VERTICAL_RULER = eINSTANCE.getGetVerticalRuler();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLeftRulerImpl <em>Get Left Ruler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLeftRulerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLeftRuler()
		 * @generated
		 */
		EClass GET_LEFT_RULER = eINSTANCE.getGetLeftRuler();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRulerColumnImpl <em>Get Ruler Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRulerColumnImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRulerColumn()
		 * @generated
		 */
		EClass GET_RULER_COLUMN = eINSTANCE.getGetRulerColumn();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_RULER_COLUMN__TEXT = eINSTANCE.getGetRulerColumn_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRightRulerImpl <em>Get Right Ruler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRightRulerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRightRuler()
		 * @generated
		 */
		EClass GET_RIGHT_RULER = eINSTANCE.getGetRightRuler();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickRulerImpl <em>Click Ruler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickRulerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickRuler()
		 * @generated
		 */
		EClass CLICK_RULER = eINSTANCE.getClickRuler();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLICK_RULER__CONTROL = eINSTANCE.getClickRuler_Control();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_RULER__LINE = eINSTANCE.getClickRuler_Line();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_RULER__BUTTON = eINSTANCE.getClickRuler_Button();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_RULER__WITH = eINSTANCE.getClickRuler_With();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickRulerImpl <em>Double Click Ruler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickRulerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDoubleClickRuler()
		 * @generated
		 */
		EClass DOUBLE_CLICK_RULER = eINSTANCE.getDoubleClickRuler();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLE_CLICK_RULER__CONTROL = eINSTANCE.getDoubleClickRuler_Control();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_RULER__LINE = eINSTANCE.getDoubleClickRuler_Line();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_RULER__BUTTON = eINSTANCE.getDoubleClickRuler_Button();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_RULER__WITH = eINSTANCE.getDoubleClickRuler_With();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.HoverRulerImpl <em>Hover Ruler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.HoverRulerImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getHoverRuler()
		 * @generated
		 */
		EClass HOVER_RULER = eINSTANCE.getHoverRuler();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOVER_RULER__CONTROL = eINSTANCE.getHoverRuler_Control();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_RULER__LINE = eINSTANCE.getHoverRuler_Line();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_RULER__WITH = eINSTANCE.getHoverRuler_With();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ControlCommandImpl <em>Control Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ControlCommandImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getControlCommand()
		 * @generated
		 */
		EClass CONTROL_COMMAND = eINSTANCE.getControlCommand();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_COMMAND__CONTROL = eINSTANCE.getControlCommand_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickLinkImpl <em>Click Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickLinkImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickLink()
		 * @generated
		 */
		EClass CLICK_LINK = eINSTANCE.getClickLink();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_LINK__REF = eINSTANCE.getClickLink_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ExpandImpl <em>Expand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ExpandImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getExpand()
		 * @generated
		 */
		EClass EXPAND = eINSTANCE.getExpand();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CollapseImpl <em>Collapse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CollapseImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCollapse()
		 * @generated
		 */
		EClass COLLAPSE = eINSTANCE.getCollapse();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetFocusImpl <em>Set Focus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetFocusImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetFocus()
		 * @generated
		 */
		EClass SET_FOCUS = eINSTANCE.getSetFocus();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTableDataImpl <em>Get Table Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTableDataImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTableData()
		 * @generated
		 */
		EClass GET_TABLE_DATA = eINSTANCE.getGetTableData();

		/**
		 * The meta object literal for the '<em><b>Include Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TABLE_DATA__INCLUDE_CHECKED = eINSTANCE.getGetTableData_IncludeChecked();

		/**
		 * The meta object literal for the '<em><b>Exclude Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TABLE_DATA__EXCLUDE_HIDDEN = eINSTANCE.getGetTableData_ExcludeHidden();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickColumnImpl <em>Click Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickColumnImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickColumn()
		 * @generated
		 */
		EClass CLICK_COLUMN = eINSTANCE.getClickColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_COLUMN__NAME = eINSTANCE.getClickColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_COLUMN__INDEX = eINSTANCE.getClickColumn_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TraceImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE__MESSAGE = eINSTANCE.getTrace_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MouseImpl <em>Mouse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MouseImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMouse()
		 * @generated
		 */
		EClass MOUSE = eINSTANCE.getMouse();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE__EVENT = eINSTANCE.getMouse_Event();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE__BUTTON = eINSTANCE.getMouse_Button();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE__WITH = eINSTANCE.getMouse_With();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE__COUNT = eINSTANCE.getMouse_Count();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE__X = eINSTANCE.getMouse_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE__Y = eINSTANCE.getMouse_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetObjectImpl <em>Get Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetObjectImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetObject()
		 * @generated
		 */
		EClass GET_OBJECT = eINSTANCE.getGetObject();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_OBJECT__OBJECT = eINSTANCE.getGetObject_Object();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetItemsImpl <em>Get Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetItemsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetItems()
		 * @generated
		 */
		EClass GET_ITEMS = eINSTANCE.getGetItems();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ExpandAllImpl <em>Expand All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ExpandAllImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getExpandAll()
		 * @generated
		 */
		EClass EXPAND_ALL = eINSTANCE.getExpandAll();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CollapseAllImpl <em>Collapse All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CollapseAllImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCollapseAll()
		 * @generated
		 */
		EClass COLLAPSE_ALL = eINSTANCE.getCollapseAll();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.TakeScreenshotImpl <em>Take Screenshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TakeScreenshotImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getTakeScreenshot()
		 * @generated
		 */
		EClass TAKE_SCREENSHOT = eINSTANCE.getTakeScreenshot();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAKE_SCREENSHOT__MESSAGE = eINSTANCE.getTakeScreenshot_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SelectItemImpl <em>Select Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SelectItemImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSelectItem()
		 * @generated
		 */
		EClass SELECT_ITEM = eINSTANCE.getSelectItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetWidgetDetailsImpl <em>Get Widget Details</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetWidgetDetailsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetWidgetDetails()
		 * @generated
		 */
		EClass GET_WIDGET_DETAILS = eINSTANCE.getGetWidgetDetails();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_WIDGET_DETAILS__ELEMENT = eINSTANCE.getGetWidgetDetails_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ClickTextImpl <em>Click Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ClickTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getClickText()
		 * @generated
		 */
		EClass CLICK_TEXT = eINSTANCE.getClickText();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_TEXT__START = eINSTANCE.getClickText_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_TEXT__END = eINSTANCE.getClickText_End();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_TEXT__BUTTON = eINSTANCE.getClickText_Button();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetQuickAccessImpl <em>Get Quick Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetQuickAccessImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetQuickAccess()
		 * @generated
		 */
		EClass GET_QUICK_ACCESS = eINSTANCE.getGetQuickAccess();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetColumnHeaderImpl <em>Get Column Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetColumnHeaderImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetColumnHeader()
		 * @generated
		 */
		EClass GET_COLUMN_HEADER = eINSTANCE.getGetColumnHeader();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetPositionImpl <em>Set Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetPositionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetPosition()
		 * @generated
		 */
		EClass SET_POSITION = eINSTANCE.getSetPosition();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_POSITION__INDEX = eINSTANCE.getSetPosition_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.SetWidthImpl <em>Set Width</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.SetWidthImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getSetWidth()
		 * @generated
		 */
		EClass SET_WIDTH = eINSTANCE.getSetWidth();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_WIDTH__WIDTH = eINSTANCE.getSetWidth_Width();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyTabImpl <em>Get Property Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetPropertyTabImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetPropertyTab()
		 * @generated
		 */
		EClass GET_PROPERTY_TAB = eINSTANCE.getGetPropertyTab();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ShowAlertImpl <em>Show Alert</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ShowAlertImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getShowAlert()
		 * @generated
		 */
		EClass SHOW_ALERT = eINSTANCE.getShowAlert();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHOW_ALERT__MESSAGE = eINSTANCE.getShowAlert_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickTextImpl <em>Double Click Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DoubleClickTextImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDoubleClickText()
		 * @generated
		 */
		EClass DOUBLE_CLICK_TEXT = eINSTANCE.getDoubleClickText();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_TEXT__POSITION = eINSTANCE.getDoubleClickText_Position();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_TEXT__BUTTON = eINSTANCE.getDoubleClickText_Button();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.ToControlHandleImpl <em>To Control Handle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.ToControlHandleImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getToControlHandle()
		 * @generated
		 */
		EClass TO_CONTROL_HANDLE = eINSTANCE.getToControlHandle();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TO_CONTROL_HANDLE__WIDGET = eINSTANCE.getToControlHandle_Widget();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.BoundControlHandleImpl <em>Bound Control Handle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.BoundControlHandleImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getBoundControlHandle()
		 * @generated
		 */
		EClass BOUND_CONTROL_HANDLE = eINSTANCE.getBoundControlHandle();

		/**
		 * The meta object literal for the '<em><b>Widget Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUND_CONTROL_HANDLE__WIDGET_ID = eINSTANCE.getBoundControlHandle_WidgetId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.UnfocusImpl <em>Unfocus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.UnfocusImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getUnfocus()
		 * @generated
		 */
		EClass UNFOCUS = eINSTANCE.getUnfocus();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DecryptImpl <em>Decrypt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DecryptImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDecrypt()
		 * @generated
		 */
		EClass DECRYPT = eINSTANCE.getDecrypt();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECRYPT__VALUE = eINSTANCE.getDecrypt_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.DecryptResultImpl <em>Decrypt Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.DecryptResultImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getDecryptResult()
		 * @generated
		 */
		EClass DECRYPT_RESULT = eINSTANCE.getDecryptResult();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECRYPT_RESULT__VALUE = eINSTANCE.getDecryptResult_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.RestartAutImpl <em>Restart Aut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.RestartAutImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getRestartAut()
		 * @generated
		 */
		EClass RESTART_AUT = eINSTANCE.getRestartAut();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.MessageBoxInfoImpl <em>Message Box Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.MessageBoxInfoImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getMessageBoxInfo()
		 * @generated
		 */
		EClass MESSAGE_BOX_INFO = eINSTANCE.getMessageBoxInfo();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_BOX_INFO__TITLE = eINSTANCE.getMessageBoxInfo_Title();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_BOX_INFO__MESSAGE = eINSTANCE.getMessageBoxInfo_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetLastMessageBoxImpl <em>Get Last Message Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetLastMessageBoxImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetLastMessageBox()
		 * @generated
		 */
		EClass GET_LAST_MESSAGE_BOX = eINSTANCE.getGetLastMessageBox();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.CheckDownloadResultImpl <em>Check Download Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.CheckDownloadResultImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getCheckDownloadResult()
		 * @generated
		 */
		EClass CHECK_DOWNLOAD_RESULT = eINSTANCE.getCheckDownloadResult();

		/**
		 * The meta object literal for the '<em><b>Content On Base64</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_DOWNLOAD_RESULT__CONTENT_ON_BASE64 = eINSTANCE.getCheckDownloadResult_ContentOnBase64();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_DOWNLOAD_RESULT__FILE_NAME = eINSTANCE.getCheckDownloadResult_FileName();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetRuntimeTargetImpl <em>Get Runtime Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetRuntimeTargetImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetRuntimeTarget()
		 * @generated
		 */
		EClass GET_RUNTIME_TARGET = eINSTANCE.getGetRuntimeTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetTestCaseNameImpl <em>Get Test Case Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetTestCaseNameImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetTestCaseName()
		 * @generated
		 */
		EClass GET_TEST_CASE_NAME = eINSTANCE.getGetTestCaseName();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.impl.GetComboItemsImpl <em>Get Combo Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.GetComboItemsImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getGetComboItems()
		 * @generated
		 */
		EClass GET_COMBO_ITEMS = eINSTANCE.getGetComboItems();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.Button <em>Button</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.Button
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getButton()
		 * @generated
		 */
		EEnum BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.ActivationEventType <em>Activation Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.ActivationEventType
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getActivationEventType()
		 * @generated
		 */
		EEnum ACTIVATION_EVENT_TYPE = eINSTANCE.getActivationEventType();

		/**
		 * The meta object literal for the '<em>Element Kind</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.ElementKind
		 * @see org.eclipse.rcptt.tesla.ecl.model.impl.TeslaPackageImpl#getElementKind()
		 * @generated
		 */
		EDataType ELEMENT_KIND = eINSTANCE.getElementKind();

	}

} //TeslaPackage
