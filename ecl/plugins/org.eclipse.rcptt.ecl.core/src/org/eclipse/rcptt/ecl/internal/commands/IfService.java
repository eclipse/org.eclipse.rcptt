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
package org.eclipse.rcptt.ecl.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.If;
import org.eclipse.rcptt.ecl.core.Let;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class IfService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof If)) {
			return Status.CANCEL_STATUS;
		}

		If iff = (If) command;
		ISession session = context.getSession();
		boolean condition = false;
		if(iff.getCondition() instanceof BoxedValue) {
			condition = BoxedValues.toBoolean((BoxedValue) iff.getCondition());
		}
		Command branch = condition ? iff.getThen() : iff.getElse();
		if (branch == null) {
			return Status.OK_STATUS; // nothing to do
		}
		return session.execute(wrapBody(branch), context.getInput(), context.getOutput())
				.waitFor();
	}

	private static Command wrapBody(Command body) {
		Let let = CoreFactory.eINSTANCE.createLet();
		let.setBody(body);
		return let;
	}

}
