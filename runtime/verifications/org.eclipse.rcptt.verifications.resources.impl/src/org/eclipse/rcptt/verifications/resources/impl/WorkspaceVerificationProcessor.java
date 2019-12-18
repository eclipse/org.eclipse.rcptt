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
package org.eclipse.rcptt.verifications.resources.impl;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.core.VerificationProcessor;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.resources.impl.WSRunnables;
import org.eclipse.rcptt.resources.impl.WSCaptureUtils;
import org.eclipse.rcptt.workspace.WorkspaceFactory;
import org.eclipse.rcptt.workspace.WorkspaceVerification;

public class WorkspaceVerificationProcessor extends VerificationProcessor {

	@Override
	public Verification create(EObject param, IProcess process) throws CoreException {
		final WorkspaceVerification verification = WorkspaceFactory.eINSTANCE
				.createWorkspaceVerification();
		final IWorkspace ws = ResourcesPlugin.getWorkspace();

		WSCaptureUtils.capture(ws, verification);
		return verification;
	}

	@Override
	public void finish(Verification verification, Object data, IProcess process) throws CoreException {
		final WorkspaceVerification wc = (WorkspaceVerification) verification;
		final IWorkspace ws = ResourcesPlugin.getWorkspace();

		ws.run(WSRunnables.refreshWorkspace, null, IWorkspace.AVOID_UPDATE, null);

		ws.run(new IWorkspaceRunnable() {
			public void run(final IProgressMonitor monitor) throws CoreException {
				new WorkspaceVerificationChecker(wc).verifyWorkspace();
			}
		}, null, IWorkspace.AVOID_UPDATE, null);
	}

}
