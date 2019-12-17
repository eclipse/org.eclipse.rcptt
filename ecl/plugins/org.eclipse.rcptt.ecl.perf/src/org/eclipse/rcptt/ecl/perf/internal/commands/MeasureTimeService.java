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
package org.eclipse.rcptt.ecl.perf.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.perf.MeasureTime;
import org.eclipse.rcptt.ecl.perf.PerfCounter;
import org.eclipse.rcptt.ecl.perf.PerfFactory;
import org.eclipse.rcptt.ecl.perf.StartTimeMeasure;
import org.eclipse.rcptt.ecl.perf.StopTimeMeasure;
import org.eclipse.rcptt.ecl.perf.internal.EclPerfPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class MeasureTimeService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		/*
		 * With with = (With) command; ISession session = process.getSession();
		 * IPipe pipe = session.createPipe(); pipe.write(with.getObject());
		 * pipe.close(Status.OK_STATUS); IProcess doProcess =
		 * session.execute(with.getDo(), pipe, null); return
		 * doProcess.waitFor();
		 */
		MeasureTime measureTime = (MeasureTime) command;
		ISession session = context.getSession();
		IStatus startStatus = session.execute(
				createStart(measureTime.getLabel())).waitFor();
		if (!startStatus.isOK()) {
			return startStatus;
		}

		IStatus bodyStatus = session.execute(measureTime.getDo()).waitFor();
		if (!bodyStatus.isOK()) {
			return bodyStatus;
		}

		IPipe out = session.createPipe();
		IStatus stopStatus = session.execute(
				createStop(measureTime.getLabel()), null, out).waitFor();
		if (!stopStatus.isOK()) {
			return stopStatus;
		}

		Object o = out.take(0);
		if (o == null || !(o instanceof PerfCounter)) {
			return new Status(IStatus.ERROR, EclPerfPlugin.PLUGIN_ID,
					"Internal error: cannot get perf counter with name "
							+ measureTime.getLabel());
		}

		context.getOutput().write(o);
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}

	private StartTimeMeasure createStart(String label) {
		StartTimeMeasure result = PerfFactory.eINSTANCE
				.createStartTimeMeasure();
		result.setLabel(label);
		return result;
	}

	private StopTimeMeasure createStop(String label) {
		StopTimeMeasure result = PerfFactory.eINSTANCE.createStopTimeMeasure();
		result.setLabel(label);
		return result;
	}

}
