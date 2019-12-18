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
import java.util.WeakHashMap;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public final class WorkbenchTexteditorEventManager {

	private static Set<IWorkbenchTexteditorEventListener> listeners = new HashSet<IWorkbenchTexteditorEventListener>();
	private static WeakHashMap<ISourceViewer, AbstractTextEditor> editorsMap = new WeakHashMap<ISourceViewer, AbstractTextEditor>();

	private WorkbenchTexteditorEventManager() {
	}

	public static void addListener(IWorkbenchTexteditorEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IWorkbenchTexteditorEventListener listener) {
		listeners.remove(listener);
	}
	public static void mapEditor(ISourceViewer viewer, AbstractTextEditor editor) {
		editorsMap.put(viewer, editor);
	}
}
