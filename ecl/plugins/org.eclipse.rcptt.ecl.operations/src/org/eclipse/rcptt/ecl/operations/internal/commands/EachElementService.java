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

import static org.eclipse.rcptt.ecl.runtime.BoxedValues.box;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.core.Let;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.operations.Each;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class EachElementService implements IScriptletExtension {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		Each cmd = (Each) command;
		EclList list = (EclList) cmd.getInput();
		Val val = cmd.getVal();
		Val index = cmd.getKey();

		boolean hasIndex = cmd.getKey() != null;

		int length = list.getElements().size();
		for (int i = 0; i < length; i++) {
			Let let = CoreFactory.eINSTANCE.createLet();
			val.setValue(EcoreUtil.copy(list.getElements().get(i)));
			let.getVals().add(val);
			if (hasIndex) {
				index.setValue(box(i));
				let.getVals().add(index);
			}

			IPipe out = context.getSession().createPipe();
			let.setBody(EcoreUtil.copy(cmd.getDo()));
			IStatus bodyStatus = context.getSession().execute(let, null, out).waitFor();
			if (!bodyStatus.isOK()) {
				if (bodyStatus instanceof MultiStatus) {
					((MultiStatus) bodyStatus).add(new Status(bodyStatus.getSeverity(), bodyStatus.getPlugin(),
							"List each failed on value " + val.getName() + ": "
									+ CoreUtils.adaptSingleObject(String.class, val.getValue(), false)));
				}
				return bodyStatus;
			}
			for (Object outObj : CoreUtils.readPipeContent(out)) {
				context.getOutput().write(outObj);
			}
		}
		return Status.OK_STATUS;
	}

	@Override
	public boolean canHandle(Command c) {
		return c instanceof Each && ((Each) c).getInput() instanceof EclList;
	}

}
