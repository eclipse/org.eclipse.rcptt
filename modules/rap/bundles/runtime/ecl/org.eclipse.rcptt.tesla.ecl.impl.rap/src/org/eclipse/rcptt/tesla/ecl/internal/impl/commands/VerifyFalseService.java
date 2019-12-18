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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.core.protocol.AssertKind;
import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.VerifyFalse;
import org.eclipse.rcptt.tesla.ecl.model.VerifyHandler;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;

public class VerifyFalseService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		VerifyFalse verify = (VerifyFalse) command;
		EObject cond = verify.getCondition();
		if (cond instanceof Wrapper) {
			Wrapper wrapper = (Wrapper) cond;
			if (wrapper.getObject() instanceof Boolean) {
				Boolean val = (Boolean) wrapper.getObject();
				if (val) {
					TeslaBridge.makeScreenshot(true, "Verification is failed");
					return TeslaImplPlugin.error("Verification is failed");
				} else
					return Status.OK_STATUS;
			}
		} else if (cond instanceof VerifyHandler) {
			VerifyHandler handler = (VerifyHandler) cond;
			switch (handler.getKind()) {
			case EQUALS:
				handler.setKind(AssertKind.NOT_EQUALS);
				break;
			case CONTAINS:
				handler.setKind(AssertKind.NOT_CONTAINS);
				break;
			case IS_EMPTY:
				handler.setKind(AssertKind.NOT_EMPTY);
				break;
			case REGEXP:
				handler.setKind(AssertKind.NOT_REGEXP);
				break;
			}
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
					boolean e1af = error.getMessage().contains(
							"Assertion Failed:");
					boolean e2af = error2.getMessage().contains(
							"Assertion Failed:");
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
			if (input != null && !input) {
				return Status.OK_STATUS;
			}
		}
		TeslaBridge.makeScreenshot(true, "Verification is failed");
		return TeslaImplPlugin.error("Verification is failed");
	}
}