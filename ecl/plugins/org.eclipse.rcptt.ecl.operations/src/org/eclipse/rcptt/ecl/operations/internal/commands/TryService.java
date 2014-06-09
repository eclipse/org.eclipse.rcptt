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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.operations.Try;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class TryService implements ICommandService {

	public IStatus service(Command command, IProcess process)
			throws InterruptedException, CoreException {
		Try t = (Try) command;
		Integer times = t.getTimes();
		Integer delay = t.getDelay();
		if (delay == null)
			delay = 100;
		if (delay < 0)
			return new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
					"Illegal parameter 'delay'");
		if (times != null && times <= 0)
			return new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
					"Illegal parameter 'times'");
		final List<Object> inputContent = CoreUtils.readPipeContent(process.getInput());
		IStatus status = Status.OK_STATUS;
		try {
			for (int i = 0; times == null || i < times; i++) {
				IPipe input = process.getSession().createPipe();
				for (Object o : inputContent)
					input.write(o);
				input.close(Status.OK_STATUS);
				IPipe output = process.getSession().createPipe();
				IProcess doProcess = process.getSession().execute(
						t.getCommand(), input, output);
				status = doProcess.waitFor();
				if (status.isOK()) {
					List<Object> outputContent = CoreUtils.readPipeContent(output);
					for (Object o : outputContent)
						process.getOutput().write(o);
					// return status;
					break;
				}
				if (delay > 0) {
					Thread.sleep(delay);
				}
			}
			// Do catch
			if (!status.isOK()) {
				if (t.getCatch() != null) {
					IPipe input = process.getSession().createPipe();
					for (Object o : inputContent)
						input.write(o);
					input.close(Status.OK_STATUS);
					IPipe output = process.getSession().createPipe();
					IProcess doProcess = process.getSession().execute(
							t.getCatch(), input, output);
					IStatus status2 = doProcess.waitFor();
					if (status2.isOK()) {
						List<Object> outputContent = CoreUtils.readPipeContent(output);
						for (Object o : outputContent)
							process.getOutput().write(o);
						status = status2;
					} else {
						status = status2;
					}
				}
			}
		} finally {
			if (t.getFinally() != null) {
				IPipe input = process.getSession().createPipe();
				for (Object o : inputContent)
					input.write(o);
				input.close(Status.OK_STATUS);
				IPipe output = process.getSession().createPipe();
				IProcess doProcess = process.getSession().execute(
						t.getFinally(), input, output);
				IStatus status2 = doProcess.waitFor();
				if (status2.isOK()) {
					List<Object> outputContent = CoreUtils.readPipeContent(output);
					for (Object o : outputContent)
						process.getOutput().write(o);
				} else {
					status = status2;
				}
			}
		}
		return status;
	}
}
