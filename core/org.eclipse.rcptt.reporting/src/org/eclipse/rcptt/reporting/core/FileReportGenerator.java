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
package org.eclipse.rcptt.reporting.core;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.reporting.Q7Statistics;
import org.eclipse.rcptt.reporting.internal.Q7ReportingPlugin;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public class FileReportGenerator implements IReportRenderer {

	public FileReportGenerator() {
	}

	
	@Override
	public IStatus generateReport(IContentFactory factory, String reportName,
			Iterable<Report> report) {

		Q7Statistics statistics = ReportUtils.calculateStatistics(report
				.iterator());
		OutputStream stream = null;
		try {
			stream = factory.createFileStream(reportName + ".xml");
			new XMLReportGenerator().generateContent(stream, reportName,
					report, statistics);
		} catch (CoreException cex) {
			return cex.getStatus();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				return new Status(IStatus.ERROR, Q7ReportingPlugin.PLUGIN_ID,
						e.getMessage(), e);
			}
		}
		return Status.OK_STATUS;
	}

	
	public String[] getGeneratedFileNames(String reportName) {
		return new String[] { reportName + ".xml" };
	}
}
