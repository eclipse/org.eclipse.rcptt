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

import java.util.regex.Pattern;

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
import org.eclipse.rcptt.tesla.ecl.model.Equals;
import org.eclipse.rcptt.tesla.ecl.model.VerifyHandler;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;

public class EqualsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		Equals equal = (Equals) command;
		String value = equal.getValue();
		EObject input = equal.getInput();
		if (input instanceof VerifyHandler) {
			VerifyHandler handler = (VerifyHandler) input;
			handler.setKind(AssertKind.EQUALS);
			handler.setValue(value.toString());
			context.getOutput().write(handler);
			return Status.OK_STATUS;
		}
		if (input instanceof Wrapper) {
			Wrapper wrapper = (Wrapper) input;
			Object object = wrapper.getObject();
			if (object instanceof String && value instanceof String) {
				String original = (String) object;
				String regexp = (String) value;
				Boolean retVal = false;
				if (original.equals(regexp)) {
					retVal = true;
				} else {
					retVal = Pattern.matches(regexp, original);
				}
				context.getOutput().write(ServiceUtil.wrap(retVal));
				return Status.OK_STATUS;
			}
		}
		if (input instanceof BoxedValue) {
			String object = BoxedValues.toString((BoxedValue) input);
			if (object != null && value != null) {
				context.getOutput()
						.write(BoxedValues.box(object.equals(value)));
				return Status.OK_STATUS;
			}
		}
		context.getOutput().write(BoxedValues.box(input.equals(value)));
		return Status.OK_STATUS;
	}
}