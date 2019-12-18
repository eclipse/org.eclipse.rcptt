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
package org.eclipse.rcptt.ui.resources.viewers;

import static org.eclipse.rcptt.ui.utils.ModelUtils.loadContext;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.resources.ui.WSValidators;
import org.eclipse.rcptt.workspace.WorkspaceContext;

public class WorkspaceLinksValidator implements IQ7Validator {

	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		try {
			if (element instanceof IContext) {
				IContext context = (IContext) element;
				WorkspaceContext ctx = loadContext(context,
						WorkspaceContext.class);
				if (ctx == null)
					return;
				WSValidators.validateLinks(ctx, (IFile) element.getResource(), reporter, SubMonitor.convert(monitor));
			}
		} catch (Throwable e) {
			RcpttPlugin.log(e);
		}
	}

	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}

}
