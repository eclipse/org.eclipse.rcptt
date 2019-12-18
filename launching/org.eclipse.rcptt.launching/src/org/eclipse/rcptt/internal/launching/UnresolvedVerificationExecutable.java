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
package org.eclipse.rcptt.internal.launching;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;

import com.google.common.collect.ImmutableMap;

public class UnresolvedVerificationExecutable extends VerificationExecutable {

	public UnresolvedVerificationExecutable(AutLaunch launch, IVerification verification,
			boolean debug, ExecutionPhase phase) {
		super(launch, verification, debug, phase);
	}

	@Override
	protected IStatus doExecute() throws CoreException, InterruptedException {
		Verification verification = (Verification) getActualElement().getModifiedNamedElement();
		Q7Info info = ReportHelper.createInfo();
		info.setType(ItemKind.VERIFICATION);
		info.setTags(verification.getTags());
		info.setId(verification.getId());
		info.setDescription(verification.getDescription());
		Map<String, EObject> props = ImmutableMap.<String, EObject> of(IQ7ReportConstants.ROOT, info);

		ReportMaker.beginReportNode(getName(), props, launch);
		ReportMaker.endReportNode(false, launch,
				RcpttPlugin.createProcessStatus(IStatus.ERROR, "Verification is unresolved"));
		return new Status(IStatus.ERROR, Q7LaunchingPlugin.PLUGIN_ID,
				"Verification could not be resolved:" + getName());
	}

}
