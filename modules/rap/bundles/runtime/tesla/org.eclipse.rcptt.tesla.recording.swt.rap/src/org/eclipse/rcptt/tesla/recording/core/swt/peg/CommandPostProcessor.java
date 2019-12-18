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
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.ITeslaRecordingListener;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.CollapseApplyDeactivate;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.CollapseClickText;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.CollapseSelectAfterCellEdit;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.CollapseTraverse;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.DuplicateMouseMoveOverEditPart;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.DuplicateSetCaretPositionStyledText;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.DuplicateSetFocus;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.KeepOnlyLastDragSetData;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.MouseUpSameCellAsMouseDown;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.MouseUpSameTableAsMouseDown;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.QuickAccessIgnoreEmptySetText;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.RemoveMouseMoveAndMousePressBeforeDragStart;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.RemoveMousePressBeforeDragStart;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.SelectAfterMouseDownInTable;
import org.eclipse.rcptt.tesla.recording.core.swt.peg.rules.SetTextAfterSetFocus;
import org.eclipse.rcptt.tesla.recording.core.swt.rap.BasicRecordingHelper;

@SuppressWarnings("unused")
public class CommandPostProcessor implements ITeslaRecordingListener {
	public CommandPostProcessor(TeslaRecorder recorder) {
		this.recorder = recorder;
	}

	private TeslaRecorder recorder;
	private static final List<ProcessingRule> rules = new LinkedList<ProcessingRule>(asList(
			new DuplicateSetCaretPositionStyledText(),
			new SelectAfterMouseDownInTable(),
			new MouseUpSameCellAsMouseDown(),
			new MouseUpSameTableAsMouseDown(),
			new DuplicateSetFocus(),
			new RemoveMouseMoveAndMousePressBeforeDragStart(),
			new RemoveMousePressBeforeDragStart(),
			new SetTextAfterSetFocus(),
			new CollapseClickText(),
			new CollapseTraverse(),
			new QuickAccessIgnoreEmptySetText(),
			new DuplicateMouseMoveOverEditPart(),
			new KeepOnlyLastDragSetData(),
			new CollapseSelectAfterCellEdit(),
			new CollapseApplyDeactivate()
			));

	/**
	 * Use this method to extend the post-processor with custom rules. Call it
	 * from {@link IRecordingProcessor#initialize(TeslaRecorder) initialization}
	 * method of corresponding recording processor.
	 */
	public static void addRule(ProcessingRule rule) {
		rules.add(rule);
	}

	//

	public void recordCommand(Command command, List<Element> elements,
			CommandTransferKind kind, List<Widget> controls, int index,
			List<RawEvent> rawEvents) {
		boolean alreadyDumped = false;

		for (ProcessingRule rule : rules) {
			List<Command> commands = recorder.getContainer().getCommands();

			if (!rule.matches(commands)) {
				continue;
			}
			applyResult(rule.apply(commands));
		}
	}

	// Leaving for debugging purposes
	private void dumpCommands(List<Command> commands) {
		for (int i = 0; i < commands.size(); ++i) {
			System.out.println(i + ":" + commands.get(i).toString());
		}
	}

	// Leaving for debugging purposes
	protected void checkIntegrity() {
		// at first, make sure all elements in element command can be found in
		List<Command> commands = recorder.getContainer().getCommands();
		List<CommandToElementEntry> mappings = recorder.getContainer()
				.getScenario().getElementMapping();
		Set<String> knownElements = new HashSet<String>();
		for (CommandToElementEntry entry : mappings) {
			knownElements.add(entry.getElements().get(0).getId());
		}

		for (Command cmd : commands) {
			Element element = (cmd instanceof ElementCommand) ? ((ElementCommand) cmd)
					.getElement() : ((SelectCommand) cmd).getData().getParent();
			if (element != null && !knownElements.contains(element.getId())) {
				System.out.println("Unknown element " + element.getId());
			}
		}
	}

	private void applyResult(ApplicationResult result) {
		Map<SelectCommand, Element> droppedElements = getElementsBySelect(
				recorder.getContainer(), result.drop);

		for (int i = 0; i < result.drop; i++) {
			recorder.removeLast();
		}

		for (int i : result.remove)
			recorder.remove(i);

		Map<String, String> elementSubstitutions = new HashMap<String, String>();
		for (Command cmd : result.add) {
			if (cmd instanceof SelectCommand) {
				executeSelectCommand((SelectCommand) cmd, droppedElements,
						elementSubstitutions);
			} else if (cmd instanceof ElementCommand) {
				executeElementCommand((ElementCommand) cmd,
						elementSubstitutions);
			} else {
				recorder.executeCommand(cmd);
			}
		}
		removeElementsFromMappers(droppedElements.values());
		checkIntegrity();
	}

	private void executeElementCommand(ElementCommand cmd,
			Map<String, String> substitutions) {
		String substitution = substitutions.get(cmd.getElement().getId());
		if (substitution != null) {
			cmd.getElement().setId(substitution);
		}
		recorder.executeCommand(EcoreUtil.copy(cmd));
	}

	private void executeSelectCommand(SelectCommand cmd,
			Map<SelectCommand, Element> droppedElements,
			Map<String, String> mapping) {
		SelectCommand copy = EcoreUtil.copy(cmd);
		Element parent = cmd.getData().getParent();
		if (parent != null && mapping.containsKey(parent.getId())) {
			parent.setId(mapping.get(parent.getId()));
		}
		List<Element> elements = ((SelectResponse) recorder
				.executeCommand(copy)).getElements();
		if (!droppedElements.containsKey(cmd) || elements.size() != 1) {
			return;
		}
		Element old = droppedElements.get(cmd);
		Element updated = elements.get(0);
		mapping.put(old.getId(), updated.getId());
		updateElementMappers(old, updated);
		droppedElements.remove(cmd); // so that we know this command has been
										// added back

	}

	@SuppressWarnings("unchecked")
	private List<BasicRecordingHelper<Object>> getAllHelpers() {
		List<BasicRecordingHelper<Object>> result = new ArrayList<BasicRecordingHelper<Object>>();
		for (IRecordingProcessor processor : recorder
				.getProcessors(IRecordingProcessor.class)) {
			IRecordingHelper<?> helper = processor.getHelper();
			if (!(helper instanceof BasicRecordingHelper<?>)) {
				continue;
			}

			result.add((BasicRecordingHelper<Object>) helper);
		}
		return result;
	}

	private void removeElementsFromMappers(Collection<Element> elements) {
		for (BasicRecordingHelper<Object> rh : getAllHelpers()) {
			for (Element element : elements) {
				Object key = rh.findByElement(element);
				if (key == null) {
					continue;
				}
				rh.remove(key);
			}
		}

	}

	private void updateElementMappers(Element old, Element updated) {
		for (BasicRecordingHelper<Object> rh : getAllHelpers()) {
			Object key = rh.findByElement(old);
			if (key == null) {
				continue;
			}
			rh.get(key).getElement().setId(updated.getId());
		}
	}

	private static Map<SelectCommand, Element> getElementsBySelect(
			TeslaScenarioContainer container, int drop) {
		Map<SelectCommand, Element> result = new HashMap<SelectCommand, Element>();
		for (SelectCommand cmd : getSelectCommands(container.getCommands(),
				drop)) {
			Element element = getSelectElement(container, cmd);
			if (element != null) {
				result.put(cmd, element);
			}
		}
		return result;
	}

	private static Element getSelectElement(TeslaScenarioContainer container,
			SelectCommand command) {
		for (CommandToElementEntry entry : container.getScenario()
				.getElementMapping()) {
			if (EcoreUtil.equals(entry.getCommand(), command)
					&& entry.getElements().size() > 0) {
				return entry.getElements().get(0);
			}
		}
		return null;
	}

	private static List<SelectCommand> getSelectCommands(
			List<Command> commands, int drop) {
		int length = commands.size();
		List<SelectCommand> result = new ArrayList<SelectCommand>();
		for (int i = length - drop; i < length; i++) {
			Command cmd = commands.get(i);
			if (cmd instanceof SelectCommand) {
				result.add((SelectCommand) cmd);
			}
		}
		return result;
	}
}
