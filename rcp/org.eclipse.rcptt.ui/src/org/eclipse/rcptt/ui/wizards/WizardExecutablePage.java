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
package org.eclipse.rcptt.ui.wizards;

import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.core.nature.RcpttNature;
import org.eclipse.rcptt.internal.ui.Messages;

public abstract class WizardExecutablePage extends WizardPage {

	// private Q7ContainerSelectionGroup containerSelectionGroup;
	private final IStructuredSelection initialSelection;
	private Text locationText;
	protected String location;

	public WizardExecutablePage(String pageName, String title,
			IStructuredSelection selection) {
		super(pageName, title, null);
		initialSelection = selection;
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(composite);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);

		Label label = new Label(composite, SWT.LEFT);
		label.setText(Messages.WizardExecutablePage_LocationLabel);

		locationText = new Text(composite, SWT.BORDER);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(locationText);
		locationText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				location = locationText.getText();
				validate();
			}
		});
		Button browse = new Button(composite, SWT.PUSH);
		browse.setText(Messages.WizardExecutablePage_BrowseButton);
		browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseLocation();
			}
		});
		setButtonLayoutData(browse);

		createContent(composite);
		setControl(composite);
		Dialog.applyDialogFont(composite);

		setInitialSelection();

		validate();
	}

	protected void browseLocation() {
		LocationSelectionDialog dialog = new LocationSelectionDialog(getShell());
		dialog.setLocation(location);
		if (dialog.open() == LocationSelectionDialog.OK) {
			location = dialog.getLocation();
			locationText.setText(location);
			validate();
		}
	}

	protected void setInitialSelection() {
		Iterator<?> it = initialSelection.iterator();
		if (it.hasNext()) {
			Object object = it.next();
			IResource selectedResource = null;
			if (object instanceof IResource) {
				selectedResource = (IResource) object;
			} else if (object instanceof IAdaptable) {
				selectedResource = (IResource) ((IAdaptable) object)
						.getAdapter(IResource.class);
			}
			if (selectedResource != null) {
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}
				if (selectedResource.isAccessible()
						&& (selectedResource instanceof IContainer)) {
					// containerSelectionGroup
					// .setSelectedContainer((IContainer) selectedResource);
					location = selectedResource.getFullPath().toString();
					locationText.setText(location);
				}
			}
		}
	}

	protected abstract void createContent(Composite parent);

	protected void validate() {
		boolean valid = doValidate();
		if (valid) {
			setErrorMessage(null);
			setMessage(getDefaultMessage());
		}
		setPageComplete(valid);
		if (getContainer() != null && getContainer().getCurrentPage() != null) {
			getContainer().updateButtons();
		}
	}

	protected String getDefaultMessage() {
		return null;
	}

	protected boolean doValidate() {
		setErrorMessage(null);
		if (location != null) {
			IPath containerPath = new Path(location);// containerSelectionGroup.getContainerFullPath();
			IProject project = getProject();
			if ((null == project)
					|| !Path.EMPTY.isValidPath(containerPath.toString())) {
				setErrorMessage(Messages.WizardExecutablePage_EmptyParentMsg);
				return false;
			}
			IPath path = containerPath.removeFirstSegments(1);
			if (!path.isEmpty()) {
				IFolder folder = project.getFolder(path);
				if (!folder.exists()) {
					setErrorMessage(Messages.WizardExecutablePage_NotExistingFolderMsg);
					return false;
				}
			}
		} else {
			setErrorMessage(Messages.WizardExecutablePage_EmptyParentMsg);
			return false;
		}
		return true;
	}

	public IProject getProject() {
		IPath resourcePath = new Path(location);// containerSelectionGroup.getContainerFullPath();
		if ((null == resourcePath) || (0 >= resourcePath.segmentCount())) {
			return null;
		}
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(resourcePath.segment(0));
		try {
			if (RcpttNature.isRcpttProject(project)) {
				return project;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public IPath getPathInProject() {
		return new Path(location).removeFirstSegments(1);
	}
}
