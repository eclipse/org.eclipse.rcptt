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
package org.eclipse.rcptt.tesla.internal.core.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public abstract class TeslaNetworkCommunication extends Thread {

	protected Socket communicationSocket;
	protected int port;
	protected String host;
	protected DataInputStream input;
	protected DataOutputStream output;
	protected IConnectionMonitor monitor;

	private boolean canceled;

	public TeslaNetworkCommunication(String host, int port) {
		this(host, port, new DefaultConnectionMonitor());
	}

	public TeslaNetworkCommunication(String host, int port,
			IConnectionMonitor monitor) {
		super("Tesla network communication to :" + host + ":"
				+ Integer.valueOf(port));
		this.host = host;
		this.port = port;
		this.monitor = monitor;
	}

	public void cancelConnection() {
		if (isConnected()) {
			canceled = true;
			close();
			interrupt();
		}
	}

	@Override
	public void run() {
		internalRun();
	}

	protected void internalRun() {
		try {
			exec();
		} catch (SocketException e) {
			if (e.getMessage() != null
					&& !e.getMessage().equals("Socket closed")) {
				TeslaCore.log(e);
			}
		} catch (IOException e) {
			TeslaCore.log(e);
		}
	}

	public void exec() throws IOException {
		boolean needClose = true;
		try {
			if (doConnect(monitor)) {
				needClose = performCommunications();
			}
		} catch (Throwable t) {
			if (t instanceof SocketException) {
				if (!communicationSocket.isClosed()) {
					TeslaCore.log(t);
				}
			} else {
				TeslaCore.log(t);
			}
		} finally {
			if (needClose) {
				close();
			}
		}
	}

	protected boolean doConnect(IConnectionMonitor monitor) throws IOException {
		long timeStart = System.currentTimeMillis();
		while (communicationSocket == null
				|| !communicationSocket.isConnected()) {
			if (monitor.getTimeout() != 0) {
				if (System.currentTimeMillis() > timeStart
						+ monitor.getTimeout()) {
					break;
				}
			}
			if (canceled) {
				return false;
			}
			tryToConnet();
			if (monitor.getTimeout() == 0) {
				break;
			}
			if (communicationSocket == null
					|| !communicationSocket.isConnected()) {
				try {
					Thread.sleep(monitor.getPause());
				} catch (InterruptedException e) {
					// ignore exception
				}
			}
		}
		if (communicationSocket == null || !communicationSocket.isConnected()) {
			monitor.timeout();
			return false;
		}
		InputStream stream = communicationSocket.getInputStream();
		input = new DataInputStream(stream);
		output = new DataOutputStream(communicationSocket.getOutputStream());
		return true;
	}

	protected void close() {
		try {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
			if (communicationSocket != null) {
				communicationSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected abstract boolean performCommunications() throws IOException;

	private void tryToConnet() {
		monitor.tryToConnect();
		try {
			communicationSocket = new Socket(host, port);
			communicationSocket.setKeepAlive(true);
		} catch (Exception e) {
			monitor.connectFailed(e);
		} finally {
			if (communicationSocket != null
					&& communicationSocket.isConnected()) {
				monitor.connected();
			}
		}
	}

	public boolean isConnected() {
		if (!this.isAlive()) {
			return false;
		}
		if (communicationSocket != null && communicationSocket.isConnected()) {
			return !communicationSocket.isClosed();
		}
		return false;
	}

	protected void setMode(TeslaMode mode, String... classes) throws IOException {
		SetMode newMode = RawFactory.eINSTANCE.createSetMode();
		newMode.getWidgetClasses().addAll(Arrays.asList(classes));
		newMode.setMode(mode);
		try {
			DataSerializer.writeEObject(output, newMode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeEObject(EObject object) throws IOException {
		DataSerializer.writeEObject(output, object);
	}

	public EObject readEObject() throws IOException {
		return DataSerializer.readEObject(input);
	}

}