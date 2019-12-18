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

import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.internal.core.network.DefaultConnectionMonitor;
import org.eclipse.rcptt.tesla.internal.core.network.IConnectionMonitor;
import org.eclipse.rcptt.tesla.internal.core.network.TeslaNetworkCommunication;

public class TeslaNetworkClient extends TeslaNetworkCommunication {
	private TeslaNetworkPlayer player;

	public TeslaNetworkClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected boolean performCommunications() throws IOException {
		setMode(TeslaMode.REPLAY);
		player = new TeslaNetworkPlayer(communicationSocket);
		return false;
	}

	public void shutdown() {
		player.shutdown();
		close();
	}

	public boolean connect(IConnectionMonitor monitor) {
		this.monitor = monitor;
		if (this.monitor == null) {
			this.monitor = new DefaultConnectionMonitor();
		}
		internalRun();
		return isConnected();
	}

	public UIPlayer getPlayer() {
		return player;
	}
}
