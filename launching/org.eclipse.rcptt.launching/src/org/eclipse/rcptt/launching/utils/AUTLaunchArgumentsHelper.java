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
package org.eclipse.rcptt.launching.utils;

import org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper;

@SuppressWarnings("restriction")
public class AUTLaunchArgumentsHelper extends LaunchArgumentsHelper {

	public static String getInitialProgramArguments(String autArchName) {
		String programArgs = LaunchArgumentsHelper.getInitialProgramArguments().trim();
		if (programArgs.contains("${target.arch}")) {
			programArgs = programArgs.replace("${target.arch}",
					autArchName);
		} else {
			if (programArgs.contains("-arch")) {
				int pos = programArgs.indexOf("-arch ") + 6;
				int len = 6;
				int pos2 = programArgs.indexOf("x86_64", pos);
				if (pos2 == -1) {
					len = 3;
					pos2 = programArgs.indexOf("x86", pos);
				}
				if (pos2 != -1) {
					programArgs = programArgs.substring(0, pos)
							+ autArchName
							+ programArgs.substring(pos2 + len,
									programArgs.length());
				}
			} else {
				programArgs = programArgs + " -arch " + autArchName;
			}
		}

		// We shouldn't set default "nl" arguments as their priority is higher,
		// than at "osgi.nl" in VM arguments
		programArgs = programArgs.replace(" -nl ${target.nl}", "");
		return programArgs;
	}

}
