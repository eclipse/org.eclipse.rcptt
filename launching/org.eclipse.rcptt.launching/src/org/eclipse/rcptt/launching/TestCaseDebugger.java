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
package org.eclipse.rcptt.launching;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.rcptt.ecl.debug.commands.CommandsFactory;
import org.eclipse.rcptt.ecl.debug.commands.ServerInfo;
import org.eclipse.rcptt.ecl.debug.commands.StartServer;
import org.eclipse.rcptt.ecl.debug.commands.StopServer;
import org.eclipse.rcptt.ecl.debug.core.Debugger;
import org.eclipse.rcptt.ecl.debug.core.DebuggerTransport;
import org.eclipse.rcptt.ecl.debug.core.EclDebug;
import org.eclipse.rcptt.ecl.debug.core.NullDebuggerTransport;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.launching.Q7Process;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;

public class TestCaseDebugger {

	public TestCaseDebugger(AutLaunch aut, Q7Process process, BiFunction<String, Integer, DebuggerTransport> connect)
			throws CoreException {
		this.aut = Objects.requireNonNull(aut);
		this.transportFactory = Objects.requireNonNull(connect);
		sessionId = UUID.randomUUID().toString();
		debugger = EclDebug.createDebugger(process);
		connect();
	}

	public IDebugTarget getDebugTarget() {
		return debugger;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void beforeRestart() {
		debugger.setTransport(new NullDebuggerTransport());
	}

	public void afterRestart() throws CoreException {
		try {
			connect();
		} catch (CoreException e) {
			throw new CoreException(Q7LaunchingPlugin.createStatus(
					"Couldn't connect to debugger after AUT restart", e));
		}
	}

	private synchronized void connect() throws CoreException {
		try {
			StartServer start = CommandsFactory.eINSTANCE.createStartServer();
			start.setId(sessionId);
			ServerInfo info = (ServerInfo) aut.execute(start);
			int port = info.getPort();

			String host = (aut instanceof BaseAutLaunch) ? ((BaseAutLaunch) aut)
					.getHost() : "localhost";
					
			transport = transportFactory.apply(host, port);
			debugger.setTransport(transport);

		} catch (InterruptedException e) {
			throw new CoreException(Status.CANCEL_STATUS);
		}
	}

	public void terminate() {
		StopServer stop = CommandsFactory.eINSTANCE.createStopServer();
		stop.setId(sessionId);
		try {
			aut.cancelTestExecution();
			aut.execute(stop);
		} catch (Exception e) {
			RcpttPlugin.log(e);
		}
		if (transport != null) {
			try {
				transport.close();
			} catch (IOException e) {
				RcpttPlugin.log(e);
			}
		}
	}

	private final String sessionId;
	private final AutLaunch aut;
	private final Debugger debugger;
	private DebuggerTransport transport;
	private final BiFunction<String, Integer, DebuggerTransport> transportFactory;

}
