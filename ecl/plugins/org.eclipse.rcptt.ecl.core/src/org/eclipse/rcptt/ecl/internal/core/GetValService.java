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
package org.eclipse.rcptt.ecl.internal.core;

import static java.lang.String.format;
import static org.eclipse.emf.ecore.util.EcoreUtil.copy;
import static org.eclipse.rcptt.ecl.internal.core.CorePlugin.err;
import static org.eclipse.rcptt.ecl.internal.core.GlobalService.getGlobals;
import static org.eclipse.rcptt.ecl.internal.core.LetService.getLocals;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.GetVal;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetValService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof GetVal)) {
			return Status.CANCEL_STATUS;
		}

		String name = ((GetVal) command).getName();
		Declaration declaration = getLocals(context).lookup(name);
		if (declaration == null) {
			declaration = getGlobals(context).lookup(name);
		}

		if (!(declaration instanceof Val)) {
			throw new CoreException(err(format("Undeclared val '%s'", name)));
		}

		context.getOutput().write(copy(((Val) declaration).getValue()));

		return Status.OK_STATUS;
	}

}
