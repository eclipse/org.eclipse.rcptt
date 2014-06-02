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
package org.eclipse.rcptt.sherlock.aspects.asyncs;

import java.util.ArrayList;
import java.util.List;

public class AsyncEventManager {
	private static AsyncEventManager INSTANCE = null;
	private List<IAsyncEventListener> listeners = new ArrayList<IAsyncEventListener>();

	public AsyncEventManager() {
	}

	public static AsyncEventManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new AsyncEventManager();
		}
		return INSTANCE;
	}

	public void addListener(IAsyncEventListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IAsyncEventListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public IAsyncEventListener[] getListeners() {
		synchronized (listeners) {
			return new ArrayList<IAsyncEventListener>(listeners)
					.toArray(new IAsyncEventListener[listeners.size()]);
		}
	}
}
