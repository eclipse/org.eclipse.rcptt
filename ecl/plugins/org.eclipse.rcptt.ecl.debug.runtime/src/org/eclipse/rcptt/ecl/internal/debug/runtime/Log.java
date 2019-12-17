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
package org.eclipse.rcptt.ecl.internal.debug.runtime;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

public class Log {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.debug.runtime";

	public static IStatus status(Throwable t) {
		return new Status(IStatus.ERROR, PLUGIN_ID, t.getMessage(), t);
	}

	public static void log(Throwable t) {
		log(status(t));
	}

	public static void log(IStatus status) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		ILog log = Platform.getLog(bundle);
		log.log(status);
	}
}
