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

import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ClickColumn;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;

public class ClickColumnService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		ClickColumn clickColumn = (ClickColumn) command;
		ControlHandler control = clickColumn.getControl();
		new ControlUIElement(TeslaBridge.find(control), TeslaBridge.getPlayer())
				.clickColumn(clickColumn.getName(), clickColumn.getIndex());
		return control;
	}

}
