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
package org.eclipse.rcptt.launching;

import org.eclipse.rcptt.ecl.client.tcp.EclTcpClientManager;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;

public interface IQ7Launch {

	public final static int TESLA_DEFAULT_PORT = 7926;
	public final static int ECL_DEFAULT_PORT = EclTcpClientManager.DEFAULT_PORT;
	public static final String DEFAULT_HOST = "localhost";
	public static final String DEFAULT_CAPABILITY = "other";
	public static final String DEFAULT_PLATFORM = "other";
	public static final String ATTR_HEADLESS_LAUNCH = "q7.headless.launch";
	public static final String ATTR_ALLOWED_BUNDLES = "q7.allowed.bunldels";

	public static final String EXEC_RESOURCES = "q7.exec.resources";
	public static final String ATTR_CAPTURE_IN_FILE = "org.eclipse.debug.ui.ATTR_CAPTURE_IN_FILE";
	public static final String ATTR_APPEND_TO_FILE = "org.eclipse.debug.ui.ATTR_APPEND_TO_FILE";
	public static final String ATTR_VARIANTS = "q7.context.variants";
	public static final String VARIANTS_SEPARATOR = "%$%${q7.variants}";
	public static final String VARIANT_NAME_SEPARATOR = "%$%${q7.variantname}";
	/**
	 * Launch configuration type identifier
	 */
	String ID_TYPE = Q7LaunchingPlugin.PLUGIN_ID + ".scenarios";

	String ATTR_LOCATION = Q7LaunchingPlugin.PLUGIN_ID + ".location";

	String ATTR_WORKING_DIRECTORY = Q7LaunchingPlugin.PLUGIN_ID
			+ ".workingDirectory";

	String ATTR_JAVA = Q7LaunchingPlugin.PLUGIN_ID + ".java";

	/**
	 * Launch configuration attribute key. The value is a string specifying the
	 * user-entered bootstrap classpath entries.
	 */
	String BOOTSTRAP_ENTRIES = "bootstrap"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a string specifying
	 * workspace data location for an Eclipse application.
	 */
	String LOCATION = "location"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a boolean specifying
	 * workspace data location for an Eclipse application should be cleared
	 * prior to launching.
	 */
	String DOCLEAR = "clearws"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a boolean specifying
	 * whether the user should be prompted prior to clearing the workspace.
	 *
	 * @see IQ7Launch#DOCLEAR
	 */
	String ASKCLEAR = "askclear"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a boolean specifying
	 * whether the workspace log for an Eclipse application should be cleared
	 * prior to launching.
	 */
	String DOCLEARLOG = "clearwslog"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a name of a Q7 project
	 * associated with a Q7 launch configuration.
	 */
	String ATTR_PROJECT_NAME = Q7LaunchingPlugin.PLUGIN_ID + ".PROJECT_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a boolean specifying
	 * whether the list of plug-ins to run should be validate prior to
	 * launching. If problems are found, they will be reported and the user will
	 * be able to cancel or continue. If no problems are found, the launch
	 * continues as normal.
	 */
	String AUTOMATIC_VALIDATE = "automaticValidate"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a name of a Q7 project
	 * associated with a Q7 launch configuration.
	 */
	String ATTR_SCENARIO_PROJECT_NAME = Q7LaunchingPlugin.PLUGIN_ID
			+ ".SCENARIO_PROJECT_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a scenario name to
	 * launch.
	 */
	String ATTR_SCENARIO_ID = Q7LaunchingPlugin.PLUGIN_ID + ".SCENARIO_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a name of a Q7 project
	 * associated with a Q7 launch configuration.
	 */
	String ATTR_CONTEXT_PROJECT_NAME = Q7LaunchingPlugin.PLUGIN_ID
			+ ".CONTEXT_PROJECT_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value indicate whether contexts
	 * should be included to this configuration.
	 */
	String ATTR_INCLUDE_CONTEXT = Q7LaunchingPlugin.PLUGIN_ID
			+ ".INCLUDE_CONTEXT_ATTR"; //$NON-NLS-1$

	String ATTR_NO_SORT = Q7LaunchingPlugin.PLUGIN_ID + ".NO_SORT";
	/**
	 * Launch configuration attribute key. The value is a context name to
	 * launch.
	 */
	String ATTR_CONTEXT_ID = Q7LaunchingPlugin.PLUGIN_ID + ".CONTEXT_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. ECL port number to use. Applies to
	 * both SUT & scenario configurations.
	 */
	String ATTR_ECL_PORT = Q7LaunchingPlugin.PLUGIN_ID + ".ECL_PORT_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Unique AUT launch identifier.
	 */
	String ATTR_AUT_ID = Q7LaunchingPlugin.PLUGIN_ID + ".ATTR_AUT_LAUNCH_ID"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Unique AUT identifier.
	 */
	String ATTR_AUT_NAME = Q7LaunchingPlugin.PLUGIN_ID + ".AUT_NAME_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Unique AUT identifier.
	 */
	String ATTR_BOUND_AUT_NAME = Q7LaunchingPlugin.PLUGIN_ID + ".BOUND_AUT_NAME_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a Map with Test Engine name and Enabled status.
	 */
	String ATTR_TEST_ENGINES = Q7LaunchingPlugin.PLUGIN_ID + ".ATTR_TEST_ENGINES"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Host name for connec to. Applies to
	 * both SUT & scenario configurations.
	 */
	String ATTR_HOST = Q7LaunchingPlugin.PLUGIN_ID + ".HOST"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Tesla port number to use. Applies to
	 * both SUT & scenario configurations.
	 */
	String ATTR_TESLA_PORT = Q7LaunchingPlugin.PLUGIN_ID + ".TESLA_PORT_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Aut platform values: "windows", "linux", "macos", "other".
	 */
	String ATTR_AUT_PLATFORM = Q7LaunchingPlugin.PLUGIN_ID + ".AUT_PLATFORM_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Aut capability values: "e3", "e4", "rap", "other".
	 */
	String ATTR_AUT_CAPABILITY = Q7LaunchingPlugin.PLUGIN_ID + ".AUT_CAPABILITY_ATTR"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. Absolute location of file to append
	 * AUT output and error streams.
	 */
	String ATTR_OUT_FILE = Q7LaunchingPlugin.PLUGIN_ID + ".outFile";
	/**
	 * Launch configuration attribute key. The value is a string specifying
	 * location of an Eclipse application.
	 */
	String AUT_LOCATION = "aut-location"; //$NON-NLS-1$

	/**
	 * Launch configuration attribute key. The value is a string specifying
	 * associated platform.
	 */
	String TARGET_PLATFORM = "aut-target-platform"; //$NON-NLS-1$

	/**
	 * Do not try to create target one more time
	 */
	String UPDATE_TARGET_SUPPORTED = "aut-target-updatable";//$NON-NLS-1$
	/*
	 * Do not override secure storage argument.
	 */
	String OVERRIDE_SECURE_STORAGE = "override-secure-storage";//$NON-NLS-1$

	/**
	 * Identifier prefix for all Q7 launch configurations.
	 *
	 * This prefix is used in AUT manager to locate correct launch
	 * configurations.
	 */
	String ID_PREFIX = "org.eclipse.rcptt.launching.";
}
