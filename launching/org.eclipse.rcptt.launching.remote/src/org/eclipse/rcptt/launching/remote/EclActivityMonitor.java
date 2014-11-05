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
package org.eclipse.rcptt.launching.remote;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.tesla.core.TeslaLimits;

public final class EclActivityMonitor implements IProcess {

	private volatile boolean terminated = false;
	private volatile boolean restart = false;
	private final BaseAutLaunch aut;

	public EclActivityMonitor(BaseAutLaunch aut) {
		this.aut = aut;
	}

	public void startMonitor() {
		new Thread("RCPTT Connection monitor") {
			public void run() {
				while (!terminated) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// monitor thread was interrupted -> terminate launch
						terminate();
					}
					try {
						if (!restart) {
							aut.ping();
						}
					} catch (Exception e) {
						terminate();
					}
				}
			};
		}.start();
	}

	public void waitForRestart(IProgressMonitor monitor) throws CoreException {
		restart = true;
		try {
			long startTime = System.currentTimeMillis();
			try {
				while (isActive()) {
					if (monitor.isCanceled()) {
						throw new CoreException(Status.CANCEL_STATUS);
					}
					waitFor(10, startTime);
				}
				// wait for activation
				while (!isActive()) {
					if (monitor.isCanceled()) {
						throw new CoreException(Status.CANCEL_STATUS);
					}
					waitFor(50, startTime);
				}
			} catch (InterruptedException e) {
				throw new CoreException(new Status(IStatus.CANCEL,
						Q7LaunchingPlugin.PLUGIN_ID, e.getMessage(), e));
			}
		} finally {
			restart = false;
		}
	}

	private void waitFor(long time, long startTime)
			throws InterruptedException, CoreException {
		Thread.sleep(time);
		long currentTime = System.currentTimeMillis();
		if (currentTime > startTime + TeslaLimits.getAUTStartupTimeout()) {
			throw new CoreException(new Status(IStatus.ERROR,
					Q7LaunchingPlugin.PLUGIN_ID,
					"Waiting for restart failed: timeout error"));
		}
	}

	private boolean isActive() {
		try {
			aut.ping();
			return true;
		} catch (CoreException e) {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return null;
	}

	public boolean canTerminate() {
		return !isTerminated();
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() {
		if (!terminated) {
			DebugEvent e = new DebugEvent(getLaunch(), DebugEvent.TERMINATE);
			DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { e });
			e = new DebugEvent(this, DebugEvent.TERMINATE);
			DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { e });
			terminated = true;
		}
	}

	public String getLabel() {
		return "Remote AUT connection";
	}

	public ILaunch getLaunch() {
		return aut.getLaunch();
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}
}
