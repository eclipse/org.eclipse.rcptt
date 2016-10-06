/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;

public class GetTestCaseNameService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		ReportBuilder builder = ReportManager.getBuilder();
		if (builder == null)
			return Status.CANCEL_STATUS;

		INodeBuilder current = builder.getCurrent();
		if (current == null)
			return Status.CANCEL_STATUS;

		// move up to root node
		while (current.getParent() != null) {
			current = current.getParent();
		}

		String nodeName = current.getName();
		context.getOutput().write(nodeName);

		return Status.OK_STATUS;
	}
}
