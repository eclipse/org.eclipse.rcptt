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
package org.eclipse.rcptt.launching.configuration;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.core.target.TargetBundle;
import org.eclipse.pde.launching.EclipseApplicationLaunchConfiguration;
import org.eclipse.rcptt.internal.launching.aut.LaunchInfoCache;
import org.eclipse.rcptt.internal.launching.ext.AJConstants;
import org.eclipse.rcptt.internal.launching.ext.IBundlePoolConstansts;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchMonitor;
import org.eclipse.rcptt.internal.launching.ext.Q7ExtLaunchingPlugin;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformInitializer;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformManager;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.events.AutEventManager;
import org.eclipse.rcptt.launching.ext.BundleStart;
import org.eclipse.rcptt.launching.ext.OriginalOrderProperties;
import org.eclipse.rcptt.launching.ext.Q7ExternalLaunchDelegate;
import org.eclipse.rcptt.launching.ext.Q7LaunchDelegateUtils;
import org.eclipse.rcptt.launching.internal.target.TargetPlatformHelper;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.rcptt.launching.target.TargetPlatformManager;
import org.eclipse.rcptt.tesla.core.TeslaLimits;

@SuppressWarnings("restriction")
public class Q7LaunchConfigurationDelegate extends
		EclipseApplicationLaunchConfiguration {
	private static final String SECURE_STORAGE_FILE_NAME = "secure_storage";

	// private Map<String, Object> fAllBundles;
	// private Map<Object, String> fModels;
	// private TargetPlatformHelper targetPlatform;
	private ILaunch launch;

	private ILaunchConfiguration getTargetConfiguration(
			ILaunchConfiguration configuration) throws CoreException {
		return LaunchConfigurationUtils.findLaunchConfiguration(
				configuration.getAttribute(Activator.TARGET_CONFIGURATION, ""),
				Activator.PDE_LAUNCH_CONFIG_ID);
	}

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		this.launch = launch;

		monitor.beginTask("", 2); //$NON-NLS-1$
		Q7ExtLaunchMonitor waiter = new Q7ExtLaunchMonitor(launch);
		try {
			ILaunchConfiguration targetConfig = getTargetConfiguration(configuration);
			String targetConfigName = targetConfig.getName();
			ILaunchConfigurationWorkingCopy configurationWc = configuration
					.getWorkingCopy();

			configurationWc.setAttributes(targetConfig.getAttributes());
			configurationWc.setAttribute(Activator.TARGET_CONFIGURATION,
					targetConfigName);
			configurationWc.doSave();
			super.launch(configuration, mode, launch,
					SubMonitor.convert(monitor, 1));
			waiter.wait(monitor, TeslaLimits.getAUTStartupTimeout() / 1000);
		} catch (CoreException e) {
			waiter.handle(e);
			// no need to throw exception in case of cancel
			if (e.getStatus().getSeverity() != IStatus.CANCEL) {
				throw e;
			}
		} catch (RuntimeException e) {
			waiter.handle(e);
			throw e;
		} finally {
			waiter.dispose();
		}
		monitor.done();
	}

	@Override
	protected void manageLaunch(ILaunch launch) {
		// remove base PDE launch management
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		try {
			Job.getJobManager().join(
					IBundlePoolConstansts.CLEAN_BUNDLE_POOL_JOB,
					new SubProgressMonitor(monitor, 1));
		} catch (Exception e1) {
			Q7ExtLaunchingPlugin.status(
					"Failed to wait for bundle pool clear job", e1);
		}

		LaunchInfoCache.CachedInfo info = LaunchInfoCache.getInfo(configuration);

		String targetName = configuration.getName() + " with RCPTT";
		ITargetPlatformHelper helper = Q7TargetPlatformManager
				.getHelper(targetName);

		// try to load existing configuration
		if (helper == null) {
			helper = TargetPlatformManager.findTarget(targetName,
					new SubProgressMonitor(monitor, 1), false);
			if (helper != null) {
				if (!helper.isResolved()) {
					helper.resolve(monitor);
					if (helper.getStatus().isOK()) {
						Q7TargetPlatformManager.setHelper(targetName, helper);
					}
				}
			}
		}

		if (helper == null
				|| ((TargetPlatformHelper) helper).getTarget() == null) {
			helper = TargetPlatformManager
					.getCurrentTargetPlatformCopy(targetName);
			helper.resolve(monitor);
			IStatus rv = Q7TargetPlatformInitializer.initialize(helper, monitor);
			if (!rv.isOK())
				Activator.getDefault().getLog().log(rv);
			helper.save();
			Q7TargetPlatformManager.setHelper(targetName, helper);
		}
		if (helper != null) {
			info.target = helper;
		}

		return super.preLaunchCheck(configuration, mode, monitor);
	}

	@Override
	public String[] getVMArguments(ILaunchConfiguration config)
			throws CoreException {
		LaunchInfoCache.CachedInfo info = LaunchInfoCache.getInfo(config);
		List<String> args = new ArrayList<String>(Arrays.asList(super
				.getVMArguments(config)));

		args.add("-Dq7id=" + launch.getAttribute(IQ7Launch.ATTR_AUT_ID));
		args.add("-Dq7EclPort=" + AutEventManager.INSTANCE.getPort());

		IPluginModelBase hook = ((TargetPlatformHelper) info.target)
				.getWeavingHook();
		if (hook == null) {
			throw new CoreException(Q7ExtLaunchingPlugin.status("No "
					+ AJConstants.HOOK + " plugin"));
		}

		args.add("-Dosgi.framework.extensions=reference:file:"
				+ hook.getInstallLocation());
		info.vmArgs = (String[]) args.toArray(new String[args.size()]);
		return info.vmArgs;
	}

	@Override
	public String[] getProgramArguments(ILaunchConfiguration configuration)
			throws CoreException {
		LaunchInfoCache.CachedInfo info = LaunchInfoCache.getInfo(configuration);
		if (info.programArgs != null) {
			return info.programArgs;
		}

		ArrayList<String> programArgs = new ArrayList<String>();

		programArgs.addAll(Arrays.asList(super
				.getProgramArguments(configuration)));

		try {
			// Correct osgi.install.area property key
			File config = new File(getConfigDir(configuration), "config.ini");
			OriginalOrderProperties props = new OriginalOrderProperties();

			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(config));
			props.load(in);
			in.close();

			String targetPlatformProfilePath = ((ITargetPlatformHelper) info.target)
					.getTargetPlatformProfilePath();
			if (targetPlatformProfilePath != null) {
				props.setProperty("osgi.install.area",
						targetPlatformProfilePath);
			}
			props.setProperty("osgi.bundles", Q7LaunchDelegateUtils
					.computeOSGiBundles(Q7ExternalLaunchDelegate
							.getBundlesToLaunch(info).latestVersionsOnly));

			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(config));
			props.store(out, "Configuration File");
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
		info.programArgs = programArgs.toArray(new String[programArgs.size()]);
		return programArgs.toArray(new String[programArgs.size()]);
	}

	@Override
	protected void preLaunchCheck(final ILaunchConfiguration configuration,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		super.preLaunchCheck(configuration, launch, monitor);
		if (monitor.isCanceled()) {
			return;
		}
		LaunchInfoCache.CachedInfo info = LaunchInfoCache.getInfo(configuration);

		TargetPlatformHelper target = (TargetPlatformHelper) info.target;

		Q7ExternalLaunchDelegate.BundlesToLaunchCollector collector = new Q7ExternalLaunchDelegate.BundlesToLaunchCollector();

		for (Entry<IPluginModelBase, String> entry : Q7LaunchDelegateUtils
				.getEclipseApplicationModels(this).entrySet()) {
			collector.addInstallationBundle(entry.getKey(),
					BundleStart.fromModelString(entry.getValue()));
		}
		for (ITargetLocation extra : target.getTarget().getTargetLocations()) {
			if (!Q7ExternalLaunchDelegate.isQ7BundleContainer(extra)) {
				continue;
			}
			for (TargetBundle bundle : extra.getBundles()) {
				collector.addExtraBundle(bundle);
			}
		}

		Q7ExternalLaunchDelegate.BundlesToLaunch bundles = collector.getResult();

		Q7ExternalLaunchDelegate.setBundlesToLaunch(info, bundles);

		Q7LaunchDelegateUtils.setDelegateFields(this, bundles.fModels, bundles.fAllBundles);
	}
}
