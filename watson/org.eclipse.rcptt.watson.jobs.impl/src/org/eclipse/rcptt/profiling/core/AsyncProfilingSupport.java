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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.rcptt.sherlock.aspects.asyncs.IAsyncEventListener;
import org.eclipse.rcptt.sherlock.core.SherlockTimerRunnable;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobsFactory;

final class AsyncProfilingSupport implements IAsyncEventListener {
	private static final String ASYNC_RUNNING_COLOR = "#00BB00";
	private static final String ASYNC_ADDED_COLOR = "#AAAAAA";
	private boolean collectTimerExecs = true;

	private Map<IReportBuilder, Map<Runnable, EventSource>> sources = new HashMap<IReportBuilder, Map<Runnable, EventSource>>();
	private JobsEventProvider provider;
	private List<SherlockTimerRunnable> runnables = new ArrayList<SherlockTimerRunnable>();

	public AsyncProfilingSupport(JobsEventProvider jobsEventProvider) {
		this.provider = jobsEventProvider;
	}

	public void timerCanceled(Runnable timer) {
	}

	public synchronized void timerAdded(Runnable async) {
		if (!collectTimerExecs) {
			return;
		}
		if (async instanceof SherlockTimerRunnable) {
			async = (Runnable) ((SherlockTimerRunnable) async).getRunnable();
		}

		final IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			EventSource source = getSources(builder).get(async);
			if (source != null) {
				// Re timer exec, skip it.
				getSources(builder).remove(async);
				return;
			}
		}
		// String name = async.getClass().getName();
		// if (name.contains("org.eclipse.swt.ole.win32.OleFrame")) {
		// return;
		// }

		for (IReportBuilder builder : builders) {
			AsyncInfo info = JobsFactory.eINSTANCE.createAsyncInfo();
			info.setRunnableClass(async.getClass().getName());
			info.setSync(false);
			info.setTimer(true);
			fillStackInfo(async, info);

			EventSource source = builder
					.findSource(SherlockJobsCore.JOBS, info);

			if (source == null) {
				source = builder.registerEventSource("timer exec:"
						+ async.getClass().getSimpleName());
				source.getProperties().put(SherlockJobsCore.JOBS, info);
			}
			getSources(builder).put(async, source);

			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			eventInfo.setKind(AsyncEventKind.TIMER_EXEC);
			eventInfo.setId(JobsEventProvider.getID(async));

			Event event = ReportFactory.eINSTANCE.createEvent();
			event.setSource(source);
			event.setData(eventInfo);
			event.setKind(EventKind.BEGIN);
			event.setColor(ASYNC_ADDED_COLOR);
			builder.getCurrent().createEvent(event);
		}
	}

	public Runnable cancelTimerProc(final Runnable runnable) {
		if (!collectTimerExecs) {
			return runnable;
		}
		synchronized (runnables) {
			Iterator<SherlockTimerRunnable> iterator = runnables.iterator();
			while (iterator.hasNext()) {
				SherlockTimerRunnable r = iterator.next();
				if (r.getDirectChild() == runnable) {
					iterator.remove();
					return r;
				}
			}
		}
		return runnable;
	}

	public Runnable processTimerProc(final Runnable newRunnable) {
		if (!collectTimerExecs) {
			return newRunnable;
		}
		final IReportBuilder[] builders = provider.getListeners();
		final Map<IReportBuilder, EventSource> localSources = new HashMap<IReportBuilder, EventSource>();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(newRunnable) == null) {
				return newRunnable;
			}
			localSources.put(builder, getSources(builder).get(newRunnable));
		}
		synchronized (runnables) {
			for (SherlockTimerRunnable r : runnables) {
				if (r.getDirectChild() == newRunnable) {
					return r;
				}
			}
		}
		SherlockTimerRunnable result = new SherlockTimerRunnable(newRunnable) {
			@Override
			protected void preExecute() {
				for (IReportBuilder builder : localSources.keySet()) {
					if (localSources.get(builder) == null) {
						continue;
					}

					Event event = ReportFactory.eINSTANCE.createEvent();
					event.setSource(getSources(builder).get(newRunnable));

					AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
							.createAsyncEventInfo();
					eventInfo.setId(JobsEventProvider.getID(newRunnable));
					event.setData(eventInfo);
					event.setKind(EventKind.BEGIN);
					event.setColor(ASYNC_RUNNING_COLOR);
					eventInfo.setKind(AsyncEventKind.RUNNING);
					builder.getCurrent().createEvent(event);
				}
			}

			public void postExecute() {
				for (IReportBuilder builder : localSources.keySet()) {
					if (localSources.get(builder) == null) {
						continue;
					}

					Event event = ReportFactory.eINSTANCE.createEvent();
					event.setSource(getSources(builder).get(newRunnable));

					AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
							.createAsyncEventInfo();
					eventInfo.setId(JobsEventProvider.getID(newRunnable));
					event.setData(eventInfo);
					event.setKind(EventKind.END);
					event.setColor(ASYNC_RUNNING_COLOR);
					eventInfo.setKind(AsyncEventKind.DONE);
					builder.getCurrent().createEvent(event);
					getSources(builder).remove(newRunnable);
					synchronized (runnables) {
						for (SherlockTimerRunnable r : runnables) {
							if (r.getRunnable() == newRunnable) {
								runnables.remove(r);
								return;
							}
						}
					}
				}
			}
		};
		synchronized (runnables) {
			runnables.add(result);
		}
		return result;
	}

	public synchronized void asyncRunning(Runnable async) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(async) == null) {
				return;
			}

			Event event = ReportFactory.eINSTANCE.createEvent();
			event.setSource(getSources(builder).get(async));

			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			eventInfo.setId(JobsEventProvider.getID(async));
			event.setData(eventInfo);
			event.setKind(EventKind.BEGIN);
			event.setColor(ASYNC_RUNNING_COLOR);
			eventInfo.setKind(AsyncEventKind.RUNNING);
			builder.getCurrent().createEvent(event);
		}
	}

	private Map<Runnable, EventSource> getSources(IReportBuilder builder) {
		Map<Runnable, EventSource> map = sources.get(builder);

		if (map == null) {
			map = new WeakHashMap<Runnable, EventSource>();
			sources.put(builder, map);
		}
		return map;
	}

	public synchronized void asyncDone(Runnable async) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {

			if (getSources(builder).get(async) == null) {
				return;
			}
			Event event = ReportFactory.eINSTANCE.createEvent();
			event.setKind(EventKind.END);
			event.setColor(ASYNC_RUNNING_COLOR);
			event.setSource(getSources(builder).get(async));

			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			event.setData(eventInfo);
			eventInfo.setId(JobsEventProvider.getID(async));
			eventInfo.setKind(AsyncEventKind.DONE);
			builder.getCurrent().createEvent(event);
			getSources(builder).remove(async);
		}
	}

	public synchronized void asyncAdded(Runnable async, boolean sync) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			AsyncInfo info = JobsFactory.eINSTANCE.createAsyncInfo();
			info.setRunnableClass(async.getClass().getName());
			info.setSync(sync);
			info.setTimer(false);
			fillStackInfo(async, info);

			EventSource source = builder
					.findSource(SherlockJobsCore.JOBS, info);

			if (source == null) {
				source = builder.registerEventSource("async:"
						+ async.getClass().getSimpleName());
				source.getProperties().put(SherlockJobsCore.JOBS, info);
			}
			getSources(builder).put(async, source);

			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			eventInfo.setKind(AsyncEventKind.STARTING);
			eventInfo.setId(JobsEventProvider.getID(async));

			Event event = ReportFactory.eINSTANCE.createEvent();
			event.setSource(source);
			event.setData(eventInfo);
			event.setKind(EventKind.BEGIN);
			if (!sync) {
				event.setColor(ASYNC_ADDED_COLOR);
			} else {
				event.setColor(ASYNC_RUNNING_COLOR);
				eventInfo.setKind(AsyncEventKind.RUNNING);
			}
			builder.getCurrent().createEvent(event);
		}
	}

	private void fillStackInfo(Runnable async, AsyncInfo info) {
		Map<Thread, StackTraceElement[]> stackTraces = Thread
				.getAllStackTraces();
		Object object = ReflectionUtils.getThis(async);
		for (Thread t : stackTraces.keySet()) {
			if (!t.equals(Thread.currentThread())) {
				continue;
			}
			info.setThreadName(t.getName());
			// Out thread
			StackTraceElement[] traceElements = stackTraces.get(t);
			boolean next = false;
			for (StackTraceElement stackTraceElement : traceElements) {
				if (next) {
					info.setSourceMethod(stackTraceElement.getMethodName());
					info.setSourceClass(stackTraceElement.getClassName());
					String fName = stackTraceElement.getFileName();
					if (fName != null) {
						info.setSourceFile(fName + ":"
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
			if (!(info.getSourceClass() != null && info.getSourceClass()
					.equals(tname))) {
				info.setThisClassName(tname);
			}
		}
		if (info.getRunnableClass() != null && info.getSourceClass() != null) {
			if (info.getRunnableClass().startsWith(info.getSourceClass())) {
				info.setRunnableClass(info.getRunnableClass().substring(
						info.getSourceClass().length()));
			}
		}
	}

	public void clear() {
		sources.clear();
	}
}
