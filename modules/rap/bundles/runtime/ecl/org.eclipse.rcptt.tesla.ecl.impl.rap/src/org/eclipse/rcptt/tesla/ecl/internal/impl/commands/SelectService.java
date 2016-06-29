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

import static org.eclipse.rcptt.tesla.ecl.internal.impl.commands.ActionService.getTextUIElement;
import static org.eclipse.rcptt.tesla.ecl.internal.impl.commands.ActionService.getViewerUIElement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.ServiceDispatchingUtils;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.internal.impl.ServiceUtil;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.Select;

public class SelectService extends AbstractActionService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		IStatus result = ServiceDispatchingUtils.handleWithExtensions(command, context);
		if (result != null)
			return result;
		return super.service(command, context);
	}

	@Override
	protected Object exec(Command command) throws CoreException {
		if (command instanceof Select)
			return handleSelect((Select) command);
		return null;
	}

	private ControlHandler handleSelect(Select s) throws CoreException {
		if (!s.getControl().getKind().equals(ElementKind.Combo)) {
			List<Object> pathList = s.getItems();
			int size = pathList.size();
			if (size == 0)
				throw new CoreException(
						TeslaImplPlugin.error("Path is not specified"));

			List<List<String>> list = new ArrayList<List<String>>(size);
			for (Object item : pathList)
				list.add(ServiceUtil.processSelectItems(item, s.getColumn()));
			getViewerUIElement(s.getControl()).setMultiSelectionList(list,
					s.isAll());

			return s.getControl();
		} else {
			// combos
			EList<Object> items = s.getItems();
			if (items == null || items.size() < 1)
				throw new CoreException(
						TeslaImplPlugin.error("No item to select"));
			Object item = items.get(0);
			if (item == null)
				throw new CoreException(
						TeslaImplPlugin.error("Bad item to select"));
			String text = item.toString();
			getTextUIElement(s.getControl()).setText(text, true, false);
			return s.getControl();
		}
	}


}
