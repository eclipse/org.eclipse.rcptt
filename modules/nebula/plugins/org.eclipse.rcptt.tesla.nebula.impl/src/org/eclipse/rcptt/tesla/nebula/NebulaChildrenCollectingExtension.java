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
package org.eclipse.rcptt.tesla.nebula;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.util.swt.Bounds;
import org.eclipse.rcptt.tesla.internal.ui.player.ChildrenCollectingSession;
import org.eclipse.rcptt.tesla.internal.ui.player.IChildrenCollectingExtension;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

public class NebulaChildrenCollectingExtension implements IChildrenCollectingExtension {

	private ChildrenCollectingSession s;

	public NebulaChildrenCollectingExtension(ChildrenCollectingSession s) {
		this.s = s;
	}

	//

	public void collect() {
		if (!s.needToCollectMenuItems())
			return;

		if (s.w instanceof NebulaPartUIElement) {
			NebulaPartUIElement w = (NebulaPartUIElement) s.w;
			collectMenuItemsFromPartBounds(w.part.grid(), w.part.bounds());

		} else {
			Widget widget = unwrapWidget(s.w);
			if (widget instanceof GridColumn) {
				GridColumn column = (GridColumn) widget;
				Grid grid = column.getParent();
				collectMenuItemsFromPartBounds(grid,
						NebulaViewers.getColumnHeaderBounds(column));
			}
			else if (widget instanceof GridItem) {
				GridItem item = (GridItem) widget;
				Grid grid = item.getParent();
				collectMenuItemsFromPartBounds(grid,
						item.getBounds(0));
			}
		}
	}

	private void collectMenuItemsFromPartBounds(Grid grid, Rectangle bounds) {
		if (bounds == null)
			return; // TODO return a message, that the column header is hidden
					// ... (column, or whatever it is)

		// or maybe the grid should be scrolled to make that column visible

		collectMenuItemsFromPoint(grid, Bounds.centerAbs(bounds));
	}

	private void collectMenuItemsFromPoint(Grid grid, Point point) {

		// imitate the mouse location, some of the clients are using
		// it to determine which menu to open (e.g. in Metus)

		// TeslaEventManager.getManager().setLastWidget(grid,
		// point.x, point.y);

		// now we are using this method instead for consistency
		s.player.addMouseWidgetInfo(grid, point.x, point.y);
		//

		point = grid.getDisplay().map(grid, null, point);

		// some of the clients maybe are using this event for
		// determination (don't know if they are use it actually)
		s.player.getEvents().sendEvent(grid, SWT.MenuDetect, point.x, point.y, 3);

		s.collectMenuItems(grid.getMenu(), point);

		// maybe we should clean up the mouse location
		// TeslaEventManager.getManager().setLastWidget(null, 0, 0);
	}

}
