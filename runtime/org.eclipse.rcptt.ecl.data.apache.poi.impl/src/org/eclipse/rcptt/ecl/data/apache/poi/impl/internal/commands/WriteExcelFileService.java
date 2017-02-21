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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile;
import org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.EclDataApachePOIImplPlugin;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class WriteExcelFileService implements ICommandService {

	private static final String XLS_EXTENSION = "xls";
	private static final String XLSX_EXTENSION = "xlsx";
	private static final String SHEET_NAME_PATTERN = "Sheet%d";

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		WriteExcelFile wef = (WriteExcelFile) command;
		EList<Table> tables = wef.getTables();
		String uri = wef.getUri();
		EclFile file = FileResolver.resolve(uri);

		Workbook book;
		if (uri.endsWith(XLS_EXTENSION)) {
			book = new HSSFWorkbook();
		} else if (uri.endsWith(XLSX_EXTENSION)) {
			book = new XSSFWorkbook();
		} else {
			return EclDataApachePOIImplPlugin.createErr("Error getting file extension %s. Only 'xls' and 'xslx' are supported.",
					file.toURI());
		}

		int sheetnum = 1;
		for (Table object : tables) {
			Table table = (Table) object;
			int rownum = 0;
			String sheetName = table.getPageName();
			if (sheetName == null || sheetName.equals("")) {
				sheetName = String.format(SHEET_NAME_PATTERN, sheetnum);
			}
			Sheet sheet = book.createSheet(sheetName);
			rownum = writeValues(rownum, sheet, table.getColumns());
			for (org.eclipse.rcptt.ecl.data.objects.Row tableRow : table.getRows()) {
				rownum = writeRow(rownum, sheet, tableRow);
			}
			autoSizeColumns(sheet);
			context.getOutput().write(table);
			sheetnum++;
		}
		try {
			FileOutputStream stream = new FileOutputStream(file.toFile());
			book.write(stream);
			stream.close();
		} catch (IOException e) {
			return EclDataApachePOIImplPlugin.createErr(e, "Error writing file %s",
					file.toURI());
		}
		return Status.OK_STATUS;
	}

	private int writeRow(int rownum, Sheet sheet, org.eclipse.rcptt.ecl.data.objects.Row tableRow) {
		for (org.eclipse.rcptt.ecl.data.objects.Row row : tableRow.getChildren()) {
			rownum = writeRow(rownum, sheet, row);
		}
		rownum = writeValues(rownum, sheet, tableRow.getValues());
		return rownum;
	}

	private int writeValues(int rownum, Sheet sheet, List<String> values) {
		Row row = sheet.createRow(rownum);
		rownum++;
		int cellnum = 0;
		for (String value : values) {
			Cell cell = row.createCell(cellnum);
			if (value != null && value.startsWith("=")) {
				try {
					cell.setCellFormula(value.replaceAll("^=", ""));
				} catch (FormulaParseException e) {
					cell.setCellValue(value);
				}
			} else {
				cell.setCellValue(value);
			}
			cellnum++;
		}
		return rownum;
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
