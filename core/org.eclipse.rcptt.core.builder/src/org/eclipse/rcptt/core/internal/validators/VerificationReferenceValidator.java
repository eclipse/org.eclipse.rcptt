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
package org.eclipse.rcptt.core.internal.validators;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class VerificationReferenceValidator implements IQ7Validator {

	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		try {
			IQ7Project project = element.getQ7Project();

			IQ7ProjectMetadata md = element.getQ7Project().getMetadata();
			List<String> defaultVerifications = null;
			if (md != null && md.exists()) {
				String[] verifications = md.getVerifications();
				if (verifications != null) {
					defaultVerifications = Arrays.asList(verifications);
				}
			}
			if (element instanceof ITestCase) {
				try {
					String[] verifications = Q7SearchCore
							.findVerificationsByDocument(element);
					if (verifications == null)
						verifications = ((ITestCase) element).getVerifications();

					if (verifications != null) {
						for (String vid : verifications) {
							reportProjectVerificationUsed(element, reporter, defaultVerifications,
									vid);
							List<IVerification> verification = project.find(IVerification.class, vid);
							if (verification.size() == 0) {
								reportUnresolved(element, reporter, vid);
							}
						}
					}
				} catch (ModelException e) {
					RcpttPlugin.log(e);
				}
			} else if (element instanceof IQ7ProjectMetadata) {
				String[] verifications = Q7SearchCore
						.findVerificationsByDocument(element);
				if (verifications == null)
					verifications = ((IQ7ProjectMetadata) element).getVerifications();
				if (verifications != null) {
					for (String vid : verifications) {
						List<IVerification> verification = project.find(IVerification.class, vid);
						if (verification.size() == 0)
							reportUnresolved(element, reporter, vid);
					}
				}
			}
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
	}

	private void reportProjectVerificationUsed(IQ7NamedElement element,
			IQ7ProblemReporter reporter, List<String> defaultVerifications, String vid) {
		if (defaultVerifications != null && defaultVerifications.contains(vid)) {
			String name = vid;
			try {
				List<IVerification> located = element.getQ7Project().find(IVerification.class, vid);
				if (located != null && located.size() == 1) {
					name = located.get(0).getElementName();
				}
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}

			reporter.reportProblem((IFile) element.getResource(),
					ProblemType.Warning, "Referenced verification \"" + name
							+ "\" is included as default verification for project: "
							+ element.getQ7Project().getName()
							+ " and will be ignored.", 0, 0, 0, 0);
		}
	}

	private void reportUnresolved(IQ7NamedElement element,
			IQ7ProblemReporter reporter, String vid) {
		reporter.reportProblem((IFile) element.getResource(),
				ProblemType.Error, "Unresolved verification:" + vid, 0, 0, 0, 0);
	}

	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}
}
