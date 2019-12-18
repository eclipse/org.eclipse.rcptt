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
package org.eclipse.rcptt.sherlock.core.info;

import java.util.Map;

public class SystemInfoProvider {
	private static final String PROPERTY_OS_NAME = "os.name";

	public static String getOSName() {
		return System.getProperty(PROPERTY_OS_NAME);
	}

	private static final String PROPERTY_OS_VERSION = "os.version";

	public static String getOSVersion() {
		return System.getProperty(PROPERTY_OS_VERSION);
	}

	private static final String PROPERTY_OS_ARCH = "os.arch";

	public static String getOSArch() {
		return System.getProperty(PROPERTY_OS_ARCH);
	}

	public static Map<String, String> getVariables() {
		return System.getenv();
	}

	private static final String PROPERTY_USER_NAME = "user.name";

	public static String getUsername() {
		return System.getProperty(PROPERTY_USER_NAME);
	}
}
