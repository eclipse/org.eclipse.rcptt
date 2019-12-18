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
package org.eclipse.rcptt.ui.dialogs;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.preferences.IPreferenceKeys;

public class AddProjectReferencesDialog extends MessageDialogWithToggle {

	private static IPreferenceStore prefStore = Q7UIPlugin.getDefault()
			.getPreferenceStore();

	private final Map<IProject, Set<IQ7NamedElement>> references;
	private final IProject project;

	private static AddProjectReferencesDialog instance;

	public static boolean open(Shell parentShell, IProject project,
			Map<IProject, Set<IQ7NamedElement>> references) {
		String value = prefStore
				.getString(IPreferenceKeys.ADD_PROJECT_REFERENCES);
		if (ALWAYS.equals(value)) {
			addMissingReferences(project, references);
			return true;
		} else {
			if (instance != null && instance.getShell() != null
					&& !instance.getShell().isDisposed()) {
				// Is still running
				return false;
			}
			instance = new AddProjectReferencesDialog(parentShell, project,
					references);
			return instance.open() == IDialogConstants.YES_ID;
		}
	}

	private AddProjectReferencesDialog(Shell parentShell, IProject project,
			Map<IProject, Set<IQ7NamedElement>> references) {
		super(parentShell, Messages.AddProjectReferencesDialog_Title, null,
				null, MessageDialog.NONE,
				new String[] { IDialogConstants.YES_LABEL,
						IDialogConstants.NO_LABEL }, 0,
				Messages.AddProjectReferencesDialog_ToggleText, false);
		this.project = project;
		this.references = references;
		this.message = generateMessage(references);
		setShellStyle(SWT.SHEET);
	}

	private String generateMessage(
			Map<IProject, Set<IQ7NamedElement>> references) {
		StringBuilder label = new StringBuilder(
				Messages.AddProjectReferencesDialog_Msg);
		for (IProject p : references.keySet()) {
			label.append("    ").append(p.getName()).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return label.toString();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.YES_ID) {
			addMissingReferences(project, references);
		}
		if (getToggleState()) {
			prefStore.setValue(IPreferenceKeys.ADD_PROJECT_REFERENCES, ALWAYS);
		}
		setReturnCode(buttonId);
		close();
	}

	private static void addMissingReferences(final IProject project,
			final Map<IProject, Set<IQ7NamedElement>> references) {
		Job job = new Job(Messages.AddProjectReferencesDialog_Job) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					IProjectDescription description = project.getDescription();
					IProject[] referenced = project.getReferencedProjects();
					IProject[] newReferenced = new IProject[referenced.length
							+ references.size()];
					System.arraycopy(referenced, 0, newReferenced, 0,
							referenced.length);
					int i = referenced.length;
					for (IProject d : references.keySet()) {
						newReferenced[i++] = d;
					}
					description.setReferencedProjects(newReferenced);
					project.setDescription(description, monitor);
				} catch (CoreException e) {
					return e.getStatus();
				}
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	}
}