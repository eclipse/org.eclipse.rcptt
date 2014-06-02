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
package org.eclipse.rcptt.tesla.recording.core.internal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.network.DataSerializer;
import org.eclipse.rcptt.tesla.internal.core.network.server.ITeslaNetworkClientProcessor;
import org.eclipse.rcptt.tesla.internal.core.network.server.NetworkTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.network.server.TeslaNetworkClientConnection;
import org.eclipse.rcptt.tesla.recording.core.ITeslaRecordingListener;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class TeslaRecordingNetworkClientProcessor implements
		ITeslaNetworkClientProcessor, ITeslaRecordingListener {

	public static final String RAW_EVENTS_FEATURE = "raw_events";
	public static final String NOT_NATIVE_EVENTS_IGNORED_FEATURE = "not_native_events_ignored";
	public static final String RECORD_MODE_SHORTCUTS_FEATURE = "record_mode_shortcuts";
	public static final String ASSERT_MODE_SHORTCUTS_FEATURE = "assert_mode_shortcuts";
	public static final String START_RECORD_SHORTCUTS_FEATURE = "start_record_shortcuts";
	public static final String STOP_RECORD_SHORTCUTS_FEATURE = "stop_record_shortcuts";
	public static final String REPLAY_SHORTCUTS_FEATURE = "replay_shortcuts";

	// private NetworkTeslaClient client;
	// private DataInputStream din;
	private DataOutputStream dout;

	// private TeslaNetworkClientConnection connection;

	public TeslaRecordingNetworkClientProcessor() {
	}

	public void activateMode(SetMode command, TeslaMode oldMode) {
		TeslaMode mode = command.getMode();
		boolean assertionsMode = mode.equals(TeslaMode.ASSERTIONS);
		if (mode.equals(TeslaMode.RECORDING) || assertionsMode) {
			TeslaRecorder.getInstance().setFreeze(assertionsMode, command);
			TeslaRecorder.getInstance().clear();
			TeslaRecorder.getInstance().addListener(this);
			TeslaRecorder.getInstance().notifySetRecordingMode(true);
		} else {
			TeslaRecorder.getInstance().setFreeze(false, command);
			TeslaRecorder.getInstance().clear();
			TeslaRecorder.getInstance().removeListener(this);
			TeslaRecorder.getInstance().notifySetRecordingMode(false);
		}
	}

	public void initialize(
			TeslaNetworkClientConnection teslaNetworkClientConnection,
			DataInputStream din, DataOutputStream dout,
			NetworkTeslaClient teslaClient) {
		// this.client = teslaClient;
		// this.din = din;
		this.dout = dout;
		// this.connection = teslaNetworkClientConnection;
	}

	public void recordCommand(Command command, List<Element> elements,
			CommandTransferKind kind, List<Widget> controls, int index,
			List<RawEvent> rawEvents) {
		CommandTransfer transfer = RawFactory.eINSTANCE.createCommandTransfer();
		transfer.setKind(kind);
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		transfer.setCommand((command != null) ? (Command) EcoreUtil
				.copy(command) : null);
		transfer.setIndex(index);
		if (rawEvents != null) {
			transfer.getRawEvents().addAll(rawEvents);
		}
		if (elements != null) {
			for (Element element : elements) {
				transfer.getElements().add(
						(element != null) ? (Element) EcoreUtil.copy(element)
								: null);
			}
		}
		if (controls != null) {
			for (Widget control : controls) {
				transfer.getControls().add(
						(control != null) ? (Widget) EcoreUtil.copy(control)
								: null);
			}
		}
		try {
			DataSerializer.writeTransfer(dout, transfer);
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
	}

	public void terminate(boolean last) {
		// Unfreeze in any case
		TeslaRecorder.getInstance().setFreeze(false, null);
		TeslaRecorder.getInstance().removeListener(this);
		if (last) {
			TeslaRecorder.getInstance().notifySetRecordingMode(false);
			TeslaRecorder.getInstance().clear();
		}
	}

	public void setFeature(String name, String value) {
		if (RAW_EVENTS_FEATURE.equals(name)) {
			TeslaRecorder.getInstance().setRawEvents("true".equals(value));
		} else if (NOT_NATIVE_EVENTS_IGNORED_FEATURE.equals(name)) {
			TeslaRecorder.getInstance().setNotNativeEventsIgnored(
					"true".equals(value));
		} else if (RECORD_MODE_SHORTCUTS_FEATURE.equals(name)) {
			String[] shortcuts = value.split("\n");
			TeslaRecorder.getInstance().setRecordModeShortcuts(shortcuts);
		} else if (ASSERT_MODE_SHORTCUTS_FEATURE.equals(name)) {
			String[] shortcuts = value.split("\n");
			TeslaRecorder.getInstance().setAssertModeShortcuts(shortcuts);
		} else if (START_RECORD_SHORTCUTS_FEATURE.equals(name)) {
			String[] shortcuts = value.split("\n");
			TeslaRecorder.getInstance().setStartRecordShortcuts(shortcuts);
		} else if (STOP_RECORD_SHORTCUTS_FEATURE.equals(name)) {
			String[] shortcuts = value.split("\n");
			TeslaRecorder.getInstance().setStopRecordShortcuts(shortcuts);
		} else if (REPLAY_SHORTCUTS_FEATURE.equals(name)) {
			String[] shortcuts = value.split("\n");
			TeslaRecorder.getInstance().setReplayShortcuts(shortcuts);
		}
	}

	public void resetAssertSelection() {
		TeslaRecorder.getInstance().resetAssertSelection();
	}
}
