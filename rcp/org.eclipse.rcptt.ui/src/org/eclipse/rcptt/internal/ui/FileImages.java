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
package org.eclipse.rcptt.internal.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.PlatformUI;

public class FileImages {

	private Map<String, Image> cache = new HashMap<String, Image>();
	private IEditorRegistry registry = PlatformUI.getWorkbench()
			.getEditorRegistry();
	private Image defaultImage;

	public FileImages(Image defaultImage) {
		this.defaultImage = defaultImage;
	}

	public Image get(String filename) {
		Image image = cache.get(filename);
		if (image != null && !image.isDisposed())
			return image;

		ImageDescriptor descriptor = registry.getImageDescriptor(filename);
		if (descriptor != null) {
			image = descriptor.createImage();
			cache.put(filename, image);
			return image;
		} else
			return defaultImage;
	}

	public void dispose() {
		for (Image i : cache.values())
			i.dispose();
	}
}
