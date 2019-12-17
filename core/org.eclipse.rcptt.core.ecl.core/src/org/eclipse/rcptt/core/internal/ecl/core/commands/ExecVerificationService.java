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
package org.eclipse.rcptt.core.internal.ecl.core.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.VerificationsRuntime;
import org.eclipse.rcptt.core.ecl.core.model.ExecVerification;
import org.eclipse.rcptt.core.internal.ecl.core.Utils;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.reporting.core.RunnableWithStatus;

public class ExecVerificationService implements ICommandService {

	public IStatus service(Command command, final IProcess context) throws InterruptedException, CoreException {
		final ExecVerification execVerification = (ExecVerification) command;
		Verification verification = execVerification.getVerification();
		final Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
		info.setType(ItemKind.VERIFICATION);
		info.setId(verification.getId());
		info.setTags(verification.getTags());
		info.setSubtype(verification.getId());
		info.setPhase(execVerification.getPhase().toString());
		info.setDescription(verification.getDescription());
		RunnableWithStatus runnable = new RunnableWithStatus() {
			@Override
			public void run() throws CoreException {
				exec(execVerification, context);
			}
		};
		Utils.reportExecution(
				ReportManager.getCurrentReportNode(),
				runnable,
				verification.getName() == null ? "Unnamed verification" : verification.getName(),
				info
				);
		return Status.OK_STATUS;

	}

	public void exec(final ExecVerification execVerification, IProcess process) throws CoreException {
		final Verification verification = execVerification.getVerification();

		switch (execVerification.getPhase()) {
		case START:
			VerificationsRuntime.getInstance().executeStart(verification, process);
			break;
		case RUN:
			VerificationsRuntime.getInstance().executeRun(verification, process);
			break;
		case FINISH:
			VerificationsRuntime.getInstance().executeFinish(verification, process);
			break;
		case AUTO:
			final VerificationType type = VerificationTypeManager.getInstance().getTypeByVerification(verification);
			final String[] phases = type.getPhases();
			if (phases.length != 1)
				throw new CoreException(new Status(IStatus.ERROR,
						org.eclipse.rcptt.core.internal.ecl.core.Activator.PLUGIN_ID,
						"Failed to execute verification (phase auto-detection failed)."));

			String phase = phases[phases.length - 1];
			if (phase.equals(VerificationType.PHASE_START))
				VerificationsRuntime.getInstance().executeStart(verification, process);
			else if (phase.equals(VerificationType.PHASE_RUN))
				VerificationsRuntime.getInstance().executeRun(verification, process);
			else if (phase.equals(VerificationType.PHASE_FINISH))
				VerificationsRuntime.getInstance().executeFinish(verification, process);

			break;
		}
	}
}
