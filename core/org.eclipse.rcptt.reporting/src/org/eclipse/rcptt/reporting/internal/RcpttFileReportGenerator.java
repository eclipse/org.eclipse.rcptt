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
package org.eclipse.rcptt.reporting.internal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.reporting.core.IReportRenderer;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.util.FileUtil;

public class RcpttFileReportGenerator implements IReportRenderer {

	protected static final String ID = null;

	public RcpttFileReportGenerator() {
	}

	
	public IStatus generateReport(IContentFactory factory, String reportName,
			Q7ReportIterator report) {

		OutputStream stream = null;
		try {
			stream = factory.createFileStream(reportName + ".report");
			FileUtil.copy(
					new BufferedInputStream(new FileInputStream(report
							.getReportFile())), stream);
		} catch (Exception e) {
			Q7ReportingPlugin.log(e);
		}

		return Status.OK_STATUS;
	}

	
	public String[] getGeneratedFileNames(String reportName) {
		return new String[] { reportName + ".report" };
	}
}
