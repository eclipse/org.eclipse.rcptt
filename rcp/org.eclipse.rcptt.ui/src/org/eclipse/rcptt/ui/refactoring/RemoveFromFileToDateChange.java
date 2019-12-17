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
package org.eclipse.rcptt.ui.refactoring;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;

import org.eclipse.rcptt.internal.core.WorkspaceMonitor;
import org.eclipse.rcptt.internal.ui.Messages;

public class RemoveFromFileToDateChange extends ResourceChange {

	private final IFile file;

	public RemoveFromFileToDateChange(IFile file) {
		this.file = file;
	}

	@Override
	protected IResource getModifiedResource() {
		return file;
	}

	@Override
	public String getName() {
		return Messages.bind(Messages.RemoveFromFileToDateChange_Name, file.getName());
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		Long stamp = WorkspaceMonitor.getInstance().removeFromFileToDate(file);
		return new UndoRemoveFromFileToDateChange(file, stamp);
	}

	private class UndoRemoveFromFileToDateChange extends ResourceChange {
		private final IFile file;
		private final Long timestamp;

		public UndoRemoveFromFileToDateChange(IFile file, Long timestamp) {
			this.file = file;
			this.timestamp = timestamp;
		}

		@Override
		protected IResource getModifiedResource() {
			return file;
		}

		@Override
		public String getName() {
			return Messages.bind(Messages.RemoveFromFileToDateChange_UndoName, file.getName());
		}

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			if (timestamp != null) {
				WorkspaceMonitor.getInstance().addToFileToDate(file, timestamp);
			}
			return new RemoveFromFileToDateChange(file);
		}
	}
}
