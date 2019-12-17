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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;

import org.eclipse.rcptt.tesla.core.protocol.LinkUIElement;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ClickLink;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;

public class ClickLinkService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		ClickLink cl = (ClickLink) command;
		ControlHandler control = cl.getControl();
		new LinkUIElement(TeslaBridge.find(control), TeslaBridge.getPlayer())
				.clickLink(cl.getRef());
		return control;
	}

}
