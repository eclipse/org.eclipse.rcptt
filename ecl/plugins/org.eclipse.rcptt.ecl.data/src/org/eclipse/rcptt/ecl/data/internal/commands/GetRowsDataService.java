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
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.data.commands.GetRowsData;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetRowsDataService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetRowsData gr = (GetRowsData) command;
		Table table = gr.getTable();
		EclList result = createList(table);

		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	private static EclList createList(Table table) {
		EclList list = CoreFactory.eINSTANCE.createEclList();
		EList<String> columns = table.getColumns();
		for (Row row : table.getRows()) {
			int colnum = 0;
			EList<String> values = row.getValues();
			EclMap map = CoreFactory.eINSTANCE.createEclMap();
			for (String column : columns) {
				EclMapEntry entry = createMapEntry(column, values.get(colnum));
				map.getEntries().add(entry);
				colnum++;
			}
			list.getElements().add(map);
		}
		return list;
	}

	private static EclMapEntry createMapEntry(String key, String value) {
		EclString keyString = CoreFactory.eINSTANCE.createEclString();
		keyString.setValue(key);
		EclString valueString = CoreFactory.eINSTANCE.createEclString();
		valueString.setValue(value);

		EclMapEntry entry = CoreFactory.eINSTANCE.createEclMapEntry();
		entry.setKey(keyString);
		entry.setValue(valueString);
		return entry;
	}

}
