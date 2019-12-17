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
package org.eclipse.rcptt.reporting.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.ImageEntry;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.SimpleSeverity;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

/**
 * One-line representation of report to show in lists
 */
public final class ReportEntry {
	public final String name;
	public final String id;
	public final int time;
	private final int status;
	public final String message;

	private ReportEntry(String name, String id, int time, int status, String message) {
		super();
		checkNotNull(name);
		checkNotNull(id);
		checkNotNull(time);
		checkNotNull(status);
		checkNotNull(message);
		this.message = message;
		this.name = name;
		this.id = id;
		this.time = time;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	
	public SimpleSeverity getSimpleSeverity() {
		return SimpleSeverity.create(status);
	}
	
	/** IStatus constants bitwise mix */
	public int getStatusSeverity() {
		return status;
	}
	
	public static ReportEntry create(Report next) {
		Node root = next.getRoot();
		Q7Info info = ReportHelper.getInfo(root);
		StringWriter writer = new StringWriter();
		RcpttReportGenerator.writeResult(new PrintWriter(writer), 0, info.getResult());
		ReportEntry entry = new ReportEntry(root.getName(), info.getId(), (int) root.getDuration(),
				info.getResult().getSeverity(), writer.toString());
		return entry;
	}

}