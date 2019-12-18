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
package org.eclipse.rcptt.core.recording;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.Widget;

public class CommandSet {

	private CommandInfo[] commands;
	private Element element;
	private Widget widget;
	private byte[] imageCapture;

	private CommandSet(Element element, Widget widget, CommandInfo[] commands) {
		this.element = element;
		this.widget = widget;
		this.commands = commands;
	}

	public Widget getWidget() {
		return widget;
	}

	public Element getElement() {
		return element;
	}

	public CommandInfo[] getCommands() {
		return commands;
	}

	public void setImageCapture(byte[] imageCapture) {
		this.imageCapture = imageCapture;
	}

	public byte[] getImageCapture() {
		return imageCapture;
	}

	public static CommandSet create(AssertionFocus focusCommand,
			TeslaScenarioContainer container) throws IllegalArgumentException {
		Element element = focusCommand.getElement();
		if (element == null) {
			throw new IllegalArgumentException(
					"Internal error: selected control haven't element");
		}
		Command cmd = getCommand(element, container);
		if (cmd == null) {
			throw new IllegalArgumentException(
					"Internal error: can't find a command which produce selected element");
		}
		Widget widget = findWidget(cmd, container);
		if (widget == null) {
			throw new IllegalArgumentException(
					"Internal error: can't find widget for selected element");
		}
		List<CommandInfo> commands = new ArrayList<CommandInfo>();
		collectElements(commands, cmd, container);

		final List<Command> originalCommands = container.getCommands();
		Collections.sort(commands, new Comparator<CommandInfo>() {
			public int compare(CommandInfo o1, CommandInfo o2) {
				int i1 = originalCommands.indexOf(o1.getCommand());
				int i2 = originalCommands.indexOf(o2.getCommand());
				if (i1 < i2) {
					return 1;
				}
				return -1;
			}
		});

		int size = commands.size();
		CommandInfo[] resultCommands = new CommandInfo[size];
		for (int i = 0; i < resultCommands.length; i++) {
			resultCommands[i] = commands.get(size - i - 1);
		}
		CommandSet cmdSet = new CommandSet(element, widget, resultCommands);
		cmdSet.setImageCapture(focusCommand.getImageCapture());
		return cmdSet;
	}

	private static void collectElements(List<CommandInfo> commands,
			Command cmd, TeslaScenarioContainer container) {
		for (CommandInfo commandInfo : commands) {
			if (commandInfo.getCommand() == cmd) {
				return;
			}
		}
		CommandInfo info = new CommandInfo(cmd, container.getElements(cmd),
				container.getControls(cmd));
		commands.add(info);
		if (cmd instanceof SelectCommand) {
			SelectCommand sc = (SelectCommand) cmd;

			Element after = sc.getData().getAfter();
			Command afterCommand = getCommand(after, container);
			if (afterCommand != null) {
				collectElements(commands, afterCommand, container);
			}

			Element element = sc.getData().getParent();
			Command newCommand = getCommand(element, container);
			if (newCommand != null) {
				collectElements(commands, newCommand, container);
			}
		}
	}

	private static Command getCommand(Element element,
			TeslaScenarioContainer container) {
		if (element == null || element.getId() == null)
			return null;
		List<Command> commands = container.getCommands();
		for (int i = commands.size() - 1; i >= 0; i--) {
			Command cmd = commands.get(i);
			List<Element> elements = container.getElements(cmd);
			if (elements != null) {
				for (Element elementToCheck : elements) {
					if (element.getId().equals(elementToCheck.getId())) {
						return cmd;
					}
				}
			}
		}
		return null;
	}

	private static Widget findWidget(Command cmd,
			TeslaScenarioContainer container) {
		List<Widget> controls = container.getControls(cmd);
		if (controls != null && controls.size() > 0) {
			return controls.get(0);
		}
		return null;
	}
}
