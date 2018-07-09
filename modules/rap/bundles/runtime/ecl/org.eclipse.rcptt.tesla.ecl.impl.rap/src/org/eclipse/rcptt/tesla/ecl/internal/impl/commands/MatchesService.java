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

import java.util.regex.PatternSyntaxException;

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
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.Matches;
import org.eclipse.rcptt.tesla.ecl.model.VerifyHandler;

public class MatchesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		Matches m = (Matches) command;
		Object value = m.getValue();
		EObject input = m.getInput();
		if (input instanceof VerifyHandler) {
			VerifyHandler handler = (VerifyHandler) input;
			handler.setKind(AssertKind.REGEXP);
			handler.setValue(value.toString());
			context.getOutput().write(handler);
			return Status.OK_STATUS;
		}

		if (input instanceof BoxedValue) {
			String object = BoxedValues.toString((BoxedValue) input);
			try {
				boolean result = object != null
						&& object.matches(value.toString());
				context.getOutput().write(BoxedValues.box(result));
				return Status.OK_STATUS;
			} catch (PatternSyntaxException e) {
				return new Status(IStatus.ERROR, TeslaImplPlugin.PLUGIN_ID,
						e.getMessage(), e);
			}

		}
		context.getOutput().write(BoxedValues.box(false));
		return Status.OK_STATUS;
	}

}
