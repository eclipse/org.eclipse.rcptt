/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
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

class SelectingItems extends SelectingThings {

	private final GridItem[] items;

	public SelectingItems(GridItem[] items) {
		this.items = items;
	}

	@Override
	public List<Object> selectionData() {
		return selectionDataFrom(items);
	}

	@Override
	public void selectUs(Grid grid) {
		grid.setSelection(items);
	}

	//

	protected void mouseActions() {
		GridScrollingHelper.showItemIfHidden(firstItem());

		Point first = clickPointFor(firstItem());
		events.sendEvent(grid, SWT.MouseDown, first.x, first.y, 1);

		// select whole item, but not as by row-header (for compatibility)
		selectUs(grid);

		// for multi-selection
		if (items.length > 1) {
			GridScrollingHelper.showItemIfHidden(lastItem());
			events.sendEvent(grid, lastItem(), SWT.Selection);
			events.sendEvent(grid, SWT.MouseMove);
		}

		Point last = clickPointFor(lastItem());
		events.sendEvent(grid, SWT.MouseUp, last.x, last.y, 1);
	}

	private GridItem firstItem() {
		return items[0];
	}

	private GridItem lastItem() {
		return items[items.length - 1];
	}

	private static Point clickPointFor(GridItem item) {
		// clicking first column cell for compatibility with old replaying behavior
		return Bounds.centerAbs(item.getBounds(0));
	}

}