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
/**
 * 
 */
package org.eclipse.rcptt.tesla.internal.ui.player.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.rcptt.tesla.ui.IViewerItem;

public class TableViewerItem implements IViewerItem {
	private TableItem item;

	public TableViewerItem(TableItem item) {
		this.item = item;
	}

	public IViewerItem[] getItems() {
		return new IViewerItem[0];
	}

	private IViewerItem[] toArray(TableItem[] items) {
		List<IViewerItem> result = new ArrayList<IViewerItem>();
		for (TableItem item : items) {
			result.add(new TableViewerItem(item));
		}
		return result.toArray(new IViewerItem[result.size()]);
	}

	public IViewerItem[] getParentItems() {
		if (item.isDisposed() || item.getParent().isDisposed()) {
			return new IViewerItem[0];
		}
		return toArray(item.getParent().getItems());
	}

	public String getText(int column) {
		return item.getText(column);
	}

	public String getText() {
		return item.getText();
	}

	public boolean matches(Object o) {
		if (o instanceof TableViewerItem) {
			return item.equals(((TableViewerItem) o).item);
		}
		return item.equals(o);
	}

	public Table getControl() {
		return this.item.getParent();
	}

	public TableItem getItem() {
		return item;
	}
}