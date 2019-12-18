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
package org.eclipse.rcptt.tesla.recording.aspects.jface;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.swt.events.SelectionEvent;

public final class JFaceEventManager {
	private JFaceEventManager() {
	}

	private static Set<IJFaceEventListener> listeners = new HashSet<IJFaceEventListener>();

	public static void addListener(IJFaceEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IJFaceEventListener listener) {
		listeners.remove(listener);
	}

	public static void activateCellEditor(CellEditor cellEditor) {
		for (IJFaceEventListener listener : listeners) {
			listener.activateCellEditor(cellEditor);
		}
	}

	public static void activateCellEditor(CellEditor cellEditor,
			ColumnViewerEditorActivationEvent activationEvent) {
		for (IJFaceEventListener listener : listeners) {
			listener.activateCellEditor(cellEditor, activationEvent);
		}
	}

	public static void applyCellEditor(CellEditor cellEditor) {
		for (IJFaceEventListener listener : listeners) {
			listener.applyCellEditor(cellEditor);
		}
	}

	public static void cancelCellEditor(CellEditor cellEditor) {
		for (IJFaceEventListener listener : listeners) {
			listener.cancelCellEditor(cellEditor);
		}
	}

	public static void applyCellEditor(ColumnViewerEditor editor) {
		for (IJFaceEventListener listener : listeners) {
			listener.applyCellEditor(editor);
		}
	}

	public static void cancelCellEditor(ColumnViewerEditor editor) {
		for (IJFaceEventListener listener : listeners) {
			listener.cancelCellEditor(editor);
		}
	}

	public static void recordOpenStrategyEvent(OpenStrategy str,
			SelectionEvent e) {
		for (IJFaceEventListener listener : listeners) {
			listener.recordOpenStrategyEvent(str, e);
		}
	}

	public static void deactivateCellEditor(CellEditor cellEditor) {
		for (IJFaceEventListener listener : listeners) {
			listener.deactivateCellEditor(cellEditor);
		}
	}
}
