/******************************************************************************* 
 * Copyright (c) 2009, 2016 Xored Software Inc and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     Xored Software Inc - initial API and implementation and/or initial documentation 
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.commands;

import org.apache.poi.ss.util.CellReference;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange;
import org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.EclDataApachePOIImplPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetTableRangeService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetTableRange getTableRange = (GetTableRange) command;
		Table table = getTableRange.getTable();
		String range = getTableRange.getRange();

		if (range.indexOf(":") == -1) {
			return EclDataApachePOIImplPlugin.createErr(
					"Invalid value of 'range' parameter. Range string must contain the first cell name and the last cell name, separated by a colon.");
		}
		String[] cells = range.split(":");
		String firstCell = cells[0];
		String lastCell = cells[1];

		CellReference firstCellRef = new CellReference(firstCell);
		int firstRow = firstCellRef.getRow();
		int firstCol = firstCellRef.getCol();
		CellReference lastCellRef = new CellReference(lastCell);
		int lastRow = lastCellRef.getRow();
		int lastCol = lastCellRef.getCol();

		if (firstRow < 0 || firstCol < 0) {
			return EclDataApachePOIImplPlugin.createErr(
					"Invalid value of 'range' parameter: %s is an invalid cell name", firstCell);
		}
		if (lastRow < 0 || lastCol < 0) {
			return EclDataApachePOIImplPlugin.createErr(
					"Invalid value of 'range' parameter: %s is an invalid cell name", lastCell);
		}
		if (firstRow > lastRow) {
			return EclDataApachePOIImplPlugin.createErr(
					"Invalid value of 'range' parameter: row of the first cell cannot be more then row of the last cell");
		}
		if (firstCol > lastCol) {
			return EclDataApachePOIImplPlugin.createErr(
					"Invalid value of 'range' parameter: column of the first cell cannot be more then column of the last cell");
		}

		Table resultTable = ObjectsFactory.eINSTANCE.createTable();
		for (int rowIndex = firstRow; rowIndex <= lastRow; rowIndex++) {
			Row resultRow = getRow(table, rowIndex, firstCol, lastCol);
			resultTable.getRows().add(resultRow);
		}
		context.getOutput().write(resultTable);
		return Status.OK_STATUS;
	}

	private Row getRow(Table table, int rowIndex, int firstCol, int lastCol) {
		Row row = null;
		if (rowIndex < table.getRows().size()) {
			row = table.getRows().get(rowIndex);
		}

		Row resultRow = ObjectsFactory.eINSTANCE.createRow();
		for (int colIndex = firstCol; colIndex <= lastCol; colIndex++) {
			String cell = getCell(row, colIndex);
			resultRow.getValues().add(cell);
		}
		return resultRow;
	}

	private String getCell(Row row, int colIndex) {
		if (row == null) {
			return "";
		}
		if (colIndex >= row.getValues().size()) {
			return "";
		}
		String cell = row.getValues().get(colIndex);
		if (cell == null) {
			return "";
		}
		return cell;
	}

}
