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
import java.net.Socket;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.tesla.core.protocol.TeslaStream;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

public class TeslaNetworkStream extends TeslaStream {
	private DataInputStream din;
	private DataOutputStream dout;
	private Socket socket;

	public TeslaNetworkStream(Socket socket) throws IOException {
		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		this.socket = socket;
	}

	@Override
	public Command readCommand() {
		try {
			EObject object = DataSerializer.readEObject(din);
			if (object instanceof Command) {
				return (Command) object;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Response readResponse() throws IOException {
		EObject object = DataSerializer.readEObject(din);
		if (object instanceof Response) {
			return (Response) object;
		}
		return null;
	}

	@Override
	public void terminate() {
		try {
			din.close();
			dout.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void writeCommand(Command command) {
		try {
			DataSerializer.writeEObject(dout, command);
		} catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@Override
	public void writeResponse(Response command) {
		try {
			DataSerializer.writeEObject(dout, command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean hasCommand() {
		try {
			return din.available() > 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Socket getSocket() {
		return this.socket;
	}
}
