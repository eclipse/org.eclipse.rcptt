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
package org.eclipse.rcptt.reporting.util;

import java.io.Closeable;
import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportIterator;

public class Q7ReportIterator implements
		Iterable<Report>, Closeable {
	private final SherlockReportIterator sherlock;

	public Q7ReportIterator(File file) {
		sherlock = new SherlockReportIterator(file);
	}

	public Iterator<Report> iterator() {
		sherlock.reset();

		return new Iterator<Report>() {

			
			public boolean hasNext() {
				return sherlock.hasNext();
			}

			
			public Report next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				Report rv = sherlock.next();
				if (rv == null)
					return null;

				Q7Info info = ReportHelper.getInfo(rv.getRoot());
				if (info.getResult() == null) {
					info.setResult(RcpttPlugin.createProcessStatus(IStatus.ERROR, "Empty result"));
				}
				return rv;
			};

			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}

	@Override
	public void close() {
		sherlock.close();
	}

	public File getReportFile() {
		return sherlock.getReportFile();
	}
}
