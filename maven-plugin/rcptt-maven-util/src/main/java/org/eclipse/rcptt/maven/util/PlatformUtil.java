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
package org.eclipse.rcptt.maven.util;

/**
 * Returns various parameters of the platform we are running on
 */
public class PlatformUtil {
	/**
	 * 
	 * @return The classifier of current platform in form of os.ws.arch
	 */
	public static String getEclipseClassifier() {
		return String.format("%s.%s", getOS().classifier, getArch());
	}

	public static String getArch() {
		String result = System.getProperty("os.arch");
		if (result.contains("64") || getOS() == OS.MACOSX) {
			return "x86_64";
		}
		return "x86";
	}

	public static OS getOS() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win")) {
			return OS.WIN;
		}
		if (osName.contains("mac")) {
			return OS.MACOSX;
		}
		return OS.LINUX;
	}
}
