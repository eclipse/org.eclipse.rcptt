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
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells;
import org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.EclDataApachePOIImplPlugin;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetTableCellsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetTableCells getTableCells = (GetTableCells) command;
		Table table = getTableCells.getTable();

		EList<String> cells = getTableCells.getCells();
		for (String cellName : cells) {
			if (cellName == null || cellName.equals("")) {
				return EclDataApachePOIImplPlugin
						.createErr("Error getting 'cells' parameter. Cell name must not be null or empty");
			}

			CellReference cellRef = new CellReference(cellName);
			int rowIndex = cellRef.getRow();
			int colIndex = cellRef.getCol();

			if (rowIndex < 0 || colIndex < 0) {
				return EclDataApachePOIImplPlugin
						.createErr("Invalid value of 'cells' parameter: %s is an invalid cell name", cellName);
			}

			if (rowIndex >= table.getRows().size()) {
				context.getOutput().write("");
				continue;
			}

			Row row = table.getRows().get(rowIndex);
			if (colIndex >= row.getValues().size()) {
				context.getOutput().write("");
				continue;
			}

			String cell = row.getValues().get(colIndex);
			if (cell == null) {
				cell = "";
			}

			context.getOutput().write(cell);
		}
		return Status.OK_STATUS;
	}

}
