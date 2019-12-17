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
package org.eclipse.rcptt.ctx.filesystem.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.filesystem.FSResource;
import org.eclipse.rcptt.filesystem.FilesystemContext;

public class FilesystemContextContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY_OBJECTS = new Object[0];

	public Object[] getElements(Object inputElement) {
		return getChildren(((FilesystemContext) inputElement).getRoot());
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof FSFolder) {
			FSFolder folder = (FSFolder) element;
			return folder.getFolders().size() > 0
					|| folder.getFiles().size() > 0;
		}
		return false;
	}

	public Object[] getChildren(Object parentElement) {
		FSResource resource = (FSResource) parentElement;
		if (resource instanceof FSFolder) {
			FSFolder folder = (FSFolder) resource;
			List<FSResource> result = new ArrayList<FSResource>();
			result.addAll(folder.getFolders());
			result.addAll(folder.getFiles());
			return result.toArray(EMPTY_OBJECTS);
		}
		return null;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
