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
package org.eclipse.rcptt.tesla.internal.core.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.raw.CloseConnection;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResetAssertSelection;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.core.server.TeslaNetworkServer;
import org.eclipse.rcptt.tesla.internal.core.network.DataSerializer;

public class TeslaNetworkClientConnection extends Thread {
	final private Socket socket;
	final private DataInputStream din;
	final private DataOutputStream dout;
	private boolean running = true;
	private TeslaMode mode = TeslaMode.FEATURES;
	private NetworkTeslaClient teslaClient;

	private ITeslaNetworkClientProcessor[] processors = new TeslaNetworkProcessorManager()
			.getProcessors();

	private TeslaNetworkServer server;

	public TeslaNetworkClientConnection(Socket socket, TeslaNetworkServer server)
			throws IOException {
		super("Tesla network client connection:" + socket.getLocalPort());
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
					"Initialize runtime connection: " + socket.getLocalPort());
		}
		this.socket = socket;
		this.server = server;
		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		teslaClient = new NetworkTeslaClient(dout, Long.toString(getId()));
		for (ITeslaNetworkClientProcessor processor : processors) {
			if (TeslaFeatures.isActivityLogging()) {
				Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
						"Initialize processor: "
								+ processor.getClass().getName());
			}
			processor.initialize(this, din, dout, teslaClient);
		}
	}

	@Override
	public void run() {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
					"Initialize connection to:"
							+ socket.getLocalAddress().toString() + ":"
							+ socket.getPort());
		}
		try {
			while (running && socket != null && !socket.isClosed()) {
				try {
					final EObject object = DataSerializer.readEObject(din);
					if (TeslaFeatures.isActivityLogging()) {
						Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
								"Read object: " + object.eClass().getName());
					}
					if (object instanceof CloseConnection) {
						terminate();
						return;
					}
					if (object instanceof SetMode) {
						final SetMode newMode = (SetMode) object;
						if (TeslaFeatures.isActivityLogging()) {
							Q7LoggingManager.logMessage(
									IQ7ActivityLogs.NETWORK, "set mode to: "
											+ newMode.getMode().name());
						}
						// Notify all processors about mode change.
						if (!mode.equals(newMode.getMode())) {
							for (ITeslaNetworkClientProcessor processor : processors) {
								processor.activateMode((SetMode) object, mode);
							}
							mode = newMode.getMode();
						}
					}
					if (object instanceof ResetAssertSelection) {
						for (ITeslaNetworkClientProcessor processor : processors) {
							processor.resetAssertSelection();
						}
					}
					if (object instanceof Command) {
						final Command cmd = (Command) object;
						teslaClient.addCommand(cmd);
						// Response should be written using processor
						// Client will wait for response, so all is ok.
					}
					if (object instanceof SetFeature) {
						final SetFeature feature = (SetFeature) object;
						for (ITeslaNetworkClientProcessor processor : processors) {
							processor.setFeature(feature.getName(),
									feature.getValue());
						}
					}
				} catch (EOFException e) {
					terminate();
				} catch (IOException e) {
					if (running) {
						e.printStackTrace();
					}
					terminate();
				}
			}
		} finally {
			if (TeslaFeatures.isActivityLogging()) {
				Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
						"Terminate client session");
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private void terminate() {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
					"Terminate is called");
		}
		running = false;
		server.removeClient(this);
		final boolean hasClients = server.hasClients();
		for (ITeslaNetworkClientProcessor processor : processors) {
			if (TeslaFeatures.isActivityLogging()) {
				Q7LoggingManager
						.logMessage(IQ7ActivityLogs.NETWORK,
								"Terminate processor:"
										+ processor.getClass().getName());
			}
			processor.terminate(!hasClients);
		}
	}

	public void shutdown() {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.NETWORK,
					"Shotdown is called");
		}
		if (running) {
			terminate();
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// Ignore
				}
			}
		}
	}
}
