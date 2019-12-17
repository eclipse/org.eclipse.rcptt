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
package org.eclipse.rcptt.tesla.internal.core.network;

public class DefaultConnectionMonitor implements IConnectionMonitor {
	private Exception failedException;
	private boolean connected = false;
	private long timeout = 5 * 60 * 1000;

	public void connectFailed(Exception exception) {
		failedException = exception;
	}

	public Exception getFailedException() {
		return failedException;
	}

	public boolean isConnected() {
		return connected;
	}

	public void connected() {
		this.connected = true;
	}

	public void timeout() {
		connected = false;
	}

	public void tryToConnect() {
		connected = false;
	}

	public long getPause() {
		return 500;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
}
