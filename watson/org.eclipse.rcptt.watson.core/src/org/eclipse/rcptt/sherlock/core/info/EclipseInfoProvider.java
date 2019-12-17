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
package org.eclipse.rcptt.sherlock.core.info;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;

import org.osgi.framework.Bundle;
import org.osgi.service.prefs.Preferences;

import org.eclipse.rcptt.sherlock.core.SherlockCore;

public class EclipseInfoProvider {
	public static String getWorkspaceLocation() {
		try {
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace()
					.getRoot();
			final IPath path = root.getLocation();
			if (path != null) {
				return path.toFile().getAbsolutePath();
			} else {
				final URI uri = root.getLocationURI();
				if (uri != null) {
					return uri.toString();
				}
			}
		} catch (Throwable e) {
			// ignore
		}

		return null;
	}

	public static String getProductId() {
		final IProduct product = Platform.getProduct();
		return product != null ? product.getId() : null;
	}

	public static String getApplicationId() {
		final IProduct product = Platform.getProduct();
		return product != null ? product.getApplication() : null;
	}

	public static String[] getApplicationArgs() {
		return Platform.getApplicationArgs();
	}

	private static final String PROPERTY_ECLIPSE_BUILD_ID = "eclipse.buildId";

	public static String getBuildId() {
		return System.getProperty(PROPERTY_ECLIPSE_BUILD_ID);
	}

	private static final String PROPERTY_ECLIPSE_START_TIME = "eclipse.startTime";

	public static long getUptime() {
		return System.currentTimeMillis()
				- Long.parseLong(System
						.getProperty(PROPERTY_ECLIPSE_START_TIME));
	}

	public static List<Bundle> getPlugins() {
		return Arrays.asList(SherlockCore.getDefault().getBundle()
				.getBundleContext().getBundles());
	}

	public static List<IBundleGroup> getFeatures() {
		final List<IBundleGroup> features = new ArrayList<IBundleGroup>();

		for (IBundleGroupProvider provider : Platform.getBundleGroupProviders()) {
			for (IBundleGroup group : provider.getBundleGroups()) {
				features.add(group);
			}
		}

		return features;
	}

	public static Preferences getPreferencesRoot() {
		IPreferencesService service = Platform.getPreferencesService();
		return service.getRootNode();
	}
}
