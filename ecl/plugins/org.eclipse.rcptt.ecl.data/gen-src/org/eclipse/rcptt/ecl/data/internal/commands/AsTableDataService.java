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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.AsTableData;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class AsTableDataService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		AsTableData asTableData = (AsTableData) command;

		Table table = ObjectsFactory.eINSTANCE.createTable();
		EList<EObject> input = asTableData.getInput();

		if (input.size() > 0) {
			EClass class_ = input.get(0).eClass();
			addColumns(table, class_);

			for (EObject o : input)
				if (o.eClass() == class_)
					addRow(table, o);
				else
					return error("Unable to convert to table data, input objects class inconsistency detected.");
		}

		context.getOutput().write(table);
		return Status.OK_STATUS;
	}

	private static void addRow(Table table, EObject o) {
		Row row = ObjectsFactory.eINSTANCE.createRow();
		for (EStructuralFeature attr : o.eClass().getEAllStructuralFeatures())
			row.getValues().add("" + BoxedValues.unbox(o.eGet(attr)));
		table.getRows().add(row);
	}

	private static void addColumns(Table table, EClass class_) {
		for (EStructuralFeature attr : class_.getEAllStructuralFeatures())
			table.getColumns().add(attr.getName());
	}

	private static Status error(String message) {
		return new Status(Status.ERROR, EclDataPlugin.PLUGIN_ID, message);
	}
}
