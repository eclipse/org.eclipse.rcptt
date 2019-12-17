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
package org.eclipse.rcptt.internal.launching.ecl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.internal.launching.ExecutionStatus;
import org.eclipse.rcptt.internal.launching.VerificationExecutable;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.tesla.core.TeslaLimits;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;

public class EclVerificationExecutable extends VerificationExecutable {

	public EclVerificationExecutable(AutLaunch launch, IVerification verification,
			boolean debug, ExecutionPhase phase) {
		super(launch, verification, debug, phase);
	}

	protected void doExecuteVerification(IProgressMonitor monitor) throws CoreException {
		launch.run(getActualElement(), TeslaLimits.getContextRunnableTimeout(), monitor, getPhase());
	}

	@Override
	protected IStatus doExecute() throws CoreException, InterruptedException {
		try {
			doExecuteVerification(executionMonitor);
			return Status.OK_STATUS;
		} catch (CoreException e) {
			IStatus status = e.getStatus();
			if (status instanceof ScriptErrorStatus) {
				ScriptErrorStatus ses = (ScriptErrorStatus) status;
				ExecutionStatus es = new ExecutionStatus(status.getSeverity(),
						status.getPlugin(), ses.getLine(), ses.getColumn(),
						ses.getLength());
				es.setElement(element);
				IStatus cause = ses.getCause();
				if (cause != null) {
					es.add(cause);
					if (cause instanceof TeslaErrorStatus) {
						TeslaErrorStatus tes = (TeslaErrorStatus) cause;
						es.setAdvancedInfo(tes.getInfo());
					}
				}
				return es;
			}
			return status;
		}
	}

	@Override
	public String toString() {
		return "Verification: " + getActualElement();
	}

}
