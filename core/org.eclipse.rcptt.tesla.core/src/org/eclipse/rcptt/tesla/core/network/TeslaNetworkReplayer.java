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
package org.eclipse.rcptt.tesla.core.network;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.tesla.core.TeslaReplayer;
import org.eclipse.rcptt.tesla.core.TeslaReplayer.IReplayPreExecute;
import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.WaitForRestart;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.network.DefaultConnectionMonitor;
import org.eclipse.rcptt.tesla.internal.core.network.IConnectionMonitor;
import org.eclipse.rcptt.tesla.internal.core.network.IProgressInformer;
import org.eclipse.rcptt.tesla.internal.core.network.TeslaNetworkCommunication;

public class TeslaNetworkReplayer extends TeslaNetworkCommunication {
	private TeslaScenarioContainer container;
	private IProgressInformer informer;
	private IProgressMonitor progressMonitor;

	public TeslaNetworkReplayer(String host, int port,
			IProgressMonitor progressMonitor, TeslaScenarioContainer container,
			IProgressInformer informer, IConnectionMonitor connectionMonitor) {
		super(host, port, connectionMonitor);
		this.container = container;
		this.informer = informer;
		this.progressMonitor = progressMonitor;
	}

	public TeslaNetworkReplayer(String host, int port,
			IProgressMonitor progressMonitor, TeslaScenarioContainer container,
			IProgressInformer informer) {
		super(host, port);
		this.container = container;
		this.informer = informer;
		this.progressMonitor = progressMonitor;
	}

	@Override
	protected boolean performCommunications() throws IOException {
		setMode(TeslaMode.REPLAY);
		final TeslaNetworkPlayer player = new TeslaNetworkPlayer(
				communicationSocket);
		TeslaReplayer replayer = new TeslaReplayer();
		replayer.replayCommands(player, container, informer, progressMonitor,
				new IReplayPreExecute() {
					public boolean preExecute(Command cmd) {
						if (cmd instanceof WaitForRestart) {
							//long startTime = System.currentTimeMillis();
							while (isConnected()
									&& !progressMonitor.isCanceled()) {
								try {
									Thread.sleep(50);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								// try to send nop command, if failed then no
								// connection is available anymore
								try {
									player.nop();
								} catch (Throwable e) {
									// ignore
								}
								// TODO: Add here and check following code
//								if ((System.currentTimeMillis() - startTime) > 30 * 1000) {
//									break;// Timeout in tesla during wait for
//											// reconnect. No reconnect is happen
//								}
							}
							if (communicationSocket != null) {
								try {
									communicationSocket.close();
								} catch (Throwable e) {
									// Ignore
								}
							}
							communicationSocket = null;
							// Reconnect
							try {
								doConnect(new DefaultConnectionMonitor());
								if (communicationSocket != null) {
									player.updateSocket(communicationSocket);
									setMode(TeslaMode.REPLAY);
								} else {
									throw new Exception(
											"Could not establish connection");
								}
							} catch (Throwable e) {
								informer.handleError(
										container,
										cmd,
										0,
										"Failed to reconnect to AUT after AUT restart",
										null);
								TeslaCore.log(e);
							}
							return true;
						}
						return false;
					}
				});
		try {
			player.shutdown();
		} catch (Throwable e) {
			// ignore
		}
		return true;
	}
}