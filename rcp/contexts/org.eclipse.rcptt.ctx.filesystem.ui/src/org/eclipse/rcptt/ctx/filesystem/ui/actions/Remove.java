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

import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.ctx.filesystem.FSUtils;
import org.eclipse.rcptt.filesystem.FSResource;

public class Remove extends FSAction {

	public Remove() {
		super("Remove", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		setToolTipText("Removes a file or folder (Del)");
	}

	@Override
	protected void init() {
		setEnabled(selection != null && selection.length > 0);
	}

	@Override
	public void run() {
		for (FSResource res : selection) {
			FSUtils.remove(res);
		}
	}

}