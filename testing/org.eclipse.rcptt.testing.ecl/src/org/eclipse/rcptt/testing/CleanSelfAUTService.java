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
package org.eclipse.rcptt.testing;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.internal.core.Session;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.ScenarioFactory;
import org.eclipse.rcptt.core.scenario.WorkbenchContext;
import org.eclipse.rcptt.debug.DebugContext;
import org.eclipse.rcptt.debug.DebugFactory;
import org.eclipse.rcptt.core.ecl.core.model.EnterContext;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;

public class CleanSelfAUTService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {

		Session s = new Session();
		
		DebugContext ctx = DebugFactory.eINSTANCE.createDebugContext();
		ctx.setNoLaunches(true);
		ctx.setNoBreakpoints(true);
		ctx.setNoLaunchShortcuts(false);
		ctx.setId("clean_self_aut_debug");

		applyCtx(s, ctx);
		
		WorkbenchContext defaultWorkbenchContext = ScenarioFactory.eINSTANCE
				.createWorkbenchContext();
		defaultWorkbenchContext.setCloseEditors(false);
		defaultWorkbenchContext.setId("clean_self_aut_workbench");
		defaultWorkbenchContext.setNoModalDialogs(true);
		defaultWorkbenchContext.setResetPerspective(false);
		defaultWorkbenchContext.setName("Close modal dialogs");
		defaultWorkbenchContext.setDescription("");
		defaultWorkbenchContext.setClearClipboard(false);
		applyCtx(s,defaultWorkbenchContext);
		
		s.close();

		return Status.OK_STATUS;
	}

	private void applyCtx(Session s, Context ctx) throws CoreException {
		EnterContext apply = Q7CoreFactory.eINSTANCE.createEnterContext();
		apply.setData(ctx);
		s.execute(apply);
	}
}
