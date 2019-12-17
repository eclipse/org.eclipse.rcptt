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
package org.eclipse.rcptt.ecl.eclsh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

public abstract class AbstractEclShellConnection {

	private EclSyntaxHelper helper = new EclSyntaxHelper();
	protected IEclShell shell = new EclShell();
	protected boolean isConnecting;
	protected StringBuffer buffer = new StringBuffer();
	protected OutputStream outputStream;
	private Thread readerThread;
	private boolean active = true;

	public void processSymbol(char c) {
		buffer.append(c);
	}

	public String getScript() {
		return buffer.toString();
	}

	public boolean removeSymbol(int count) {
		if (buffer.length() > 0) {
			if (buffer.length() > count) {
				buffer.setLength(buffer.length() - count);
			} else {
				buffer.setLength(0);
			}
			return true;
		} else {
			return false;
		}
	}

	public void connect(OutputStream outputStream) {
		this.outputStream = outputStream;
		isConnecting = true;
		try {
			shell.connect(outputStream);
			printBanner();
			outputNewLine();
			printPrompt();
			readerThread = new Thread(new Runnable() {
				public void run() {
					try {
						readDataForever(getInputStream());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			});
			readerThread.start();
		} finally {
			isConnecting = false;
		}
	}

	protected void printBanner() {
		try {
			outputStream
					.write((Messages
							.getString("AbstractEclShellConnection.welcomeBanner")).getBytes()); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract InputStream getInputStream();

	public void printPrompt() {
		try {
			outputStream.write(getPrompt().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getPrompt() {
		return Messages.getString("AbstractEclShellConnection.prompt"); //$NON-NLS-1$
	}

	protected void readDataForever(InputStream in) throws IOException {
		// read the data
		byte bytes[] = new byte[32 * 1024];
		int n;
		// read until the thread gets interrupted....
		try {
			while (active && (n = in.read(bytes)) != -1) {
				// Process data
				byte prev = 0;
				for (int i = 0; i < n; i++) {
					byte c = bytes[i];
					switch (c) {
					case -1:
						i += 2;
						continue;
					case 13:
					case 10:
						if (prev != 10 && prev != 13) {
							processNewLine();
						}
						break;
					case 127:
					case 0x8:
						processBackspace();
						break;
					default:
						if (c != 0) {
							processSymbol((char) c);
						}
					}
					prev = c;
				}
			}
		} catch (SocketException e) {
			if (active) {// Only if we active.
				e.printStackTrace();
			}
		}
	}

	protected void processBackspace() {
		if (removeSymbol(1)) {
			try {
				outputStream.write("\u001b[D\u001b[K".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void processNewLine() throws IOException {
		if (Messages
				.getString("AbstractEclShellConnection.quitCommand").equals(buffer.toString())) { //$NON-NLS-1$
			disconnect();
			return;
		}
		switch (helper.checkCommand(buffer.toString())) {
		case EclSyntaxHelper.CMD_EMPTY:
			if (buffer.length() > 0) {
				buffer.setLength(0);
				printPrompt();
			}
			break;
		case EclSyntaxHelper.CMD_VALID:
			// outputNewLine();
			// outputStream.write(("Execute command:" + buffer.toString())
			// .getBytes());
			shell.execute(buffer.toString());
			buffer.setLength(0);
			printPrompt();
			break;
		case EclSyntaxHelper.CMD_REQUIRE_CURLY_STRING_END:
		case EclSyntaxHelper.CMD_REQUIRE_SUBSTITUION_END:
			processSymbol('\n');
			break;
		default:
			// processSymbol('\n');
			outputNewLine();
			outputStream
					.write((Messages
							.getString("AbstractEclShellConnection.Incorrect_Sytnax_begin") + buffer.toString() + Messages.getString("AbstractEclShellConnection.Incorrect_Sytnax_end")) //$NON-NLS-1$ //$NON-NLS-2$
							.getBytes());
			buffer.setLength(0);
			printPrompt();
		}
	}

	protected void outputNewLine() {
		try {
			outputStream.write("\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		shell.disconnect();
		active = false;
	}
}
