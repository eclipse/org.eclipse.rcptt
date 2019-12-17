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

import org.eclipse.core.runtime.CoreException;

public final class URLBuilder {

	private static final String EMPTY = ""; //$NON-NLS-1$
	static final String SLASH = "/"; //$NON-NLS-1$

	private static final String PROTOCOL = "http"; //$NON-NLS-1$
	private static final String HOST = "127.0.0.1"; //$NON-NLS-1$

	public static String getHost() {
		return HOST;
	}

	public static String fromLaunchConfig(RAPLaunchConfig config, int port, boolean testMode)
			throws CoreException {
		return fromLaunchConfig(config, Integer.toString(port), testMode);
	}

	public static String fromLaunchConfig(RAPLaunchConfig config, String port, boolean testMode)
			throws CoreException {
		String path = getUrlPath(config);
		return PROTOCOL + "://" + HOST + ":" + port + path;
	}

	private static String getUrlPath(RAPLaunchConfig config) throws CoreException {
		String contextPath = getContextPath(config);
		String servletPath = getServletPath(config);
		StringBuffer buffer = new StringBuffer();
		buffer.append(SLASH);
		if (!EMPTY.equals(contextPath)) {
			buffer.append(contextPath);
			buffer.append(SLASH);
		}
		buffer.append(servletPath);
		return buffer.toString();
	}

	private static String getServletPath(RAPLaunchConfig config) throws CoreException {
		String servletPath = config.getServletPath();
		return stripLeadingAndTrailingSlashes(servletPath);
	}

	private static String getContextPath(RAPLaunchConfig config) throws CoreException {
		String contextPath = "";
		if (config.getUseManualContextPath()) {
			contextPath = config.getContextPath();
		}
		return stripLeadingAndTrailingSlashes(contextPath);
	}

	private static String stripLeadingAndTrailingSlashes(String input) {
		String result = input;
		if (result.startsWith(SLASH)) {
			result = result.substring(1);
		}
		if (result.endsWith(SLASH)) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	private URLBuilder() {
		// prevent instantiation
	}
}