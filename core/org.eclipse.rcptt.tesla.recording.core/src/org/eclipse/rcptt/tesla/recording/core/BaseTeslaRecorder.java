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
package org.eclipse.rcptt.tesla.recording.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.CheckItem;
import org.eclipse.rcptt.tesla.core.protocol.Children;
import org.eclipse.rcptt.tesla.core.protocol.Click;
import org.eclipse.rcptt.tesla.core.protocol.ClickText;
import org.eclipse.rcptt.tesla.core.protocol.Close;
import org.eclipse.rcptt.tesla.core.protocol.DoubleClick;
import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GetState;
import org.eclipse.rcptt.tesla.core.protocol.GetStateResponse;
import org.eclipse.rcptt.tesla.core.protocol.HoverAtText;
import org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset;
import org.eclipse.rcptt.tesla.core.protocol.Parent;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition;
import org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset;
import org.eclipse.rcptt.tesla.core.protocol.SetFocus;
import org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode;
import org.eclipse.rcptt.tesla.core.protocol.SetText;
import org.eclipse.rcptt.tesla.core.protocol.SetTextOffset;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.TypeText;
import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand;
import org.eclipse.rcptt.tesla.core.protocol.WaitForRestart;
import org.eclipse.rcptt.tesla.core.protocol.WaitForState;
import org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;

public class BaseTeslaRecorder extends UIPlayer {
	private ElementGenerator generator = new ElementGenerator();
	private final TeslaScenarioContainer container = new TeslaScenarioContainer();
	private List<Widget> controls;
	private final List<RawEvent> rawEvents = new ArrayList<RawEvent>();
	private static boolean rawEventsEnabled;
	private static boolean notNativeEventsIgnored;
	private String[] recordModeShortcuts;
	private String[] assertModeShortcuts;
	private String[] startRecordShortcuts;
	private String[] stopRecordShortcuts;
	private String[] replayShortcuts;
	private int replaceIndex = 0;
	private boolean skipNext = false;

	public BaseTeslaRecorder() {
	}

	public synchronized void addRawEvent(RawEvent event) {
		if (rawEventsEnabled) {
			rawEvents.add(event);
		}
	}

	public boolean isRawEventsEnabled() {
		synchronized (BaseTeslaRecorder.class) {
			return rawEventsEnabled;
		}
	}

	public void setRawEvents(boolean equals) {
		synchronized (BaseTeslaRecorder.class) {
			rawEventsEnabled = equals;
		}
	}

	public boolean isNotNativeEventsIgnored() {
		synchronized (BaseTeslaRecorder.class) {
			return notNativeEventsIgnored;
		}
	}

	public void setNotNativeEventsIgnored(boolean value) {
		synchronized (BaseTeslaRecorder.class) {
			notNativeEventsIgnored = value;
		}
	}

	public synchronized String[] getRecordModeShortcuts() {
		return recordModeShortcuts;
	}

	public synchronized String[] getAssertModeShortcuts() {
		return assertModeShortcuts;
	}

	public synchronized String[] getStartRecordShortcuts() {
		return startRecordShortcuts;
	}

	public synchronized String[] getStopRecordShortcuts() {
		return stopRecordShortcuts;
	}

	public synchronized String[] getReplayShortcuts() {
		return replayShortcuts;
	}

	public synchronized void setRecordModeShortcuts(String[] recordModeShortcuts) {
		this.recordModeShortcuts = recordModeShortcuts;
	}

	public synchronized void setAssertModeShortcuts(String[] shortcuts) {
		this.assertModeShortcuts = shortcuts;
	}

	public synchronized void setStartRecordShortcuts(String[] shortcuts) {
		this.startRecordShortcuts = shortcuts;
	}

	public synchronized void setStopRecordShortcuts(String[] shortcuts) {
		this.stopRecordShortcuts = shortcuts;
	}

	public synchronized void setReplayShortcuts(String[] shortcuts) {
		this.replayShortcuts = shortcuts;
	}

	@Override
	public synchronized Response executeCommand(Command command) {
		List<Element> elements = new ArrayList<Element>();
		Response response = null;
		if (command instanceof SelectCommand) {
			Element element = getGenerator().generate(
					((SelectCommand) command).getData().getKind());
			elements.add(element);
			SelectResponse selectResponse = ProtocolFactory.eINSTANCE
					.createSelectResponse();
			selectResponse.getElements().add(element);
			response = selectResponse;
		} else if (command instanceof Parent) {
			Element element = getGenerator().generate("parent");
			elements.add(element);
		} else if (command instanceof CreateFigure) {
			Element element = getGenerator().generate(
					ElementKind.DiagramFigure.name());
			elements.add(element);
		} else if (command instanceof Children) {
			Element element = getGenerator().generate(
					((Children) command).getElement().getKind());
			elements.add(element);
		} else if (command instanceof ActivateDirectEdit) {
			Element element = getGenerator().generate("control");
			elements.add(element);
		} else if (command instanceof GetState) {
			Element element = getGenerator().generate("State");
			elements.add(element);
			GetStateResponse getStateResponse = ProtocolFactory.eINSTANCE
					.createGetStateResponse();
			getStateResponse.setState(element);
			response = getStateResponse;
		}

		CommandTransferKind transferKind = getTransferKind(command);
		container.processTransfer(command, elements, transferKind, controls,
				replaceIndex, rawEvents);

		hookExecuteCommand(command, elements, transferKind, controls,
				replaceIndex, rawEvents);
		controls = null;
		rawEvents.clear();
		return response;
	}

	private CommandTransferKind getTransferKind(Command command) {
		CommandTransferKind transferKind = CommandTransferKind.DEFAULT;
		replaceIndex = 0;
		if (!container.isEmpty() && isReplacable(command)) {
			Command last = container.getLastCommand();
			skipNext = false;
			if (command instanceof FigureMouseCommand) {
				transferKind = getKindForFigureMouseCommand((FigureMouseCommand) command, transferKind);
			} else if (command instanceof SelectCommand) {
				transferKind = getKindForSelectCommand(command, last, transferKind);
			}
			if (isReplacable(last, command) && !skipNext) {
				// Replace old command
				transferKind = CommandTransferKind.REPLACE_PREVIOUS;
			}
		}
		if ((command instanceof SetStatusDialogMode
				&& ((SetStatusDialogMode) command).isEnabled())
				|| command instanceof SetSWTDialogInfo) {
			transferKind = CommandTransferKind.INSERT_BEFORE_ESSENTIAL_COMMAND;
		} else if (command instanceof UpdateControlCommand) {
			transferKind = CommandTransferKind.REMOVE;
		}
		return transferKind;
	}

	private CommandTransferKind getKindForSelectCommand(Command command, Command last, CommandTransferKind transferKind) {
		if (last instanceof SelectCommand) {
			if (EcoreUtil.equals(command, last)) {
				transferKind = CommandTransferKind.REMOVE;
			}
		} else {
			List<Command> commands = container.getCommands();
			if (commands.size() > 1) {
				Command beforeLast = commands.get((commands.size() - 2));
				if (EcoreUtil.equals(command, beforeLast)) {
					transferKind = CommandTransferKind.REMOVE;
				}
			}
		}
		return transferKind;
	}

	private CommandTransferKind getKindForFigureMouseCommand(FigureMouseCommand command,
			CommandTransferKind transferKind) {
		// Look into previous drag command and correct down event.
		if (command.getKind().equals(MouseCommandKind.DOWN)) {
			int skip = 0;
			while (container.size() - (1 + skip) >= 0) {
				Command ncmd = container.getLastCommand(1 + skip);
				if (ncmd instanceof FigureMouseCommand
						&& ((FigureMouseCommand) ncmd).getKind()
								.equals(MouseCommandKind.DRAG)) {
					skip++;
				} else {
					break;
				}
			}
			if (skip > 0) {
				skipNext = true;
				transferKind = CommandTransferKind.INSERT_BEFORE;
				replaceIndex = skip;
			}
		}
		return transferKind;
	}

	public synchronized void setControls(Widget... controls) {
		if (controls.length > 0) {
			this.controls = new ArrayList<Widget>(Arrays.asList(controls));
		} else {
			this.controls = null;
		}
	}

	public synchronized List<Widget> getControls() {
		List<Widget> result = new ArrayList<Widget>();
		if (this.controls != null) {
			result.addAll(this.controls);
		}
		return result;
	}

	private boolean isReplacable(Command current) {
		return (current instanceof SetSelection && !TeslaFeatures.getInstance()
				.isTrue(TeslaFeatures.RECORD_ALL_SELECTIONS))
				|| current instanceof SetText
				|| current instanceof MouseCommand
				|| current instanceof DragCommand
				|| current instanceof CheckItem
				|| current instanceof Close
				|| current instanceof TypeText
				|| current instanceof FigureMouseCommand
				|| current instanceof ApplyCellEditor
				|| current instanceof SetTextOffset
				|| current instanceof SetCaretPosition
				|| current instanceof SetCursorOffset
				|| current instanceof DragCommand
				|| current instanceof DoubleClick
				|| current instanceof WaitForRestart
				|| current instanceof SetTextSelection
				|| current instanceof SetTextSelection2
				|| current instanceof HoverAtText
				|| current instanceof HoverAtTextOffset
				|| current instanceof Type
				|| current instanceof ClickText
				|| current instanceof SetFocus
				|| current instanceof SelectCommand;
	}

	private synchronized boolean isReplacable(Command last, Command newCommand) {
		boolean equals = last.eClass().equals(newCommand.eClass());
		boolean ecoreEquals = false;
		if (newCommand instanceof WaitForRestart) {
			if (last instanceof WaitForState) {
				return true;
			}
		}
		if (last instanceof ElementCommand
				&& newCommand instanceof ElementCommand) {
			Element lastElement = ((ElementCommand) last).getElement();
			Element element = ((ElementCommand) newCommand).getElement();
			if (EcoreUtil.equals(lastElement, element)) {
				ecoreEquals = true;
			}
		}
		if (last instanceof SetFocus) {
			if (newCommand instanceof SetFocus) {
				return ecoreEquals;
			}
			if (newCommand instanceof ClickText) {
				return ecoreEquals;
			}
		}
		if (last instanceof ClickText && newCommand instanceof SetText
				&& ecoreEquals) {
			return true;
		}

		if (newCommand instanceof Type && last instanceof Type && ecoreEquals) {
			Type newTypeCmd = (Type) newCommand;
			Type lastTypeCmd = (Type) last;
			int tempTimes = newTypeCmd.getTimes();
			newTypeCmd.setTimes(lastTypeCmd.getTimes());
			if (EcoreUtil.equals(lastTypeCmd, newTypeCmd)) {
				newTypeCmd.setTimes(lastTypeCmd.getTimes() + 1);
				return true;
			}
			newTypeCmd.setTimes(tempTimes);
			return false;
		}
		if (newCommand instanceof SetTextSelection
				&& last instanceof SetTextSelection) {
			return ecoreEquals;
		}
		if (newCommand instanceof SetTextSelection2
				&& last instanceof SetTextSelection2) {
			return ecoreEquals;
		}
		if (last instanceof Click && newCommand instanceof Click) {
			String lastKind = ((Click) last).getElement().getKind();
			if (lastKind.equals(ElementKind.View.name())
					|| lastKind.equals(ElementKind.Editor.name())) {
				return ecoreEquals;
			}
		}
		if (last instanceof Click && ((Click) last).isDefault()
				&& newCommand instanceof DoubleClick) {
			return ecoreEquals;
		}
		if (newCommand instanceof DoubleClick) {
			return false;
		}
		if (last instanceof ApplyCellEditor
				&& newCommand instanceof ApplyCellEditor) {
			return ecoreEquals;
		}
		if (equals && last instanceof MouseCommand) {
			MouseCommand lastCmd = (MouseCommand) last;
			MouseCommand newCmd = (MouseCommand) newCommand;
			equals = lastCmd.getKind().equals(newCmd.getKind());
			if (lastCmd.getKind().equals(MouseCommandKind.DRAG)) {
				return false;
			}
			if (lastCmd.getKind().equals(MouseCommandKind.MOVE)) {
				return isReplacable(last) && isReplacable(newCommand) && equals;
			}
		}
		if (equals && last instanceof FigureMouseCommand) {
			FigureMouseCommand lastCmd = (FigureMouseCommand) last;
			FigureMouseCommand newCmd = (FigureMouseCommand) newCommand;
			equals = lastCmd.getKind().equals(newCmd.getKind());

			if (equals && lastCmd.getKind().equals(MouseCommandKind.DRAG)) {
				return true;
			}
			if (lastCmd.getKind().equals(MouseCommandKind.MOVE)) {
				return isReplacable(last) && isReplacable(newCommand) && equals;
			}
		}
		if (equals && ecoreEquals && last instanceof CheckItem) {
			CheckItem ci1 = (CheckItem) last;
			CheckItem ci2 = (CheckItem) newCommand;
			EList<String> p1 = ci1.getPath();
			EList<String> p2 = ci2.getPath();
			if (p1.size() != p2.size()) {
				return false;
			}
			for (int i = 0; i < p1.size(); i++) {
				if (!p1.get(i).equals(p2.get(i))) {
					return false;
				}
			}

			// Check also for same path.
			return ci1.isState() == ci2.isState();
		}
		if (equals && ecoreEquals && last instanceof TypeText) {
			TypeText t1 = (TypeText) last;
			TypeText t2 = (TypeText) newCommand;
			t2.setText(t1.getText() + t2.getText());
			return true;
		}
		if (last instanceof DragCommand && newCommand instanceof DragCommand) {
			DragCommand lastDrag = (DragCommand) last;
			DragCommand newDrag = (DragCommand) newCommand;
			if (lastDrag.getKind().equals(newDrag.getKind())
					&& newDrag.getKind().equals(DragKind.OVER)) {
				return true;
			}
			return false;
		}

		return isReplacable(last) && isReplacable(newCommand) && equals
				&& ecoreEquals;
	}

	protected void hookExecuteCommand(Command command, List<Element> elements,
			CommandTransferKind kind, List<Widget> controls, int index,
			List<RawEvent> rawEvents) {
	}

	public ElementGenerator getGenerator() {
		return generator;
	}

	public synchronized void clear() {
		// this.generator = new ElementGenerator();
		this.container.clear();
		this.controls = null;
		this.rawEvents.clear();
	}

	public void generatorsClear() {
		this.generator = new ElementGenerator();
	}

	public TeslaScenarioContainer getContainer() {
		return container;
	}

	public void removeLast() {
		container.removeLast();
		hookExecuteCommand(null, null, CommandTransferKind.REPLACE_PREVIOUS,
				null, 0, null);
	}

	public void remove(int index) {
		container.remove(index);
		hookExecuteCommand(null, null, CommandTransferKind.REMOVE, null, index,
				null);
	}
}