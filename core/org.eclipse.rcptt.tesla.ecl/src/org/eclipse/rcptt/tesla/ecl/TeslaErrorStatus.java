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
package org.eclipse.rcptt.tesla.ecl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;

public class TeslaErrorStatus extends Status {
	private final AdvancedInformation info;

	public TeslaErrorStatus(String message, AdvancedInformation info) {
		this(IStatus.ERROR, "org.eclipse.rcptt.tesla.ecl", message, info);
	}

	public TeslaErrorStatus(int severity, String pluginId, String message,
			AdvancedInformation info) {
		super(severity, pluginId, createMessage(message));
		this.info = info;
	}

	private static String createMessage(String message) {
		if (message == null || message.length() == 0) {
			return "Unknown reason";
		} else {
			return message;
		}
	}

	public AdvancedInformation getInfo() {
		return info;
	}
}
