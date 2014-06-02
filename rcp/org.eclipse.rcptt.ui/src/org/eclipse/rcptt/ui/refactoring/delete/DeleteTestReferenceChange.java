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
package org.eclipse.rcptt.ui.refactoring.delete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.internal.ui.Messages;

public class DeleteTestReferenceChange extends
		AbstractDeleteTestReferenceChange {

	protected DeleteTestReferenceChange(ITestSuite testSuite,
			IQ7NamedElement q7Element) {
		super(testSuite, q7Element);
	}

	@Override
	public String getName() {
		return Messages.bind(Messages.DeleteContextReferenceChange_Name,
				getQ7Element().getName(), getTestSuite().getName());
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		if (!isValid()) {
			return RefactoringStatus
					.createFatalErrorStatus(Messages.DeleteReferenceChange_InvalidRefMsg);
		}
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			ITestSuite suiteCopy = (ITestSuite) getTestSuite().getWorkingCopy(
					new NullProgressMonitor());
			List<TestSuiteItem> references = getReferences(suiteCopy);
			Map<Integer, TestSuiteItem> deletedItems = new HashMap<Integer, TestSuiteItem>();
			for (TestSuiteItem item : references) {
				int idx = suiteCopy.getTestSuite().getItems().indexOf(item);
				deletedItems.put(idx, item);
			}
			try {
				TestSuite suiteNamedElement = (TestSuite) suiteCopy
						.getModifiedNamedElement();
				for (TestSuiteItem item : references) {
					suiteNamedElement.getItems().remove(item);
				}
				suiteCopy.commitWorkingCopy(true, new NullProgressMonitor());
			} finally {
				suiteCopy.discardWorkingCopy();
			}
			return new UndoDeleteTestReferenceChange(getTestSuite(),
					getQ7Element(), deletedItems);
		} finally {
			pm.done();
		}
	}

	private List<TestSuiteItem> getReferences(ITestSuite suite)
			throws ModelException {
		List<TestSuiteItem> result = new ArrayList<TestSuiteItem>();
		for (TestSuiteItem item : suite.getTestSuite().getItems()) {
			if (getQ7Element().getID().equals(item.getNamedElementId())) {
				result.add(item);
			}
		}
		return result;
	}

	@Override
	protected boolean isValid() throws ModelException {
		if (!super.isValid())
			return false;
		return getReferences(getTestSuite()).size() > 0;
	}

}
