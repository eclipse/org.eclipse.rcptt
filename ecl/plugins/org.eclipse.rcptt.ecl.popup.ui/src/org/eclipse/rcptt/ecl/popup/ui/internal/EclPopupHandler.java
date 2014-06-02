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
package org.eclipse.rcptt.ecl.popup.ui.internal;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class EclPopupHandler extends AbstractHandler {

	private IWorkbenchWindow window;

	public Object execute(ExecutionEvent executionEvent) {

		window = HandlerUtil.getActiveWorkbenchWindow(executionEvent);
		if (window == null) {
			return null;
		}

		final PopupDialog popupDialog = new EclPopupDialog(window);
		popupDialog.open();
		return null;
	}
}