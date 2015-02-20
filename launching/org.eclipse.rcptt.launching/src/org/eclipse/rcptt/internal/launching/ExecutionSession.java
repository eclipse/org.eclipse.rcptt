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
package org.eclipse.rcptt.internal.launching;

import static org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin.PLUGIN_ID;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.reporting.internal.Q7ReportingPlugin;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportSession;

public class ExecutionSession implements IExecutionSession {

	private final String name;
	private final Executable[] executables;
	private Date startTime;
	private boolean running = false;
	private boolean terminated = false;
	private final ListenerList listeners = new ListenerList();

	private Executable executable;

	private int finishedCount;
	private int failedCount;
	private Date endTime;
	private final SherlockReportSession reportSession;
	private Q7TestLaunch launch;
	private final int testCasesCount;
	private AutLaunch aut;

	public ExecutionSession(String name, Executable[] executables, AutLaunch aut) {
		this.name = name;
		this.executables = executables;
		this.aut = aut;
		String reportID = Q7ReportingPlugin.getID(name);
		File reportRoot = Q7LaunchingPlugin.getExecutionSessionRoot(reportID,
				this);
		reportSession = new SherlockReportSession(reportRoot);
		Executable[] testCases = getTestCases();
		for (Executable executable : testCases) {
			if (executable instanceof PrepareExecutionWrapper) {
				((PrepareExecutionWrapper) executable)
						.setReportSession(reportSession);
			}
		}
		testCasesCount = testCases.length;
	}

	public void setLaunch(Q7TestLaunch q7TestLaunch) {
		this.launch = q7TestLaunch;
	}

	public Q7TestLaunch getLaunch() {
		return this.launch;
	}

	public SherlockReportSession getReportSession() {
		return reportSession;
	}

	public Executable[] getExecutables() {
		return executables;
	}

	public Executable[] getTestCases() {
		List<Executable> result = internalGetTestCases(executables);
		return result.toArray(new Executable[result.size()]);
	}

	private List<Executable> internalGetTestCases(Executable[] parents) {
		List<Executable> result = new ArrayList<Executable>();
		for (Executable executable : parents) {
			if (executable instanceof PrepareExecutionWrapper) {
				result.add(executable);
			} else if (executable instanceof TestSuiteExecutable) {
				result.addAll(internalGetTestCases(((TestSuiteExecutable) executable)
						.getChildren()));
			}
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void addListener(IExecutionSessionListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(IExecutionSessionListener listener) {
		this.listeners.remove(listener);
	}

	public synchronized void setActive(Executable executable) {
		this.executable = executable;
	}

	public synchronized Executable getActive() {
		return executable;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public int getResultStatus() {
		int status = OK;
		for (IExecutable executable : executables) {
			switch (executable.getStatus()) {
			case FAILED:
				return FAIL;
			case PASSED:
				continue;
			case LAUNCHING:
			case WAITING:
				return UNKNOWN;
			}
		}
		return status;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void start() {
		this.running = true;
	}

	public void stop() {
		this.running = false;
		for (Executable ex : executables) {
			ex.cancel(new Status(IStatus.CANCEL, PLUGIN_ID, "Execution is stopped"));
		}
		for (Object o : listeners.getListeners()) {
			((IExecutionSessionListener) o).executionFinished();
		}
		terminated = true;
		if (launch != null) {
			launch.setSession(null);
		}
		aut = null;
		for (Object o : listeners.getListeners()) {
			((IExecutionSessionListener) o).statisticsUpdate();
		}
	}

	public int getFailedCount() {
		return failedCount;
	}

	public int getStoppedCount() {
		int count = 0;
		for (IExecutable executable : executables) {
			if (executable.getResultStatus().matches(IStatus.CANCEL))
				count++;
		}
		return count;
	}

	public int getFinishedCount() {
		return finishedCount;
	}

	public int getTotalCount() {
		return testCasesCount;
	}

	public void resetCounters() {
		finishedCount = 0;
		failedCount = 0;
		for (Object o : listeners.getListeners()) {
			((IExecutionSessionListener) o).statisticsUpdate();
		}
	}

	public void oneFailed() {
		finishedCount++;
		failedCount++;
		for (Object o : listeners.getListeners()) {
			((IExecutionSessionListener) o).statisticsUpdate();
		}
	}

	public void oneFinished() {
		finishedCount++;
		for (Object o : listeners.getListeners()) {
			((IExecutionSessionListener) o).statisticsUpdate();
		}
	}

	public long getTotalTime() {
		long total = 0;
		for (IExecutable executable : executables) {
			total += executable.getTime();
		}
		return total;
	}

	public void dispose() {
		if (launch != null) {
			launch.setSession(null);
		}
		if (executable != null) {
			executable.dispose();
		}
		if (executables != null) {
			for (Executable executable : executables) {
				executable.dispose();
			}
		}
		if (reportSession != null) {
			reportSession.dispose();
		}
		aut = null;
	}

	public void setEndTime(Date date) {
		endTime = date;
	}

	public Date getEndTime() {
		return endTime;
	}

	public boolean isDebugging(AutLaunch aut) {
		return running && aut.equals(this.aut);
	}
}
