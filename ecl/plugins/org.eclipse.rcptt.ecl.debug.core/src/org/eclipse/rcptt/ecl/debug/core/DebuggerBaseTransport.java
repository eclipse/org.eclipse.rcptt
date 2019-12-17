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
package org.eclipse.rcptt.ecl.debug.core;

import java.io.IOException;
import java.net.Socket;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.debug.runtime.Session;
import org.eclipse.rcptt.ecl.internal.debug.core.Plugin;

public class DebuggerBaseTransport implements DebuggerTransport {

	public static synchronized DebuggerTransport create(int port, String host) throws CoreException {
		return new DebuggerBaseTransport(host, port);
	}
	
	

	private DebuggerBaseTransport(String host, int port) throws CoreException {
		try {
			Socket socket = new Socket(host, port);
			session = new Session(socket) {

				@Override
				protected void handle(EObject event) {
					final DebuggerCallback c = callback;
					if (c != null) {
						callback.handleResponse(event);
					}
				}

				@Override
				protected void handle(Exception e) {
					Plugin.log(e);
				}
			};
		} catch (Exception e) {
			throw new CoreException(Plugin.status(
					"Couldn't connect to debugger", e));
		}
	}

	public synchronized void request(EObject event) throws CoreException {
		session.request(event);
	}

	public synchronized void setCallback(DebuggerCallback callback) {
		this.callback = callback;
	}

	private volatile DebuggerCallback callback;
	private final Session session;

	@Override
	public synchronized void close() throws IOException {
		if (session != null) {
			session.terminate();
		}
	}

}
