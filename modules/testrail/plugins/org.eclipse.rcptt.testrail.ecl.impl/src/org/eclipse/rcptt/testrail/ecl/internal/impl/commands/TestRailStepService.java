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
package org.eclipse.rcptt.testrail.ecl.internal.impl.commands;

import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.testrail.TestRailStep;

public class TestRailStepService implements ICommandService {
	private static final String TESTRAILSTEP_PROPERTYNAME = "test-rail-step:{0}";

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		TestRailStep step = (TestRailStep) command;
		INodeBuilder node = ReportManager.getBuilder().getCurrent();
		while (node.getParent() != null) {
			node = node.getParent();
		}
		int id = 1;
		String name = generatePropertyName(id);
		while (node.getProperty(name) != null) {
			id++;
			name = generatePropertyName(id);
		}
		node.setProperty(name, step);
		return Status.OK_STATUS;
	}

	private static String generatePropertyName(int id) {
		return MessageFormat.format(TESTRAILSTEP_PROPERTYNAME, String.valueOf(id));
	}
}