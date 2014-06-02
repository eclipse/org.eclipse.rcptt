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
package org.eclipse.rcptt.profiling.core;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.rcptt.sherlock.aspects.jobs.internal.IJobsEventListener;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobsFactory;

@SuppressWarnings("restriction")
public class JobsProfilingSupport implements IJobsEventListener,
		IJobChangeListener {

	private static final String JOBS_SLEEPING_COLOR = "#505050";

	private static final String JOBS_RUNNING_COLOR = "#00BB00";

	private static final String JOBS_WAITING_COLOR = "#AAAAAA";

	private Map<IReportBuilder, Map<Object, EventSource>> sources = new HashMap<IReportBuilder, Map<Object, EventSource>>();
	private Map<InternalJob, JobEventKind> currentStates = new WeakHashMap<InternalJob, JobEventKind>();
	private JobsEventProvider provider;

	public JobsProfilingSupport(JobsEventProvider jobsEventProvider) {
		this.provider = jobsEventProvider;
	}

	private Map<Object, EventSource> getSources(IReportBuilder builder) {
		Map<Object, EventSource> map = sources.get(builder);

		if (map == null) {
			map = new WeakHashMap<Object, EventSource>();
			sources.put(builder, map);
		}
		return map;
	}

	public void jobSchedule(InternalJob job, long delay, boolean reshedule) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			JobInfo jobInfo = JobsFactory.eINSTANCE.createJobInfo();
			String jname = job.getClass().getName();
			// if (jname.contains("org.eclipse.ecl")) {
			// return;
			// }
			jobInfo.setJobClassName(jname);

			Map<Thread, StackTraceElement[]> stackTraces = Thread
					.getAllStackTraces();
			Object object = ReflectionUtils.getThis(job);
			for (Thread t : stackTraces.keySet()) {
				if (!t.equals(Thread.currentThread())) {
					continue;
				}
				jobInfo.setThreadName(t.getName());
				// Out thread
				StackTraceElement[] traceElements = stackTraces.get(t);
				boolean next = false;
				for (StackTraceElement stackTraceElement : traceElements) {
					if (next) {
						jobInfo.setSourceMethod(stackTraceElement
								.getMethodName());
						jobInfo.setSourceClass(stackTraceElement.getClassName());
						String fName = stackTraceElement.getFileName();
						if (fName != null) {
							jobInfo.setSourceFile(fName + ":"
									+ stackTraceElement.getLineNumber());
						}
						break;
					}
					if (stackTraceElement.getClassName().equals(
							"org.eclipse.swt.widgets.Display")) {
						next = true;
					}
				}
			}
			if (object != null) {
				String tname = object.getClass().getName();
				if (!(jobInfo.getSourceClass() != null && jobInfo
						.getSourceClass().equals(tname))) {
					jobInfo.setThisClassName(tname);
				}
			}
			if (jobInfo.getJobClassName() != null
					&& jobInfo.getSourceClass() != null) {
				if (jobInfo.getJobClassName().startsWith(
						jobInfo.getSourceClass())) {
					jobInfo.setJobClassName(jobInfo.getJobClassName()
							.substring(jobInfo.getSourceClass().length()));
				}
			}

			EventSource source = builder.findSource(SherlockJobsCore.JOBS,
					jobInfo);

			if (source == null) {
				source = builder.registerEventSource("job:"
						+ job.getClass().getSimpleName());
				source.getProperties().put(SherlockJobsCore.JOBS, jobInfo);
			}
			getSources(builder).put(job, source);

			Event event = builder.createEvent();
			event.setSource(source);
			event.setKind(EventKind.BEGIN);
			event.setColor(JOBS_WAITING_COLOR);
			JobEventInfo eventInfo = JobsFactory.eINSTANCE.createJobEventInfo();
			event.setData(eventInfo);
			// eventInfo.
			eventInfo.setKind(JobEventKind.SHEDULED);
			eventInfo.setId(JobsEventProvider.getID(job));
			currentStates.put(job, JobEventKind.SHEDULED);
		}
	}

	public void jobChangeStatus(InternalJob job, int newState) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(job) == null) {
				return;
			}
			if (newState != 0) {
				JobEventKind kind = currentStates.get(job);
				if (kind != null) {
					if (newState == Job.RUNNING || newState == 0x10) {
						if (kind.equals(JobEventKind.RUNNING)) {
							return;
						}
					} else if (newState == Job.SLEEPING) {
						if (kind.equals(JobEventKind.SLEPPING)) {
							return;
						}
					} else {
						if (kind.equals(JobEventKind.WAITING)) {
							return;
						}
					}
				}

				// Close old event
				JobEventInfo eventInfo = JobsFactory.eINSTANCE
						.createJobEventInfo();
				eventInfo.setId(JobsEventProvider.getID(job));

				Event event = builder.createEvent();
				event.setSource(getSources(builder).get(job));
				event.setData(eventInfo);
				event.setKind(EventKind.BEGIN);
				if (newState == Job.RUNNING || newState == 0x10) {
					eventInfo.setKind(JobEventKind.RUNNING);
					event.setColor(JOBS_RUNNING_COLOR);
				} else if (newState == Job.SLEEPING) {
					event.setColor(JOBS_SLEEPING_COLOR);
					eventInfo.setKind(JobEventKind.SLEPPING);
				} else /*
						 * if (newState == Job.WAITING || newState == 0x08 ||
						 * newState == 0x40 || newState == 0x20)
						 */{
					eventInfo.setKind(JobEventKind.WAITING);
					event.setColor(JOBS_WAITING_COLOR);
				}
				currentStates.put(job, eventInfo.getKind());
			}
		}
	}

	public void endJob(InternalJob job, IStatus status, boolean notify) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(job) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setSource(getSources(builder).get(job));
			JobEventInfo eventInfo = JobsFactory.eINSTANCE.createJobEventInfo();
			eventInfo.setId(JobsEventProvider.getID(job));
			event.setData(eventInfo);
			if (status != null && Job.ASYNC_FINISH.equals(status)) {
				event.setKind(EventKind.BEGIN);
				eventInfo.setKind(JobEventKind.ASYNC_FINISH);
			} else {
				event.setKind(EventKind.END);
				eventInfo.setKind(JobEventKind.FINISHED);
				currentStates.remove(job);
				getSources(builder).remove(job);
			}
		}
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
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(job) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setSource(getSources(builder).get(job));
			JobEventInfo eventInfo = JobsFactory.eINSTANCE.createJobEventInfo();
			event.setData(eventInfo);
			eventInfo.setKind(JobEventKind.CANCELED);
			eventInfo.setId(JobsEventProvider.getID(job));
			event.setKind(EventKind.END);
			currentStates.remove(job);
		}
	}

	public void clear() {
		currentStates.clear();
		sources.clear();
	}
}
