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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.ui.RWTUtils;

public class GetPropertyNodesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		final GetPropertyNodes getPropertyNodes = (GetPropertyNodes) command;
		final IProcess finalContext = context;
		final IStatus[] resultStatus = new IStatus[] { Status.OK_STATUS };

		RWTUtils.findDisplay().syncExec(new Runnable() {

			public void run() {
				PropertyNodeList response = null;
				List<IRecordingProcessor> processors = TeslaRecorder
						.getInstance().getProcessors(IRecordingProcessor.class);

				for (IRecordingProcessor processor : processors) {
					IRecordingHelper<?> recordingHelper = processor.getHelper();
					if (recordingHelper != null) {
						try {
							response = processor.getHelper().getNodeProperties(
									getPropertyNodes.getElement(),
									getPropertyNodes.getNodePath());
						} catch (Exception e) {

							resultStatus[0] = TeslaImplPlugin.err(
									"Failed to get property nodes for path \""
											+ getPropertyNodes.getNodePath()
											+ "\".", e);
							TeslaBridge.makeScreenshot(true,
									resultStatus[0].getMessage());
							return;
						}
						if (response != null) {
							break;
						}
					}
				}
				try {
					if (response == null) {
						resultStatus[0] = TeslaImplPlugin
								.error("Property nodes for path \""
										+ getPropertyNodes.getNodePath()
										+ "\" not found.");
						TeslaBridge.makeScreenshot(true,
								resultStatus[0].getMessage());
						return;
					}
					finalContext.getOutput().write(response);
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
