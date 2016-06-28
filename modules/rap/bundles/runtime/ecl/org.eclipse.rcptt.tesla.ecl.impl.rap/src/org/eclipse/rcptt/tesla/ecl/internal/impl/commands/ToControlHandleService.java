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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.BoundControlHandleRuntime;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.ToControlHandle;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;

public class ToControlHandleService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		final ToControlHandle cmd = (ToControlHandle) command;
		final Object wannabeWidget = cmd.getWidget();

		if (wannabeWidget instanceof Widget) {
			final Widget widget = (Widget) wannabeWidget;
			BoundControlHandle result = TeslaFactory.eINSTANCE.createBoundControlHandle();
			result.setKind(SWTUIPlayer.getKind(widget).kind);
			Long id = BoundControlHandleRuntime.put(widget);
			if (id == null)
				return TeslaImplPlugin.err("Unable to allocate an ID for the widget.");
			result.setWidgetId(id);
			return result;
		} else
			return TeslaImplPlugin.err(String.format("Usupported type %s",
					wannabeWidget.getClass()));
	}

	@Override
	protected void makeScreenshot(boolean onError, String message) {
		// do nothing
	}

	@Override
	protected Object wrap(Object object) {
		return object; // no wrapping
	}

}
