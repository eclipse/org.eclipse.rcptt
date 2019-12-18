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
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ProjectMetadata;
import org.eclipse.rcptt.internal.ui.Messages;

public class DeleteVerificationReferenceChange extends
		AbstractDeleteVerificationReferenceChange {

	public DeleteVerificationReferenceChange(IQ7Element element, IVerification verification,
			String id) {
		super(element, verification, id);
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			IQ7NamedElement e = (IQ7NamedElement) getElement();
			IQ7NamedElement copy = null;
			try {
				copy = e.getWorkingCopy(new NullProgressMonitor());

				List<String> references = getVerificationReferences(copy);
				int index = references.indexOf(getVerificationId());
				if (index != -1) {
					references.remove(index);
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
					return new UndoDeleteVerificationReferenceChange(getElement(),
							(IFile) (getElement().getResource()), getVerification(),
							getVerificationId(), index);
				}
			} finally {
				copy.discardWorkingCopy();
			}
			return null;
		} finally {
			pm.done();
		}
	}

	@Override
	public String getName() {
		return Messages.bind(Messages.DeleteContextReferenceChange_Name,
				getVerification().getName(), getElement().getName());
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		if (!isValid()) {
			return RefactoringStatus
					.createFatalErrorStatus(Messages.DeleteContextReferenceChange_InvalidRefMsg);
		}
		return new RefactoringStatus();
	}

	@Override
	protected boolean isValid() throws ModelException {
		if (!super.isValid())
			return false;
		IQ7NamedElement element = (IQ7NamedElement) getElement();
		IQ7NamedElement copy = null;
		try {
			copy = element.getWorkingCopy(new NullProgressMonitor());
			List<String> references = getVerificationReferences(copy);
			return references.contains(getVerificationId());
		} finally {
			copy.discardWorkingCopy();
		}
	}
}
