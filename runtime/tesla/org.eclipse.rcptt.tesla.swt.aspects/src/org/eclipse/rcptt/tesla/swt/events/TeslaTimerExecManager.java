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
package org.eclipse.rcptt.tesla.swt.events;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Display;

import org.eclipse.rcptt.sherlock.core.SherlockTimerRunnable;

public class TeslaTimerExecManager {
	private static TeslaTimerExecManager manager = new TeslaTimerExecManager();
	private Set<ITimerExecHelper> listeners = new HashSet<ITimerExecHelper>();

	public static class TimerInfo {
		public Runnable runnable;
		public String execQualifier;
		public long firstSheduleTime = 0; // First schedule time
		public long time; // Delay
		public long resheduleCounter = 0;

		public boolean hasRunnable(Runnable run) {
			Runnable thisRun = getRunnable(this.runnable);
			Runnable runRun = getRunnable(run);
			return thisRun.equals(runRun);
		}

		private Runnable getRunnable(Runnable ref) {
			if (ref instanceof SherlockTimerRunnable) {
				return ((SherlockTimerRunnable) ref).getRunnable();
			}
			return ref;
		}

		public Runnable getRunnable() {
			return getRunnable(this.runnable);
		}
	}

	private List<WeakReference<TimerInfo>> timers = new ArrayList<WeakReference<TimerInfo>>();

	private TeslaTimerExecManager() {
	}

	public synchronized void recordTimerExec(Runnable run, int time) {

		Iterator<WeakReference<TimerInfo>> iterator = timers.iterator();
		while (iterator.hasNext()) {
			WeakReference<TimerInfo> info = iterator.next();
			TimerInfo timerInfo = info.get();
			if (timerInfo != null && timerInfo.hasRunnable(run)) {
				updateTimer(run, time, timerInfo);
				return;
			}
		}
		TimerInfo info = new TimerInfo();
		info.runnable = run;
		info.time = time;
		info.firstSheduleTime = System.currentTimeMillis();
		info.resheduleCounter = 0;
		info.execQualifier = getTimerCallQualifier(info, Thread.currentThread().getStackTrace());
		timers.add(new WeakReference<TeslaTimerExecManager.TimerInfo>(info));
	}

	private String getTimerCallQualifier(TimerInfo info, StackTraceElement[] stackTrace) {
		if (info.getRunnable().getClass().getName().indexOf("$") == -1) {
			return null;
		}
		for (int i = 0; i < stackTrace.length; i++) {
			if (stackTrace[i].getClassName().equals(Display.class.getName()) &&
					stackTrace[i].getMethodName().equals("timerExec")) {
				return stackTrace[i + 1].getMethodName() + ":"
						+ stackTrace[i + 1].getLineNumber();
			}
		}
		return null;
	}

	private void updateTimer(Runnable run, int time, TimerInfo info) {
		// This is rescheduling of same timer exec.
		info.resheduleCounter++;
		info.time = time;
	}

	public synchronized List<TimerInfo> getTimers() {
		ArrayList<TimerInfo> result = new ArrayList<TimerInfo>();
		for (WeakReference<TimerInfo> timerInfo : timers) {
			TimerInfo info = timerInfo.get();
			if (info != null) {
				result.add(info);
			}
		}
		return result;
	}

	public synchronized void clearTimers() {
		 this.timers.clear();
	}

	public boolean isNeedNullify(Runnable run, int time) {
		for (ITimerExecHelper listener : listeners) {
			if (listener.needNullify(run, time)) {
				return true;
			}
		}
		return false;
	}

	public static TeslaTimerExecManager getManager() {
		return manager;
	}

	public void addEventListener(ITimerExecHelper listener) {
		synchronized (listeners) {
			this.listeners.add(listener);
		}
	}

	public void removeEventListener(ITimerExecHelper listener) {
		synchronized (listeners) {
			this.listeners.remove(listener);
		}
	}

	public void clearListeners() {
		synchronized (listeners) {
			this.listeners.clear();
		}
	}

	@SuppressWarnings("unused")
	private List<ITimerExecHelper> getListeners() {
		List<ITimerExecHelper> copy = null;
		synchronized (listeners) {
			copy = new ArrayList<ITimerExecHelper>(listeners);
		}
		return copy;
	}

	public boolean hasListeners() {
		synchronized (listeners) {
			return !listeners.isEmpty();
		}
	}

	public synchronized void afterRunTimers(Display display) {
		try {
			Runnable[] currentTimers = TimerUtils.getTimers(display);
			Iterator<WeakReference<TimerInfo>> iterator = timers.iterator();
			while (iterator.hasNext()) {
				TimerInfo info = iterator.next().get();
				boolean found = false;
				if (info != null) {
					for (Runnable e : currentTimers) {
						if (info.hasRunnable(e)) {
							found = true;
							break;
						}
					}
				}
				if (!found) {
					iterator.remove(); // Remove timer if it is not in the list.
				}
			}
		} catch (Exception e) {
			timers.clear();
		}
	}

	public static boolean isTimerIgnored(String clName) {
		if (clName.contains("org.eclipse.swt")) {
			return true;
		}
		if( clName.contains("org.eclipse.ui.internal.progress.Throttler")) {
			return true;
		}
		if (clName.contains("org.eclipse.gef")) {
			return true;
		}
		if (clName.contains("org.eclipse.gmf")) {
			return true;
		}
		if (clName
				.contains("org.eclipse.ui.internal.ide.application.IDEIdleHelper")) {
			return true;
		}
		if (clName
				.contains("org.eclipse.tm.internal.terminal.textcanvas.PollingTextCanvasModel")) {
			return true;
		}
		if (clName
				.startsWith("org.eclipse.nebula.widgets.oscilloscope.OscilloscopeDispatcher")) {
			return true;
		}
		return false;
	}
}
