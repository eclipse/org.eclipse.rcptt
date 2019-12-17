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
package org.eclipse.rcptt.internal.launching.aut;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.pde.core.plugin.IPluginModelBase;

public class LaunchInfoCache {
	public static class CachedInfo {
		public Map<String, Object> fAllBundles;

		public Map<Object, String> fModels;

		public Object target;

		public String[] programArgs;

		public String[] vmArgs;

		/**
		 * II: Arbitrary associated data, couldn't save {@link Map}&lt;
		 * {@link IPluginModelBase}, BundleStart&gt; directly due to
		 * dependencies
		 * 
		 */
		public Map<String, Object> data = new HashMap<String, Object>();
	}

	private static Map<ILaunchConfiguration, CachedInfo> infoCache = new HashMap<ILaunchConfiguration, CachedInfo>();

	public static synchronized CachedInfo getInfo(ILaunchConfiguration configuration) {
		CachedInfo info = infoCache.get(configuration);
		if (info == null) {
			info = new CachedInfo();
			infoCache.put(configuration, info);
		}
		return info;
	}

	public static synchronized void copyCache(ILaunchConfiguration launchConfiguration,
			ILaunchConfigurationWorkingCopy copy) {
		CachedInfo info = infoCache.get(launchConfiguration);
		if (info != null) {
			infoCache.put(copy, info);
		}
	}

	public static synchronized void remove(ILaunchConfiguration launchConfiguration) {
		infoCache.remove(launchConfiguration);
	}
}
