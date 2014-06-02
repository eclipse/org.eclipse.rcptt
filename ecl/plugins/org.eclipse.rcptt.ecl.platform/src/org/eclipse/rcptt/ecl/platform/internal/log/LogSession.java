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
package org.eclipse.rcptt.ecl.platform.internal.log;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Group of entries with additional Session data.
 */
public class LogSession extends Group {

	/**
	 * Describes the !SESSION header name
	 * 
	 * @since 3.5
	 */
	public static final String SESSION = "!SESSION"; //$NON-NLS-1$
	private String sessionData;
	private Date date;

	public LogSession() {
		super("Session");
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //$NON-NLS-1$
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) { // do nothing
		}
	}

	public String getSessionData() {
		return sessionData;
	}

	void setSessionData(String data) {
		this.sessionData = data;
	}

	public void processLogLine(String line) {
		// process "!SESSION <dateUnknownFormat> ----------------------------"
		if (line.startsWith(SESSION)) {
			line = line.substring(SESSION.length()).trim(); // strip "!SESSION "
			int delim = line.indexOf("----"); //$NON-NLS-1$ // single "-" may be in date, so take few for sure
			if (delim == -1) {
				return;
			}
			String dateBuffer = line.substring(0, delim).trim();
			setDate(dateBuffer);
		}
	}

	public void write(PrintWriter writer) {
		writer.write(sessionData);
		writer.println();
		super.write(writer);
	}
}
