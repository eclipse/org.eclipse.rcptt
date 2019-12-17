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
package org.eclipse.rcptt.launching.events;

import org.eclipse.rcptt.ecl.server.tcp.EclTcpServerManager;

public enum AutEventManager {

	INSTANCE;

	private int port = -1;

	public int getPort() {
		return initialize();
	}

	private synchronized int initialize() {
		if (port == -1) {
			// EclTcpServer server =
			// EclTcpServerManager.Instance.findServer(PORT_RANGE_START,
			// PORT_RANGE_END);
			// if (server != null) {
			// port = server.getPort();
			// }
			for (port = PORT_RANGE_START; port < PORT_RANGE_END; port++) {
				try {
					EclTcpServerManager.Instance.startServer(port);
					return port;
				} catch (Exception e) {
					// OK, let's try another port
				}
			}
		}
		return port;
	}

	private static final int PORT_RANGE_START = 4001;

	private static final int PORT_RANGE_END = 20000;
}
