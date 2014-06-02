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
package org.eclipse.rcptt.verifications.tree.impl;

import java.util.Stack;

import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.util.swt.TableTreeUtil;
import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;

public class TreeIterator {
	private Widget tree;
	private Item item;
	private Item[] currentItems;
	int itemInd = 0;
	private Stack<Item> itemPath = new Stack<Item>();
	private Stack<Integer> itemInds = new Stack<Integer>();

	public TreeIterator(Widget tree) {
		this.tree = tree;
		currentItems = TableTreeUtil.getItems(this.tree);
		item = toFirstItem();
	}

	public Item nextInto() {
		if (tree instanceof Tree) {
			stepInto();
			if (getItemsCount() == 0) {
				return stepReturn();
			} else {
				return item;
			}
		} else {
			return nextOver();
		}
	}

	public Item nextOver() {
		itemInd++;
		if (currentItems.length > itemInd) {
			item = currentItems[itemInd];
			return getItem();
		} else {
			return null;
		}
	}

	public Item stepReturn() {
		do {
			stepOut();
		} while (itemPath.size() > 0 && itemInd >= currentItems.length - 1);
		Item next = nextOver();
		if (next == null && !isEnd()) {
			return stepReturn();
		} else {
			return next;
		}
	}

	public Item toFirstItem() {
		itemInd = 0;
		if (currentItems.length > 0) {
			return currentItems[0];
		} else {
			return null;
		}
	}

	public int getNestingLevel() {
		return itemPath.size();
	}

	public Item getItem() {
		return item;
	}

	public int getItemIndex() {
		return itemInd;
	}

	public String getNonBlankItemPath() {
		return getNonBlankItemPath(false);
	}

	public String getNonBlankPath() {
		return getNonBlankItemPath(true);
	}

	public String getNonBlankItemPath(boolean pathOnly) {
		StringBuilder sb = new StringBuilder();
		for (Item curItem : itemPath) {
			sb.append(appendNonBlankItemText(curItem));
			sb.append("/");
		}
		if (!pathOnly) {
			sb.append(appendNonBlankItemText(item));
		} else if (itemPath.size() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	private String appendNonBlankItemText(Item item) {
		StringBuilder sb = new StringBuilder();
		String[] vals = TableTreeUtil.getValues(item);
		for (int i = 0; i < vals.length; i++) {
			if (!vals[i].equals("")) {
				sb.append(vals[i]);
				if (i != 0) {
					String colName = TableTreeUtil.getName(TableTreeUtil.getColumn(tree, i));
					sb.append(String.format("(column \"%s\")", colName));
				}
				break;
			}
		}
		return sb.toString();
	}

	private String getFullItemPath(boolean pathOnly) {
		StringBuilder sb = new StringBuilder();
		for (Item curItem : itemPath) {
			sb.append(curItem.getText()).append("/");
		}
		if (!pathOnly) {
			sb.append(item.getText());
		} else if (itemPath.size() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public String getFullItemPath() {
		return getFullItemPath(false);
	}

	public String getPath() {
		return (itemPath.size() > 0) ? getFullItemPath(true) : null;
	}

	public int getItemsCount() {
		return currentItems.length;
	}

	private void stepInto() {
		if (tree instanceof Tree) {
			Viewers.expandTreeItem((TreeItem) item);
		}
		itemPath.push(item);
		itemInds.push(itemInd);
		currentItems = TableTreeUtil.getChildren(item);
		item = toFirstItem();
	}

	private void stepOut() {
		if (itemPath.size() > 0) {
			item = itemPath.pop();
			itemInd = itemInds.pop();
			currentItems = (itemPath.size() == 0)
					? TableTreeUtil.getItems(this.tree)
					: TableTreeUtil.getChildren(itemPath.peek());
		}
	}

	public boolean isEnd() {
		return (currentItems.length <= itemInd && itemPath.empty());
	}
}
