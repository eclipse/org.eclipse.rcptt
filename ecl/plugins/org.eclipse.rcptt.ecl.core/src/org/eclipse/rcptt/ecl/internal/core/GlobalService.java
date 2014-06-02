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
package org.eclipse.rcptt.ecl.internal.core;

import static org.eclipse.rcptt.ecl.internal.core.CorePlugin.err;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.Global;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class GlobalService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Global)) {
			return Status.CANCEL_STATUS;
		}

		Global global = (Global) command;

		DeclarationContainer globals = getGlobals(context);
		for (Declaration decl : global.getVals()) {
			if (!(decl instanceof Val)) {
				continue; // TODO: pipes support
			}
			Val val = (Val) decl;
			if (val.isInput()) {
				throw new CoreException(
						err("Cannot initialize global value from input"));
			}

			if (val.getValue() == null) {
				throw new CoreException(
						err("Cannot declare uninitialized global value"));
			}

			globals.declare(val.getName(), val, global.isOverride());
		}
		return Status.OK_STATUS;
	}

	protected static DeclarationContainer getGlobals(IProcess context) {
		ISession session = context.getSession();
		if (!(session instanceof AbstractSession)) {
			return null;
		}

		return ((AbstractSession) session).getRoot().getGlobals();
	}

}
