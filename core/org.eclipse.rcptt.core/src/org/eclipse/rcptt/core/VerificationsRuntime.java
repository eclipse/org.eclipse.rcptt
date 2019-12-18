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
package org.eclipse.rcptt.core;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class VerificationsRuntime {

	private static VerificationsRuntime instance;

	public static VerificationsRuntime getInstance() {
		if (instance == null)
			instance = new VerificationsRuntime();
		return instance;
	}

	private final HashMap<String, Object> data = new HashMap<String, Object>();

	public void resetVerifications() {
		data.clear();
	}

	public void executeStart(Verification verification, IProcess process) throws CoreException {
		final IVerificationProcessor processor = getProcessor(verification);
		data.put(verification.getId(), processor.start(verification, process));
	}

	public void executeRun(Verification verification, IProcess process) throws CoreException {
		final IVerificationProcessor processor = getProcessor(verification);
		data.put(verification.getId(),
				processor.run(verification, data.get(verification.getId()), process));
	}

	public void executeFinish(Verification verification, IProcess process) throws CoreException {
		final IVerificationProcessor processor = getProcessor(verification);
		processor.finish(verification, data.get(verification.getId()), process);
	}

	private static IVerificationProcessor getProcessor(Verification verification) throws CoreException {
		VerificationType type = VerificationTypeManager.getInstance().getTypeByVerification(verification);
		if (type == null)
			throw new CoreException(
					RcpttPlugin.createStatus("Failed to locate type for verification:"
							+ verification.getId()));

		IVerificationProcessor processor = VerificationTypeManager.getInstance().getProcessor(type.getId());
		if (processor == null)
			throw new CoreException(
					RcpttPlugin.createStatus("Failed to locate processor for verification:"
							+ verification.getId()));

		return processor;
	}
}
