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
package org.eclipse.rcptt.ui.dialogs;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.preferences.IPreferenceKeys;

public class RemoveProjectReferencesDialog extends MessageDialogWithToggle {

	private static IPreferenceStore prefStore = Q7UIPlugin.getDefault()
			.getPreferenceStore();

	private final List<String> references;
	private final IQ7NamedElement element;

	private static RemoveProjectReferencesDialog instance;

	public static boolean open(Shell parentShell, IQ7NamedElement element,
			List<String> references) {
		String value = prefStore
				.getString(IPreferenceKeys.REMOVE_PROJECT_REFERENCES);
		if (ALWAYS.equals(value)) {
			addMissingReferences(element, references);
			return true;
		} else {
			if (instance != null && instance.getShell() != null
					&& !instance.getShell().isDisposed()) {
				// Is still running
				return false;
			}
			instance = new RemoveProjectReferencesDialog(parentShell, element,
					references);
			return instance.open() == IDialogConstants.YES_ID;
		}
	}

	private RemoveProjectReferencesDialog(Shell parentShell,
			IQ7NamedElement element, List<String> references) {
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
		this.element = element;
		this.references = references;
		this.message = generateMessage(references);
		setShellStyle(SWT.SHEET);
	}

	private String generateMessage(List<String> references) {
		StringBuilder label = new StringBuilder(
				"Would you like to remove default project context/verification references?\n\n");
		try {
			for (String e : references) {
				List<IQ7NamedElement> target = element.getQ7Project().find(IQ7NamedElement.class, e);
				if (target.size() == 1) {
					label.append("    ").append(target.get(0).getNamedElement().getName()).append(" (").append(target.get(0).getPath()).append(")").append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return label.toString();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.YES_ID) {
			addMissingReferences(element, references);
		}
		if (getToggleState()) {
			prefStore.setValue(IPreferenceKeys.REMOVE_PROJECT_REFERENCES,
					ALWAYS);
		}
		setReturnCode(buttonId);
		close();
	}

	private static void addMissingReferences(final IQ7NamedElement element,
			final List<String> references) {
		Job job = new Job("Fix project references") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					NamedElement namedElement = element.getNamedElement();
					EList<String> contexts = null;
					if (namedElement instanceof Scenario) {
						contexts = ((Scenario) namedElement).getContexts();
						((Scenario) namedElement).getVerifications().removeAll(references);
					}
					if (namedElement instanceof GroupContext) {
						contexts = ((GroupContext) namedElement)
								.getContextReferences();
					}

					if (contexts != null) {
						contexts.removeAll(references);
					}
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