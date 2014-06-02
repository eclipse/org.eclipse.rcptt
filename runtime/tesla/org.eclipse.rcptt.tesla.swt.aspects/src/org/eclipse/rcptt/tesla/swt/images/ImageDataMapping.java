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
package org.eclipse.rcptt.tesla.swt.images;

import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import org.eclipse.rcptt.util.WeakIdentityHashMap;

/**
 * When {@link Image} is created from {@link ImageData} or vice versa, this
 * class stores references from created object to its origin.
 * 
 * References to origin are always flattened, i.e. if image3 created from image2
 * and image2 created from image1, then
 * <code>getSource(image3) == getSource(image2) == image1</code>
 * 
 */
public enum ImageDataMapping {
	INSTANCE;
	private Map<Object, Object> sources = new WeakIdentityHashMap<Object, Object>();

	public Object getSource(Object o) {
		return sources.get(o);
	}

	public void imageFromImage(Image result, Image source) {
		store(result, source);
	}

	public void imageDataFromImageData(ImageData result, ImageData source) {
		store(result, source);
	}

	public void imageFromImageData(Image result, ImageData source) {
		store(result, source);
	}

	public void imageDataFromImage(ImageData result, Image source) {
		store(result, source);
	}

	private synchronized void store(Object result, Object source) {
		Object parent = sources.get(source);
		if (parent == null) {
			parent = source;
		}
		sources.put(result, parent);
	}
}
