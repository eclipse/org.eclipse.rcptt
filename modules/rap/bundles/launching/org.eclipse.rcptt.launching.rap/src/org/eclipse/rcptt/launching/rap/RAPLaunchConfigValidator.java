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

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;

public class RAPLaunchConfigValidator {

	public static final int ERR_SERVLET_PATH = 6001;
	public static final int ERR_PORT = 6004;
	public static final int ERR_URL = 6005;
	public static final int ERR_TIMEOUT = 6007;
	public static final int ERR_ENTRY_POINT = 6008;
	public static final int ERR_SERVLET_BUNDLE = 6009;
	public static final int ERR_DATA_LOCATION = 6010;
	public static final int ERR_CONTEXT_PATH = 6011;
	public static final int ERR_SERVLET_PATH_LEADING_SLASH = 60012;
	public static final int ERR_SERVLET_PATH_INVALID = 60013;
	public static final int ERR_CONTEXT_PATH_LEADING_SLASH = 60014;
	public static final int WARN_OSGI_FRAMEWORK = 7002;
	public static final int WARN_WS_WRONG = 7003;
	private static final String RAP_LAUNCH_CONFIG_TYPE = "org.eclipse.rap.ui.launch.RAPLauncher"; //$NON-NLS-1$
	private static final String EMPTY = ""; //$NON-NLS-1$

	private final RAPLaunchConfig config;

	public RAPLaunchConfigValidator(final RAPLaunchConfig config) {
		this.config = config;
	}

	public IStatus[] validate() {
		List<IStatus> states = new ArrayList<IStatus>();
		try {
			addNonOKState(states, validateServletPath());
			addNonOKState(states, validatePort());
			addNonOKState(states, validateUniquePort());
			addNonOKState(states, validateContextPath());
			addNonOKState(states, validateURL());
			addNonOKState(states, validateSessionTimeout());
			addNonOKState(states, validateDataLocation());
		} catch (CoreException e) {
			String text = "An error occured while validating the launch configuration: {0}";
			Object[] args = new Object[] { e.getLocalizedMessage() };
			String msg = MessageFormat.format(text, args);
			states.add(createError(msg, 0, e));
		}
		IStatus[] result = new IStatus[states.size()];
		states.toArray(result);
		return result;
	}

	/////////////////////
	// Validation methods

	private IStatus validateDataLocation() throws CoreException {
		IStatus result = Status.OK_STATUS;
		String dataLocation = config.getDataLocation();
		if (dataLocation == null || dataLocation.length() == 0) {
			String msg = "Instance Area must not be empty.";
			result = createError(msg, ERR_DATA_LOCATION, null);
		}
		return result;
	}

	private IStatus validateServletPath() throws CoreException {
		IStatus result = Status.OK_STATUS;
		if (config.getOpenBrowser()) {
			String servletPath = config.getServletPath();
			if (servletPath == null || EMPTY.equals(servletPath)) {
				String msg = "The servlet path must not be empty";
				result = createError(msg, ERR_SERVLET_PATH, null);
			} else if (!servletPath.startsWith("/")) {
				String msg = "The servlet path must start with a slash.";
				result = createError(msg, ERR_SERVLET_PATH_LEADING_SLASH, null);
			} else if (containsChars(servletPath.substring(1), new char[] { '*', '/', '\\' })) {
				String msg = "The servlet path contains invalid characters.";
				result = createError(msg, ERR_SERVLET_PATH_INVALID, null);
			}
		}
		return result;
	}

	private static boolean containsChars(String string, char[] chars) {
		boolean hasInvalidChar = false;
		String pattern = new String(chars);
		for (int i = 0; !hasInvalidChar && i < string.length(); i++) {
			if (pattern.indexOf(string.charAt(i)) != -1) {
				hasInvalidChar = true;
			}
		}
		return hasInvalidChar;
	}

	private IStatus validateContextPath() throws CoreException {
		IStatus result = Status.OK_STATUS;
		if (config.getUseManualContextPath()) {
			String contextPath = config.getContextPath();
			if (!contextPath.startsWith("/")) {
				String msg = "The context path must start with a slash.";
				result = createError(msg, ERR_CONTEXT_PATH_LEADING_SLASH, null);
			} else if (!isValidContextPath(contextPath)) {
				String unformatedMsg = "The context path contains invalid characters.";
				String msg = MessageFormat.format(unformatedMsg, new Object[] { contextPath });
				result = createError(msg, ERR_CONTEXT_PATH, null);
			}
		}
		return result;
	}

	private boolean isValidContextPath(String contextPath) {
		boolean result = true;
		int length = contextPath.length();
		if (contextPath.indexOf("//") != -1) {
			result = false;
		}
		for (int i = 0; i < length && result; i++) {
			char ch = contextPath.charAt(i);
			boolean isLetterOrDigit = Character.isLetterOrDigit(ch);
			boolean isValidSpecialChar = "/_-.".indexOf(ch) != -1;
			if (!isLetterOrDigit && !isValidSpecialChar) {
				result = false;
			}
		}
		return result;
	}

	private IStatus validatePort() throws CoreException {
		IStatus result = Status.OK_STATUS;
		if (config.getUseManualPort()) {
			int port = config.getPort();
			if (port < RAPLaunchConfig.MIN_PORT_NUMBER || port > RAPLaunchConfig.MAX_PORT_NUMBER) {
				String text = "Port number must be between {0} and {1}";
				Object[] args = new Object[] {
						new Integer(RAPLaunchConfig.MIN_PORT_NUMBER),
						new Integer(RAPLaunchConfig.MAX_PORT_NUMBER)
				};
				String msg = MessageFormat.format(text, args);
				result = createError(msg, ERR_PORT, null);
			}
		}
		return result;
	}

	private IStatus validateUniquePort() throws CoreException {
		IStatus result = Status.OK_STATUS;
		if (config.getUseManualPort()) {
			RAPLaunchConfig duplicate = null;
			ILaunchConfiguration[] launchConfigs = getLaunchConfigs();
			for (int i = 0; duplicate == null && i < launchConfigs.length; i++) {
				RAPLaunchConfig otherConfig = new RAPLaunchConfig(launchConfigs[i]);
				if (hasSamePort(otherConfig)) {
					duplicate = otherConfig;
				}
			}
			if (duplicate != null) {
				String text = "The port {0,number,\\#} is already used by {1}";
				Object[] args = new Object[] {
						new Integer(config.getPort()),
						duplicate.getName()
				};
				String msg = MessageFormat.format(text, args);
				result = createWarning(msg, 0, null);
			}
		}
		return result;
	}

	private IStatus validateURL() throws CoreException {
		IStatus result = Status.OK_STATUS;
		try {
			String url = URLBuilder.fromLaunchConfig(config, 80, false);
			new URI(url);
		} catch (URISyntaxException exception) {
			String text = "Servlet path and/or context path cause a malformed URL.";
			result = createError(text, ERR_URL, exception);
		}
		return result;
	}

	private IStatus validateSessionTimeout() throws CoreException {
		IStatus result = Status.OK_STATUS;
		boolean isValid = config.getSessionTimeout() >= RAPLaunchConfig.MIN_SESSION_TIMEOUT;
		if (!isValid) {
			String msg = "Session timeout value must be a non-negative integer number.";
			result = createError(msg, ERR_TIMEOUT, null);
		}
		return result;
	}

	private void addNonOKState(List<IStatus> states, IStatus state) {
		if (state != null && !state.isOK()) {
			states.add(state);
		}
	}

	private IStatus createWarning(String msg, int code, Throwable thr) {
		String pluginId = Activator.PLUGIN_ID;
		return new Status(IStatus.WARNING, pluginId, code, msg, thr);
	}

	private IStatus createError(String msg, int code, Throwable thr) {
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, code, msg, thr);
	}

	private static ILaunchConfiguration[] getLaunchConfigs() throws CoreException {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = launchManager.getLaunchConfigurationType(RAP_LAUNCH_CONFIG_TYPE);
		return launchManager.getLaunchConfigurations(type);
	}

	private boolean hasSamePort(RAPLaunchConfig otherConfig) throws CoreException {
		return otherConfig.getUseManualPort()
				&& !config.getName().equals(otherConfig.getName())
				&& config.getPort() == otherConfig.getPort();
	}

}
