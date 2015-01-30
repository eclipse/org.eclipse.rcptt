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
package org.eclipse.rcptt.internal.launching;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.internal.ecl.core.Utils;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;

public class UnresolvedVerificationExecutable extends VerificationExecutable {

	public UnresolvedVerificationExecutable(AutLaunch launch, IVerification verification,
			boolean debug, ExecutionPhase phase) {
		super(launch, verification, debug, phase);
	}

	@Override
	protected IStatus doExecute() throws CoreException, InterruptedException {
		Map<String, EObject> props = new HashMap<String, EObject>();

		Q7Info info = ReportHelper.createInfo();
		info.setResult(Utils.createStatus(IStatus.ERROR, "Verification is unresolved"));
		info.setType(ItemKind.VERIFICATION);
		props.put(IQ7ReportConstants.ROOT, info);

		ReportMaker.beginReportNode(getName(), props, launch);
		ReportMaker.endReportNode(false, launch);
		return new Status(Status.ERROR, Q7LaunchingPlugin.PLUGIN_ID,
				"Verification could not be resolved:" + getName());
	}

}
