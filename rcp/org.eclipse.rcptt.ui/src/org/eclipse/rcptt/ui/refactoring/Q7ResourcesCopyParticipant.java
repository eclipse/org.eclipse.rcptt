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
package org.eclipse.rcptt.ui.refactoring;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.CopyParticipant;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Messages;

public class Q7ResourcesCopyParticipant extends CopyParticipant {

	IResource element = null;
	IContainer source = null;

	@Override
	protected boolean initialize(Object element) {
		if (!(getArguments().getDestination() instanceof IContainer))
			return false;
		if (!(element instanceof IResource))
			return false;
		this.element = (IResource) element;
		final boolean[] rv = new boolean[] { false };
		try {
			this.element.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (Q7SearchCore.findIDByPath(resource.getFullPath()) != null) {
						rv[0] = true;
					}
					return !rv[0];
				}
			});
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		this.source = this.element.getParent();
		return rv[0];
	}

	@Override
	public String getName() {
		return Messages.Q7ResourcesCopyParticipant_Name;
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws OperationCanceledException {
		return new RefactoringStatus();
	}

	static abstract class UpdateIdChange extends ResourceChange {

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			IFile modifiedResource = getModifiedResource();
			assert modifiedResource.exists() : "Resource " + modifiedResource + " doesn't exists yet";
			assert modifiedResource != null;
			IQ7NamedElement newElement = (IQ7NamedElement) RcpttCore
					.create(modifiedResource);
			if (newElement == null) {
				throw new RuntimeException("Failed to load RCPTT element "
						+ modifiedResource);
			}
			IQ7NamedElement workingCopy = newElement.getWorkingCopy(pm);
			workingCopy.setID(EcoreUtil.generateUUID());
			workingCopy.commitWorkingCopy(false, pm);
			return null;
		}

		@Override
		public String getName() {
			return "ID update";
		}

		@Override
		public RefactoringStatus isValid(IProgressMonitor pm)
				throws CoreException, OperationCanceledException {
			return new RefactoringStatus();
		}
		@Override
		protected abstract IFile getModifiedResource();
	};

	class UpdateIdInCopiedFrom extends UpdateIdChange {
		private final IFile copiedFrom;

		public UpdateIdInCopiedFrom(IFile copiedFrom) {
			super();
			this.copiedFrom = copiedFrom;
		}

		String renamed(IResource res) {
			String newName = getArguments().getExecutionLog().getNewName(
					res);
			if (newName == null)
				newName = res.getName();
			return newName;
		}
		
		/** Returns relative destination path with all renamings applied */
		IPath changedPath(IResource sourceResource) {
			if (sourceResource.equals(source)) {
				return Path.EMPTY;
			}
			return changedPath(sourceResource.getParent()).append(renamed(sourceResource));
		}
		
		@Override
		protected IFile getModifiedResource() {
			IContainer destination = (IContainer) getArguments().getDestination();
			IFile target = (IFile) destination.getFile(changedPath(copiedFrom));
			assert target != null;
			return target;
		}
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		assert element != null;
		final CompositeChange rv = new CompositeChange("Update ids");
		element.accept(new IResourceVisitor() {

			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource instanceof IFile)
					if (Q7SearchCore.findIDByPath(resource.getFullPath()) != null)
						rv.add(new UpdateIdInCopiedFrom((IFile) resource));
				return true;
			}
		});

		return rv;
	}

}
