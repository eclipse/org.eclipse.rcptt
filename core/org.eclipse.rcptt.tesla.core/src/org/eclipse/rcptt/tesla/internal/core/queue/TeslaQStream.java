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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.rcptt.tesla.core.protocol.TeslaStream;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

public class TeslaQStream extends TeslaStream {
	private static final int TIMEOUT = 100;
	private BlockingQueue<Object> out = new LinkedBlockingQueue<Object>(10);
	private BlockingQueue<Object> in = new LinkedBlockingQueue<Object>(10);
	private boolean active = true;

	public TeslaQStream(TeslaQStream reverse) {
		if (reverse != null) {
			this.out = reverse.in;
			this.in = reverse.out;
		}
	}

	public void terminate() {
		active = false;
	}

	public boolean hasCommand() {
		return !in.isEmpty();
	}

	@Override
	public Command readCommand() {
		try {
			Command value = null;
			while (value == null && active) {
				value = (Command) in.poll(TIMEOUT, TimeUnit.MILLISECONDS);
			}
			return value;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Response readResponse() {
		try {
			Response response = null;
			while (response == null && active) {
				response = (Response) in.poll(TIMEOUT, TimeUnit.MILLISECONDS);
			}
			return response;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void writeCommand(Command command) {
		try {
			out.put(command);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeResponse(Response command) {
		try {
			out.put(command);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
