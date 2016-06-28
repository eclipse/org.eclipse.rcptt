/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.logging;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

public class Q7LoggingManager {
	private File rootFile;

	private static Map<String, IQ7Monitor> monitors = new HashMap<String, IQ7Monitor>();

	private static Q7LoggingManager serverMonitor = new Q7LoggingManager();

	public static Q7LoggingManager getManager() {
		return serverMonitor;
	}

	public Q7LoggingManager() {
		this.rootFile = getLogsFile().toFile();
		this.rootFile.mkdirs();
	}

	public IPath getLogsFile() {
		return Q7LoggingPlugin.getDefault().getStateLocation();
	}

	public IQ7Monitor getMonitor(String id) {
		return getMonitor(id, null, ".log");
	}

	public static IQ7Monitor get(String id) {
		return getManager().getMonitor(id);
	}

	public static IQ7Monitor get(String id, String prefix, String pipe) {
		return getManager().getMonitor(id, prefix, pipe);
	}

	public synchronized IQ7Monitor getMonitor(String id, String prefix,
			String pipeName) {
		String key = id + ":" + pipeName;
		if (monitors.containsKey(key)) {
			return monitors.get(key);
		}
		File child = new File(this.rootFile, (prefix != null ? prefix + "/"
				: "") + getID(id));
		if (!child.exists()) {
			child.mkdirs();
		}
		ConfigurableFileQ7Monitor monitor = new ConfigurableFileQ7Monitor(id, prefix,
				child, pipeName);
		monitors.put(key, monitor);
		return monitor;
	}

	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String idValue = formatter.format(new Date(System.currentTimeMillis()));
		return idValue;
	}

	public synchronized IQ7Monitor getNewMonitor(String prefix, String base) {
		while (true) {
			String key = base + getCurrentDate();
			File child = new File(this.rootFile, (prefix != null ? prefix + "/"
					: "") + getID(key));
			if (!child.exists()) {
				child.mkdirs();
				ConfigurableFileQ7Monitor monitor = new ConfigurableFileQ7Monitor(key,
						prefix, child, ".log");
				monitors.put(key + ":.log", monitor);
				return monitor;
			}
		}

	}

	public static IQ7Monitor newMonitor(String prefix, String base) {
		return getManager().getNewMonitor(prefix, base);
	}

	public static StatusListener getChild(IQ7Monitor monitor, String uri) {
		IQ7Monitor result = getManager().getMonitor(monitor.getId(),
				monitor.getPrefix(), uri);
		monitor.putChild(result);
		return result;
	}

	public static String getID(String value) {
		if (value == null) {
			return null;
		}
		StringBuilder textResult = new StringBuilder();
		for (char c : value.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				textResult.append('_');
			} else {
				textResult.append(c);
			}
		}
		return textResult.toString();
	}

	synchronized void remove(BaseFileQ7Monitor simpleFileQ7Monitor) {
		String removeID = null;
		for (Map.Entry<String, IQ7Monitor> e : monitors.entrySet()) {
			if (e.getValue().equals(simpleFileQ7Monitor)) {
				removeID = e.getKey();
				break;
			}
		}
		if (removeID != null) {
			monitors.remove(removeID);
		}
	}

	public static void logMessage(String id, String message) {
		get(id).log(message, null);
	}

	public static void logMessage(String id, String message, Exception e) {
		get(id).log(message, e);
	}
}
