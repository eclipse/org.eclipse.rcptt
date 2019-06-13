/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.test;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.internal.ui.player.UIJobCollector;
import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Closer;

public class UIJobCollectorTest {
	private static final int schedulingTolerance = 500;
	private static final IJobManager MANAGER = Job.getJobManager();
	private final Closer closer = Closer.create();
	private final Job sleepingJob = Job.create("sleep", (ICoreRunnable)monitor -> {
		while (!monitor.isCanceled()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new AssertionError(e);
			}
		}
	});
	private final Job oscillatingJob = Job.create("oscillating", (ICoreRunnable)monitor -> {
		long step = 500;
		while (!monitor.isCanceled()) {
			try {
				Thread.sleep(step);
				long stop = System.currentTimeMillis() + step;
				while (System.currentTimeMillis() < stop && !monitor.isCanceled())
					Thread.yield();
			} catch (InterruptedException e) {
				throw new AssertionError(e);
			}
		}
	});
	
	private final Job busyLoop = Job.create("busyloop", (ICoreRunnable)monitor -> {
		debug("Busyloop - start");
		while (!monitor.isCanceled()) {
			Thread.yield();
		}
		debug("Busyloop - end");
	});

	{
		sleepingJob.setPriority(Job.INTERACTIVE);
		oscillatingJob.setPriority(Job.INTERACTIVE);
	}

	@Before
	public void waitForAllJobs() throws InterruptedException {
		Display display = Display.getCurrent();
		while (display.readAndDispatch()) {
		}
		UIJobCollector subject = new UIJobCollector();
		MANAGER.addJobChangeListener(subject);
		try {
			subject.enable();
			boolean found = true;
			while (found) {
				idle();
				found = MANAGER.find(org.eclipse.ui.internal.decorators.DecoratorManager.FAMILY_DECORATE).length > 0
						|| !isEmpty(subject);
			}
		} finally {
			MANAGER.removeJobChangeListener(subject);
		}
	}

	private void idle() {
		Display display = Display.getCurrent();
		int sleepTime = schedulingTolerance / 10;
		try {
			if (display != null) {
				long stop = System.currentTimeMillis() + sleepTime;
				while (display.readAndDispatch() || System.currentTimeMillis() < stop) {
					Thread.sleep(1);
				}
			} else {
				Thread.sleep(sleepTime);
			}
		} catch (InterruptedException e) {
			throw new AssertionError(e);
		}
	}

	@Test
	public void emptyWhenNoJobs() {
		UIJobCollector subject = new UIJobCollector();
		addListener(subject);
		subject.enable();
		Assert.assertTrue(isEmpty(subject));
	}

	@Test
	public void stepMode() throws InterruptedException {
		Parameters parameters = new Parameters();
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		long start = System.currentTimeMillis();
		sleepingJob.schedule();
		Assert.assertFalse("Should not step immediately", isEmpty(subject));
		sleepUntil(start + parameters.stepModeStartDelay - schedulingTolerance);
		Assert.assertFalse("Should not step until delay", isEmpty(subject));
		join(subject, System.currentTimeMillis() - start + parameters.stepModeStartDelay);
		Assert.assertFalse("Should not step twice", isEmpty(subject));
		Thread.sleep(parameters.stepModeStepInterval + schedulingTolerance);
		Assert.assertTrue("Should step after step interval", isEmpty(subject));
	}
	
	@Test
	public void waitSecondRunAfterReschedule() throws InterruptedException {
		Parameters parameters = new Parameters();
		parameters.timeout = 60000;
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		Job job = busyLoop;
		for (int i = 0; i < 100; i++) {
			job.cancel();
			job.join();
			join(subject, 10000);
			CountDownLatch startedOnce = new CountDownLatch(1);
			CountDownLatch completedOnce = new CountDownLatch(1);
			IJobChangeListener jobListener = new JobChangeAdapter() {
				@Override
				public void scheduled(IJobChangeEvent event) {
					super.scheduled(event);
					debug("Scheduled");
				}
				@Override
				public void running(IJobChangeEvent event) {
					super.running(event);
					debug("Running");
					startedOnce.countDown();
				}
				@Override
				public void done(IJobChangeEvent event) {
					super.done(event);
					debug("Done");
					completedOnce.countDown();
				}
			};
			addListener(job, jobListener);
			System.out.printf("Attempt %d\n", i);
			Assert.assertTrue("No jobs on start", isEmpty(subject));
			job.schedule();
			startedOnce.await();
			job.cancel();
			job.schedule();
			completedOnce.await();
			boolean result = isEmpty(subject);
			Assert.assertFalse("Should not step immediately", result);
			Assert.assertNotEquals(Job.NONE, job.getState());
			System.out.printf("End of attempt %d\n", i);
			job.removeJobChangeListener(jobListener);
			job.cancel();
		}
	}
	
	
	
	public void waitForCancelledJobs() throws InterruptedException {
		Parameters parameters = new Parameters();
		parameters.timeout = 60000;
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		CountDownLatch startedOnce = new CountDownLatch(1);
		IJobChangeListener jobListener = new JobChangeAdapter() {
			@Override
			public void running(IJobChangeEvent event) {
				super.running(event);
				startedOnce.countDown();
			}
		};
		Job job = Job.create("ignoringCancel", (ICoreRunnable)monitor -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new AssertionError(e);
				}
		});
		
		closeJobAfterTest(job);
		
		addListener(job, jobListener);
		job.schedule();
		startedOnce.await();
		job.cancel();
		boolean result = isEmpty(subject);
		Assert.assertNotEquals(Job.NONE, job.getState());
		Assert.assertFalse("Should not step immediately", result);
	}
	
	

	private void prepare(UIJobCollector subject) {
		addListener(subject);
		subject.enable();
		idle(); // Waiting for irrelevant jobs to start
		join(subject, 10000); // Waiting for irrelevant jobs to complete
	}

	@Test
	public void stepAfterDelay() throws InterruptedException {
		Parameters parameters = new Parameters();
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		sleepingJob.schedule();
		idle();
		Assert.assertFalse("Should not step immediately", isEmpty(subject));
		join(subject, parameters.stepModeStartDelay);
	}
	
	@Test
	public void stepRepeatedly() {
		Parameters parameters = new Parameters();
		parameters.stepModeStartDelay = 1;
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		sleepingJob.schedule();
		idle();
		int expected = 7;
		int waitTime = parameters.stepInterval() * expected;
		Assert.assertTrue("This test relies on stepModeTimeout to be big enough", waitTime < parameters.stepModeTimeout);
		long stop = System.currentTimeMillis() + waitTime;
		int stepCount = 0;
		while (System.currentTimeMillis() < stop) {
			idle();
			join(subject, parameters.stepInterval());
			stepCount++;
		}
		Assert.assertTrue("Step count expected " +expected + " but was: " + stepCount, expected - 2 < stepCount && stepCount < expected + 2);
	}
	
	@Test
	public void abortStepMode() throws InterruptedException {
		Parameters parameters = new Parameters();
		parameters.stepModeStartDelay = parameters.stepInterval();
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		long sleepTime = parameters.stepModeStartDelay() + parameters.stepInterval() * 2;
		Job job = Job.create("runaway", (ICoreRunnable)monitor -> {
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				throw new AssertionError(e);
			}
			// We slept for a while, and now are working indefinitely.
			while (!monitor.isCanceled()) {}
		});
		job.setPriority(Job.INTERACTIVE);
		closeJobAfterTest(job);
		job.schedule();
		join(subject, parameters.stepInterval());
		join(subject, parameters.stepInterval());
		Thread.sleep(sleepTime);
		Assert.assertFalse(isEmpty(subject)); // Job is recognized as running now, steps should no longer happen
		join(subject, parameters.timeout);
	}


	@Test
	public void doNotStepTwice() throws InterruptedException {
		Parameters parameters = new Parameters();
		UIJobCollector subject = new UIJobCollector(parameters);
		addListener(subject);
		subject.enable();
		sleepingJob.schedule();
		join(subject, parameters.stepModeStartDelay);
		Assert.assertFalse("Should not step twice", isEmpty(subject));
	}

	@Test
	public void respectStepModeTimeout() {
		Parameters parameters = new Parameters();
		parameters.stepModeTimeout = parameters.timeout;
		UIJobCollector subject = new UIJobCollector(parameters);
		prepare(subject);
		sleepingJob.schedule();
		long stop = System.currentTimeMillis() + parameters.stepModeTimeout;
		while (System.currentTimeMillis() < stop) {
			idle();
			isEmpty(subject);
		}

		// Do not block after timeout
		while (System.currentTimeMillis() < stop + parameters.stepModeStepInterval * 10) {
			idle();
			Assert.assertTrue(isEmpty(subject));
		}

	}

	@Test
	public void stepInSyncExec() {
		Parameters parameters = new Parameters();
		parameters.stepModeStartDelay = schedulingTolerance * 3;
		parameters.stepModeStepInterval = schedulingTolerance;
		UIJobCollector subject = new UIJobCollector(parameters);
		addListener(subject);
		MessageDialog dialog = new MessageDialog(null, "hello", null, "press X", 0, 0, new String[] { "X" });
		Display display = Objects.requireNonNull(Display.getCurrent());
		Job closeDialog = Job.create("close dialog", monitor -> {
			while (!monitor.isCanceled() && dialog.getShell() == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new AssertionError(e);
				}
			}
			if (monitor.isCanceled())
				return;
			join(subject, parameters.stepModeStartDelay);
			dialog.getShell().getDisplay().syncExec(dialog::close);
		});
		closeJobAfterTest(closeDialog);
		closeDialog.schedule();
		Job showDialog = Job.create("show dialog", monitor -> {
			long start = System.currentTimeMillis();
			display.syncExec(() -> dialog.open());
			Assert.assertTrue(System.currentTimeMillis() < start + parameters.stepModeStartDelay + schedulingTolerance);
		});
		closeJobAfterTest(showDialog);
		showDialog.schedule();
		while (dialog.getShell() != null) {
			idle();
		}
		join(subject, parameters.stepModeStartDelay);
	}

	@After
	public void after() throws IOException {
		closeJobAfterTest(sleepingJob);
		closeJobAfterTest(oscillatingJob);
		closeJobAfterTest(busyLoop);
		closer.close();
	}

	private void join(UIJobCollector subject, long timeout) {
		long stop = System.currentTimeMillis() + timeout + schedulingTolerance;
		while (System.currentTimeMillis() < stop) {
			idle();
			long moment = System.currentTimeMillis();
			if (isEmpty(subject))
				return;
		}
		throw new AssertionError("timeout");
	}

	private void sleepUntil(long moment) {
		while (System.currentTimeMillis() < moment) {
			idle();
		}
	}

	private static boolean isEmpty(UIJobCollector subject) {
		return subject.isEmpty(new org.eclipse.rcptt.tesla.core.context.ContextManagement.Context(),
				InfoFactory.eINSTANCE.createQ7WaitInfoRoot());
	}

	private void addListener(IJobChangeListener listener) {
		MANAGER.addJobChangeListener(listener);
		closer.register(() -> MANAGER.removeJobChangeListener(listener));
	}
	
	private void addListener(Job job, IJobChangeListener listener) {
		job.addJobChangeListener(listener);
		closer.register(() -> job.removeJobChangeListener(listener));
	}

	private void closeJobAfterTest(Job job) {
		closer.register(() -> cancel(job));

	}

	private void cancel(Job job) {
		job.cancel();
		if (job.getState() == Job.NONE)
			return;
		try {
			for (int i = 0; i < 10000 && !job.join(1, null); i++) {
				idle();
			}
			if (!job.join(1, null)) {
				throw new TimeoutException("Job " + job.getName() + " failed to complete");
			}
			IStatus result = job.getResult();
			if (result.matches(IStatus.WARNING | IStatus.ERROR)) {
				throw new CoreException(result);
			}
		} catch (Throwable e) {
			throw new AssertionError("Job " + job.getName() + " failed to complete", e);
		}
	}

	private final class Parameters implements UIJobCollector.IParameters {
		public int stepModeStepInterval = schedulingTolerance;
		public int stepModeStartDelay = stepModeStepInterval * 2;
		public int timeout = stepModeStartDelay * 5;
		public int stepModeTimeout = timeout * 2;

		@Override
		public int stepModeStartDelay() {
			return stepModeStartDelay;
		}

		@Override
		public int stepInterval() {
			return stepModeStepInterval;
		}

		@Override
		public int stepModeTimeout() {
			return stepModeTimeout;
		}

		@Override
		public int timeout() {
			return timeout;
		}

	}
	
	private void debug(String message) {
		System.out.printf("Junit Test: %s\n", message);
	}

}
