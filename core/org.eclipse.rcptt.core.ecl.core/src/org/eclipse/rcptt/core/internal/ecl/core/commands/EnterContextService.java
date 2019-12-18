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
package org.eclipse.rcptt.core.internal.ecl.core.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.ecl.core.model.EnterContext;
import org.eclipse.rcptt.core.internal.ecl.core.Utils;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.reporting.core.RunnableWithStatus;

public class EnterContextService implements ICommandService {

	public IStatus service(Command command, final IProcess context)
			throws InterruptedException, CoreException {
		EnterContext ewc = (EnterContext) command;
		final Context data = ewc.getData();
		Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
		info.setType(ItemKind.CONTEXT);
		info.setId(data.getId());
		info.setTags(data.getTags());
		info.setSubtype(data.getId());
		info.setDescription(data.getDescription());

		RunnableWithStatus runnable = new RunnableWithStatus() {
			@Override
			public void run() throws CoreException {
				ContextTypeManager.getInstance().apply(data, context.getSession());
			}
		};
		Utils.reportExecution(ReportManager.getCurrentReportNode(), runnable, data.getName() == null ? "Unnamed ctx"
				: data.getName(), info);
		return Status.OK_STATUS;
	}
}
