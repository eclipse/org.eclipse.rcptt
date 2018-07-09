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
package org.eclipse.rcptt.ecl.data.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.data.commands.ListAsTableData;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ListAsTableDataService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ListAsTableData latd = (ListAsTableData) command;
		EclList list = latd.getList();
		Table table = ObjectsFactory.eINSTANCE.createTable();

		for (EObject object : list.getElements()) {
			if (!(object instanceof EclList)) {
				return EclDataPlugin.createErr("Error getting input list. List entry is not EclList");
			}
			EclList rowData = (EclList) object;
			addRow(rowData, table);
		}

		context.getOutput().write(table);
		return Status.OK_STATUS;
	}

	private void addRow(EclList rowData, Table table) throws CoreException {
		Row row = ObjectsFactory.eINSTANCE.createRow();
		for (EObject object : rowData.getElements()) {
			String value = getValue(object);
			row.getValues().add(value);
		}
		table.getRows().add(row);
	}

	private String getValue(EObject obj) {
		Object object = BoxedValues.unbox(obj);
		if (object == null) {
			return null;
		}
		return String.valueOf(object);
	}

}
