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
package org.eclipse.rcptt.tesla.core.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.internal.core.network.TeslaNetworkStream;

public class TeslaNetworkPlayer extends UIPlayer {
	private TeslaNetworkStream qStream = null;

	public TeslaNetworkPlayer(Socket socket) throws UnknownHostException,
			IOException {
		qStream = new TeslaNetworkStream(socket);
	}

	public Response executeCommand(Command command) throws IOException {
		qStream.writeCommand(command);
		return qStream.readResponse();
	}

	@Override
	public void shutdown() {
		super.shutdown();
		qStream.terminate();
	}

	public void updateSocket(Socket communicationSocket)
			throws UnknownHostException, IOException {
		if (qStream != null) {
			Socket old = qStream.getSocket();
			if (old != null) {
				try {
					old.close();
				} catch (Throwable e) {
				}
			}
		}
		qStream = new TeslaNetworkStream(communicationSocket);
	}

	protected void handleFailure(Throwable e) {
		if (qStream != null) {
			try {
				Socket s = qStream.getSocket();
				if (s != null) {
					s.close();
				}
			} catch (Throwable e1) {
				// Skip
			}
		}
	}
}
