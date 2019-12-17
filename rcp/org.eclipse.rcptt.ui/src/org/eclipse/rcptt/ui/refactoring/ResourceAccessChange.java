/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.refactoring;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;

public class ResourceAccessChange extends Change {

	private IResource recource;
	private boolean makeWrittable;

	public ResourceAccessChange(IResource recource, boolean makeWrittable) {
		this.recource = recource;
		this.makeWrittable = makeWrittable;
	}

	@Override
	public String getName() {
		return Messages.bind(Messages.ResourceAccess_Message, recource.getFullPath());
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		RefactoringStatus result = new RefactoringStatus();
		checkExistence(result);
		return result;
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		try {
			pm.beginTask(getName(), 1);
			if (makeWrittable) {
				WriteAccessChecker.setWritable(recource, true);
				return new ResourceAccessChange(recource, false);
			} else {
				WriteAccessChecker.setWritable(recource, false);
				return new ResourceAccessChange(recource, true);
			}
		} finally {
			pm.done();
		}
	}

	@Override
	public Object getModifiedElement() {
		return recource;
	}

	private void checkExistence(RefactoringStatus status) {
		if (recource == null) {
			status.addFatalError("No input element provided");
		} else if (!recource.exists()) {
			status.addFatalError("\"" + recource.getFullPath() + "\" does not exist anymore.");
		}
	}
}
