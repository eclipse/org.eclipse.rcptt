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
package org.eclipse.rcptt.core.recording;

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.Widget;

public class CommandInfo {

	public CommandInfo(Command command, List<Element> elements,
			List<Widget> controls) {
		this.command = command;
		this.elements = elements;
		this.controls = controls;
	}

	public Command getCommand() {
		return command;
	}

	public List<Widget> getControls() {
		return controls;
	}

	public List<Element> getElements() {
		return elements;
	}

	private Command command;
	private List<Element> elements;
	private List<Widget> controls;

}
