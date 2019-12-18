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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.Print;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class PrintService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Print)) {
			return Status.CANCEL_STATUS;
		}
		List<EObject> input = ((Print) command).getInput();
		// print table with attributes

		printTable(context.getOutput(), input);
		return Status.OK_STATUS;
	}

	private void printTable(IPipe out, List<EObject> input)
			throws CoreException {
		Set<String> columns = new TreeSet<String>();
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		for (Object o : input) {
			if (!(o instanceof EObject)) {
				continue;
			}
			Map<String, String> row = getRow((EObject) o);
			rows.add(row);
			columns.addAll(row.keySet());
		}

		// define column width for each col
		int[] widths = new int[columns.size()];
		String[] colNames = columns.toArray(new String[columns.size()]);

		for (int i = 0; i < widths.length; i++) {
			widths[i] = colNames[i].length();
		}

		for (int i = 0; i < widths.length; i++) {
			String col = colNames[i];
			for (Map<String, String> row : rows) {
				String strVal = row.get(col);
				if (strVal != null && strVal.length() > widths[i]) {
					widths[i] = strVal.length();
				}
			}
		}

		// print header
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for (int i = 0; i < colNames.length; i++) {
			sb.append(String.format("%-" + widths[i] + "s", colNames[i]))
					.append("|");
		}

		out.write(sb.toString());

		sb.setLength(0);
		sb.append("+");
		for (int i = 0; i < colNames.length; i++) {
			char[] sep = new char[widths[i]];
			Arrays.fill(sep, '-');
			sb.append(new String(sep));
			sb.append("+");
		}

		out.write(sb.toString());

		for (Map<String, String> row : rows) {
			sb.setLength(0);
			sb.append("|");
			for (int i = 0; i < colNames.length; i++) {
				String val = row.get(colNames[i]);
				sb.append(String.format("%-" + widths[i] + "s", val));
				sb.append("|");
			}
			out.write(sb.toString());
		}
	}

	private Map<String, String> getRow(EObject obj) {
		Map<String, String> result = new HashMap<String, String>();
		for (EAttribute attr : obj.eClass().getEAllAttributes()) {
			Object val = obj.eGet(attr);
			String strVal = null;
			if (val != null) {
				strVal = val.toString();
			}
			result.put(attr.getName(), strVal);
		}
		return result;
	}
}
