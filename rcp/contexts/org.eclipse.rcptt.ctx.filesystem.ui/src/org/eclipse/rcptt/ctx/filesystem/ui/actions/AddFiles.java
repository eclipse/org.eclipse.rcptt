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
package org.eclipse.rcptt.ctx.filesystem.ui.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.rcptt.ctx.filesystem.FSUtils;
import org.eclipse.rcptt.ctx.filesystem.ui.Activator;
import org.eclipse.rcptt.filesystem.FSFile;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class AddFiles extends FSAction {

	public AddFiles() {
		super("Add Files...", Images.getImageDescriptor(Images.NEW_FILE));
	}

	@Override
	protected void init() {
		setEnabled(getFolder() != null);
	}

	@Override
	public void run() {
		Shell shell = viewer.getTree().getShell();
		FileDialog dialog = new FileDialog(shell, SWT.MULTI);
		if (dialog.open() == null)
			return;
		final FSFolder parent = getFolder();
		String[] fileNames = dialog.getFileNames();
		final File[] paths = new File[fileNames.length];
		for (int i = 0; i < paths.length; ++i)
			paths[i] = new File(dialog.getFilterPath(), fileNames[i]);

		final AtomicReference<FSFile[]> result = new AtomicReference<FSFile[]>();

		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				monitor.beginTask("Adding files...", IProgressMonitor.UNKNOWN);
				try {
					result.set(FSUtils.addFiles(parent, paths));
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				}

			}
		};
		try {
			PlatformUI.getWorkbench().getProgressService()
					.busyCursorWhile(runnable);
			FSFile[] files = result.get();
			if (files == null) {
				// operation canceled
				return;
			}
			viewer.setSelection(new StructuredSelection(files[0]));
		} catch (InterruptedException e) {
			// nothing to do
		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			MessageDialog
					.openError(shell, "Error adding files", t.getMessage());
			if (t.getCause() != null || !(t instanceof CoreException)) {
				// internal error, not a validation
				Activator.logErr(t, "Error adding files");
			}
		}
	}
}