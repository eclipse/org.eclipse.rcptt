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
package org.eclipse.rcptt.runner.util;

import static org.eclipse.rcptt.ecl.core.util.Statuses.hasCode;

import java.io.EOFException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.interop.InteropFactory;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.internal.launching.EclStackTrace;
import org.eclipse.rcptt.internal.launching.ExecutionStatus;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.runner.RunnerConfiguration;

public class TestResult {

	public final boolean failed;
	public final boolean skipped;
	public final String name;
	public final String reason;
	public final long time;
	public final boolean timeout;
	public final boolean connectionUnavailable;

	public TestResult(boolean failed, boolean skipped, String name, String reason, long time,
			boolean timeout, boolean connectionUnavailable) {
		this.failed = failed;
		this.skipped = skipped;
		this.name = name;
		this.reason = reason;
		this.time = time;
		this.timeout = timeout;
		this.connectionUnavailable = connectionUnavailable;
	}

	public long memory;

	public TestResult withAdditionalInfo(RunnerConfiguration conf,
			AutThread thread) {
		if (conf.outputMemoryUsage) {
			try {
				memory = (Long) thread.launch.execute(InteropFactory.eINSTANCE
						.createGetMemoryUsage());
			} catch (Throwable e) {
				ResultsHandler.log("Cannot get the memory usage information", e);
			}
		}
		return this;
	}

	public String userFriendlyMessage(int est, int timeLeft, int processed,
			int artifacts, int failedCount) {

		String remaining = String.format("%d:%02d mins", est / 60, est % 60);
		String elapsed = String.format("%d:%02d", timeLeft / 60, timeLeft % 60);
		String usedMB = String.format("%.1fMB", memory / 1024f / 1024f);
		String status = "Pass";
		if (failed)
			status = "Fail";
		else if (skipped)
			status = "Skip";

		return String.format("%s %s (%s) processed. %s failed. spent: %s,"
				+ " %s remaining. %s. time: %sms %s%s",

				status, "" + processed, "" + artifacts, ""
						+ failedCount, elapsed, remaining, name, time,
				reason.length() > 0 ? " Cause: " + reason : "",
				memory > 0 ? "\nUsed memory: " + usedMB : "");
	}

	public static TestResult collectFrom(IExecutable[] executables,
			String testName, long totalTime) {
		String reason = "";
		boolean failed = false;
		boolean skipped = false;
		boolean timeout = false;
		boolean connectionUnavailable = false;

		for (IExecutable executable : executables) {
			IStatus resultStatus = executable.getResultStatus();
			if (!executable.getResultStatus().isOK()) {
				reason = "";
				if (resultStatus != null) {

					if (hasCode(resultStatus, IProcess.TIMEOUT_CODE)) {
						timeout = true;
					}
					reason = resultStatus.getMessage();
					if (resultStatus instanceof ExecutionStatus) {
						reason = EclStackTrace.fromExecStatus((ExecutionStatus) resultStatus).getDisplayMessage();
					}
					if (resultStatus.getException() instanceof EOFException) {
						connectionUnavailable = true;
					}
				}
				failed = true;
			}
		}

		return new TestResult(failed, skipped, testName, reason, totalTime, timeout, connectionUnavailable);
	}

}
