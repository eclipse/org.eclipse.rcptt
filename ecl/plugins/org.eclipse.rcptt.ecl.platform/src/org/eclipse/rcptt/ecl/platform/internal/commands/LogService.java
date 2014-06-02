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
package org.eclipse.rcptt.ecl.platform.internal.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.platform.commands.Log;
import org.eclipse.rcptt.ecl.platform.internal.PlatformPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class LogService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof Log)) {
			return Status.CANCEL_STATUS;
		}
		Log log = (Log) command;
		String message = log.getMessage();
		String pluginId = log.getPlugin();
		int severity = getSeverity(log.getSeverity());

		PlatformPlugin.getDefault().getLog()
				.log(new Status(severity, pluginId, message, null));
		return Status.OK_STATUS;
	}

	public static final Map<String, Integer> severities = new HashMap<String, Integer>();
	static {
		severities.put("info", IStatus.INFO);
		severities.put("warning", IStatus.WARNING);
		severities.put("warn", IStatus.WARNING);
		severities.put("error", IStatus.ERROR);
		severities.put("err", IStatus.ERROR);
		severities.put("ok", IStatus.ERROR);
		severities.put("cancel", IStatus.ERROR);
	}

	private int getSeverity(String severityText) {
		if (severityText == null) {
			severityText = "";
		}
		Integer result = severities.get(severityText.toLowerCase());
		return result == null ? IStatus.INFO : result;
	}

}
