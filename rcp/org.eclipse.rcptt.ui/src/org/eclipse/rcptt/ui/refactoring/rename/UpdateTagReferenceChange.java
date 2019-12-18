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
package org.eclipse.rcptt.ui.refactoring.rename;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.refactoring.RefactoringUtils;

public class UpdateTagReferenceChange extends Change {

	private final IQ7NamedElement element;
	private final String newTagName;
	private final String oldTagName;

	public UpdateTagReferenceChange(IQ7NamedElement element, String oldTagName,
			String newTagName) {
		Assert.isNotNull(element);
		Assert.isNotNull(oldTagName);
		Assert.isNotNull(newTagName);
		this.element = element;
		this.oldTagName = oldTagName;
		this.newTagName = newTagName;
	}

	@Override
	public String getName() {
		return NLS.bind(Messages.UpdateTagReferenceChange_Name, new Object[] {
				oldTagName, RefactoringUtils.elementToString(element) });
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		try {
			pm.beginTask(getName(), 1);
			String tags = element.getTags();
			String newTags = tags;
			Matcher matcher = Pattern.compile(",\\s*(" + oldTagName + ")") //$NON-NLS-1$ //$NON-NLS-2$
					.matcher(tags);
			while (matcher.find()) {
				int index = matcher.start(1);
				newTags = newTags.substring(0, index)
						+ newTagName
						+ newTags.substring(index + oldTagName.length(),
								newTags.length());
			}
			matcher = Pattern.compile("\\s*(" + oldTagName + ")").matcher(tags); //$NON-NLS-1$ //$NON-NLS-2$
			if (matcher.lookingAt()) {
				int index = matcher.start(1);
				newTags = newTags.substring(0, index)
						+ newTagName
						+ newTags.substring(index + oldTagName.length(),
								newTags.length());
			}
			IQ7NamedElement elementWc = element.getWorkingCopy(pm);
			try {
				elementWc.setTags(newTags);
				elementWc.commitWorkingCopy(true, pm);
			} finally {
				elementWc.discardWorkingCopy();
			}
			return new UpdateTagReferenceChange(element, newTagName, oldTagName);
		} finally {
			pm.done();
		}
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// Nothing
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		if (!element.getTags().contains(oldTagName)) {
			return RefactoringStatus.createFatalErrorStatus(NLS.bind(
					Messages.UpdateTagReferenceChange_InvalidStateMsg,
					RefactoringUtils.elementToString(element), oldTagName));
		}
		return new RefactoringStatus();
	}

	@Override
	public Object getModifiedElement() {
		return element;
	}
}
