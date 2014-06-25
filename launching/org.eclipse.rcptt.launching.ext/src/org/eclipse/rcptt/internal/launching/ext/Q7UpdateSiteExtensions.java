/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.launching.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class Q7UpdateSiteExtensions {
	private static Q7UpdateSiteExtensions instance;

	public static class Q7RuntimeInfo {
		public String kind;
		public String path;
		public String bundle;

		@Override
		public String toString() {
			return bundle;
		}
	}

	private Map<String, List<Q7RuntimeInfo>> versionToBundles = new HashMap<String, List<Q7RuntimeInfo>>();

	public Q7UpdateSiteExtensions() {
		inializeProcessors();
	}

	private void inializeProcessors() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						Q7ExtLaunchingPlugin.PLUGIN_ID + ".q7runtime");
		for (IConfigurationElement config : configurationElements) {
			String version = config.getAttribute("version");
			IContributor contributor = config.getContributor();
			Q7RuntimeInfo info = new Q7RuntimeInfo();
			info.bundle = contributor.getName();
			info.kind = config.getAttribute("kind");
			info.path = config.getAttribute("path");
			if (info.path == null) {
				Q7ExtLaunchingPlugin
						.getDefault()
						.log("Plugin "
								+ info.bundle
								+ " provides incorrect q7runtime extension point",
								null);
			}
			if (!versionToBundles.containsKey(version)) {
				versionToBundles.put(version,
						new ArrayList<Q7UpdateSiteExtensions.Q7RuntimeInfo>());
			}
			List<Q7RuntimeInfo> list = versionToBundles.get(version);
			list.add(info);
		}
	}

	public synchronized static Q7UpdateSiteExtensions getDefault() {
		if (instance == null) {
			instance = new Q7UpdateSiteExtensions();
		}
		return instance;
	}

	public List<Q7RuntimeInfo> getRuntimes(String version) {
		List<Q7RuntimeInfo> result = new ArrayList<Q7UpdateSiteExtensions.Q7RuntimeInfo>();
		Set<String> keySet = versionToBundles.keySet();
		Version versionValue = Version.create(version);
		for (String key : keySet) {
			if (key.equals(version)) {
				result.addAll(versionToBundles.get(key));
			} else {
				try {
					VersionRange range = new VersionRange(key);
					if (range.isIncluded(versionValue)) {
						result.addAll(versionToBundles.get(key));
					}
				} catch (IllegalArgumentException e) {
					RcpttPlugin.log(e);
				}
			}
		}
		return result;
	}
	
	public Map<String, List<Q7RuntimeInfo>> getAllKnownVersions() {
		return versionToBundles; 
	}
}
