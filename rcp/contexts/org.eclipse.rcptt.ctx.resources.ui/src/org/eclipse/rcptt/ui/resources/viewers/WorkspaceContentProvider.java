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
package org.eclipse.rcptt.ui.resources.viewers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.rcptt.ctx.resources.WSUtils;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSResource;
import org.eclipse.rcptt.workspace.WorkspaceContext;

public class WorkspaceContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		WSResource resource = (WSResource) parentElement;
		if (resource instanceof WSFolder) {
			return WSUtils.getContents((WSFolder) resource).toArray();
		}
		return null;
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		WSResource resource = (WSResource) element;
		if (resource instanceof WSFolder) {
			return WSUtils.getContents((WSFolder) resource).size() > 0;
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		WorkspaceContext context = (WorkspaceContext) inputElement;
		return WSUtils.getContents(context.getContent()).toArray();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
