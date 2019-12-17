/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
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
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.ServiceUtil;
import org.eclipse.rcptt.tesla.ecl.model.Contains;
import org.eclipse.rcptt.tesla.ecl.model.VerifyHandler;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;

public class ContainsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		Contains c = (Contains) command;
		Object value = c.getValue();
		EObject input = c.getInput();
		if (input instanceof VerifyHandler) {
			VerifyHandler handler = (VerifyHandler) input;
			handler.setKind(AssertKind.CONTAINS);
			handler.setValue(value.toString());
			context.getOutput().write(handler);
			return Status.OK_STATUS;
		}
		if (input instanceof Wrapper) {
			Wrapper wrapper = (Wrapper) input;
			if (wrapper.getObject() instanceof String) {
				String val = (String) wrapper.getObject();
				if (val.contains(value.toString())
						|| val.matches(value.toString())) {
					context.getOutput().write(ServiceUtil.wrap(true));
					return Status.OK_STATUS;
				} else {
					context.getOutput().write(ServiceUtil.wrap(false));
					return Status.OK_STATUS;
				}
			}
		}

		if (input instanceof BoxedValue) {
			String object = BoxedValues.toString((BoxedValue) input);
			if (object != null && value != null) {
				context.getOutput().write(BoxedValues.box(object.contains(value.toString())));
				return Status.OK_STATUS;
			}
		}
		context.getOutput().write(BoxedValues.box(false));
		return Status.OK_STATUS;
	}
}
