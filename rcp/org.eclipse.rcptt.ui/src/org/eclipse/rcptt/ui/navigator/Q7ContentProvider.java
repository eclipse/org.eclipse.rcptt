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
package org.eclipse.rcptt.ui.navigator;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.internal.navigator.resources.workbench.ResourceExtensionContentProvider;

@SuppressWarnings("restriction")
public class Q7ContentProvider extends ResourceExtensionContentProvider {

	private Viewer viewer;

	@Override
	public void dispose() {
		if (viewer != null) {
			IWorkspace workspace = null;
			Object obj = viewer.getInput();
			if (obj instanceof IWorkingSet) {
				workspace = ResourcesPlugin.getWorkspace();
				if (workspace != null) {
					workspace.removeResourceChangeListener(this);
				}
			}
		}

		super.dispose();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		super.inputChanged(viewer, oldInput, newInput);

		this.viewer = viewer;

		if (oldInput instanceof IWorkingSet) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			if (workspace != null) {
				workspace.removeResourceChangeListener(this);
			}
		}

		if (newInput instanceof IWorkingSet) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			if (workspace != null) {
				workspace.addResourceChangeListener(this,
						IResourceChangeEvent.POST_CHANGE);
			}
		}
	}
}
