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

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.core.ecl.core.model.ViewInfo;

public class ViewsLabelProvider extends BaseLabelProvider implements
		ILabelProvider {

	private Map<Object, Image> images = new HashMap<Object, Image>();

	@Override
	public void dispose() {
		super.dispose();
		for (Image image : images.values()) {
			image.dispose();
		}
		images.clear();
	}

	public Image getImage(Object element) {
		ViewInfo perspective = (ViewInfo) element;
		byte[] image = perspective.getImage();
		if (!perspective.getItems().isEmpty()) {
			// This is category
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
		if (image != null) {
			if (images.containsKey(element)) {
				return images.get(element);
			}
			Image img = new Image(PlatformUI.getWorkbench().getDisplay(),
					new ByteArrayInputStream(image));
			images.put(element, img);
			return img;
		}
		return null;
	}

	public String getText(Object element) {
		ViewInfo perspective = (ViewInfo) element;
		return removeAccel(perspective.getLabel());
	}

	private String removeAccel(String label) {

		int startBracket = label.indexOf("(&"); //$NON-NLS-1$
		// Non latin accelerator?
		if (startBracket >= 0) {
			int endBracket = label.indexOf(')');

			// If there is more than one character it is not an accelerator
			if ((endBracket - startBracket) == 3) {
				return label.substring(0, startBracket)
						+ label.substring(endBracket + 1);
			}
		}

		int i = label.indexOf('&');
		if (i >= 0) {
			label = label.substring(0, i) + label.substring(i + 1);
		}

		return label;
	}

}
