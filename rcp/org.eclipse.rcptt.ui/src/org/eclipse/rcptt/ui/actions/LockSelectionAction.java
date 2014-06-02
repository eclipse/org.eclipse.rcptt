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
package org.eclipse.rcptt.ui.actions;

import org.eclipse.jface.action.Action;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.launching.ExecutionView;
import org.eclipse.rcptt.ui.utils.Executables;

public class LockSelectionAction extends Action {
	private ExecutionView view;

	public LockSelectionAction(ExecutionView view) {
		setToolTipText(Messages.LockSelectionAction_ToolTip);
		setImageDescriptor(Images.getImageDescriptor(Images.SCROLL_LOCK));
		this.view = view;
		setChecked(view.getScrollState());
	}

	public void inputChanged(Executables executables) {
	}

	@Override
	public void run() {
		setChecked(view.updateScrollState());
	}
}
