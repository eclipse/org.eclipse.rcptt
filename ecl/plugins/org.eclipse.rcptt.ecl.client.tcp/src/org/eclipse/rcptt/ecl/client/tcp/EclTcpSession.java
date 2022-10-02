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
package org.eclipse.rcptt.ecl.client.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.internal.core.IMarkeredPipe;
import org.eclipse.rcptt.ecl.internal.core.Pipe;
import org.eclipse.rcptt.ecl.internal.core.Process;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class EclTcpSession implements ISession {
	private static final ExecutionNode CLOSE_NODE = new ExecutionNode();
	
	private Map<String, Object> properties = new HashMap<String, Object>();

	private final AtomicBoolean closed = new AtomicBoolean(false);

	@SuppressWarnings("unused")
	private InetAddress address;
	@SuppressWarnings("unused")
	private int port;

	private Socket socket;

	private String sessionID;

	private static class ExecutionNode {
		Command command;
		IPipe input;
		IPipe output;
		Process process;
	}

	private BlockingQueue<ExecutionNode> commands = new LinkedBlockingQueue<ExecutionNode>(
			10);

	private Thread processingThread;

	public EclTcpSession(InetAddress address, int port) throws IOException {
		NetworkUtil.initTimeouts();
		this.address = address;
		this.port = port;

		try {
			initSocket(address, port, true);
		} catch (IOException e) {
			initSocket(address, port, false);
			EclTcpClientPlugin
					.logInfo("Could not open a session with NO_DELAY and SO_REUSEADDR, succeeded with default socket");
		}
		processingThread = new Thread(new Runnable() {
			public void run() {
				try {
					while (!closed.get()) {
						ExecutionNode node = null;
						IMarkeredPipe pipe = null;
						try {
							node = commands.take();
							if (CLOSE_NODE.equals(node)) {
								return;
							}
							pipe = CoreUtils.createEMFPipe(
									socket.getInputStream(),
									socket.getOutputStream());

							pipe.write(node.command);
							readInput(node.input, pipe);
							pipe.writeCloseMarker();
							IStatus result = writeOutput(node.output, pipe);

							node.process.setStatus(result);
						} catch (Throwable t) {
							try {
								if (node != null) {
									IStatus status = (t instanceof CoreException)
											? ((CoreException) t).getStatus()
											: CorePlugin.err(t);
									node.process.setStatus(new EclTcpSocketStatus(
											status));
								}
							} catch (CoreException e1) {
								CorePlugin.log(e1);
							}
						} finally {
							if (pipe != null) {
								pipe.closeNoWait();
							}
						}
					}
				} finally {
					try {
						closeSocket();
					} catch (Throwable e) {
						CorePlugin.log(e);
					}
				}

			}
		}, "ECL TCP session execute: " + sessionID);
		processingThread.start();
	}

	private void initSocket(InetAddress address, int port, boolean nonDefaultSocket) throws SocketException,
			IOException {
		socket = new Socket();
		if (nonDefaultSocket) {
			socket.setReuseAddress(true);
			try {
				this.socket.setTcpNoDelay(true);
			} catch (SocketException e) {
				EclTcpClientPlugin.log(new Status(IStatus.ERROR, EclTcpClientPlugin.PLUGIN_ID,
						"Error setting TCP_NODELAY on client socket"));
			}
		}
		socket.connect(new InetSocketAddress(address, port));

		initSessionId(socket);
	}

	private void initSessionId(Socket socket) throws IOException {
		OutputStream outputStream = socket.getOutputStream();
		InputStream inputStream = socket.getInputStream();
		DataOutputStream dout = new DataOutputStream(outputStream);
		DataInputStream din = new DataInputStream(inputStream);
		dout.writeUTF("newsession");
		dout.flush();
		sessionID = din.readUTF();
	}

	public IPipe createPipe() {
		return new Pipe();
	}

	public IProcess execute(final Command command) throws CoreException {
		return execute(command, null, null);
	}

	public IProcess execute(final Command command, IPipe in, IPipe out)
			throws CoreException {
		ExecutionNode node = new ExecutionNode();
		node.command = (Command) EcoreUtil.copy(command);
		node.input = in == null ? createPipe().close(Status.OK_STATUS) : in;
		node.output = out == null ? createPipe() : out;
		node.process = new Process(this, node.input, node.output);

		try {
			commands.put(node);
		} catch (InterruptedException e) {
			throw new CoreException(new Status(Status.ERROR,
					EclTcpClientPlugin.PLUGIN_ID,
					"Failed to execute ecl command: "
							+ command.getClass().getName(), e));
		}

		return node.process;
	}

	private void readInput(final IPipe input, IPipe pipe) throws CoreException {
		while (true) {
			Object object = input.take(Long.MAX_VALUE);
			if (object instanceof IStatus) {
				pipe.write(object);
				break;
			}
			pipe.write(object);
		}
	}

	private IStatus writeOutput(final IPipe output, IPipe pipe)
			throws CoreException {
		while (true) {
			Object object = pipe.take(Long.MAX_VALUE);
			if (object instanceof IStatus) {
				return (IStatus) object;
			} else {
				output.write(object);
			}
		}
	}

	public void close() throws CoreException {
		closed.compareAndSet(false, true);
		try {
			if (!Thread.currentThread().isInterrupted()) {
				commands.put(CLOSE_NODE);
			} else {
				processingThread.interrupt();
			}
			closeSocket();
		} catch (Throwable e) {
			CorePlugin.log(e);
		}
	}

	public boolean isClosed() {
		return closed.get();
	}

	private synchronized void closeSocket() throws IOException {
		if (socket != null) {
			socket.close();
			socket = null;
		}
	}
	public synchronized void putProperty(String key, Object value) {
		if (value == null) {
			properties.remove(key);
		} else {
			properties.put(key, value);
		}
	}
	public synchronized Object getProperty(String key) {
		return properties.get(key);
	}
}
