/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.launching.ext;

import static org.eclipse.equinox.p2.metadata.Version.create;
import static org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin.PLUGIN_ID;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.frameworkadmin.BundleInfo;
import org.eclipse.equinox.internal.p2.metadata.OSGiVersion;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.pde.core.target.TargetBundle;
import org.eclipse.pde.core.target.TargetFeature;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.util.VersionUtil;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;

import com.google.common.base.Objects;

@SuppressWarnings("restriction")
public class AUTInformation {
	private static final String OSGI_PLUGIN = "org.eclipse.osgi";
	private static final String SWT_PLUGIN = "org.eclipse.swt";
	public static final String VERSION = "Version";
	public static final String EMF_WORKSPACE = "EMF Workspace";
	public static final String EMF_TRANSACTION = "EMF Transaction";
	public static final String EMF_VALIDATION = "EMF Validation";
	public static final String OSGI = "OSGI";
	public static final String PDE = "PDE";
	public static final String EMF = "EMF";
	public static final String GMF = "GMF";
	public static final String GEF = "GEF";
	public static final String JDT = "JDT";
	public static final String RAP = "RAP";
	public static final String PLATFORM = "Platform";

	private static final String TESLA_PLUGIN = "org.eclipse.rcptt.tesla";
	private static final String Q7_PLUGIN = "org.eclipse.rcptt";
	private static final String PDE_PLUGIN = "org.eclipse.pde";
	private static final String EMF_VALIDATION_PLUGIN = "org.eclipse.emf.validation";
	private static final String EMF_TRANSACTION_PLUGIN = "org.eclipse.emf.transaction";
	private static final String EMF_FEATURE = "org.eclipse.emf";
	private static final String GMF_FEATURE = "org.eclipse.gmf";
	private static final String GMF_PLUGIN = "org.eclipse.gmf.runtime.diagram.ui";
	private static final String GEF_PLUGIN = "org.eclipse.gef";
	private static final String JDT_PLUGIN = "org.eclipse.jdt";
	private static final String RAP_PLUGIN = "org.eclipse.rap.rwt";

	@SuppressWarnings("serial")
	static class VersionMap extends TreeMap<String, Version> {
		public Version put(String key, String value) {
			return super.put(key, create(value));
		}

		public void putPluginVersion(String key, BundleInfo plugin) {
			if (plugin == null)
				return;
			put(key, create(plugin.getVersion()));
		}

		public void putFeatureVersion(String key, IFeature feature) {
			if (feature == null)
				return;
			put(key, create(feature.getVersion()));
		}
	}

	/**
	 * Return information properties map. Constants could be used to check plugin
	 * versions available.
	 *
	 * @return
	 * @throws CoreException
	 */
	public static Map<String, Version> getInformationMap(org.eclipse.pde.core.target.ITargetDefinition platform)
			throws CoreException {
		VersionMap values = new VersionMap();
		MultiStatus warnings = new MultiStatus(PLUGIN_ID, 0,
				"Detected potential problems in target platform " + platform, null);
		if (platform.getTargetLocations().length <= 0)
			throw new CoreException(
					new Status(IStatus.ERROR, PLUGIN_ID, "No containers in target platform " + platform));
		// Calculate target platform version
		TargetBundle[] allBundles = platform.getAllBundles();
		Map<String, BundleInfo> resolvedBundles = new HashMap<String, BundleInfo>();
		for (TargetBundle bundle : allBundles) {
			BundleInfo bundleInfo = bundle.getBundleInfo();
			String bundleName = bundleInfo.getSymbolicName();
			BundleInfo oldValue = resolvedBundles.get(bundleName);
			if (oldValue != null && !Objects.equal(oldValue.getVersion(), bundleInfo.getVersion())) {
				warnings.add(createWarning(
						"Multiple versions of bundle " + oldValue.getLocation() + " and " + bundleInfo.getLocation()));
			}
			resolvedBundles.put(bundleName, bundleInfo);
		}
		BundleInfo bundleInfo = resolvedBundles.get(SWT_PLUGIN);
		if (bundleInfo != null) {
			putSwtVersion(values, create(bundleInfo.getVersion()));
		} else {
			bundleInfo = resolvedBundles.get(RAP_PLUGIN);
			putRwtVersion(values, create(bundleInfo.getVersion()));
			values.putPluginVersion(RAP, bundleInfo);
		}

		values.putPluginVersion(GEF, resolvedBundles.get(GEF_PLUGIN));
		values.putPluginVersion(GMF, resolvedBundles.get(GMF_PLUGIN));
		values.putPluginVersion(OSGI, resolvedBundles.get(OSGI_PLUGIN));
		BundleInfo platformBundle = resolvedBundles.get("org.eclipse.platform");
		if (platformBundle != null) {
			String version = platformBundle.getVersion();
			if (VersionUtil.validateVersion(version).getSeverity() == IStatus.OK) {
				putVersionPlatform(values, create(version));
			}
		}

		TargetFeature[] features = platform.getAllFeatures();
		for (TargetFeature feature : features) {
			TargetFeature iFeature = feature;
			if (iFeature.getId().equals("org.eclipse.platform")) {
				values.put(PLATFORM, iFeature.getVersion());
			}
			if (iFeature.getId().equals(EMF_FEATURE)) {
				values.put(EMF, iFeature.getVersion());
			}
			if (iFeature.getId().equals(JDT_PLUGIN)) {
				values.put(JDT, iFeature.getVersion());
			}
			if (iFeature.getId().equals(GEF_PLUGIN)) {
				values.put(GEF, iFeature.getVersion());
			}
			if (iFeature.getId().equals(GMF_FEATURE)) {
				values.put(GMF, iFeature.getVersion());
			}
			if (iFeature.getId().equals(EMF_TRANSACTION_PLUGIN)) {
				values.put(EMF_TRANSACTION, iFeature.getVersion());
			}
			if (iFeature.getId().equals(EMF_VALIDATION_PLUGIN)) {
				values.put(EMF_VALIDATION, iFeature.getVersion());
			}
			if (iFeature.getId().equals(PDE_PLUGIN)) {
				values.put(PDE, iFeature.getVersion());
			}
			if (iFeature.getId().equals(Q7_PLUGIN)) {
				values.put("Q7", iFeature.getVersion());
			}
			if (iFeature.getId().equals(TESLA_PLUGIN)) {
				values.put("Tesla", iFeature.getVersion());
			}
		}
		if (!warnings.isOK())
			Q7LaunchingPlugin.log(warnings);
		return values;
	}

	private static IStatus createWarning(String string) {
		return new Status(IStatus.WARNING, PLUGIN_ID, string);
	}

	private static void putSwtVersion(VersionMap values, Version swtVersion) {
		if (!(swtVersion instanceof OSGiVersion))
			return;
		int major = ((OSGiVersion) swtVersion).getMajor();
		if (major != 3)
			return;
		int minor = ((OSGiVersion) swtVersion).getMinor();
		if (minor == 0) {
			values.put(VERSION, "3.0");
		} else if (minor == 1) {
			values.put(VERSION, "3.1");
		} else if (minor == 2) {
			values.put(VERSION, "3.2");
		} else if (minor == 3) {
			values.put(VERSION, "3.3");
		} else if (minor == 4) {
			values.put(VERSION, "3.4");
		} else if (minor == 5) {
			values.put(VERSION, "3.5");
		} else if (minor == 6) {
			values.put(VERSION, "3.6");
		} else if (minor == 7) {
			values.put(VERSION, "3.7");
		} else if (minor == 8) {
			values.put(VERSION, "3.8");
		} else if (minor == 100) {
			values.put(VERSION, "4.2");
		} else if (minor == 102) {
			values.put(VERSION, "4.3");
		} else if (minor == 103) {
			values.put(VERSION, "4.4");
		} else if (minor == 104) {
			values.put(VERSION, "4.5");
		} else if (minor == 105) {
			values.put(VERSION, "4.6");
		} else if (minor == 106) {
			values.put(VERSION, "4.7");
		} else if (minor == 107) {
			values.put(VERSION, "4.8");
		}
	}

	private static void putRwtVersion(VersionMap values, Version swtVersion) {
		if (!(swtVersion instanceof OSGiVersion))
			return;
		int major = ((OSGiVersion) swtVersion).getMajor();
		if (major != 3)
			return;
		int minor = ((OSGiVersion) swtVersion).getMinor();
		if (minor <= 5) {
			values.put(VERSION, "4.3");
		}
	}

	private static void putVersionPlatform(VersionMap values, Version version) {
		if (!(version instanceof OSGiVersion))
			return;
		int major = ((OSGiVersion) version).getMajor();
		int minor = ((OSGiVersion) version).getMinor();
		if (major == 4 && minor == 4)
			values.put(VERSION, "4.4");
	}
}
