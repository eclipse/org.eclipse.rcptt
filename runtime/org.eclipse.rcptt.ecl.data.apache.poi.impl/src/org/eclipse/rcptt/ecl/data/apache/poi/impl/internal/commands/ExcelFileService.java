package org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.commands;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.data.apache.poi.impl.internal.EclDataApachePOIImplPlugin;
import org.eclipse.rcptt.ecl.filesystem.EclFile;

public class ExcelFileService {

	public static Workbook readBook(EclFile file) throws CoreException {
		Workbook book;
		try {
			book = WorkbookFactory.create(file.toFile());
		} catch (InvalidFormatException e) {
			throw new CoreException(
					EclDataApachePOIImplPlugin
							.createErr("Error getting extension of file %s. Only 'xls' and 'xslx' are supported.",
									file.toURI()));
		} catch (IOException e) {
			throw new CoreException(
					EclDataApachePOIImplPlugin
							.createErr(e, "Error reading file %s", file.toURI()));
		}
		return book;
	}

	public static void writeBook(Workbook book, EclFile file) throws CoreException {
		try {
			FileOutputStream stream = new FileOutputStream(file.toFile());
			book.write(stream);
			stream.close();
		} catch (IOException e) {
			throw new CoreException(
					EclDataApachePOIImplPlugin
							.createErr(e, "Error writing file %s", file.toURI()));
		}
	}

	public static String getCellValue(Cell cell) {
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
