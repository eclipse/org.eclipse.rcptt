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
package org.eclipse.rcptt.tesla.nebula.grid.selection;

import java.util.List;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

import org.eclipse.rcptt.util.swt.Bounds;
import org.eclipse.rcptt.tesla.nebula.grid.GridScrollingHelper;
import org.eclipse.rcptt.tesla.nebula.grid.parts.RowHeader;

public class SelectingRange extends SelectingThings {

	private final GridItem fromItem;
	private final GridItem toItem;

	public SelectingRange(GridItem fromItem, GridItem toItem) {
		this.fromItem = fromItem;
		this.toItem = toItem;
	}

	@Override
	public List<Object> selectionData() {
		return selectionDataFrom(items());
	}

	@Override
	public void selectUs(Grid grid) {
		grid.setSelection(items());
	}
	
	private GridItem[] items() {
		Grid grid = fromItem.getParent();
		int from = grid.getIndexOfItem(fromItem);
		int to = grid.getIndexOfItem(toItem);

		if (from > to) {
			int t = from;
			from = to;
			to = t;
		}
		
		GridItem[] items = new GridItem[to - from + 1];
		for (int i = from; i <= to; i++)
			items[i - from] = grid.getItem(i);
		return items;
	}

	//

	@Override
	protected void mouseActions() {

		// // imitate selection by dragging:
		// events.sendEvent(grid, SWT.MouseDown, from.x, from.y, 1);
		// events.sendEvent(grid, SWT.MouseMove, to.x, to.y, 1, SWT.BUTTON1);
		// events.sendEvent(grid, SWT.MouseUp, to.x, to.y, 1);
		// -- doesn't work for Metus, so we have to imitate "click - shift+click" behavior,
		// maybe later we should use some special option to support both techniques

		Point from = clickPointFor(fromItem);
		events.sendEvent(grid, SWT.MouseDown, from.x, from.y, 1);
		events.sendEvent(grid, SWT.MouseUp, from.x, from.y, 1);

		// can't scroll to see "toItem" in preExecute step in case when
		// it is distanced from "fromItem" by more than one screen, so doing it here
		GridScrollingHelper.showItemIfHidden(toItem);

		Point to = clickPointFor(toItem);
		events.sendEvent(grid, SWT.MouseMove, to.x, to.y, 1);
		events.sendEvent(grid, SWT.MouseDown, to.x, to.y, 1, SWT.SHIFT);
		events.sendEvent(grid, SWT.MouseUp, to.x, to.y, 1, SWT.SHIFT);
	}

	private Point clickPointFor(GridItem item) {
		if (grid.isRowHeaderVisible())
			return Bounds.centerAbs(new RowHeader(item).bounds());
		else {
			// using first column, when row-headers are hidden;
			// even though it may not be working properly in certain cases
			return Bounds.centerAbs(item.getBounds(0));
		}
	}

}
