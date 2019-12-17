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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.GetWidgetDetails;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class GetWidgetDetailsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		final GetWidgetDetails getPropertyNodes = (GetWidgetDetails) command;
		final IProcess finalContext = context;
		final IStatus[] resultStatus = new IStatus[] { Status.OK_STATUS };

		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

			public void run() {
				EObject response = null;
				List<IRecordingProcessor> processors = TeslaRecorder
						.getInstance().getProcessors(IRecordingProcessor.class);

				for (IRecordingProcessor processor : processors) {
					IRecordingHelper<?> recordingHelper = processor.getHelper();
					if (recordingHelper != null) {
						try {
							String details = processor.getHelper()
									.getWidgetDetails(
											getPropertyNodes.getElement());
							if (details != null) {
								response = BoxedValues.box(details);
								break;
							}
						} catch (Exception e) {

							resultStatus[0] = TeslaImplPlugin.err(
									"Failed to get widget details", e);
							return;
						}
						if (response != null) {
							break;
						}
					}
				}
				try {
					if (response == null) {
						finalContext.getOutput().write(BoxedValues.box(""));
					} else {
						finalContext.getOutput().write(response);
					}
				} catch (CoreException e) {
					resultStatus[0] = TeslaImplPlugin.err(
							"Write output error.", e);
					TeslaBridge.makeScreenshot(true,
							resultStatus[0].getMessage());

				}
			}
		});

		return resultStatus[0];
	}
}
