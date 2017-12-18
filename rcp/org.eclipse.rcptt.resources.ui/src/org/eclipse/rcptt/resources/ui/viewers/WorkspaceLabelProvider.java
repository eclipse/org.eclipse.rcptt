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
package org.eclipse.rcptt.resources.ui.viewers;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.rcptt.internal.ui.FileImages;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFileLink;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSFolderLink;
import org.eclipse.rcptt.workspace.WSLink;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSProjectLink;
import org.eclipse.rcptt.workspace.WSResource;
import org.eclipse.swt.graphics.Image;

public class WorkspaceLabelProvider extends BaseLabelProvider implements
		IStyledLabelProvider {

	private FileImages fileImages = new FileImages(Images.getImage(Images.FILE));

	@Override
	public void dispose() {
		fileImages.dispose();
	}

	public Image getImage(Object element) {
		String key = null;
		if (element instanceof WSProject || element instanceof WSProjectLink)
			key = Images.PROJECT;
		else if (element instanceof WSFolder || element instanceof WSFolderLink)
			key = Images.FOLDER;
		else if (element instanceof WSFile || element instanceof WSFileLink) {
			WSResource resource = (WSResource) element;
			return fileImages.get(resource.getName());
		}

		if (key != null)
			return Images.getImage(key);
		else
			return null;
	}

	public StyledString getStyledText(Object element) {
		StyledString r = new StyledString();
		r.append(((WSResource) element).getName());
		if (element instanceof WSLink) {
			WSLink link = (WSLink) element;
			if (link.getPath() == null || link.getPath().length() == 0)
				r.append(String.format(" - %s", link.getProject()),
						StyledString.QUALIFIER_STYLER);
			else
				r.append(
						String.format(" - %s/%s", link.getProject(),
								link.getPath()), StyledString.QUALIFIER_STYLER);
		}
		return r;
	}

}
