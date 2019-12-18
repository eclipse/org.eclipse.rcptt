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
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.rcptt.tesla.nebula.viewers.NebulaViewers;

public abstract class ItemPart implements GridPart {

	public final GridItem item;

	public ItemPart(GridItem item) {
		Assert.isNotNull(item);
		this.item = item;
	}

	//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPart other = (ItemPart) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	//

	@Override
	public Grid grid() {
		return item.getParent();
	}

	protected Rectangle itemBounds() {
		return NebulaViewers.getItemBounds(item);
	}

	// replaying selection stuff

	public abstract void selectMeInGrid();

	protected int row() {
		return grid().indexOf(item);
	}

}