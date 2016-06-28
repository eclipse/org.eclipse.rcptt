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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetObject;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class GetObjectService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		final GetObject cmd = (GetObject) command;
		final EObject target = cmd.getObject();
		if (target instanceof ControlHandler) {
			final Element element = TeslaBridge.find((ControlHandler) target);
			if (element == null) {
				return TeslaImplPlugin.err("Cannot find element");
			}
			SWTUIElement swtElement = TeslaBridge.getClient().getProcessor(SWTUIProcessor.class)
					.getMapper().get(element);
			if (swtElement == null) {
				return TeslaImplPlugin.err("Cannot find element");
			}
			return swtElement.widget;
		} else
			return TeslaImplPlugin.err(String.format("Usupported type %s",
					target.getClass()));
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
