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
import org.eclipse.rcptt.ecl.perf.PerfCounter;
import org.eclipse.rcptt.ecl.perf.StopTimeMeasure;
import org.eclipse.rcptt.ecl.perf.internal.EclPerfPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class StopTimeMeasureService implements ICommandService {
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		PerfCounter result = EclPerfPlugin.getDefault().getPerfService()
				.stopTimeMeasure(((StopTimeMeasure) command).getLabel());
		context.getOutput().write(result);
		context.getOutput().close(Status.OK_STATUS);
		return Status.OK_STATUS;
	}

}
