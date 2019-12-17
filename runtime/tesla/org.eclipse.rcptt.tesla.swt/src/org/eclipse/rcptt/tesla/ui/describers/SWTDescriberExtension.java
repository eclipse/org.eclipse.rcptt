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
package org.eclipse.rcptt.tesla.ui.describers;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class SWTDescriberExtension implements IDescriberExtension {

	public SWTDescriberExtension() {
	}

	public IWidgetDescriber getDescriber(Widget widget,
			IWidgetDescriber previous, int x, int y) {
		return getItemAt(new WidgetDescriber(widget), x, y);
	}

	private IWidgetDescriber getItemAt(IWidgetDescriber descr, int x, int y) {
		// Display display = base.getDisplay();
		Widget base = descr.getWidget();
		if (base instanceof Tree) {
			Tree widget = (Tree) base;
			TreeItem item = null;
			TreeItem[] items = widget.getItems();
			item = findTreeItemAt(items, x, y);
			if (item != null) {
				return getDescriber(item);
			}
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
		if (base instanceof Composite) {
			Composite compo = (Composite) base;
			Control[] children = compo.getChildren();
			Point p = new Point(x, y);
			for (Control control : children) {
				if (control.isVisible()) {
					Rectangle bounds = control.getBounds();
					if (bounds.contains(p)) {
						return getItemAt(getDescriber(control), x - bounds.x, y
								- bounds.y);
					}
				}
			}
		}
		return descr;
	}

	private IWidgetDescriber getDescriber(Widget item) {
		return new WidgetDescriber(item);
	}

	private TreeItem findTreeItemAt(TreeItem[] items, int x, int y) {
		for (TreeItem treeItem : items) {
			if (treeItem.getBounds().contains(x, y)) {
				return treeItem;
			}
			TreeItem[] treeItems = treeItem.getItems();
			if (treeItems != null && treeItems.length > 0) {
				TreeItem itemAt = findTreeItemAt(treeItems, x, y);
				if (itemAt != null) {
					return itemAt;
				}
			}
		}
		return null;
	}

	private TableItem findTableItemAt(TableItem[] items, int x, int y) {
		for (TableItem treeItem : items) {
			if (treeItem.getBounds().contains(x, y)) {
				return treeItem;
			}
		}
		return null;
	}

	public IWidgetDescriber getDescriber(Element element,
			AbstractTeslaClient client) {
		SWTUIProcessor processor = client.getProcessor(SWTUIProcessor.class);
		SWTUIElement swtuiElement = processor.getMapper().get(element);
		if (swtuiElement != null) {
			return new WidgetDescriber(PlayerWrapUtils.unwrapWidget(swtuiElement));
		}
		return null;
	}
}
