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

import static org.eclipse.rcptt.ecl.runtime.BoxedValues.box;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.Let;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class LetService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Let)) {
			return Status.CANCEL_STATUS;
		}

		Let let = (Let) command;
		DeclarationContainer locals = getLocals(context);

		boolean inputUsed = false;
		for (Declaration decl : let.getVals()) {
			if (!(decl instanceof Val)) {
				continue; // TODO other declarations support
			}
			Val val = (Val) decl;
			if (val.isInput()) {
				inputUsed = true;
				val.setValue(box(context.getInput().take(Long.MAX_VALUE)));
			}

			locals.declare(val.getName(), val);
		}

		return context
				.getSession()
				.execute(let.getBody(), inputUsed ? null : context.getInput(),
						context.getOutput()).waitFor();
	}

	protected static DeclarationContainer getLocals(IProcess context) {
		ISession session = context.getSession();
		if (!(session instanceof CommandSession)) {
			return null;
		}

		return ((CommandSession) session).getStack().getDeclarations();
	}
}
