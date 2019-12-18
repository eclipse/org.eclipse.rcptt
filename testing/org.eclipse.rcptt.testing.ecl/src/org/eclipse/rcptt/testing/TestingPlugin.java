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
package org.eclipse.rcptt.testing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import org.eclipse.rcptt.internal.launching.ExecutionStatus;

public class TestingPlugin extends Plugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.testing.ecl";
	private static TestingPlugin plugin = null;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static TestingPlugin getDefault() {
		return plugin;
	}

	public static IStatus createErrStatus(String message) {
		return createErrStatus(message, null);
	}

	public static void logErr(String message, Throwable t) {
		getDefault().getLog().log(createErrStatus(message, t));
	}

	public static IStatus createErrStatus(String message, Throwable t) {
		return new Status(IStatus.ERROR, "org.eclipse.rcptt.tests.ecl", message, t);
	}

	public static String encodeExecStatus(ExecutionStatus status) {
		StringBuilder buffer = new StringBuilder();
		String message = status.getMessage();
		if (message == null || message.length() == 0) {
			message = "Execution failed";
		}
		buffer.append(message);
		if (status.hasLocation()) {
			buffer.append(" at ");
			buffer.append(status.getLine());
			buffer.append(":");
			buffer.append(status.getColumn());
		}
		IStatus cause = status.getCause();
		if (cause != null) {
			String msg = cause.getMessage();
			if (msg != null && msg.length() > 0) {
				buffer.append("\n");
				buffer.append("Caused by:");
				msg = msg.replace("\n", "\n\t");
				buffer.append("\n").append("\t").append(msg);
			}
		}
		buffer.append("\n");
		Throwable t = status.getException();
		if (t != null) {
			StackTraceElement[] trace = t.getStackTrace();
			for (int i = 0; i < trace.length; i++) {
				buffer.append("\tat ");
				buffer.append(trace[i]);
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}

	private Map<String, List<Object>> globals = new HashMap<String, List<Object>>();

	public Map<String, List<Object>> getGlobals() {
		return globals;
	}
}
