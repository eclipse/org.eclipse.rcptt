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
package org.eclipse.rcptt.core.model;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class Q7Status extends Status implements IStatus {
	public static Q7Status OK = new Q7Status(IStatus.OK, 0);

	public static enum Q7StatusCode {
		OK, NotPressent, NotOpen
	}

	private Q7StatusCode statusCode = Q7StatusCode.OK;

	public Q7Status() {
		// no code for an multi-status
		super(ERROR, RcpttPlugin.PLUGIN_ID, 0, "Q7Status", null); //$NON-NLS-1$
	}

	public Q7Status(int code) {
		super(ERROR, RcpttPlugin.PLUGIN_ID, code, "Q7Status", null); //$NON-NLS-1$
	}

	public Q7Status(int code, Throwable throwable) {
		super(ERROR, RcpttPlugin.PLUGIN_ID, code, throwable.getMessage(), throwable); //$NON-NLS-1$
	}

	public Q7Status(int severity, int code) {
		super(severity, RcpttPlugin.PLUGIN_ID, code, "Q7Status", null); //$NON-NLS-1$
	}

	public Q7Status(int code, String string) {
		super(ERROR, RcpttPlugin.PLUGIN_ID, code, string, null); //$NON-NLS-1$
	}

	public void setStatusCode(Q7StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public Q7StatusCode getStatusCode() {
		return statusCode;
	}
}
