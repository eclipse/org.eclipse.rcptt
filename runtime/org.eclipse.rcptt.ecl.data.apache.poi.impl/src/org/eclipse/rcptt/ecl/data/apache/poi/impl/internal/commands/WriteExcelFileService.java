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
	private static final String TEMP_FILE_NAME_PATTERN = "%s.tmp";

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		WriteExcelFile wef = (WriteExcelFile) command;
		EList<Table> tables = wef.getTables();

		String uri = wef.getUri();
		EclFile file = FileResolver.resolve(uri);

		boolean isAppend = wef.isAppend();
		isAppend &= file.toFile().exists();

		Workbook book;
		try {
			if (isAppend) {
				book = ExcelFileService.readBook(file);
			} else {
				book = createBook(file, uri, isAppend);
			}
		} catch (CoreException e) {
			return e.getStatus();
		}

		int sheetnum = 1;
		for (Table table : tables) {
			int rownum = 0;
			String sheetName = table.getPageName();
			if (sheetName == null || sheetName.equals("")) {
				sheetName = String.format(SHEET_NAME_PATTERN, sheetnum);
			}
			Sheet sheet = book.getSheet(sheetName);
			if (sheet == null) {
				sheet = book.createSheet(sheetName);
				rownum = writeValues(rownum, sheet, table.getColumns());
			} else {
				rownum = resolveHeaders(sheet, table, file);
			}
			for (org.eclipse.rcptt.ecl.data.objects.Row tableRow : table.getRows()) {
				rownum = writeRow(rownum, sheet, tableRow);
			}
			autoSizeColumns(sheet);
			context.getOutput().write(table);
			sheetnum++;
		}
		try {
			writeBook(book, file, uri, isAppend);
		} catch (CoreException e) {
			return e.getStatus();
		}
		return Status.OK_STATUS;
	}

	private Workbook createBook(EclFile file, String uri, boolean isAppend) throws CoreException {
		Workbook book;
		if (uri.endsWith(XLS_EXTENSION)) {
			book = new HSSFWorkbook();
		} else if (uri.endsWith(XLSX_EXTENSION)) {
			book = new XSSFWorkbook();
		} else {
			throw new CoreException(EclDataApachePOIImplPlugin.createErr(
					"Error getting extension of file %s. Only 'xls' and 'xslx' are supported.", file.toURI()));
		}
		return book;
	}

	private void writeBook(Workbook book, EclFile file, String uri, boolean isAppend) throws CoreException {
		if (isAppend) {
			String tempUri = String.format(TEMP_FILE_NAME_PATTERN, uri);
			EclFile tempFile = FileResolver.resolve(tempUri);
			ExcelFileService.writeBook(book, tempFile);
			file.toFile().delete();
			tempFile.toFile().renameTo(file.toFile());
			return;
		}
		ExcelFileService.writeBook(book, file);
	}

	private int resolveHeaders(Sheet sheet, Table table, EclFile file) throws CoreException {
		Row header = sheet.getRow(0);
		if (header == null || header.getLastCellNum() == -1) {
			return writeValues(0, sheet, table.getColumns());
		}
		validateHeaders(sheet, table, file);
		return sheet.getLastRowNum() + 1;
	}

	private void validateHeaders(Sheet sheet, Table table, EclFile file) throws CoreException {
		Row headersRow = sheet.getRow(0);
		List<String> tableHeaders = table.getColumns();
		if (headersRow.getLastCellNum() != tableHeaders.size()) {
			throw new CoreException(EclDataApachePOIImplPlugin.createErr(
					"Table headers length from input does not match with headers length in the file", file.toURI()));
		}
		int cellnum = 0;
		for (String tableHeader : tableHeaders) {
			Cell headerCell = headersRow.getCell(cellnum);
			if (headerCell == null || !tableHeader.equals(ExcelFileService.getCellValue(headerCell))) {
				throw new CoreException(EclDataApachePOIImplPlugin.createErr(
						"%s table header from input does not match with header %d in the file", tableHeader, cellnum,
						file.toURI()));
			}
			cellnum++;
		}
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
