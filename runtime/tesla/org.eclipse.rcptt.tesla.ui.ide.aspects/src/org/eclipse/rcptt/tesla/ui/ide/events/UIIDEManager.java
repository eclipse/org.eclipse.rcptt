/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ui.ide.events;

import java.util.ArrayList;
import java.util.List;

public class UIIDEManager {
	private static String location = null;

	public static interface IUIIDEListener {
		void handleNewWorkspaceLocation(String path);
	}

	private static List<IUIIDEListener> listeners = new ArrayList<UIIDEManager.IUIIDEListener>();

	public synchronized static void registerNewLocation(String location) {
		UIIDEManager.location = location;
		for (IUIIDEListener listener : listeners) {
			listener.handleNewWorkspaceLocation(location);
		}
	}

	public synchronized static String getLocation() {
		return location;
	}

	public synchronized static void addListener(IUIIDEListener listener) {
		listeners.add(listener);
	}

	public synchronized static void removeListener(IUIIDEListener listener) {
		listeners.remove(listener);
	}
}
