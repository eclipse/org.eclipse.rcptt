/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.eclipse.rcptt.tesla.core.protocol.GetState;
import org.eclipse.rcptt.tesla.core.protocol.Nop;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand;
import org.eclipse.rcptt.tesla.core.protocol.WaitForState;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.core.ui.Widget;

public class TeslaScenarioContainer {
	private TeslaScenario scenario;
	private XMIResource resource;

	public TeslaScenarioContainer() {
		scenario = RawFactory.eINSTANCE.createTeslaScenario();
		resource = new XMIResourceImpl();
		resource.getContents().add(scenario);
	}

	public TeslaScenarioContainer(TeslaScenario scenario) {
		this.scenario = scenario;
	}

	public synchronized void add(Command command, List<Element> elements, List<Widget> controls,
			List<RawEvent> rawEvents) {
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		Command copy = (command != null) ? (Command) EcoreUtil.copy(command) : null;
		if (copy != null) {
			scenario.getCommands().add(copy);
			setElements(elements, copy, controls);
			setEvents(copy, rawEvents);
		}
	}

	public synchronized void add(int index, Command command, List<Element> elements, List<Widget> controls,
			List<RawEvent> rawEvents) {
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		Command copy = (command != null) ? (Command) EcoreUtil.copy(command) : null;
		scenario.getCommands().add(index, copy);
		setElements(elements, copy, controls);
		setEvents(copy, rawEvents);
	}

	private synchronized void setElements(List<Element> elements, Command copy, List<Widget> controls) {
		if (elements != null && elements.size() > 0) {
			CommandToElementEntry entry = RawFactory.eINSTANCE.createCommandToElementEntry();
			entry.setCommand(copy);
			for (Element element : elements) {
				// eclipse 3.4 compatibility:
				// EcoreUtil.copy raise exception if argument is null
				entry.getElements().add((element != null) ? (Element) EcoreUtil.copy(element) : null);
			}
			if (controls != null) {
				for (Widget control : controls) {
					// eclipse 3.4 compatibility:
					// EcoreUtil.copy raise exception if argument is null
					entry.getControls().add((control != null) ? (Widget) EcoreUtil.copy(control) : null);
				}
			}
			scenario.getElementMapping().add(entry);
		}
	}

	private synchronized void setEvents(Command copy, List<RawEvent> events) {
		if (events != null && events.size() > 0) {
			CommandToRawEntry entry = RawFactory.eINSTANCE.createCommandToRawEntry();
			entry.setCommand(copy);
			for (RawEvent event : events) {
				// eclipse 3.4 compatibility:
				// EcoreUtil.copy raise exception if argument is null
				entry.getRawEvents().add((event != null) ? (RawEvent) EcoreUtil.copy(event) : null);
			}
			scenario.getRawMapping().add(entry);
		}
	}

	private synchronized List<RawEvent> getRawEvents(Command command) {
		if (command != null) {
			EList<CommandToRawEntry> rawMapping = scenario.getRawMapping();
			for (CommandToRawEntry commandToRawEntry : rawMapping) {
				if (commandToRawEntry.getCommand().equals(command)) {
					return commandToRawEntry.getRawEvents();
				}
			}
		}
		return new ArrayList<RawEvent>();
	}

	public synchronized void clear() {
		if (scenario != null) {
			scenario.getCommands().clear();
			scenario.getElementMapping().clear();
		}
	}

	public synchronized List<Command> getCommands() {
		return scenario.getCommands();
	}

	public synchronized List<Element> getElements(Command cmd) {
		EList<CommandToElementEntry> elementMapping = scenario.getElementMapping();
		for (CommandToElementEntry commandToElementEntry : elementMapping) {
			if (commandToElementEntry.getCommand().equals(cmd)) {
				return commandToElementEntry.getElements();
			}
		}
		return null;
	}

	public synchronized List<Widget> getControls(Command cmd) {
		EList<CommandToElementEntry> elementMapping = scenario.getElementMapping();
		for (CommandToElementEntry commandToElementEntry : elementMapping) {
			if (commandToElementEntry.getCommand().equals(cmd)) {
				return commandToElementEntry.getControls();
			}
		}
		return null;
	}

	public synchronized TeslaScenario getScenarioCopy() {
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		return (scenario != null) ? (TeslaScenario) EcoreUtil.copy(scenario) : null;
	}

	public boolean isEmpty() {
		return scenario == null || scenario.getCommands().isEmpty();
	}

	public Command getLastCommand() {
		EList<Command> commands = scenario.getCommands();
		return commands.get(commands.size() - 1);
	}

	public Command getLastCommand(int index) {
		EList<Command> commands = scenario.getCommands();
		return commands.get(commands.size() - index);
	}

	public synchronized Command getLast() {
		EList<Command> commands = scenario.getCommands();
		if (commands.isEmpty()) {
			return null;
		}
		Command last = commands.get(commands.size() - 1);
		return last;
	}

	public synchronized Command removeLast() {
		EList<Command> commands = scenario.getCommands();
		if (commands.isEmpty()) {
			return null;
		}
		Command last = commands.remove(commands.size() - 1);
		EList<CommandToElementEntry> mapping = scenario.getElementMapping();
		List<CommandToElementEntry> toRemove = new ArrayList<CommandToElementEntry>();
		for (CommandToElementEntry commandToElementEntry : mapping) {
			if (commandToElementEntry.getCommand().equals(last)) {
				toRemove.add(commandToElementEntry);
			}
		}
		mapping.removeAll(toRemove);
		EList<CommandToRawEntry> rawMapping = scenario.getRawMapping();
		List<CommandToRawEntry> toRemoveRaw = new ArrayList<CommandToRawEntry>();
		for (CommandToRawEntry commandToRawEntry : rawMapping) {
			if (commandToRawEntry.getCommand().equals(last)) {
				toRemoveRaw.add(commandToRawEntry);
			}
		}
		rawMapping.removeAll(toRemoveRaw);
		return last;
	}

	public synchronized Command remove(int index) {
		EList<Command> commands = scenario.getCommands();
		if (commands.isEmpty())
			return null;

		Command command = commands.remove(index);
		EList<CommandToElementEntry> mapping = scenario.getElementMapping();
		List<CommandToElementEntry> toRemove = new ArrayList<CommandToElementEntry>();
		for (CommandToElementEntry commandToElementEntry : mapping)
			if (commandToElementEntry.getCommand().equals(command))
				toRemove.add(commandToElementEntry);
		mapping.removeAll(toRemove);

		EList<CommandToRawEntry> rawMapping = scenario.getRawMapping();
		List<CommandToRawEntry> toRemoveRaw = new ArrayList<CommandToRawEntry>();
		for (CommandToRawEntry commandToRawEntry : rawMapping)
			if (commandToRawEntry.getCommand().equals(command))
				toRemoveRaw.add(commandToRawEntry);
		rawMapping.removeAll(toRemoveRaw);
		return command;
	}

	public void save(OutputStream stream) {
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SAVE_ONLY_IF_CHANGED, Boolean.FALSE);
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		options.put(XMIResource.OPTION_FORMATTED, Boolean.TRUE);
		try {
			resource.save(stream, options);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void load(InputStream stream) {
		clear();
		resource.getContents().clear();
		// initialize();
		try {
			resource.unload();
			resource.load(stream, null);
			scenario = null;
			EList<EObject> contents = resource.getContents();
			for (EObject eObject : contents) {
				if (eObject instanceof TeslaScenario) {
					scenario = (TeslaScenario) eObject;
				}
			}
			if (scenario == null) {
				scenario = RawFactory.eINSTANCE.createTeslaScenario();
				resource.getContents().add(scenario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isDirty() {
		return resource.isModified();
	}

	public TeslaScenario getScenario() {
		return scenario;
	}

	public void setScenarioID(String name) {
		this.scenario.setId(name);
	}

	public void processTransfer(Command command, List<Element> elements, CommandTransferKind kind,
			List<Widget> controls, int index, List<RawEvent> rawEvents) {

		if (isSystemFilteredCommand(command)) {
			// Doesn't pass to container since command is system one.
			return;
		}
		switch (kind) {
		case REMOVE:
			this.remove(index);
			break;
		case INSERT_BEFORE:
			this.add(this.size() - index, command, elements, controls, rawEvents);
			break;
		case REPLACE_PREVIOUS:
			if (rawEvents != null && scenario.getCommands().size() > 0) {
				List<RawEvent> events = getRawEvents(scenario.getCommands().get(scenario.getCommands().size() - 1));
				events.addAll(rawEvents);
			}
			this.removeLast();
			this.add(command, elements, controls, rawEvents);
			break;
		case INSERT_BEFORE_ESSENTIAL_COMMAND:
			EList<Command> commands = scenario.getCommands();
			for (int i = commands.size() - 1; i >= 0; i--) {
				Command cmd = commands.get(i);
				if (cmd instanceof SelectCommand || cmd instanceof WaitForState || cmd instanceof GetState
						|| cmd instanceof Nop) {
					continue;
				}
				this.add(i, command, elements, controls, rawEvents);
				break;
			}
			break;
		case DEFAULT:
			this.add(command, elements, controls, rawEvents);
			break;
		}
	}

	private boolean isSystemFilteredCommand(Command command) {
		return command instanceof UpdateControlCommand;
	}

	public int size() {
		if (scenario == null) {
			return 0;
		}
		return this.scenario.getCommands().size();
	}
}
