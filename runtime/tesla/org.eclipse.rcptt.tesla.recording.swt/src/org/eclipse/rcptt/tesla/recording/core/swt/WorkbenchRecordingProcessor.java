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

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusAdapter;

import org.eclipse.rcptt.tesla.core.protocol.PartUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.recording.aspects.ActionType;
import org.eclipse.rcptt.tesla.recording.aspects.IWorkbenchEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.WorkbenchEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class WorkbenchRecordingProcessor implements IRecordingProcessor,
		IWorkbenchEventListener {
	private TeslaRecorder recorder;

	public WorkbenchRecordingProcessor() {
		WorkbenchEventManager.addListener(this);
		PlatformUI.getWorkbench().addWorkbenchListener(new IWorkbenchListener() {
			public boolean preShutdown(IWorkbench workbench, boolean forced) {
				return true;
			}

			public void postShutdown(IWorkbench workbench) {
				restartEclipse();
			}
		});
	}

	public void closeEditors(IEditorReference[] refArray) {
		Display display = PlatformUI.getWorkbench().getDisplay();
		Shell[] shells = display.getShells();
		for (Shell shell : shells) {
			if (SWTEventRecorder.isModal(shell)) {
				return;
			}
		}
		if (!getSWTProcessor().getRecorder().hasListeners()) {
			return;
		}
		for (IEditorReference ref : refArray) {
			PartUIElement resultPart = getSWTProcessor().getLocator()
					.findPartElement(ref.getPart(false), false);
			if (resultPart != null) {
				resultPart.close();
			}
		}
	}

	private SWTEventRecorder getSWTProcessor() {
		return recorder.getProcessor(SWTEventRecorder.class);
	}

	public void restartEclipse() {
		getSWTProcessor().getRecorder().safeExecuteCommand(
				ProtocolFactory.eINSTANCE.createWaitForRestart());
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

	public void recordAction(ActionType type) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		recorder.safeExecuteCommand(commandByAction(type));
	}

	private Command commandByAction(ActionType type) {
		switch (type) {
		case ABOUT_DIALOG:
			return ProtocolFactory.eINSTANCE.createClickAboutMenu();
		case PREFERENCE_DIALOG:
			return ProtocolFactory.eINSTANCE.createClickPreferencesMenu();
		}
		throw new IllegalArgumentException("Couldn't find command for action: "
				+ type);
	}

	public void recordAddStatus(StatusAdapter adapter, boolean modal) {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		SetStatusDialogMode mode = ProtocolFactory.eINSTANCE
				.createSetStatusDialogMode();
		mode.setEnabled(true);
		recorder.executeCommand(mode);
	}

	public void recordStatusCleanup() {
		if (recorder == null) {
			return;
		}
		if (!recorder.hasListeners()) {
			return;
		}
		SetStatusDialogMode mode = ProtocolFactory.eINSTANCE
				.createSetStatusDialogMode();
		mode.setEnabled(false);
		recorder.executeCommand(mode);
	}

	public void resetAssertSelection() {
	}

	public IRecordingHelper<?> getHelper() {
		return null;
	}
}
