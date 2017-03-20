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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells;
import org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.EclDataApachePOIImplPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class SetTableCellsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		SetTableCells setTableCells = (SetTableCells) command;
		Table table = setTableCells.getTable();

		EclMap cells = setTableCells.getCells();
		for (EclMapEntry entry : cells.getEntries()) {
			String key = getValue(entry.getKey());
			if (key == null || key.equals("")) {
				return EclDataApachePOIImplPlugin
						.createErr("Error getting 'cells' parameter. Map key must not be null");
			}
			String value = getValue(entry.getValue());
			addCellValue(table, key, value);
		}
		context.getOutput().write(table);
		return Status.OK_STATUS;
	}

	private void addCellValue(Table table, String cellName, String cellValue) throws CoreException {
		CellReference cellRef = new CellReference(cellName);
		int rowIndex = cellRef.getRow();
		int colIndex = cellRef.getCol();

		if (rowIndex < 0 || colIndex < 0) {
			throw new CoreException(EclDataApachePOIImplPlugin
					.createErr("Invalid value of 'cells' parameter: %s is an invalid cell name", cellName));
		}

		if (rowIndex >= table.getRows().size()) {
			for (int i = table.getRows().size(); i <= rowIndex; i++) {
				Row row = ObjectsFactory.eINSTANCE.createRow();
				table.getRows().add(i, row);
			}
		}

		Row row = table.getRows().get(rowIndex);
		if (colIndex >= row.getValues().size()) {
			for (int i = row.getValues().size(); i <= colIndex; i++) {
				row.getValues().add(i, "");
			}
		}

		row.getValues().set(colIndex, cellValue);
	}

	private String getValue(EObject obj) {
		Object object = BoxedValues.unbox(obj);
		if (object == null) {
			return null;
		}
		return String.valueOf(object);
	}

}
