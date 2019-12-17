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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.features.IMLFeatures;

public class ScreenshotSupport {
	public static void saveImage(ImageData image, String postfix) {
		String path = TeslaFeatures.getInstance().getValue(
				IMLFeatures.IML_CAPTURES_FOLDER);
		if (path != null && new File(path).exists()) {
			ImageLoader loader = new ImageLoader();
			loader.data = new ImageData[] { image };
			try {
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(new File(path),
								"ir_screenshot_" + System.currentTimeMillis()
										+ postfix + ".png")));
				loader.save(stream, SWT.IMAGE_PNG);
				stream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
