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
package org.eclipse.rcptt.tesla.core.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.network.server.TeslaNetworkClientConnection;

public class TeslaNetworkServer extends Thread {
	private boolean running = true;
	private volatile boolean isStarted = false;
	private final ServerSocket socket;
	private final List<TeslaNetworkClientConnection> clients = new ArrayList<TeslaNetworkClientConnection>();
	private int port;

	public TeslaNetworkServer(final int port) throws IOException {
		super("Tesla network server:" + Integer.toString(port));
		this.port = port;
		socket = new ServerSocket(port);
		socket.setSoTimeout(1000 * 60 * 5);
	}

	public int getPort() {
		return port;
	}

	public boolean isStarted() {
		return isStarted;
	}

	@Override
	public void run() {
		isStarted = true;
		try {
			while ((running && socket != null && !socket.isClosed())
					&& !isInterrupted()) {
				try {
					final Socket clientSocket = socket.accept();
					TeslaNetworkClientConnection client = new TeslaNetworkClientConnection(
							clientSocket, this);
					client.start();
					synchronized (clients) {
						// System.out.println("NEW TESLA CLIENT CONNECTED:"
						// + clients.size());
						clients.add(client);
					}
				} catch (SocketTimeoutException t) {
					// Just socket timeout, ignore it.
				} catch (IOException e) {
					if (running) {
						TeslaCore.log(e);
					}
				}
			}
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (Throwable e) {
				}
			}
		}
	}

	public void shutdown() {
		if (socket != null) {
			running = false;
			try {
				socket.close();
			} catch (IOException e) {
				TeslaCore.log(e);
			}
		}
		TeslaNetworkClientConnection[] clientsCopy;
		synchronized (clients) {
			clientsCopy = clients
					.toArray(new TeslaNetworkClientConnection[clients.size()]);
		}
		for (TeslaNetworkClientConnection client : clientsCopy) {
			client.shutdown();
		}
		clients.clear();
	}

	public void removeClient(final TeslaNetworkClientConnection client) {
		synchronized (clients) {
			clients.remove(client);
		}
	}

	public boolean hasClients() {
		boolean result = false;
		synchronized (clients) {
			result = !clients.isEmpty();
		}
		return result;
	}
}
