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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.util.Base64;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.ServiceUtil;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.ContainsImage;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetRegionText;

public class IMLContainsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		try {
			if (command instanceof ContainsImage) {
				ContainsImage ct = (ContainsImage) command;
				ControlUIElement controlUIElement = getControlUIElement(ct
						.getControl());
				byte[] decode = Base64.decode(ct.getRawImage());
				controlUIElement.doContainsImageAssert(decode);

				TeslaErrorStatus error = TeslaBridge.getTeslaFailure();
				if (error == null) {
					context.getOutput().write(ServiceUtil.wrap(Boolean.TRUE));
					return Status.OK_STATUS;
				}
				context.getOutput().write(ServiceUtil.wrap(Boolean.FALSE));
				return Status.OK_STATUS;

			} else if (command instanceof GetRegionText) {
				GetRegionText rct = (GetRegionText) command;
				ControlUIElement controlUIElement = getControlUIElement(rct
						.getControl());
				String text = controlUIElement.getRegionText(rct.getX(),
						rct.getY(), rct.getSx(), rct.getSy(), rct.getWidth(),
						rct.getHeight());
				TeslaErrorStatus error = TeslaBridge.getTeslaFailure();
				if (error == null) {
					context.getOutput().write(ServiceUtil.wrap(text));
					return Status.OK_STATUS;
				}
				context.getOutput().write(ServiceUtil.wrap(""));
				return Status.OK_STATUS;
			}
		} catch (Throwable e) {
			TeslaImplPlugin.err("IMLContainsService error:", e);
		}
		context.getOutput().write(ServiceUtil.wrap(false));
		return Status.OK_STATUS;
	}

	private ControlUIElement getControlUIElement(ControlHandler control)
			throws CoreException {
		ControlUIElement element = new ControlUIElement(
				TeslaBridge.find(control), TeslaBridge.getPlayer());
		return element;
	}
}
