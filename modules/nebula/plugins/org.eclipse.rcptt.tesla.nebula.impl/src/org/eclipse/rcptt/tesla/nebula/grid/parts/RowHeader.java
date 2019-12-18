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

import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.rcptt.tesla.nebula.Messages;

public class RowHeader extends ItemPart {

	public RowHeader(GridItem item) {
		super(item);
		if (!grid().isRowHeaderVisible())
			throw new IllegalArgumentException(Messages.HiddenRowHeaders);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +
				(item != null ? " of " + item.toString() : " area");
	}

	//

	public Rectangle bounds() {
		return new Rectangle(
				0, itemBounds().y,
				grid().getItemHeaderWidth(), itemBounds().height);
	}

	@Override
	public void selectMeInGrid() {
		
		// select all the cells of an item
		Point[] cells = new Point[grid().getColumnCount()];
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new Point(i, row());
		}
		
		grid().setCellSelection(cells);
	}

}
