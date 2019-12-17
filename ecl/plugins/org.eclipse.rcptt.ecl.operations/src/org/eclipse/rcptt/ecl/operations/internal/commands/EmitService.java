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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.operations.Emit;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class EmitService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Emit)) {
			return Status.CANCEL_STATUS;
		}
		for (Object value : CoreUtils.readPipeContent(context.getInput())) {
			context.getOutput().write(EcoreUtil.copy(BoxedValues.box(value)));
		}
		for (Object value : ((Emit) command).getValues()) {
			context.getOutput().write(EcoreUtil.copy(BoxedValues.box(value)));
		}
		return Status.OK_STATUS;
	}

}
