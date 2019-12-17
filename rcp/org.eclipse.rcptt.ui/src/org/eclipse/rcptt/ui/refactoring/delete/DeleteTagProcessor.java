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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteProcessor;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.osgi.util.NLS;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.refactoring.RefactoringUtils;

public class DeleteTagProcessor extends DeleteProcessor {

	private List<Tag> tags;

	public DeleteTagProcessor(List<Tag> tags) {
		if (tags == null || tags.size() == 0) {
			throw new IllegalArgumentException("Tags must not be null or empty"); //$NON-NLS-1$
		}
		this.tags = tags;
	}

	public List<Tag> getTags() {
		return tags;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * checkInitialConditions(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm)
			throws CoreException {
		for (Tag tag : tags) {
			RefactoringStatus status = RefactoringUtils.validateTagInSync(tag);
			if (!status.isOK())
				return status;
		}
		return new RefactoringStatus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
	 */
	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			// Do nothing
			return new RefactoringStatus();
		} finally {
			pm.done();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * createChange(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			CompositeChange composite = new CompositeChange(
					Messages.DeleteTagProcessor_ChangeName);
			for (Tag t : tags) {
				collectUpdates(composite, t);
			}
			return composite;
		} finally {
			pm.done();
		}
	}

	private List<IQ7NamedElement> collectUpdates(CompositeChange composite,
			Tag tag) {
		List<IQ7NamedElement> refs = new ArrayList<IQ7NamedElement>();
		synchronized (tag) {
			for (Tag t : tag.getTags()) {
				refs.addAll(collectUpdates(composite, t));
			}
		}
		String taskName;
		if (tag.getPath().equals(tag.getValue())) {
			taskName = NLS.bind(Messages.DeleteTagProcessor_TaskName,
					new Object[] { tag.getValue() });
		} else {
			taskName = NLS.bind(Messages.DeleteTagProcessor_TaskName_SubTag,
					new Object[] { tag.getValue(), tag.getPath() });
		}
		CompositeChange sub = new CompositeChange(taskName);
		composite.add(sub);
		synchronized (tag) {
			refs.addAll(tag.getRefs());
		}
		for (IQ7NamedElement e : refs) {
			sub.add(new DeleteTagReferenceChange(e, tag));
		}
		return refs;
	}

	@Override
	public String getIdentifier() {
		return "org.eclipse.rcptt.ui.refactoring.delete.deleteTagProcessor"; //$NON-NLS-1$
	}

	@Override
	public String getProcessorName() {
		return Messages.DeleteTagProcessor_ProcessorName;
	}

	@Override
	public boolean isApplicable() {
		return true;
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants shared) throws CoreException {
		return new RefactoringParticipant[0];
	}

	@Override
	public Object[] getElements() {
		return tags.toArray();
	}

}
