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
package org.eclipse.rcptt.tesla.internal.core.network.server;

import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.rcptt.tesla.core.protocol.TeslaStream;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.network.DataSerializer;

public class NetworkTeslaClient extends AbstractTeslaClient {
	private final class LocalEmptyStream extends TeslaStream {
		@Override
		public void terminate() {
		}

		@Override
		public Response readResponse() {
			return null;
		}

		@Override
		public Command readCommand() {
			return null;
		}

		@Override
		public void writeResponse(Response command) {
			try {
				DataSerializer.writeEObject(dataOutput, command);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void writeCommand(Command command) {
		}
	}

	private DataOutputStream dataOutput;
	private LocalEmptyStream stream;

	public NetworkTeslaClient(DataOutputStream dout, String id) {
		super(id);
		this.dataOutput = dout;
	}

	@Override
	public boolean hasCommand() {
		return localQueue.isEmpty();
	}

	@Override
	protected TeslaStream stream() {
		if (stream == null) {
			stream = new LocalEmptyStream();
		}
		return stream;
	}

	public void waitForExecution(Command cmd) {
	}

	@Override
	public void logException(Throwable t) {
		TeslaCore.log(t);
	}
}
