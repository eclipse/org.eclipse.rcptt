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
package org.eclipse.rcptt.reporting.util.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportSession;

public class Reports {

	private final SherlockReportSession session;
	private final Map<String, List<String>> reports;

	public Reports(File root) {
		reports = new HashMap<String, List<String>>();
		session = new SherlockReportSession(root);
		session.reinit();
	}

	public SherlockReportSession getSession() {
		return session;
	}

	public void add(String suiteId, String reportId) {
		List<String> ids = reports.get(suiteId);
		if (ids == null) {
			ids = new ArrayList<String>();
			reports.put(suiteId, ids);
		}
		ids.add(reportId);
	}

	public Iterable<String> getSuiteIds() {
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				return reports.keySet().iterator();
			}
		};
	}

	public Iterable<String> getReportIds(final String suite) {
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				return reports.get(suite).iterator();
			}
		};
	}

	public Iterator<Report> getReports(String suite) {
		return new ReportIterator(getReportIds(suite).iterator());
	}

	private class ReportIterator implements Iterator<Report> {
		private Iterator<String> ids;

		public ReportIterator(Iterator<String> ids) {
			super();
			this.ids = ids;
		}

		
		public boolean hasNext() {
			return ids.hasNext();
		}

		
		public Report next() {
			return getSession().getReport(ids.next());
		}

		
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
