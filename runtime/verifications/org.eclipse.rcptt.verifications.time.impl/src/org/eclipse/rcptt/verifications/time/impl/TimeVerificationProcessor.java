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
package org.eclipse.rcptt.verifications.time.impl;

import java.util.Date;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.VerificationProcessor;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.internal.core.AbstractSession;
import org.eclipse.rcptt.ecl.internal.core.DeclarationContainer;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.util.MathUtils;
import org.eclipse.rcptt.verifications.time.TimeVerification;

public class TimeVerificationProcessor extends VerificationProcessor {

	private static final String START_KEY = TimeVerificationProcessor.class.getName() + "_start";
	private static final String RUN_KEY = TimeVerificationProcessor.class.getName() + "_run";

	@Override
	public Object start(Verification verification, IProcess process) throws CoreException {
		putTime(process, START_KEY);
		return null;
	}

	private static void putTime(IProcess process, String key) throws CoreException {
		Val val = CoreFactory.eINSTANCE.createVal();
		val.setName(key);
		val.setValue(BoxedValues.box(new Date().getTime()));
		getGlobals(process).declare(val.getName(), val);
	}

	private static Date getDate(IProcess process, final String key) {
		long startTime = (Long) BoxedValues.unbox((((Val) getGlobals(process)
				.lookup(key)).getValue()));
		return new Date(startTime);
	}

	@Override
	public Object run(Verification verification, Object data, IProcess process) throws CoreException {
		putTime(process, RUN_KEY);
		return null;
	}

	@Override
	public void finish(Verification verification, Object data, IProcess process) throws CoreException {
		final TimeVerification timeVerification = (TimeVerification) verification;

		final String key = timeVerification.isIncludeContexts() ? START_KEY : RUN_KEY;

		final Date start = getDate(process, key);

		double diff = (new Date().getTime() - start.getTime()) / 1000.0;
		double goal = timeVerification.getMinutes() * 60 +
				timeVerification.getSeconds();

		diff = MathUtils.round(diff, 2);
		goal = MathUtils.round(goal, 2);

		if (goal < diff)
			throw new CoreException(
					new Status(
							IStatus.ERROR,
							this.getClass().getPackage().getName(),
							String.format(
									"Verification '%s' failed. Expected test case execution time is %.2f second(s), but it was %.2f second(s).",
									verification.getName(), goal, diff)));
	}


	private static DeclarationContainer getGlobals(IProcess process) {
		return ((AbstractSession) process.getSession())
				.getRoot().getGlobals();
	}

}
