/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.internal.commands;

import static org.eclipse.rcptt.ecl.data.internal.EclDataPlugin.createErr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.ReadCsvFile;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCsvFileService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ReadCsvFile)) {
			return Status.CANCEL_STATUS;
		}

		ReadCsvFile readFile = (ReadCsvFile) command;
		File file = FileResolver.resolve(readFile.getUri());
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			return createErr("Cannot read file %s", file.getAbsolutePath());
		}

		Table result = ObjectsFactory.eINSTANCE.createTable();
		try {
			String[] headers = reader.readNext();
			if (headers.length == 0) {
				return createErr("File %s does not contain any rows",
						file.getAbsolutePath());
			}

			boolean haveIndent = headers[0]
					.equals(WriteCsvFileService.INDENT_COLUMN);
			for (int i = haveIndent ? 1 : 0; i < headers.length; i++) {
				result.getColumns().add(headers[i]);
			}

			LinkedList<Row> stack = new LinkedList<Row>();
			String[] line = null;
			int lineNum = 0;

			while ((line = reader.readNext()) != null) {
				lineNum++;
				if (line.length != headers.length) {
					return createErr(
							"Value count in line %d differs from column counti in file %s ",
							lineNum, file.getAbsolutePath());
				}

				int indent = haveIndent ? Integer.parseInt(line[0]) : 0;
				while (indent < stack.size()) {
					stack.pop(); // throwing rows until falling on required
									// level
				}

				Row row = ObjectsFactory.eINSTANCE.createRow();
				for (int i = haveIndent ? 1 : 0; i < line.length; i++) {
					row.getValues().add(line[i]);
				}

				if (indent != stack.size() && (indent - stack.size()) > 1) {
					return createErr(
							"Error on line %d - indent level too high, can't determine parent row in file %s",
							lineNum, file.getAbsolutePath());
				}

				if (stack.size() > 0) {
					stack.peek().getChildren().add(row);
				} else {
					result.getRows().add(row);
				}

				stack.push(row);
			}
		} catch (IOException e) {
			return createErr(e, "Error reading file %s", file.getAbsolutePath());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// nothing to do
			}
		}

		context.getOutput().write(result);
		return Status.OK_STATUS;
	}
}
