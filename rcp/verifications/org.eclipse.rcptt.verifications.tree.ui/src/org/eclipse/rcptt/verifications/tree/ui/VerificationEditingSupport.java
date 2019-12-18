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
package org.eclipse.rcptt.verifications.tree.ui;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.rcptt.tesla.core.utils.WidgetModels;
import org.eclipse.rcptt.verifications.tree.Cell;
import org.eclipse.rcptt.verifications.tree.Row;

public class VerificationEditingSupport extends EditingSupport {

	private TextCellEditor cellEditor;

	public VerificationEditingSupport(ColumnViewer viewer) {
		super(viewer);
		cellEditor = new TextCellEditor(((TreeViewer) viewer).getTree());
	}

	@Override
	protected void initializeCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
		if (cell.getElement() instanceof Row) {
			Cell tableCell = ((Row) cell.getElement()).getValues().get(cell.getColumnIndex());
			cellEditor.setValue(getValue(tableCell));
		}
	}

	@Override
	protected void saveCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
		if (cell.getElement() instanceof Row) {
			Cell tableCell = ((Row) cell.getElement()).getValues().get(cell.getColumnIndex());
			setValue(tableCell, cellEditor.getValue());
			getViewer().refresh();
		}
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return false;
	}

	@Override
	protected Object getValue(Object element) {
		String result = "";
		if (element instanceof Cell) {
			result = WidgetModels.getTextWithoutStyle(((Cell) element).getStyle(),
					((Cell) element).getData().getText());
		}
		return result;

	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof Cell) {
			Object oldValue = getValue(element);
			if (!oldValue.equals(value)) {
				((Cell) element).getData().setText(value.toString());
				((Cell) element).getStyle().clear();
			}
		}
	}
}
