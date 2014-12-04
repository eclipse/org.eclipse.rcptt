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
package org.eclipse.rcptt.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.eclipse.rcptt.logging.IQ7Monitor.IQ7LogListener;

public abstract class BaseFileQ7Monitor {
	static boolean logToConsole = false;

	public static void setLogToConsole(boolean value) {
		logToConsole = value;
	}

	protected abstract String getFailMessage();

	protected abstract FileHandler getFileHandle() throws IOException;

	private SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	private List<IQ7LogListener> listeners = null;

	protected Logger logger;

	public BaseFileQ7Monitor() {
		super();
	}

	public synchronized void addListener(IQ7LogListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<IQ7LogListener>();
		}
		listeners.add(listener);
	}

	public synchronized void removeListener(IQ7LogListener listener) {
		if (listeners != null) {
			listeners.remove(listener);
		}
	}

	protected int getLogFileCount() {
		return 10;
	}

	protected int getLogFileSize() {
		return 10 * 1024 * 1024;
	}

	protected void reinit() {
		try {
			disposeLogger();
			logger = Logger.getAnonymousLogger();
			logger.setLevel(Level.ALL);
			FileHandler fileHandler = getFileHandle();
			fileHandler.setFormatter(new Formatter() {
				private String lineSeparator = System
						.getProperty("line.separator");

				@Override
				public String format(LogRecord record) {
					StringBuffer sb = new StringBuffer();
					// Minimize memory allocations here.
					String idValue = formatter.format(new Date(record
							.getMillis()));
					sb.append(idValue + ": ");

					String message = formatMessage(record);
					message = message.replace("\n", lineSeparator);
					sb.append(message);
					sb.append(lineSeparator);
					if (record.getThrown() != null) {
						try {
							StringWriter sw = new StringWriter();
							PrintWriter pw = new PrintWriter(sw);
							record.getThrown().printStackTrace(pw);
							pw.close();
							sb.append(sw.toString());
						} catch (Exception ex) {
						}
					}
					return sb.toString();
				}
			});
			logger.addHandler(fileHandler);
			log("############################## NEW SESSION #####################################",
					null);
		} catch (Exception e) {
			Q7LoggingPlugin.error(e.getMessage(), e);
		}
	}

	public void log(String message) {
		log(message, null);
	}

	public synchronized void log(String message, Throwable e) {
		if (logToConsole) {
			System.out.println(message);
			if (e != null) {
				e.printStackTrace();
			}
		}
		if (listeners != null) {
			for (IQ7LogListener l : listeners) {
				l.added(message);
			}
		}
		if (this.logger == null) {
			reinit();
		}
		if (this.logger == null) {
			Q7LoggingPlugin.error(getFailMessage(), null);
			return;
		}
		logger.log(Level.ALL, message, e);
	}

	public void close() {
		disposeLogger();
	}

	private void disposeLogger() {
		Logger logger2 = null;
		synchronized (this) {
			logger2 = logger;
			logger = null;
		}

		if (logger2 != null) {
			Handler[] targets = logger2.getHandlers();
			for (int i = 0; i < targets.length; i++) {
				Handler h = targets[i];
				logger2.removeHandler(h);
				try {
					h.close();
				} catch (Exception ex) {
					// Problems closing a handler? Keep going...
				}
			}
		}
	}

}