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
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.core.Let;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.operations.Each;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class EachEntryService implements IScriptletExtension {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		Each cmd = (Each) command;
		EclMap map = (EclMap) cmd.getInput();
		Val val = cmd.getVal();
		Val key = cmd.getKey();

		boolean hasKey = cmd.getKey() != null;

		for (EclMapEntry entry : map.getEntries()) {
			Let let = CoreFactory.eINSTANCE.createLet();
			val.setValue(EcoreUtil.copy(entry.getValue()));
			let.getVals().add(val);
			if (hasKey) {
				key.setValue(entry.getKey());
				let.getVals().add(key);
			}

			IPipe out = context.getSession().createPipe();
			let.setBody(EcoreUtil.copy(cmd.getDo()));
			IStatus bodyStatus = context.getSession().execute(let, null, out).waitFor();
			if (!bodyStatus.isOK()) {
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
		return c instanceof Each && ((Each) c).getInput() instanceof EclMap;
	}

}
