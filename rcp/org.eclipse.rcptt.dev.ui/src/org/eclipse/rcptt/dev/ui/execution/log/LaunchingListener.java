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
package org.eclipse.rcptt.dev.ui.execution.log;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.launching.ScenarioExecutable;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.ILaunchListener;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;

public class LaunchingListener implements ILaunchListener {

	public LaunchingListener() {
	}

	
	public void started(IExecutionSession session) {
	}

	
	public void launchStatusChanged(IExecutable... executables) {
		if (TeslaFeatures.getInstance().isTrue(TeslaFeatures.ACTIVITY_LOGS)) {
			for (IExecutable executable : executables) {
				if (executable instanceof PrepareExecutionWrapper
						&& executable.getStatus() == IExecutable.State.WAITING
						&& executable.getTime() == 0) {
					addLogFile(executable, "Before Contexts");
				} else if (executable instanceof ScenarioExecutable
						&& executable.getStatus() == IExecutable.State.LAUNCHING) {
					addLogFile(executable, "Before Execution");
				}
			}
		}
	}

	private void addLogFile(IExecutable executable, String stepDesc) {
		try {
			AdvancedInfoLog.addLogFile(executable, stepDesc);
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void finished() {
	}

}
