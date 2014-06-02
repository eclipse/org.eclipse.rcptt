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
package org.eclipse.rcptt.ecl.client.tcp;

public class NetworkUtil {
	private static final String JRE_CONNECT_TIMEOUT_PROPERTY = "sun.net.client.defaultConnectTimeout"; //$NON-NLS-1$
	private static final String JRE_READ_TIMEOUT_PROPERTY = "sun.net.client.defaultReadTimeout"; //$NON-NLS-1$

	public static void initTimeouts() {
		setTimeout(JRE_CONNECT_TIMEOUT_PROPERTY, getConnectTimeout());
		setTimeout(JRE_READ_TIMEOUT_PROPERTY, getReadTimeout());
	}

	private static int getExistingTimeout(String propName) {
		String val = System.getProperty(propName, "-1");
		try {
			return Integer.parseInt(val);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void setTimeout(String prop, int val) {
		int existingTimeout = getExistingTimeout(prop);
		if (existingTimeout == -1) {
			EclTcpClientPlugin.logInfo("%s is not set. Setting to %d", prop, val);
		} else if (existingTimeout < val) {
			EclTcpClientPlugin.logInfo("%s is set to %d. Increasing to %d", prop, existingTimeout, val);
		}

		System.setProperty(prop, Integer.toString(val));
	}

	private static int getReadTimeout() {
		return 120000; // 2 minutes to read timeout.
	}

	private static int getConnectTimeout() {
		return 60000; // 60 seconds to establish connection.
	}
}
