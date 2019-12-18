/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.operations.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Let;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.operations.Loop;
import org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin;
import org.eclipse.rcptt.ecl.operations.internal.commands.RecurService.RecurStatus;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class LoopService implements ICommandService {
	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		ISession session = context.getSession();
		Loop loop = (Loop) command;
		Val[] vals = loop.getVals().toArray(new Val[loop.getVals().size()]);
		Command body = loop.getBody();

		Let let = CoreFactory.eINSTANCE.createLet();
		let.setBody(body);
		for (Val val : vals) {
			let.getVals().add(val);
		}

		while (true) {
			IPipe out = session.createPipe();
			IStatus status = session.execute(let, null, out).waitFor();
			RecurStatus recurStatus = findRecurStatus(status);
			if (recurStatus == null) {
				// use out pipe
				for (Object o : CoreUtils.readPipeContent(out)) {
					context.getOutput().write(o);
				}
				return status;
			}
			if (recurStatus.vals.length != vals.length) {
				throw new CoreException(OperationsPlugin.createErr(
						"Illegal arity in recur call, expected: %d, invoked: %d", vals.length,
						recurStatus.vals.length));
			}
			for (int i = 0; i < recurStatus.vals.length; i++) {
				vals[i].setValue(recurStatus.vals[i]);
			}
		}
	}

	private static RecurStatus findRecurStatus(IStatus status) {
		return (status instanceof RecurStatus) ? (RecurStatus) status : null;
	}

}
