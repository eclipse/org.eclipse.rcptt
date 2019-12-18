/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.jobs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;

public class ProfilingJobsEventManager {
	private static ProfilingJobsEventManager INSTANCE = null;
	private List<IProfilingJobsListener> listeners = new ArrayList<IProfilingJobsListener>();

	public ProfilingJobsEventManager() {
	}

	public synchronized static ProfilingJobsEventManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new ProfilingJobsEventManager();
		}
		return INSTANCE;
	}

	public void addListener(IProfilingJobsListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IProfilingJobsListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public IProfilingJobsListener[] getListeners() {
		synchronized (listeners) {
			return new ArrayList<IProfilingJobsListener>(listeners)
					.toArray(new IProfilingJobsListener[listeners.size()]);
		}
	}

	public void jobChangeState(InternalJob job, int newState) {
		synchronized (listeners) {
			for (IProfilingJobsListener l : listeners) {
				l.jobChangeStatus(job, newState);
			}
		}
	}

	public void jobSchedule(InternalJob job, long delay, boolean reshedule) {
		synchronized (listeners) {
			for (IProfilingJobsListener l : listeners) {
				l.jobSchedule(job, delay, reshedule);
			}
		}
	}

	public void jobCanceled(InternalJob job) {
		synchronized (listeners) {
			for (IProfilingJobsListener l : listeners) {
				l.jobCanceled(job);
			}
		}
	}

	public void endJob(InternalJob job, IStatus status, boolean notify) {
		IProfilingJobsListener[] listeners = ProfilingJobsEventManager
				.getDefault().getListeners();
		for (IProfilingJobsListener l : listeners) {
			l.endJob(job, status, notify);
		}
	}
}
