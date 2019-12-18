/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.swt.internal.ui;

import org.eclipse.rcptt.util.DisplayUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public class DefaultDisplayUtils implements DisplayUtils {

	@Override
	public boolean isWidget(Object object) {
		return object instanceof Widget;
	}

	@Override
	public void asyncExec(Object widget, Runnable runnable) {
		Display display = widget instanceof Widget ? ((Widget) widget).getDisplay() : Display.getDefault();
		display.asyncExec(runnable);
	}

	@Override
	public void syncExec(Object widget, Runnable runnable) {
		Display display = widget instanceof Widget ? ((Widget) widget).getDisplay() : Display.getDefault();
		display.syncExec(runnable);
	}

}
