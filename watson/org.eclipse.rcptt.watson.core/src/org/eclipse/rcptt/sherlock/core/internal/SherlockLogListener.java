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
package org.eclipse.rcptt.sherlock.core.internal;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;

import org.eclipse.rcptt.sherlock.core.IPluginFilter;
import org.eclipse.rcptt.sherlock.core.IStatusFilter;
import org.eclipse.rcptt.sherlock.core.PluginFilters;
import org.eclipse.rcptt.sherlock.core.StatusFilters;

public class SherlockLogListener implements ILogListener {
	private static class ListenerEntry {
		public final ILogListener listener;
		public final IStatusFilter statusFilter;
		public final IPluginFilter pluginFilter;

		public ListenerEntry(ILogListener listener, IStatusFilter statusFilter,
				IPluginFilter pluginFilter) {
			this.listener = listener;
			this.statusFilter = statusFilter;
			this.pluginFilter = pluginFilter;
		}
	}

	private final ListenerList listeners = new ListenerList();

	public void addLogListener(ILogListener listener,
			IStatusFilter statusFilter, IPluginFilter pluginFilter) {
		if (statusFilter == null) {
			statusFilter = StatusFilters.all();
		}

		if (pluginFilter == null) {
			pluginFilter = PluginFilters.all();
		}

		listeners.add(new ListenerEntry(listener, statusFilter, pluginFilter));
	}

	public void removeLogListener(ILogListener listener) {
		synchronized (listeners) {
			for (Object obj : listeners.getListeners()) {
				if (((ListenerEntry) obj).listener == listener) {
					listeners.remove(obj);
					break;
				}
			}
		}
	}

	public void logging(IStatus status, String plugin) {
		for (Object obj : listeners.getListeners()) {
			final ListenerEntry entry = (ListenerEntry) obj;
			if (entry.statusFilter.matches(status)
					&& entry.pluginFilter.matches(plugin)) {
				entry.listener.logging(status, plugin);
			}
		}
	}
}
