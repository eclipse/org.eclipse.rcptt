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

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.ILaunchListener;
import org.eclipse.rcptt.launching.Q7Launcher;

public class LaunchTimer extends Thread implements ILaunchListener {

	private Timer timer;

	public void finished() {
		cancel();
	}

	public void launchStatusChanged(IExecutable... executables) {
		cancel();
		for (IExecutable executable : executables) {
			if (executable.getStatus() == IExecutable.State.LAUNCHING
					&& !executable.isDebug()) {
				timer = new Timer(true);
				timer.schedule(new StopTask((Executable) executable),
						Q7Launcher.getLaunchTimeout() * 1000);
			}
		}
	}

	private void cancel() {
		if (timer != null) {
			timer.cancel();
			timer = null;
		}
	}

	public void started(IExecutionSession session) {
	}

	private static class StopTask extends TimerTask {

		private Executable executable;

		public StopTask(Executable executable) {
			this.executable = executable;
		}

		@Override
		public void run() {
			executable.terminate(false);
		}

	}

}
