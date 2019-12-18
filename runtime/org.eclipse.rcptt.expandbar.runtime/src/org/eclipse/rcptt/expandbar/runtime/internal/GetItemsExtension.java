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
package org.eclipse.rcptt.expandbar.runtime.internal;

import static org.eclipse.rcptt.expandbar.runtime.internal.ExpandBarRuntimePlugin.err;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.expandbar.ExpandBarConstants;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetItems;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class GetItemsExtension implements IScriptletExtension {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		GetItems cmd = (GetItems) command;
		final ControlHandler parent = cmd.getControl();

		Element element = TeslaBridge.find(parent, context);
		final Widget widget = (Widget) TeslaBridge.getClient()
				.getProcessor(SWTUIProcessor.class).getMapper().get(element).widget;
		if (!(widget instanceof ExpandBar)) {
			return err("Don't know how to get items from %s", widget);
		}

		final ExpandBar expandBar = (ExpandBar) widget;

		final List<ControlHandler> items = new ArrayList<ControlHandler>();
		widget.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				for (ExpandItem item : expandBar.getItems()) {
					ControlHandler handler = TeslaFactory.eINSTANCE.createControlHandler();
					handler.setKind(ElementKind.Item);
					handler.setParent(parent);
					handler.setPath(ItemLocation.fromItem(item).toPathFragment());
					items.add(handler);
				}
			}
		});

		for (ControlHandler item : items) {
			context.getOutput().write(item);
		}
		return Status.OK_STATUS;
	}

	@Override
	public boolean canHandle(Command c) {
		return (c instanceof GetItems) && isExpandBarHandle(((GetItems) c).getControl());
	}

	public static final boolean isExpandBarHandle(ControlHandler handle) {
		return handle.getKind() == ElementKind.Custom
				&& ExpandBarConstants.EXPAND_BAR_KIND.equals(handle.getCustomKindId());
	}

}
