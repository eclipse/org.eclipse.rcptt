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
import org.eclipse.rcptt.ecl.data.commands.ExcludeColumns;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ExcludeColumnsService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ExcludeColumns)) {
			return Status.CANCEL_STATUS;
		}

		ExcludeColumns ec = (ExcludeColumns) command;
		Table source = ec.getTable();
		List<String> srcColumns = source.getColumns();
		List<String> excludeColumns = ec.getColumns();
		List<Integer> indices = new ArrayList<Integer>();
		List<String> destColumns = new ArrayList<String>();

		for (int i = 0; i < srcColumns.size(); i++) {
			String srcColumn = srcColumns.get(i);
			if (!excludeColumns.contains(srcColumn)) {
				indices.add(i);
				destColumns.add(srcColumn);
			}
		}

		Table result = ObjectsFactory.eINSTANCE.createTable();
		result.getColumns().addAll(destColumns);

		for (Row row : source.getRows()) {
			result.getRows().add(
					SelectColumnsService.extractSubrow(row, indices));
		}
		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

}
