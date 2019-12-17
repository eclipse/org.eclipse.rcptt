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
package org.eclipse.rcptt.tesla.recording.core.swt;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class SWTDescriberExtension implements IRecorderDescriberExtension {

	public SWTDescriberExtension() {
	}

	public IRecordingDescriber getDescriber(Widget widget,
			IRecordingDescriber previous, int x, int y, boolean fromAsser) {
		return getItemAt(new RecordingWidgetDescriber(widget), x, y, fromAsser);
	}

	private IRecordingDescriber getItemAt(IRecordingDescriber descr, int x,
			int y, boolean fromAssert) {

		// Display display = base.getDisplay();
		Widget base = descr.getWidget();
		if (base != null && base.isDisposed())
			return descr;
		if (base instanceof TreeItem)
			return getItemAt(
					new RecordingWidgetDescriber(((TreeItem) base).getParent()),
					x, y, fromAssert);
		if (base instanceof TableItem)
			return getItemAt(
					new RecordingWidgetDescriber(((TableItem) base).getParent()),
					x, y, fromAssert);

		if (base instanceof Tree) {
			Tree widget = (Tree) base;
			TreeItem item = null;
			TreeItem[] items = widget.getItems();
			item = findTreeItemAt(items, x, y);
			if (item != null)
				return getDescriber(item);
			return descr;
		} else if (base instanceof Table) {
			Table widget = (Table) base;
			TableItem item = null;
			TableItem[] items = widget.getItems();
			item = findTableItemAt(items, x, y);
			if (item != null) {
				return getDescriber(item);
			}
			return descr;
		} else if (base instanceof ToolBar) {
			ToolBar bar = (ToolBar) base;
			ToolItem item = bar.getItem(new Point(x, y));
			if (item != null) {
				return getDescriber(item);
			}
			return descr;
		} else if (base instanceof CoolBar) {
			CoolBar bar = (CoolBar) base;
			CoolItem[] items = bar.getItems();
			Point pt = new Point(x, y);
			for (CoolItem coolItem : items) {
				Rectangle bounds = coolItem.getBounds();
				if (bounds.contains(pt)) {
					return getDescriber(coolItem);
				}
			}
		}
		if (fromAssert) {
			if (base instanceof Browser) {
				return descr;
			}
			if (base instanceof Control
					&& ((Control) base).getParent() instanceof CCombo) {
				return getDescriber(((Control) base).getParent());
			}
			if (base instanceof Control
					&& ((Control) base).getParent() instanceof DateTime) {
				return getDescriber(((Control) base).getParent());
			}
			if (base instanceof Composite) {
				Composite compo = (Composite) base;
				Control[] children = compo.getChildren();
				Point p = new Point(x, y);
				for (Control control : children) {
					if (control.isVisible()) {
						Rectangle bounds = control.getBounds();
						if (bounds.contains(p)) {
							return getItemAt(getDescriber(control), x
									- bounds.x, y - bounds.y, fromAssert);
						}
					}
				}
			}
		}
		return descr;
	}

	private IRecordingDescriber getDescriber(Widget item) {
		return new RecordingWidgetDescriber(item);
	}

	private TreeItem findTreeItemAt(TreeItem[] items, int x, int y) {
		for (TreeItem treeItem : items) {
			if (!treeItem.isDisposed()) {
				Rectangle treeBounds = treeItem.getParent().getBounds();
				int columnCount = treeItem.getParent().getColumnCount();
				if (columnCount == 0) {
					Rectangle bounds = treeItem.getBounds();
					bounds.x = 0;
					bounds.width = treeBounds.width;
					if (bounds.contains(x, y)) {
						return treeItem;
					}
				} else {
					for (int i = 0; i < columnCount; i++) {
						Rectangle bounds = treeItem.getBounds(i);
						bounds.x = 0;
						bounds.width = treeBounds.width;
						if (bounds.contains(x, y)) {
							return treeItem;
						}
					}
				}
				TreeItem[] treeItems = treeItem.getItems();
				if (treeItems != null && treeItems.length > 0) {
					TreeItem itemAt = findTreeItemAt(treeItems, x, y);
					if (itemAt != null) {
						return itemAt;
					}
				}
			}
		}
		return null;
	}

	private TableItem findTableItemAt(TableItem[] items, int x, int y) {
		for (TableItem tableItem : items) {
			if (!tableItem.isDisposed()) {
				Table parent = tableItem.getParent();
				if (parent.isDisposed()) {
					continue;
				}
				int columnCount = parent.getColumnCount();
				if (columnCount == 0) {
					if (tableItem.getBounds().contains(x, y)) {
						return tableItem;
					}
				} else {
					for (int i = 0; i < columnCount; i++) {
						if (tableItem.getBounds(i).contains(x, y)) {
							return tableItem;
						}
					}
				}
			}

		}
		return null;
	}
}
