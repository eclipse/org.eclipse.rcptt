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
package org.eclipse.rcptt.tesla.recording.aspects;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.statushandlers.StatusAdapter;

public final class WorkbenchEventManager {

	private static Set<IWorkbenchEventListener> listeners = new HashSet<IWorkbenchEventListener>();

	private static boolean freezeState;

	private WorkbenchEventManager() {
	}

	public static void addListener(IWorkbenchEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IWorkbenchEventListener listener) {
		listeners.remove(listener);
	}

	public static boolean getFreeze() {
		return freezeState;
	}

	public static void setFreeze(boolean value) {
		freezeState = value;
	}

	public static void closeEditors(IEditorReference[] refArray) {
		for (IWorkbenchEventListener listener : listeners) {
			listener.closeEditors(refArray);
		}
	}

	public static void restartEclipse() {
		for (IWorkbenchEventListener listener : listeners) {
			listener.restartEclipse();
		}
	}

	public static void recordAction(ActionType type) {
		try {
			for (IWorkbenchEventListener listener : listeners) {
				listener.recordAction(type);
			}
		} catch (Throwable e) {
			RecordingWorkbenchActivator.log(e);
		}
	}

	public static void recordAddStatus(StatusAdapter adapter, boolean modal) {
		for (IWorkbenchEventListener listener : listeners) {
			listener.recordAddStatus(adapter, modal);
		}
	}

	public static void recordStatusCleanup() {
		for (IWorkbenchEventListener listener : listeners) {
			listener.recordStatusCleanup();
		}
	}
}
