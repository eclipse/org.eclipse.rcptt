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
package org.eclipse.rcptt.ui.navigator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringContribution;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.MoveResourcesDescriptor;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ide.undo.AbstractWorkspaceOperation;
import org.eclipse.ui.ide.undo.CopyResourcesOperation;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.navigator.CommonDropAdapter;

import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.actions.edit.Q7CopyFilesAndFoldersOperation;

@SuppressWarnings("restriction")
public class Q7DropAdapterAssistant extends Q7ResourceDropAdapterAssistant {
	@SuppressWarnings("unused")
	private static final IResource[] NO_RESOURCES = new IResource[0];
	private static final String MOVE_CONTRIBUTION_ID = "org.eclipse.ltk.core.refactoring.move.resources"; //$NON-NLS-1$

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter,
			DropTargetEvent aDropTargetEvent, Object aTarget) {

		// IResource[] resources = getSelectedResources(aDropAdapter,
		// aDropTargetEvent);
		//
		// if (isMoveRefactoringRequired(resources)) {
		//
		// RefactoringContribution contribution = RefactoringCore
		// .getRefactoringContribution(MOVE_CONTRIBUTION_ID);
		// MoveResourcesDescriptor moveDescriptor = (MoveResourcesDescriptor)
		// contribution
		// .createDescriptor();
		//
		// moveDescriptor.setDestination((IContainer) aTarget);
		// moveDescriptor.setResourcesToMove(resources);
		//
		// try {
		// IContainer sourceParentContainer = resources[0].getParent();
		//
		// Refactoring refactoring = createMoveRefactoring(resources,
		// (IContainer) aTarget);
		// PerformRefactoringOperation operation = new
		// PerformRefactoringOperation(
		// refactoring, CheckConditionsOperation.ALL_CONDITIONS);
		// ResourcesPlugin.getWorkspace().run(operation,
		// new NullProgressMonitor());
		//
		// if (sourceParentContainer != null
		// && sourceParentContainer.isAccessible()) {
		// try {
		// sourceParentContainer.refreshLocal(
		// IResource.DEPTH_INFINITE, null);
		// } catch (CoreException e) {
		// }
		// }
		//
		// return Status.OK_STATUS;
		// } catch (CoreException e) {
		// return e.getStatus();
		// }
		// }

		return super.handleDrop(aDropAdapter, aDropTargetEvent, aTarget);
	}

	private static class CopyQ7ResourcesOperation extends
			CopyResourcesOperation {

		private IResource[] targets;

		public CopyQ7ResourcesOperation(IResource[] resources,
				IPath destinationPath, String label) {
			super(resources, destinationPath, label);
		}

		public CopyQ7ResourcesOperation(IResource[] resources,
				IPath[] destinationPaths, String label) {
			super(resources, destinationPaths, label);
		}

		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable uiInfo)
				throws ExecutionException {
			IStatus result = super.execute(monitor, uiInfo);
			if (targets != null) {
				for (IResource target : targets) {
					if (target instanceof IFile) {
						IQ7NamedElement file;
						file = (IQ7NamedElement) RcpttCore.create((IFile) target);
						if (file != null) {
							try {
								IQ7NamedElement copy = file
										.getWorkingCopy(new NullProgressMonitor());
								try {
									IQ7Folder folder = (IQ7Folder) copy
											.getParent();
									do {
										copy.setID(EcoreUtil.generateUUID());
									} while (folder
											.haveIDConflict(copy.getID()));

									copy.setElementName(target.getFullPath()
											.removeFileExtension()
											.lastSegment());
									copy.commitWorkingCopy(true,
											new NullProgressMonitor());
								} finally {
									copy.discardWorkingCopy();
								}
							} catch (ModelException e) {
								Q7UIPlugin.log(e);
							}
						}

					}
				}
			}
			return result;
		}

		@Override
		protected void setTargetResources(IResource[] targetResources) {
			super.setTargetResources(targetResources);
			this.targets = targetResources;
		}
	};

	@Override
	protected Q7CopyFilesAndFoldersOperation createOperation(Shell shell) {
		return new Q7CopyFilesAndFoldersOperation(shell) {
			@Override
			protected AbstractWorkspaceOperation getUndoableCopyOrMoveOperation(
					IResource[] resources, boolean renamed,
					IPath... destinationPath) {
				if (renamed) {
					return new CopyQ7ResourcesOperation(
							resources,
							destinationPath,
							IDEWorkbenchMessages.CopyFilesAndFoldersOperation_copyTitle);
				} else {
					return new CopyQ7ResourcesOperation(
							resources,
							destinationPath[0],
							IDEWorkbenchMessages.CopyFilesAndFoldersOperation_copyTitle);
				}
			}
		};
	}

	@SuppressWarnings("unused")
	private Refactoring createMoveRefactoring(IResource[] resources,
			IContainer target) throws CoreException {
		RefactoringContribution contribution = RefactoringCore
				.getRefactoringContribution(MOVE_CONTRIBUTION_ID);
		MoveResourcesDescriptor moveDescriptor = (MoveResourcesDescriptor) contribution
				.createDescriptor();

		moveDescriptor.setDestination(target);
		moveDescriptor.setResourcesToMove(resources);
		return moveDescriptor.createRefactoring(new RefactoringStatus());
	}

	@SuppressWarnings("unused")
	private boolean isMoveRefactoringRequired(IResource[] resources) {
		for (IResource resource : resources) {
			if (resource instanceof IFile) {
				if (RcpttCore.isQ7Context(resource.getFullPath())) {
					return true;
				}
			}
		}
		return false;

	}
}
