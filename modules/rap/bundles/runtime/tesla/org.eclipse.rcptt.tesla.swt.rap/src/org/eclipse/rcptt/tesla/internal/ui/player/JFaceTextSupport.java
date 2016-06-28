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

import org.eclipse.jface.viewers.Viewer;

public class JFaceTextSupport {

	public static void setLastPixels(Viewer viewer, int topPixel) {
		// TODO RAP-FIX
		/*
		 * if (viewer instanceof TextViewer) {
		 * setLastTopPixel((TextViewer) viewer, topPixel);
		 * }
		 */
	}

	// TODO RAP-FIX
	/*
	 * public static void setLastTopPixel(TextViewer viewer, int topPixel) {
	 * try {
	 * Field field = TextViewer.class.getDeclaredField("fLastTopPixel");
	 * field.setAccessible(true);
	 * field.set(viewer, Integer.valueOf(topPixel));
	 * } catch (Throwable e) {
	 * TeslaCore.log(e);
	 * }
	 * 
	 * }
	 */

}
