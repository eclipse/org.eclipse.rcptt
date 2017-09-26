/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.core.model;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory
 * @model kind="package"
 * @generated
 */
public interface Q7CorePackage extends EPackage {
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
	String eNS_URI = "http://eclipse.org/rcptt/core/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.core.ecl.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Q7CorePackage eINSTANCE = org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.EnterContextImpl <em>Enter Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.EnterContextImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getEnterContext()
	 * @generated
	 */
	int ENTER_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_CONTEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_CONTEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_CONTEXT__DATA = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enter Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_CONTEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateContextImpl <em>Create Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateContextImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateContext()
	 * @generated
	 */
	int CREATE_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONTEXT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONTEXT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONTEXT__TYPE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONTEXT__PARAM = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Create Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONTEXT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.PrepareEnvironmentImpl <em>Prepare Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.PrepareEnvironmentImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getPrepareEnvironment()
	 * @generated
	 */
	int PREPARE_ENVIRONMENT = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_ENVIRONMENT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_ENVIRONMENT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Prepare Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_ENVIRONMENT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetCommandsDelayImpl <em>Set Commands Delay</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetCommandsDelayImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetCommandsDelay()
	 * @generated
	 */
	int SET_COMMANDS_DELAY = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMMANDS_DELAY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMMANDS_DELAY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMMANDS_DELAY__DELAY = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Commands Delay</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMMANDS_DELAY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetQ7InformationImpl <em>Get Q7 Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetQ7InformationImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetQ7Information()
	 * @generated
	 */
	int GET_Q7_INFORMATION = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_Q7_INFORMATION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_Q7_INFORMATION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Q7 Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_Q7_INFORMATION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl <em>Q7 Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getQ7Information()
	 * @generated
	 */
	int Q7_INFORMATION = 5;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFORMATION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Tesla Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFORMATION__TESLA_ACTIVE = 1;

	/**
	 * The feature id for the '<em><b>Tesla Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFORMATION__TESLA_PORT = 2;

	/**
	 * The feature id for the '<em><b>Client Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFORMATION__CLIENT_ACTIVE = 3;

	/**
	 * The feature id for the '<em><b>Window Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFORMATION__WINDOW_COUNT = 4;

	/**
	 * The number of structural features of the '<em>Q7 Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFORMATION_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7FeaturesImpl <em>Set Q7 Features</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7FeaturesImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetQ7Features()
	 * @generated
	 */
	int SET_Q7_FEATURES = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_FEATURES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_FEATURES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Features</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_FEATURES__FEATURES = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Q7 Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_FEATURES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetPerspectivesImpl <em>Get Perspectives</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetPerspectivesImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetPerspectives()
	 * @generated
	 */
	int GET_PERSPECTIVES = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PERSPECTIVES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PERSPECTIVES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Perspectives</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PERSPECTIVES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.PerspectiveInfoImpl <em>Perspective Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.PerspectiveInfoImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getPerspectiveInfo()
	 * @generated
	 */
	int PERSPECTIVE_INFO = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_INFO__ID = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_INFO__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_INFO__LABEL = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_INFO__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Perspective Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVE_INFO_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.PerspectivesListImpl <em>Perspectives List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.PerspectivesListImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getPerspectivesList()
	 * @generated
	 */
	int PERSPECTIVES_LIST = 9;

	/**
	 * The feature id for the '<em><b>Perspectives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVES_LIST__PERSPECTIVES = 0;

	/**
	 * The number of structural features of the '<em>Perspectives List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSPECTIVES_LIST_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetViewsImpl <em>Get Views</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetViewsImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetViews()
	 * @generated
	 */
	int GET_VIEWS = 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEWS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEWS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Views</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VIEWS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ViewInfoImpl <em>View Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ViewInfoImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getViewInfo()
	 * @generated
	 */
	int VIEW_INFO = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INFO__ID = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INFO__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INFO__LABEL = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INFO__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INFO__ITEMS = 4;

	/**
	 * The number of structural features of the '<em>View Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INFO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ViewListImpl <em>View List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ViewListImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getViewList()
	 * @generated
	 */
	int VIEW_LIST = 12;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_LIST__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>View List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_LIST_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateReportImpl <em>Create Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateReportImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateReport()
	 * @generated
	 */
	int CREATE_REPORT = 13;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REPORT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REPORT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REPORT__NAME = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Q7info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REPORT__Q7INFO = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Create Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REPORT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetReportImpl <em>Get Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetReportImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetReport()
	 * @generated
	 */
	int GET_REPORT = 14;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REPORT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REPORT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REPORT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.BeginReportNodeImpl <em>Begin Report Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.BeginReportNodeImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getBeginReportNode()
	 * @generated
	 */
	int BEGIN_REPORT_NODE = 15;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN_REPORT_NODE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN_REPORT_NODE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN_REPORT_NODE__NAME = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN_REPORT_NODE__PROPERTIES = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Begin Report Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEGIN_REPORT_NODE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl <em>End Report Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getEndReportNode()
	 * @generated
	 */
	int END_REPORT_NODE = 16;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REPORT_NODE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REPORT_NODE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Snaphots</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REPORT_NODE__SNAPHOTS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Take Snaphots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REPORT_NODE__TAKE_SNAPHOTS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REPORT_NODE__RESULT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>End Report Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REPORT_NODE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ReportAppendImpl <em>Report Append</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ReportAppendImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getReportAppend()
	 * @generated
	 */
	int REPORT_APPEND = 17;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_APPEND__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_APPEND__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_APPEND__OBJECTS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Report Append</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_APPEND_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7OptionImpl <em>Set Q7 Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7OptionImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetQ7Option()
	 * @generated
	 */
	int SET_Q7_OPTION = 18;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_OPTION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_OPTION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_OPTION__KEY = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_OPTION__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Q7 Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_Q7_OPTION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ExecVerificationImpl <em>Exec Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ExecVerificationImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getExecVerification()
	 * @generated
	 */
	int EXEC_VERIFICATION = 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_VERIFICATION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_VERIFICATION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Verification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_VERIFICATION__VERIFICATION = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_VERIFICATION__PHASE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exec Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_VERIFICATION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ResetVerificationsImpl <em>Reset Verifications</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ResetVerificationsImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getResetVerifications()
	 * @generated
	 */
	int RESET_VERIFICATIONS = 20;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_VERIFICATIONS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_VERIFICATIONS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Reset Verifications</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_VERIFICATIONS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateVerificationImpl <em>Create Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateVerificationImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateVerification()
	 * @generated
	 */
	int CREATE_VERIFICATION = 21;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERIFICATION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERIFICATION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERIFICATION__TYPE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERIFICATION__PARAM = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Create Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VERIFICATION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateWidgetVerificationParamImpl <em>Create Widget Verification Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateWidgetVerificationParamImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateWidgetVerificationParam()
	 * @generated
	 */
	int CREATE_WIDGET_VERIFICATION_PARAM = 22;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_WIDGET_VERIFICATION_PARAM__SELECTOR = 0;

	/**
	 * The number of structural features of the '<em>Create Widget Verification Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_WIDGET_VERIFICATION_PARAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.TerminateAutImpl <em>Terminate Aut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.TerminateAutImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getTerminateAut()
	 * @generated
	 */
	int TERMINATE_AUT = 23;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_AUT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_AUT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Terminate Aut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_AUT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetOptionImpl <em>Set Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetOptionImpl
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetOption()
	 * @generated
	 */
	int SET_OPTION = 24;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OPTION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OPTION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OPTION__KEY = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OPTION__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_OPTION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase <em>Execution Phase</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase
	 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getExecutionPhase()
	 * @generated
	 */
	int EXECUTION_PHASE = 25;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.EnterContext <em>Enter Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enter Context</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EnterContext
	 * @generated
	 */
	EClass getEnterContext();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.ecl.core.model.EnterContext#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EnterContext#getData()
	 * @see #getEnterContext()
	 * @generated
	 */
	EReference getEnterContext_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateContext <em>Create Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Context</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateContext
	 * @generated
	 */
	EClass getCreateContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.CreateContext#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateContext#getType()
	 * @see #getCreateContext()
	 * @generated
	 */
	EAttribute getCreateContext_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.core.ecl.core.model.CreateContext#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Param</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateContext#getParam()
	 * @see #getCreateContext()
	 * @generated
	 */
	EReference getCreateContext_Param();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment <em>Prepare Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prepare Environment</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment
	 * @generated
	 */
	EClass getPrepareEnvironment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay <em>Set Commands Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Commands Delay</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay
	 * @generated
	 */
	EClass getSetCommandsDelay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay#getDelay()
	 * @see #getSetCommandsDelay()
	 * @generated
	 */
	EAttribute getSetCommandsDelay_Delay();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.GetQ7Information <em>Get Q7 Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Q7 Information</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetQ7Information
	 * @generated
	 */
	EClass getGetQ7Information();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information <em>Q7 Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Q7 Information</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information
	 * @generated
	 */
	EClass getQ7Information();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information#getVersion()
	 * @see #getQ7Information()
	 * @generated
	 */
	EAttribute getQ7Information_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#isTeslaActive <em>Tesla Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tesla Active</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information#isTeslaActive()
	 * @see #getQ7Information()
	 * @generated
	 */
	EAttribute getQ7Information_TeslaActive();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getTeslaPort <em>Tesla Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tesla Port</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information#getTeslaPort()
	 * @see #getQ7Information()
	 * @generated
	 */
	EAttribute getQ7Information_TeslaPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#isClientActive <em>Client Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Active</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information#isClientActive()
	 * @see #getQ7Information()
	 * @generated
	 */
	EAttribute getQ7Information_ClientActive();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getWindowCount <em>Window Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Window Count</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information#getWindowCount()
	 * @see #getQ7Information()
	 * @generated
	 */
	EAttribute getQ7Information_WindowCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Features <em>Set Q7 Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Q7 Features</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Features
	 * @generated
	 */
	EClass getSetQ7Features();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Features#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Features</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Features#getFeatures()
	 * @see #getSetQ7Features()
	 * @generated
	 */
	EAttribute getSetQ7Features_Features();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.GetPerspectives <em>Get Perspectives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Perspectives</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetPerspectives
	 * @generated
	 */
	EClass getGetPerspectives();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo <em>Perspective Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Perspective Info</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo
	 * @generated
	 */
	EClass getPerspectiveInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getId()
	 * @see #getPerspectiveInfo()
	 * @generated
	 */
	EAttribute getPerspectiveInfo_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getImage()
	 * @see #getPerspectiveInfo()
	 * @generated
	 */
	EAttribute getPerspectiveInfo_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getLabel()
	 * @see #getPerspectiveInfo()
	 * @generated
	 */
	EAttribute getPerspectiveInfo_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo#getDescription()
	 * @see #getPerspectiveInfo()
	 * @generated
	 */
	EAttribute getPerspectiveInfo_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectivesList <em>Perspectives List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Perspectives List</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectivesList
	 * @generated
	 */
	EClass getPerspectivesList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectivesList#getPerspectives <em>Perspectives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Perspectives</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectivesList#getPerspectives()
	 * @see #getPerspectivesList()
	 * @generated
	 */
	EReference getPerspectivesList_Perspectives();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.GetViews <em>Get Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Views</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetViews
	 * @generated
	 */
	EClass getGetViews();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo <em>View Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Info</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo
	 * @generated
	 */
	EClass getViewInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getId()
	 * @see #getViewInfo()
	 * @generated
	 */
	EAttribute getViewInfo_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getImage()
	 * @see #getViewInfo()
	 * @generated
	 */
	EAttribute getViewInfo_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getLabel()
	 * @see #getViewInfo()
	 * @generated
	 */
	EAttribute getViewInfo_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getDescription()
	 * @see #getViewInfo()
	 * @generated
	 */
	EAttribute getViewInfo_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo#getItems()
	 * @see #getViewInfo()
	 * @generated
	 */
	EReference getViewInfo_Items();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.ViewList <em>View List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View List</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewList
	 * @generated
	 */
	EClass getViewList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.ecl.core.model.ViewList#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewList#getItems()
	 * @see #getViewList()
	 * @generated
	 */
	EReference getViewList_Items();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateReport <em>Create Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Report</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateReport
	 * @generated
	 */
	EClass getCreateReport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.CreateReport#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateReport#getName()
	 * @see #getCreateReport()
	 * @generated
	 */
	EAttribute getCreateReport_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.core.ecl.core.model.CreateReport#getQ7info <em>Q7info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Q7info</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateReport#getQ7info()
	 * @see #getCreateReport()
	 * @generated
	 */
	EReference getCreateReport_Q7info();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.GetReport <em>Get Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Report</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetReport
	 * @generated
	 */
	EClass getGetReport();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.BeginReportNode <em>Begin Report Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Begin Report Node</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.BeginReportNode
	 * @generated
	 */
	EClass getBeginReportNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.BeginReportNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.BeginReportNode#getName()
	 * @see #getBeginReportNode()
	 * @generated
	 */
	EAttribute getBeginReportNode_Name();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.core.ecl.core.model.BeginReportNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.BeginReportNode#getProperties()
	 * @see #getBeginReportNode()
	 * @generated
	 */
	EReference getBeginReportNode_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode <em>End Report Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Report Node</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EndReportNode
	 * @generated
	 */
	EClass getEndReportNode();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#getSnaphots <em>Snaphots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Snaphots</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EndReportNode#getSnaphots()
	 * @see #getEndReportNode()
	 * @generated
	 */
	EAttribute getEndReportNode_Snaphots();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#isTakeSnaphots <em>Take Snaphots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Take Snaphots</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EndReportNode#isTakeSnaphots()
	 * @see #getEndReportNode()
	 * @generated
	 */
	EAttribute getEndReportNode_TakeSnaphots();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EndReportNode#getResult()
	 * @see #getEndReportNode()
	 * @generated
	 */
	EReference getEndReportNode_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.ReportAppend <em>Report Append</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Report Append</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ReportAppend
	 * @generated
	 */
	EClass getReportAppend();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.core.ecl.core.model.ReportAppend#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objects</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ReportAppend#getObjects()
	 * @see #getReportAppend()
	 * @generated
	 */
	EReference getReportAppend_Objects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option <em>Set Q7 Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Q7 Option</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Option
	 * @generated
	 */
	EClass getSetQ7Option();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getKey()
	 * @see #getSetQ7Option()
	 * @generated
	 */
	EAttribute getSetQ7Option_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getValue()
	 * @see #getSetQ7Option()
	 * @generated
	 */
	EAttribute getSetQ7Option_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification <em>Exec Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Verification</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecVerification
	 * @generated
	 */
	EClass getExecVerification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Verification</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getVerification()
	 * @see #getExecVerification()
	 * @generated
	 */
	EReference getExecVerification_Verification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getPhase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getPhase()
	 * @see #getExecVerification()
	 * @generated
	 */
	EAttribute getExecVerification_Phase();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.ResetVerifications <em>Reset Verifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reset Verifications</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ResetVerifications
	 * @generated
	 */
	EClass getResetVerifications();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification <em>Create Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Verification</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateVerification
	 * @generated
	 */
	EClass getCreateVerification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getType()
	 * @see #getCreateVerification()
	 * @generated
	 */
	EAttribute getCreateVerification_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Param</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getParam()
	 * @see #getCreateVerification()
	 * @generated
	 */
	EReference getCreateVerification_Param();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam <em>Create Widget Verification Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Widget Verification Param</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam
	 * @generated
	 */
	EClass getCreateWidgetVerificationParam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selector</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam#getSelector()
	 * @see #getCreateWidgetVerificationParam()
	 * @generated
	 */
	EAttribute getCreateWidgetVerificationParam_Selector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.TerminateAut <em>Terminate Aut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate Aut</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.TerminateAut
	 * @generated
	 */
	EClass getTerminateAut();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.ecl.core.model.SetOption <em>Set Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Option</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetOption
	 * @generated
	 */
	EClass getSetOption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.SetOption#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetOption#getKey()
	 * @see #getSetOption()
	 * @generated
	 */
	EAttribute getSetOption_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.ecl.core.model.SetOption#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetOption#getValue()
	 * @see #getSetOption()
	 * @generated
	 */
	EAttribute getSetOption_Value();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase <em>Execution Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Phase</em>'.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase
	 * @generated
	 */
	EEnum getExecutionPhase();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Q7CoreFactory getQ7CoreFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.EnterContextImpl <em>Enter Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.EnterContextImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getEnterContext()
		 * @generated
		 */
		EClass ENTER_CONTEXT = eINSTANCE.getEnterContext();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTER_CONTEXT__DATA = eINSTANCE.getEnterContext_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateContextImpl <em>Create Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateContextImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateContext()
		 * @generated
		 */
		EClass CREATE_CONTEXT = eINSTANCE.getCreateContext();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_CONTEXT__TYPE = eINSTANCE.getCreateContext_Type();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_CONTEXT__PARAM = eINSTANCE.getCreateContext_Param();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.PrepareEnvironmentImpl <em>Prepare Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.PrepareEnvironmentImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getPrepareEnvironment()
		 * @generated
		 */
		EClass PREPARE_ENVIRONMENT = eINSTANCE.getPrepareEnvironment();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetCommandsDelayImpl <em>Set Commands Delay</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetCommandsDelayImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetCommandsDelay()
		 * @generated
		 */
		EClass SET_COMMANDS_DELAY = eINSTANCE.getSetCommandsDelay();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_COMMANDS_DELAY__DELAY = eINSTANCE.getSetCommandsDelay_Delay();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetQ7InformationImpl <em>Get Q7 Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetQ7InformationImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetQ7Information()
		 * @generated
		 */
		EClass GET_Q7_INFORMATION = eINSTANCE.getGetQ7Information();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl <em>Q7 Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getQ7Information()
		 * @generated
		 */
		EClass Q7_INFORMATION = eINSTANCE.getQ7Information();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFORMATION__VERSION = eINSTANCE.getQ7Information_Version();

		/**
		 * The meta object literal for the '<em><b>Tesla Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFORMATION__TESLA_ACTIVE = eINSTANCE.getQ7Information_TeslaActive();

		/**
		 * The meta object literal for the '<em><b>Tesla Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFORMATION__TESLA_PORT = eINSTANCE.getQ7Information_TeslaPort();

		/**
		 * The meta object literal for the '<em><b>Client Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFORMATION__CLIENT_ACTIVE = eINSTANCE.getQ7Information_ClientActive();

		/**
		 * The meta object literal for the '<em><b>Window Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFORMATION__WINDOW_COUNT = eINSTANCE.getQ7Information_WindowCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7FeaturesImpl <em>Set Q7 Features</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7FeaturesImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetQ7Features()
		 * @generated
		 */
		EClass SET_Q7_FEATURES = eINSTANCE.getSetQ7Features();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_Q7_FEATURES__FEATURES = eINSTANCE.getSetQ7Features_Features();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetPerspectivesImpl <em>Get Perspectives</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetPerspectivesImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetPerspectives()
		 * @generated
		 */
		EClass GET_PERSPECTIVES = eINSTANCE.getGetPerspectives();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.PerspectiveInfoImpl <em>Perspective Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.PerspectiveInfoImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getPerspectiveInfo()
		 * @generated
		 */
		EClass PERSPECTIVE_INFO = eINSTANCE.getPerspectiveInfo();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSPECTIVE_INFO__ID = eINSTANCE.getPerspectiveInfo_Id();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSPECTIVE_INFO__IMAGE = eINSTANCE.getPerspectiveInfo_Image();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSPECTIVE_INFO__LABEL = eINSTANCE.getPerspectiveInfo_Label();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSPECTIVE_INFO__DESCRIPTION = eINSTANCE.getPerspectiveInfo_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.PerspectivesListImpl <em>Perspectives List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.PerspectivesListImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getPerspectivesList()
		 * @generated
		 */
		EClass PERSPECTIVES_LIST = eINSTANCE.getPerspectivesList();

		/**
		 * The meta object literal for the '<em><b>Perspectives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSPECTIVES_LIST__PERSPECTIVES = eINSTANCE.getPerspectivesList_Perspectives();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetViewsImpl <em>Get Views</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetViewsImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetViews()
		 * @generated
		 */
		EClass GET_VIEWS = eINSTANCE.getGetViews();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ViewInfoImpl <em>View Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ViewInfoImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getViewInfo()
		 * @generated
		 */
		EClass VIEW_INFO = eINSTANCE.getViewInfo();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_INFO__ID = eINSTANCE.getViewInfo_Id();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_INFO__IMAGE = eINSTANCE.getViewInfo_Image();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_INFO__LABEL = eINSTANCE.getViewInfo_Label();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_INFO__DESCRIPTION = eINSTANCE.getViewInfo_Description();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_INFO__ITEMS = eINSTANCE.getViewInfo_Items();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ViewListImpl <em>View List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ViewListImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getViewList()
		 * @generated
		 */
		EClass VIEW_LIST = eINSTANCE.getViewList();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_LIST__ITEMS = eINSTANCE.getViewList_Items();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateReportImpl <em>Create Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateReportImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateReport()
		 * @generated
		 */
		EClass CREATE_REPORT = eINSTANCE.getCreateReport();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_REPORT__NAME = eINSTANCE.getCreateReport_Name();

		/**
		 * The meta object literal for the '<em><b>Q7info</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_REPORT__Q7INFO = eINSTANCE.getCreateReport_Q7info();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.GetReportImpl <em>Get Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.GetReportImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getGetReport()
		 * @generated
		 */
		EClass GET_REPORT = eINSTANCE.getGetReport();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.BeginReportNodeImpl <em>Begin Report Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.BeginReportNodeImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getBeginReportNode()
		 * @generated
		 */
		EClass BEGIN_REPORT_NODE = eINSTANCE.getBeginReportNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEGIN_REPORT_NODE__NAME = eINSTANCE.getBeginReportNode_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEGIN_REPORT_NODE__PROPERTIES = eINSTANCE.getBeginReportNode_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl <em>End Report Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getEndReportNode()
		 * @generated
		 */
		EClass END_REPORT_NODE = eINSTANCE.getEndReportNode();

		/**
		 * The meta object literal for the '<em><b>Snaphots</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute END_REPORT_NODE__SNAPHOTS = eINSTANCE.getEndReportNode_Snaphots();

		/**
		 * The meta object literal for the '<em><b>Take Snaphots</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute END_REPORT_NODE__TAKE_SNAPHOTS = eINSTANCE.getEndReportNode_TakeSnaphots();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_REPORT_NODE__RESULT = eINSTANCE.getEndReportNode_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ReportAppendImpl <em>Report Append</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ReportAppendImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getReportAppend()
		 * @generated
		 */
		EClass REPORT_APPEND = eINSTANCE.getReportAppend();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT_APPEND__OBJECTS = eINSTANCE.getReportAppend_Objects();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7OptionImpl <em>Set Q7 Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetQ7OptionImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetQ7Option()
		 * @generated
		 */
		EClass SET_Q7_OPTION = eINSTANCE.getSetQ7Option();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_Q7_OPTION__KEY = eINSTANCE.getSetQ7Option_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_Q7_OPTION__VALUE = eINSTANCE.getSetQ7Option_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ExecVerificationImpl <em>Exec Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ExecVerificationImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getExecVerification()
		 * @generated
		 */
		EClass EXEC_VERIFICATION = eINSTANCE.getExecVerification();

		/**
		 * The meta object literal for the '<em><b>Verification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_VERIFICATION__VERIFICATION = eINSTANCE.getExecVerification_Verification();

		/**
		 * The meta object literal for the '<em><b>Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_VERIFICATION__PHASE = eINSTANCE.getExecVerification_Phase();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.ResetVerificationsImpl <em>Reset Verifications</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.ResetVerificationsImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getResetVerifications()
		 * @generated
		 */
		EClass RESET_VERIFICATIONS = eINSTANCE.getResetVerifications();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateVerificationImpl <em>Create Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateVerificationImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateVerification()
		 * @generated
		 */
		EClass CREATE_VERIFICATION = eINSTANCE.getCreateVerification();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_VERIFICATION__TYPE = eINSTANCE.getCreateVerification_Type();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_VERIFICATION__PARAM = eINSTANCE.getCreateVerification_Param();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.CreateWidgetVerificationParamImpl <em>Create Widget Verification Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.CreateWidgetVerificationParamImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getCreateWidgetVerificationParam()
		 * @generated
		 */
		EClass CREATE_WIDGET_VERIFICATION_PARAM = eINSTANCE.getCreateWidgetVerificationParam();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_WIDGET_VERIFICATION_PARAM__SELECTOR = eINSTANCE.getCreateWidgetVerificationParam_Selector();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.TerminateAutImpl <em>Terminate Aut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.TerminateAutImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getTerminateAut()
		 * @generated
		 */
		EClass TERMINATE_AUT = eINSTANCE.getTerminateAut();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.impl.SetOptionImpl <em>Set Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.SetOptionImpl
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getSetOption()
		 * @generated
		 */
		EClass SET_OPTION = eINSTANCE.getSetOption();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_OPTION__KEY = eINSTANCE.getSetOption_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_OPTION__VALUE = eINSTANCE.getSetOption_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase <em>Execution Phase</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase
		 * @see org.eclipse.rcptt.core.ecl.core.model.impl.Q7CorePackageImpl#getExecutionPhase()
		 * @generated
		 */
		EEnum EXECUTION_PHASE = eINSTANCE.getExecutionPhase();

	}

} //Q7CorePackage
