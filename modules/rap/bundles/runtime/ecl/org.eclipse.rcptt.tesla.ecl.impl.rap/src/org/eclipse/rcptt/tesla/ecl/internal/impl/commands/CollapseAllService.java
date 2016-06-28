/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.CollapseAll;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class CollapseAllService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		CollapseAll cmd = (CollapseAll) command;
		ControlHandler handler = cmd.getControl();

		Element element = TeslaBridge.find(handler);
		final Widget widget = (Widget) TeslaBridge.getClient()
				.getProcessor(SWTUIProcessor.class).getMapper()
				.get(element).widget;

		if (!(widget instanceof Tree || widget instanceof TreeItem)) {
			return TeslaImplPlugin
					.err("'collapse-all' can be used only on tree or tree item");
		}

		widget.getDisplay().syncExec(new Runnable() {
			public void run() {
				collapseAll(widget);
			}
		});

		return handler;
	}

	private static void collapseAll(Widget widget) {
		TreeItem[] roots = widget instanceof Tree ?
				((Tree) widget).getItems()
				: new TreeItem[] { ((TreeItem) widget) };
		collapse(roots);
	}

	private static void collapse(TreeItem[] items) {
		for (TreeItem i : items) {
			Event e = new Event();
			e.widget = i.getParent();
			e.display = i.getDisplay();
			e.time = (int) System.currentTimeMillis();
			e.item = i;
			i.getParent().notifyListeners(SWT.Collapse, e);

			i.setExpanded(false);
			collapse(i.getItems());
		}
	}
}
