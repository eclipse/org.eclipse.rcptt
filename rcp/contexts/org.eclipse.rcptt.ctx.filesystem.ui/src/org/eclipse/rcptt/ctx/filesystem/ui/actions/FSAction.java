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


import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeItem;

import org.eclipse.rcptt.filesystem.FSFile;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.filesystem.FSResource;
import org.eclipse.rcptt.filesystem.FilesystemContext;

public abstract class FSAction extends Action {

	public FSAction(String text, ImageDescriptor descriptor) {
		super(text, descriptor);
	}

	protected FSResource[] selection;
	protected TreeViewer viewer;

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	protected FilesystemContext getContext() {
		return (FilesystemContext) viewer.getInput();
	}

	protected FSFolder getFolder() {
		if (selection == null || selection.length == 0)
			return getContext().getRoot();
		else if (selection.length > 1) {
			return null;
		}
		else if (selection[0] instanceof FSFolder)
			return (FSFolder) selection[0];
		else if (selection[0] instanceof FSFile) {
			TreeItem parent = viewer.getTree().getSelection()[0]
					.getParentItem();
			if (parent == null)
				return getContext().getRoot();
			return (FSFolder) parent.getData();
		} else
			return null;
	}

	protected FSFile getFile() {
		if (selection != null && selection.length == 1
				&& selection[0] instanceof FSFile)
			return (FSFile) selection[0];
		else
			return null;
	}

	protected FSResource getResource() {
		if (selection != null && selection.length == 1)
			return selection[0];
		else
			return getContext().getRoot();
	}

	public void setSelection(FSResource[] selection) {
		this.selection = selection;
		init();
	}

	protected abstract void init();

}