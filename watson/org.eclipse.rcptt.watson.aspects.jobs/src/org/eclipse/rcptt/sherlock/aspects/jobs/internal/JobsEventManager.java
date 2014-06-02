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
package org.eclipse.rcptt.sherlock.aspects.jobs.internal;

import java.util.ArrayList;
import java.util.List;

public class JobsEventManager {
	private static JobsEventManager INSTANCE = null;
	private List<IJobsEventListener> listeners = new ArrayList<IJobsEventListener>();

	public JobsEventManager() {
	}

	public static JobsEventManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new JobsEventManager();
		}
		return INSTANCE;
	}

	public void addListener(IJobsEventListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IJobsEventListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public IJobsEventListener[] getListeners() {
		synchronized (listeners) {
			return new ArrayList<IJobsEventListener>(listeners)
					.toArray(new IJobsEventListener[listeners.size()]);
		}
	}
}
