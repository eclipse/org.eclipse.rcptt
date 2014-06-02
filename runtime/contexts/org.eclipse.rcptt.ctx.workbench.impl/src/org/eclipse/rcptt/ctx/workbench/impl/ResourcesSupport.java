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
package org.eclipse.rcptt.ctx.workbench.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import org.eclipse.rcptt.core.scenario.Editor;
import org.eclipse.rcptt.core.scenario.FileEditor;
import org.eclipse.rcptt.core.scenario.ScenarioFactory;
import org.eclipse.rcptt.core.scenario.WorkbenchContext;
import org.eclipse.rcptt.internal.runtime.ui.UIRunnable;

public class ResourcesSupport {

	public static Object getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public static void openEditors(final IWorkbenchPage page,
			WorkbenchContext context) throws CoreException {
		for (Editor editor : context.getEditors()) {
			FileEditor fileEditor = (FileEditor) editor;
			Path path = new Path(fileEditor.getPath());
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			final IFile file = (IFile) root.findMember(path);
			if (null == file) {
				IStatus status = Activator.createStatus("File '" + path
						+ "' to open in editor wasn't found in workspace.",
						null);
				throw new CoreException(status);
			}
			UIRunnable.exec(new UIRunnable<Object>() {
				@Override
				public Object run() throws CoreException {
					IDE.openEditor(page, file);
					return null;
				}
			});
		}
	}

	public static void fillEditors(final IWorkbenchPage page,
			WorkbenchContext context) {
		boolean closeOtherEditors = true;
		IEditorReference[] editors = page.getEditorReferences();
		for (IEditorReference editor : editors) {
			FileEditor fileEditor = createEditor(editor);
			if (fileEditor != null) {
				context.getEditors().add(fileEditor);
			} else {
				closeOtherEditors = false;
			}
		}
		context.setCloseEditors(closeOtherEditors);
	}

	private static FileEditor createEditor(IEditorReference editor) {
		IFile file = getFile(editor);
		if (file == null) {
			return null;
		}
		FileEditor result = ScenarioFactory.eINSTANCE.createFileEditor();
		result.setPath(file.getFullPath().makeRelative().toString());
		return result;
	}

	private static IFile getFile(IEditorReference editor) {
		try {
			return getFile(editor.getEditorInput());
		} catch (PartInitException e) {
			Activator.log(e);
		}
		return null;
	}

	private static IFile getFile(IEditorInput input) {
		if (input instanceof IFileEditorInput) {
			return ((IFileEditorInput) input).getFile();
		}
		try {
			return (IFile) input.getAdapter(IFile.class);
		} catch (Exception e) {
		}
		return null;
	}

}
