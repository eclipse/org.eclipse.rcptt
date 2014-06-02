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
package org.eclipse.rcptt.ctx.workbench.ui.views;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSResource;

public class WorkspaceLabelProvider extends BaseLabelProvider implements
		ILabelProvider {

	public Image getImage(Object element) {
		String key = null;
		if (element instanceof WSProject) {
			key = Images.PROJECT;
		} else if (element instanceof WSFolder) {
			key = Images.FOLDER;
		} else if (element instanceof WSFile) {
			key = Images.FILE;
		}
		if (key != null) {
			return Images.getImage(key);
		}
		return null;
	}

	public String getText(Object element) {
		return ((WSResource) element).getName();
	}

}
