/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.recording;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand;
import org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.internal.core.network.DataSerializer;
import org.eclipse.rcptt.tesla.recording.core.TeslaNetworkRecorder;

public class NetworkRecorder extends TeslaNetworkRecorder {

	private static final String RAW_EVENTS_FEATURE = "raw_events";
	private static final String NOT_NATIVE_EVENTS_IGNORED_FEATURE = "not_native_events_ignored";

	public interface IAssertModeListener {
		void doAssertMode();
	}

	private TeslaScenarioContainer assertContainer = new TeslaScenarioContainer();
	private IAssertModeListener assertModeListener;

	private boolean assertMode = false;

	public NetworkRecorder(String host, int port, IRecordingMonitor monitor) {
		super(host, port, monitor);
	}

	public boolean isAssertMode() {
		return assertMode;
	}

	protected IRecordingMonitor getMonitor() {
		return (IRecordingMonitor) monitor;
	}

	public void toAssertMode(String... classes) throws IOException {
		assertContainer = new TeslaScenarioContainer();
		assertMode = true;
		setMode(TeslaMode.ASSERTIONS, classes);
	}

	public void toRecordMode() throws IOException {
		assertMode = false;
		setMode(TeslaMode.RECORDING);
	}

	public void addAsserts(CommandSet commands, Assert[] asserts) {
		TeslaScenarioContainer container = getContainer();
		for (CommandInfo info : commands.getCommands()) {
			container.add(info.getCommand(), info.getElements(),
					info.getControls(), null);
		}
		for (Assert asrt : asserts) {
			container.add(asrt, null, null, null);
		}
		for (ITeslaRecordListener listener : getListeners()) {
			listener.handleContainerChange();
		}
	}

	@Override
	protected void processTransfer(CommandTransfer transfer) throws IOException {
		if (transfer.getCommand() instanceof Type) {
			if (isStopRecordRequest((Type) transfer.getCommand())) {
				getMonitor().stopRecord();
				return;
			}
			if (isAssertModeRequest((Type) transfer.getCommand())) {
				getMonitor().assertMode();
				if (assertModeListener != null) {
					assertModeListener.doAssertMode();
				}
				return;
			}
		} else if (transfer.getCommand() instanceof UpdateControlCommand) {
			updateControl(transfer, (UpdateControlCommand) transfer.getCommand());
			return;
		}
		if (assertMode) {
			assertContainer.processTransfer(transfer.getCommand(),
					transfer.getElements(), transfer.getKind(),
					transfer.getControls(), transfer.getIndex(),
					transfer.getRawEvents());
			if (transfer.getCommand() instanceof AssertionFocus) {
				AssertionFocus focus = (AssertionFocus) transfer.getCommand();
				addWidget(focus);
			}
			if (transfer.getCommand() instanceof RecordingModeRequest) {
				getMonitor().recordMode();
			}
		} else {
			if (transfer.getCommand() instanceof AssertionFocus) {
				// Ignore it
				return;
			}
			super.processTransfer(transfer);
		}

	}

	private void updateControl(CommandTransfer transfer, UpdateControlCommand command) {
		Element element = command.getElements();
		if (element != null) {
			Command cmd = getCommand(element, assertContainer);
			if (cmd == null) {
				return;
			}
			EList<CommandToElementEntry> elementMapping = assertContainer.getScenario()
					.getElementMapping();
			for (CommandToElementEntry commandToElementEntry : elementMapping) {
				if (commandToElementEntry.getCommand().equals(cmd)) {
					commandToElementEntry.getControls().clear();
					commandToElementEntry.getControls().addAll(transfer.getControls());
				}
			}
		}
	}
	
	private Command getCommand(Element element,
			TeslaScenarioContainer container) {
		if (element == null || element.getId() == null)
			return null;
		List<Command> commands = container.getCommands();
		for (int i = commands.size() - 1; i >= 0; i--) {
			Command cmd = commands.get(i);
			List<Element> elements = container.getElements(cmd);
			if (elements != null) {
				for (Element elementToCheck : elements) {
					if (element.getId().equals(elementToCheck.getId())) {
						return cmd;
					}
				}
			}
		}
		return null;
	}

	protected boolean isAssertModeRequest(Type command) {
		return false;
	}

	protected boolean isRecordingModeRequest(Type command) {
		return false;
	}

	protected boolean isStartRecordRequest(Type command) {
		return false;
	}

	protected boolean isStopRecordRequest(Type command) {
		return false;
	}

	protected boolean isReplayRequest(Type command) {
		return false;
	}

	private void addWidget(AssertionFocus focus) {
		try {
			if (focus.isPointFixed()) {
				CommandSet commands = CommandSet.create(focus, assertContainer);
				getMonitor().assertAdded(commands);
			} else {
				getMonitor().assertAdded(null);
			}
		} catch (Exception e) {
			RcpttPlugin.log(e);
		}
	}

	public void setFeature(String name, String value) {
		SetFeature newMode = RawFactory.eINSTANCE.createSetFeature();
		newMode.setName(name);
		newMode.setValue(value);
		try {
			if (!isConnected()) {
				doConnect(monitor);
			}
			if (output != null) {
				DataSerializer.writeEObject(output, newMode);
			}
		} catch (IOException e) {
			RcpttPlugin.log(e);
		}
	}

	public void enableRawEvents(boolean rawSupported) {
		setFeature(RAW_EVENTS_FEATURE, rawSupported ? "true" : "false");
	}

	public void setNotNativeEventsIgnored(boolean ignored) {
		setFeature(NOT_NATIVE_EVENTS_IGNORED_FEATURE, ignored ? "true"
				: "false");
	}

	public void setAssertModeListener(IAssertModeListener iAssertModeListener) {
		this.assertModeListener = iAssertModeListener;
	}

	public void resetAssertSelection() {
		try {
			DataSerializer.writeEObject(output,
					RawFactory.eINSTANCE.createResetAssertSelection());
		} catch (IOException e) {
			RcpttPlugin.log(e);
		}
	}
}
