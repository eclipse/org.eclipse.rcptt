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
package org.eclipse.rcptt.ctx.filesystem.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.filesystem.FSFile;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class OpenFile extends FSAction {

	public OpenFile() {
		super("Open File", Images.getImageDescriptor(Images.FILE));
	}

	@Override
	protected void init() {
		setEnabled(selection != null && selection.length == 1 && selection[0] instanceof FSFile);
	}

	@Override
	public void run() {
		FSFile file = (FSFile) selection[0];
		String name = getFullName(file);
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		try {
			IDE.openEditor(page, new FSFileEditorInput(
					file, name), "org.eclipse.ui.DefaultTextEditor");
		} catch (PartInitException e) {
			Q7UIPlugin.log(e);
		}
	}

	/**
	 * Returns file name with path through the folders.
	 * E.g. "contents/MyProject/MyFile.txt".
	 * 
	 * @param file
	 * @return
	 */
	private String getFullName(FSFile file) {
		StringBuilder builder = new StringBuilder();
		builder.append(file.getName());
		EObject container = file.eContainer();
		String folderName;
		while (container != null) {
			if (container instanceof FSFolder) {
				folderName = ((FSFolder) container).getName();
				if (folderName != null) {
					builder.insert(0, folderName + "/");
				}
			}
			container = container.eContainer();
		}

		return "contents/" + builder.toString();
	}

}
