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
package org.eclipse.rcptt.tesla.recording.core.swt;

import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.recording.aspects.IUIIDEEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.UIIDEEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class UIIDERecordingProcessor implements IRecordingProcessor,
		IUIIDEEventListener {
	private TeslaRecorder recorder;

	public UIIDERecordingProcessor() {
		UIIDEEventManager.addListener(this);
	}

	@SuppressWarnings("unused")
	private SWTEventRecorder getSWTProcessor() {
		return recorder.getProcessor(SWTEventRecorder.class);
	}

	public void restartEclipse() {
		// WaitForRestart command is created by
		// WorkbenchRecordingProcessor.restartEclipse()
		// it must not be added here

		// getSWTProcessor().getRecorder().safeExecuteCommand(
		// ProtocolFactory.eINSTANCE.createWaitForRestart());
	}

	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	public int getInitLevel() {
		return 1000;
	};

	public void clear() {

	}

	public void setFreeze(boolean value, SetMode command) {
	}

	public void resetAssertSelection() {
	}

	public IRecordingHelper<?> getHelper() {
		return null;
	}
}
