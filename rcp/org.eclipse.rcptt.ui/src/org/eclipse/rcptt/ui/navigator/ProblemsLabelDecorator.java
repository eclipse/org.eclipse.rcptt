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
package org.eclipse.rcptt.ui.navigator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.rcptt.internal.ui.Images;

public class ProblemsLabelDecorator implements ILabelDecorator,
		ILightweightLabelDecorator {

	private ImageDescriptorRegistry fRegistry;

	private ListenerList fListeners;

	public ProblemsLabelDecorator() {
		this(null);
	}

	public ProblemsLabelDecorator(ImageDescriptorRegistry registry) {
		fRegistry = registry;
	}

	private ImageDescriptorRegistry getRegistry() {
		if (fRegistry == null) {
			fRegistry = new ImageDescriptorRegistry();
		}
		return fRegistry;
	}

	public String decorateText(String text, Object element) {
		return text;
	}

	public Image decorateImage(Image image, Object obj) {
		if (image == null)
			return null;

		if (obj instanceof IResource) {
			int adornmentFlags;
			try {
				adornmentFlags = getErrorTicksFromMarkers((IResource) obj,
						IResource.DEPTH_INFINITE);
				if (adornmentFlags != 0) {
					ImageDescriptor baseImage = new ImageImageDescriptor(image);
					Rectangle bounds = image.getBounds();
					return getRegistry().get(
							new Q7ImageDescriptor(baseImage, adornmentFlags,
									new Point(bounds.width, bounds.height)));
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

	private int getErrorTicksFromMarkers(IResource res, int depth)
			throws CoreException {
		if (res == null || !res.isAccessible()) {
			return 0;
		}
		int severity = 0;

		IMarker[] markers = res.findMarkers(IMarker.PROBLEM, true, depth);
		if (markers != null && markers.length > 0) {
			for (int i = 0; i < markers.length
					&& (severity != IMarker.SEVERITY_ERROR); i++) {
				IMarker curr = markers[i];
				int val = curr.getAttribute(IMarker.SEVERITY, -1);
				if (val == IMarker.SEVERITY_WARNING
						|| val == IMarker.SEVERITY_ERROR) {
					severity = val;
				}
			}
		}

		return severity;
	}

	public void dispose() {
		if (fRegistry != null) {
			fRegistry.dispose();
		}
	}

	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	public void addListener(ILabelProviderListener listener) {
		if (fListeners == null) {
			fListeners = new ListenerList();
		}
		fListeners.add(listener);
	}

	public void removeListener(ILabelProviderListener listener) {
		if (fListeners != null) {
			fListeners.remove(listener);
		}
	}

	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof IResource) {
			int adornmentFlags;
			try {
				adornmentFlags = getErrorTicksFromMarkers((IResource) element,
						IResource.DEPTH_INFINITE);
				if (adornmentFlags == IMarker.SEVERITY_ERROR) {
					decoration.addOverlay(Images
							.getImageDescriptor(Images.OVERLAY_ERROR));
				} else if (adornmentFlags == IMarker.SEVERITY_WARNING) {
					decoration.addOverlay(Images
							.getImageDescriptor(Images.OVERLAY_WARNING));
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

}
