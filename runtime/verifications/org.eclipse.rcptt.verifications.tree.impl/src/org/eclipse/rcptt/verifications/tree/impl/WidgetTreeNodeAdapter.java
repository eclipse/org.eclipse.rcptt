/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.tree.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;
import org.eclipse.rcptt.util.swt.TableTreeUtil;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.TreeNode;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class WidgetTreeNodeAdapter implements TreeNode<Row> {
	private final Widget widget;

	private static class TreeItemNodeAdapter implements TreeNode<Row> {
		private final Item widget;

		public TreeItemNodeAdapter(Item item) {
			if (item == null)
				throw new NullPointerException();
			widget = item;
		}

		@Override
		public Collection<? extends TreeNode<Row>> getChildren() {
			if (widget instanceof TreeItem) {
				Viewers.expandTreeItem((TreeItem) widget);
			}
			return convert(TableTreeUtil.getItems(widget), this);
		}

		@Override
		public Row payload() {
			return TreeVerificationModeller.getRow(widget, TableTreeUtil.getColumnCount(widget), false);
		}

	}

	public WidgetTreeNodeAdapter(Widget tree) {
		widget = tree;
	}

	@Override
	public Collection<? extends TreeNode<Row>> getChildren() {
		return convert(TableTreeUtil.getItems(widget), this);
	}

	private static List<TreeItemNodeAdapter> convert(Item[] items, TreeNode<Row> parent) {
		List<TreeItemNodeAdapter> rv = new ArrayList<TreeItemNodeAdapter>(items.length);
		for (Item item : items) {
			rv.add(new TreeItemNodeAdapter(item));
		}
		return rv;
	}

	@Override
	public Row payload() {
		return null;
	}

}
