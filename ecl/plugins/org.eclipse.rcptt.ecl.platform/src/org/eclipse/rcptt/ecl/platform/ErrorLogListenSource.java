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
package org.eclipse.rcptt.ecl.platform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rcptt.ecl.core.IListenSource;
import org.eclipse.rcptt.ecl.platform.internal.log.LogEntry;
import org.eclipse.rcptt.ecl.platform.util.EclPlatformUtil;

public class ErrorLogListenSource implements IListenSource {
	public static class CollectedLogEntries {
		List<LogEntry> entries = new ArrayList<LogEntry>();
		ILogListener listener = new ILogListener() {
			public void logging(IStatus status, String plugin) {
				entries.add(new LogEntry(status));
			}
		};
	}

	public Object begin() {
		final CollectedLogEntries e = new CollectedLogEntries();
		Platform.addLogListener(e.listener);
		return e;
	}

	public List<Object> finish(Object obj) {
		List<Object> result = new ArrayList<Object>();
		CollectedLogEntries ee = (CollectedLogEntries) obj;
		Platform.removeLogListener(ee.listener);
		for (Object o : ee.entries) {
			result.add(EclPlatformUtil.createMessage((LogEntry) o));
		}

		return result;
	}
}
