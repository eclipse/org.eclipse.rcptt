/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.maven.util;

import java.io.IOException;
import java.net.ServerSocket;

public class NetUtils {

	public static int findFreePort(int minPort, int maxPort) {
		for (int port = minPort; port <= maxPort; port++) {
			ServerSocket socket = null;
			try {
				socket = new ServerSocket(port);
				return port;
			} catch (IOException e) {
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return -1;
	}

}
