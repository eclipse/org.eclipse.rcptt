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
package org.eclipse.rcptt.reporting.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.reporting.core.IReportRenderer;
import org.eclipse.rcptt.reporting.util.internal.Plugin;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.util.FileUtil;

public class RcpttFileReportGenerator implements IReportRenderer {

	protected static final String ID = null;

	public RcpttFileReportGenerator() {
	}

	@Override
	public IStatus generateReport(IContentFactory factory, String reportName,
			Iterable<Report> report) {

		OutputStream stream = null;

		try {
			stream = factory.createFileStream(reportName + ".report");
			FileUtil.copy(
					new BufferedInputStream(new FileInputStream(((Q7ReportIterator) report)
							.getReportFile())), stream);
		} catch (CoreException e) {
			return e.getStatus();
		} catch (FileNotFoundException e) {
			return Plugin.UTILS.createError(e);
		} catch (IOException e) {
			return Plugin.UTILS.createError(e);
		}

		return Status.OK_STATUS;
	}

	
	public String[] getGeneratedFileNames(String reportName) {
		return new String[] { reportName + ".report" };
	}
}
