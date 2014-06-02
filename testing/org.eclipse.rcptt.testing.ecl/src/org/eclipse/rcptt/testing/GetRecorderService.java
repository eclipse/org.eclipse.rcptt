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
package org.eclipse.rcptt.testing;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.recording.NetworkRecorder;
import org.eclipse.rcptt.ui.panels.main.ControlPanelWindow;
import org.eclipse.rcptt.ui.recording.RecordingSupport;

public class GetRecorderService implements ICommandService {

	
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ControlPanelWindow panel = ControlPanelWindow.getOpenedControlPanel();
		if (panel == null) {
			return TestingPlugin.createErrStatus("Control panel isn't opened");
		}
		RecordingSupport recordingSupport = panel.getRecordingSupport();
		NetworkRecorder recorder = recordingSupport.getRecorder();
		if (recorder == null) {
			return TestingPlugin.createErrStatus("Recorder is null");
		}
		context.getOutput().write(recorder);
		return Status.OK_STATUS;
	}
}
