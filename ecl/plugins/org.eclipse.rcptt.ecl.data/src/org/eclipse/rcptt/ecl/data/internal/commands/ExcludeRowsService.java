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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.ExcludeRows;
import org.eclipse.rcptt.ecl.data.commands.RowMatchMode;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ExcludeRowsService extends TableRowMatcher implements
		ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ExcludeRows)) {
			return Status.CANCEL_STATUS;
		}

		ExcludeRows ec = (ExcludeRows) command;
		Table source = ec.getTable();
		List<String> srcColumns = source.getColumns();
		String filterColumn = ec.getColumn();
		if (filterColumn == null) {
			return EclDataPlugin
					.createErr(
							"Failed to filter table. column argument is not specified.",
							new Object[] {});
		}
		int columnIndex = srcColumns.indexOf(filterColumn);
		RowMatchMode match = ec.getMatch();

		String value = ec.getValue();
		if (value == null) {
			return EclDataPlugin.createErr(
					"Failed to filter table. Pattern value is not specified.",
					new Object[] {});
		}
		IMatcher matcher = createMatcher(match, value);
		Table result = ObjectsFactory.eINSTANCE.createTable();

		result.getColumns().addAll(source.getColumns());
		if (columnIndex == -1) {
			context.getOutput().write(result);
			return Status.OK_STATUS;
		}
		for (Row row : source.getRows()) {
			String columnValue = row.getValues().get(columnIndex);
			if (!matcher.match(columnValue)) {
				result.getRows().add(EcoreUtil.copy(row));
			}
		}
		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

}
