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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.Format;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class FormatService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		Format format = (Format) command;
		List<Object> args = new ArrayList<Object>();
		for (EObject arg : format.getArgs()) {
			args.add(BoxedValues.unbox(arg));
		}
		try {
			String result = String.format(format.getFormat(), args.toArray());
			context.getOutput().write(result);
		} catch (Exception e) {
			return new Status(
					IStatus.ERROR,
					OperationsPlugin.PLUGIN_ID,
					String.format("Error formatting string: %s", e.getMessage()),
					e);
		}
		return Status.OK_STATUS;
	}

}
