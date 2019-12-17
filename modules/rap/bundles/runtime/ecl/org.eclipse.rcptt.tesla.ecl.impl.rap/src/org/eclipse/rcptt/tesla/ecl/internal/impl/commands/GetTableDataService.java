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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import static org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin.err;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetTableData;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class GetTableDataService extends AbstractActionService {

	@Override
	protected Object exec(final Command command) throws CoreException {
//		final GetTableData gtd = (GetTableData) command;
//		ControlHandler control = gtd.getControl();
//		Element tableElement = TeslaBridge.find(control);
//		final Widget table = (Widget) TeslaBridge.getClient()
//				.getProcessor(SWTUIProcessor.class).getMapper()
//				.get(tableElement).widget;
//
//		if (!(table instanceof Tree) && !(table instanceof Table)) {
//			throw new CoreException(
//					err("'get-table-data' can be used only on table or tree"));
//		}
//
//		final org.eclipse.rcptt.ecl.data.objects.Table data = ObjectsFactory.eINSTANCE
//				.createTable();
//
//		table.getDisplay().syncExec(new Runnable() {
//			public void run() {
//				getTableData(data, table, gtd.isIncludeChecked(),
//						gtd.isExcludeHidden());
//			}
//		});
//
//		return data;
		return null;
	}

//	private static void getTableData(org.eclipse.rcptt.ecl.data.objects.Table table,
//			Widget widget, boolean includeChecked, boolean excludeHidden) {
//		List<String> columnNames = new ArrayList<String>();
//		List<Integer> columnIndices = new ArrayList<Integer>();
//
//		if (includeChecked) {
//			columnNames.add(CHECKED_COLUMN);
//		}
//
//		Widget[] columns = TableTreeUtil.getColumns(widget);
//
//		if (columns.length == 0) {
//			columnNames.add(DEFAULT_COLUMN);
//		} else {
//			for (int i = 0; i < columns.length; i++) {
//				Widget column = columns[i];
//				if (excludeHidden && TableTreeUtil.getColumnWidth(column) == 0) {
//					continue;
//				}
//				columnNames.add(TableTreeUtil.getName(column));
//				columnIndices.add(i);
//			}
//		}
//
//		table.getColumns().addAll(columnNames);
//
//		for (Item item : TableTreeUtil.getItems(widget)) {
//			table.getRows().add(toRow(item, includeChecked, columnIndices));
//		}
//	}
//
//	private static Row toRow(Item item, boolean includeChecked,
//			List<Integer> columnIndices) {
//		Row result = ObjectsFactory.eINSTANCE.createRow();
//		if (includeChecked) {
//			result.getValues().add(
//					Boolean.toString(TableTreeUtil.isChecked(item)));
//		}
//
//		if (columnIndices.isEmpty()) {
//			result.getValues().add(TableTreeUtil.getValue(item));
//		} else {
//			for (int index : columnIndices) {
//				result.getValues().add(TableTreeUtil.getValue(item, index));
//			}
//		}
//
//		for (Item child : TableTreeUtil.getChildren(item)) {
//			result.getChildren().add(
//					toRow(child, includeChecked, columnIndices));
//		}
//		return result;
//	}

	private static final String DEFAULT_COLUMN = "text";
	private static final String CHECKED_COLUMN = "checked";
}
