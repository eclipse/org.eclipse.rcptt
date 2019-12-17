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
package org.eclipse.rcptt.ecl.debug.commands;


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
 * @see org.eclipse.rcptt.ecl.debug.commands.CommandsFactory
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
	String eNS_URI = "http://www.eclipse.org/debug/runtime/commands.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.debug.runtime.commands";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsPackage eINSTANCE = org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.StartServerImpl <em>Start Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.StartServerImpl
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getStartServer()
	 * @generated
	 */
	int START_SERVER = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_SERVER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_SERVER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_SERVER__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_SERVER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.StopServerImpl <em>Stop Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.StopServerImpl
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getStopServer()
	 * @generated
	 */
	int STOP_SERVER = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_SERVER__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_SERVER__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_SERVER__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stop Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_SERVER_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.ServerInfoImpl <em>Server Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.ServerInfoImpl
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getServerInfo()
	 * @generated
	 */
	int SERVER_INFO = 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__PORT = 0;

	/**
	 * The number of structural features of the '<em>Server Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugScriptImpl <em>Debug Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.DebugScriptImpl
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getDebugScript()
	 * @generated
	 */
	int DEBUG_SCRIPT = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT__HOST = CorePackage.SCRIPT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT__BINDINGS = CorePackage.SCRIPT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT__CONTENT = CorePackage.SCRIPT__CONTENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT__PATH = CorePackage.SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT__SESSION = CorePackage.SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT__PATHS = CorePackage.SCRIPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Debug Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_SCRIPT_FEATURE_COUNT = CorePackage.SCRIPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl <em>Debug Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getDebugCommand()
	 * @generated
	 */
	int DEBUG_COMMAND = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND__PATH = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND__SESSION = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND__COMMAND = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND__PATHS = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Debug Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_COMMAND_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.PathsMapImpl <em>Paths Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.PathsMapImpl
	 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getPathsMap()
	 * @generated
	 */
	int PATHS_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Paths Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS_MAP_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.commands.StartServer <em>Start Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Server</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.StartServer
	 * @generated
	 */
	EClass getStartServer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.StartServer#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.StartServer#getId()
	 * @see #getStartServer()
	 * @generated
	 */
	EAttribute getStartServer_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.commands.StopServer <em>Stop Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Server</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.StopServer
	 * @generated
	 */
	EClass getStopServer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.StopServer#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.StopServer#getId()
	 * @see #getStopServer()
	 * @generated
	 */
	EAttribute getStopServer_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.commands.ServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Info</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.ServerInfo
	 * @generated
	 */
	EClass getServerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.ServerInfo#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.ServerInfo#getPort()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.commands.DebugScript <em>Debug Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Script</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugScript
	 * @generated
	 */
	EClass getDebugScript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.DebugScript#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugScript#getPath()
	 * @see #getDebugScript()
	 * @generated
	 */
	EAttribute getDebugScript_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.DebugScript#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugScript#getSession()
	 * @see #getDebugScript()
	 * @generated
	 */
	EAttribute getDebugScript_Session();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.ecl.debug.commands.DebugScript#getPaths <em>Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Paths</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugScript#getPaths()
	 * @see #getDebugScript()
	 * @generated
	 */
	EReference getDebugScript_Paths();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand <em>Debug Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Command</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugCommand
	 * @generated
	 */
	EClass getDebugCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPath()
	 * @see #getDebugCommand()
	 * @generated
	 */
	EAttribute getDebugCommand_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getSession()
	 * @see #getDebugCommand()
	 * @generated
	 */
	EAttribute getDebugCommand_Session();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getCommand()
	 * @see #getDebugCommand()
	 * @generated
	 */
	EReference getDebugCommand_Command();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPaths <em>Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Paths</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.commands.DebugCommand#getPaths()
	 * @see #getDebugCommand()
	 * @generated
	 */
	EReference getDebugCommand_Paths();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Paths Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paths Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getPathsMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPathsMap()
	 * @generated
	 */
	EAttribute getPathsMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPathsMap()
	 * @generated
	 */
	EAttribute getPathsMap_Value();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.StartServerImpl <em>Start Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.StartServerImpl
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getStartServer()
		 * @generated
		 */
		EClass START_SERVER = eINSTANCE.getStartServer();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute START_SERVER__ID = eINSTANCE.getStartServer_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.StopServerImpl <em>Stop Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.StopServerImpl
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getStopServer()
		 * @generated
		 */
		EClass STOP_SERVER = eINSTANCE.getStopServer();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_SERVER__ID = eINSTANCE.getStopServer_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.ServerInfoImpl <em>Server Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.ServerInfoImpl
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getServerInfo()
		 * @generated
		 */
		EClass SERVER_INFO = eINSTANCE.getServerInfo();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__PORT = eINSTANCE.getServerInfo_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugScriptImpl <em>Debug Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.DebugScriptImpl
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getDebugScript()
		 * @generated
		 */
		EClass DEBUG_SCRIPT = eINSTANCE.getDebugScript();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_SCRIPT__PATH = eINSTANCE.getDebugScript_Path();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_SCRIPT__SESSION = eINSTANCE.getDebugScript_Session();

		/**
		 * The meta object literal for the '<em><b>Paths</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_SCRIPT__PATHS = eINSTANCE.getDebugScript_Paths();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl <em>Debug Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getDebugCommand()
		 * @generated
		 */
		EClass DEBUG_COMMAND = eINSTANCE.getDebugCommand();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_COMMAND__PATH = eINSTANCE.getDebugCommand_Path();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_COMMAND__SESSION = eINSTANCE.getDebugCommand_Session();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_COMMAND__COMMAND = eINSTANCE.getDebugCommand_Command();

		/**
		 * The meta object literal for the '<em><b>Paths</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_COMMAND__PATHS = eINSTANCE.getDebugCommand_Paths();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.commands.impl.PathsMapImpl <em>Paths Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.PathsMapImpl
		 * @see org.eclipse.rcptt.ecl.debug.commands.impl.CommandsPackageImpl#getPathsMap()
		 * @generated
		 */
		EClass PATHS_MAP = eINSTANCE.getPathsMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATHS_MAP__KEY = eINSTANCE.getPathsMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATHS_MAP__VALUE = eINSTANCE.getPathsMap_Value();

	}

} //CommandsPackage
