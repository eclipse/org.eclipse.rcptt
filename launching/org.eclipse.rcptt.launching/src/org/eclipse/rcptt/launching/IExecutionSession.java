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
package org.eclipse.rcptt.launching;

import java.util.Date;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.internal.launching.Q7TestLaunch;

public interface IExecutionSession {

	public static final int OK = 0;

	public static final int FAIL = 1;

	public static final int UNKNOWN = 2;

	public IExecutable[] getExecutables();

	public IExecutable[] getTestCases();

	public String getName();

	public Date getStartTime();

	public boolean isRunning();

	public int getTotalCount();

	public long getTotalTime();

	public int getFinishedCount();

	public int getFailedCount();

	public int getStoppedCount();

	public Date getEndTime();

	public Q7TestLaunch getLaunch();
	
	public static interface IExecutionSessionListener {
		void executionFinished();
		void statisticsUpdate();
	}
	public void addListener(IExecutionSessionListener listener);

	public void removeListener(IExecutionSessionListener listener);

	public IStatus getResultStatus();
}
