/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.recording;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.bindings.BindingManagerEvent;
import org.eclipse.jface.bindings.IBindingManagerListener;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.keys.IBindingService;

public enum RecordingContextManager {

	Instance;

	public static final String CONTROL_PANEL_CONTEXT_ID = "org.eclipse.rcptt.ui.contexts.recording"; //$NON-NLS-1$
	public static final String RECORDING_COMMAND_ID = "org.eclipse.rcptt.ui.commands.recording.recordMode"; //$NON-NLS-1$
	public static final String ASSERTING_COMMAND_ID = "org.eclipse.rcptt.ui.commands.recording.assertMode"; //$NON-NLS-1$
	public static final String START_RECORD_COMMAND_ID = "org.eclipse.rcptt.ui.commands.recording.startRecording"; //$NON-NLS-1$
	public static final String STOP_RECORD_COMMAND_ID = "org.eclipse.rcptt.ui.commands.recording.stopRecording"; //$NON-NLS-1$
	public static final String REPLAY_COMMAND_ID = "org.eclipse.rcptt.ui.commands.recording.replay"; //$NON-NLS-1$

	private final WritableValue recordModeShortcutsObservable = new WritableValue(
			null, TriggerSequence[].class);
	private final WritableValue assertModeShortcutsObservable = new WritableValue(
			null, TriggerSequence[].class);
	private final WritableValue startRecordShortcutsObservable = new WritableValue(
			null, TriggerSequence[].class);
	private final WritableValue stopRecordShortcutsObservable = new WritableValue(
			null, TriggerSequence[].class);
	private final WritableValue replayShortcutsObservable = new WritableValue(
			null, TriggerSequence[].class);

	private final IContextService contextService;
	private final IBindingService bindingService;
	private IContextActivation contextActivation;

	private RecordingContextManager() {
		contextService = (IContextService) PlatformUI.getWorkbench()
				.getService(IContextService.class);
		bindingService = (IBindingService) PlatformUI.getWorkbench()
				.getService(IBindingService.class);
	}

	private void updateTriggerSequences() {
		updateTriggerSequence(RECORDING_COMMAND_ID,
				recordModeShortcutsObservable);
		updateTriggerSequence(ASSERTING_COMMAND_ID,
				assertModeShortcutsObservable);
		updateTriggerSequence(START_RECORD_COMMAND_ID,
				startRecordShortcutsObservable);
		updateTriggerSequence(STOP_RECORD_COMMAND_ID,
				stopRecordShortcutsObservable);
		updateTriggerSequence(REPLAY_COMMAND_ID,
				replayShortcutsObservable);
	}

	private void updateTriggerSequence(String commandId, WritableValue value) {
		TriggerSequence[] sequences = bindingService
				.getActiveBindingsFor(commandId);
		value.setValue(sequences);
	}

	public synchronized void activateContext() {
		if (contextActivation == null) {
			contextActivation = contextService
					.activateContext(CONTROL_PANEL_CONTEXT_ID);
			bindingService.addBindingManagerListener(new BindingServiceListener());
			updateTriggerSequences();
		}
	}

	public synchronized void deactivateContext() {
		if (contextActivation != null) {
			contextService.deactivateContext(contextActivation);
			contextActivation = null;
			bindingService
					.removeBindingManagerListener(new BindingServiceListener());
			updateTriggerSequences();
		}
	}

	public TriggerSequence[] getRecordModeShortcuts() {
		return (TriggerSequence[]) recordModeShortcutsObservable.getValue();
	}

	public TriggerSequence[] getAssertModeShortcuts() {
		return (TriggerSequence[]) assertModeShortcutsObservable.getValue();
	}

	public TriggerSequence[] getStartRecordShortcuts() {
		return (TriggerSequence[]) startRecordShortcutsObservable.getValue();
	}

	public TriggerSequence[] getStopRecordShortcuts() {
		return (TriggerSequence[]) stopRecordShortcutsObservable.getValue();
	}

	public TriggerSequence[] getReplayShortcuts() {
		return (TriggerSequence[]) replayShortcutsObservable.getValue();
	}

	public IObservableValue observeRecordModeShortcuts() {
		return recordModeShortcutsObservable;
	}

	public IObservableValue observeAssertModeShortcuts() {
		return assertModeShortcutsObservable;
	}

	public IObservableValue observeStartRecordShortcuts() {
		return startRecordShortcutsObservable;
	}

	public IObservableValue observeStopRecordShortcuts() {
		return stopRecordShortcutsObservable;
	}

	public IObservableValue observeReplayShortcuts() {
		return replayShortcutsObservable;
	}

	private final class BindingServiceListener implements
			IBindingManagerListener {
		public void bindingManagerChanged(BindingManagerEvent event) {
			updateTriggerSequences();
		}
	}
}
