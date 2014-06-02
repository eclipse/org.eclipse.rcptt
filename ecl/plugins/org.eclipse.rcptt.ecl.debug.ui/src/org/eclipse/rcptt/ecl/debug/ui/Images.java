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
package org.eclipse.rcptt.ecl.debug.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.swt.graphics.Image;

public class Images {

	private static final String PREFIX = "icons/"; //$NON-NLS-1$

	public static final String LOCAL_VARIABLE = PREFIX + "localvariable_obj.gif"; //$NON-NLS-1$
	public static final String VARIABLE = PREFIX + "field_public_obj.gif"; //$NON-NLS-1$
	public static final String FIELD = PREFIX + "field_protected_obj.gif"; //$NON-NLS-1$
	public static final String OBJECT = PREFIX + "object_icon.gif"; //$NON-NLS-1$
	public static final String REFERENCE = PREFIX + "object_icon.gif"; //$NON-NLS-1$

	public synchronized static Image getImage(String key) {
		ImageRegistry registry = EclDebugUIPlugin.getDefault().getImageRegistry();
		Image image = registry.get(key);
		if (image == null || image.isDisposed()) {
			ImageDescriptor descriptor = getImageDescriptor(key);
			image = descriptor.createImage();
			registry.remove(key);
			registry.put(key, image);
		}
		return image;
	}

	public synchronized static Image getOverlayImageBottomRight(String key, String decor) {
		ImageRegistry registry = EclDebugUIPlugin.getDefault().getImageRegistry();
		Image image = registry.get(key + ".decorator.br" + decor); //$NON-NLS-1$
		if (image == null) {
			ImageDescriptor descriptor = getOverlayImageDescriptor(key, new String[] {
					null, null, null, decor, null });
			image = descriptor.createImage();
			registry.put(key + ".decorator.br" + decor, image); //$NON-NLS-1$
		}
		return image;
	}

	public synchronized static ImageDescriptor getOverlayImageBottomRight(
			ImageDescriptor original, String key, String decor) {
		ImageRegistry registry = EclDebugUIPlugin.getDefault().getImageRegistry();
		ImageDescriptor image = registry.getDescriptor(key + ".decorator.br" + decor); //$NON-NLS-1$
		if (image == null) {
			ImageDescriptor descriptor = getOverlayImageDescriptor(original, key,
					new String[] { null, null, null, decor, null });
			registry.put(key + ".decorator.br" + decor, descriptor); //$NON-NLS-1$
		}
		return image;
	}

	public synchronized static Image getOverlayImageBottomLeft(String key,
			String descriptorKey) {
		ImageRegistry registry = EclDebugUIPlugin.getDefault().getImageRegistry();
		Image image = registry.get(key + ".decorator.bl" + descriptorKey); //$NON-NLS-1$
		if (image == null) {
			ImageDescriptor descriptor = getOverlayImageDescriptor(key, new String[] {
					null, null, descriptorKey, null, null });
			image = descriptor.createImage();
			registry.put(key + ".decorator.bl" + descriptorKey, image); //$NON-NLS-1$
		}
		return image;
	}

	private synchronized static ImageDescriptor getOverlayImageDescriptor(String key,
			String[] descriptorKeys) {
		ImageDescriptor[] decorators = new ImageDescriptor[descriptorKeys.length];
		for (int i = 0; i < decorators.length; i++) {
			if (descriptorKeys[i] != null) {
				decorators[i] = getImageDescriptor(descriptorKeys[i]);
			}
		}
		return new DecorationOverlayIcon(getImage(key), decorators);
	}

	private synchronized static ImageDescriptor getOverlayImageDescriptor(
			ImageDescriptor original, String key, String[] descriptorKeys) {
		ImageDescriptor[] decorators = new ImageDescriptor[descriptorKeys.length];
		for (int i = 0; i < decorators.length; i++) {
			if (descriptorKeys[i] != null) {
				decorators[i] = getImageDescriptor(descriptorKeys[i]);
			}
		}
		return new DecorationOverlayIcon(original.createImage(), decorators);
	}

	public static ImageDescriptor getImageDescriptor(String key) {
		return EclDebugUIPlugin.imageDescriptorFromPlugin(EclDebugUIPlugin.PLUGIN_ID, key);
	}
}
