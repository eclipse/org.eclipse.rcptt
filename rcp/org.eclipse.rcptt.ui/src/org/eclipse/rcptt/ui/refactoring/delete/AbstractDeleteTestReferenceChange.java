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
package org.eclipse.rcptt.ui.refactoring.delete;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;

public abstract class AbstractDeleteTestReferenceChange extends Change {

	private final ITestSuite testSuite;
	private final IQ7NamedElement q7Element;

	protected AbstractDeleteTestReferenceChange(ITestSuite testSuite,
			IQ7NamedElement q7Element) {
		this.testSuite = testSuite;
		this.q7Element = q7Element;
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
	}

	@Override
	public Object getModifiedElement() {
		return testSuite.getResource();
	}

	protected ITestSuite getTestSuite() {
		return testSuite;
	}

	protected IQ7NamedElement getQ7Element() {
		return q7Element;
	}

	protected boolean isValid() throws ModelException {
		if (testSuite == null || q7Element == null)
			return false;
		if (!(q7Element instanceof ITestCase || q7Element instanceof ITestSuite))
			return false;
		return true;
	}

}
