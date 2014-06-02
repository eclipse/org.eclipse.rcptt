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

public class TeslaServerManager {
	private static TeslaNetworkServer server;

	/**
	 * Make sure Tesla's server started on the specified port. Start server if
	 * it was not started. If it was started on another port, cancel it and
	 * start on the specified port.
	 * 
	 * @throws IOException
	 *             if server can't be started on the specified port
	 */
	public synchronized static void startServer(int port) throws IOException {
		if (server != null) {
			if (server.getPort() == port) {
				// Already started
				return;
			}
			server.interrupt();
			server = null;
		}
		server = new TeslaNetworkServer(port);
		server.start();
		while (!server.isStarted()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				//
			}
		}
	}

	public synchronized static TeslaNetworkServer getServer() {
		return server;
	}

	public synchronized static void stopServer() {
		if (server != null) {
			server.interrupt();
			server = null;
		}
	}

}
