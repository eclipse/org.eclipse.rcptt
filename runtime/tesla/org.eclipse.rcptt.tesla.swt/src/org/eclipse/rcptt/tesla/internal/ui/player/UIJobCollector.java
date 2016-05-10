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
package org.eclipse.rcptt.tesla.internal.ui.player;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.tesla.core.Q7WaitUtils;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.TeslaLimits;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.jobs.JobsManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.ui.IJobCollector;
import org.eclipse.rcptt.tesla.ui.IJobCollector.JobStatus;
import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

/**
 * Manages jobs information and statuses.
 */
public class UIJobCollector implements IJobChangeListener {
	private class JobInfo {
		private final Job job;
		private JobStatus status;
		private boolean sleeping = false;
		private boolean infoPrinted = false;
		private long startingTime = System.currentTimeMillis();
		private long rescheduleCounter = 0;
		private boolean jobInStepMode = false;
		private boolean checkForTimeout = true;
		private boolean done = false;

		JobInfo(Job job) {
			this.job = job;
			status = calcJobStatus(job, 0);
		}

		synchronized void awake() {
			sleeping = false;
			done = false;
			startingTime = System.currentTimeMillis();
		}

		synchronized void sleeping() {
			sleeping = true;
			done = false;
			infoPrinted = false;
		}

		synchronized void done(boolean reschedule) {
			if (!reschedule) {
				done = true;
			}
			else {
				// Job will be rescheduled
				rescheduleCounter += 1;
			}
		}

		synchronized void cancel() {
			done = true;
		}

		synchronized void printJobTimeoutLogEntry() {
			if (!infoPrinted) {
				infoPrinted = true;
				SWTTeslaActivator
						.logToReport("---->>> Waiting timeout exceed then execute: "
								+ getCurrentReportNodeName()
								+ " <<---\n(skipping)"
								+ getJobMessage(this));
			}
		}

		synchronized boolean isActive() {
			if (done)
				return false;
			if (!JobStatus.REQUIRED.equals(status))
				return false;
			if (sleeping) {
				long delay = startingTime - System.currentTimeMillis();
				return delay < TeslaLimits.getJobWaitForDelayedTimeout();
			}

			return true;
		}

		synchronized void scheduled(long delay) {
			sleeping = false;
			done = false;
			checkForTimeout = true;
			jobInStepMode = false;
			status = calcJobStatus(job, delay);
			startingTime = System.currentTimeMillis() + delay;
		}

		@Override
		public String toString() {
			return job.toString();
		}

	}

	private final Map<Job, JobInfo> jobs = Collections.synchronizedMap(new IdentityHashMap<Job, JobInfo>());
	private boolean state;
	private boolean needDisable = false;
	private long stepModeNext = 0;

	private JobInfo getOrCreateJobInfo(Job job) {
		synchronized (jobs) {
			JobInfo rv = jobs.get(job);
			if (rv == null) {
				rv = new JobInfo(job);
				JobsManager.getInstance().removeCanceled(job);
				if (TeslaFeatures.isActivityLogging()) {
					String msg = "waiting for job: "
							+ job.getClass().getName();
					System.out.println(msg);
					Q7LoggingManager.get("jobs").log(
							msg, null);
					ReportManager.appendLogExtra(msg);
				}
				jobs.put(job, rv);
			}
			return rv;
		}
	}

	public void aboutToRun(IJobChangeEvent event) {
	}

	public void awake(IJobChangeEvent event) {
		getOrCreateJobInfo(event.getJob()).awake();
	}

	public void done(IJobChangeEvent event) {
		JobsManager.getInstance().removeCanceled(event.getJob());
		synchronized (jobs) {
			boolean reschedule = TeslaSWTAccess.getJobEventReSchedule(event) && state;
			getOrCreateJobInfo(event.getJob()).done(reschedule);
			if (needDisable && isJoinEmpty()) {
				disable();
			}
			if (!reschedule)
				jobs.remove(event.getJob());
		}
	}

	public void running(IJobChangeEvent event) {
	}

	public void scheduled(IJobChangeEvent event) {
		if (!state) {
			return;
		}
		JobInfo jobInfo = getOrCreateJobInfo(event.getJob());
		jobInfo.scheduled(event.getDelay());
		if (JobStatus.REQUIRED.equals(jobInfo.status)) {
			if (event.getJob().belongsTo(TeslaSWTAccess.getDecoratorManagerFamily())) {
				JobsManager.getInstance().nulifyTime(event.getJob());
			}
			if (jobInfo.rescheduleCounter < TeslaLimits
					.getJobNullifyRescheduleMaxValue()) {
				JobsManager.getInstance().nulifyTime(event.getJob());
			}
		}
	}

	protected JobStatus calcJobStatus(Job job, long delay) {
		return detectJobStatus(job, delay);
	}

	private static final Set<String> IGNORED_BY_DEFAULT = Collections.unmodifiableSet(
			new HashSet<String>(
					asList(
							"org.eclipse.jdt.internal.core.search.processing.JobManager$1$ProgressJob",
							"org.eclipse.ui.internal.progress.ProgressViewUpdater$1",
							"org.eclipse.ui.internal.progress.WorkbenchSiteProgressService$SiteUpdateJob",
							"org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.RefreshProgressMessageJob",
							"org.eclipse.ui.dialogs.FilteredItemsSelectionDialog$RefreshProgressMessageJob",
							"org.eclipse.ui.internal.progress.AnimationManager$1",
							"org.eclipse.ui.internal.progress.ProgressManager$6",
							"org.eclipse.ui.internal.progress.TaskBarProgressManager$2",
							"org.eclipse.ui.internal.views.markers.CachedMarkerBuilder$1")));

	public static JobStatus detectJobStatus(Job job, long delay) {
		JobStatus status = null;
		IJobCollector[] collectors = JobCollectorExtensions.getDefault()
				.getCollectors();

		// Take first status
		for (IJobCollector cl : collectors) {
			JobStatus jobStatus = cl.testJob(job);
			if (jobStatus != null
					&& (!jobStatus.equals(JobStatus.UNKNOWN) && status == null)) {
				status = jobStatus;
				break;
			}
		}
		// Allow override some default
		if (status == null) {
			if ((delay < TeslaLimits.getJobWaitForDelayedTimeout())) {
				status = JobStatus.REQUIRED;
			}
			if (job.belongsTo(getFamilyAutoBuild())) {
				status = JobStatus.REQUIRED;
			}
			if (job.isUser()) {
				status = JobStatus.REQUIRED;
			}
			// if (TeslaSWTAccess.isDefferedTreeContentProvider(job)) {
			// status = JobStatus.REQUIRED;
			// }
			String jClassName = job.getClass().getName();
			if (IGNORED_BY_DEFAULT.contains(jClassName))
				status = JobStatus.IGNORED;
		}
		return status;
	}

	public void sleeping(IJobChangeEvent event) {
		getOrCreateJobInfo(event.getJob()).sleeping();
	}

	private static boolean isModal(Shell shell) {
		return PlayerWidgetUtils.isModal(shell);
	}

	private long lastSuccessTime = 0;

	private String getJobMessage(Job job) {
		return getJobMessage(getOrCreateJobInfo(job));
	}

	private String getJobMessage(JobInfo jobInfo) {
		Job job = jobInfo.job;
		StringBuilder msg = new StringBuilder();
		msg.append("Job: ").append(job.getName()).append("\n");

		msg.append("\tclass: ").append(job.getClass().getName()).append(" ")
				.append(DetailUtils.extractSupers(job.getClass())).append("\n");

		Long startTime = jobInfo.startingTime;

		long currentTimeMillis = System.currentTimeMillis();
		long time = 0;
		if (startTime != null) {
			time = currentTimeMillis - startTime.longValue();
		}

		msg.append("\tworking time: ").append(time).append("(ms)\n");
		msg.append("\tstate: ").append(job.getState()).append("\n");

		ISchedulingRule rule = job.getRule();
		if (rule != null) {
			if (rule instanceof IResource) {
				IPath location = ((IResource) rule).getLocation();
				msg.append("\trule is resource: ")
						.append(location != null ? location.toOSString() : "/")
						.append("\n");
			}
			else {
				msg.append("\trule: ").append(rule.toString()).append("\n");
			}
		}
		else {
			msg.append("\trule: Empty\n");
		}

		Thread thread = job.getThread();
		if (thread != null) {
			StackTraceElement[] trace = thread.getStackTrace();
			msg.append("\tstack trace: \n");
			// Print 5 lines of stack trace for job
			int c = 0;
			for (StackTraceElement stackTraceElement : trace) {
				if (c > 15) {
					msg.append("\t\t....");
					break;
				}
				c++;
				msg.append(
						"\t\t"
								+ stackTraceElement.getClassName()
								+ "."
								+ stackTraceElement.getMethodName()
								+ ":"
								+ stackTraceElement.getLineNumber()
								+ (stackTraceElement.getFileName() != null ? (" ["
										+ stackTraceElement
												.getFileName()
										+ "]")
										: ""))
						.append("\n");

			}
		}
		return msg.toString();
	}

	private boolean logReturnResult(boolean result, List<Job> realJobs,
			List<Job> jobsInUI, Q7WaitInfoRoot info) {
		try {
			long curTime = System.currentTimeMillis();
			if (result) {
				lastSuccessTime = curTime;
				return result;
			}
			for (Job job : jobsInUI) {
				Q7WaitUtils.updateInfo("job.ui", job.getClass().getName(), info);
			}
			for (Job job : realJobs) {
				Q7WaitUtils.updateInfo("job", job.getClass().getName(), info);
			}

			if (lastSuccessTime == 0) {
				lastSuccessTime = curTime;
				return result;
			}
			if (curTime - lastSuccessTime > TeslaLimits.getJobLoggingTimeout()) {
				lastSuccessTime = curTime;
				logJobInformation(realJobs, jobsInUI);
			}
		}
		catch (Exception e) {
			SWTTeslaActivator.log(e);
		}

		return result;
	}

	@SuppressWarnings("deprecation")
	static String getCurrentReportNodeName() {
		final String[] rv = new String[1];
		ReportManager.getCurrentReportNode().update(new Procedure1<Node>() {
			@Override
			public void apply(Node node) {
				rv[0] = node.getName();
			}
		});
		return rv[0];
	}

	private void logJobInformation(List<Job> realJobs, List<Job> jobsInUI) {
		List<Job> otherJobs = new ArrayList<Job>(jobs.keySet());
		Set<Job> jobInStepMode = new HashSet<Job>();
		for (Job job : otherJobs) {
			if (getOrCreateJobInfo(job).jobInStepMode)
				jobInStepMode.add(job);
		}
		otherJobs.removeAll(realJobs);
		otherJobs.removeAll(jobsInUI);
		otherJobs.removeAll(jobInStepMode);
		StringBuilder reportMessage = new StringBuilder();

		reportMessage.append("----->>> Waiting for Jobs during execution: ")
				.append(getCurrentReportNodeName())
				.append(" -----<<<< \n");

		if (realJobs.size() > 0) {
			reportMessage.append("---> Standalone Jobs:\n");
			for (Job job : realJobs) {
				reportMessage.append(getJobMessage(job)).append("\n");
			}
		}
		if (jobInStepMode.size() > 0) {
			reportMessage.append("---> Jobs in Stepping mode:\n");
			for (Job job : jobInStepMode) {
				reportMessage.append(getJobMessage(job)).append("\n");
			}
		}
		if (jobsInUI.size() > 0) {
			reportMessage.append("---> Jobs doing UI:\n");
			for (Job job : jobsInUI) {
				reportMessage.append(getJobMessage(job)).append("\n");
			}
		}
		if (otherJobs.size() > 0) {
			reportMessage.append("---> Other jobs:\n");
			for (Job job : otherJobs) {
				reportMessage.append(getJobMessage(job)).append("\n");
			}
		}
		SWTTeslaActivator.logToReport(reportMessage.toString());
	}

	public boolean isEmpty(Context context, Q7WaitInfoRoot info) {
		// Filter already executed UI jobs with async finish status.
		List<Job> realJobs = new ArrayList<Job>();
		long current = System.currentTimeMillis();
		boolean wasInStepMode = false;
		List<Job> jobsInUI = new ArrayList<Job>();
		synchronized (jobs) {
			// Remove all canceled jobs
			removeCanceledJobs();
			if (jobs.isEmpty()) {
				return logReturnResult(true, realJobs, jobsInUI, info);
			}
			for (JobInfo jobInfo : jobs.values()) {
				if (!jobInfo.isActive())
					continue;
				Job job = jobInfo.job;
				IJobCollector[] collectors = JobCollectorExtensions.getDefault()
						.getCollectors();
				boolean allowSkip = true;
				for (IJobCollector ext : collectors) {
					if (ext.noSkipMode(job)) {
						allowSkip = false;
						break;
					}
				}
				if (allowSkip) {
					continue;
				}
				// SWTTeslaActivator.debugLog("Waiting job:" + job.getName() + ": "
				// + job.getClass().getName());
				long jobStartTime = jobInfo.startingTime;

				if (job.getClass().getName().contains("org.eclipse.debug.internal.ui.DebugUIPlugin$")) {
					// It looks like background launching job.
					Thread thread = job.getThread();
					if (thread == null) {
						SWTTeslaActivator.logToReport("Active job " + job.getName() + " has no thread");
						jobInfo.done(false);
					}
					Context ctx = ContextManagement.makeContext(thread.getStackTrace());
					// If Autobuild job is active and on lock and there is Modal Dialog in main thread,
					// lets' skip job from important for us.
					if (ctx.contains("java.util.concurrent.locks.LockSupport",
							"park") || ctx.contains("java.lang.Object",
									"wait")) {
						// We are waiting some stuff, let's check if main thread have a MessageDialog and if so skip this job right now.
						if (context.contains("org.eclipse.jface.dialogs.MessageDialogWithToggle", "open") ||
								context.contains("org.eclipse.jface.dialogs.MessageDialog", "open")) {
							// Skip job from processing since it in lock and waits for a dialog.
							SWTTeslaActivator.logToReport("Active job " + job.getName() + " has skipped since it in lock state and Message dialog are active");
							continue;
						}
					}
				}

				if (jobInfo.checkForTimeout) {
					if (jobStartTime + TeslaLimits.getStepModeEnableTimeout() < current
							&& job.getState() == Job.RUNNING
							&& stepModeNext < current) {
						// Job is sleepping to long time already.
						// Check for job are slepping
						// String name = job.getClass().getName();
						// Locate thread
						Thread thread = job.getThread();
						if (thread == null) {
							SWTTeslaActivator.logToReport("Active job " + job.getName() + " has no thread");
							jobInfo.done(false);
						}
						Context ctx = ContextManagement.makeContext(thread.getStackTrace());
						// if (ctx.contains(
						// "org.eclipse.jface.operation.ModalContext$ModalContextThread",
						// "block")) {
						// // Skip model context, since it could
						// continue;
						// }

						if (ctx.contains("java.lang.Thread",
								"sleep")
								|| ctx.contains("java.lang.Object",
										"wait")) {
							/*
							 * Job are in Thread.sleep(), lets allow one operation.
							 */
							if (!jobInfo.jobInStepMode) {
								// Print step information
								SWTTeslaActivator
										.logToReport("---->>> Begin step mode for Job: "
												+ getCurrentReportNodeName()
												+ " <<---\n(skipping)"
												+ getJobMessage(jobInfo));
							}
							jobInfo.jobInStepMode = true;
							wasInStepMode = true;
							continue;
						}
					}

					long timeout = TeslaLimits.getJobTimeout();
					if (job.belongsTo(getFamilyAutoBuild())) {
						timeout = TeslaLimits.getAutoBuildJobTimeout();
					}
					if (jobInfo.jobInStepMode) {
						timeout = TeslaLimits.getStepModeTimeout();
					}
					if (job.getClass()
							.getName()
							.contains(
									"org.eclipse.debug.internal.ui.DebugUIPlugin")) {
						timeout = TeslaLimits.getDebugJobTimeout();
					}
					if (jobStartTime + timeout < current) {
						if (context != null
								&& TeslaEventManager.getManager()
										.isJobInSyncExec(job, context)) {
							// Remove from stop waited jobs if called sync
							// exec
							jobInfo.checkForTimeout = false;
						}
						else {
							printJobTimeoutLogEntry(job);
							continue;
						}
					}
				}
				if (context != null) {
					if (isAsyncSupported()) {
						// If we are executed from async finished job lets
						// filter it
						if (JobsManager.getInstance().isFinishedAsyncJob(job)) {
							if (context.containsClass(job.getClass().getName())) {
								jobsInUI.add(job);
								continue;
							}
						}
					}
					if (isSyncSupported()) {
						// Check for any other job running Display.sleep()
						if (context.contains(Display.class.getName(), "sleep")) {
							if (TeslaEventManager.getManager().isJobInSyncExec(
									job, context)) {
								// If and only if job is already in synchronizer
								Map<Thread, StackTraceElement[]> traces = Thread
										.getAllStackTraces();
								Set<String> names = getSuperClassNames(job);
								Thread jobThread = null;
								Context jobContext = null;
								for (Map.Entry<Thread, StackTraceElement[]> thread : traces
										.entrySet()) {
									Context ctx = ContextManagement
											.makeContext(thread.getValue());
									for (String name : names) {
										if (ctx.contains(
												"org.eclipse.core.internal.jobs.Worker",
												"run")
												&& ctx.contains(name, "run")) {
											jobThread = thread.getKey();
											jobContext = ctx;
										}
									}
								}
								if (jobThread != null && jobContext != null) {
									if (jobContext
											.contains(
													"org.eclipse.ui.internal.UISynchronizer",
													"syncExec")
											&& jobContext
													.contains(
															"org.eclipse.ui.internal.Semaphore",
															"acquire")) {
										if (!SWTUIPlayer
												.hasRunnables(PlatformUI
														.getWorkbench()
														.getDisplay())) {
											// also check what sync exec are on
											// current stack trace
											List<Context> execs = TeslaEventManager
													.getManager()
													.getSyncExecs();
											boolean toContinue = true;
											for (Context context2 : execs) {
												StackTraceElement[] stackTrace = context2
														.getStackTrace();
												String className = null;
												for (int i = 0; i < stackTrace.length; i++) {
													if (stackTrace[i]
															.getClassName()
															.equals("org.eclipse.swt.widgets.Display")
															&& stackTrace[i]
																	.getMethodName()
																	.equals("syncExec")) {
														className = stackTrace[i + 1]
																.getClassName();
														break;
													}
												}
												if (!context
														.containsClass(className)) {
													toContinue = false;
												}
											}
											if (toContinue) {
												jobsInUI.add(job);
												continue;
											}
										}
									}
								}
							}
						}
					}
				}
				if (jobInfo.isActive())
					realJobs.add(job);
			}
		}
		if (!jobsInUI.isEmpty()) {
			if (realJobs.size() == 1
					&& realJobs.get(0).belongsTo(getFamilyAutoBuild())) {
				realJobs.clear();
			}
		}
		if (realJobs.size() == 1) {
			Job job = realJobs.iterator().next();
			if (job.belongsTo(getFamilyAutoBuild())) {
				// Check for modal dialogs are visible
				int flags = TeslaSWTAccess.getJobFlags(job);
				// Job is alone and blocked
				if ((flags & 0xFF) == 0x08) {
					return logReturnResult(true, realJobs, jobsInUI, info);
				}
				final Display display = PlatformUI.getWorkbench().getDisplay();
				final boolean value[] = { false };
				display.syncExec(new Runnable() {

					public void run() {
						Shell[] shells = display.getShells();
						for (Shell shell : shells) {
							if (isModal(shell)) {
								value[0] = true;
							}
						}
					}
				});
				if (value[0]) {
					return logReturnResult(true, realJobs, jobsInUI, info);
				}
				if (job.getState() != Job.NONE) {
					return logReturnResult(false, realJobs, jobsInUI, info);
				}
				return logReturnResult(true, realJobs, jobsInUI, info);
			}
		}
		if (wasInStepMode && realJobs.isEmpty()) {
			stepModeNext = current + TeslaLimits.getStepModeStepTime();
		}
		return logReturnResult(realJobs.isEmpty(), realJobs, jobsInUI, info);
	}

	private void removeCanceledJobs() {
		synchronized (jobs) {
			for (JobInfo job : jobs.values()) {
				if (JobsManager.getInstance().isCanceled(job.job)) {
					job.cancel();
				}
			}
			List<Job> find = Arrays.asList(Job.getJobManager().find(null));
			for (Job job : jobs.keySet()) {
				if (!find.contains(job)) {
					getOrCreateJobInfo(job).cancel();
				}
			}
		}
	}

	private Set<String> getSuperClassNames(Job job) {
		Class<?> cl = job.getClass();
		Set<String> names = new HashSet<String>();
		while (true) {
			if (cl.equals(Job.class)) {
				break;
			}
			names.add(cl.getName());
			Class<?> superclass = cl.getSuperclass();
			if (superclass == null) {
				break;
			}
			cl = superclass;
		}
		return names;
	}

	private void printJobTimeoutLogEntry(Job job) {
		getOrCreateJobInfo(job).printJobTimeoutLogEntry();
	}

	protected boolean isSyncSupported() {
		return true;
	}

	protected boolean isAsyncSupported() {
		return true;
	}

	public void enable() {
		this.state = true;
		this.needDisable = false;
		// Add all current jobs to wait queue
		Job[] find = Job.getJobManager().find(null);
		for (Job job : find) {
			if ((job instanceof UIJob && job.getState() != Job.SLEEPING)
					|| job.belongsTo(getFamilyAutoBuild()) || job.isUser()) {
				JobStatus status = calcJobStatus(job, (long) 0);
				if (JobStatus.REQUIRED.equals(status)) {
					if (job.belongsTo(TeslaSWTAccess.getDecoratorManagerFamily())) {
						JobsManager.getInstance().nulifyTime(job);
					}
					JobInfo jobInfo = getOrCreateJobInfo(job);
					if (jobInfo.rescheduleCounter < TeslaLimits
							.getJobNullifyRescheduleMaxValue()) {
						JobsManager.getInstance().nulifyTime(job);
					}
				}
			}
		}
	}

	private static Object getFamilyAutoBuild() {
		try {
			return ResourcesPlugin.FAMILY_AUTO_BUILD;
		}
		catch (Throwable e) {
			// Skip
		}
		return UIJobCollector.class;
	}

	public void disable() {
		this.state = false;
		this.needDisable = false;
	}

	public void setNeedDisable() {
		this.needDisable = true;
	}

	public int getCount() {
		synchronized (jobs) {
			return jobs.size();
		}
	}

	public List<Job> getJobs() {
		synchronized (jobs) {
			ArrayList<Job> rv = new ArrayList<Job>();
			for (JobInfo info : jobs.values())
				if (info.isActive())
					rv.add(info.job);
			return rv;
		}
	}

	/**
	 * Wait untill will not be empty for timeout
	 * 
	 * @param timeout
	 * @throws InterruptedException
	 */
	public void join(long timeout) throws InterruptedException {
		SWTTeslaActivator.debugLog("UIJobCollector is going to join");
		long startTime = System.currentTimeMillis();
		// Context ctx = ContextManagement.currentContext();
		while (true) {
			removeCanceledJobs();
			long delta = System.currentTimeMillis() - startTime;
			if (delta > timeout) {
				break;
			}
			if (isJoinEmpty()) {
				break;
			}

			List<Job> jobs2 = getJobs();
			for (Job job : jobs2) {
				SWTTeslaActivator.debugLog("Waiting for job:" + job.getName() + " "
						+ job.getState());
			}
			SWTTeslaActivator.debugLog("UIJobCollector is going to join");
			Thread.sleep(50);
		}
	}

	private boolean isJoinEmpty() {
		List<Job> realJobs = new ArrayList<Job>();
		synchronized (jobs) {
			if (jobs.isEmpty()) {
				return true;
			}
			for (JobInfo jobInfo : jobs.values()) {
				if (!jobInfo.isActive())
					continue;
				Job job = jobInfo.job;
				Set<String> names = getSuperClassNames(job);

				// Locate thread
				Map<Thread, StackTraceElement[]> traces = Thread
						.getAllStackTraces();
				boolean toContinue = false;
				for (Map.Entry<Thread, StackTraceElement[]> thread : traces
						.entrySet()) {
					Context ctx = ContextManagement.makeContext(thread
							.getValue());
					for (String name : names) {
						if (ctx.contains(name, "run")
								|| ctx.contains(name, "runInUIThread")) {
							// Job already running
							if (ctx.contains("org.eclipse.swt.widgets.Display",
									"sleep")) {
								// Job are showing dialog. Skip waiting for such
								// job.
								toContinue = true;
								break;
							}
						}
					}
				}
				if (toContinue) {
					continue;
				}
				realJobs.add(job);
			}
		}
		if (realJobs.size() == 1) {
			Job job = realJobs.iterator().next();
			if (job.belongsTo(getFamilyAutoBuild())) {
				// Check for modal dialogs are visible
				int flags = TeslaSWTAccess.getJobFlags(job);
				// Job is alone and blocked
				if (flags == 0x08) {
					return true;
				}
			}
		}
		return realJobs.isEmpty();
	}

	public void clean() {
		synchronized (jobs) {
			jobs.clear();
			stepModeNext = 0;
		}
	}
}
