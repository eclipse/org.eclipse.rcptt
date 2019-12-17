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
package org.eclipse.rcptt.ecl.popup;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.internal.core.Session;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class EclPopupSession {
	private Session session;

	public EclPopupSession() {
		this.session = new Session();
	}

	public EclResult exec(String command) {
		IStatus status = null;
		List<Object> pipe = new ArrayList<Object>();

		try {
			Command cmd = EclCoreParser.newCommand(command);
			IProcess process = session.execute(cmd);
			status = process.waitFor();
			pipe = CoreUtils.readPipeContent(process.getOutput());
		} catch (CoreException e) {
			status = e.getStatus();
		} catch (Exception e) {
			status = new Status(IStatus.ERROR, EclPopupPlugin.PLUGIN_ID,
					"Error executing command", e);
		}
		EclResult result = new EclResult(command, status, pipe.toArray(new Object[pipe
				.size()]));
		history.add(result);
		return result;
	}
	
	private List<EclResult> history = new ArrayList<EclResult>();
	public EclResult[] getHistory() {
		return history.toArray(new EclResult[history.size()]);
	}

	public static class EclResult {
		public EclResult(String command, IStatus status, Object[] pipe) {
			this.command = command;
			this.status = status;
			this.pipe = pipe;
		}

		public final String command;
		public final IStatus status;
		public final Object[] pipe;

		public String getCombinedOut() {
			StringBuilder sb = new StringBuilder();
			for (Object obj : pipe) {
				sb.append(obj.toString()).append("\n");
			}
			return sb.toString();
		}
	}
}
