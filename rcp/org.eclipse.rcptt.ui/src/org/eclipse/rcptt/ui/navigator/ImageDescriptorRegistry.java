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
package org.eclipse.rcptt.ui.navigator;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.internal.ui.Messages;

@SuppressWarnings("rawtypes")
public class ImageDescriptorRegistry {

	private HashMap fRegistry = new HashMap(10);
	private Display fDisplay;

	public ImageDescriptorRegistry() {
		this(PlatformUI.getWorkbench().getDisplay());
	}

	public ImageDescriptorRegistry(Display display) {
		fDisplay = display;
		Assert.isNotNull(fDisplay);
		hookDisplay();
	}

	@SuppressWarnings("unchecked")
	public Image get(ImageDescriptor descriptor) {
		if (descriptor == null)
			descriptor = ImageDescriptor.getMissingImageDescriptor();

		Image result = (Image) fRegistry.get(descriptor);
		if (result != null)
			return result;

		Assert.isTrue(fDisplay == PlatformUI.getWorkbench().getDisplay(),
				Messages.ImageDescriptorRegistry_InvalidDisplayMsg);
		result = descriptor.createImage();
		if (result != null)
			fRegistry.put(descriptor, result);
		return result;
	}

	public void dispose() {
		for (Iterator iter = fRegistry.values().iterator(); iter.hasNext();) {
			Image image = (Image) iter.next();
			image.dispose();
		}
		fRegistry.clear();
	}

	private void hookDisplay() {
		fDisplay.disposeExec(new Runnable() {
			public void run() {
				dispose();
			}
		});
	}
}
