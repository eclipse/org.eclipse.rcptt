/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.platform.commands;


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
 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsFactory
 * @model kind="package"
 * @generated
 */
public interface CommandsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commands";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/platform/commands.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "platformCommands";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsPackage eINSTANCE = org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListPluginsImpl <em>List Plugins</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListPluginsImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListPlugins()
	 * @generated
	 */
	int LIST_PLUGINS = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PLUGINS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PLUGINS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Include Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PLUGINS__INCLUDE_DEPENDENCIES = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Plugins</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_PLUGINS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListFeaturesImpl <em>List Features</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListFeaturesImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListFeatures()
	 * @generated
	 */
	int LIST_FEATURES = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>List Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListRepositoriesImpl <em>List Repositories</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListRepositoriesImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListRepositories()
	 * @generated
	 */
	int LIST_REPOSITORIES = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_REPOSITORIES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_REPOSITORIES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>List Repositories</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_REPOSITORIES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.AddRepositoryImpl <em>Add Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.AddRepositoryImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getAddRepository()
	 * @generated
	 */
	int ADD_REPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REPOSITORY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REPOSITORY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REPOSITORY__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REPOSITORY__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Add Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REPOSITORY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.RemoveRepositoryImpl <em>Remove Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.RemoveRepositoryImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getRemoveRepository()
	 * @generated
	 */
	int REMOVE_REPOSITORY = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REPOSITORY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REPOSITORY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REPOSITORY__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REPOSITORY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.UpdateFeatureImpl <em>Update Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.UpdateFeatureImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getUpdateFeature()
	 * @generated
	 */
	int UPDATE_FEATURE = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.UpdateAllImpl <em>Update All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.UpdateAllImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getUpdateAll()
	 * @generated
	 */
	int UPDATE_ALL = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_ALL__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_ALL__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Update All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_ALL_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.SortByImpl <em>Sort By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.SortByImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getSortBy()
	 * @generated
	 */
	int SORT_BY = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_BY__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_BY__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_BY__FIELD = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sort By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_BY_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListInstallUnitsImpl <em>List Install Units</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListInstallUnitsImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListInstallUnits()
	 * @generated
	 */
	int LIST_INSTALL_UNITS = 8;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_INSTALL_UNITS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_INSTALL_UNITS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>List Install Units</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_INSTALL_UNITS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetLogImpl <em>Get Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetLogImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetLog()
	 * @generated
	 */
	int GET_LOG = 9;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LOG__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LOG__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Levels</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LOG__LEVELS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LOG__LIMIT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_LOG_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.LogImpl <em>Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.LogImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getLog()
	 * @generated
	 */
	int LOG = 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__MESSAGE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__SEVERITY = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__PLUGIN = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.EchoImpl <em>Echo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.EchoImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getEcho()
	 * @generated
	 */
	int ECHO = 11;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO__STR = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Echo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHO_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ClearLogImpl <em>Clear Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ClearLogImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getClearLog()
	 * @generated
	 */
	int CLEAR_LOG = 12;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAR_LOG__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAR_LOG__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Clear Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAR_LOG_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListLaunchConfigurationsImpl <em>List Launch Configurations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListLaunchConfigurationsImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListLaunchConfigurations()
	 * @generated
	 */
	int LIST_LAUNCH_CONFIGURATIONS = 13;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LAUNCH_CONFIGURATIONS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LAUNCH_CONFIGURATIONS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>List Launch Configurations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LAUNCH_CONFIGURATIONS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.LaunchImpl <em>Launch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.LaunchImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getLaunch()
	 * @generated
	 */
	int LAUNCH = 14;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__MODE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Launch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.SubstituteVariablesImpl <em>Substitute Variables</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.SubstituteVariablesImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getSubstituteVariables()
	 * @generated
	 */
	int SUBSTITUTE_VARIABLES = 15;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTE_VARIABLES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTE_VARIABLES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTE_VARIABLES__EXPRESSION = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ignore Undefined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTE_VARIABLES__IGNORE_UNDEFINED = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Substitute Variables</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTE_VARIABLES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetWorkspaceLocationImpl <em>Get Workspace Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetWorkspaceLocationImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetWorkspaceLocation()
	 * @generated
	 */
	int GET_WORKSPACE_LOCATION = 16;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WORKSPACE_LOCATION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WORKSPACE_LOCATION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Get Workspace Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_WORKSPACE_LOCATION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.FindInWorkspaceImpl <em>Find In Workspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.FindInWorkspaceImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getFindInWorkspace()
	 * @generated
	 */
	int FIND_IN_WORKSPACE = 17;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_IN_WORKSPACE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_IN_WORKSPACE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_IN_WORKSPACE__PATH = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_IN_WORKSPACE__ALL = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Find In Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIND_IN_WORKSPACE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusMessageImpl <em>Get Status Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusMessageImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetStatusMessage()
	 * @generated
	 */
	int GET_STATUS_MESSAGE = 18;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_MESSAGE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_MESSAGE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_MESSAGE__STATUS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Status Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_MESSAGE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusTraceImpl <em>Get Status Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusTraceImpl
	 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetStatusTrace()
	 * @generated
	 */
	int GET_STATUS_TRACE = 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_TRACE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_TRACE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_TRACE__STATUS = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Status Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATUS_TRACE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.ListPlugins <em>List Plugins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Plugins</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ListPlugins
	 * @generated
	 */
	EClass getListPlugins();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.ListPlugins#isIncludeDependencies <em>Include Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Dependencies</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ListPlugins#isIncludeDependencies()
	 * @see #getListPlugins()
	 * @generated
	 */
	EAttribute getListPlugins_IncludeDependencies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.ListFeatures <em>List Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Features</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ListFeatures
	 * @generated
	 */
	EClass getListFeatures();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.ListRepositories <em>List Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Repositories</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ListRepositories
	 * @generated
	 */
	EClass getListRepositories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.AddRepository <em>Add Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Repository</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.AddRepository
	 * @generated
	 */
	EClass getAddRepository();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.AddRepository#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.AddRepository#getUri()
	 * @see #getAddRepository()
	 * @generated
	 */
	EAttribute getAddRepository_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.AddRepository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.AddRepository#getName()
	 * @see #getAddRepository()
	 * @generated
	 */
	EAttribute getAddRepository_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.RemoveRepository <em>Remove Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Repository</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.RemoveRepository
	 * @generated
	 */
	EClass getRemoveRepository();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.RemoveRepository#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.RemoveRepository#getUri()
	 * @see #getRemoveRepository()
	 * @generated
	 */
	EAttribute getRemoveRepository_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.UpdateFeature <em>Update Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Feature</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.UpdateFeature
	 * @generated
	 */
	EClass getUpdateFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.UpdateFeature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.UpdateFeature#getId()
	 * @see #getUpdateFeature()
	 * @generated
	 */
	EAttribute getUpdateFeature_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.UpdateAll <em>Update All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update All</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.UpdateAll
	 * @generated
	 */
	EClass getUpdateAll();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.SortBy <em>Sort By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sort By</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.SortBy
	 * @generated
	 */
	EClass getSortBy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.SortBy#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.SortBy#getField()
	 * @see #getSortBy()
	 * @generated
	 */
	EAttribute getSortBy_Field();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.ListInstallUnits <em>List Install Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Install Units</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ListInstallUnits
	 * @generated
	 */
	EClass getListInstallUnits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.GetLog <em>Get Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Log</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetLog
	 * @generated
	 */
	EClass getGetLog();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.platform.commands.GetLog#getLevels <em>Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Levels</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetLog#getLevels()
	 * @see #getGetLog()
	 * @generated
	 */
	EAttribute getGetLog_Levels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.GetLog#getLimit <em>Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limit</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetLog#getLimit()
	 * @see #getGetLog()
	 * @generated
	 */
	EAttribute getGetLog_Limit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.Log <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Log
	 * @generated
	 */
	EClass getLog();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.Log#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Log#getMessage()
	 * @see #getLog()
	 * @generated
	 */
	EAttribute getLog_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.Log#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Log#getSeverity()
	 * @see #getLog()
	 * @generated
	 */
	EAttribute getLog_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.Log#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Log#getPlugin()
	 * @see #getLog()
	 * @generated
	 */
	EAttribute getLog_Plugin();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.Echo <em>Echo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Echo</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Echo
	 * @generated
	 */
	EClass getEcho();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.Echo#getStr <em>Str</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Str</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Echo#getStr()
	 * @see #getEcho()
	 * @generated
	 */
	EAttribute getEcho_Str();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.ClearLog <em>Clear Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clear Log</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ClearLog
	 * @generated
	 */
	EClass getClearLog();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.ListLaunchConfigurations <em>List Launch Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Launch Configurations</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.ListLaunchConfigurations
	 * @generated
	 */
	EClass getListLaunchConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.Launch <em>Launch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Launch</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Launch
	 * @generated
	 */
	EClass getLaunch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.Launch#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Launch#getMode()
	 * @see #getLaunch()
	 * @generated
	 */
	EAttribute getLaunch_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.Launch#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.Launch#getName()
	 * @see #getLaunch()
	 * @generated
	 */
	EAttribute getLaunch_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.SubstituteVariables <em>Substitute Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substitute Variables</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.SubstituteVariables
	 * @generated
	 */
	EClass getSubstituteVariables();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.SubstituteVariables#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.SubstituteVariables#getExpression()
	 * @see #getSubstituteVariables()
	 * @generated
	 */
	EAttribute getSubstituteVariables_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.SubstituteVariables#isIgnoreUndefined <em>Ignore Undefined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Undefined</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.SubstituteVariables#isIgnoreUndefined()
	 * @see #getSubstituteVariables()
	 * @generated
	 */
	EAttribute getSubstituteVariables_IgnoreUndefined();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.GetWorkspaceLocation <em>Get Workspace Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Workspace Location</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetWorkspaceLocation
	 * @generated
	 */
	EClass getGetWorkspaceLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace <em>Find In Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Find In Workspace</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace
	 * @generated
	 */
	EClass getFindInWorkspace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace#getPath()
	 * @see #getFindInWorkspace()
	 * @generated
	 */
	EAttribute getFindInWorkspace_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace#isAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.FindInWorkspace#isAll()
	 * @see #getFindInWorkspace()
	 * @generated
	 */
	EAttribute getFindInWorkspace_All();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.GetStatusMessage <em>Get Status Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Status Message</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetStatusMessage
	 * @generated
	 */
	EClass getGetStatusMessage();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.platform.commands.GetStatusMessage#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Status</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetStatusMessage#getStatus()
	 * @see #getGetStatusMessage()
	 * @generated
	 */
	EReference getGetStatusMessage_Status();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.commands.GetStatusTrace <em>Get Status Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Status Trace</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetStatusTrace
	 * @generated
	 */
	EClass getGetStatusTrace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.platform.commands.GetStatusTrace#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Status</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.commands.GetStatusTrace#getStatus()
	 * @see #getGetStatusTrace()
	 * @generated
	 */
	EReference getGetStatusTrace_Status();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandsFactory getCommandsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListPluginsImpl <em>List Plugins</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListPluginsImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListPlugins()
		 * @generated
		 */
		EClass LIST_PLUGINS = eINSTANCE.getListPlugins();

		/**
		 * The meta object literal for the '<em><b>Include Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST_PLUGINS__INCLUDE_DEPENDENCIES = eINSTANCE.getListPlugins_IncludeDependencies();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListFeaturesImpl <em>List Features</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListFeaturesImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListFeatures()
		 * @generated
		 */
		EClass LIST_FEATURES = eINSTANCE.getListFeatures();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListRepositoriesImpl <em>List Repositories</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListRepositoriesImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListRepositories()
		 * @generated
		 */
		EClass LIST_REPOSITORIES = eINSTANCE.getListRepositories();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.AddRepositoryImpl <em>Add Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.AddRepositoryImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getAddRepository()
		 * @generated
		 */
		EClass ADD_REPOSITORY = eINSTANCE.getAddRepository();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_REPOSITORY__URI = eINSTANCE.getAddRepository_Uri();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_REPOSITORY__NAME = eINSTANCE.getAddRepository_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.RemoveRepositoryImpl <em>Remove Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.RemoveRepositoryImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getRemoveRepository()
		 * @generated
		 */
		EClass REMOVE_REPOSITORY = eINSTANCE.getRemoveRepository();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOVE_REPOSITORY__URI = eINSTANCE.getRemoveRepository_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.UpdateFeatureImpl <em>Update Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.UpdateFeatureImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getUpdateFeature()
		 * @generated
		 */
		EClass UPDATE_FEATURE = eINSTANCE.getUpdateFeature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_FEATURE__ID = eINSTANCE.getUpdateFeature_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.UpdateAllImpl <em>Update All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.UpdateAllImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getUpdateAll()
		 * @generated
		 */
		EClass UPDATE_ALL = eINSTANCE.getUpdateAll();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.SortByImpl <em>Sort By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.SortByImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getSortBy()
		 * @generated
		 */
		EClass SORT_BY = eINSTANCE.getSortBy();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT_BY__FIELD = eINSTANCE.getSortBy_Field();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListInstallUnitsImpl <em>List Install Units</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListInstallUnitsImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListInstallUnits()
		 * @generated
		 */
		EClass LIST_INSTALL_UNITS = eINSTANCE.getListInstallUnits();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetLogImpl <em>Get Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetLogImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetLog()
		 * @generated
		 */
		EClass GET_LOG = eINSTANCE.getGetLog();

		/**
		 * The meta object literal for the '<em><b>Levels</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_LOG__LEVELS = eINSTANCE.getGetLog_Levels();

		/**
		 * The meta object literal for the '<em><b>Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_LOG__LIMIT = eINSTANCE.getGetLog_Limit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.LogImpl <em>Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.LogImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getLog()
		 * @generated
		 */
		EClass LOG = eINSTANCE.getLog();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG__MESSAGE = eINSTANCE.getLog_Message();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG__SEVERITY = eINSTANCE.getLog_Severity();

		/**
		 * The meta object literal for the '<em><b>Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG__PLUGIN = eINSTANCE.getLog_Plugin();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.EchoImpl <em>Echo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.EchoImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getEcho()
		 * @generated
		 */
		EClass ECHO = eINSTANCE.getEcho();

		/**
		 * The meta object literal for the '<em><b>Str</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECHO__STR = eINSTANCE.getEcho_Str();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ClearLogImpl <em>Clear Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ClearLogImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getClearLog()
		 * @generated
		 */
		EClass CLEAR_LOG = eINSTANCE.getClearLog();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.ListLaunchConfigurationsImpl <em>List Launch Configurations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.ListLaunchConfigurationsImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getListLaunchConfigurations()
		 * @generated
		 */
		EClass LIST_LAUNCH_CONFIGURATIONS = eINSTANCE.getListLaunchConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.LaunchImpl <em>Launch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.LaunchImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getLaunch()
		 * @generated
		 */
		EClass LAUNCH = eINSTANCE.getLaunch();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH__MODE = eINSTANCE.getLaunch_Mode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH__NAME = eINSTANCE.getLaunch_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.SubstituteVariablesImpl <em>Substitute Variables</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.SubstituteVariablesImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getSubstituteVariables()
		 * @generated
		 */
		EClass SUBSTITUTE_VARIABLES = eINSTANCE.getSubstituteVariables();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTITUTE_VARIABLES__EXPRESSION = eINSTANCE.getSubstituteVariables_Expression();

		/**
		 * The meta object literal for the '<em><b>Ignore Undefined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTITUTE_VARIABLES__IGNORE_UNDEFINED = eINSTANCE.getSubstituteVariables_IgnoreUndefined();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetWorkspaceLocationImpl <em>Get Workspace Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetWorkspaceLocationImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetWorkspaceLocation()
		 * @generated
		 */
		EClass GET_WORKSPACE_LOCATION = eINSTANCE.getGetWorkspaceLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.FindInWorkspaceImpl <em>Find In Workspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.FindInWorkspaceImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getFindInWorkspace()
		 * @generated
		 */
		EClass FIND_IN_WORKSPACE = eINSTANCE.getFindInWorkspace();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIND_IN_WORKSPACE__PATH = eINSTANCE.getFindInWorkspace_Path();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIND_IN_WORKSPACE__ALL = eINSTANCE.getFindInWorkspace_All();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusMessageImpl <em>Get Status Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusMessageImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetStatusMessage()
		 * @generated
		 */
		EClass GET_STATUS_MESSAGE = eINSTANCE.getGetStatusMessage();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_STATUS_MESSAGE__STATUS = eINSTANCE.getGetStatusMessage_Status();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusTraceImpl <em>Get Status Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.GetStatusTraceImpl
		 * @see org.eclipse.rcptt.ecl.platform.commands.impl.CommandsPackageImpl#getGetStatusTrace()
		 * @generated
		 */
		EClass GET_STATUS_TRACE = eINSTANCE.getGetStatusTrace();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_STATUS_TRACE__STATUS = eINSTANCE.getGetStatusTrace_Status();

	}

} //CommandsPackage
