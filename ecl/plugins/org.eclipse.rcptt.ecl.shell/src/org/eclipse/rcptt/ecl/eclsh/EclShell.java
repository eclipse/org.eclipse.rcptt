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
package org.eclipse.rcptt.ecl.eclsh;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.EclRuntime;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class EclShell implements IEclShell {
	ISession session;
	private OutputStream outputStream;
	private PrintStream printStream;

	public EclShell() {
		super();
	}

	public void execute(String command) {
		if (session == null) {
			writeCloseMessage(this.outputStream);
			return;
		}
		try {
			Command cmd = EclCoreParser.newCommand(command); // CoreFactory.eINSTANCE.createScript();
			if (cmd == null)
				return;
			IProcess process = session.execute(cmd);
			IStatus status = process.waitFor();
			if (status instanceof ScriptErrorStatus) {
				IStatus cause = ((ScriptErrorStatus) status).getCause();
				if (cause != null) {
					status = cause;
				}
			}
			if (status.getSeverity() != IStatus.OK) {
				outputStream.write((status.getMessage()).getBytes());
				outputStream.write("\r\n".getBytes());

			}

			// dump pipe

			for (Object o : CoreUtils.readPipeContent(process.getOutput())) {
				printStream.println(o);
			}
			printStream.flush();

		} catch (CoreException e) {
			e.printStackTrace(printStream);
			IStatus status = e.getStatus();
			if (status != null) {
				printStatus(status);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printStatus(IStatus status) {
		if (status == null) {
			return;
		}
		if (status.getMessage() != null) {
			printStream.println(status.getMessage());
		}
		Throwable t = status.getException();
		if (t != null) {
			t.printStackTrace(printStream);
		}
		if (status instanceof MultiStatus) {
			IStatus[] childs = status.getChildren();
			for (IStatus st : childs) {
				printStatus(st);
			}
		}
	}

	private void writeCloseMessage(OutputStream stream) {
		try {
			stream.write("Shell is closed...".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void connect(OutputStream stream) {
		session = EclRuntime.createSession();
		this.outputStream = stream;
		this.printStream = new PrintStream(outputStream);
	}

	public void disconnect() {
		session = null;
	}
}
