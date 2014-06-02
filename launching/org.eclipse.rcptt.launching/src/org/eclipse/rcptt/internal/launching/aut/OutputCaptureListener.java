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
package org.eclipse.rcptt.internal.launching.aut;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;

import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchListener;
import org.eclipse.rcptt.launching.AutListener;
import org.eclipse.rcptt.launching.IQ7Launch;

public class OutputCaptureListener implements AutListener {

	public void autAdded(Aut aut) {
		// This class does not care about auts
	}

	public void autRemoved(Aut aut) {
		// This class does not care about auts
	}

	public void autChanged(Aut aut) {
		// This class does not care about auts
	}

	public void launchAdded(AutLaunch launch) {
		File logFile = getLogFile(launch);
		if (logFile == null) {
			return;
		}
		AutLaunchListener listener = new OutputCaptureLaunchListener(logFile);
		launch.addListener(listener);
		listener.stateChanged(launch, launch.getState());
	}

	public void launchRemoved(AutLaunch launch) {
		// We don't care about removals, as
		// OutputCaptureLaunchListener will
		// automatically close streams once aut
		// is terminated
	}

	/**
	 * Returns log file path from {@link IQ7Launch#ATTR_OUT_FILE} attribute.
	 * Exceptions caught while getting attribute are logged.
	 * 
	 * Also verifies that file can be written. If not, logs error
	 * 
	 * @param launch
	 * @return File or null if something goes wrong or attribute is not set
	 */
	private File getLogFile(AutLaunch launch) {
		try {
			String logFilePath = launch.getLaunch().getLaunchConfiguration()
					.getAttribute(IQ7Launch.ATTR_OUT_FILE, (String) null);
			if (logFilePath == null) {
				return null;
			}

			File result = new File(VariablesPlugin.getDefault()
					.getStringVariableManager()
					.performStringSubstitution(logFilePath));
			File resultDir = result.getParentFile();
			String error = null;

			if (resultDir == null) {
				error = String.format(
						"Output file location '%s' is not absolute",
						result.getAbsolutePath());
			} else if (resultDir.isFile()) {
				error = String.format("'%s' is not a directory",
						resultDir.getAbsolutePath());
			} else if (!resultDir.exists() && !resultDir.mkdirs()) {
				error = String.format(
						"Directory '%s' does not exist and cannot be created",
						resultDir.getAbsolutePath());
			} else if (!(result.exists() || result.createNewFile())
					|| !result.canWrite()) {
				error = String.format("Cannot write to '%s'",
						result.getAbsolutePath());
			}

			if (error != null) {
				Q7LaunchingPlugin.log(String.format(
						"Cannot create output file: %s", error));
				return null;
			}

			return result;
		} catch (CoreException e) {
			Q7LaunchingPlugin.log(e.getStatus());
		} catch (Exception e) {
			Q7LaunchingPlugin
					.log("Unexpected error while creating log file", e);
		}
		return null;
	}
}
