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
package org.eclipse.rcptt.verifications.tree;

import org.eclipse.rcptt.tesla.core.ui.Image;

public class TreeVerificationUtils {
	public static String getDecoratedImagePath(Image img) {
		if (img == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(img.getPath());

		for (Image decorImg : img.getDecorations()) {
			sb.append('_').append(decorImg.getPath());
		}
		return sb.toString();
	}
}
