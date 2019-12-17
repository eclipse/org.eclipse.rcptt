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
package org.eclipse.rcptt.ctx.preferences.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.ctx.preferences.ui.wizard.PreferencesImportWizard;
import org.eclipse.rcptt.internal.preferences.PrefUtils;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.preferences.PreferencesContext;
import org.eclipse.rcptt.preferences.SettingsNode;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;
import org.eclipse.rcptt.workspace.WorkspaceContext;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public abstract class PrefAction extends Action {

	protected ISelectionProvider selectionProvider;
	protected TreeViewer viewer;

	public PrefAction(String text, ImageDescriptor descriptor,
			ISelectionProvider selectionProvider) {
		super(text, descriptor);
		this.selectionProvider = selectionProvider;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	protected WorkspaceContext getContext() {
		return (WorkspaceContext) viewer.getInput();
	}

	public static class Remove extends PrefAction {

		private PreferencesContext context;

		public Remove(ISelectionProvider selectionProvider,
				PreferencesContext context) {
			super("Remove", PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE),
					selectionProvider);
			this.context = context;
		}

		@Override
		public boolean isEnabled() {
			return !selectionProvider.getSelection().isEmpty();
		}

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) selectionProvider
					.getSelection();
			for (Object o : selection.toList()) {
				if (o instanceof SettingsNode) {
					context.setSettings(null);
					viewer.remove(o);
				} else {
					PrefUtils.remove((EObject) o);
				}
			}
		}
	}

	public static class ImportPreferences extends PrefAction {

		private final IQ7Editor<Context> contextEditor;

		public ImportPreferences(IQ7Editor<Context> contextEditor) {
			super("Import Preferences...", Images
					.getImageDescriptor(Images.PREFERENCES_IMPORT), null);
			this.contextEditor = contextEditor;
		}

		@Override
		public void run() {
			PreferencesImportWizard wizard = new PreferencesImportWizard(
					contextEditor);
			WizardDialog dialog = new WizardDialog(WorkbenchUtils.getShell(),
					wizard);
			dialog.open();
		}
	}
}
