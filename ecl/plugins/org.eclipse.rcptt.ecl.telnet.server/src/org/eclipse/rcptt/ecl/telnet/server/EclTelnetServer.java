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
package org.eclipse.rcptt.ecl.telnet.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EclTelnetServer {
	private List<EclTelnetConnection> connections = new ArrayList<EclTelnetConnection>();
	private Connector connector;
	private int port;

	public EclTelnetServer(int port) throws IOException {
		this.port = port;
	}

	public void start() throws IOException {
		connector = new Connector(port);
		connector.start();
	}

	public void stop() {
		if (connector != null) {
			connector.disable();
		}
		for (EclTelnetConnection connection : this.connections) {
			connection.disconnect();
		}
	}

	protected void connect(Socket socket) throws IOException {
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		EclTelnetConnection connection = new EclTelnetConnection();
		connection.connect(inputStream, outputStream);
		this.connections.add(connection);
	}

	protected void disconnect() throws IOException {
	}

	private class Connector extends Thread {
		private ServerSocket socServer;
		private boolean run = true;

		public Connector(int port) throws IOException {
			socServer = new ServerSocket(port);
		}

		void disable() {
			run = false;
		}

		@Override
		public void run() {
			while (this.run) {
				try {
					Socket socket = socServer.accept();
					connect(socket);
				} catch (IOException ioEx) {
					ioEx.printStackTrace();
				}
			}
			if (socServer != null) {
				try {
					socServer.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

}
