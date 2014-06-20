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

import static com.google.common.base.Objects.firstNonNull;
import static org.eclipse.rcptt.internal.launching.ext.AJConstants.OSGI_FRAMEWORK_EXTENSIONS;
import static org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin.log;
import static org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin.status;
import static org.eclipse.rcptt.launching.ext.Q7LaunchDelegateUtils.id;
import static org.eclipse.rcptt.launching.ext.Q7LaunchDelegateUtils.setDelegateFields;
import static org.eclipse.rcptt.launching.ext.StartLevelSupport.getStartInfo;
import static org.eclipse.rcptt.util.Versions.isGreater;
import static java.util.Arrays.asList;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.build.IPDEBuildConstants;
import org.eclipse.pde.internal.core.PDEState;
import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.IBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.IResolvedBundle;
import org.eclipse.pde.internal.launching.PDEMessages;
import org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper;
import org.eclipse.pde.internal.launching.launcher.LaunchConfigurationHelper;
import org.eclipse.pde.internal.launching.launcher.LauncherUtils;
import org.eclipse.pde.internal.launching.launcher.VMHelper;
import org.eclipse.pde.launching.EclipseApplicationLaunchConfiguration;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.osgi.framework.Version;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.aut.LaunchInfoCache;
import org.eclipse.rcptt.internal.launching.aut.LaunchInfoCache.CachedInfo;
import org.eclipse.rcptt.internal.launching.ext.AJConstants;
import org.eclipse.rcptt.internal.launching.ext.IBundlePoolConstansts;
import org.eclipse.rcptt.internal.launching.ext.JDTUtils;
import org.eclipse.rcptt.internal.launching.ext.OSArchitecture;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchMonitor;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformManager;
import org.eclipse.rcptt.internal.launching.ext.UpdateVMArgs;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.common.Q7LaunchingCommon;
import org.eclipse.rcptt.launching.events.AutEventManager;
import org.eclipse.rcptt.launching.internal.target.Q7Target;
import org.eclipse.rcptt.launching.internal.target.TargetPlatformHelper;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.rcptt.launching.target.TargetPlatformManager;
import org.eclipse.rcptt.util.FileUtil;
import org.eclipse.rcptt.tesla.core.TeslaLimits;

@SuppressWarnings("restriction")
public class Q7ExternalLaunchDelegate extends
		EclipseApplicationLaunchConfiguration {

	private static final String ATTR_D32 = "-d32";

	private static final String Q7_LAUNCHING_AUT = "RCPTT: Launching AUT: ";

	private static final String SECURE_STORAGE_FILE_NAME = "secure_storage";

	private ILaunch launch;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		this.launch = launch;
		monitor.beginTask("", 2); //$NON-NLS-1$
		Q7ExtLaunchMonitor waiter = new Q7ExtLaunchMonitor(launch);

		ILaunchConfiguration cfg = updateConsoleAttribute(configuration);

		try {
			super.launch(cfg, mode, launch, SubMonitor.convert(monitor, 1));
			waiter.wait(monitor, TeslaLimits.getAUTStartupTimeout() / 1000);
		} catch (CoreException e) {
			Q7ExtLaunchingPlugin.getDefault().log(
					"RCPTT: Failed to Launch AUT: " + configuration.getName()
							+ " cause " + e.getMessage(), e);
			waiter.handle(e);
			// no need to throw exception in case of cancel
			if (e.getStatus().getSeverity() != IStatus.CANCEL) {
				throw e;
			}
		} catch (RuntimeException e) {
			Q7ExtLaunchingPlugin.getDefault().log(
					"RCPTT: Failed to Launch AUT: " + configuration.getName()
							+ " cause " + e.getMessage(), e);
			waiter.handle(e);
			throw e;
		} finally {
			waiter.dispose();
		}
		monitor.done();
	}

	private ILaunchConfiguration updateConsoleAttribute(
			ILaunchConfiguration configuration) throws CoreException {
		ILaunchConfigurationWorkingCopy configurationWc = configuration
				.getWorkingCopy();

		String log_directory = new Path(LaunchConfigurationHelper
				.getConfigurationArea(configuration).getAbsolutePath()).append(
				"console.log").toOSString();

		String old_path = configurationWc.getAttribute(
				IQ7Launch.ATTR_CAPTURE_IN_FILE, (String) null);
		if (old_path == null) {
			configurationWc.setAttribute(IQ7Launch.ATTR_CAPTURE_IN_FILE,
					log_directory);
		}
		configurationWc.setAttribute(IQ7Launch.ATTR_APPEND_TO_FILE, true);

		ILaunchConfiguration cfg = configurationWc.doSave();
		return cfg;
	}

	@Override
	protected void manageLaunch(ILaunch launch) {
		// remove base PDE launch management
	}

	@Override
	protected boolean saveBeforeLaunch(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		if (isHeadless(configuration)) {
			return true;
		}
		return super.saveBeforeLaunch(configuration, mode, monitor);
	}

	@Override
	public boolean finalLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		if (isHeadless(configuration)) {
			return true;
		}
		return super.finalLaunchCheck(configuration, mode, monitor);
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		if (monitor.isCanceled()) {
			return false;
		}
		monitor.beginTask("", 4);
		if (!isHeadless(configuration)
				&& !super.preLaunchCheck(configuration, mode,
						new SubProgressMonitor(monitor, 1))) {
			monitor.done();
			return false;
		}

		waitForClearBundlePool(monitor);

		CachedInfo info = LaunchInfoCache.getInfo(configuration);

		if (info.target != null) {
			monitor.done();
			return true;
		}

		ITargetPlatformHelper target = null;
		info = LaunchInfoCache.getInfo(configuration);
		try {
			target = Q7TargetPlatformManager.getTarget(configuration,
					SubMonitor.convert(monitor, 2));
		} catch (Exception e) {
			monitor.setCanceled(true);
		}
		if (monitor.isCanceled()) {
			removeTargetPlatform(configuration);
			return false;
		}

		info.target = target;

		if (!target.isValid()
				|| !target.validateBundles(new SubProgressMonitor(monitor, 1))) {
			if (monitor.isCanceled()) {
				removeTargetPlatform(configuration);
				return false;
			}

			String errorMessage = "RCPTT failed to launch configuration: "
					+ configuration.getName()
					+ " because target platform for configuration is not valid. Error: "
					+ target.getErrorMessage();
			IStatus error = Q7ExtLaunchingPlugin.status(errorMessage, null);
			Q7ExtLaunchingPlugin.log(error);
			removeTargetPlatform(configuration);
			throw new CoreException(error);
		}

		boolean haveAUT = false;

		OSArchitecture configArch = null;
		StringBuilder detectMsg = new StringBuilder();

		OSArchitecture architecture = ((configArch == null) ? ((ITargetPlatformHelper) info.target)
				.detectArchitecture(true, detectMsg) : configArch);

		Q7ExtLaunchingPlugin.getDefault().info(
				Q7_LAUNCHING_AUT + configuration.getName()
						+ ": Detected AUT architecture is "
						+ architecture.name() + "." + detectMsg.toString());

		try {
			IVMInstall install = VMHelper.getVMInstall(configuration);

			OSArchitecture jvmArch = JDTUtils.detect(install);

			Q7ExtLaunchingPlugin.getDefault().info(
					Q7_LAUNCHING_AUT + configuration.getName()
							+ ": Selected JVM is "
							+ install.getInstallLocation().toString()
							+ " detected architecture is " + jvmArch.name());

			boolean canRun32bit = false;
			if (jvmArch.equals(architecture)
					|| (jvmArch.equals(OSArchitecture.x86_64) && (canRun32bit = JDTUtils
							.canRun32bit(install)))) {
				haveAUT = true;
			}

			if (!haveAUT
					&& architecture != OSArchitecture.Unknown
					&& target.detectArchitecture(false, new StringBuilder()) == OSArchitecture.Unknown) {
				Q7ExtLaunchingPlugin
						.getDefault()
						.info("Cannot determine AUT architecture, sticking to architecture of selected JVM, which is "
								+ jvmArch.name());
				haveAUT = true;
			}

			Q7ExtLaunchingPlugin
					.getDefault()
					.info(Q7_LAUNCHING_AUT
							+ configuration.getName()
							+ ": JVM and AUT architectures are compatible: "
							+ haveAUT
							+ "."
							+ (jvmArch.equals(OSArchitecture.x86_64) ? " JVM is 64bit and support running 32bit: "
									+ canRun32bit
									: ""));
		} catch (Throwable e) {
			RcpttPlugin.log(e);
		}
		if (!haveAUT) {
			// Let's search for configuration and update JVM if possible.
			haveAUT = updateJVM(configuration, architecture,
					((ITargetPlatformHelper) info.target));

			if (!haveAUT) {
				// try to register current JVM, it may help
				try {
					JDTUtils.registerCurrentJVM();
					haveAUT = updateJVM(configuration, architecture,
							((ITargetPlatformHelper) info.target));
				} catch (CoreException e) {
					// no special actions, error message will be set by
					// lines below
					Q7ExtLaunchingPlugin.getDefault().log(e);
				}
			}

			if (haveAUT) {
				try {
					Q7ExtLaunchingPlugin
							.getDefault()
							.info(Q7_LAUNCHING_AUT
									+ configuration.getName()
									+ "JVM configuration is updated to compatible one: "
									+ VMHelper.getVMInstall(configuration)
											.getInstallLocation());
				} catch (Throwable e) {
					// in case of error
					Q7ExtLaunchingPlugin.getDefault().log(e.getMessage(), e);
				}
			}

		}
		if (!haveAUT) {
			String errorMessage = "The "
					+ configuration.getName()
					+ " requires "
					+ ((OSArchitecture.x86.equals(architecture)) ? "32 bit"
							: "64 bit") + " Java VM which cannot be found.";
			Q7ExtLaunchingPlugin.getDefault().log(errorMessage, null);
			removeTargetPlatform(configuration);
			throw new CoreException(new Status(IStatus.ERROR,
					Q7ExtLaunchingPlugin.PLUGIN_ID, errorMessage, null));
		}

		monitor.done();
		return true;
	}

	private void removeTargetPlatform(ILaunchConfiguration configuration)
			throws CoreException {
		String targetPlatformName = configuration.getAttribute(
				IQ7Launch.TARGET_PLATFORM, "");
		Q7TargetPlatformManager.delete(targetPlatformName);
		LaunchInfoCache.remove(configuration);
		TargetPlatformManager.deleteTargetPlatform(targetPlatformName);
	}

	private static boolean isHeadless(ILaunchConfiguration configuration)
			throws CoreException {
		return configuration
				.getAttribute(IQ7Launch.ATTR_HEADLESS_LAUNCH, false);
	}

	private void waitForClearBundlePool(IProgressMonitor monitor) {
		try {
			Job.getJobManager().join(
					IBundlePoolConstansts.CLEAN_BUNDLE_POOL_JOB,
					new SubProgressMonitor(monitor, 1));
		} catch (Exception e1) {
			Q7ExtLaunchingPlugin.getDefault().log(
					"Failed to wait for bundle pool clear job", e1);
		}
	}

	private boolean updateJVM(ILaunchConfiguration configuration,
			OSArchitecture architecture, ITargetPlatformHelper target) {
		try {
			IVMInstall jvmInstall = null;
			OSArchitecture jvmArch = OSArchitecture.Unknown;
			IVMInstallType[] types = JavaRuntime.getVMInstallTypes();
			boolean haveArch = false;
			for (IVMInstallType ivmInstallType : types) {
				IVMInstall[] installs = ivmInstallType.getVMInstalls();
				for (IVMInstall ivmInstall : installs) {
					jvmArch = JDTUtils.detect(ivmInstall);
					if (jvmArch.equals(architecture)
							|| (jvmArch.equals(OSArchitecture.x86_64) && JDTUtils
									.canRun32bit(ivmInstall))) {
						jvmInstall = ivmInstall;
						haveArch = true;
						break;
					}
				}
			}
			if (haveArch) {
				ILaunchConfigurationWorkingCopy workingCopy = configuration
						.getWorkingCopy();

				String vmArgs = workingCopy.getAttribute(
						IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
						target.getIniVMArgs());
				if (vmArgs == null) {
					// Lets use current runner vm arguments
					vmArgs = LaunchArgumentsHelper.getInitialVMArguments()
							.trim();
				} else {
					vmArgs = vmArgs.trim();
				}

				OSArchitecture configArch;
				String archAttrValue = configuration.getAttribute(
						Q7LaunchingCommon.ATTR_ARCH, "");
				if (archAttrValue.isEmpty())
					configArch = null;
				else
					configArch = OSArchitecture.valueOf(archAttrValue);

				OSArchitecture autArch = configArch == null ? target
						.detectArchitecture(true, null) : configArch;

				// there is no -d32 on Windows
				if (!autArch.equals(jvmArch)
						&& Platform.getOS().equals(Platform.OS_MACOSX)) {
					if (vmArgs != null && !vmArgs.contains(ATTR_D32)) {
						vmArgs += " " + ATTR_D32;
					} else {
						vmArgs = ATTR_D32;
					}
				}
				if (vmArgs != null && vmArgs.length() > 0) {
					vmArgs = UpdateVMArgs.updateAttr(vmArgs);
					workingCopy
							.setAttribute(
									IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
									vmArgs);
				}

				workingCopy
						.setAttribute(
								IJavaLaunchConfigurationConstants.ATTR_JRE_CONTAINER_PATH,
								String.format(
										"org.eclipse.jdt.launching.JRE_CONTAINER/%s/%s",
										jvmInstall.getVMInstallType().getId(),
										jvmInstall.getName()));

				String programArgs = workingCopy
						.getAttribute(
								IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS,
								LaunchArgumentsHelper
										.getInitialProgramArguments().trim());
				if (programArgs.contains("${target.arch}")) {
					programArgs = programArgs.replace("${target.arch}",
							autArch.name());
				} else {
					if (programArgs.contains("-arch")) {
						int pos = programArgs.indexOf("-arch ") + 6;
						int len = 6;
						int pos2 = programArgs.indexOf("x86_64", pos);
						if (pos2 == -1) {
							len = 3;
							pos2 = programArgs.indexOf("x86", pos);
						}
						if (pos2 != -1) {
							programArgs = programArgs.substring(0, pos)
									+ autArch.name()
									+ programArgs.substring(pos2 + len,
											programArgs.length());
						}
					} else {
						programArgs = programArgs + " -arch " + autArch.name();
					}
				}
				if (programArgs.length() > 0) {
					workingCopy
							.setAttribute(
									IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS,
									programArgs);
				}
				workingCopy.doSave();
				return true;
			}
		} catch (Throwable e) {
			RcpttPlugin.log(e);
		}
		return false;
	}

	private static String getSubstitutedString(String text)
			throws CoreException {
		if (text == null)
			return ""; //$NON-NLS-1$
		IStringVariableManager mgr = VariablesPlugin.getDefault()
				.getStringVariableManager();
		return mgr.performStringSubstitution(text);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String[] constructClasspath(ILaunchConfiguration configuration)
			throws CoreException {
		CachedInfo info = LaunchInfoCache.getInfo(configuration);
		ITargetPlatformHelper target = (ITargetPlatformHelper) info.target;

		String jarPath = target
				.getEquinoxStartupPath(IPDEBuildConstants.BUNDLE_EQUINOX_LAUNCHER);

		if (jarPath == null)
			return null;

		ArrayList entries = new ArrayList();
		entries.add(jarPath);

		String bootstrap = configuration.getAttribute(
				IPDELauncherConstants.BOOTSTRAP_ENTRIES, ""); //$NON-NLS-1$
		StringTokenizer tok = new StringTokenizer(
				getSubstitutedString(bootstrap), ","); //$NON-NLS-1$
		while (tok.hasMoreTokens())
			entries.add(tok.nextToken().trim());
		return (String[]) entries.toArray(new String[entries.size()]);

	}

	@Override
	public String[] getClasspath(ILaunchConfiguration configuration)
			throws CoreException {
		String[] classpath = constructClasspath(configuration);
		if (classpath == null) {
			String message = PDEMessages.WorkbenchLauncherConfigurationDelegate_noStartup;
			throw new CoreException(LauncherUtils.createErrorStatus(message));
		}
		return classpath;
	}

	@Override
	public String[] getProgramArguments(ILaunchConfiguration configuration)
			throws CoreException {
		CachedInfo info = LaunchInfoCache.getInfo(configuration);
		final ITargetPlatformHelper target = (ITargetPlatformHelper) info.target;
		if (info.programArgs != null) {
			return info.programArgs;
		}

		ArrayList<String> programArgs = new ArrayList<String>();

		programArgs.addAll(asList(super.getProgramArguments(configuration)));

		try {
			// Correct osgi.install.area property key
			File config = new File(getConfigDir(configuration), "config.ini");
			Properties props = new Properties();

			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(config));
			props.load(in);
			in.close();

			File location = target.getQ7Target().getInstallLocation();
			if (location != null) {
				props.setProperty("osgi.install.area",
						location.getAbsolutePath());
			}
			props.setProperty(
					"osgi.bundles",
					Q7LaunchDelegateUtils
							.computeOSGiBundles(getBundlesToLaunch(info).latestVersionsOnly));

			// Append all other properties from original config file
			OriginalOrderProperties properties = target.getConfigIniProperties();

			properties.setBeginAdd(true);
			properties.putAll(props);

			properties.setProperty(
					OSGI_FRAMEWORK_EXTENSIONS,
					addWeavingHook(
							properties.getProperty(OSGI_FRAMEWORK_EXTENSIONS),
							target.getWeavingHook()));

			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(config));
			properties.store(out, "Configuration File");
			out.close();
		} catch (IOException e) {
			throw new CoreException(Q7ExtLaunchingPlugin.status(e));
		}
		String override = configuration.getAttribute(
				IQ7Launch.OVERRIDE_SECURE_STORAGE, (String) null);
		if (override == null || "true".equals(override)) {
			// Override existing parameter
			programArgs.add("-eclipse.keyring");
			programArgs.add(getConfigDir(configuration).toString()
					+ IPath.SEPARATOR + SECURE_STORAGE_FILE_NAME);
		}

		IVMInstall install = VMHelper.getVMInstall(configuration);
		programArgs.add("-vm");
		programArgs.add(install.getInstallLocation().toString());

		info.programArgs = programArgs.toArray(new String[programArgs.size()]);
		Q7ExtLaunchingPlugin.getDefault().info(
				Q7_LAUNCHING_AUT + configuration.getName()
						+ ": AUT command line arguments is set to: "
						+ Arrays.toString(info.programArgs));
		return info.programArgs;
	}

	private static String addWeavingHook(String extensions, IPluginModelBase hook) throws CoreException {
		if (hook == null) {
			throw new CoreException(Q7ExtLaunchingPlugin.status("No "
					+ AJConstants.HOOK + " plugin"));
		}

		String ajref = String.format("reference:file:%s", hook.getInstallLocation());

		if (extensions == null) {
			return ajref;
		}

		// otherwise split and search for a duplicate AJ hook:
		StringBuilder result = new StringBuilder();

		for (String extension : extensions.split(",")) {
			if (extensions.contains(AJConstants.HOOK)) {
				continue;
			}
			if (!extension.isEmpty())
				result.append(extension).append(',');
		}
		result.append(ajref).append(',');
		result.setLength(result.length() - 1);
		return result.toString();
	}

	@Override
	public String[] getVMArguments(ILaunchConfiguration config)
			throws CoreException {
		CachedInfo info = LaunchInfoCache.getInfo(config);
		if (info.vmArgs != null) {
			return info.vmArgs;
		}
		List<String> args = new ArrayList<String>(Arrays.asList(super
				.getVMArguments(config)));

		// Filter some PDE parameters
		Iterables.removeIf(args, new Predicate<String>() {
			public boolean apply(String input) {
				if (input.contains("-Declipse.pde.launch=true")) {
					return true;
				}
				return false;
			}
		});

		args.add("-Dq7id=" + launch.getAttribute(IQ7Launch.ATTR_AUT_ID));
		args.add("-Dq7EclPort=" + AutEventManager.INSTANCE.getPort());

		TargetPlatformHelper target = (TargetPlatformHelper) ((ITargetPlatformHelper) info.target);

		IPluginModelBase hook = target.getWeavingHook();
		if (hook == null) {
			throw new CoreException(Q7ExtLaunchingPlugin.status("No "
					+ AJConstants.HOOK + " plugin"));
		}

		args.add("-Dosgi.framework.extensions=reference:file:"
				+ hook.getInstallLocation());

		args.add("-Declipse.vmargs=" + Joiner.on("\n").join(args));

		info.vmArgs = args.toArray(new String[args.size()]);
		Q7ExtLaunchingPlugin.getDefault().info(
				Q7_LAUNCHING_AUT + config.getName()
						+ ": AUT JVM arguments is set to : "
						+ Arrays.toString(info.vmArgs));
		return info.vmArgs;
	}

	@Override
	protected void preLaunchCheck(final ILaunchConfiguration configuration,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		super.preLaunchCheck(configuration, launch, monitor);
		if (monitor.isCanceled()) {
			return;
		}

		CachedInfo info = LaunchInfoCache.getInfo(configuration);

		BundlesToLaunch bundlesToLaunch = collectBundles(((ITargetPlatformHelper) info.target)
				.getQ7Target());

		setBundlesToLaunch(info, bundlesToLaunch);

		setDelegateFields(this, bundlesToLaunch.fModels,
				bundlesToLaunch.fAllBundles);

		// Copy all additional configuration area folders into PDE new
		// configuration location.
		copyConfiguratonFiles(configuration, info);
	}

	public static class BundlesToLaunchCollector {
		private void addInstallationBundle(IResolvedBundle bundle,
				BundleStart hint) {
			for (IPluginModelBase base : getModels(bundle)) {
				addInstallationBundle(base, hint);
			}
		}

		public void addInstallationBundle(IPluginModelBase base,
				BundleStart hint) {
			String id = id(base);
			idsToSkip.add(id);
			put(base, getStartInfo(base, hint));
		}

		private void addPluginBundle(IResolvedBundle bundle) {
			for (IPluginModelBase base : getModels(bundle)) {
				String id = id(base);

				if (idsToSkip.contains(id)) {
					continue;
				}
				put(base, getStartInfo(base, BundleStart.DEFAULT));
			}
		}

		public void addExtraBundle(IResolvedBundle bundle) {
			for (IPluginModelBase base : getModels(bundle)) {
				put(base, getStartInfo(base, BundleStart.DEFAULT));
			}
		}

		public BundlesToLaunch getResult() {
			return new BundlesToLaunch(rejectedBundles, plugins, latestVersions);
		}

		private void put(IPluginModelBase plugin, BundleStart start) {

			/**
			 * Check for aspectj special plugins, they should be one version
			 * only.
			 **/
			final String id = id(plugin);
			if (id.equals(AJConstants.AJ_HOOK) || id.equals(AJConstants.AJ_RT)
					|| id.equals(AJConstants.HOOK)) {
				// remove previous bundles with specified id
				Iterables.removeIf(plugins.entrySet(), isEqualsId(id));
				latestVersions.remove(id);
			}

			plugins.put(plugin, start);
			IPluginModelBase existing = latestVersions.get(id);

			if (existing == null
					|| isGreater(version(plugin), version(existing))) {
				latestVersions.put(id, plugin);
			}
		}

		private Predicate<Entry<IPluginModelBase, BundleStart>> isEqualsId(
				final String id) {
			return new Predicate<Map.Entry<IPluginModelBase, BundleStart>>() {
				public boolean apply(Entry<IPluginModelBase, BundleStart> input) {
					if (id.equals(id(input.getKey()))) {
						return true;
					}
					return false;
				}
			};
		}

		private final Set<String> idsToSkip = new HashSet<String>();
		private final Set<String> rejectedBundles = new LinkedHashSet<String>();
		private final Map<IPluginModelBase, BundleStart> plugins = new HashMap<IPluginModelBase, BundleStart>();
		private final Map<String, IPluginModelBase> latestVersions = new HashMap<String, IPluginModelBase>();
	}

	public static boolean isQ7BundleContainer(IBundleContainer container) {
		if (!(container instanceof IUBundleContainer))
			return false;
		URI[] uris = ((IUBundleContainer) container).getRepositories();
		for (URI uri : uris) {
			if (!uri.getScheme().equals("platform")
					|| !uri.getPath().startsWith("/plugin/org.eclipse.rcptt")) {
				return false;
			}
		}
		return true;
	}

	public static BundlesToLaunch collectBundles(Q7Target target) {
		BundlesToLaunchCollector collector = new BundlesToLaunchCollector();
		if (target.getInstall() != null) {
			Map<String, BundleStart> bundlesFromConfig = target.getInstall()
					.configIniBundles();
			for (IResolvedBundle bundle : target.getInstall().getBundles()) {
				BundleStart hint = firstNonNull(bundlesFromConfig.get(bundle
						.getBundleInfo().getSymbolicName()),
						BundleStart.fromBundle(bundle.getBundleInfo()));
				collector.addInstallationBundle(bundle, hint);
			}
		}

		if (target.pluginsDir != null) {
			for (IResolvedBundle bundle : target.pluginsDir.getBundles()) {
				collector.addPluginBundle(bundle);
			}
		}

		for (IBundleContainer extra : target.getExtras()) {
			for (IResolvedBundle bundle : extra.getBundles()) {
				collector.addExtraBundle(bundle);
			}
		}

		return new BundlesToLaunch(collector.rejectedBundles,
				collector.plugins, collector.latestVersions);
	}

	/**
	 * Represents result of collection of bundles to launch
	 * 
	 * @author ivaninozemtsev
	 * 
	 */
	public static class BundlesToLaunch {
		public BundlesToLaunch(Set<String> rejectedBundles,
				Map<IPluginModelBase, BundleStart> plugins,
				final Map<String, IPluginModelBase> latestVersions) {
			this.resolvedBundles = plugins;

			this.latestVersionsOnly = Maps.filterKeys(resolvedBundles,
					new Predicate<IPluginModelBase>() {
						public boolean apply(IPluginModelBase input) {
							// II: reference equality intentionally
							return latestVersions.get(id(input)) == input;
						}
					});

			fAllBundles = new HashMap<String, Object>(latestVersions);
			fModels = new HashMap<Object, String>(Maps.transformValues(
					resolvedBundles, new Function<BundleStart, String>() {
						public String apply(BundleStart input) {
							return input.toModelString();
						}
					}));
		}

		public final Map<IPluginModelBase, BundleStart> resolvedBundles;
		public final Map<IPluginModelBase, BundleStart> latestVersionsOnly;
		public final Map<Object, String> fModels;
		public final Map<String, Object> fAllBundles;
	}

	private static final String KEY_BUNDLES_TO_LAUNCH = "bundlesToLaunch";

	public static void setBundlesToLaunch(CachedInfo info,
			BundlesToLaunch bundles) {
		info.data.put(KEY_BUNDLES_TO_LAUNCH, bundles);
	}

	public static BundlesToLaunch getBundlesToLaunch(CachedInfo info) {
		return (BundlesToLaunch) info.data.get(KEY_BUNDLES_TO_LAUNCH);
	}

	private static IPluginModelBase[] getModels(IResolvedBundle bundle) {
		try {
			return new PDEState(new URL[] { new URL(String.format("file://%s",
					bundle.getBundleInfo().getLocation().getPath())) }, true,
					new NullProgressMonitor()).getTargetModels();
		} catch (MalformedURLException e) {
			log(status("Problem in resolving AUT bundle " + bundle, e));
			return new IPluginModelBase[0];
		}

	}

	private static Version version(IPluginModelBase plugin) {
		try {
			return new Version(plugin.getPluginBase().getVersion());
		} catch (IllegalArgumentException e) {
			return Version.emptyVersion;
		}
	}

	private void copyConfiguratonFiles(
			final ILaunchConfiguration configuration, CachedInfo info) {
		String targetPlatformPath = ((ITargetPlatformHelper) info.target)
				.getTargetPlatformProfilePath();
		File configFolder = new File(targetPlatformPath, "configuration"); //$NON-NLS-1$
		if (!configFolder.exists())
			return;

		Set<String> filter = new HashSet<String>(Arrays.asList(new String(
				".p2;" + //
						"org.eclipse.core.runtime;" //
						+ "org.eclipse.equinox.app;" //
						+ "org.eclipse.equinox.simpleconfigurator;" //
						+ "org.eclipse.equinox.source;" //
						+ "org.eclipse.osgi;" //
						+ "org.eclipse.ui.intro.universal;" //
						+ "org.eclipse.update;" //
						+ "config.ini;" //
						+ ".settings;" //
						+ "org.eclipse.help.base"//
		).split(";")));
		File target = getConfigDir(configuration);
		File[] listFiles = configFolder.listFiles();
		for (File file : listFiles) {
			if (!filter.contains(file.getName())) {
				if (file.isDirectory()) {
					FileUtil.copyFiles(file, new File(target, file.getName()));
				} else {
					FileUtil.copyFiles(file, target);
				}
			}
		}
	}
}