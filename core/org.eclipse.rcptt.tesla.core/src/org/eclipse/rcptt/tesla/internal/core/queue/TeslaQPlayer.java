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
package org.eclipse.rcptt.tesla.internal.core.queue;

import java.io.IOException;
import java.net.UnknownHostException;

import org.eclipse.rcptt.tesla.core.protocol.TeslaStream;
import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

public class TeslaQPlayer extends UIPlayer {
	private TeslaStream qStream = null;

	public TeslaQPlayer(TeslaQClient client) throws UnknownHostException,
			IOException {
		// Make reversed stream
		qStream = new TeslaQStream(client.qStream);
	}

	protected void notifyUI() {
	}

	public Response executeCommand(Command command) throws IOException {
		qStream.writeCommand(command);
		notifyUI();
		return qStream.readResponse();
	}

	@Override
	public void shutdown() {
		qStream.terminate();
		super.shutdown();
	}
}
