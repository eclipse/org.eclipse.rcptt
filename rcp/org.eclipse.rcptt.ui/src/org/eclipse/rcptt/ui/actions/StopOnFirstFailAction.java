/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.actions;

import org.eclipse.jface.action.Action;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;

public class StopOnFirstFailAction extends Action {
	private boolean fValue;

	public StopOnFirstFailAction(boolean stopOnFirstFail) {
		fValue = stopOnFirstFail;
		setToolTipText(Messages.StopOnFirstFailAction_ToolTip);
		setImageDescriptor(Images.getImageDescriptor(Images.SCENARIO_STOP));
		setChecked(fValue);
	}

	@Override
	public void run() {
		fValue = !fValue;
		setChecked(fValue);
	}

	public boolean getValue() {
		return fValue;
	}
}
