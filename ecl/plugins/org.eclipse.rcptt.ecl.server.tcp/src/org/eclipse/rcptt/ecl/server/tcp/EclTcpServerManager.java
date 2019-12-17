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
package org.eclipse.rcptt.ecl.server.tcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public enum EclTcpServerManager {
	Instance;

	private final Map<Integer, EclTcpServer> servers = new HashMap<Integer, EclTcpServer>();

	public EclTcpServer startServer(int port) throws IOException {
		return startServer(port, true, false);
	}

	public synchronized EclTcpServer startServer(int port, boolean useJobs,
			boolean useFixedPool) throws IOException {
		EclTcpServer server = servers.get(port);
		if (server == null) {
			EclTcpServer newServer = new EclTcpServer(port, useJobs);
			newServer.start();
			while (newServer.isStarting()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// Ignore
				}
			}
			servers.put(port, newServer);
			return newServer;
		} else {
			throw new IOException("Another server is already running on port "
					+ port);
		}
	}

	public synchronized void stopServer(int port) throws IOException {
		EclTcpServer server = servers.remove(port);
		if (server != null) {
			server.interrupt();
			try {
				server.join(10000);
				if (server.isAlive())
					throw new IOException("Failed to stop " + server);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new IOException("Failed to stop server", e);
			}
		} else {
			throw new IOException("No server found on port " + port);
		}
	}

	public synchronized EclTcpServer getServer(int port) {
		return servers.get(port);
	}

	public synchronized void terminateAll() {
		HashSet<Integer> ports = new HashSet<Integer>(servers.keySet());
		IOException result = null;
		for (int i : ports) {
			try {
				stopServer(i);
			} catch (IOException e) {
				if (result == null) {
					result = e;
				} else {
					result.addSuppressed(e);
				}
			}
		}
	}
}
