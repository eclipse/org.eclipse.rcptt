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

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import org.eclipse.rcptt.tesla.ui.IViewerItem;

class TreeViewerItem implements IViewerItem {
	private TreeItem item;

	public TreeViewerItem(TreeItem item) {
		this.item = item;
	}

	public IViewerItem[] getItems() {
		if (item.isDisposed() || item.getParent().isDisposed()) {
			return new IViewerItem[0];
		}
		TreeItem[] items = this.item.getItems();
		return toArray(items);
	}

	private IViewerItem[] toArray(TreeItem[] items) {
		List<IViewerItem> result = new ArrayList<IViewerItem>();
		for (TreeItem item : items) {
			if (item != null) {
				result.add(new TreeViewerItem(item));
			}
		}
		return result.toArray(new IViewerItem[result.size()]);
	}

	public IViewerItem[] getParentItems() {
		TreeItem parentItem = item.getParentItem();
		if (parentItem != null) {
			if (parentItem.isDisposed()) {
				return new IViewerItem[0];
			}
			return toArray(parentItem.getItems());
		}
		return toArray(item.getParent().getItems());
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
		if (o instanceof TreeViewerItem) {
			return item.equals(((TreeViewerItem) o).item);
		}
		return item.equals(o);
	}

	public Tree getControl() {
		return item.getParent();
	}

	public TreeItem getItem() {
		return item;
	}
}