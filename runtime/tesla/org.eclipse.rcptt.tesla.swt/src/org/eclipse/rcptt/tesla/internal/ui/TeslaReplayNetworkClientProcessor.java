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
package org.eclipse.rcptt.tesla.internal.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.internal.core.network.server.ITeslaNetworkClientProcessor;
import org.eclipse.rcptt.tesla.internal.core.network.server.NetworkTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.network.server.TeslaNetworkClientConnection;
import org.eclipse.rcptt.tesla.swt.events.ITeslaEventListener;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager.HasEventKind;

public class TeslaReplayNetworkClientProcessor implements
		ITeslaNetworkClientProcessor {

	private NetworkTeslaClient client;
	// private DataOutputStream dout;
	// private DataInputStream din;
	// private TeslaNetworkClientConnection connection;
	private ITeslaEventListener listener;

	public TeslaReplayNetworkClientProcessor() {
		listener = new ITeslaEventListener() {
			public boolean doProcessing(final Context currentContext) {
				if (client != null) {
					Q7WaitInfoRoot  info = ReportHelper.getWaitInfo(ReportManager.getCurrentReportNode());
					client.processNext(currentContext, info);
				}
				return false;
			}

			public void hasEvent(HasEventKind kind, String name) {
				if (client != null) {
					client.hasEvent(kind.name(), name, null);
				}
			}
		};
	}

	public void activateMode(SetMode command, TeslaMode oldMode) {
		AspectManager.printInfo();
		if (command.getMode().equals(TeslaMode.REPLAY)) {
			// Use async exec to be sure display are wakeup
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					TeslaEventManager.getManager().addEventListener(listener);
					// Wait up Display
					PlatformUI.getWorkbench().getDisplay()
							.asyncExec(new Runnable() {
								public void run() {
								}
							});
				}
			});
		} else {
			TeslaEventManager.getManager().removeEventListener(listener);
		}
	}

	public void initialize(
			TeslaNetworkClientConnection teslaNetworkClientConnection,
			DataInputStream din, DataOutputStream dout,
			NetworkTeslaClient teslaClient) {
		this.client = teslaClient;
		// this.din = din;
		// this.dout = dout;
		// this.connection = teslaNetworkClientConnection;
	}

	public void terminate(boolean last) {
		TeslaEventManager.getManager().removeEventListener(listener);
		if (last) {
			client.clean();
		}
		client.shutdown();
	}

	public void setFeature(String name, String value) {
	}

	public void resetAssertSelection() {
	}
}
