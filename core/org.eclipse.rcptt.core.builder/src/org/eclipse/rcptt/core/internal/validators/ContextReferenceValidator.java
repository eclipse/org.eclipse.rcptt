/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.internal.validators;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class ContextReferenceValidator implements IQ7Validator {

	public ContextReferenceValidator() {
	}

	@Override
	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		try {
			IQ7Project project = element.getQ7Project();

			IQ7ProjectMetadata md = element.getQ7Project().getMetadata();
			List<String> lctxs = null;
			if (md != null && md.exists()) {
				String[] ctxs = md.getContexts();
				if (ctxs != null) {
					lctxs = Arrays.asList(ctxs);
				}
			}
			if (element instanceof ITestCase) {
				try {
					String[] contexts = Q7SearchCore
							.findContextsByDocument(element);
					if (contexts == null) {
						contexts = ((ITestCase) element).getContexts();
					}

					if (contexts != null) {
						// Check for project default contexts.

						for (String cid : contexts) {
							reportProjectContextUsed(element, reporter, lctxs,
									cid);
							List<IContext> context = project.find(IContext.class, cid);
							if (context.size() == 0) {
								reportUnresolved(element, reporter, cid);
							}
						}
					}
				} catch (ModelException e) {
					RcpttPlugin.log(e);
				}
			} else if (element instanceof IContext) {
				for (String cid : RcpttCore.getInstance().getContextReferences((IContext) element)) {
					reportProjectContextUsed(element, reporter, lctxs, cid);
					List<IContext> contexts = project.find(IContext.class, cid);
					if (contexts.isEmpty()) {
						reportUnresolved(element, reporter, cid);
					}
				}
			} else if (element instanceof IQ7ProjectMetadata) {
				String[] contexts = Q7SearchCore
						.findContextsByDocument(element);
				if (contexts == null)
					contexts = ((IQ7ProjectMetadata) element).getContexts();
				if (contexts != null) {
					for (String cid : contexts) {
						List<IContext> context = project.find(IContext.class, cid);
						if (context.size() == 0)
							reportUnresolved(element, reporter, cid);
					}
				}
			}

		} catch (Throwable e) {
			TeslaCore.log(e);
		}
	}

	private void reportProjectContextUsed(IQ7NamedElement element,
			IQ7ProblemReporter reporter, List<String> lctxs, String cid) {
		if (lctxs != null && lctxs.contains(cid)) {
			String name = cid;
			try {
				List<IContext> located = element.getQ7Project().find(IContext.class, cid);
				if (located != null && located.size() == 1) {
					name = located.get(0).getElementName();
				}
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}

			reporter.reportProblem((IFile) element.getResource(),
					ProblemType.Warning, "Referenced context \"" + name
							+ "\" is included as default context for project: "
							+ element.getQ7Project().getName()
							+ " and will be ignored.", 0, 0, 0, 0);
		}
	}

	private void reportUnresolved(IQ7NamedElement element,
			IQ7ProblemReporter reporter, String cid) {
		reporter.reportProblem((IFile) element.getResource(),
				ProblemType.Error, "Unresolved context:" + cid, 0, 0, 0, 0);
	}

	@Override
	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}
}
