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
package org.eclipse.rcptt.ecl.internal.server.tcp;

import java.net.Socket;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.EclRuntime;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

@Deprecated
public class Session extends Thread {
	private final static boolean DEBUG_LOG = false;
	private Socket socket;
	private ISession session;

	Session(Socket socket) {
		super("ECL tcp session:" + socket.getPort());
		this.socket = socket;
		session = EclRuntime.createSession();
		start();
	}

	public void run() {
		if (DEBUG_LOG) {
			System.out.println("SERVER: New TCP Server Session:");
		}
		try {
			IPipe pipe = CoreUtils.createEMFPipe(socket.getInputStream(),
					socket.getOutputStream());
			while (!isInterrupted()) {
				Command command = (Command) pipe.take(Long.MAX_VALUE);
				if (command == null)
					break;
				if (DEBUG_LOG) {
					System.out.println("SERVER:   Got command: " + command);
				}
				setName("ECL tcp session command:"
						+ command.getClass().getSimpleName());
				IProcess process = session.execute(command);
				IStatus status = process.waitFor();
				if (DEBUG_LOG) {
					System.out.println("SERVER:   Done: " + status);
				}
				Object output = null;
				do {
					output = process.getOutput().take(0);
					if (output == null) {
						break;
					} else {
						pipe.write(output);
					}
				} while (true);
				pipe.write(status);
			}
		} catch (Exception e) {
			if (DEBUG_LOG) {
				System.out.println("SERVER: Closing TCP Server Session due: "
						+ e.getMessage());
			}
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
