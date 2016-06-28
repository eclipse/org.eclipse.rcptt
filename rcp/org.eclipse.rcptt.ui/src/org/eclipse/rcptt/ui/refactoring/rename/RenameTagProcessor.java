/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.refactoring.rename;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.refactoring.RefactoringUtils;
import org.eclipse.rcptt.ui.refactoring.ResourceAccessChange;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;

public class RenameTagProcessor extends RenameProcessor {

	private Tag tag;
	private String newTagName;

	public RenameTagProcessor(Tag tag) {
		if (tag == null) {
			throw new IllegalArgumentException("Tag must not be null"); //$NON-NLS-1$
		}
		this.tag = tag;
		setNewTagName(tag.getValue());
	}

	public String getNewTagName() {
		return newTagName;
	}

	public Tag getTag() {
		return tag;
	}

	public void setNewTagName(String newName) {
		Assert.isNotNull(newName);
		newTagName = newName;
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm)
			throws CoreException {
		return RefactoringUtils.validateTagInSync(tag);
	}

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

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException {
		pm.beginTask("", 1); //$NON-NLS-1$
		try {
			String taskName;
			synchronized (tag) {
				if (tag.getPath().equals(tag.getValue())) {
					taskName = NLS.bind(Messages.RenameTagProcessor_TaskName,
							tag.getValue());
				} else {
					taskName = NLS.bind(
							Messages.RenameTagProcessor_TaskName_SubTag,
							tag.getValue(), tag.getPath());
				}
				CompositeChange composite = new CompositeChange(taskName);

				String path = tag.getPath();
				int i = path.lastIndexOf(tag.getValue());
				String newPath = path.substring(0, i) + newTagName;
				for (IQ7NamedElement ref : tag.getRefs()) {
					if (WriteAccessChecker.isReadOnly(ref)) {
						composite.add(new ResourceAccessChange(ref.getResource(), true));
					}
					composite.add(new UpdateTagReferenceChange(ref, tag
							.getPath(), newPath));
				}
				collectUpdates(composite, tag.getTags(), tag.getPath(), newPath);
				return composite;
			}
		} finally {
			pm.done();
		}
	}

	private void collectUpdates(CompositeChange composite, List<Tag> tags,
			String oldPath, String newPath) {
		for (Tag t : tags) {
			String oldPath2 = t.getPath();
			String newPath2 = newPath
					+ oldPath2.substring(oldPath.length(), oldPath2.length());
			synchronized (t) {
				for (IQ7NamedElement ref : t.getRefs()) {
					if (WriteAccessChecker.isReadOnly(ref)) {
						composite.add(new ResourceAccessChange(ref.getResource(), true));
					}
					composite.add(new UpdateTagReferenceChange(ref, oldPath2,
							newPath2));
				}
				collectUpdates(composite, t.getTags(), oldPath2, newPath2);
			}
		}
	}

	@Override
	public String getIdentifier() {
		return "org.eclipse.rcptt.ui.refactoring.rename.renameTagProcessor"; //$NON-NLS-1$
	}

	@Override
	public String getProcessorName() {
		return Messages.RenameTagProcessor_ProcessorName;
	}

	@Override
	public boolean isApplicable() {
		return tag != null;
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants shared) throws CoreException {
		return new RefactoringParticipant[0];
	}

	@Override
	public Object[] getElements() {
		return new Object[] { tag };
	}

	public RefactoringStatus validateNewTagName(String text) {
		if (text == null || text.length() == 0) {
			return RefactoringStatus.createFatalErrorStatus(""); //$NON-NLS-1$
		}
		if (text.equals(tag.getValue())) {
			return RefactoringStatus.createFatalErrorStatus(""); //$NON-NLS-1$
		}
		// for (Tag tag : Q7UIPlugin.getDefault().getTags().getTags()) {
		// if (text.equals(tag.getValue())) {
		// return RefactoringStatus
		// .createFatalErrorStatus("A tag with the this name already exist");
		// }
		// }
		return new RefactoringStatus();
	}

}
