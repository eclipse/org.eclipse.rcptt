/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.runner.util;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.launching.rap.IBrowserLaunchDelegate;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfig;
import org.eclipse.rcptt.runner.HeadlessRunnerPlugin;
import org.eclipse.swt.program.Program;

public class RunnerBrowserLaunchDelegate implements IBrowserLaunchDelegate {

	private static final String HTML_EXTENSION = "html";

	@Override
	public void launch(URL uri, RAPLaunchConfig config) throws CoreException {

		if (hasDefaultBrowser(config)) {
			openDefaultSystemBrowser(uri);
		} else {
			openCustomBrowserCommand(uri, config.getBrowserCommand());
		}
	}

	private void openCustomBrowserCommand(URL uri, String command) throws CoreException {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(String.format(command, uri.toString()));
		} catch (IOException e) {
			throwsOpenURLFailed(uri);
		}
	}

	private void openDefaultSystemBrowser(URL uri) throws CoreException {
		final Program program = Program.findProgram(HTML_EXTENSION);
		if (program != null) {
			if (program.execute(uri.toString())) {
				return;
			}
		}
		if (!Program.launch(uri.toString())) {
			throwsOpenURLFailed(uri);
		}
	}


	private static void throwsOpenURLFailed(URL uri) throws CoreException {
		final String message = String.format("Failed to open URL '%s' in browser.", uri);
		final Status fail = new Status(IStatus.ERROR, HeadlessRunnerPlugin.PLUGIN_ID, message);
		throw new CoreException(fail);
	}

	private static boolean hasDefaultBrowser(RAPLaunchConfig config) throws CoreException {
		return config.getBrowserCommand() == null;
	}

}
