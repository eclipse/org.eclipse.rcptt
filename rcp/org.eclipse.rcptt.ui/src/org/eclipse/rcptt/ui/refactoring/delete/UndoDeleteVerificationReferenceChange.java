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
package org.eclipse.rcptt.ui.refactoring.delete;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ProjectMetadata;
import org.eclipse.rcptt.internal.ui.Messages;

public class UndoDeleteVerificationReferenceChange extends
		AbstractDeleteVerificationReferenceChange {

	private final int index;

	public UndoDeleteVerificationReferenceChange(IQ7Element element,
			IFile elementFile, IVerification verification, String id, int index) {
		super(element, verification, id);
		this.index = index;
	}

	@Override
	public String getName() {
		return Messages.bind(Messages.UndoDeleteContextReferenceChange_Name,
				getVerification().getName(), getElement().getName());
	}

	protected final int getIndex() {
		return index;
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		if (!isValid()) {
			return RefactoringStatus
					.createFatalErrorStatus(Messages.UndoDeleteContextReferenceChange_InvalidRefMsg);
		}
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			IQ7NamedElement e = (IQ7NamedElement) getElement();
			IQ7NamedElement copy = e.getWorkingCopy(new NullProgressMonitor());
			try {
				List<String> references = getVerificationReferences(copy);
				references.add(getIndex(), getVerificationId());

				if (copy instanceof ITestCase) {
					((ITestCase) copy).setVerifications(references
							.toArray(new String[references.size()]));
				} else if (copy instanceof IQ7ProjectMetadata) {
					NamedElement namedElement = copy.getNamedElement();
					if (namedElement instanceof ProjectMetadata) {
						ProjectMetadata meta = (ProjectMetadata) namedElement;
						meta.getVerifications().clear();
						meta.getVerifications().addAll(references);
					}
				}

				copy.commitWorkingCopy(true, new NullProgressMonitor());
				return new DeleteVerificationReferenceChange(getElement(),
						getVerification(), getVerificationId());
			} finally {
				copy.discardWorkingCopy();
			}
		} finally {
			pm.done();
		}
	}
}
