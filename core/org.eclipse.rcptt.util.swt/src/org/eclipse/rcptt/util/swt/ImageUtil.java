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
package org.eclipse.rcptt.util.swt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

public class ImageUtil {
	public static byte[] serializeImage(Image img) {
		ImageLoader imageLoader = new ImageLoader();
		imageLoader.data = new ImageData[] { img.getImageData() };
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		imageLoader.save(stream, SWT.IMAGE_PNG);
		return stream.toByteArray();
	}

	public static Image deserializeImage(Display display, byte[] img) {
		ImageLoader imageLoader = new ImageLoader();
		ByteArrayInputStream stream = new ByteArrayInputStream(img);
		ImageData[] data = imageLoader.load(stream);
		return new Image(display, data[0]);
	}
}
