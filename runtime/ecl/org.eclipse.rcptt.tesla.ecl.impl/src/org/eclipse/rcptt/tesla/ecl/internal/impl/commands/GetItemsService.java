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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetItems;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class GetItemsService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		GetItems cmd = (GetItems) command;
		final ControlHandler handler = cmd.getControl();

		Element element = TeslaBridge.find(handler, getContext());
		final Widget widget = (Widget) TeslaBridge.getClient().getProcessor(SWTUIProcessor.class).getMapper()
				.get(element).widget;

		if (!(widget instanceof Tree || widget instanceof TreeItem || widget instanceof Table)) {
			return TeslaImplPlugin.err("'get-items' can be used only on table or tree or tree item");
		}

		final List<ControlHandler> items = new ArrayList<ControlHandler>();

		widget.getDisplay().syncExec(new Runnable() {
			public void run() {
				getItems(items, widget, handler);
			}
		});

		for (ControlHandler h : items)
			getContext().getOutput().write(h);

		return null; // prevents writing to output pipe
	}

	private static void getItems(List<ControlHandler> result, Widget widget, ControlHandler parent) {
		Map<String, Integer> counters = new HashMap<String, Integer>();

		if (widget instanceof Table) {
			Table table = (Table) widget;
			for (TableItem i : table.getItems()) {
				ControlHandler handler = TeslaFactory.eINSTANCE.createControlHandler();
				handler.setKind(ElementKind.Item);
				handler.setParent(parent);

				if (!counters.containsKey(i.getText())) {
					counters.put(i.getText(), 1);
					handler.setPath(escapePathFragment(i.getText()));
				} else {
					int index = counters.get(i.getText());
					counters.put(i.getText(), index + 1);
					handler.setPath(escapePathFragment(i.getText()) + "%" + index + "%");
				}

				result.add(handler);
			}
		} else if (widget instanceof Tree || widget instanceof TreeItem) {
			if (widget instanceof TreeItem && !((TreeItem) widget).getExpanded()) {
				return; // At least on Mac OS X SWT API returns a single tree
						// item child
						// for a collapsed tree item, which is wrong
						//
			}
			TreeItem[] roots = widget instanceof Tree ? ((Tree) widget).getItems() : ((TreeItem) widget).getItems();
			if (widget instanceof TreeItem)
				parent = parent.getParent();

			List<TreeItem> expanded = new ArrayList<TreeItem>();
			listExpanded(expanded, roots);

			for (TreeItem i : expanded) {
				ControlHandler handler = TeslaFactory.eINSTANCE.createControlHandler();
				handler.setKind(ElementKind.Item);
				handler.setParent(parent);

				String path = makeTreeItemPath(i);
				if (!counters.containsKey(path)) {
					counters.put(path, 1);
					handler.setPath(path);
				} else {
					int index = counters.get(path);
					counters.put(path, index + 1);
					handler.setPath(path + "%" + index + "%");
				}

				result.add(handler);
			}
		}
	}

	private static void listExpanded(List<TreeItem> result, TreeItem[] items) {
		for (TreeItem i : items) {
			result.add(i);
			if (i.getExpanded())
				listExpanded(result, i.getItems());
		}
	}

	private static String makeTreeItemPath(TreeItem item) {
		StringBuilder b = new StringBuilder();
		while (item != null) {
			if (b.length() > 0)
				b.insert(0, '/');
			b.insert(0, escapePathFragment(item.getText()));
			item = item.getParentItem();
		}
		return b.toString();
	}

	private static String escapePathFragment(String path) {
		path = SWTUIPlayer.toSelectionItem(path);
		path = path.replaceAll("/", "\\\\/");
		return path;
	}

}
