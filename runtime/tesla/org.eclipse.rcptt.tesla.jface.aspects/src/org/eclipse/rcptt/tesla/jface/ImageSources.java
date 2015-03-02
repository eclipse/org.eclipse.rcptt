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
package org.eclipse.rcptt.tesla.jface;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.rcptt.tesla.swt.images.ImageDataMapping;
import org.eclipse.rcptt.util.WeakIdentityHashMap;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.osgi.framework.Bundle;

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

		if (ResourceSource.isValidSource(descriptor)) {
			result = new ResourceSource(descriptor);
			descriptors.put(descriptor, result);
			return result;
		} else {
			return null;
		}
	}

	public synchronized void imageDataFromDescriptor(ImageData imageData,
			ImageDescriptor descriptor) {
		imageOrDataFromDescriptor(dedup(imageData), descriptor);
	}

	public synchronized void imageFromDescriptor(Image image,
			ImageDescriptor descriptor) {
		imageOrDataFromDescriptor(dedup(image), descriptor);
	}

	private synchronized void imageOrDataFromDescriptor(Object imageOrData,
			ImageDescriptor descriptor) {
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

	public synchronized void imageDrawn(ImageData data,
			ImageDescriptor descriptor) {
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

		enum DescriptorInfo {
			BUNDLE_URL("URLImageDescriptor\\(((bundleentry|bundleresource).*)\\)") {
				@Override
				String extract(Matcher matcher) {
					String uriStr = matcher.group(1);
					URI bundleUri = null;
					try {
						bundleUri = new URI(uriStr);
					} catch (URISyntaxException e) {
						return "InvalidUri(" + uriStr + ")";
					}

					String host = bundleUri.getHost();
					int bundleIdEndIndex = host.indexOf(".fwk");
					if (bundleIdEndIndex == -1) {
						return "UnknownBundleId(" + uriStr + ")";
					}

					int bundleId = -1;
					try {
						bundleId = Integer.parseInt(host.substring(0, bundleIdEndIndex));
					} catch (NumberFormatException e) {
						return "UnknownBundleId(" + uriStr + ")";
					}

					Bundle imageBundle = JFaceAspectsActivator.getDefault().getBundle().getBundleContext()
							.getBundle(bundleId);
					String bundleName = imageBundle == null ? "unknownBundle" : imageBundle.getSymbolicName();
					return String.format("%s%s", bundleName, bundleUri.getPath());
				}
			},

			ABSOLUTE_URL("URLImageDescriptor\\((file:/|platform:/plugin/)(.*)\\)") {
				@Override
				String extract(Matcher matcher) {
					return matcher.group(2);
				}
			},

			FILE_CLASS("FileImageDescriptor\\(location=class (.*), name=(.*)\\)") {
				@Override
				String extract(Matcher matcher) {
					return String.format("%s%s", matcher.group(1), matcher.group(2));
				}
			};

			public final Pattern pattern;

			DescriptorInfo(String expression) {
				this.pattern = Pattern.compile(expression);
			}

			public static boolean isValid(String str) {
				for (DescriptorInfo i : DescriptorInfo.values()) {
					if (i.pattern.matcher(str).matches()) {
						return true;
					}
				}

				return false;
			}

			public static String getInfo(String str) {
				for (DescriptorInfo i : DescriptorInfo.values()) {
					Matcher matcher = i.pattern.matcher(str);
					if (matcher.matches()) {
						return i.extract(matcher);
					}
				}

				return str;
			}

			abstract String extract(Matcher matcher);
		}

		public final String source;

		public ResourceSource(ImageDescriptor source) {
			this.source = getInfo(source.toString());
		}

		public static boolean isValidSource(ImageDescriptor source) {
			return DescriptorInfo.isValid(source.toString());
		}

		public static String getInfo(String str) {
			return DescriptorInfo.getInfo(str);
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
