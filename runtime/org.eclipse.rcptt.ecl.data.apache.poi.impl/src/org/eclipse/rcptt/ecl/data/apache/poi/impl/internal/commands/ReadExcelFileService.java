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

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

		Workbook book;
		try {
			book = WorkbookFactory.create(file.toFile());
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
					if (table == null) {
						return EclDataApachePOIImplPlugin.createErr("First row on sheet %d of file %s does not contain data",
								sheetnum, file.toURI());
					}
					context.getOutput().write(table);
					sheetnum++;
				}
			}
		} catch (InvalidFormatException e) {
			return EclDataApachePOIImplPlugin.createErr("Error getting extension of file %s. Only 'xls' and 'xslx' are supported.",
					file.toURI());
		} catch (IOException e) {
			return EclDataApachePOIImplPlugin.createErr(e, "Error reading file %s",
					file.toURI());
		}

		return Status.OK_STATUS;
	}

	private Table readTable(Workbook book, int sheetnum) {
		Table table = ObjectsFactory.eINSTANCE.createTable();
		Sheet sheet = book.getSheetAt(sheetnum);
		Row headers = sheet.getRow(0);
		if (headers == null) {
			return null;
		}
		table.setPageName(sheet.getSheetName());
		readHeaders(table, headers);
		readRows(table, sheet);
		return table;
	}

	private void readHeaders(Table table, Row headers) {
		int cellnum = 0;
		while (headers.getCell(cellnum) != null) {
			Cell cell = headers.getCell(cellnum);
			table.getColumns().add(getCellValue(cell));
			cellnum++;
		}
	}

	private void readRows(Table table, Sheet sheet) {
		int rownum = 1;
		while (sheet.getRow(rownum) != null) {
			Row row = sheet.getRow(rownum);
			readRow(table, row);
			rownum++;
		}
	}

	private void readRow(Table table, Row row) {
		org.eclipse.rcptt.ecl.data.objects.Row tableRow = ObjectsFactory.eINSTANCE.createRow();
		int cellnum = 0;
		int size = table.getColumns().size();
		for (; cellnum < size; cellnum++) {
			Cell cell = row.getCell(cellnum);
			tableRow.getValues().add(getCellValue(cell));
		}
		table.getRows().add(tableRow);
	}

	private String getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			String number = String.valueOf(cell.getNumericCellValue());
			number = number.replaceAll(".0$", "");
			return number;
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			return "=" + cell.getCellFormula();
		default:
			return null;
		}
	}
}
