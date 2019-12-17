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
package org.eclipse.rcptt.ui.launching.aut;

import org.eclipse.swt.graphics.Image;

import org.eclipse.rcptt.internal.ui.Images;

public class AUTProvider {

	public static Image getImage(AutElement e) {
		if (!e.isValid()) {
			return Images.getOverlayImageBottomLeft(Images.CONFIG,
					Images.OVERLAY_ERROR);			
		}
		if (e.isLaunched()) {
			return Images.getOverlayImageBottomLeft(Images.CONFIG,
					Images.OVERLAY_RUNNING);
		} else {
			return Images.getImage(Images.CONFIG);
		}
	}

	public static String getText(AutElement e) {
		return e.getName();
	}
}
