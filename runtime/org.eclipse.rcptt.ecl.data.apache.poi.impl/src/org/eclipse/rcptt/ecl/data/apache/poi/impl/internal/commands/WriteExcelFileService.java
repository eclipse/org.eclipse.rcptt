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

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class WriteExcelFileService implements ICommandService {

	private static final String SHEET_NAME_PATTERN = "Sheet%d";

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		WriteExcelFile wef = (WriteExcelFile) command;
		EList<Table> tables = wef.getTables();

		String uri = wef.getUri();
		EclFile file = FileResolver.resolve(uri);

		boolean isAppend = wef.isAppend();
		isAppend &= file.toFile().exists();

		Workbook book;
		if (isAppend) {
			book = ExcelFileService.readBook(file);
		} else {
			book = ExcelFileService.createBook(file, uri);
		}

		int sheetnum = 1;
		for (Table table : tables) {
			String sheetName = table.getPageName();
			if (sheetName == null || sheetName.equals("")) {
				sheetName = String.format(SHEET_NAME_PATTERN, sheetnum);
			}
			Sheet sheet = book.getSheet(sheetName);
			if (sheet == null) {
				sheet = book.createSheet(sheetName);
			}
			writeTable(sheet, table);
			if (!isAppend) {
				autoSizeColumns(sheet);
			}
			context.getOutput().write(table);
			sheetnum++;
		}

		ExcelFileService.writeBook(book, file);
		return Status.OK_STATUS;
	}

	private void writeTable(Sheet sheet, Table table) {
		EList<org.eclipse.rcptt.ecl.data.objects.Row> tableRows = table.getRows();
		for (int rownum = 0; rownum < tableRows.size(); rownum++) {
			Row row = sheet.getRow(rownum);
			if (row == null) {
				row = sheet.createRow(rownum);
			}
			writeRow(row, tableRows.get(rownum));
		}
	}

	private void writeRow(Row row, org.eclipse.rcptt.ecl.data.objects.Row tableRow) {
		EList<String> cells = tableRow.getValues();
		for (int cellnum = 0; cellnum < cells.size(); cellnum++) {
			String value = cells.get(cellnum);
			if (value == null || value.equals("")) {
				continue;
			}

			Cell cell = row.getCell(cellnum);
			if (cell == null) {
				cell = row.createCell(cellnum);
			}

			if (value.startsWith("=")) {
				try {
					cell.setCellFormula(value.replaceAll("^=", ""));
				} catch (FormulaParseException e) {
					cell.setCellValue(value);
				}
			} else {
				cell.setCellValue(value);
			}
		}
	}

	private void autoSizeColumns(Sheet sheet) {
		int length = sheet.getRow(0).getLastCellNum();
		if (length == -1) {
			return;
		}
		for (int col = 0; col < length; col++) {
			sheet.autoSizeColumn(col);
		}
	}

}
