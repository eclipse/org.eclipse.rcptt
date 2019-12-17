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
package org.eclipse.rcptt.tesla.workbench.texteditor.aspects;

import java.util.WeakHashMap;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public final class WorkbenchTexteditorManager {
	private WorkbenchTexteditorManager() {
	}

	private static WeakHashMap<ISourceViewer, AbstractTextEditor> editorsMap = new WeakHashMap<ISourceViewer, AbstractTextEditor>();

	public static void mapEditor(ISourceViewer viewer, AbstractTextEditor editor) {
		editorsMap.put(viewer, editor);
	}
}
