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
package org.eclipse.rcptt.ecl.perf.tests;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.perf.ConstrainMax;
import org.eclipse.rcptt.ecl.perf.MeasureTime;
import org.eclipse.rcptt.ecl.perf.PerfCounter;
import org.eclipse.rcptt.ecl.perf.PerfFactory;
import org.eclipse.rcptt.ecl.perf.StartTimeMeasure;
import org.eclipse.rcptt.ecl.perf.StopTimeMeasure;
import org.eclipse.rcptt.ecl.runtime.EclRuntime;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;
import org.junit.Assert;
import org.junit.Test;

public class TimePerfTest extends TestCase {

	@Test
	public void testSimple() throws CoreException, InterruptedException {
		ISession session = createSession();

		StartTimeMeasure start = PerfFactory.eINSTANCE.createStartTimeMeasure();
		start.setLabel("foo");
		IProcess process = session.execute(start);
		IStatus result = process.waitFor();
		Assert.assertTrue(result.isOK());

		StopTimeMeasure stop = PerfFactory.eINSTANCE.createStopTimeMeasure();
		stop.setLabel("foo");
		process = session.execute(stop);
		result = process.waitFor();
		Assert.assertTrue(result.isOK());

		Object fromPipe = process.getOutput().take(1000);
		Assert.assertTrue(fromPipe instanceof PerfCounter);

		PerfCounter counter = (PerfCounter) fromPipe;
		Assert.assertEquals("foo", counter.getName());
		System.out.println(counter.getDuration());

		session.close();
	}

	@Test
	public void testMeasureTime() throws CoreException, InterruptedException {
		ISession session = createSession();

		MeasureTime measureTime = PerfFactory.eINSTANCE.createMeasureTime();
		measureTime.setLabel("bar");

		PerfCounter fake = PerfFactory.eINSTANCE.createPerfCounter();
		fake.setName("fake_name");
		fake.setDuration(42);

		ConstrainMax fakeCommand = PerfFactory.eINSTANCE.createConstrainMax();
		fakeCommand.setCounter(fake);
		fakeCommand.setValue(100);

		measureTime.setDo(fakeCommand);

		IProcess process = session.execute(measureTime);
		IStatus status = process.waitFor();
		if (!status.isOK()) {
			status.getException().printStackTrace();
		}
		Assert.assertTrue(process.waitFor().isOK());

		Object fromPipe = process.getOutput().take(1000);
		Assert.assertTrue(fromPipe instanceof PerfCounter);

		PerfCounter counter = (PerfCounter) fromPipe;
		Assert.assertEquals("bar", counter.getName());
		System.out.println(counter.getDuration());
		session.close();
	}

	private static ISession createSession() {
		return EclRuntime.createSession();
	}
}
