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
package org.eclipse.rcptt.ui.refactoring;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;

import org.eclipse.rcptt.internal.ui.Messages;

public class NamedElementMoveParticipant extends MoveParticipant {

	private Object element;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {

		CompositeChange change = null;

		if (element instanceof IFolder) {
			MoveArguments arguments = getArguments();
			IContainer destination = (IContainer) arguments.getDestination();
			IFolder destinationFolder = getDestinationFolder((IFolder) element,
					destination);
			if (destinationFolder != null && destinationFolder.exists()) {
				change = new CompositeChange(
						Messages.NamedElementMoveParticipant_ChangeName);
				processReplacedFolder((IFolder) element, destinationFolder,
						change);
				if (change.getChildren().length == 0) {
					change = null;
				}
			}
		}
		if (element instanceof IFile) {
			MoveArguments arguments = getArguments();
			IContainer destination = (IContainer) arguments.getDestination();
			IFile destinationFile = getDestinationFile((IFile) element,
					destination);
			if (destinationFile != null && destinationFile.exists()) {
				if (change == null) {
					change = new CompositeChange(
							Messages.NamedElementMoveParticipant_ChangeName);
				}
				change.add(new RemoveFromFileToDateChange(destinationFile));
			}
		}

		return change;
	}

	private void processReplacedFolder(IFolder source, IFolder destination,
			CompositeChange change) throws CoreException {
		for (IResource sourceChild : source.members()) {
			if (sourceChild instanceof IFile) {
				IFile destinationFile = getDestinationFile((IFile) sourceChild,
						destination);
				if (destinationFile != null && destinationFile.exists()) {
					change.add(new RemoveFromFileToDateChange(destinationFile));
				}
			}
			if (sourceChild instanceof IFolder) {
				IFolder destinationFolder = getDestinationFolder(
						(IFolder) sourceChild, destination);
				if (destinationFolder != null && destinationFolder.exists()) {
					processReplacedFolder((IFolder) sourceChild,
							destinationFolder, change);
				}
			}
		}
	}

	private IFile getDestinationFile(IFile sourceFile, IContainer destination) {
		IPath destinationLocation = destination.getFullPath().append(
				sourceFile.getFullPath().lastSegment());
		IFile destinationFile = destination.getWorkspace().getRoot()
				.getFile(destinationLocation);
		return destinationFile;
	}

	private IFolder getDestinationFolder(IFolder sourceFolder,
			IContainer destination) {
		IPath destinationLocation = destination.getFullPath().append(
				sourceFolder.getFullPath().lastSegment());
		IFolder destinationFolder = destination.getWorkspace().getRoot()
				.getFolder(destinationLocation);
		return destinationFolder;
	}

	@Override
	public String getName() {
		return Messages.NamedElementMoveParticipant_Name;
	}

	@Override
	protected boolean initialize(Object element) {
		this.element = element;
		return true;
	}
}
