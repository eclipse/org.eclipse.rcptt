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

import static org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin.err;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;

import org.eclipse.rcptt.tesla.ecl.impl.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.SelectItem;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class SelectItemService extends AbstractActionService {
	@Override
	protected Object exec(Command command) throws CoreException {
		SelectItem select = (SelectItem) command;
		ControlHandler control = select.getControl();
		final SWTUIElement item = TeslaBridge.getClient().getProcessor(SWTUIProcessor.class).getMapper()
				.get(TeslaBridge.find(control, getContext()));

		if (!(item.widget instanceof TreeItem) && !(item.widget instanceof TableItem)) {
			throw new CoreException(err("'select-item' can only be used on table or tree item"));
		}

		item.getPlayer().exec("Selecting table item", new Runnable() {
			public void run() {
				Viewers.selectItem(item, false);
			}
		});

		return control;
	}
}
