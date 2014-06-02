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
package org.eclipse.rcptt.tesla.recording.aspects;

import java.util.HashSet;
import java.util.Set;

public final class UIIDEEventManager {

	private static Set<IUIIDEEventListener> listeners = new HashSet<IUIIDEEventListener>();

	private static boolean freezeState;

	private UIIDEEventManager() {
	}

	public static void addListener(IUIIDEEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IUIIDEEventListener listener) {
		listeners.remove(listener);
	}

	public static boolean getFreeze() {
		return freezeState;
	}

	public static void setFreeze(boolean value) {
		freezeState = value;
	}

	public static void restartEclipse() {
		for (IUIIDEEventListener listener : listeners) {
			listener.restartEclipse();
		}
	}
}
