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

import org.eclipse.rcptt.util.KeysAndButtons;
import org.eclipse.rcptt.tesla.core.protocol.MouseEvent;
import org.eclipse.rcptt.tesla.core.protocol.MouseEventKind;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.Mouse;

public class MouseService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		Mouse cmd = (Mouse) command;
		ControlHandler control = cmd.getControl();
		Element element = TeslaBridge.find(control);
		MouseEvent me = ProtocolFactory.eINSTANCE.createMouseEvent();
		MouseEventKind kind = parseKind(cmd.getEvent());
		int button = getButton(cmd.getButton());
		me.setElement(element);
		me.setKind(parseKind(cmd.getEvent()));
		me.setX(cmd.getX());
		me.setY(cmd.getY());
		me.setCount(getCount(kind));
		me.setButton(button);
		me.setStateMask(KeysAndButtons.stateMaskFromStr(cmd.getWith())
				| getButtonMask(button, kind));

		TeslaBridge.getPlayer().safeExecuteCommand(me);
		return control;
	}

	private static int getButtonMask(int button, MouseEventKind kind)
			throws CoreException {
		if (button == 0) {
			return 0;
		}
		if (isIncludeButtonToMask(kind)) {
			return KeysAndButtons.getButtonMask(button);
		}
		return 0;
	}

	private static boolean isIncludeButtonToMask(MouseEventKind kind) {
		return kind == MouseEventKind.UP;
	}

	private static int getButton(String buttonName) throws CoreException {
		if (buttonName == null || buttonName.length() == 0) {
			return 0;
		}
		return KeysAndButtons.getButtonNumber(buttonName);
	}

	private static int getCount(MouseEventKind kind) {
		switch (kind) {
		case DOUBLE_CLICK:
			return 2;
		case DOWN:
			return 1;
		case UP:
			return 1;
		case ENTER:
			return 0;
		case EXIT:
			return 0;
		case MOVE:
			return 0;
		default:
			return 0;
		}
	}

	private static MouseEventKind parseKind(String str) throws CoreException {
		for (MouseEventKind kind : MouseEventKind.VALUES) {
			if (kind.getLiteral().equalsIgnoreCase(str)) {
				return kind;
			}
		}
		throw new CoreException(TeslaImplPlugin.err(String.format(
				"Unsupported mouse action %s", str)));
	}

}
