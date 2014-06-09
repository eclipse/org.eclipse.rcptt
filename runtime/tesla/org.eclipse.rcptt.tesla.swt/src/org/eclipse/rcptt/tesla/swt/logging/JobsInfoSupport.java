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
package org.eclipse.rcptt.tesla.swt.logging;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.aspects.jobs.internal.IJobsEventListener;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.tesla.internal.ui.player.UIJobCollector;
import org.eclipse.rcptt.tesla.ui.IJobCollector.JobStatus;

@SuppressWarnings("restriction")
public class JobsInfoSupport implements IJobsEventListener,
		IJobChangeListener {

	private JobsInfoProvider provider;

	public JobsInfoSupport(JobsInfoProvider jobsEventProvider) {
		this.provider = jobsEventProvider;
	}

	public void jobSchedule(InternalJob job, long delay, boolean reshedule) {
		jobUpdate(job);
	}

	public void jobChangeStatus(InternalJob job, int newState) {
		jobUpdate(job);
	}

	public void endJob(InternalJob job, IStatus status, boolean notify) {
		jobUpdate(job);
	}

	public void aboutToRun(IJobChangeEvent event) {
	}

	public void awake(IJobChangeEvent event) {
	}

	public void done(IJobChangeEvent event) {
	}

	public void running(IJobChangeEvent event) {
	}

	public void scheduled(IJobChangeEvent event) {
	}

	public void sleeping(IJobChangeEvent event) {
	}

	public void register() {
		Job.getJobManager().addJobChangeListener(this);
	}

	public void unregister() {
		Job.getJobManager().removeJobChangeListener(this);
	}

	public void jobCanceled(InternalJob job) {
		jobUpdate(job);
	}

	private void jobUpdate(final InternalJob job) {
		JobStatus status = UIJobCollector.detectJobStatus((Job) job, 0);
		if (status.equals(JobStatus.IGNORED)) {
			return;
		}
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			ReportHelper.updateWaitInfo(builder.getCurrent(), "job", job.getClass().getName());
		}
	}

	public void clear() {

	}
}
