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
package org.eclipse.rcptt.core.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;

public class SameIDValidator implements IQ7Validator {

	public SameIDValidator() {
	}

	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		try {
			String id = null;// element.getID();
			id = Q7SearchCore.findIDByDocument(element);
			if (id == null) {
				id = element.getID();
			}
			IQ7NamedElement[] elements = Q7SearchCore
					.findById(id,
							new ReferencedProjectScope(element.getQ7Project()),
							monitor);
			if (elements != null && elements.length > 1) {
				StringBuilder ress = new StringBuilder();
				// for (IQ7NamedElement iq7NamedElement : elements) {
				// if (ress.length() > 0) {
				// ress.append(", ");
				// }
				// ress.append(iq7NamedElement.getPath().toString());
				// }
				reporter.reportProblem((IFile) element.getResource(),
						ProblemType.Error, "Duplicate IDs are detected: " + id
								+ ress.toString(), 1, 0, 0, 0);
			}
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
	}

	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}
}
