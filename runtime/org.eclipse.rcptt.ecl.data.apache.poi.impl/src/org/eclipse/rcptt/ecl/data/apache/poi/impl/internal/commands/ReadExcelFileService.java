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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile;
import org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.EclDataApachePOIImplPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ReadExcelFileService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ReadExcelFile ref = (ReadExcelFile) command;
		EList<String> sheetNames = ref.getSheets();
		String uri = ref.getUri();
		EclFile file = FileResolver.resolve(uri);
		Workbook book = ExcelFileService.readBook(file);

		if (sheetNames != null && !sheetNames.isEmpty()) {
			// try to read sheets
			for (String sheetName : sheetNames) {
				if (book.getSheet(sheetName) == null) {
					return EclDataApachePOIImplPlugin.createErr("Sheet %s does not persist in file %s",
							sheetName, file.toURI());
				}
				Table table = readTable(book, book.getSheetIndex(sheetName));
				context.getOutput().write(table);
			}
		} else {
			// read all the sheets
			int sheetnum = 0;
			while (sheetnum < book.getNumberOfSheets()) {
				Table table = readTable(book, sheetnum);
				context.getOutput().write(table);
				sheetnum++;
			}
		}

		return Status.OK_STATUS;
	}

	private Table readTable(Workbook book, int sheetnum) {
		Table table = ObjectsFactory.eINSTANCE.createTable();
		Sheet sheet = book.getSheetAt(sheetnum);
		table.setPageName(sheet.getSheetName());
		readRows(table, sheet);
		return table;
	}

	private void readRows(Table table, Sheet sheet) {
		int maxRownum = sheet.getLastRowNum() + 1;
		for (int rownum = 0; rownum < maxRownum; rownum++) {
			Row row = sheet.getRow(rownum);
			readRow(table, row);
		}
	}

	private void readRow(Table table, Row row) {
		org.eclipse.rcptt.ecl.data.objects.Row tableRow = ObjectsFactory.eINSTANCE.createRow();
		int maxCellnum = row == null ? 0 : row.getLastCellNum();
		for (int cellnum = 0; cellnum < maxCellnum; cellnum++) {
			Cell cell = row.getCell(cellnum);
			tableRow.getValues().add(ExcelFileService.getCellValue(cell));
		}
		table.getRows().add(tableRow);
	}

}
