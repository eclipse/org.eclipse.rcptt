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

import org.eclipse.rcptt.internal.ui.Images;

public class Rename extends FSAction {

	public Rename() {
		super("Rename", Images.getImageDescriptor(Images.SCENARIO_EMPTY));
	}

	@Override
	protected void init() {
		setEnabled(selection != null && selection.length == 1);
	}

	@Override
	public void run() {
		viewer.editElement(selection[0], 0);
	}

}
