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
package org.eclipse.rcptt.internal.launching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;

import org.eclipse.rcptt.core.workspace.RcpttCore;

public class EclStackTrace {
	private EclStackTrace(IStatus rootCause, ScriptErrorStatus[] trace) {
		this.rootCause = rootCause;
		this.frames = trace;
	}

	public final IStatus rootCause;
	public final ScriptErrorStatus[] frames;

	public static EclStackTrace fromExecStatus(ExecutionStatus status) {
		while (status.getCause() instanceof ExecutionStatus) {
			status = (ExecutionStatus) status.getCause();
		}
		List<ScriptErrorStatus> trace = new ArrayList<ScriptErrorStatus>();
		IStatus cause = status.getCause();
		while (cause instanceof ScriptErrorStatus) {
			trace.add((ScriptErrorStatus) cause);
			cause = ((ScriptErrorStatus) cause).getCause();
		}
		Collections.reverse(trace);

		return new EclStackTrace(cause, trace.toArray(new ScriptErrorStatus[trace.size()]));
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append(getDisplayMessage()).append("\n");
		for (ScriptErrorStatus frame : frames) {
			sb.append(String.format("\tat %s (%s)", frame.getMessage(), getLocation(frame))).append("\n");
		}
		return sb.toString();
	}

	public String getDisplayMessage() {
		return rootCause == null ? "Execution failed" : rootCause.getMessage();
	}

	public static String getLocation(ScriptErrorStatus status) {
		String id = status.getResource();
		String path = RcpttCore.getResourcePath(id);
		return path == null ? String.format("line %d", status.getLine()) : String.format("%s:%d", path,
				status.getLine());
	}
}
