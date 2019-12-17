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
package org.eclipse.rcptt.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.utils.Executables;

public class CollapseAllAction extends Action {
	private TreeViewer viewer;

	public CollapseAllAction(TreeViewer viewer) {
		setToolTipText(Messages.CollapseAllAction_ToolTip);
		setImageDescriptor(Images.getImageDescriptor(Images.COLLAPSEALL));
		this.viewer = viewer;
	}

	public void inputChanged(Executables executables) {
	}

	@Override
	public void run() {
		viewer.collapseAll();
	}
}
