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
package org.eclipse.rcptt.ctx.filesystem.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import org.eclipse.rcptt.filesystem.FSFile;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.filesystem.FSResource;
import org.eclipse.rcptt.internal.ui.FileImages;
import org.eclipse.rcptt.internal.ui.Images;

public class FilesystemContextLabelProvider extends LabelProvider {

	private FileImages fileImages = new FileImages(Images.getImage(Images.FILE));

	@Override
	public void dispose() {
		fileImages.dispose();
	}

	@Override
	public String getText(Object element) {
		return ((FSResource) element).getName();
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof FSFolder)
			return Images.getImage(Images.FOLDER);
		else if (element instanceof FSFile)
			return fileImages.get(((FSFile) element).getName());
		return null;
	}

}
