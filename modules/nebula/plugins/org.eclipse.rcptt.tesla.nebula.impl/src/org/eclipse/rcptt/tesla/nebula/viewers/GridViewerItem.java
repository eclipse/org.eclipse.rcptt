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
package org.eclipse.rcptt.tesla.nebula.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.widgets.grid.GridItem;

import org.eclipse.rcptt.tesla.ui.IViewerItem;

public class GridViewerItem implements IViewerItem {

	private GridItem item;

	public GridViewerItem(GridItem item) {
		this.item = item;
	}

	public IViewerItem[] getItems() {
		if (item.isDisposed() || item.getParent().isDisposed()) {
			return new IViewerItem[0];
		}
		GridItem[] items = this.item.getItems();
		return toArray(items);
	}

	private IViewerItem[] toArray(GridItem[] items) {
		List<IViewerItem> result = new ArrayList<IViewerItem>();
		for (GridItem item : items) {
			result.add(new GridViewerItem(item));
		}
		return result.toArray(new IViewerItem[result.size()]);
	}

	public IViewerItem[] getParentItems() {
		GridItem parentItem = item.getParentItem();
		if (parentItem != null) {
			if (parentItem.isDisposed()) {
				return new IViewerItem[0];
			}
			return toArray(parentItem.getItems());
		}
		return toArray(NebulaViewers.getGridRootItems(item.getParent()).toArray(new GridItem[] {}));
	}

	public String getText(int column) {
		if (item.isDisposed()) {
			return "";
		}
		return item.getText(column);
	}

	public String getText() {
		if (item.isDisposed()) {
			return "";
		}
		return item.getText();
	}

	public boolean matches(Object o) {
		if (o instanceof GridViewerItem) {
			return item.equals(((GridViewerItem) o).item);
		}
		return item.equals(o);
	}

}
