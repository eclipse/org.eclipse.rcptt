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

import org.eclipse.rcptt.tesla.internal.ui.player.SWTEvents;

abstract class SelectingThings {

	public abstract List<Object> selectionData();

	protected static List<Object> selectionDataFrom(final GridItem[] items) {
		final List<Object> selectionData = new ArrayList<Object>();
		for (GridItem gridItem : items) {
			Object data = gridItem.getData();
			if (data != null)
				selectionData.add(data);
		}
		return selectionData;
	}

	//

	public abstract void selectUs(Grid grid);

	//

	protected SWTEvents events;
	protected Grid grid;

	public final void imitateMouseActions(SWTEvents events, Grid grid) {
		this.events = events;
		this.grid = grid;

		mouseActions();

		events = null;
		grid = null;
	}

	protected abstract void mouseActions();

}
