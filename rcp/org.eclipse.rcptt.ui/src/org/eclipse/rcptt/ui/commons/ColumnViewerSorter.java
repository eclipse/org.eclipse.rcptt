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
package org.eclipse.rcptt.ui.commons;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public abstract class ColumnViewerSorter extends ViewerComparator {
	public static final int ASC = 1;

	public static final int NONE = 0;

	public static final int DESC = -1;

	private int direction = 0;

	private final TableViewerColumn column;

	private final ColumnViewer viewer;

	public ColumnViewerSorter(ColumnViewer viewer, TableViewerColumn column) {
		this.column = column;
		this.viewer = viewer;
		this.column.getColumn().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (ColumnViewerSorter.this.viewer.getComparator() != null) {
					if (ColumnViewerSorter.this.viewer.getComparator() == ColumnViewerSorter.this) {
						int tdirection = ColumnViewerSorter.this.direction;

						if (tdirection == ASC) {
							setSorter(ColumnViewerSorter.this, DESC);
						} else if (tdirection == DESC) {
							setSorter(ColumnViewerSorter.this, NONE);
						}
					} else {
						setSorter(ColumnViewerSorter.this, ASC);
					}
				} else {
					setSorter(ColumnViewerSorter.this, ASC);
				}
			}
		});
	}

	public void setSorter(ColumnViewerSorter sorter, int direction) {
		if (direction == NONE) {
			column.getColumn().getParent().setSortColumn(null);
			column.getColumn().getParent().setSortDirection(SWT.NONE);
			viewer.setComparator(null);
		} else {
			column.getColumn().getParent().setSortColumn(column.getColumn());
			sorter.direction = direction;

			if (direction == ASC) {
				column.getColumn().getParent().setSortDirection(SWT.DOWN);
			} else {
				column.getColumn().getParent().setSortDirection(SWT.UP);
			}

			if (viewer.getComparator() == sorter) {
				viewer.refresh();
			} else {
				viewer.setComparator(sorter);
			}
		}
		afterSort();
	}

	@Override
	public int compare(Viewer viewer, Object element1, Object element2) {
		return direction * doCompare(viewer, element1, element2);
	}

	protected abstract int doCompare(Viewer viewer, Object element1,
			Object element2);

	protected abstract void afterSort();
}
