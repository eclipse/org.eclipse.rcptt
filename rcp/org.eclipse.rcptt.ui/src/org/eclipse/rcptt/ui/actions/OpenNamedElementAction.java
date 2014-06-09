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
package org.eclipse.rcptt.ui.actions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.commons.ModernElementListSelectionDialog;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;

public abstract class OpenNamedElementAction {
	IWorkbenchWindow window;

	public OpenNamedElementAction() {
		super();
	}

	protected ILabelProvider createLabelProvider() {
		return new Q7ElementLabelProvider();
	}

	public void run(IAction action) {
		final Display display = Display.getCurrent();
		new Job("Looking for elements") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final Set<IQ7NamedElement> allElements = new HashSet<IQ7NamedElement>();
				fillNamedElements(allElements);
				display.asyncExec(new Runnable() {
					
					@Override
					public void run() {
						showDialog(allElements);
					}
				});
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	protected void showDialog(Set<IQ7NamedElement> allElements) {
		ModernElementListSelectionDialog dialog = new ModernElementListSelectionDialog(
				WorkbenchUtils.getShell(), createLabelProvider());

		dialog.setElements(allElements.toArray());
		dialog.setTitle(getWindowTitle());
		dialog.setMessage(Messages.OpenNamedElementAction_DialogMsg);
		dialog.setMultipleSelection(false);
		int result = dialog.open();
		if (result == Window.OK) {
			Object[] selected = dialog.getResult();
			for (int i = 0; i < selected.length; i++) {
				try {
					IDE.openEditor(WorkbenchUtils.getPage(),
							(IFile) ((IQ7NamedElement) selected[i])
									.getResource());
				} catch (PartInitException e) {
					Q7UIPlugin.log(e);
				}
			}
		}
	}

	protected abstract String getWindowTitle();

	protected abstract void fillNamedElements(Set<IQ7NamedElement> allElements);

	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

}