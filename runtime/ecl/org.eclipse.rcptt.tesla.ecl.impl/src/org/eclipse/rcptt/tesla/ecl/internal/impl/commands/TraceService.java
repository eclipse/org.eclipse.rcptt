/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
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
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.TraceData;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.tesla.ecl.model.Trace;

public class TraceService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		final Trace trace = (Trace) command;
		final ReportBuilder builder = ReportManager.getBuilder();
		builder.withCurrentNode(new Procedure1<Node>() {
			
			@Override
			public void apply(Node root) {
				Event event = builder.createEvent(root);

				EventSource source = ReportFactory.eINSTANCE.createEventSource();
				source.setName("trace");

				TraceData data = ReportFactory.eINSTANCE.createTraceData();
				data.setMessage(trace.getMessage());

				event.setKind(EventKind.INFO);
				event.setData(data);
				event.setSource(source);
			}
		});

		return Status.OK_STATUS;
	}
}
