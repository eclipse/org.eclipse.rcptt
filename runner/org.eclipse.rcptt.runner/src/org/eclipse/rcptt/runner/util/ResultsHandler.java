/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
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
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.runner.HeadlessRunnerPlugin;
import org.eclipse.rcptt.runner.RunnerConfiguration;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;

public class ResultsHandler {

	// this field is synchronously accessed by TestsRunner for printing out
	// results
	public List<TestResult> results = new ArrayList<TestResult>();

	private Multiset<AutThread> timeoutCount = HashMultiset.create();
	private Multiset<AutThread> retryCount = HashMultiset.create();

	private RunnerConfiguration conf;
	private final boolean autRestartOnFailures;

	/** These error messages appear erratically on Hudson. Retrying the test is likely to succeed. */
	private static final Set<String> RETRY_REASONS = ImmutableSet.of("Connection reset",
			ReportMaker.FAILED_TO_CLOSE_REPORT_NODE);

	public ResultsHandler(RunnerConfiguration conf, boolean restartAUTOnFailures) {
		this.conf = conf;
		autRestartOnFailures = restartAUTOnFailures;
	}

	public void testCompleted(TestResult result, AutThread thread) throws CoreException, InterruptedException {
		synchronized (results) {
			if (RETRY_REASONS.contains(result.reason) && retryCount.count(thread) < conf.connectionResetRetry) {
				thread.retry();
				retryCount.add(thread);
				log(String.format("\nRetry %d of %d\n", retryCount.count(thread), conf.connectionResetRetry), null);
				thread.restart();
				return;
			} else {
				retryCount.setCount(thread, 0);
				results.add(result.withAdditionalInfo(conf, thread));
			}

			if (result.timeout) {
				timeoutCount.add(thread);
			} else {
				timeoutCount.setCount(thread, 0);
			}
		}

		if (result.connectionUnavailable) {
			restartAutWithMessage(thread, "Connection to AUT is not available.");
		} else if (autRestartOnFailures && result.failed) {
			restartAutWithMessage(thread,
					"Test is failed and restartAUTOnFailure=true test option is specified.");
		} else if (timeoutCount.count(thread) >= conf.timeoutRestart) {
			int tc = timeoutCount.count(thread);
			timeoutCount.setCount(thread, 0);
			restartAutWithMessage(thread, "Possible AUT hang detected, "
					+ tc
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
