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
package org.eclipse.rcptt.tesla.recording.nebula;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;

import org.eclipse.rcptt.tesla.nebula.grid.parts.GridPart;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemCell;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.grid.parts.RowHeader;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

/**
 * Tracks how grid parts have been selected, as the way of selection (by cells or by row-header) can be important for
 * AUTs (and it is important for Metus, for example), but that information is not stored in the grid itself.
 */
public class NebulaGridSelectionManager {

	private static final Map<Grid, NebulaGridSelectionManager> managers = new WeakHashMap<Grid, NebulaGridSelectionManager>();

	public static NebulaGridSelectionManager forGrid(Grid grid) {
		if (!managers.containsKey(grid))
			managers.put(grid, new NebulaGridSelectionManager(grid));
		return managers.get(grid);
	}
	
	private final Grid grid;
	
	public NebulaGridSelectionManager(Grid grid) {
		this.grid = grid;
	}

	//

	private final Set<ItemPart> parts = new LinkedHashSet<ItemPart>(); // preserves insertion order on iteration
	private ItemPart lastSelectedPart; // for ranges selection

	/**
	 * Handles selection event, adding a new selected part into the list.
	 * 
	 * @return The set containing selected parts, which preserves iteration order (as parts have been selected).
	 */
	public Set<ItemPart> handle(Event event) {

		if ((event.stateMask & SWT.MOD1) == 0)
			parts.clear();

		GridPart part = NebulaViewers.getGridPartFromPoint(grid, new Point(event.x, event.y));
		if (part instanceof ItemPart) {
			parts.add((ItemPart) part);
			lastSelectedPart = (ItemPart) part; // for ranges selection

			// some cells could be removed from the selection by repeated clicks on them
			Iterator<ItemPart> it = parts.iterator();
			while (it.hasNext())
				if (!stillSelected(it.next()))
					it.remove();

			// some cells could be selected before recording was started,
			// or be retained when user deselected a cell from the row selected before
			for (Point coords : grid.getCellSelection()) {
				ItemCell cell = NebulaViewers.getItemCellFromCoords(grid, coords);
				if (!inSelectedRow(cell))
					parts.add(cell);
			}
		}

		return parts;
	}

	public ItemPart rangeFrom() {
		return lastSelectedPart;
	}

	public ItemPart handleRange(Event event) {
		Assert.isTrue((event.stateMask & (SWT.SHIFT | SWT.BUTTON1)) != 0);

		GridPart part = NebulaViewers.getGridPartFromPoint(grid, new Point(event.x, event.y));
		// Assert.isTrue(part instanceof ItemPart);

		return (part instanceof ItemPart) ? (ItemPart) part : null;
	}

	//

	private boolean stillSelected(ItemPart part) {
		int y = grid.getIndexOfItem(part.item); // ? NebulaViewers.getGridItemIndex();
		if (part instanceof ItemCell) {
			ItemCell cell = (ItemCell) part;
			int x = NebulaViewers.getColumnIndex(cell.column);
			return grid.isCellSelected(new Point(x, y));
		}
		if (part instanceof RowHeader) {
			for (int x = 0; x < grid.getColumnCount(); x++)
				if (!grid.isCellSelected(new Point(x, y)))
					return false;
		}
		return true;
	}

	private boolean inSelectedRow(ItemCell cell) {
		for (ItemPart part : parts)
			if (part instanceof RowHeader)
				if (part.item == cell.item)
					return true;
		return false;
	}



}
