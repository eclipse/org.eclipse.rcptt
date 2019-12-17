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
package org.eclipse.rcptt.ui.internal.resources;

import static org.eclipse.rcptt.ui.utils.ModelUtils.loadVerification;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.resources.ui.WSValidators;
import org.eclipse.rcptt.workspace.WorkspaceContext;

public class WorkspaceContextContentValidator implements IQ7Validator {

	public WorkspaceContextContentValidator() {
	}

	@Override
	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		if (element instanceof IVerification) {
			IVerification verification = (IVerification) element;
			WorkspaceContext ctx = loadVerification(verification, WorkspaceContext.class);
			if (ctx == null)
				return;
			WSValidators.validateContent(
					ctx,
					verification, reporter,
					SubMonitor.convert(monitor).newChild(1, SubMonitor.SUPPRESS_BEGINTASK));
		}
	}

	@Override
	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}

}
