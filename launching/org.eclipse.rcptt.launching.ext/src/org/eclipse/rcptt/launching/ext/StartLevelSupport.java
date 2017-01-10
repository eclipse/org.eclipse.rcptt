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

import static org.eclipse.rcptt.launching.ext.Q7LaunchDelegateUtils.id;
import static org.eclipse.rcptt.util.StringUtils.safeToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.build.IPDEBuildConstants;
import org.eclipse.pde.internal.launching.launcher.BundleLauncherHelper;
import org.osgi.framework.BundleException;

import org.eclipse.rcptt.internal.launching.ext.AJConstants;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin;

@SuppressWarnings("restriction")
public class StartLevelSupport {
	public static final String START_LEVEL_ATTR = "Runtime-StartLevel";
	public static final String AUTO_START_ATTR = "Runtime-AutoStart";

	private static final Map<String, String> predefined = new HashMap<String, String>();
	static {
		predefined.put(AJConstants.AJ_HOOK, "1:true");
		predefined.put(AJConstants.AJ_RT, "1:true");
		predefined.put(IPDEBuildConstants.BUNDLE_OSGI, "-1:true");
		predefined.put(IPDEBuildConstants.BUNDLE_DS, "2:true");
		predefined.put(IPDEBuildConstants.BUNDLE_EQUINOX_COMMON, "2:true");
		predefined.put(IPDEBuildConstants.BUNDLE_SIMPLE_CONFIGURATOR, "1:true");
		predefined
				.put(IPDEBuildConstants.BUNDLE_UPDATE_CONFIGURATOR,
						String.format(
								"%s:%s",
								BundleLauncherHelper.DEFAULT_UPDATE_CONFIGURATOR_START_LEVEL_TEXT,
								BundleLauncherHelper.DEFAULT_UPDATE_CONFIGURATOR_AUTO_START_TEXT));
		predefined.put(IPDEBuildConstants.BUNDLE_CORE_RUNTIME, "default:true");
	}

	public static BundleStart getStartInfo(IPluginModelBase model,
			BundleStart hint) {

		// first, check for Q7 headers
		String q7sl = null;
		String q7as = null;

		Map<String, String> headers = loadManifest(model.getInstallLocation());
		if (headers != null) {
			q7sl = safeToString(headers.get(START_LEVEL_ATTR));
			q7as = safeToString(headers.get(AUTO_START_ATTR));
		} else {
			Q7ExtLaunchingPlugin.logWarn(
					"Could not read manifest for bundle %s",
					model.getInstallLocation());
		}
		if (q7sl != null || q7as != null) {
			return BundleStart.fromQ7Headers(q7sl, q7as);
		}

		// if hint is default, check for predefined bundle
		String id = id(model);
		if (hint.isDefault() && predefined.containsKey(id)) {
			return BundleStart.fromModelString(predefined.get(id));
		}

		return hint;
	}

	public static Map<String, String> loadManifest(String path) {
		ZipFile jarFile = null;
		InputStream manifestStream = null;
		try {
			File dirOrJar = new File(path);
			String extension = new Path(path).getFileExtension();
			if (extension != null
					&& extension.equals("jar") && dirOrJar.isFile()) { //$NON-NLS-1$
				jarFile = new ZipFile(dirOrJar, ZipFile.OPEN_READ);
				ZipEntry manifestEntry = jarFile
						.getEntry(JarFile.MANIFEST_NAME);
				if (manifestEntry != null) {
					manifestStream = jarFile.getInputStream(manifestEntry);
				}
			} else {
				File file = new File(dirOrJar, JarFile.MANIFEST_NAME);
				if (file.exists())
					manifestStream = new FileInputStream(file);
			}
			if (manifestStream == null) {
				return null;
			}
			return ManifestElement.parseBundleManifest(manifestStream,
					new HashMap<String, String>(10));
		} catch (BundleException e) {
			return null;
		} catch (IOException e) {
			return null;
		} finally {
			closeZipFileAndStream(manifestStream, jarFile);
		}
	}

	private static void closeZipFileAndStream(InputStream stream,
			ZipFile jarFile) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
		try {
			if (jarFile != null) {
				jarFile.close();
			}
		} catch (IOException e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
	}
}
