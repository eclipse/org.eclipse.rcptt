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
package org.eclipse.rcptt.launching.autdetails;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.osgi.framework.Version;

import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.IQ7Launch;

@SuppressWarnings("restriction")
public class AutDetailsCollector {
	private IStringVariableManager mgr = VariablesPlugin.getDefault()
			.getStringVariableManager();

	public void collectInformation(Aut aut, IAutDetailsProcessor processor) {
		ILaunchConfiguration configuration = aut.getConfig();

		try {
			collectEclipseInfo(processor, configuration);

			collectBundlesInfo(processor, configuration);

			collectMetadataLog(processor, configuration);

			collectConsoleLog(processor, configuration);

			collectBundlesInfoRuntime(processor, configuration);

			collectConfigIniRuntime(processor, configuration);

			collectQ7Properties(processor);

			collectPlatformInfo(processor);

			Properties configuration_props = mapToProperties(configuration
					.getAttributes());
			processor.addFile("configuration.properties", configuration_props);

			processor.closeStream();
		} catch (Exception e) {
			Q7LaunchingPlugin.log(e);
		}
	}

	private void collectConfigIniRuntime(IAutDetailsProcessor processor,
			ILaunchConfiguration configuration) throws FileNotFoundException {

		File bundles_info_file = new Path(org.eclipse.pde.internal.launching.launcher.LaunchConfigurationHelper
				.getConfigurationArea(configuration).getAbsolutePath()).append(
				"config.ini").toFile();

		passFile("config_ini_runtime.ini", bundles_info_file, processor);
	}

	private void collectBundlesInfoRuntime(IAutDetailsProcessor processor,
			ILaunchConfiguration configuration) throws FileNotFoundException {

		File bundles_info_file = new Path(org.eclipse.pde.internal.launching.launcher.LaunchConfigurationHelper
				.getConfigurationArea(configuration).getAbsolutePath()).append(
				"org.eclipse.equinox.simpleconfigurator").append("bundles.info").toFile();

		passFile("bundles_info_runtime.info", bundles_info_file, processor);
	}

	private void collectQ7Properties(IAutDetailsProcessor processor) {
		Properties q7props = new Properties();

		Version runtimeBundle = Platform.getBundle(
				"org.eclipse.rcptt.updates.runtime").getVersion();
		q7props.put("runtime.version", runtimeBundle.toString());
		processor.addFile("Q7 version.properties", q7props);
	}

	private void collectPlatformInfo(IAutDetailsProcessor processor) {
		Properties platform_info = new Properties();
		platform_info.put("os.arch", System.getProperty("os.arch"));
		platform_info.put("os.name", System.getProperty("os.name"));
		platform_info.put("os.version", System.getProperty("os.version"));
		platform_info.put("java.runtime.name",
				System.getProperty("java.runtime.name"));
		platform_info.put("java.runtime.version",
				System.getProperty("java.runtime.version"));
		processor.addFile("platform.properties", platform_info);
	}

	private void collectConsoleLog(IAutDetailsProcessor processor,
			ILaunchConfiguration configuration) throws CoreException,
			FileNotFoundException {
		File console_log_file = new Path(configuration.getAttribute(
				IQ7Launch.ATTR_CAPTURE_IN_FILE, "")).toFile();
		passFile("console.log", console_log_file, processor);
	}

	private void collectMetadataLog(IAutDetailsProcessor processor,
			ILaunchConfiguration configuration) throws CoreException,
			FileNotFoundException {
		File metadata_log_file = new Path(
				org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper.getWorkspaceLocation(configuration))
				.append(".metadata").append(".log").toFile();
		passFile("metadata.log", metadata_log_file, processor);
	}

	private void collectBundlesInfo(IAutDetailsProcessor processor,
			ILaunchConfiguration configuration) throws CoreException,
			FileNotFoundException {

		File bundles_info_file = new Path(configuration.getAttribute(
				IQ7Launch.AUT_LOCATION, "")).append("configuration")
				.append("org.eclipse.equinox.simpleconfigurator")
				.append("bundles.info").toFile();
		passFile("bundles.info", bundles_info_file, processor);
	}

	private void collectEclipseInfo(IAutDetailsProcessor processor,
			ILaunchConfiguration configuration) throws CoreException,
			FileNotFoundException {

		File eclipse_ini_file = new Path(configuration.getAttribute(
				IQ7Launch.AUT_LOCATION, "")).append("eclipse.ini").toFile();
		passFile("eclipse.ini", eclipse_ini_file, processor);
	}

	private void passFile(String file_name, File file,
			IAutDetailsProcessor processor) throws FileNotFoundException {
		if (file.exists()) {
			processor.addFile(file_name, new BufferedInputStream(
					new FileInputStream(file)));
		}
	}

	@SuppressWarnings("rawtypes")
	private Properties mapToProperties(Map map) {
		Properties p = new Properties();
		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Entry) it.next();
			String value = entry.getValue().toString();
			String substituted = "";

			try {
				substituted = mgr.performStringSubstitution(value);
			} catch (CoreException e) {
			}

			if (!value.equals(substituted)) {
				p.put(entry.getKey() + "_substituted", substituted);
			}

			p.put(entry.getKey(), value);
		}
		return p;
	}
}
