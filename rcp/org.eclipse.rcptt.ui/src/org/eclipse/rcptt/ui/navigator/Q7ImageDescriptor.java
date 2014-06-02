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
package org.eclipse.rcptt.ui.navigator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;

import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;

public class Q7ImageDescriptor extends CompositeImageDescriptor {
	private ImageDescriptor fBaseImage;
	private int fFlags;
	private Point fSize;

	public Q7ImageDescriptor(ImageDescriptor baseImage, int flags, Point size) {
		fBaseImage = baseImage;
		Assert.isNotNull(fBaseImage);
		fFlags = flags;
		Assert.isTrue(fFlags >= 0);
		fSize = size;
		Assert.isNotNull(fSize);
	}

	public void setAdornments(int adornments) {
		Assert.isTrue(adornments >= 0);
		fFlags = adornments;
	}

	public int getAdronments() {
		return fFlags;
	}

	public void setImageSize(Point size) {
		Assert.isNotNull(size);
		Assert.isTrue(size.x >= 0 && size.y >= 0);
		fSize = size;
	}

	public Point getImageSize() {
		return new Point(fSize.x, fSize.y);
	}

	protected Point getSize() {
		return fSize;
	}

	public boolean equals(Object object) {
		if (object == null
				|| !Q7ImageDescriptor.class.equals(object.getClass()))
			return false;

		Q7ImageDescriptor other = (Q7ImageDescriptor) object;
		return (fBaseImage.equals(other.fBaseImage) && fFlags == other.fFlags && fSize
				.equals(other.fSize));
	}

	public int hashCode() {
		return fBaseImage.hashCode() | fFlags | fSize.hashCode();
	}

	protected void drawCompositeImage(int width, int height) {
		ImageData bg = getImageData(fBaseImage);

		drawImage(bg, 0, 0);

		drawTopRight();
		drawBottomRight();
		drawBottomLeft();

	}

	private ImageData getImageData(ImageDescriptor descriptor) {
		ImageData data = descriptor.getImageData(); // see bug 51965:
													// getImageData can return
													// null
		if (data == null) {
			data = DEFAULT_IMAGE_DATA;
			RcpttPlugin.log(
					Messages.bind("Image data not available: {0}", descriptor), //$NON-NLS-1$
					null);
		}
		return data;
	}

	@SuppressWarnings("unused")
	private void addTopRightImage(ImageDescriptor desc, Point pos) {
		ImageData data = getImageData(desc);
		int x = pos.x - data.width;
		if (x >= 0) {
			drawImage(data, x, pos.y);
			pos.x = x;
		}
	}

	@SuppressWarnings("unused")
	private void addBottomRightImage(ImageDescriptor desc, Point pos) {
		ImageData data = getImageData(desc);
		int x = pos.x - data.width;
		int y = pos.y - data.height;
		if (x >= 0 && y >= 0) {
			drawImage(data, x, y);
			pos.x = x;
		}
	}

	private void addBottomLeftImage(ImageDescriptor desc, Point pos) {
		ImageData data = getImageData(desc);
		int x = pos.x;
		int y = pos.y - data.height;
		if (x + data.width < getSize().x && y >= 0) {
			drawImage(data, x, y);
			pos.x = x + data.width;
		}
	}

	private void drawTopRight() {
	}

	private void drawBottomRight() {
	}

	private void drawBottomLeft() {
		Point pos = new Point(0, getSize().y);
		if ((fFlags & IMarker.SEVERITY_ERROR) != 0) {
			addBottomLeftImage(Images.getImageDescriptor(Images.OVERLAY_ERROR),
					pos);
		}
		if ((fFlags & IMarker.SEVERITY_WARNING) != 0) {
			addBottomLeftImage(
					Images.getImageDescriptor(Images.OVERLAY_WARNING), pos);
		}

	}
}
