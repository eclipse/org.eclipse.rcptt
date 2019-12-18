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

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.AssertKind;

public class AssertOperationEditingSupport extends EditingSupport {
	public AssertOperationEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected boolean canEdit(Object element) {
		return element instanceof Assert;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		String[] operationNames = AssertValue.forAssert(((Assert) element))
				.getOperationNames();
		if (operationNames.length > 1) {
			ComboBoxCellEditor editor = new ComboBoxCellEditor(
					(Composite) getViewer().getControl(), operationNames,
					SWT.READ_ONLY);
			return editor;
		}
		return null;
	}

	@Override
	protected Object getValue(Object element) {
		String name = ((Assert) element).getKind().getLiteral();
		return AssertValue.forAssert(((Assert) element))
				.getOperationIndex(name);
	}

	@Override
	protected void setValue(Object element, Object value) {
		String literal = AssertValue.forAssert(((Assert) element))
				.getOperationNames()[(Integer) value];
		((Assert) element).setKind(AssertKind.get(literal));

		// Update
		final CheckboxTreeViewer viewer = ((CheckboxTreeViewer) getViewer());
		viewer.setChecked(element, true);
		viewer.update(element, null);
	}
}