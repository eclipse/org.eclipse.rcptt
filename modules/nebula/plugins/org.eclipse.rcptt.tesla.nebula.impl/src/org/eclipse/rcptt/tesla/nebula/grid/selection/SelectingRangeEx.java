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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

import org.eclipse.rcptt.util.swt.Bounds;
import org.eclipse.rcptt.tesla.nebula.grid.GridScrollingHelper;
import org.eclipse.rcptt.tesla.nebula.grid.parts.ItemPart;

public class SelectingRangeEx extends SelectingThings {

	private final ItemPart fromPart;
	private final ItemPart toPart;

	public SelectingRangeEx(ItemPart from, ItemPart to) {
		this.fromPart = from;
		this.toPart = to;
	}

	@Override
	public List<Object> selectionData() {
		return null; // ignore it, only imitate mouse actions
	}

	@Override
	public void selectUs(Grid grid) {
		// ignore it, only imitate mouse actions
	}

	@Override
	protected void mouseActions() {
		// see super's implementation for comments

		Point from = clickPointFor(fromPart);
		events.sendEvent(grid, SWT.MouseDown, from.x, from.y, 1);
		events.sendEvent(grid, SWT.MouseUp, from.x, from.y, 1);

		GridScrollingHelper.showPartIfHidden(toPart);

		Point to = clickPointFor(toPart);
		events.sendEvent(grid, SWT.MouseMove, to.x, to.y, 1);
		events.sendEvent(grid, SWT.MouseDown, to.x, to.y, 1, SWT.SHIFT);
		events.sendEvent(grid, SWT.MouseUp, to.x, to.y, 1, SWT.SHIFT);
	}

	private Point clickPointFor(ItemPart part) {
		return Bounds.centerAbs(part.bounds());
	}

}
