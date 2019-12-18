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
package org.eclipse.rcptt.ecl.internal.core;

import static org.eclipse.rcptt.ecl.internal.core.LetService.getLocals;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.ProcInstance;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ProcInstanceService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof ProcInstance)) {
			return Status.CANCEL_STATUS;
		}

		ProcInstance instance = (ProcInstance) command;
		DeclarationContainer locals = getLocals(context);

		boolean inputUsed = false;
		for (Declaration decl : instance.getDefinition().getVals()) {
			if (!(decl instanceof Val)) {
				continue; // TODO: pipe support
			}

			Val val = EcoreUtil.copy((Val) decl);
			val.setValue(BoxedValues.box(instance.eGet(instance.eClass()
					.getEStructuralFeature(val.getName()))));
			if (val.isInput()) {
				inputUsed = true;
			}
			locals.declare(val.getName(), val);
		}

		IStatus s = context
				.getSession()
				.execute(instance.getDefinition().getBody(),
						inputUsed ? null : context.getInput(),
						context.getOutput()).waitFor();

		return s.isOK() ? Status.OK_STATUS : new ProcErrorStatus(s);
	}

}
