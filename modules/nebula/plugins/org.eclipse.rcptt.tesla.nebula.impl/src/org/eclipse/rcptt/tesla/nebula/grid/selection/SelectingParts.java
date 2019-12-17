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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

import org.eclipse.rcptt.util.swt.Bounds;
import org.eclipse.rcptt.tesla.nebula.grid.GridScrollingHelper;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;

class SelectingParts extends SelectingThings {

	private final List<ItemPart> parts;

	public SelectingParts(List<ItemPart> parts) {
		this.parts = parts;
	}

	@Override
	public List<Object> selectionData() {
		List<GridItem> items = new ArrayList<GridItem>(parts.size());
		for (ItemPart part : parts)
			items.add(part.item);
		return SelectingItems.selectionDataFrom(items.toArray(new GridItem[] {}));
	}

	@Override
	public void selectUs(Grid grid) {
		// ? part.selectMeInGrid();
	}

	//

	protected void mouseActions() {
		boolean first = true;
		for (ItemPart part : parts) {
			// we can't scroll to see all the items on preExecute stage
			// if there are cells distant from each other;
			// so let's do it now:
			GridScrollingHelper.showPartIfHidden(part);

			Point point = Bounds.centerAbs(part.bounds());
			if (first) {
				events.sendEvent(grid, SWT.MouseDown, point.x, point.y, 1);
				events.sendEvent(grid, SWT.MouseUp, point.x, point.y, 1);
				first = false;
			} else {
				events.sendEvent(grid, SWT.MouseMove, point.x, point.y, 1);
				events.sendEvent(grid, SWT.MouseDown, point.x, point.y, 1, SWT.MOD1);
				events.sendEvent(grid, SWT.MouseUp, point.x, point.y, 1, SWT.MOD1);
			}
		}
	}

}
