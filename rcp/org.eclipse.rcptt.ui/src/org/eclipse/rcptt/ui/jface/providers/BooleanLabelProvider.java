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
package org.eclipse.rcptt.ui.jface.providers;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

/** Draws a checkbox */
public abstract class BooleanLabelProvider extends ColumnLabelProvider {
	
	
	private static Image loadImageCached(String cacheKey, String path) {
		ImageRegistry registry = JFaceResources.getImageRegistry();
		synchronized (registry) {
			Image rv = registry.get(cacheKey);
			if (rv == null) {
				registry.put(cacheKey, ImageDescriptor.createFromFile(BooleanLabelProvider.class, "/icons/providers/"+path));
				rv = registry.get(cacheKey);
			}
			assert rv != null;
			return rv;
		}
	}
	
	static final Image checkedImage   = loadImageCached("unchecked", "checked-win.png");
	static final Image uncheckedImage = loadImageCached("checked",   "unchecked-win.png");
	
	@Override
	public final String getText(Object element) {
		return "";
	}

	@Override
	public final Image getImage(Object element) {
		if (isChecked(element)) {
			return checkedImage;
		} else {
			return uncheckedImage;
		}
	}


	public abstract boolean isChecked(Object element);
	

}
