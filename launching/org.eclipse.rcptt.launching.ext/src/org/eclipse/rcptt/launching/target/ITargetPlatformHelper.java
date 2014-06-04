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
package org.eclipse.rcptt.launching.target;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.internal.launching.ext.OSArchitecture;
import org.eclipse.rcptt.launching.ext.OriginalOrderProperties;
import org.eclipse.rcptt.launching.injection.InjectionConfiguration;
import org.eclipse.rcptt.launching.internal.target.Q7Target;

/**
 * Class designed to access target platform features to configure it via easy
 * way.
 */
public interface ITargetPlatformHelper {
	Q7Target getQ7Target();

	/**
	 * Check if platform are valid. Check target platform containers status
	 * message. If target platform are not resolved, method will return false.
	 * 
	 * @return - false if target platform is not resolved, or resulution status.
	 */
	boolean isValid();

	/**
	 * Return if target is already resolved.
	 * 
	 * @return
	 */
	boolean isResolved();

	/**
	 * Return error message of previous target platform resolution.
	 * 
	 * @return
	 */
	String getErrorMessage();

	/**
	 * Return warning message of previous target platform resulution.
	 */
	String getWarningMessage();

	/**
	 * Set target platform name.
	 * 
	 * @param string
	 */
	void setTargetName(String name);

	/**
	 * Save current target platform to PDE.
	 */
	void save();

	/**
	 * Return target platform name.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Return target platform profile path.
	 * 
	 * @return
	 */
	String getTargetPlatformProfilePath();

	/**
	 * Remove target platform from PDE.
	 */
	void delete();

	/**
	 * Validate bundles consistency. getErrorMessage() method could be used to
	 * retrive error if failed.
	 * 
	 * @param monitor
	 * @return
	 */
	boolean validateBundles(IProgressMonitor monitor);

	/**
	 * Return list of available applications to target platform. If platform is
	 * not resolved, will return empty list.
	 * 
	 * @return
	 */
	String[] getApplications();

	/**
	 * Return list of available products to target platform. If platform is not
	 * resolved, will return empty list.
	 * 
	 * @return
	 */
	String[] getProducts();

	/**
	 * Return currently set default target platform application. Will read
	 * configuration file for this purpose.
	 * 
	 * @return
	 */
	String getDefaultApplication();

	/**
	 * Return currently set default target platform product. Will read
	 * configuration file for this purpose.
	 * 
	 * @return
	 */
	String getDefaultProduct();

	/**
	 * Will modify target platform with specified injection configuration.
	 * 
	 * Will remove previously added configuration injection.
	 * 
	 * @param configuration
	 * @return
	 */
	boolean applyInjection(InjectionConfiguration configuration,
			IProgressMonitor monitor);

	/**
	 * Get initial vmargs readed from eclipse.ini of target platform.
	 */
	String getIniVMArgs();

	String getVmFromIniFile();

	String getTemplateConfigLocation();

	String getBundlesList();

	OriginalOrderProperties getConfigIniProperties();

	/**
	 * Returns {@link InjectionConfiguration} set with previous
	 * {@link #applyInjection(InjectionConfiguration, IProgressMonitor)}
	 * invocation. Can be null if no injection has been applied
	 * 
	 * @return
	 */
	InjectionConfiguration getInjectConfig();

	OSArchitecture detectArchitecture(boolean preferCurrentVmArchitecture,
			StringBuilder detectMsg);

	String getRuntimeVersion();

	IStatus resolve(IProgressMonitor monitor);

	String getEquinoxStartupPath(String bundleEquinoxLauncher);
}
