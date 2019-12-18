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
package org.eclipse.rcptt.ecl.internal.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.runtime.IPipe;

public class Pipe implements IPipe {
	private static Object CLOSE_OBJECT = new Object();
	private static final int DELTA = 100;
	private final LinkedBlockingQueue<Object> queue;
	private boolean closed = false;
	private IStatus status = null;

	public Pipe() {
		queue = new LinkedBlockingQueue<Object>();
	}

	public boolean isClosed() {
		return closed;
	}

	public Object take(long timeout) throws CoreException {
		if (queue == null) {
			// Couldn't happen
			throw new CoreException(CorePlugin.err("Pipe was not initialized"
					+ " for some reason"));
		}
		try {
			if (timeout > DELTA) {
				long steps = timeout / DELTA;
				long end = timeout % DELTA;
				for (int i = 0; i < steps; i++) {
					if (closed && queue.isEmpty())
						return this.status;
					Object o = queue.poll(DELTA, TimeUnit.MILLISECONDS);
					if (CLOSE_OBJECT.equals(o)) {
						return this.status;
					}
					if (o != null)
						return o;
				}
				if (end > 0)
					return queue.poll(end, TimeUnit.MILLISECONDS);
				return CorePlugin.err("Timeout");
			}
			Object result = queue.poll(timeout, TimeUnit.MILLISECONDS);
			if (CLOSE_OBJECT.equals(result)) {
				return this.status;
			}
			return result;
		} catch (InterruptedException e) {
			throw new CoreException(CorePlugin.err(e.getMessage(), e));
		}
	}

	public IPipe write(Object object) throws CoreException {
		if (queue == null) {
			IStatus s = new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
					"Writing to closed pipe");
			throw new CoreException(s);
		}
		try {
			queue.put(object);
		} catch (InterruptedException e) {
			throw new CoreException(CorePlugin.err(e.getMessage(), e));
		}
		return this;
	}

	public IPipe close(IStatus status) throws CoreException {
		if ((this.status = status) == null) {
			throw new CoreException(
					CorePlugin.err("Pipe was closed without status specified"));
		}
		closed = true;
		try {
			queue.put(CLOSE_OBJECT);
		} catch (InterruptedException e) {
			throw new CoreException(CorePlugin.err(e.getMessage(), e));
		}
		return this;
	}

	public void reinit() {
		status = null;
		closed = false;
	}
}
