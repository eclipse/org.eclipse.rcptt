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
package org.eclipse.rcptt.sherlock.core.info;

import java.io.File;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IBundleGroup;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.service.prefs.Preferences;

import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable;

public final class Info {
	public static SystemInfo getSystem() {
		final SystemInfo info = SherlockFactory.eINSTANCE.createSystemInfo();
		info.setOsName(SystemInfoProvider.getOSName());
		info.setOsArch(SystemInfoProvider.getOSArch());
		info.setOsVersion(SystemInfoProvider.getOSVersion());
		info.setUsername(SystemInfoProvider.getUsername());

		final List<SystemVariable> vars = info.getVariables();
		for (Map.Entry<String, String> entry : SystemInfoProvider
				.getVariables().entrySet()) {
			final SystemVariable var = SherlockFactory.eINSTANCE
					.createSystemVariable();
			var.setName(entry.getKey());
			var.setValue(entry.getValue());
			vars.add(var);
		}

		return info;
	}

	public static JavaInfo getJava() {
		final JavaInfo info = SherlockFactory.eINSTANCE.createJavaInfo();
		info.setRuntimeName(JavaInfoProvider.getRuntimeName());
		info.setRuntimeVersion(JavaInfoProvider.getRuntimeVersion());
		info.setFreeMemory(JavaInfoProvider.getFreeMemory());
		info.setMaxMemory(JavaInfoProvider.getMaxMemory());
		info.setTotalMemory(JavaInfoProvider.getTotalMemory());

		final List<JavaProperty> props = info.getProperties();
		for (Map.Entry<String, String> entry : JavaInfoProvider.getProperties()
				.entrySet()) {
			final JavaProperty prop = SherlockFactory.eINSTANCE
					.createJavaProperty();
			prop.setName(entry.getKey());
			prop.setValue(entry.getValue());
			props.add(prop);
		}

		return info;
	}

	public static EclipseInfo getEclipse() {
		return getEclipse(EclipseInfoProvider.getFeatures());
	}

	public static EclipseInfo getEclipse(List<IBundleGroup> features) {
		final EclipseInfo info = SherlockFactory.eINSTANCE.createEclipseInfo();

		info.setBuildId(EclipseInfoProvider.getBuildId());
		String workspace = EclipseInfoProvider.getWorkspaceLocation();
		info.setWorkspaceLocation(workspace);

		if (workspace != null) {
			try {
				File workspaceDir = new File(workspace);
				info.setWorkspacePartitionTotalDiskspace(workspaceDir
						.getTotalSpace());
				info.setWorkspacePartitionUsableDiskspace(workspaceDir
						.getUsableSpace());
				info.setWorkspacePartitionFreeDiskspace(workspaceDir
						.getFreeSpace());
			} catch (Throwable t) {
			}
		}

		info.setUptime(EclipseInfoProvider.getUptime());
		info.setProductId(EclipseInfoProvider.getProductId());
		info.setApplicationId(EclipseInfoProvider.getApplicationId());
		info.getApplicationArgs().addAll(
				Arrays.asList(EclipseInfoProvider.getApplicationArgs()));

		for (IBundleGroup group : features) {
			final EclipseFeature feature = SherlockFactory.eINSTANCE
					.createEclipseFeature();
			feature.setId(group.getIdentifier());
			feature.setVersion(group.getVersion());
			feature.setProvider(group.getProviderName());
			feature.setName(group.getName());

			info.getFeatures().add(feature);
		}

		for (Bundle bundle : EclipseInfoProvider.getPlugins()) {
			final Dictionary<String, String> headers = bundle.getHeaders();

			final EclipsePlugin plugin = SherlockFactory.eINSTANCE
					.createEclipsePlugin();
			plugin.setName(headers.get(Constants.BUNDLE_NAME));
			plugin.setProvider(headers.get(Constants.BUNDLE_VENDOR));
			plugin.setId(bundle.getSymbolicName());
			plugin.setVersion(headers.get(Constants.BUNDLE_VERSION));

			info.getPlugins().add(plugin);
		}

		List<Preferences> unprocessed = new LinkedList<Preferences>();
		unprocessed.add(EclipseInfoProvider.getPreferencesRoot());

		try {
			while (unprocessed.size() > 0) {
				Preferences p = unprocessed.get(0);
				unprocessed.remove(0);

				String absolutePath = p.absolutePath();
				for (String childName : p.childrenNames()) {
					unprocessed.add(0, p.node(childName));
				}
				for (String key : p.keys()) {
					final EclipsePreference pref = SherlockFactory.eINSTANCE
							.createEclipsePreference();
					pref.setName(key);
					pref.setValue(p.get(key, ""));
					pref.setPath(absolutePath);
					info.getPreferences().add(pref);
				}
			}
		} catch (Throwable t) {
		}

		return info;
	}

	private Info() {

	}
}
