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

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.WriteCsvFile;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.filesystem.Util;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import au.com.bytecode.opencsv.CSVWriter;

public class WriteCsvFileService implements ICommandService {
	static final String INDENT_COLUMN = "_indent";

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof WriteCsvFile)) {
			return Status.CANCEL_STATUS;
		}
		WriteCsvFile wcf = (WriteCsvFile) command;
		EclFile file = FileResolver.resolve(wcf.getUri());
		Table table = wcf.getTable();

		List<String> columns = new ArrayList<String>();
		boolean haveChildren = haveChildren(table);

		if (haveChildren) {
			columns.add(INDENT_COLUMN); // first column is going to be 'indent'
		}
		columns.addAll(table.getColumns());

		try {
			Writer fileWriter = Util.getWriter(file, wcf.isAppend());
			CSVWriter writer = new CSVWriter(fileWriter);
			writer.writeNext(columns.toArray(new String[columns.size()]), false);
			for (Row row : table.getRows()) {
				writeRow(writer, row, 0, haveChildren);
			}
			writer.close();
		} catch (IOException e) {
			return EclDataPlugin.createErr(e, "Error writing file %s",
					file.toURI());
		}

		context.getOutput().write(table);
		return Status.OK_STATUS;
	}

	private void writeRow(CSVWriter writer, Row row, int indent,
			boolean haveChildren) {
		List<String> values = new ArrayList<String>();
		if (haveChildren) {
			values.add(Integer.toString(indent));
		}
		values.addAll(row.getValues());
		writer.writeNext(values.toArray(new String[values.size()]), false);
		for (Row child : row.getChildren()) {
			writeRow(writer, child, indent + 1, haveChildren);
		}
	}

	private static boolean haveChildren(Table table) {
		for (Row row : table.getRows()) {
			if (row.getChildren().size() > 0) {
				return true;
			}
		}
		return false;
	}
}
