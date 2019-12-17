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
package org.eclipse.rcptt.ecl.internal.debug.core;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

public class Plugin {

	public static final String ID = "org.eclipse.rcptt.ecl.debug.core";

	public static final String MARKER = ID + ".breakpoint.marker";

	public static IStatus status(Throwable t) {
		return status(t.getMessage(), t);
	}

	public static IStatus status(String message, Throwable t) {
		return new Status(IStatus.ERROR, ID, message, t);
	}

	public static void log(Throwable t) {
		log(status(t));
	}
	public static void log(String msg, Throwable t) {
		log(status(msg,t));
	}

	public static void log(IStatus status) {
		Bundle bundle = Platform.getBundle(ID);
		ILog log = Platform.getLog(bundle);
		log.log(status);
	}
}
