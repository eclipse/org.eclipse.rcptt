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
package org.eclipse.rcptt.sherlock.jface;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.util.ILogger;
import org.eclipse.jface.util.Policy;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.reporting.AbstractEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.internal.EventLogEventProvider;

public class JfacePolicyEventProvider extends AbstractEventProvider implements
		IEventProvider, ILogListener {

	private static SherlockJfaceLogger fJFaceLogger;
	private static ILogger fJfaceNativeLogger;

	public JfacePolicyEventProvider() {
		fJFaceLogger = new SherlockJfaceLogger();
	}

	public void storeSnapshot(INodeBuilder builder, String type) {
	}

	public void logging(IStatus status, String plugin) {
		IReportBuilder[] builders = getListeners();
		for (IReportBuilder builder : builders) {
			Event event = ReportFactory.eINSTANCE.createEvent();
			event.setData(org.eclipse.rcptt.ecl.core.util.ProcessStatuses.adapt(status));
			builder.getCurrent().createEvent(event);
		}
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		fJfaceNativeLogger = Policy.getLog();
		Policy.setLog(fJFaceLogger);
	}

	@Override
	protected void doneBuilders() {
		Policy.setLog(fJfaceNativeLogger);
	}

	private class SherlockJfaceLogger implements ILogger {

		public void log(IStatus status) {
			EventLogEventProvider.handledStatus = status;
			logging(status, "org.eclipse.jface");
			fJfaceNativeLogger.log(status);
		}
	};

}
