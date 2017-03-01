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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Row;
import org.eclipse.rcptt.ecl.data.objects.Table;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class AssertTablesMatchService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		AssertTablesMatch cmd = (AssertTablesMatch) command;
		final boolean ignoreOrder = cmd.isIgnoreColumnOrder();
		Table leftTable = cmd.getLeft();
		Table rightTable = cmd.getRight();

		if (EcoreUtil.equals(leftTable, rightTable)) {
			return Status.OK_STATUS; // fast comparison
		}

		List<Column> leftColumns = toColumns(leftTable.getColumns());
		List<Column> rightColumns = toColumns(rightTable.getColumns());
		switch (cmd.getIgnoreMissingColumns()) {
		case LEFT:
			rightColumns = excludeNotPresent(rightColumns, leftColumns);
			break;
		case RIGHT:
			leftColumns = excludeNotPresent(leftColumns, rightColumns);
			break;
		case BOTH:
			rightColumns = excludeNotPresent(rightColumns, leftColumns);
			leftColumns = excludeNotPresent(leftColumns, rightColumns);
			break;
		case NONE:
			// nothing to do
			break;
		}

		if (leftColumns.size() != rightColumns.size()) {
			return EclDataPlugin.createErr(
					"Columns in left table(%s) don't match "
							+ "to columns in right table(%s)",
					columnNames(leftColumns), columnNames(rightColumns));
		}

		if (!ignoreOrder) {
			// just iterating through columns to make sure
			// names match
			for (int i = 0; i < leftColumns.size(); i++) {
				if (!rightColumns.get(i).name.equals(leftColumns.get(i).name)) {
					return EclDataPlugin
							.createErr(
									"Different columns at position %d: left table has '%s', while right column has '%s'",
									i, leftColumns.get(i).name,
									rightColumns.get(i).name);
				}
			}
		} else {
			// reordering right columns according to left columns (if reordering
			// is allowed)
			List<Column> tmp = new ArrayList<Column>();
			for (Column left : leftColumns) {
				Column right = findColumn(rightColumns, left.name);
				if (right == null) {
					return EclDataPlugin.createErr(
							"Unmatched column '%s' in left table", left.name);
				}
				tmp.add(right);
				rightColumns.remove(right);
			}
			rightColumns = tmp;
		}

		return rowsMatch(leftColumns, rightColumns, leftTable.getRows(),
				rightTable.getRows(), new Position());
	}

	private static IStatus rowsMatch(List<Column> leftColumns,
			List<Column> rightColumns, List<Row> leftRows, List<Row> rightRows,
			Position pos) {
		if (leftRows.size() != rightRows.size()) {
			return EclDataPlugin.createErr("Child row count differ, %s",
					pos.toString());
		}

		for (int row = 0; row < leftRows.size(); row++) {
			Row leftRow = leftRows.get(row);
			Row rightRow = rightRows.get(row);

			for (int col = 0; col < leftColumns.size(); col++) {
				Column lc = leftColumns.get(col);
				Column rc = rightColumns.get(col);
				String lv = leftRow.getValues().get(lc.index);
				String rv = rightRow.getValues().get(rc.index);
				if (!(lv != null && rv != null && lv.equals(rv)
						|| lv == null && rv == null)) {
					return EclDataPlugin
							.createErr(
									"Tables differ at column '%s', %s: "
											+ "left value is '%s', right value is '%s'",
									lc.name, pos.toString(), lv, rv);
				}
			}

			pos.goIn(); // comparing children
			IStatus childResult = rowsMatch(leftColumns, rightColumns,
					leftRow.getChildren(), rightRow.getChildren(), pos);
			if (!childResult.isOK()) {
				return childResult;
			}
			pos.goOut();
			pos.nextSibling();
		}

		return Status.OK_STATUS;
	}

	private static List<Column> toColumns(List<String> columnNames) {
		List<Column> result = new ArrayList<Column>();
		for (int i = 0; i < columnNames.size(); i++) {
			result.add(new Column(columnNames.get(i), i));
		}
		return result;
	}

	/**
	 * Aggregates information about name and index
	 * 
	 */
	private static class Column {
		public Column(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public final String name;
		public final int index;
	}

	/**
	 * Mutable position in tree
	 * 
	 * @author ivaninozemtsev
	 * 
	 */
	private static class Position {
		private int absoluteIndex = 0;
		private int currentIndex = 0;
		private List<Integer> indexPath = new ArrayList<Integer>();

		public void nextSibling() {
			currentIndex++;
		}

		public void goIn() {
			indexPath.add(currentIndex);
			currentIndex = 0;
		}

		public void goOut() {
			currentIndex = indexPath.get(indexPath.size() - 1);
			indexPath.remove(indexPath.size() - 1);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int index : indexPath) {
				sb.append(index).append("/");
			}
			sb.append(currentIndex);
			return String.format(
					"absolute row index '%d' (path in tree - '%s')",
					absoluteIndex, sb.toString());
		}
	}

	/**
	 * Removes all elements from <code>from</code> param, which cannot be found
	 * in <code>where</code> param
	 * 
	 * @param from
	 * @param where
	 * @return new array list
	 */
	private static final List<Column> excludeNotPresent(List<Column> from,
			List<Column> where) {
		List<Column> result = new ArrayList<Column>();
		for (Column column : from) {
			if (containsName(where, column.name)) {
				result.add(column);
			}
		}
		return result;
	}

	private static final String SEP = ", ";

	private static final String columnNames(List<Column> columns) {
		if (columns.isEmpty()) {
			return "<no columns>";
		}
		StringBuilder sb = new StringBuilder();

		for (Column column : columns) {
			sb.append(column.name).append(SEP);
		}
		sb.setLength(sb.length() - SEP.length());
		return sb.toString();
	}

	private static final boolean containsName(List<Column> columns, String name) {
		return findColumn(columns, name) != null;
	}

	private static final Column findColumn(List<Column> columns, String name) {
		for (Column column : columns) {
			if (column.name.equals(name)) {
				return column;
			}
		}
		return null;
	}

}
