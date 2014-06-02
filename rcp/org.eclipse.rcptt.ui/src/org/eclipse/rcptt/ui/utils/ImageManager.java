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
package org.eclipse.rcptt.ui.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;

public class ImageManager implements DisposeListener {

	private Map<ImageDescriptor, Image> images = new HashMap<ImageDescriptor, Image>();

	public Image getImage(ImageDescriptor descriptor) {
		Image image = images.get(descriptor);
		if (image == null) {
			image = descriptor.createImage();
			images.put(descriptor, image);
		}
		return image;
	}

	public void dispose() {
		for (Image image : images.values()) {
			if (!image.isDisposed())
				image.dispose();
		}
		images.clear();
	}

	public void widgetDisposed(DisposeEvent e) {
		dispose();
	}

}
