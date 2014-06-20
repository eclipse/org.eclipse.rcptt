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

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Iterables.transform;
import static java.util.Arrays.asList;
import static org.eclipse.pde.internal.build.IPDEBuildConstants.BUNDLE_SIMPLE_CONFIGURATOR;
import static org.eclipse.pde.internal.launching.launcher.LaunchConfigurationHelper.getBundleURL;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Platform;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.build.IPDEBuildConstants;
import org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper;
import org.eclipse.pde.launching.EclipseApplicationLaunchConfiguration;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import org.eclipse.rcptt.internal.launching.ext.AJConstants;
import org.eclipse.rcptt.internal.launching.ext.PDEUtils;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin;
import org.eclipse.rcptt.internal.launching.ext.UpdateVMArgs;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;

@SuppressWarnings("restriction")
public class Q7LaunchDelegateUtils {
	private static String getEntry(IPluginModelBase bundle, String startLevel) {
		StringBuilder result = new StringBuilder("reference:");
		result.append(getBundleURL(bundle, false));
		result.append(startLevel);
		return result.toString();
	}

	private static IPluginModelBase getSimpleConfigurator(
			Map<String, Object> bundles) {
		return (IPluginModelBase) bundles
				.get(IPDEBuildConstants.BUNDLE_SIMPLE_CONFIGURATOR);
	}

	private static final Predicate<IPluginModelBase> isSimpleConfigurator = new Predicate<IPluginModelBase>() {
		public boolean apply(IPluginModelBase input) {
			return BUNDLE_SIMPLE_CONFIGURATOR.equals(id(input));
		}
	};

	private static IPluginModelBase findSimpleConfigurator(
			Iterable<IPluginModelBase> plugins) {
		return find(plugins, isSimpleConfigurator, null);
	}

	public static String computeOSGiBundles(Map<String, Object> bundles,
			final Map<Object, String> bundlesWithStartLevels) {
		return computeOSGiBundles(bundles, bundlesWithStartLevels, 4);
	}

	public static String computeOSGiBundles(
			Map<IPluginModelBase, BundleStart> bundles) {
		return computeOSGiBundles(bundles, 4);
	}

	public static String computeOSGiBundles(
			Map<IPluginModelBase, BundleStart> bundles,
			final int defaultStartLevel) {
		IPluginModelBase sc = findSimpleConfigurator(bundles.keySet());
		if (sc != null) {
			return getEntry(sc, "@1:start");
		}

		StringBuilder sb = new StringBuilder();
		for (Entry<IPluginModelBase, BundleStart> entry : bundles.entrySet()) {
			if (EXCLUDE.contains(id(entry.getKey()))) {
				continue;
			}
			if (sb.length() > 0) {
				sb.append(",");
			}

			sb.append(getEntry(entry.getKey(),
					entry.getValue().toOsgiString(defaultStartLevel)));
		}
		return sb.toString();

	}

	private static List<String> EXCLUDE = asList(IPDEBuildConstants.BUNDLE_OSGI);
	private static final Predicate<Object> keepBundle = new Predicate<Object>() {

		public boolean apply(Object input) {
			return !EXCLUDE.contains(id((IPluginModelBase) input));
		}
	};

	private static final String DEFAULT = "default";

	private static final String resolveStartLevel(String sl,
			int defaultStartLevel) {
		int sep = sl.indexOf(':');
		String levelStr = sep == -1 ? sl : sl.substring(0, sep);
		String startStr = sep == -1 ? DEFAULT : sl.substring(sep + 1);

		boolean defaultLevel = DEFAULT.equals(levelStr);
		boolean defaultStart = DEFAULT.equals(startStr);
		if (defaultLevel && defaultStart) {
			return "";
		}

		if (defaultStart) {
			return "@" + levelStr;
		}

		String actualLevelStr = defaultLevel ? Integer
				.toString(defaultStartLevel) : levelStr;
		String actualStartStr = Boolean.parseBoolean(startStr) ? ":start" : "";
		return "@" + actualLevelStr + actualStartStr;
	}

	public static String computeOSGiBundles(Map<String, Object> bundles,
			final Map<Object, String> bundlesWithStartLevels,
			final int defaultStartLevel) {

		IPluginModelBase simpleConfigurator = getSimpleConfigurator(bundles);
		if (simpleConfigurator != null) {
			return getEntry(simpleConfigurator, "@1:start");
		}

		return Joiner.on(",").join(
				transform(filter(bundles.values(), keepBundle),
						new Function<Object, String>() {
							public String apply(Object input) {
								IPluginModelBase plugin = (IPluginModelBase) input;
								return getEntry(
										plugin,
										resolveStartLevel(
												bundlesWithStartLevels
														.get(plugin),
												defaultStartLevel));

							}
						}));
	}

	public static String id(IPluginModelBase plugin) {
		return plugin.getPluginBase().getId();
	}

	public static void addBundleToMap(IPluginModelBase model,
			Map<Object, String> fModels, Map<String, String> runlevelsMap) {
		String name = model.getBundleDescription().getSymbolicName();
		if (name.equals(AJConstants.AJ_HOOK) || name.equals(AJConstants.AJ_RT)) {
			PDEUtils.addBundleToMap(fModels, model, "1:true");
		} else {
			Map<String, String> manifest = StartLevelSupport.loadManifest(model
					.getInstallLocation());
			if (manifest != null) {
				String startLevel = (String) manifest
						.get(StartLevelSupport.START_LEVEL_ATTR);
				String autoStart = (String) manifest
						.get(StartLevelSupport.AUTO_START_ATTR);
				if (startLevel == null && autoStart == null) {
					if (runlevelsMap != null && runlevelsMap.containsKey(name)) {
						PDEUtils.addBundleToMap(fModels, model,
								runlevelsMap.get(name));
						return;
					}
				}
				if (startLevel == null) {
					startLevel = "default";
				}
				if (autoStart == null) {
					autoStart = "default";
				}
				PDEUtils.addBundleToMap(fModels, model, startLevel + ":"
						+ autoStart);
				return;
			}
			if (runlevelsMap != null && runlevelsMap.containsKey(name)) {
				PDEUtils.addBundleToMap(fModels, model, runlevelsMap.get(name));
			} else {
				PDEUtils.addBundleToMap(fModels, model, "default:default");
			}
		}
	}

	public static void setDelegateFields(
			EclipseApplicationLaunchConfiguration delegate,
			Map<Object, String> models, Map<String, Object> allBundles) {
		try {
			Field field = EclipseApplicationLaunchConfiguration.class
					.getDeclaredField("fModels");
			field.setAccessible(true);
			field.set(delegate, models);

			field = EclipseApplicationLaunchConfiguration.class
					.getDeclaredField("fAllBundles");
			field.setAccessible(true);
			field.set(delegate, allBundles);
		} catch (Throwable e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<IPluginModelBase, String> getEclipseApplicationModels(
			EclipseApplicationLaunchConfiguration delegate) {
		try {
			Field field = EclipseApplicationLaunchConfiguration.class
					.getDeclaredField("fModels");
			field.setAccessible(true);
			return (Map<IPluginModelBase, String>) field.get(delegate);
		} catch (Throwable e) {
			Q7ExtLaunchingPlugin.getDefault().log(e);
		}
		return null;
	}

	public static final List<String> DEF_ARGS = Arrays.asList("-os",
			"${target.os}", "-arch", "${target.arch}", "-nl", "${target.nl}",
			"-consoleLog");

	public static File getWorkingDirectory(File autLocation) {
		if (!Platform.getOS().equals(Platform.OS_MACOSX)) {
			return autLocation;
		}
		if (autLocation == null || !autLocation.exists()
				|| !autLocation.isDirectory()) {
			return autLocation;
		}
		for (File child : autLocation.listFiles()) {
			if (!child.isDirectory() || !child.getName().endsWith(".app")) {
				continue;
			}
			File result = new File(new File(child, "Contents"), "MacOS");
			if (result.exists()) {
				return result;
			}
		}
		return autLocation;
	}

	public static String getAUTArgs(String[] args) {
		return getAUTArgs(args == null ? Collections.<String> emptyList()
				: Arrays.asList(args));
	}

	public static String getVMArgs(ITargetPlatformHelper aut, String[] userArgs) {
		return getVMArgs(
				aut,
				userArgs == null ? Collections.<String> emptyList() : Arrays
						.asList(userArgs));
	}

	public static String getVMArgs(ITargetPlatformHelper aut,
			Collection<String> userArgs) {
		StringBuilder result = new StringBuilder();
		String iniArgs = aut.getIniVMArgs();
		if (iniArgs == null) {
			iniArgs = LaunchArgumentsHelper.getInitialVMArguments();
		}
		if (iniArgs == null) {
			iniArgs = "";
		}
		result.append(iniArgs);

		if (userArgs != null) {
			for (String vmArg : userArgs) {
				result.append(" ");
				result.append(Q7LaunchDelegateUtils.escapeCommandArg(vmArg));
			}
		}
		return UpdateVMArgs.updateAttr(result.toString().trim());
	}

	public static String getAUTArgs(Collection<String> userArgs) {
		List<String> allArgs = new ArrayList<String>(DEF_ARGS);
		if (userArgs != null) {
			allArgs.addAll(userArgs);
		}
		return joinCommandArgs(allArgs);
	}

	public static String joinCommandArgs(Collection<String> args) {
		if (args == null || args.isEmpty()) {
			return "";
		}

		StringBuilder result = new StringBuilder();
		for (String arg : args) {
			result.append(escapeCommandArg(arg));
			result.append(" ");
		}
		result.setLength(result.length() - 1); // trim last space
		return result.toString();
	}

	public static String escapeCommandArg(String arg) {
		if (arg == null || arg.length() == 0) {
			return "\"\""; // empty string encoded
		}
		// escape backslashes and quotes
		if (!Platform.getOS().equals(Platform.OS_WIN32))
			arg = arg.replace("\\", "\\\\");
		arg = arg.replace("\"", "\\\"");
		return arg.contains(" ") ? String.format("\"%s\"", arg) : arg;
	}

	public static String joinCommandArgs(String[] args) {
		return joinCommandArgs(args == null ? Collections.<String> emptyList()
				: Arrays.asList(args));
	}
}