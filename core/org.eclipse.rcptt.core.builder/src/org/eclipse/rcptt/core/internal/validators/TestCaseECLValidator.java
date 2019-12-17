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
package org.eclipse.rcptt.core.internal.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.rcptt.ecl.core.Script;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class TestCaseECLValidator implements IQ7Validator {

	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		if (!(element instanceof ITestCase))
			return;
		if (element.exists()) {
			try {
				Scenario scenario = (Scenario) ((ITestCase) element)
						.getNamedElement();
				if (scenario != null) {
					Script ecl = Scenarios.getEcl(scenario);
					if (ecl != null && ecl.getContent() != null) {
						String eclCode = ecl.getContent();
						ScriptValidator.validateErrors(eclCode, reporter, (IFile) element.getResource());
						ScriptValidator.validateWarnings(eclCode, reporter, (IFile) element.getResource());
					}
				}
			} catch (Throwable e) {
				if (e instanceof IllegalArgumentException) {
					// Pass
				} else {
					RcpttPlugin.log(e);
				}
			}
		}
	}

	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
		ScriptValidator.validateErrors(eclCode, reporter, null);
		ScriptValidator.validateWarnings(eclCode, reporter, null);
	}

}
