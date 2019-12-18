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
package org.eclipse.rcptt.tesla.jface.rap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.rcptt.tesla.swt.images.ImageDataMapping;
import org.eclipse.rcptt.util.WeakIdentityHashMap;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public enum ImageSources {
	INSTANCE;
	private Map<ImageDescriptor, ImageSource> descriptors = new WeakIdentityHashMap<ImageDescriptor, ImageSource>();
	private Map<Object, ImageSource> sources = new WeakIdentityHashMap<Object, ImageSource>();

	public ImageSource find(Image image) {
		return sources.get(dedup(image));
	}

	private synchronized ImageSource findOrCreate(ImageDescriptor descriptor) {
		ImageSource result = descriptors.get(descriptor);
		if (result != null) {
			return result;
		}
		if (descriptor instanceof CompositeImageDescriptor) {
			result = new CompositeSource();
			descriptors.put(descriptor, result);
			return result;
		}

		String info = DescriptorInfo.getInfo(descriptor);
		if (info != null) {
			result = new ResourceSource(info);
			descriptors.put(descriptor, result);
			return result;
		} else {
			return null;
		}
	}

	public synchronized void imageDataFromDescriptor(ImageData imageData, ImageDescriptor descriptor) {
		imageOrDataFromDescriptor(dedup(imageData), descriptor);
	}

	public synchronized void imageFromDescriptor(Image image, ImageDescriptor descriptor) {
		imageOrDataFromDescriptor(dedup(image), descriptor);
	}

	private synchronized void imageOrDataFromDescriptor(Object imageOrData, ImageDescriptor descriptor) {
		ImageSource source = findOrCreate(descriptor);
		if (source == null) {
			return; // unknown origin
		}
		sources.put(imageOrData, source);
	}

	private static Object dedup(Object imageOrData) {
		Object source = ImageDataMapping.INSTANCE.getSource(imageOrData);
		return source == null ? imageOrData : source;
	}

	public synchronized void imageDrawn(ImageData data, ImageDescriptor descriptor) {
		ImageSource composite = findOrCreate(descriptor);
		ImageSource source = sources.get(dedup(data));
		if (source == null) {
			return; // inidentified image data
		}
		if (!(composite instanceof CompositeSource)) {
			return; // consistency error
		}
		((CompositeSource) composite).addUnique(source);
	}

	public static class ImageSource {
	}

	public static class ResourceSource extends ImageSource {
		public final String source;

		public ResourceSource(String source) {
			this.source = source;
		}

		@Override
		public String toString() {
			return source;
		}
	}

	public static class CompositeSource extends ImageSource {
		public final List<ImageSource> children = new ArrayList<ImageSource>();

		public void addUnique(ImageSource source) {
			for (ImageSource src : children) {
				if (src.equals(source)) {
					return;
				}
			}
			children.add(source);
		}

		@Override
		public String toString() {
			return children.toString();
		}
	}

}
