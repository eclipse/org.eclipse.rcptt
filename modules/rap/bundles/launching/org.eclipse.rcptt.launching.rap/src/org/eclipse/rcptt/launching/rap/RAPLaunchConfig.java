/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2019 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * https://www.eclipse.org/legal/epl-v20.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.launching.rap;

import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.pde.launching.IPDELauncherConstants;

public final class RAPLaunchConfig {

	public static final int MIN_PORT_NUMBER = 0;
	public static final int MAX_PORT_NUMBER = 65535;
	public static final int MIN_SESSION_TIMEOUT = 0;
	public static final int MAX_SESSION_TIMEOUT = Integer.MAX_VALUE;

	// Launch configuration attribute names
	private static final String PREFIX = "org.eclipse.rap.launch."; //$NON-NLS-1$
	public static final String SERVLET_PATH = PREFIX + "servletPath"; //$NON-NLS-1$
	public static final String BROWSER_COMMAND = PREFIX + "browserCommand"; //$NON-NLS-1$
	public static final String OPEN_BROWSER = PREFIX + "openBrowser"; //$NON-NLS-1$
	public static final String BROWSER_MODE = PREFIX + "browserMode"; //$NON-NLS-1$
	public static final String PORT = PREFIX + "port"; //$NON-NLS-1$
	public static final String USE_MANUAL_PORT = PREFIX + "useManualPort"; //$NON-NLS-1$
	public static final String CONTEXTPATH = PREFIX + "contextpath"; //$NON-NLS-1$
	public static final String USE_MANUAL_CONTEXTPATH = PREFIX + "useManualContextPath"; //$NON-NLS-1$
	public static final String SESSION_TIMEOUT = PREFIX + "sessionTimeout"; //$NON-NLS-1$
	public static final String USE_SESSION_TIMEOUT = PREFIX + "useSessionTimeout"; //$NON-NLS-1$
	public static final String DEVELOPMENT_MODE = PREFIX + "developmentMode"; //$NON-NLS-1$
	public static final String USE_DEFAULT_DATA_LOCATION = PREFIX + "useDefaultDataLocation"; //$NON-NLS-1$
	public static final String DATA_LOCATION = PREFIX + "dataLocation"; //$NON-NLS-1$

	// Default values for launch configuration attribute names
	private static final String DEFAULT_SERVLET_PATH = "/"; //$NON-NLS-1$
	private static final BrowserMode DEFAULT_BROWSER_MODE = BrowserMode.EXTERNAL;
	private static final int DEFAULT_PORT = 10080;
	private static final boolean DEFAULT_USE_MANUAL_PORT = true;
	private static final String DEFAULT_CONTEXTPATH = "/";
	private static final boolean DEFAULT_USE_MANUAL_CONTEXTPATH = false;
	private static final int DEFAULT_SESSION_TIMEOUT = MIN_SESSION_TIMEOUT;
	private static final boolean DEFAULT_USE_SESSION_TIMEOUT = false;
	private static final String DEFAULT_DATA_LOCATION = "${workspace_loc}/.metadata/.plugins/"; //$NON-NLS-1$

	public static void setDefaults(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(SERVLET_PATH, DEFAULT_SERVLET_PATH);
		config.setAttribute(BROWSER_MODE, DEFAULT_BROWSER_MODE.getName());
		config.setAttribute(PORT, DEFAULT_PORT);
		config.setAttribute(USE_MANUAL_PORT, DEFAULT_USE_MANUAL_PORT);
		config.setAttribute(CONTEXTPATH, DEFAULT_CONTEXTPATH);
		config.setAttribute(USE_MANUAL_CONTEXTPATH, DEFAULT_USE_MANUAL_CONTEXTPATH);
		config.setAttribute(SESSION_TIMEOUT, DEFAULT_SESSION_TIMEOUT);
		config.setAttribute(USE_SESSION_TIMEOUT, DEFAULT_USE_SESSION_TIMEOUT);
		config.setAttribute(DEVELOPMENT_MODE, false);
		config.setAttribute(USE_DEFAULT_DATA_LOCATION, true);
		config.setAttribute(IPDELauncherConstants.DOCLEAR, false);
		config.setAttribute(IPDELauncherConstants.ASKCLEAR, false);
		String defaultDataLocation = getDefaultDataLocation(config.getName());
		config.setAttribute(DATA_LOCATION, defaultDataLocation);
		config.setAttribute(BROWSER_COMMAND, (String) null);
	}

	public static String getDefaultDataLocation(String name) {
		return DEFAULT_DATA_LOCATION + Activator.PLUGIN_ID + "/" + name.replaceAll("\\s", "");
	}

	private final ILaunchConfiguration config;
	private final ILaunchConfigurationWorkingCopy workingCopy;

	public RAPLaunchConfig(ILaunchConfiguration config) {
		this.config = config;
		if (config instanceof ILaunchConfigurationWorkingCopy) {
			workingCopy = (ILaunchConfigurationWorkingCopy) config;
		} else {
			workingCopy = null;
		}
	}

	public String getName() {
		return config.getName();
	}

	public ILaunchConfiguration getUnderlyingLaunchConfig() {
		return config;
	}

	public String getBrowserCommand() throws CoreException {
		return config.getAttribute(BROWSER_COMMAND, (String) null);
	}

	public void setBrowserCommand(String cmd) {
		checkWorkingCopy();
		workingCopy.setAttribute(BROWSER_COMMAND, cmd);
	}

	public boolean getAskClearDataLocation() throws CoreException {
		return config.getAttribute(IPDELauncherConstants.ASKCLEAR, false);
	}

	public void setAskClearDataLocation(boolean askClear) {
		checkWorkingCopy();
		workingCopy.setAttribute(IPDELauncherConstants.ASKCLEAR, askClear);
	}

	public boolean getDoClearDataLocation() throws CoreException {
		return config.getAttribute(IPDELauncherConstants.DOCLEAR, false);
	}

	public void setDoClearDataLocation(boolean doClear) {
		checkWorkingCopy();
		workingCopy.setAttribute(IPDELauncherConstants.DOCLEAR, doClear);
	}

	public boolean getUseDefaultDatatLocation() throws CoreException {
		return config.getAttribute(USE_DEFAULT_DATA_LOCATION, true);
	}

	public void setUseDefaultDataLocation(boolean useDefaultDataLocation) {
		checkWorkingCopy();
		workingCopy.setAttribute(USE_DEFAULT_DATA_LOCATION, useDefaultDataLocation);
	}

	public String getDataLocation() throws CoreException {
		return config.getAttribute(DATA_LOCATION, getDefaultDataLocation(getName()));
	}

	public void setDataLocation(String dataLocation) {
		if (dataLocation == null) {
			throw new NullPointerException("dataLocation"); //$NON-NLS-1$
		}
		checkWorkingCopy();
		workingCopy.setAttribute(DATA_LOCATION, dataLocation);
	}

	public String getServletPath() throws CoreException {
		return config.getAttribute(SERVLET_PATH, DEFAULT_SERVLET_PATH);
	}

	public void setServletPath(String servletPath) {
		if (servletPath == null) {
			throw new NullPointerException("servletPath"); //$NON-NLS-1$
		}
		checkWorkingCopy();

		if (!servletPath.startsWith("/")) {
			servletPath = "/" + servletPath;
		}

		workingCopy.setAttribute(SERVLET_PATH, servletPath);
	}

	public boolean getOpenBrowser() throws CoreException {
		return config.getAttribute(OPEN_BROWSER, true);
	}

	public void setOpenBrowser(boolean openBrowser) {
		checkWorkingCopy();
		workingCopy.setAttribute(OPEN_BROWSER, openBrowser);
	}

	public BrowserMode getBrowserMode() throws CoreException {
		String value = config.getAttribute(BROWSER_MODE, BrowserMode.INTERNAL.getName());
		return BrowserMode.parse(value);
	}

	public void setBrowserMode(BrowserMode browserMode) {
		checkWorkingCopy();
		workingCopy.setAttribute(BROWSER_MODE, browserMode.getName());
	}

	public boolean getUseManualPort() throws CoreException {
		// If not specified, return false instead of the default value (true) to
		// remain backwards compatible
		return config.getAttribute(USE_MANUAL_PORT, DEFAULT_USE_MANUAL_PORT);
	}

	public void setUseManualPort(boolean useManualPort) {
		checkWorkingCopy();
		workingCopy.setAttribute(USE_MANUAL_PORT, useManualPort);
	}

	public int getPort() throws CoreException {
		return config.getAttribute(PORT, DEFAULT_PORT);
	}

	public void setPort(int port) {
		checkWorkingCopy();
		workingCopy.setAttribute(PORT, port);
	}

	public boolean getUseManualContextPath() throws CoreException {
		return config.getAttribute(USE_MANUAL_CONTEXTPATH, DEFAULT_USE_MANUAL_CONTEXTPATH);
	}

	public void setUseManualContextPath(boolean useManualContextPath) {
		checkWorkingCopy();
		workingCopy.setAttribute(USE_MANUAL_CONTEXTPATH, useManualContextPath);
	}

	public String getContextPath() throws CoreException {
		return config.getAttribute(CONTEXTPATH, DEFAULT_CONTEXTPATH);
	}

	public void setContextPath(String contextPath) {
		if (contextPath == null) {
			throw new NullPointerException("contextPath"); //$NON-NLS-1$
		}
		checkWorkingCopy();
		workingCopy.setAttribute(CONTEXTPATH, contextPath);
	}

	public boolean getUseSessionTimeout() throws CoreException {
		return config.getAttribute(USE_SESSION_TIMEOUT, DEFAULT_USE_SESSION_TIMEOUT);
	}

	public void setUseSessionTimeout(boolean useSessionTimeout) {
		checkWorkingCopy();
		workingCopy.setAttribute(USE_SESSION_TIMEOUT, useSessionTimeout);
	}

	public int getSessionTimeout() throws CoreException {
		return config.getAttribute(SESSION_TIMEOUT, DEFAULT_SESSION_TIMEOUT);
	}

	public void setSessionTimeout(int timeout) {
		checkWorkingCopy();
		workingCopy.setAttribute(SESSION_TIMEOUT, timeout);
	}

	public boolean getDevelopmentMode() throws CoreException {
		return config.getAttribute(DEVELOPMENT_MODE, false);
	}

	public void setDevelopmentMode(boolean developmentMode) {
		checkWorkingCopy();
		workingCopy.setAttribute(DEVELOPMENT_MODE, developmentMode);
	}

	private void checkWorkingCopy() {
		if (workingCopy == null) {
			String msg = "Launch configuration cannot be modified, no working copy available"; //$NON-NLS-1$
			throw new IllegalStateException(msg);
		}
	}

	public static final class BrowserMode {

		public static final BrowserMode INTERNAL = new BrowserMode("INTERNAL"); //$NON-NLS-1$
		public static final BrowserMode EXTERNAL = new BrowserMode("EXTERNAL"); //$NON-NLS-1$

		private final String name;

		private BrowserMode(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return name;
		}

		public static BrowserMode[] values() {
			return new BrowserMode[] { INTERNAL, EXTERNAL };
		}

		public static BrowserMode parse(String name) {
			BrowserMode result = null;
			BrowserMode[] knownValues = values();
			for (int i = 0; result == null && i < knownValues.length; i++) {
				if (knownValues[i].getName().equalsIgnoreCase(name)) {
					result = knownValues[i];
				}
			}
			if (result == null) {
				String text = "Unknown BrowserMode ''{0}''."; //$NON-NLS-1$
				String msg = MessageFormat.format(text, new Object[] { name });
				throw new IllegalArgumentException(msg);
			}
			return result;
		}

	}

}
