/*******************************************************************************
 * Copyright (c) 2009, 2017 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import static org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin.err;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetComboItems;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;

public class GetComboItemsService extends AbstractActionService {

	@Override
	protected Object exec(final Command command) throws CoreException {
		final GetComboItems gci = (GetComboItems) command;
		final ControlHandler control = gci.getControl();

		final Element element = TeslaBridge.find(control, getContext());
		final Widget combo = (Widget) TeslaBridge.getClient()
				.getProcessor(SWTUIProcessor.class).getMapper()
				.get(element).widget;

		if (!(combo instanceof Combo) && !(combo instanceof CCombo)) {
			throw new CoreException(
					err("'get-combo-items' can be used only on combo box"));
		}

		final EclList list = CoreFactory.eINSTANCE.createEclList();
		combo.getDisplay().syncExec(new Runnable() {

			@Override
			public void run() {
				addComboItemsToList(combo, list);
			}

		});

		return list;
	}

	private static void addComboItemsToList(Widget widget, EclList list) {
		if (widget instanceof Combo) {
			Combo combo = (Combo) widget;
			addItemsToList(combo.getItems(), list);
		} else if (widget instanceof CCombo) {
			CCombo combo = (CCombo) widget;
			addItemsToList(combo.getItems(), list);
		}
	}

	private static void addItemsToList(String[] items, EclList list) {
		if (items == null) {
			return;
		}
		for (int i = 0; i < items.length; i++) {
			EclString item = CoreFactory.eINSTANCE.createEclString();
			item.setValue(items[i]);
			list.getElements().add(item);
		}
	}

}
