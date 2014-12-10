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
package org.eclipse.rcptt.ui.report.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.reporting.internal.ReportUtils;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;

import com.google.common.base.Preconditions;

class ReportEntryContentProvider implements
		IStructuredContentProvider {
	public void dispose() {
		Job.getJobManager().cancel(this);
	}

	private List<ReportEntry> entries = Collections.emptyList();
	private Viewer viewer = null;

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		Job.getJobManager().cancel(this);
		if (newInput instanceof Q7ReportIterator)
			new UpdateJob((Q7ReportIterator) newInput).schedule();
	}

	public Object[] getElements(Object inputElement) {
		return entries.toArray();
	}

	private class UpdateJob extends Job {
		private final Q7ReportIterator iterator;

		@Override
		public boolean belongsTo(Object family) {
			return ReportEntryContentProvider.this == family;
		}

		public UpdateJob(Q7ReportIterator iterator) {
			super("Building test list for report");
			Preconditions.checkNotNull(iterator);
			this.iterator = iterator;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			final List<ReportEntry> entries = new ArrayList<ReportEntry>();
			if (monitor.isCanceled())
				return Status.CANCEL_STATUS;
			synchronized (iterator) {
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				iterator.reset();
				int failCount = 0;
				while (this.iterator.hasNext()) {
					if (monitor.isCanceled())
						return Status.CANCEL_STATUS;
					Report next = this.iterator.next();
					if (next == null) {
						break;
					}
					ReportEntry re = new ReportEntry();
					Node root = next.getRoot();
					re.name = root.getName();
					re.time = (int) (root.getEndTime() - root.getStartTime());
					EMap<String, EObject> properties = root.getProperties();
					Q7Info info = (Q7Info) properties.get(IQ7ReportConstants.ROOT);

					if (info != null) {
						StringBuilder details = new StringBuilder();
						String fail = ReportUtils.getFailMessage(root);
						if (fail.length() > 0) {
							details.append(fail).append("\n");
						}
						ReportUtils.collectDetails(root, details);
						if (details.length() > 0) {
							re.warning = true;
						}
						re.status = info.getResult();
						if (re.status != ResultStatus.PASS) {
							failCount++;
							if (failCount < 100) {
								re.message = new SimpleReportGenerator().generateContent(next);// details.toString();
							} else {
								re.message = "Too many errors";
							}
						}
						re.id = info.getId();
						entries.add(re);
					}
				}
			}
			ReportEntryContentProvider.this.entries = entries;
			viewer.getControl().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					if (!viewer.getControl().isDisposed())
						viewer.refresh();
				}
			});
			return Status.OK_STATUS;
		}
	}
}