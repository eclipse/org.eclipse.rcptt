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
package org.eclipse.rcptt.tesla.nebula.grid;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import java.util.List;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.nebula.NebulaUIElement;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.tesla.nebula.grid.parts.EmptyArea;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemCell;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

public class GridScrollingHelper {

	public static void scrollGridFor(NebulaUIElement grid, List<String> path) {
		GridItem item = NebulaViewers.searchGridItem(grid, path);
		showItemIfHidden(item);
	}

	public static void scrollGridFor(SelectData data, SWTUIElement parent) {
		Widget parentWidget = unwrapWidget(parent);

		// TODO implement it for whole item selection case (e.g. select "Item #3")

		if (parentWidget instanceof GridItem) {
			GridItem item = (GridItem) unwrapWidget(parent);
			showItemIfHidden(item);

			if (data.getKind().contentEquals(NebulaElementKinds.ITEM_CELL)) {
				ItemCell cell = ItemCell.from(data, item);
				showColumnIfHidden(cell.column); // scroll horizontally to the column
			}
		}
		else if (data.getKind().contentEquals(NebulaElementKinds.EMPTY_AREA)) {
			Grid grid = (Grid) unwrapWidget(parent); // GridItem case is handled above

			EmptyArea area = EmptyArea.fromPath(data.getPath().toArray(new String[] {}), grid);
			if (!area.top) {
				// scroll grid to bottom to see the empty area
				grid.setTopIndex(grid.getItemCount() - 1);
			}

			// scroll horizontally
			if (area.column != null)
				showColumnIfHidden(area.column); // to see the column
			else if (!area.left)
				grid.showColumn(NebulaViewers.getGridLastColumn(grid)); // to see an empty area on the right
		}
	}

	//

	public static void showItemIfHidden(GridItem item) {
		if (NebulaViewers.getItemBounds(item) == null) {
			Grid grid = item.getParent();

			// scroll grid vertically to see the item
			grid.setTopIndex(grid.getIndexOfItem(item));
		}
	}

	public static void showColumnIfHidden(GridColumn column) {
		Grid grid = column.getParent();
		Rectangle bounds = NebulaViewers.getColumnHeaderBounds(column);

		if (bounds == null || bounds.x > grid.getBounds().width)
			grid.showColumn(column);
	}

	public static void showPartIfHidden(ItemPart part) {
		showItemIfHidden(part.item);
		if (part instanceof ItemCell)
			showColumnIfHidden(((ItemCell) part).column);
	}

}
