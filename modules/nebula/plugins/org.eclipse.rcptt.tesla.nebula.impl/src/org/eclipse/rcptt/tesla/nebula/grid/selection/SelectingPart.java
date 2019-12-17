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
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;

class SelectingPart extends SelectingThings {

	private final ItemPart part;

	public SelectingPart(ItemPart part) {
		this.part = part;
	}

	@Override
	public List<Object> selectionData() {
		return SelectingItems.selectionDataFrom(new GridItem[] { part.item });
	}

	@Override
	public void selectUs(Grid grid) {
		part.selectMeInGrid();
	}

	//

	protected void mouseActions() {
		Point point = Bounds.centerAbs(part.bounds());

		events.sendEvent(grid, SWT.MouseDown, point.x, point.y, 1);
		events.sendEvent(grid, SWT.MouseUp, point.x, point.y, 1);
	}

}
