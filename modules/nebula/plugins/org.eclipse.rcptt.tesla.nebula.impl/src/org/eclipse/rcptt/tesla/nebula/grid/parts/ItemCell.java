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
package org.eclipse.rcptt.tesla.nebula.grid.parts;

import org.eclipse.core.runtime.Assert;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.Messages;
import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Widget;

public class ItemCell extends ItemPart {

	public final GridColumn column;

	public ItemCell(GridItem item, GridColumn column) {
		super(item);
		Assert.isNotNull(column);
		this.column = column;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + item + " x " + column + "]";
	}

	//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();	
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCell other = (ItemCell) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		return true;
	}

	//

	public static ItemCell from(SelectData data, GridItem item, Integer index) {
		return from(data.getPattern(), item, index);
	}

	public static ItemCell from(String pattern, GridItem item, Integer index) {

		Grid grid = ((GridItem) item).getParent();
		GridColumn column = null;
		if(index != null)
			column = NebulaViewers.findColumn(grid, pattern, index);
		else {
			column = NebulaViewers.findColumn(grid, pattern, 0);
		}
		if (column == null)
			throw new IllegalArgumentException(Messages.bind(Messages.ColumnNotExist, pattern));
		// TODO check that this exception handled on menu-clicks replaying (maybe in SWTUIProcessor)

		return new ItemCell((GridItem) item, column);
	}

	public static SWTUIElement select(SWTUIPlayer p, PlayerSelectionFilter f) {
		Widget item = PlayerWrapUtils.unwrapWidget(f.parent);
		if (!(item instanceof GridItem))
			return null;

		return p.wrap(ItemCell.from(f.pattern, (GridItem) item, f.index));
	}

	//

	@Override
	public Rectangle bounds() {
		Rectangle columnHeaderBounds = NebulaViewers.getColumnHeaderBounds(column);
		if (columnHeaderBounds != null) {
			return new Rectangle(columnHeaderBounds.x, itemBounds().y, columnHeaderBounds.width, itemBounds().height);
		}
		if (item == null || NebulaViewers.getColumnCurrentPosition(column) == -1 || item.isDisposed()){
            return new Rectangle(0, 0, 0, 0);
	 }
	return item.getBounds(NebulaViewers.getColumnCurrentPosition(column));
	}

	// replaying selection stuff

	@Override
	public void selectMeInGrid() {
		grid().setCellSelection(new Point(column(), row()));
	}

	private int column() {
		return grid().indexOf(column);
	}

}
