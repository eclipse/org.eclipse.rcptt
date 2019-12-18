/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.util;

public class NetworkUtils {
	private static final String JRE_CONNECT_TIMEOUT_PROPERTY = "sun.net.client.defaultConnectTimeout"; //$NON-NLS-1$
	private static final String JRE_READ_TIMEOUT_PROPERTY = "sun.net.client.defaultReadTimeout"; //$NON-NLS-1$

	public static void initTimeouts() {
		String existingTimeout = System
				.getProperty(JRE_CONNECT_TIMEOUT_PROPERTY);
		if (existingTimeout == null) {
			System.setProperty(JRE_CONNECT_TIMEOUT_PROPERTY,
					getConnectTimeout());
		}
		existingTimeout = System.getProperty(JRE_READ_TIMEOUT_PROPERTY);
		if (existingTimeout == null) {
			System.setProperty(JRE_READ_TIMEOUT_PROPERTY,
					"" + getSocketReadTimeout()); //$NON-NLS-1$
		}
	}

	private static String getSocketReadTimeout() {
		return "120000"; // 2 minutes to read timeout.
	}

	private static String getConnectTimeout() {
		return "60000"; // 60 seconds to establish connection.
	}

}
