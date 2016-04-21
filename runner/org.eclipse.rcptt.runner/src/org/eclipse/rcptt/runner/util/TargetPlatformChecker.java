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
package org.eclipse.rcptt.runner.util;

import static org.eclipse.rcptt.runner.HeadlessRunnerPlugin.PLUGIN_ID;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.ext.PDELocationUtils;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformInitializer;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformInitializer.Q7Info;
import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformManager;
import org.eclipse.rcptt.launching.injection.InjectionConfiguration;
import org.eclipse.rcptt.launching.injection.InjectionFactory;
import org.eclipse.rcptt.launching.injection.UpdateSite;
import org.eclipse.rcptt.launching.internal.target.PDEHelper;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.rcptt.launching.target.TargetPlatformManager;
import org.eclipse.rcptt.runner.PrintStreamMonitor;
import org.eclipse.rcptt.runner.Q7PluginValidator;
import org.eclipse.rcptt.runner.RunnerConfiguration;

public class TargetPlatformChecker {

	private final RunnerConfiguration conf;

	public TargetPlatformChecker(RunnerConfiguration conf) {
		this.conf = conf;
	}


	private ITargetPlatformHelper targetPlatform;

	public ITargetPlatformHelper getTargetPlatform() {
		return targetPlatform;
	}

	/**
	 * @return true, if the target platform is ok
	 * @throws CoreException
	 */
	public boolean initAndCheckTargetPlatform() throws CoreException {

		if (conf.location == null) {
			System.out.println("AUT location is not set");
			return false;
		}

		if (!PDELocationUtils.validateProductLocation(conf.location).isOK()) {
			System.out.println("AUT location doesn't exist: " + conf.location);
			return false;
		}

		System.out.println("Initializing target platform...");
		initializeTargetPlatform();
		System.out.println("Target platform is valid.");

		return true;
	}

	private void initializeTargetPlatform() throws CoreException {
		targetPlatform = null;
		String location = PDELocationUtils.getProductLocation(conf.location).getAbsolutePath();
		if (conf.config != null) {
			targetPlatform = TargetPlatformManager.createTargetPlatform(
					location, new PrintStreamMonitor());
			Map<String, Version> versions = targetPlatform.getVersions();
			Q7Info q7Info = Q7TargetPlatformInitializer.getInfo(targetPlatform, versions);
			if (!conf.onlySpecified) {
				IMetadataRepository repository = PDEHelper
						.safeLoadRepository(q7Info.q7,
								new PrintStreamMonitor());
				if (repository != null) {
					InjectionConfiguration configuration = Q7TargetPlatformInitializer
							.createInjectionConfiguration(
									new PrintStreamMonitor(), q7Info,
									versions);
					if (configuration != null) {
						conf.config.getEntries().addAll(
								configuration.getEntries());
					}
				}
			}
			else if (q7Info.aspectj != null) {
				UpdateSite aspectsSite = InjectionFactory.eINSTANCE.createUpdateSite();
				aspectsSite.setUri(q7Info.aspectj.toString());
				conf.config.getEntries().add(aspectsSite);
			}
			targetPlatform.setTargetName("AUT");
			IStatus rv = targetPlatform.applyInjection(conf.config, new PrintStreamMonitor());
			if (!rv.isOK())
				throw new CoreException(rv);
			if (targetPlatform.getWeavingHook() == null) {
				throw new CoreException(
						RcpttPlugin.createStatus("No org.eclipse.weaving hook plugin in target platform"));
			}
		} else { // Try to initialize using Q7 bundled runtime
			targetPlatform = Q7TargetPlatformManager.createTargetPlatform(
					location, new PrintStreamMonitor());
			targetPlatform.setTargetName("AUT");
		}
		targetPlatform.save();
		// Check for few core q7, tesla plugins are available.
		if (!Q7PluginValidator.validate(targetPlatform)) {
			throw new CoreException(new Status(IStatus.ERROR, PLUGIN_ID,
					"Target platform doesn't contain RCPTT runtime injected..."));
		}
	}

}
