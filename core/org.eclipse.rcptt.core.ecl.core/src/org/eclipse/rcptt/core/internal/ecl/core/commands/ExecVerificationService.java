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
package org.eclipse.rcptt.core.internal.ecl.core.commands;

import static org.eclipse.rcptt.reporting.core.ReportHelper.addSnapshotWithData;
import static org.eclipse.rcptt.reporting.core.ReportHelper.setInfo;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.VerificationsRuntime;
import org.eclipse.rcptt.core.ecl.core.model.ExecVerification;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.internal.core.TeslaProcessorManager;
import org.eclipse.rcptt.tesla.internal.core.info.GeneralInformationCollector;
import org.eclipse.rcptt.verifications.runtime.VerificationReporter;
import org.eclipse.rcptt.verifications.runtime.VerificationStatus;
import org.eclipse.swt.widgets.Display;

public class ExecVerificationService implements ICommandService {

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		ExecVerification execVerification = (ExecVerification) command;
		Verification verification = execVerification.getVerification();
		final INodeBuilder node = ReportManager.getCurrentReportNode().beginTask(verification.getName() == null ? "Unnamed verification"
				: verification.getName());
		final Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
		info.setType(ItemKind.VERIFICATION);
		info.setId(verification.getId());
		info.setTags(verification.getTags());
		info.setSubtype(verification.getId());
		info.setPhase(execVerification.getPhase().toString());
		try {
			exec(execVerification, context);
			if (node != null) {
				info.setResult(ResultStatus.PASS);
			}
		} catch (Throwable e) {
			if (node != null) {
				info.setResult(ResultStatus.FAIL);
				if (e instanceof CoreException
						&& ((CoreException) e).getStatus() instanceof VerificationStatus) {
					VerificationStatus st = (VerificationStatus) ((CoreException) e).getStatus();
					info.setMessage(VerificationReporter.getStyledMessage(st).getMessage());
				} else {
					info.setMessage(e.getMessage());
				}
				info.setDescription(verification.getDescription());
			}
			boolean processed = false;
			if (e instanceof CoreException
					&& ((CoreException) e).getStatus() instanceof ScriptErrorStatus) {
				ScriptErrorStatus sest = (ScriptErrorStatus) ((CoreException) e)
						.getStatus();
				if (sest.getCause() instanceof TeslaErrorStatus) {
					TeslaErrorStatus tes = (TeslaErrorStatus) sest.getCause();
					AdvancedInformation advancedInfo = tes.getInfo();
					if (advancedInfo != null) {
						addSnapshotWithData(node, advancedInfo);
						processed = true;
					}
				}
			}
			if (!processed) {
				final AdvancedInformation information = InfoFactory.eINSTANCE
						.createAdvancedInformation();
				try {
					final boolean infoCollected[] = { false };
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							new TeslaProcessorManager().collectInformation(information, null);
							infoCollected[0] = true;
						}
					});
					long waitStart = System.currentTimeMillis();
					while (!infoCollected[0]
							&& (System.currentTimeMillis() - waitStart) < 15000) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException eee) {
							// Ignore
						}
					}
				} catch (Throwable eee) {
					// ignore
				}
				GeneralInformationCollector.collectInformation(information);
				addSnapshotWithData(node, information);
			}
			if (e instanceof CoreException) {
				throw (CoreException) e;
			} else {
				throw new CoreException(new Status(IStatus.ERROR,
						org.eclipse.rcptt.core.internal.ecl.core.Activator.PLUGIN_ID,
						"Failed to execute verification: " + e.getMessage(), e));
			}

		} finally {
			setInfo(node, info);
			node.endTask();
		}
		return Status.OK_STATUS;

	}

	public void exec(final ExecVerification execVerification, IProcess process) throws InterruptedException,
			CoreException {
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
