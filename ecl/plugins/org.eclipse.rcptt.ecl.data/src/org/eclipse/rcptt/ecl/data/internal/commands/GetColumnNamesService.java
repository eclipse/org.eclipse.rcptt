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
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.data.commands.GetColumnNames;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetColumnNamesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetColumnNames gcn = (GetColumnNames) command;
		Table table = gcn.getTable();
		EList<String> columns = table.getColumns();
		EclList result = createList(columns);

		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	private static EclList createList(EList<String> list) {
		EclList eclList = CoreFactory.eINSTANCE.createEclList();
		for (String entry : list) {
			EclString entryString = CoreFactory.eINSTANCE.createEclString();
			entryString.setValue(entry);
			eclList.getElements().add(entryString);
		}
		return eclList;
	}

}
