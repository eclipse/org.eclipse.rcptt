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
package org.eclipse.rcptt.tesla.recording.core;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.impl.WaitForRestartImpl;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.network.IConnectionMonitor;
import org.eclipse.rcptt.tesla.internal.core.network.TeslaNetworkCommunication;

public class TeslaNetworkRecorder extends TeslaNetworkCommunication implements
		ITeslaRecorder {
	private TeslaScenarioContainer container = new TeslaScenarioContainer();
	private List<ITeslaRecordListener> listeners = new ArrayList<ITeslaRecordListener>();

	public TeslaNetworkRecorder(String host, int port,
			IConnectionMonitor monitor) {
		super(host, port, monitor);
	}

	public TeslaNetworkRecorder(String host, int port) {
		super(host, port);
	}

	private boolean isPrevCommandAUTRestarting = false;

	protected boolean performCommunications() throws IOException {
		setMode(TeslaMode.RECORDING);

		// Set server mode to replaying
		try {
			while (!communicationSocket.isClosed()) {
				EObject object = readEObject();
				if (object != null && object instanceof CommandTransfer) {
					CommandTransfer transfer = (CommandTransfer) object;
					if (transfer.getCommand() instanceof WaitForRestartImpl) {
						isPrevCommandAUTRestarting = true;
					} else {
						isPrevCommandAUTRestarting = false;
					}
					processTransfer(transfer);
				}
			}
		} catch (EOFException e) {
			// skip
		} catch (IOException e) {
			if ((e.getMessage() != null && (e.getMessage().toLowerCase()
					.contains("socket closed"))) || isPrevCommandAUTRestarting) {
				// Ignore socket closed or AUT restarting
			} else {
				TeslaCore.log(e);
			}
		} finally {
			input.close();
			close();
			for (ITeslaRecordListener listener : getListeners()) {
				listener.disconnected();
			}
		}
		return true;
	}

	public void waitConnection(int timeout) {
		long start = System.currentTimeMillis();
		while (!isConnected() && (start + timeout > System.currentTimeMillis())) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void processTransfer(CommandTransfer transfer) throws IOException {
		container.processTransfer(transfer.getCommand(),
				transfer.getElements(), transfer.getKind(),
				transfer.getControls(), transfer.getIndex(),
				transfer.getRawEvents());
		for (ITeslaRecordListener listener : getListeners()) {
			listener.handleContainerChange();
		}
	}

	public List<ITeslaRecordListener> getListeners() {
		synchronized (listeners) {
			return new ArrayList<ITeslaRecordListener>(listeners);
		}
	}

	public void addListener(ITeslaRecordListener listener) {
		synchronized (listeners) {
			listeners.add(listener);
		}
	}

	public TeslaScenarioContainer getContainer() {
		return container;
	}

	public void removeListener(ITeslaRecordListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public void close() {
		if (communicationSocket != null) {
			try {
				communicationSocket.close();
			} catch (IOException e) {
				TeslaCore.log(e);
			}
		}
		// if (launch != null) {
		// try {
		// launch.terminate();
		// } catch (DebugException e) {
		// TeslaCore.log(e);
		// }
		// }
	}
}
