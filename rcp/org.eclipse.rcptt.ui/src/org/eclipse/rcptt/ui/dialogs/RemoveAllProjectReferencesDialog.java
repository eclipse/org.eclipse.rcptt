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

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.preferences.IPreferenceKeys;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

public class RemoveAllProjectReferencesDialog extends MessageDialogWithToggle {

	private static IPreferenceStore prefStore = Q7UIPlugin.getDefault()
			.getPreferenceStore();

	private final List<IQ7NamedElement> references;
	private final IQ7Project project;

	private static RemoveAllProjectReferencesDialog instance;

	public static boolean open(Shell parentShell, IQ7Project project,
			List<IQ7NamedElement> elements) {
		String value = prefStore
				.getString(IPreferenceKeys.ALL_REMOVE_PROJECT_REFERENCES);
		if (ALWAYS.equals(value)) {
			addMissingReferences(project, elements);
			return true;
		} else {
			if (instance != null && instance.getShell() != null
					&& !instance.getShell().isDisposed()) {
				// Is still running
				return false;
			}
			instance = new RemoveAllProjectReferencesDialog(parentShell,
					project, elements);
			return instance.open() == IDialogConstants.YES_ID;
		}
	}

	private RemoveAllProjectReferencesDialog(Shell parentShell,
			IQ7Project project, List<IQ7NamedElement> references) {
		super(
				parentShell,
				"Project Context and Verification References",
				null,
				null,
				MessageDialog.NONE,
				new String[] { IDialogConstants.YES_LABEL,
						IDialogConstants.NO_LABEL },
				0,
				"Always remove default project context and verification references automatically.",
				false);
		this.project = project;
		this.references = references;
		this.message = generateMessage(references);
		setShellStyle(SWT.SHEET);
	}

	private String generateMessage(List<IQ7NamedElement> references) {
		StringBuilder label = new StringBuilder(
				"Would you like to remove default project context/verification references from "
						+ references.size() + " elements?\n\n");
		// try {
		// for (IQ7NamedElement e : references) {
		//				label.append("    ").append(e.getNamedElement().getName()).append(" (").append(e.getPath()).append(")").append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
		// }
		// } catch (ModelException e) {
		// Q7UIPlugin.log(e);
		// }
		return label.toString();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.YES_ID) {
			addMissingReferences(project, references);
		}
		if (getToggleState()) {
			prefStore.setValue(IPreferenceKeys.ALL_REMOVE_PROJECT_REFERENCES,
					ALWAYS);
		}
		setReturnCode(buttonId);
		close();
	}

	private static void addMissingReferences(final IQ7Project project,
			final List<IQ7NamedElement> references) {
		Job job = new Job("Fix project references") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final IStatus[] status = { Status.OK_STATUS };
				try {
					monitor.beginTask("Remove project context/verification references",
							references.size() * 2);
					IQ7ProjectMetadata metadata = project.getMetadata();
					if (metadata == null || !metadata.exists()) {
						return status[0];
					}
					String[] defaultContexts = metadata.getContexts();
					String[] defaultVerifications = metadata.getVerifications();
					if (defaultContexts.length == 0 && defaultVerifications.length == 0) {
						return status[0];
					}
					final List<String> contextsToRemove = Arrays.asList(defaultContexts);
					final List<String> verificationsToRemove = Arrays.asList(defaultVerifications);
					ResourcesPlugin.getWorkspace().run(
							new IWorkspaceRunnable() {
								public void run(IProgressMonitor monitor)
										throws CoreException {
									WriteAccessChecker writeAccessChecker = new WriteAccessChecker(instance.getShell());
									if (!writeAccessChecker.makeResourceWritable(references
											.toArray(new IQ7NamedElement[0]))) {
										status[0] = Status.CANCEL_STATUS;
										return;
									}
									for (IQ7NamedElement e : references) {
										IQ7NamedElement copy = e.getWorkingCopy(new SubProgressMonitor(
												monitor, 1));
										try {
											NamedElement ne = copy.getNamedElement();
											if (ne instanceof Scenario) {
												((Scenario) ne)
														.getContexts()
														.removeAll(
																contextsToRemove);
												((Scenario) ne)
														.getVerifications()
														.removeAll(
																verificationsToRemove);
											}
											if (ne instanceof GroupContext) {
												((GroupContext) ne)
														.getContextReferences()
														.removeAll(
																contextsToRemove);
											}
											copy.commitWorkingCopy(false,
													new SubProgressMonitor(
															monitor, 1));
										} finally {
											copy.discardWorkingCopy();
										}
									}
								}
							}, monitor);
				} catch (CoreException e) {
					return e.getStatus();
				}
				return status[0];
			}
		};
		job.setUser(true);
		job.schedule();
	}
}