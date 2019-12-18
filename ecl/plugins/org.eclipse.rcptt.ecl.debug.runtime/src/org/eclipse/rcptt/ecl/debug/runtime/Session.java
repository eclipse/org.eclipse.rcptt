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
package org.eclipse.rcptt.ecl.debug.runtime;

import java.io.IOException;
import java.net.Socket;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.internal.core.IMarkeredPipe;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;

public abstract class Session extends Job {

	public Session(Socket socket) throws CoreException {
		super("Event Dispatch");
		setSystem(true);

		this.socket = socket;

		try {
			this.pipe = CoreUtils.createEMFPipe(
					socket.getInputStream(),
					socket.getOutputStream());
		} catch (IOException e) {
			throw new CoreException(CorePlugin.err(e.getMessage(), e));
		}
		schedule();
	}

	public void request(EObject event) throws CoreException {
		pipe.write(event);
	}

	public void terminate() {
		terminated = true;
		try {
			socket.close();
		} catch (IOException e) {
			// safe close
		}
	}

	protected abstract void handle(EObject event);

	protected abstract void handle(Exception e);

	private final Socket socket;
	private IMarkeredPipe pipe;
	private volatile boolean terminated = false;

	protected IStatus run(IProgressMonitor monitor) {
		try {
			while (!pipe.isClosed()) {
				Object take = pipe.take(60000);
				if (take instanceof IStatus) {
					return Status.OK_STATUS;
				}
				if (pipe.isClosed()) {
					return Status.OK_STATUS;
				}
				if (take instanceof EObject) {
					handle((EObject) take);
				}
			}
		} catch (Exception e) {
			// exception on termination is OK
			if (!terminated) {
				handle(e);
			}
		}
		return Status.OK_STATUS;
	}

}
