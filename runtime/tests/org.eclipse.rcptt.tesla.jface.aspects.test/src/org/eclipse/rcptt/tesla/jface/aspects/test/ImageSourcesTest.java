/*******************************************************************************
 * Copyright (c) 2009, 2017 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.jface.aspects.test;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.rcptt.tesla.jface.ImageSources;
import org.eclipse.rcptt.tesla.jface.ImageSources.CompositeSource;
import org.eclipse.rcptt.tesla.jface.ImageSources.ImageSource;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class ImageSourcesTest {
	private static final ISharedImages SHARED_IMAGES = PlatformUI.getWorkbench().getSharedImages();
	
	@Test
	public void getImageData() {
		Image folder = SHARED_IMAGES.getImage(ISharedImages.IMG_OBJ_FOLDER);
		ImageDescriptor[] overlays = new ImageDescriptor[IDecoration.BOTTOM_RIGHT + 1];
		URL url = Platform.getBundle("org.eclipse.ui").getEntry("icons/full/ovr16/warning_ovr.png");
		overlays[IDecoration.BOTTOM_RIGHT] = ImageDescriptor.createFromURL(url);
		
		DecorationOverlayIcon icon = new DecorationOverlayIcon(folder, overlays);
		Image iconImage = (Image)icon.createResource(Display.getCurrent());
		try {
			ImageSource imageSource = ImageSources.INSTANCE.find(iconImage);
			CompositeSource composite = (CompositeSource) imageSource;
			List<String> strings = composite.children.stream().map(Object::toString).collect(Collectors.toList());
			Assert.assertEquals(ImmutableList.of("org.eclipse.ui/icons/full/obj16/fldr_obj.png", "org.eclipse.ui/icons/full/ovr16/warning_ovr.png"), strings);
		} finally {
			iconImage.dispose();
		}
	}

}
