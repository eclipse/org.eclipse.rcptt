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
package org.eclipse.rcptt.ecl.server.tcp;

import java.net.Socket;
import java.net.SocketException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.EclRuntime;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

final class SessionRequestHandler implements Runnable {
	private final Socket socket;
	private final ISession session;

	SessionRequestHandler(Socket socket, boolean useJobs) {
		// super("ECL tcp session:" + socket.getPort());
		this.socket = socket;
		try {
			this.socket.setTcpNoDelay(true);
		} catch (SocketException e) {
			CorePlugin.log(e);
		}
		this.session = EclRuntime.createSession(useJobs);
	}

	public void run() {
		try {
			IPipe pipe = CoreUtils.createEMFPipe(socket.getInputStream(),
					socket.getOutputStream());
			while (!Thread.currentThread().isInterrupted()
					&& !socket.isClosed()) {
				try {
					pipe.reinit();
					Object object = pipe.take(Long.MAX_VALUE);
					if (!(object instanceof Command))
						break;
					Command command = (Command) object;
					IStatus status;
					try {
						IPipe input = readInput(pipe);
						IProcess process = session.execute(command, input, null);
						status = writeOutput(pipe, process);
					} catch (CoreException e) {
						status = e.getStatus();
					}
					pipe.write(status);
					pipe.close(status);
				} catch (Exception e) {
					Throwable te = e;
					if (e instanceof CoreException) {
						if (e.getCause() instanceof SocketException) {
							te = e.getCause();
						}
					}
					if (te instanceof SocketException) {
						try {
							socket.close();
						} catch (Throwable e2) {

						}
						break;
					}
					CorePlugin.log(e);
				}
			}
		} catch (Exception e) {
			CorePlugin.log(e);
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				CorePlugin.log(e);
			}
			try {
				session.close();
			} catch (Exception e) {
				CorePlugin.log(e);
			}
		}
	}

	private IPipe readInput(IPipe pipe) throws CoreException {
		Object object;
		IPipe input = session.createPipe();
		while (true) {
			object = pipe.take(Long.MAX_VALUE);
			if (object instanceof IStatus) {
				input.close((IStatus) object);
				break;
			}
			input.write(object);
		}
		return input;
	}

	private IStatus writeOutput(IPipe pipe, IProcess process)
			throws CoreException {
		Object object;
		do {
			object = process.getOutput().take(Long.MAX_VALUE);
			if (object instanceof IStatus) {
				try {
					return process.waitFor();
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;
				}
			} else {
				pipe.write(object);
			}
		} while (true);
	}

	public void recover(Socket client) {
	}
}