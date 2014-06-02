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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.VerifyHandler;
import org.eclipse.rcptt.tesla.ecl.model.VerifyTrue;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;

public class VerifyTrueService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		VerifyTrue verify = (VerifyTrue) command;
		EObject cond = verify.getCondition();
		if (cond instanceof Wrapper) {
			Wrapper wrapper = (Wrapper) cond;
			if (wrapper.getObject() instanceof Boolean) {
				Boolean val = (Boolean) wrapper.getObject();
				if (val)
					return Status.OK_STATUS;
				else {
					TeslaBridge.makeScreenshot(true, "Verification is failed");
					return TeslaImplPlugin.err("Verification is failed");
				}
			}
		} else if (cond instanceof VerifyHandler) {
			VerifyHandler handler = (VerifyHandler) cond;
			BasicUIElement uiElement = new BasicUIElement(handler.getElement(),
					TeslaBridge.getPlayer());

			uiElement.doAssert(handler.getKind(), handler.getAttribute(),
					handler.getIndex(), handler.getValue(), null);
			TeslaErrorStatus error = TeslaBridge.getTeslaFailure();
			if (error == null) {
				return Status.OK_STATUS;
			}

			uiElement.doAssert(handler.getKind(), handler.getAttribute(),
					handler.getIndex(), handler.getValue(), "property");
			TeslaErrorStatus error2 = TeslaBridge.getTeslaFailure();
			if (error2 == null) {
				return Status.OK_STATUS;
			} else {
				if (error != null && error2 != null) {
					String error1message = error.getMessage().toLowerCase();
					String error2message = error2.getMessage().toLowerCase();
					boolean e1af = error1message.contains("assertion ")
							&& error1message.contains(" failed:");
					boolean e2af = error2message.contains("assertion ")
							&& error2message.contains(" failed:");
					if (e1af && !e2af) {
						TeslaBridge.makeScreenshot(true, error.getMessage());
						return error;
					} else if (!e1af && e2af) {
						TeslaBridge.makeScreenshot(true, error2.getMessage());
						return error2;
					}
				}
				if (error != null) {
					TeslaBridge.makeScreenshot(true, error.getMessage());
				}
				return error;
			}
		} else if (cond instanceof BoxedValue) {
			Boolean input = BoxedValues.toBoolean((BoxedValue) cond);
			if (input != null && input) {
				return Status.OK_STATUS;
			}
		}
		return TeslaImplPlugin.err("Verification is failed");
	}
}