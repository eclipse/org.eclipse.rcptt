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
package org.eclipse.rcptt.ui.panels.assertion;

import java.lang.reflect.Method;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.tesla.core.protocol.Assert;

public class AssertValueEditingSupport extends EditingSupport {
	public AssertValueEditingSupport(TreeViewer viewer) {
		super(viewer);
	}

	@Override
	protected boolean canEdit(Object element) {
		return element instanceof Assert;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor((Composite) getViewer().getControl());
	}

	@Override
	protected Object getValue(Object element) {
		final String v = ((Assert) element).getValue();
		return v == null ? "" : v; //$NON-NLS-1$
	}

	@Override
	protected void setValue(Object element, Object value) {
		((Assert) element).setValue(value.toString());

		// Check element
		final CheckboxTreeViewer viewer = ((CheckboxTreeViewer) getViewer());
		viewer.setChecked(element, true);

		// Fix for QS-773
		// Invocation of method
		// org.eclipse.jface.viewers.CheckboxTreeViewer.setChecked(Object,
		// boolean) is not enough because it doesn't send any event and viewer
		// won't update it's observables about checked element. So we have to
		// send org.eclipse.jface.viewers.CheckStateChangedEvent this way.
		try {
			Method method = CheckboxTreeViewer.class.getDeclaredMethod(
					"fireCheckStateChanged", CheckStateChangedEvent.class); //$NON-NLS-1$
			method.setAccessible(true);
			method.invoke(viewer, new CheckStateChangedEvent(viewer, element,
					true));
		} catch (Throwable e) {
			Q7UIPlugin.log(e);
		}
	}
}