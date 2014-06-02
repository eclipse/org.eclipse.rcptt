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
package org.eclipse.rcptt.launching.ext;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.equinox.frameworkadmin.BundleInfo;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.core.target.provisional.IResolvedBundle;
import org.eclipse.pde.internal.core.util.VersionUtil;
import org.osgi.framework.Version;

import org.eclipse.rcptt.launching.internal.target.TargetPlatformHelper;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;

@SuppressWarnings("restriction")
public class AUTInformation {
	public static final String VERSION = "Version";
	public static final String EMF_WORKSPACE = "EMF Workspace";
	public static final String EMF_TRANSACTION = "EMF Transaction";
	public static final String EMF_VALIDATION = "EMF Validation";
	public static final String PDE = "PDE";
	public static final String EMF = "EMF";
	public static final String GMF = "GMF";
	public static final String GEF = "GEF";
	public static final String JDT = "JDT";
	public static final String PLATFORM = "Platform";

	private static final String EMF_WORKSPACE_PLUGIN = "org.eclipse.emf.workspace";
	private static final String TESLA_PLUGIN = "org.eclipse.rcptt.tesla";
	private static final String Q7_PLUGIN = "org.eclipse.rcptt";
	private static final String PDE_PLUGIN = "org.eclipse.pde";
	private static final String EMF_VALIDATION_PLUGIN = "org.eclipse.emf.validation";
	private static final String EMF_TRANSACTION_PLUGIN = "org.eclipse.emf.transaction";
	private static final String EMF_FEATURE = "org.eclipse.emf";
	private static final String GMF_PLUGIN = "org.eclipse.gmf";
	private static final String GMF2_PLUGIN = "org.eclipse.gmf.runtime.diagram.ui";
	private static final String GEF_PLUGIN = "org.eclipse.gef";
	private static final String JDT_PLUGIN = "org.eclipse.jdt";

	/**
	 * Return information properties map. Constants could be used to check
	 * plugin versions available.
	 * 
	 * @return
	 */
	public static Map<String, String> getInformationMap(
			ITargetPlatformHelper platform) {
		TargetPlatformHelper target = (TargetPlatformHelper) platform;
		Map<String, String> values = new TreeMap<String, String>();
		if (!platform.isValid()) {
			return values;
		}
		// Obtain some information values based on target definition
		if (target.getBundleContainers().length > 0) {
			// Calculate target platform version
			IResolvedBundle[] allBundles = target.getAllBundles();
			Map<String, BundleInfo > resolvedBundles = new HashMap<String, BundleInfo>();
			
			for (IResolvedBundle bundle : allBundles) {
				BundleInfo bundleInfo = bundle.getBundleInfo();
				String bundleName = bundleInfo.getSymbolicName();
				resolvedBundles.put(bundleName, bundleInfo);
				if (bundleName.equals("org.eclipse.swt")) {
					String version = bundleInfo.getVersion();
					if (VersionUtil.validateVersion(version).getSeverity() == IStatus.OK) {
						Version vid = new Version(version);
						putVersion(values, vid.getMajor(), vid.getMinor());
					}
					break;
				}
				if (bundleName.equals(GEF_PLUGIN)) {
					values.put(GEF, bundle.getBundleInfo().getVersion());
				}
				if (bundleName.equals(GMF2_PLUGIN)) {
					values.put(GMF, bundle.getBundleInfo().getVersion());
				}
			}
			// Correct version based on OSGiv version for Eclipse 4.4x
			BundleInfo osgiBundle = resolvedBundles.get("org.eclipse.osgi");
			if( osgiBundle != null) {
				String version = osgiBundle.getVersion();
				if (VersionUtil.validateVersion(version).getSeverity() == IStatus.OK) {
					Version vid = new Version(version);
					putVersionOSGI(values, vid.getMajor(), vid.getMinor());
				}
			}
			BundleInfo platformBundle = resolvedBundles.get("org.eclipse.platform");
			if( platformBundle != null) {
				String version = platformBundle.getVersion();
				if (VersionUtil.validateVersion(version).getSeverity() == IStatus.OK) {
					Version vid = new Version(version);
					putVersionPlatform(values, vid.getMajor(), vid.getMinor());
				}
			}
			
			

			IFeatureModel[] features = target.getAllFeatures();
			for (IFeatureModel feature : features) {
				IFeature iFeature = feature.getFeature();
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
				if (iFeature.getId().equals(GMF_PLUGIN)) {
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
				if (iFeature.getId().equals(EMF_WORKSPACE_PLUGIN)) {
					values.put(EMF_WORKSPACE, iFeature.getVersion());
				}
			}
		}
		return values;
	}

	private static void putVersion(Map<String, String> values, int major,
			int minor) {
		if (major == 3 && minor == 0) {
			values.put(VERSION, "3.0");
		} else if (major == 3 && minor == 1) {
			values.put(VERSION, "3.1");
		} else if (major == 3 && minor == 2) {
			values.put(VERSION, "3.2");
		} else if (major == 3 && minor == 3) {
			values.put(VERSION, "3.3");
		} else if (major == 3 && minor == 4) {
			values.put(VERSION, "3.4");
		} else if (major == 3 && minor == 5) {
			values.put(VERSION, "3.5");
		} else if (major == 3 && minor == 6) {
			values.put(VERSION, "3.6");
		} else if (major == 3 && minor == 7) {
			values.put(VERSION, "3.7");
		} else if (major == 3 && minor == 8) {
			values.put(VERSION, "3.8");
		} else if (major == 3 && minor == 100) {
			values.put(VERSION, "4.2");
		} else if (major == 3 && minor == 102) {
			values.put(VERSION, "4.3");
		}
	}
	private static void putVersionOSGI(Map<String, String> values, int major,
			int minor) {
		if (major == 3 && minor == 10) {
			values.put(VERSION, "4.4");
		}
	}
	private static void putVersionPlatform(Map<String, String> values, int major,
			int minor) {
		if (major == 4 && minor == 4) {
			values.put(VERSION, "4.4");
		}
	}
}
