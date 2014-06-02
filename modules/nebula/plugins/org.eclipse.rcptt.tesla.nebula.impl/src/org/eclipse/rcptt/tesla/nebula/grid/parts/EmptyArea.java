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
package org.eclipse.rcptt.tesla.nebula.grid.parts;

import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.COLUMN;
import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.LEFT;
import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.TOP;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

public class EmptyArea implements GridPart {

	public final Grid grid;
	public final boolean top;
	public final boolean left;
	public final GridColumn column;
	public final GridItem item;

	public EmptyArea(Grid grid, boolean top, boolean left) {
		this.grid = grid;
		this.top = top;
		this.left = left;
		column = null;
		item = null;
	}

	public EmptyArea(Grid grid, GridColumn column, GridItem item) {
		this.grid = grid;
		top = left = false;
		this.column = column;
		this.item = item;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getClass().getSimpleName());
		if (top)
			sb.append(" top");
		if (left)
			sb.append(" left");
		if (column != null)
			sb.append(" of column " + column);
		if (item != null)
			sb.append(" of item " + item);
		return sb.toString();
	}

	//

	public static EmptyArea corner(Grid grid) {
		return new EmptyArea(grid, true, true);
	}

	public static EmptyArea topRight(Grid grid) {
		return new EmptyArea(grid, true, false);
	}

	public static EmptyArea left(Grid grid) {
		return new EmptyArea(grid, false, true);
	}

	public static EmptyArea right(Grid grid) {
		return new EmptyArea(grid, false, false);
	}

	public static EmptyArea of(GridColumn column) {
		return new EmptyArea(column.getParent(), column, null);
	}

	public static EmptyArea of(GridItem item) {
		return new EmptyArea(item.getParent(), null, item);
	}

	//

	public String[] path() {
		List<String> path = new LinkedList<String>();
		if (top)
			path.add(TOP);
		if (left)
			path.add(LEFT);
		if (column != null) {
			Assert.isTrue(path.isEmpty()); // -column should not be used
											// with -top or -left
			path.add(COLUMN);
			path.add(column.getText());
		}
		return path.toArray(new String[] {});
	}

	public static EmptyArea fromPath(String[] path, Grid grid) {
		boolean top = false;
		boolean left = false;
		for (String pa : path) {
			if (pa.equals(TOP))
				top = true;
			if (pa.equals(LEFT))
				left = true;

			if (pa.equals(COLUMN)) { // must be the first part of the path
				Assert.isTrue(path[0].equals(COLUMN) && path.length == 2);
				
				String columnTitle = path[1];
				GridColumn column = NebulaViewers.findColumn(grid, columnTitle, 0);
				return EmptyArea.of(column);
			}
		}
		return new EmptyArea(grid, top, left);
	}

	//

	public static SWTUIElement select(SWTUIPlayer p, PlayerSelectionFilter f) {
		Widget w = PlayerWrapUtils.unwrapWidget(f.parent);
		if (w instanceof GridItem)
			return p.wrap(EmptyArea.of((GridItem) w));
		else if (w instanceof Grid)
			return p.wrap(EmptyArea.fromPath(f.path, (Grid) w));
		throw new IllegalArgumentException("f.parent have to be a Grid or a GridItem");
	}

	//

	@Override
	public Grid grid() {
		return grid;
	}

	@Override
	public Rectangle bounds() {

		// values for the TOP LEFT case, other cases are handled below
		int x = 0;
		int y = 0;
		int width = grid.getItemHeaderWidth();
		int height = grid.getHeaderHeight();

		if (item != null) {
			Rectangle itemBounds = NebulaViewers.getItemBounds(item);
			y = itemBounds.y;
			height = itemBounds.height;
		}
		else if (!top) {
			Rectangle lastItemBounds = NebulaViewers.getLastVisibleItemBounds(grid);
			y = (lastItemBounds != null)
					? lastItemBounds.y + lastItemBounds.height
					: grid.getHeaderHeight();
			height = grid.getBounds().height - y;
		}
		
		if (column != null) {
			Rectangle columnBounds = NebulaViewers.getColumnHeaderBounds(column);
			x = columnBounds.x;
			width = columnBounds.width;
		}
		else if (!left) {
			GridColumn lastColumn = NebulaViewers.getGridLastColumn(grid);
			Rectangle lastColumnBounds = NebulaViewers.getColumnHeaderBounds(lastColumn);
			x = lastColumnBounds.x + lastColumnBounds.width;
			width = grid.getBounds().width - x;
		}

		return new Rectangle(x, y, width, height);
	}

}
