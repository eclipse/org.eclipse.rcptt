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
package org.eclipse.rcptt.ecl.internal.debug.runtime;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DebugServer {

	public static DebugServer start(String id) throws IOException {
		DebugServer server = new DebugServer(id);
		servers.put(id, server);
		return server;
	}

	public static DebugServer get(String id) {
		return servers.get(id);
	}

	public String getId() {
		return id;
	}

	public int getPort() {
		return socket.getLocalPort();
	}

	public void stop() {
		servers.remove(getId());
		try {
			socket.close();
		} catch (IOException e) {
			// safe close
		}
		terminate();
	}

	private DebugServer(String id) throws IOException {
		this.id = id;
		socket = new ServerSocket(0);

		new Thread() {
			public void run() {
				accept();
			};
		}.start();
	}

	private void accept() {
		try {
			if (isTerminated()) {
				return;
			}
			transport = new ServerSession(socket.accept(), id);
		} catch (Exception e) {
			Log.log(e);
		}
	}

	private synchronized void terminate() {
		terminated = true;
		if (transport != null) {
			transport.terminate();
		}
	}

	private synchronized boolean isTerminated() {
		return terminated;
	}

	private final static Map<String, DebugServer> servers = new ConcurrentHashMap<String, DebugServer>();

	private final ServerSocket socket;
	private final String id;

	// synchronized with "this"
	private ServerSession transport;
	private boolean terminated;

}
