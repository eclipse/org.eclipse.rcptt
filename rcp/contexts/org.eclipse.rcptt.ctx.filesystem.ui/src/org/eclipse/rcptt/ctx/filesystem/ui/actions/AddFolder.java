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
package org.eclipse.rcptt.ctx.filesystem.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.rcptt.ctx.filesystem.FSUtils;
import org.eclipse.rcptt.ctx.filesystem.ui.Activator;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class AddFolder extends FSAction {

	public AddFolder() {
		super("Add Folder...", Images.getImageDescriptor(Images.NEW_FOLDER));
	}

	@Override
	protected void init() {
		setEnabled(getFolder() != null);
	}

	/**
	 * Must be run in UI thread
	 */
	@Override
	public void run() {
		Shell shell = viewer.getTree().getShell();
		DirectoryDialog dialog = new DirectoryDialog(shell);
		final String path = dialog.open();
		if (path == null)
			return;
		final FSFolder parent = getFolder();
		final AtomicReference<FSFolder> result = new AtomicReference<FSFolder>();

		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				monitor.beginTask("Adding folder...", IProgressMonitor.UNKNOWN);
				try {
					result.set(FSUtils.addFolder(parent, path));
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		try {
			PlatformUI.getWorkbench().getProgressService()
					.busyCursorWhile(runnable);
			FSFolder folder = result.get();
			if (folder == null) {
				// operation canceled
				return;
			}
			viewer.setSelection(new StructuredSelection(result.get()));
		} catch (InterruptedException e) {
			// nothing to do
		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			MessageDialog.openError(shell, "Error adding folder",
					t.getMessage());
			if (t.getCause() != null || !(t instanceof CoreException)) {
				// internal error, not a validation
				Activator.logErr(t, "Error adding folder");
			}
		}
	}

}