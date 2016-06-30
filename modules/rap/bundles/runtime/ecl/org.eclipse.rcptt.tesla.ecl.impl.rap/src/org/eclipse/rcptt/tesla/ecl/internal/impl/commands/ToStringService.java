/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;
import org.eclipse.rcptt.tesla.ecl.rap.model.ToString;

public class ToStringService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		final ToString cmd = (ToString) command;

		final EObject input = cmd.getInput();

		if (input instanceof Wrapper) {

			try {
				context.getOutput().write(ServiceUtil.wrap(convert(cmd, (Wrapper) input)));
			} catch (IllegalArgumentException e) {
				return new Status(IStatus.ERROR, TeslaImplPlugin.PLUGIN_ID, e.getMessage(), e);
			}
		}

		return Status.OK_STATUS;
	}

	private static Object convert(ToString command, Wrapper wrapper) throws IllegalArgumentException {
		if (wrapper.getObject() instanceof byte[]) {
			byte[] bytes = (byte[]) wrapper.getObject();
			try {
				return new String(bytes, command.getEncode());
			} catch (UnsupportedEncodingException e) {
				return new IllegalArgumentException("Bad encoding format: " + command.getEncode(), e); //$NON-NLS-1$
			}
		}
		return new IllegalArgumentException("Not supported value type"); //$NON-NLS-1$
	}

}
