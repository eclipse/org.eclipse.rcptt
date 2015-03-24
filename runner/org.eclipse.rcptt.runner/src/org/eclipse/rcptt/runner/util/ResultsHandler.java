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
package org.eclipse.rcptt.runner.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.runner.HeadlessRunnerPlugin;
import org.eclipse.rcptt.runner.RunnerConfiguration;

public class ResultsHandler {

	// this field is synchronously accessed by TestsRunner for printing out
	// results
	public List<TestResult> results = new ArrayList<TestResult>();

	private Map<AutThread, Integer> timeoutCount = new HashMap<AutThread, Integer>();

	private RunnerConfiguration conf;
	private final boolean autRestartOnFailures;

	public ResultsHandler(RunnerConfiguration conf, boolean restartAUTOnFailures) {
		this.conf = conf;
		autRestartOnFailures = restartAUTOnFailures;
	}

	public void testCompleted(TestResult result, AutThread thread) throws CoreException, InterruptedException {
		Integer timeoutC = null;
		synchronized (results) {
			results.add(result.withAdditionalInfo(conf, thread));

			if (thread != null) {
				timeoutC = timeoutCount.get(thread);
				if (timeoutC == null) {
					timeoutC = Integer.valueOf(0);
				}
				if (result.timeout) {
					timeoutC = Integer.valueOf(timeoutC.intValue() + 1);
				} else {
					timeoutC = Integer.valueOf(0);
				}
				timeoutCount.put(thread, timeoutC);
			}
		}

		if (result.connectionUnavailable) {
			restartAutWithMessage(thread, "Connection to AUT is not available.");
		}
		else if (autRestartOnFailures && result.failed) {
			restartAutWithMessage(thread,
					"Test is failed and restartAUTOnFailure=true test option is specified.");
		}
		else if (timeoutC != null && timeoutC.intValue() >= conf.timeoutRestart) {
			timeoutCount.put(thread, Integer.valueOf(0));
			restartAutWithMessage(thread, "Possible AUT hang detected, "
					+ timeoutC.intValue()
					+ " tests are failed because of timeout.");
		}
	}

	private static void restartAutWithMessage(AutThread thread, String msg) throws CoreException, InterruptedException {
		log("\n\n" + msg + " Restarting AUT.\n\n", null);
		thread.restart();
	}

	static void log(String msg, Throwable e) {
		HeadlessRunnerPlugin.getDefault().info(msg, e);
		System.out.println(msg);
	}

}
