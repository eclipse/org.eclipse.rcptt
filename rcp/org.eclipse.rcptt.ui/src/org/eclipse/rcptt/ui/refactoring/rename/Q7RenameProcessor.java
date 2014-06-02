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
package org.eclipse.rcptt.ui.refactoring.rename;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor;
import org.eclipse.ltk.internal.core.refactoring.BasicElementLabels;
import org.eclipse.ltk.internal.core.refactoring.Messages;
import org.eclipse.ltk.internal.core.refactoring.RefactoringCoreMessages;
import org.eclipse.ltk.internal.core.refactoring.Resources;
import org.eclipse.ltk.internal.core.refactoring.resource.ResourceModifications;
import org.eclipse.ltk.internal.core.refactoring.resource.ResourceProcessors;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.util.resources.ResourcesUtil;

@SuppressWarnings("restriction")
public class Q7RenameProcessor extends RenameProcessor {

	private final IResource fResource;
	private String fNewResourceName;
	private boolean fUpdateReferences;
	// set after checkFinalConditions
	private RenameNamedElementArguments fRenameArguments;
	private IQ7NamedElement fElement;
	private String newElementName;

	public Q7RenameProcessor(IResource resource) {
		if (resource == null || !resource.exists()) {
			throw new IllegalArgumentException("resource must not be null and must exist"); //$NON-NLS-1$
		}

		fResource = resource;
		fRenameArguments = null;
		fUpdateReferences = true;
		setNewResourceName(resource.getName()); // Initialize new name
		if (resource instanceof IFile) {
			fElement = (IQ7NamedElement) RcpttCore.create((IFile) resource);
		}
	}

	public String getNewElementName() {
		return newElementName;
	}

	public void setNewElementName(String newElementName) {
		this.newElementName = newElementName;
	}

	public IQ7NamedElement getNamedElement() {
		return fElement;
	}

	/**
	 * Returns the resource this processor was created on
	 * 
	 * @return the resource to rename
	 */
	public IResource getResource() {
		return fResource;
	}

	/**
	 * Returns the new resource name
	 * 
	 * @return the new resource name
	 */
	public String getNewResourceName() {
		return fNewResourceName;
	}

	/**
	 * Sets the new resource name
	 * 
	 * @param newName
	 *            the new resource name
	 */
	public void setNewResourceName(String newName) {
		Assert.isNotNull(newName);
		fNewResourceName = newName;
	}

	/**
	 * Returns <code>true</code> if the refactoring processor also updates
	 * references
	 * 
	 * @return <code>true</code> if the refactoring processor also updates
	 *         references
	 */
	public boolean isUpdateReferences() {
		return fUpdateReferences;
	}

	/**
	 * Specifies if the refactoring processor also updates references. The
	 * default behaviour is to update references.
	 * 
	 * @param updateReferences
	 *            <code>true</code> if the refactoring processor should also
	 *            updates references
	 */
	public void setUpdateReferences(boolean updateReferences) {
		fUpdateReferences = updateReferences;
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
		return RefactoringStatus.create(Resources.checkInSync(fResource));
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
			fRenameArguments = new RenameNamedElementArguments(
					getNewElementName(), getNewResourceName(),
					isUpdateReferences());

			ResourceChangeChecker checker = (ResourceChangeChecker) context
					.getChecker(ResourceChangeChecker.class);
			IResourceChangeDescriptionFactory deltaFactory = checker
					.getDeltaFactory();

			ResourceModifications.buildMoveDelta(deltaFactory, fResource,
					fRenameArguments);

			return new RefactoringStatus();
		} finally {
			pm.done();
		}
	}

	/**
	 * Validates if the a name is valid. This method does not change the name
	 * settings on the refactoring. It is intended to be used in a wizard to
	 * validate user input.
	 * 
	 * @param newName
	 *            the name to validate
	 * @param newName
	 * @return returns the resulting status of the validation
	 */

	public RefactoringStatus validateNewElementName(String scenarioName,
			String newName) {
		Assert.isNotNull(newName, "new name"); //$NON-NLS-1$
		IContainer c = fResource.getParent();
		if (c == null)
			return RefactoringStatus
					.createFatalErrorStatus(RefactoringCoreMessages.RenameResourceProcessor_error_no_parent);

		try {
			if (ResourcesUtil.getCaseInsensitiveChild(c, newName) != null)
				return RefactoringStatus
						.createFatalErrorStatus(RefactoringCoreMessages.RenameResourceProcessor_error_resource_already_exists);
		} catch (CoreException e) {
			return RefactoringStatus.create(e.getStatus());
		}
		if (scenarioName.trim().length() == 0) {
			return RefactoringStatus
					.createFatalErrorStatus(RefactoringCoreMessages.RenameResourceProcessor_error_invalid_name);
		}
		if (!c.getFullPath().isValidSegment(newName))
			return RefactoringStatus
					.createFatalErrorStatus(RefactoringCoreMessages.RenameResourceProcessor_error_invalid_name);

		RefactoringStatus result = RefactoringStatus.create(c.getWorkspace()
				.validateName(newName, fResource.getType()));
		if (!result.hasFatalError())
			result.merge(RefactoringStatus.create(c.getWorkspace()
					.validatePath(createNewPath(newName), fResource.getType())));
		return result;
	}

	protected RenameResourceDescriptor createDescriptor() {
		IResource resource = getResource();

		RenameResourceDescriptor descriptor = new RenameResourceDescriptor();
		descriptor.setProject(resource instanceof IProject ? null : resource
				.getProject().getName());
		descriptor.setDescription(Messages.format(
				RefactoringCoreMessages.RenameResourceProcessor_description,
				BasicElementLabels.getResourceName(resource)));
		descriptor.setComment(Messages.format(
				RefactoringCoreMessages.RenameResourceProcessor_comment,
				new String[] {
						BasicElementLabels.getPathLabel(resource.getFullPath(),
								false),
						BasicElementLabels
								.getResourceName(getNewResourceName()) }));
		descriptor.setFlags(RefactoringDescriptor.STRUCTURAL_CHANGE
				| RefactoringDescriptor.MULTI_CHANGE
				| RefactoringDescriptor.BREAKING_CHANGE);
		descriptor.setResourcePath(resource.getFullPath());
		descriptor.setNewName(getNewResourceName());
		descriptor.setUpdateReferences(isUpdateReferences());
		return descriptor;
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
			if (getNamedElement() != null) {
				RenameNamedElementChange change = new RenameNamedElementChange(
						fResource.getFullPath(), getNewResourceName(),
						getNewElementName());
				change.setDescriptor(new RefactoringChangeDescriptor(
						createDescriptor()));
				return change;
			} else if (getResource() instanceof IContainer) {
				RenameContainerChange change = new RenameContainerChange(
						fResource.getFullPath(), getNewResourceName());
				change.setDescriptor(new RefactoringChangeDescriptor(
						createDescriptor()));
				return change;
			} else {
				RenameResourceChange change = new RenameResourceChange(
						fResource.getFullPath(), getNewResourceName());
				change.setDescriptor(new RefactoringChangeDescriptor(
						createDescriptor()));
				return change;
			}
		} finally {
			pm.done();
		}
	}

	private String createNewPath(String newName) {
		return fResource.getFullPath().removeLastSegments(1).append(newName)
				.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * getElements()
	 */
	@Override
	public Object[] getElements() {
		return new Object[] { fResource };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return "org.eclipse.ltk.core.refactoring.renameResourceProcessor"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * getProcessorName()
	 */
	@Override
	public String getProcessorName() {
		return RefactoringCoreMessages.RenameResourceProcessor_processor_name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * isApplicable()
	 */
	@Override
	public boolean isApplicable() {
		if (fResource == null)
			return false;
		if (!fResource.exists())
			return false;
		if (!fResource.isAccessible())
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#
	 * loadParticipants(org.eclipse.ltk.core.refactoring.RefactoringStatus,
	 * org.eclipse.ltk.core.refactoring.participants.SharableParticipants)
	 */
	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants shared) throws CoreException {
		String[] affectedNatures = ResourceProcessors
				.computeAffectedNatures(fResource);
		return ParticipantManager.loadRenameParticipants(status, this,
				fResource, fRenameArguments, null, affectedNatures, shared);
	}

}
