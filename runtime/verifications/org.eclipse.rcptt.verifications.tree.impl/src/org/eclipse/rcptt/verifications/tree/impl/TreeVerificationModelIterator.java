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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.Tree;

public class TreeVerificationModelIterator {
	private Tree tree;
	private Row item;
	private List<Row> currentItems;
	int itemInd = 0;
	private Stack<Row> itemPath = new Stack<Row>();
	private Stack<Integer> itemInds = new Stack<Integer>();

	public TreeVerificationModelIterator(Tree tree) {
		this.tree = tree;
		currentItems = tree.getRows();
		item = toFirstItem();
	}

	public Row nextInto() {
		stepInto();
		if (getItemsCount() == 0) {
			return stepReturn();
		} else {
			return item;
		}
	}

	public Row nextOver() {
		itemInd++;
		if (currentItems.size() > itemInd) {
			item = currentItems.get(itemInd);
			return getItem();
		} else {
			return null;
		}
	}

	public Row stepReturn() {
		do {
			stepOut();
		} while (itemPath.size() > 0 && itemInd >= currentItems.size() - 1);
		Row next = nextOver();
		if (next == null && !isEnd()) {
			return stepReturn();
		} else {
			return next;
		}
	}

	public Row toFirstItem() {
		itemInd = 0;
		if (currentItems.size() > 0) {
			return currentItems.get(0);
		} else {
			return null;
		}
	}

	public List<Integer> getItemIndexPath() {
		List<Integer> path = new ArrayList<Integer>(itemInds);
		path.add(itemInd);
		return path;
	}

	public String getNonBlankItemPath() {
		return getNonBlankItemPath(false);
	}

	public String getNonBlankPath() {
		return getNonBlankItemPath(true);
	}

	public String getNonBlankItemPath(boolean pathOnly) {
		StringBuilder sb = new StringBuilder();
		for (Row curItem : itemPath) {
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

	private String appendNonBlankItemText(Row item) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < item.getValues().size(); i++) {
			if (!item.getValues().get(i).getData().getText().equals("")) {
				sb.append(item.getValues().get(i).getData().getText());
				if (i != 0) {
					sb.append(String.format("(column \"%s\")", tree.getColumns().get(i).getName()));
				}
				break;
			}
		}
		return sb.toString();
	}

	private String getFullItemPath(boolean pathOnly) {
		StringBuilder sb = new StringBuilder();
		for (Row curItem : itemPath) {
			sb.append(curItem.getData().getText()).append("/");
		}
		if (!pathOnly) {
			sb.append(item.getData().getText());
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

	public int getNestingLevel() {
		return itemPath.size();
	}

	public Row getItem() {
		return item;
	}

	public int getItemIndex() {
		return itemInd;
	}

	public int getItemsCount() {
		return currentItems.size();
	}

	private void stepInto() {
		itemPath.push(item);
		itemInds.push(itemInd);
		currentItems = item.getChildren();
		item = toFirstItem();
	}

	private void stepOut() {
		if (itemPath.size() > 0) {
			item = itemPath.pop();
			itemInd = itemInds.pop();
			currentItems = (itemPath.size() == 0)
					? tree.getRows()
					: itemPath.peek().getChildren();
		}
	}

	public boolean isEnd() {
		return (currentItems.size() <= itemInd && itemPath.empty());
	}
}
