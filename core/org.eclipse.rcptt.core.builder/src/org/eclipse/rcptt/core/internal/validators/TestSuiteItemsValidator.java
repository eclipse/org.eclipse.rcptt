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
package org.eclipse.rcptt.core.internal.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7ProblemReporter.ProblemType;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;

public class TestSuiteItemsValidator implements IQ7Validator {

	private static String getName(TestSuiteItem item) {
		return item.getNamedElemetName() != null ? item.getNamedElemetName() : item.getNamedElementId();
	}

	public void validate(IQ7NamedElement element, IQ7ProblemReporter reporter,
			IProgressMonitor monitor) {
		if (!(element instanceof ITestSuite))
			return;
		ITestSuite suite = (ITestSuite) element;
		try {
			ISearchScope scope = getSearchScope(suite);
			for (TestSuiteItem test : suite.getItems()) {
				IQ7NamedElement q7Element = Q7SearchCore.getTestSuiteItemElement(test, scope);
				if (q7Element == null) {
					reporter.reportProblem(
							(IFile) suite.getResource(),
							ProblemType.Error,
							"Test " + getName(test) + " not found for test suite: " + element.getName(), 0, 0, 0, 0);
				}
			}
		} catch (Exception e) {
			reporter.reportProblem(
					(IFile) element.getResource(),
					ProblemType.Error,
					"Bad test suite: " + e.getMessage(), 0, 0, 0, 0);
		}
	}

	private static ISearchScope getSearchScope(ITestSuite suiteModel) {
		IQ7Project testSuiteProject = suiteModel.getQ7Project();
		ISearchScope scope = testSuiteProject != null ? new ReferencedProjectScope(
				testSuiteProject) : new AllProjectScope();
		return scope;
	}

	public void reconcile(IQ7NamedElement content, String eclCode,
			IQ7ProblemReporter reporter, IProgressMonitor nullProgressMonitor) {
	}

}
