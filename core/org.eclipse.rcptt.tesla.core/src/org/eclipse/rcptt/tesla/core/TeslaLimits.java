/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core;

public class TeslaLimits {
	private static final String TIMER_EXECS_WAIT = "timer.execs.wait";
	private static final String TIMER_EXECS_SKIP = "timer.execs.skip.after";

	private static final String TIMER_EXECS_TOTAL_WAIT = "timer.execs.total.wait";
	private static final String TIMER_EXECS_TOTAL_WAIT_STEP = "timer.execs.total.wait.step";

	private static final String TIMER_EXECS_WAIT_NULLIFY = "timer.execs.wait.nullify";
	private static final String JOB_DEBUGJOB_TIMEOUT = "job.debugjob.timeout";
	private static final String JOB_STEPMODE_STEP_TIME = "job.sleeping.step.time";
	private static final String JOB_STEPMODE_TIMEOUT = "job.sleeping.step.timeout";
	private static final String JOB_STEPMODE_ENABLE_TIMEOUT = "job.treat.as.sleeping.timeout";

	private static final String JOB_NULIFY_IF_NOT_RESCHEDULED = "job.nulify.reschedule.max.value";
	private static final String CONTEXTS_WAITFORJOBS_TIMEOUT = "contexts.waitforjobs.timeout";
	private static final String UIJOB_JOB_TIMEOUT = "uijob.hang.timeout";
	private static final String AUTOBUILD_JOB_TIMEOUT = "autobuild.job.hang.timeout";

	private static final String CONTEXT_RUNNABLE_TIMEOUT = "context.runnable.timeout";

	private static final String UIJOB_WAIT_FOR_DELAYED_TIMEOUT_TYPO = "uijob.scheldule.delayed.maxtime";
	private static final String UIJOB_WAIT_FOR_DELAYED_TIMEOUT = "uijob.schedule.delayed.maxtime";
	private static final String TIMEOUTS = "Runtime Limits";
	public static final String AUT_STARTUP_TIMEOUT = "uijob.aut.startup.timeout";
	public static final String JOB_LOGGING_TIMEOUT = "job.logging.timeout";
	public static final String JFACE_RECONCILER_TIMEOUT = "jface.reconciler.timeout";

	public static void init(TeslaFeatures o) {

		o.addReplace(UIJOB_WAIT_FOR_DELAYED_TIMEOUT_TYPO, UIJOB_WAIT_FOR_DELAYED_TIMEOUT);
		o.intOption(AUT_STARTUP_TIMEOUT, 10 * 60).category(TIMEOUTS)
				.name("Time RCPTT wait for AUT application to startup (sec)")
				.showIn(TeslaFeatures.ADV_OPTIONS);

		o.intOption(CONTEXT_RUNNABLE_TIMEOUT, 3 * 60 * 1000).category(TIMEOUTS)
				.name("Context operation runnable timeout (ms)")
				.showIn(TeslaFeatures.ADV_OPTIONS);

		o.intOption(UIJOB_JOB_TIMEOUT, 30 * 1000)
				.category(TIMEOUTS)
				.name("Job Hang Skip timeout (ms)")
				.description(
						"Timeout then RCPTT will deside to stop waiting for job")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(1);
		o.intOption(JOB_LOGGING_TIMEOUT, 10)
				.category(TIMEOUTS)
				.name("Log waiting for job if exceed (sec)")
				.description(
						"Timeout then RCPTT will add information entry to Eclipse log")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(1);
		o.intOption(AUTOBUILD_JOB_TIMEOUT, 3 * 60 * 1000)
				.category(TIMEOUTS)
				.name("AutoBuild Job Hang Skip timeout (ms)")
				.description(
						"Timeout then RCPTT will deside to stop waiting for autobuild job")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(1);

		o.intOption(JOB_STEPMODE_ENABLE_TIMEOUT, 10 * 1000)
				.category(TIMEOUTS)
				.name("Enable step mode for job after timeout (job in Thread.sleep, Object.wait)")
				.description(
						"If job executes more then (ms). And calling Thread.sleep() or Object.wait(). RCPTT will try to continue execution in step mode")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(2);
		o.intOption(JOB_STEPMODE_STEP_TIME, 200)
				.category(TIMEOUTS)
				.name("Step mode: One Step every (ms)")
				.description(
						"If job executes more then (ms). And calling Thread.sleep() or Object.wait(). RCPTT will try to continue execution")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(3);
		o.intOption(JOB_STEPMODE_TIMEOUT, 120 * 1000).category(TIMEOUTS)
				.name("Step mode: Step mode timeout (ms)")
				.description("Allow step mode only for specified time")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(4);

		o.intOption(UIJOB_WAIT_FOR_DELAYED_TIMEOUT, 600).category(TIMEOUTS)
				.name("Wait for delayed jobs with delay less then (ms)")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(5);
		o.intOption(CONTEXTS_WAITFORJOBS_TIMEOUT, 60 * 1000).category(TIMEOUTS)
				.name("Wait jobs completion after context apply (ms)")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(6);

		o.intOption(JOB_NULIFY_IF_NOT_RESCHEDULED, 50)
				.category(TIMEOUTS)
				.name("Delayed jobs scheduled with delay 0, if not rescheduled more then (times)")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(7);

		o.intOption(JOB_DEBUGJOB_TIMEOUT, 5 * 60 * 1000).category(TIMEOUTS)
				.name("Timeout for background Debug plugin launch Job")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(8);
		o.intOption(TIMER_EXECS_WAIT, 250)
				.category(TIMEOUTS)
				.name("Wait for timerExecs (ms) (0 is disabled state)\n(skip org.eclipse.swt, org.eclipse.get packages)")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(9);
		o.intOption(TIMER_EXECS_SKIP, 5000)
				.category(TIMEOUTS)
				.name("Wait for timerExecs (ms) rescheduling for no more then time in ms")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(9);
		o.intOption(TIMER_EXECS_WAIT_NULLIFY, 100).category(TIMEOUTS)
				.name("Nullify timerExec if time is less then (ms)")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(10);

		o.intOption(TIMER_EXECS_TOTAL_WAIT, 30000)
				.category(TIMEOUTS)
				.name("Wait for timerExecs (ms) no more timeout and then do a step mode\nwith step timeout")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(9);
		o.intOption(TIMER_EXECS_TOTAL_WAIT_STEP, 2000)
				.category(TIMEOUTS)
				.name("Step timeout for Timer Exec total timeout")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(9);

		o.intOption(JFACE_RECONCILER_TIMEOUT, 10000)
				.category(TIMEOUTS)
				.name("JFace Viewer Reconciling Timeout (ms)")
				.showIn(TeslaFeatures.ADV_OPTIONS).order(11);

	}

	public static int getTimerExecsWait() {
		return getIntValue(TIMER_EXECS_WAIT);
	}

	public static int getTimerExecsSkip() {
		return getIntValue(TIMER_EXECS_SKIP);
	}

	public static int getTimerExecsTotalWaitTime() {
		return getIntValue(TIMER_EXECS_TOTAL_WAIT);
	}

	public static int getTimerExecsTotalWaitTimeStep() {
		return getIntValue(TIMER_EXECS_TOTAL_WAIT_STEP);
	}

	public static int getTimerExecsWaitNullify() {
		return getIntValue(TIMER_EXECS_WAIT_NULLIFY);
	}

	public static int getJobNullifyRescheduleMaxValue() {
		return getIntValue(JOB_NULIFY_IF_NOT_RESCHEDULED);
	}

	public static int getJobTimeout() {
		return getIntValue(UIJOB_JOB_TIMEOUT);
	}

	public static int getAutoBuildJobTimeout() {
		return getIntValue(AUTOBUILD_JOB_TIMEOUT);
	}

	public static int getContextRunnableTimeout() {
		return getIntValue(CONTEXT_RUNNABLE_TIMEOUT);
	}

	public static int getJobWaitForDelayedTimeout() {
		return getIntValue(UIJOB_WAIT_FOR_DELAYED_TIMEOUT);
	}

	private static int getIntValue(String id) {
		return Integer.parseInt(TeslaFeatures.getInstance().getOption(id)
				.getValue());
	}

	public static long getContextJoinTimeout() {
		return getIntValue(CONTEXTS_WAITFORJOBS_TIMEOUT);
	}

	public static int getStepModeEnableTimeout() {
		return getIntValue(JOB_STEPMODE_ENABLE_TIMEOUT);
	}

	public static int getStepModeStepTime() {
		return getIntValue(JOB_STEPMODE_STEP_TIME);
	}

	public static int getStepModeTimeout() {
		return getIntValue(JOB_STEPMODE_TIMEOUT);
	}

	public static long getDebugJobTimeout() {
		return getIntValue(JOB_DEBUGJOB_TIMEOUT);
	}

	public static int getAUTStartupTimeout() {
		return getIntValue(AUT_STARTUP_TIMEOUT) * 1000;
	}

	public static long getJobLoggingTimeout() {
		return getIntValue(JOB_LOGGING_TIMEOUT) * 1000;
	}

	public static long getReconcilerTimeout() {
		return getIntValue(JFACE_RECONCILER_TIMEOUT);
	}
}
