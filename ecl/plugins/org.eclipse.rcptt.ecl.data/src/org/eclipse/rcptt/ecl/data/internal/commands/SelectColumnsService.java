/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.SelectColumns;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class SelectColumnsService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws CoreException {
		if (!(command instanceof SelectColumns)) {
			return Status.CANCEL_STATUS;
		}

		SelectColumns ec = (SelectColumns) command;
		Table source = ec.getTable();
		List<String> srcColumns = source.getColumns();
		List<String> destColumns = ec.getColumns();
		List<Integer> indices = new ArrayList<Integer>();

		for (int i = 0; i < destColumns.size(); i++) {
			String destColumn = destColumns.get(i);
			int index = srcColumns.indexOf(destColumn);
			if (index == -1) {
				return EclDataPlugin
						.createErr("Source table does not contain column '%s'",
								destColumn);
			}
			indices.add(index);
		}

		Table result = ObjectsFactory.eINSTANCE.createTable();
		result.getColumns().addAll(destColumns);
		for (Row row : source.getRows()) {
			result.getRows().add(extractSubrow(row, indices));
		}
		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	static Row extractSubrow(Row src, List<Integer> indices) {
		Row result = ObjectsFactory.eINSTANCE.createRow();
		for (int index : indices) {
			result.getValues().add(src.getValues().get(index));
		}
		for (Row child : src.getChildren()) {
			result.getChildren().add(extractSubrow(child, indices));
		}
		return result;
	}
}
