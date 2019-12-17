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
package org.eclipse.rcptt.tesla.recording.aspects.jface;

import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.swt.events.SelectionEvent;

public interface IJFaceEventListener {
	void activateCellEditor(Object cellEditor);

	void activateCellEditor(CellEditor cellEditor,
			ColumnViewerEditorActivationEvent activationEvent);

	void applyCellEditor(Object cellEditor);

	void cancelCellEditor(Object cellEditor);

	void recordOpenStrategyEvent(OpenStrategy str, SelectionEvent e);

	void deactivateCellEditor(Object cellEditor);
}
