/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.io.ByteArrayOutputStream;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class SWTScreenCapturer implements IScreenCapturer {

	public SWTScreenCapturer() {
	}

	public byte[] makeScreenShotData(Display display, int x, int y, int width,
			int height, Rectangle arect, boolean scale_640_480) {
		// GC gc = new GC(display);
		// Rectangle bounds = display.getBounds();
		// if (x < 0) {
		// x = 0;
		// }
		// if (y < 0) {
		// y = 0;
		// }
		// if (x + width > bounds.width) {
		// width = bounds.width - x;
		// }
		// if (y + height > bounds.height) {
		// height = bounds.height - y;
		// }
		// if (width <= 0) {
		// width = bounds.width;
		// x = 0;
		// }
		// if (height <= 0) {
		// y = 0;
		// height = bounds.height;
		// }
		//
		// Image image = new Image(display, width, height);
		// gc.copyArea(image, x, y);
		// gc.dispose();
		//
		// // BufferedImage bufferedImage = robot
		// // .createScreenCapture(new java.awt.Rectangle(x, y, width,
		// // height));
		// if (arect != null) {
		// GC imgGC = new GC(image);
		//
		// imgGC.setForeground(display.getSystemColor(SWT.COLOR_RED));
		// imgGC.drawRectangle(arect.x - x, arect.y - y, arect.width - 1,
		// arect.height - 1);
		// imgGC.dispose();
		// }
		// if (scale_640_480) {
		// double ra = Math.max((double) (width / 640.0),
		// (double) (height / 480.0));
		//
		// int rx = (int)(width / ra);
		// int ry = (int)(height / ra);
		//
		// Image newImage = new Image(display, rx, ry);
		// gc = new GC(newImage);
		// gc.setAntialias(SWT.ON);
		// gc.setInterpolation(SWT.HIGH);
		// gc.drawImage(image, 0, 0, width, height, 0, 0, rx, ry);
		// gc.dispose();
		// image.dispose();
		// image = newImage;
		// }

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		// ImageLoader imageLoader = new ImageLoader();
		// imageLoader.data = new ImageData[] { image.getImageData() };
		// imageLoader.save(bout, SWT.IMAGE_PNG);
		// image.dispose();
		return bout.toByteArray();
	}
}
