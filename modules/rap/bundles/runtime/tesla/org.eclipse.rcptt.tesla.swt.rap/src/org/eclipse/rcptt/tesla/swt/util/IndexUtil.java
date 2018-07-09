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
package org.eclipse.rcptt.tesla.swt.util;

import static org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer.isVisible;

import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;

public class IndexUtil {

	public static interface Criterion {
		boolean fits(SWTUIElement uiElem);
	}

	public static SWTUIElement selectFrom(SWTUIElement[] from, Integer index,
			Criterion crite) {

		int i = 0;
		for (SWTUIElement uiElem : from) {
			if (isVisible(uiElem) && crite.fits(uiElem)) {
				if (index == null || index == i)
					return uiElem;
				i++;
			}
		}

		return null;
	}

	public static int calcIndexFor(Widget w, SWTUIElement[] in, Criterion crite) {

		int index = 0;
		for (SWTUIElement uiElem : in) {
			if (isVisible(uiElem) && crite.fits(uiElem)) {
				if (uiElem.match(w))
					return index;
				else
					index++;
			}
		}

		throw new IllegalArgumentException("Searching widget should be matched by" +
				" at least one of the SWTUIElements");
	}

}
