/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.player;

import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.internal.WorkbenchPartReference;

@SuppressWarnings("restriction")
public class PlayerWrapUtils {

	public static Object unwrap(SWTUIElement element) {
		if (element == null) {
			return null;
		} else if (element instanceof WorkbenchUIElement) {
			return ((WorkbenchUIElement) element).reference;
		}
		try {
			if (element instanceof FormTextLinkUIElement) {
				Object result = ((FormTextLinkUIElement) element).segment;
				if (result != null) {
					return result;
				}
			}
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
		return (element).widget;
	}

	/**
	 * 
	 * @param widget
	 * @return <code>null</code> if input is <code>null</code>, corresponding
	 *         widget otherwise
	 */
	public static Widget unwrapWidget(SWTUIElement widget) {
		if (widget == null) {
			return null;
		} else if (widget instanceof WorkbenchUIElement) {
			return ((WorkbenchPartReference) (((WorkbenchUIElement) widget).reference))
					.getPane().getControl();

		} else {
			return widget.widget;
		}
	}
}
