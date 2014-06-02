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

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.internal.ui.Messages;

public class UndoDeleteTestReferenceChange extends
		AbstractDeleteTestReferenceChange {

	private final Map<Integer, TestSuiteItem> deletedItems;

	protected UndoDeleteTestReferenceChange(ITestSuite testSuite,
			IQ7NamedElement q7Element, Map<Integer, TestSuiteItem> deletedItems) {
		super(testSuite, q7Element);
		this.deletedItems = deletedItems;
	}

	@Override
	public String getName() {
		return Messages.bind(Messages.UndoDeleteContextReferenceChange_Name,
				getQ7Element().getName(), getTestSuite().getName());
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		if (!isValid()) {
			return RefactoringStatus
					.createFatalErrorStatus(Messages.UndoDeleteReferenceChange_InvalidRefMsg);
		}
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			ITestSuite suiteCopy = (ITestSuite) getTestSuite().getWorkingCopy(
					new NullProgressMonitor());
			try {
				for (Entry<Integer, TestSuiteItem> entry : deletedItems
						.entrySet()) {
					suiteCopy.getTestSuite().getItems()
							.add(entry.getKey(), entry.getValue());
				}
				suiteCopy.commitWorkingCopy(true, new NullProgressMonitor());
			} finally {
				suiteCopy.discardWorkingCopy();
			}
			return new DeleteTestReferenceChange(getTestSuite(), getQ7Element());
		} finally {
			pm.done();
		}
	}

}
