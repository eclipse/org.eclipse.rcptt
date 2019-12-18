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

import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.swt.widgets.Event;

import org.eclipse.rcptt.core.recording.IRecordingMonitor;
import org.eclipse.rcptt.core.recording.NetworkRecorder;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.recording.core.internal.TeslaRecordingNetworkClientProcessor;

public class UiNetworkRecorder extends NetworkRecorder {

	private static final String RECORD_MODE_SHORTCUTS_FEATURE = TeslaRecordingNetworkClientProcessor.RECORD_MODE_SHORTCUTS_FEATURE; //$NON-NLS-1$
	private static final String ASSERT_MODE_SHORTCUTS_FEATURE = TeslaRecordingNetworkClientProcessor.ASSERT_MODE_SHORTCUTS_FEATURE; //$NON-NLS-1$
	private static final String START_RECORD_SHORTCUTS_FEATURE = TeslaRecordingNetworkClientProcessor.START_RECORD_SHORTCUTS_FEATURE; //$NON-NLS-1$
	private static final String STOP_RECORD_SHORTCUTS_FEATURE = TeslaRecordingNetworkClientProcessor.STOP_RECORD_SHORTCUTS_FEATURE; //$NON-NLS-1$
	private static final String REPLAY_SHORTCUTS_FEATURE = TeslaRecordingNetworkClientProcessor.REPLAY_SHORTCUTS_FEATURE; //$NON-NLS-1$

	private TriggerSequence[] assertModeShortcuts;
	private TriggerSequence[] recordingModeShortcuts;
	private TriggerSequence[] startRecordShortcuts;
	private TriggerSequence[] stopRecordShortcuts;
	private TriggerSequence[] replayShortcuts;

	public UiNetworkRecorder(String host, int port, IRecordingMonitor monitor) {
		super(host, port, monitor);
	}

	@Override
	protected boolean isAssertModeRequest(Type command) {
		return isShortcutsRequest(command, assertModeShortcuts);
	}

	@Override
	protected boolean isRecordingModeRequest(Type command) {
		return isShortcutsRequest(command, recordingModeShortcuts);
	}
	
	@Override
	protected boolean isStartRecordRequest(Type command) {
		return isShortcutsRequest(command, startRecordShortcuts);
	}
	
	@Override
	protected boolean isStopRecordRequest(Type command) {
		return isShortcutsRequest(command, stopRecordShortcuts);
	}
	
	@Override
	protected boolean isReplayRequest(Type command) {
		return isShortcutsRequest(command, replayShortcuts);
	}
	
	private boolean isShortcutsRequest(Type command, TriggerSequence[] shortcuts) {
		Event e = new Event();
		e.character = command.getCharacter();
		e.keyCode = command.getCode();
		e.stateMask = command.getState();
		int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(e);
		KeySequence sequence = KeySequence.getInstance(SWTKeySupport
				.convertAcceleratorToKeyStroke(accelerator));

		if (assertModeShortcuts != null) {
			for (TriggerSequence s : shortcuts) {
				if (sequence.equals(s)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public synchronized void setAssertModeShortcuts(TriggerSequence[] shortcuts) {
		assertModeShortcuts = shortcuts;
		StringBuilder builder = new StringBuilder();
		for (TriggerSequence s : shortcuts)
			builder.append(s).append("\n"); //$NON-NLS-1$
		setFeature(ASSERT_MODE_SHORTCUTS_FEATURE, builder.toString());
	}

	public void setRecordModeShortcuts(TriggerSequence[] shortcuts) {
		recordingModeShortcuts = shortcuts;
		StringBuilder builder = new StringBuilder();
		for (TriggerSequence s : shortcuts)
			builder.append(s).append("\n"); //$NON-NLS-1$
		setFeature(RECORD_MODE_SHORTCUTS_FEATURE, builder.toString());
	}

	public void setStartRecordShortcuts(TriggerSequence[] shortcuts) {
		startRecordShortcuts = shortcuts;
		StringBuilder builder = new StringBuilder();
		for (TriggerSequence s : shortcuts)
			builder.append(s).append("\n"); //$NON-NLS-1$
		setFeature(START_RECORD_SHORTCUTS_FEATURE, builder.toString());
	}
	
	public void setStopRecordShortcuts(TriggerSequence[] shortcuts) {
		stopRecordShortcuts = shortcuts;
		StringBuilder builder = new StringBuilder();
		for (TriggerSequence s : shortcuts)
			builder.append(s).append("\n"); //$NON-NLS-1$
		setFeature(STOP_RECORD_SHORTCUTS_FEATURE, builder.toString());
	}
	
	public void setReplayShortcuts(TriggerSequence[] shortcuts) {
		replayShortcuts = shortcuts;
		StringBuilder builder = new StringBuilder();
		for (TriggerSequence s : shortcuts)
			builder.append(s).append("\n"); //$NON-NLS-1$
		setFeature(REPLAY_SHORTCUTS_FEATURE, builder.toString());
	}
}
