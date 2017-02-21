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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclBoolean;
import org.eclipse.rcptt.ecl.core.EclByte;
import org.eclipse.rcptt.ecl.core.EclChar;
import org.eclipse.rcptt.ecl.core.EclDouble;
import org.eclipse.rcptt.ecl.core.EclFloat;
import org.eclipse.rcptt.ecl.core.EclInteger;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.core.EclLong;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.core.EclShort;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.data.commands.ListAsTableData;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ListAsTableDataService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ListAsTableData latd = (ListAsTableData) command;
		EclList list = latd.getList();
		Table result = ObjectsFactory.eINSTANCE.createTable();

		List<String> columns = new ArrayList<String>();
		for (EObject object : list.getElements()) {
			if (!(object instanceof EclMap)) {
				return EclDataPlugin.createErr("Error getting input list. List entry is not EclMap");
			}
			EclMap map = (EclMap) object;
			try {
				columns = addRow(map, columns, result);
			} catch (CoreException e) {
				return e.getStatus();
			}
		}
		result.getColumns().addAll(columns);

		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	private List<String> addRow(EclMap map, List<String> columns, Table table) throws CoreException {
		Row row = ObjectsFactory.eINSTANCE.createRow();
		List<String> addedColumns = new ArrayList<String>();
		List<String> addedValues = new ArrayList<String>();
		for (EclMapEntry entry : map.getEntries()) {
			String key = getValue(entry.getKey());
			if (key == null) {
				throw new CoreException(
						EclDataPlugin.createErr("Error getting input list. Map key must not be null"));
			}
			String value = getValue(entry.getValue());
			if (columns.contains(key)) {
				row.getValues().add(value);
				continue;
			}
			addedColumns.add(key);
			addedValues.add(value);
		}
		columns.addAll(addedColumns);
		row.getValues().addAll(addedValues);
		table.getRows().add(row);
		return columns;
	}

	private String getValue(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof EclBoolean) {
			boolean value = ((EclBoolean) object).isValue();
			return String.valueOf(value);
		} else if (object instanceof EclByte) {
			byte value = ((EclByte) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclChar) {
			char value = ((EclChar) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclDouble) {
			double value = ((EclDouble) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclFloat) {
			float value = ((EclFloat) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclInteger) {
			int value = ((EclInteger) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclLong) {
			long value = ((EclLong) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclShort) {
			short value = ((EclShort) object).getValue();
			return String.valueOf(value);
		} else if (object instanceof EclString) {
			return ((EclString) object).getValue();
		}
		return object.toString();
	}

}
