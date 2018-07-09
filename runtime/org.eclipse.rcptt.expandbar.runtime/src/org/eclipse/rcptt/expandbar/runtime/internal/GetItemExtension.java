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
package org.eclipse.rcptt.expandbar.runtime.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.expandbar.ExpandBarConstants;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetItem;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;

public class GetItemExtension implements IScriptletExtension {
	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		GetItem getItem = (GetItem) command;
		ControlHandler result = TeslaFactory.eINSTANCE.createControlHandler();
		ControlHandler parent = getItem.getParent();

		result.setParent(parent);
		result.setAfter(getItem.getAfter());
		result.setKind(ElementKind.Item);

		String path = getItem.getPath();
		Integer index = getItem.getIndex();
		if (path == null) {
			result.setIndex(index == null ? 0 : index);
		} else {
			result.setPath(index == null ? path : String.format("%s%%%d%%",
					path, index));
		}
		TeslaBridge.find(result, context);
		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	@Override
	public boolean canHandle(Command c) {
		if (!(c instanceof GetItem))
			return false;
		GetItem getItem = (GetItem) c;
		if (getItem.getParent() == null)
			return false;
		return ExpandBarConstants.EXPAND_BAR_KIND.equals(getItem.getParent().getCustomKindId());
	}

}
