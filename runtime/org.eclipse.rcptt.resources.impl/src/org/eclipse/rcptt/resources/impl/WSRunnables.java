/*******************************************************************************
 * Copyright (c) 2009, 2017 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.resources.impl;

import static org.eclipse.core.commands.operations.OperationHistoryFactory.getOperationHistory;

import java.net.URI;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.tesla.ecl.impl.UIRunnable;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class WSRunnables {

	public static IWorkspaceRunnable refreshWorkspace = new IWorkspaceRunnable() {
		public void run(final IProgressMonitor monitor) throws CoreException {
			// refresh in case of SUT was working messy
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace()
					.getRoot();

			// Automatically remove non existing projects.
			autoDeleteUnexistingProjects(root);

			try {
				root.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				RcpttPlugin.log("Failed to refresh workspace on first time cause: + " + e.getMessage(), e);
				root.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
			// Wait for all auto build jobs
			Job[] autobuildJobs = Job.getJobManager().find(
					ResourcesPlugin.FAMILY_AUTO_BUILD);
			for (Job job : autobuildJobs) {
				job.schedule();
			}
		}
	};

	public static UIRunnable<Object> clearHistory = new UIRunnable<Object>() {
		@Override
		public Object run() throws CoreException {
			ResourcesPlugin.getWorkspace().getRoot()
					.clearHistory(new NullProgressMonitor());
			return null;
		}
	};

	public static UIRunnable<Object> clearAllFileBuffers = new UIRunnable<Object>() {
		@Override
		public Object run() throws CoreException {
			FileBuffersUtils.getFileBuffers().clearAll();
			return null;
		}
	};

	public static UIRunnable<Object> closeEditorsWithResources = new UIRunnable<Object>() {
		@Override
		public Object run() throws CoreException {
			IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench()
					.getWorkbenchWindows();
			for (IWorkbenchWindow win : workbenchWindows) {
				IWorkbenchPage[] pages = win.getPages();
				for (IWorkbenchPage page : pages) {
					IEditorReference[] refs = page.getEditorReferences();
					for (IEditorReference ref : refs) {
						closeEditor(page, ref);
					}
				}
			}

			return null;
		}

		private void closeEditor(IWorkbenchPage page, IEditorReference ref)
				throws PartInitException {
			IEditorInput editorInput = ref.getEditorInput();
			if (!editorInput.exists()) {
				return;
			}
			int attemptCount = 10;
			while (attemptCount-- > 0) {
				IWorkbenchPart part = ref.getPart(false);
				if (part == null) {
					return;
				}
				try {
					page.closeEditor((IEditorPart) part, false);
				} catch (Throwable e) {
					RcpttPlugin.log("Failed to close editor", e);
				}
			}
		}
	};

	public static UIRunnable<Boolean> clearOperationHistoryEntry = new UIRunnable<Boolean>() {
		public Boolean run() throws CoreException {
			try {
				IOperationHistory history = getOperationHistory();

				for (IUndoableOperation op : history.getUndoHistory(anyContext)) {
					history.replaceOperation(op, new IUndoableOperation[0]);
					return true;
				}

				for (IUndoableOperation op : history.getRedoHistory(anyContext)) {
					history.replaceOperation(op, new IUndoableOperation[0]);
					return true;
				}
			} catch (Throwable e) {
				RcpttPlugin.log(e);
			}
			return false;
		}

		private IUndoContext anyContext = new IUndoContext() {
			public boolean matches(IUndoContext context) {
				return true;
			}

			public String getLabel() {
				return "any";
			}
		};
	};

	private static void autoDeleteUnexistingProjects(final IWorkspaceRoot root) throws CoreException {
		IProject[] projects = root.getProjects();
		for (IProject prj : projects) {
			URI uri = prj.getLocationURI();
			if (uri == null || uri.getScheme() == null) {
				continue;
			}
			IFileStore store = EFS.getStore(uri);
			if (store == null) {
				continue;
			}
			IFileInfo fileInfo = store.fetchInfo();
			if (fileInfo != null && !fileInfo.exists()) {
				prj.delete(true, true, null);
				RcpttPlugin.infoLog("Q7 workspace context, automatic delete of unexisting project: " + prj.getName());
			}
		}
	}

}
