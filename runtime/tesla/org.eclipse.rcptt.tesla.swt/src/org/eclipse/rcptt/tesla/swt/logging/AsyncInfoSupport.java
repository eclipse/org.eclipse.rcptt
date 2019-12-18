/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.logging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.aspects.asyncs.IAsyncEventListener;
import org.eclipse.rcptt.sherlock.core.SherlockTimerRunnable;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.tesla.core.Q7WaitUtils;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.swt.events.TeslaTimerExecManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaTimerExecManager.TimerInfo;

final class AsyncInfoSupport implements IAsyncEventListener {
	private JobsInfoProvider provider;
	private boolean collectTimerExecs = true;

	private List<SherlockTimerRunnable> runnables = new ArrayList<SherlockTimerRunnable>();
	private List<Runnable> sync = new ArrayList<Runnable>();

	public AsyncInfoSupport(JobsInfoProvider jobsEventProvider) {
		this.provider = jobsEventProvider;
	}

	public void timerCanceled(Runnable timer) {
	}

	public synchronized void timerAdded(Runnable async) {
		async = getRunnable(async);
		String timerClassName = async.getClass().getName();
		boolean ignoredTimer = SWTUIPlayer.isTimerIgnored(timerClassName);
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			ReportHelper.updateWaitInfo(builder.getCurrent(), ignoredTimer ? "timer (ignored)" : "timer",
					timerClassName);
		}
	}

	private Runnable getRunnable(Runnable async) {
		if (async instanceof SherlockTimerRunnable) {
			async = (Runnable) ((SherlockTimerRunnable) async).getRunnable();
		}
		return async;
	}

	public Runnable cancelTimerProc(Runnable runnable) {
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
		synchronized (runnables) {
			for (SherlockTimerRunnable r : runnables) {
				if (r.getDirectChild() == newRunnable) {
					return r;
				}
			}
		}
		// Check for ignored timer's.
		SherlockTimerRunnable result = new SherlockTimerRunnable(newRunnable) {
			@Override
			protected void preExecute() {
				final boolean ignoredTimer = SWTUIPlayer.isTimerIgnored(getRunnable().getClass().getName());
				IReportBuilder[] builders = provider.getListeners();
				for (IReportBuilder builder : builders) {
					Q7WaitInfoRoot waitInfo = ReportHelper.getWaitInfo(builder.getCurrent());
					List<TimerInfo> timers = TeslaTimerExecManager.getManager().getTimers();
					for (TimerInfo timerInfo : timers) {
						if (timerInfo.hasRunnable(getRunnable())) {
							String timerClassName = getRunnable().getClass().getName();
							synchronized (waitInfo) {
								if (timerInfo.execQualifier != null) {
									waitInfo.getInnerClassMap().put(timerClassName, timerInfo.execQualifier);
								}
							}
							Q7WaitUtils
									.updateInfo(ignoredTimer ? "timer (ignored)" : "timer", timerClassName, waitInfo);
						}
					}

				}
			}

			public void postExecute() {
				try {
					preExecute();
				} finally {
					synchronized (runnables) {
						runnables.remove(this);
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
		if (async == null) {
			return;
		}
		async = getRunnable(async);
		String className = getAsyncClassName(async);
		if (isAsyncIgnored(className)) {
			return;
		}

		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			String kind = "async";
			if (this.sync.contains(async)) {
				kind = "sync";
			}
			ReportHelper.startWaitInfo(builder.getCurrent(), kind, className);
		}
	}

	private boolean isAsyncIgnored(String className) {
		if (className.startsWith("org.eclipse.ui.internal.UISynchronizer")) {
			return true;
		}
		return false;
	}

	public synchronized void asyncDone(Runnable async) {
		async = getRunnable(async);
		String className = getAsyncClassName(async);
		if (isAsyncIgnored(className)) {
			return;
		}
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			String kind = "async";
			if (this.sync.contains(async)) {
				kind = "sync";
				this.sync.remove(async);
			}
			ReportHelper.finishWaitInfo(builder.getCurrent(), kind, className);
		}
	}

	public synchronized void asyncAdded(Runnable async, boolean sync) {
		async = getRunnable(async);
		String className = getAsyncClassName(async);
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			String kind = sync ? "sync" : "async";
			if (sync) {
				this.sync.add(async);
			}
			ReportHelper.startWaitInfo(builder.getCurrent(), kind, className);
		}
	}

	private String getAsyncClassName(Runnable async) {
		String className = async.getClass().getName();
		if (async instanceof SWTUIPlayer.ExecRunnable) {
			className = async.toString();
		}
		if (className.startsWith("org.eclipse.ui.progress.UIJob")) {
			Object this1 = TeslaSWTAccess.getThis(async);
			if (this1 instanceof Job) {
				className = this1.getClass().getName();
			}
		}
		return className;
	}

	public void clear() {
	}
}
