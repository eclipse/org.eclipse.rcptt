/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.profiling;

import java.util.ArrayList;
import java.util.List;

public class ProfilingEventManager {
	private static ProfilingEventManager INSTANCE = null;
	private List<IProfilingListener> listeners = new ArrayList<IProfilingListener>();

	public ProfilingEventManager() {
	}

	public synchronized static ProfilingEventManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new ProfilingEventManager();
		}
		return INSTANCE;
	}

	public void addListener(IProfilingListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IProfilingListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public int getListenersLength() {
		synchronized (listeners) {
			return listeners.size();
		}
	}

	public void asyncRunning(Runnable value) {
		synchronized (listeners) {
			for (IProfilingListener l : listeners) {
				l.asyncRunning(value);
			}
		}
	}

	public void asyncDone(Runnable value) {
		synchronized (listeners) {
			for (IProfilingListener l : listeners) {
				l.asyncDone(value);
			}
		}
	}

	public void asyncAdded(Runnable async, boolean value) {
		synchronized (listeners) {
			for (IProfilingListener l : listeners) {
				l.asyncAdded(async, value);
			}
		}
	}

	public void timerAdded(Runnable run) {
		synchronized (listeners) {
			for (IProfilingListener l : listeners) {
				l.timerAdded(run);
			}
		}
	}
}
