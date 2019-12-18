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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFactory;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;

public class ControlUIElement extends BasicUIElement {
	private static final int EMPTY_MASK = 0;

	private static class Selector {
		public UISelector<ControlUIElement> menu;
		public UISelector<ControlUIElement> region;
	}

	private final Selector selector = new Selector();

	public ControlUIElement(Element e, UIPlayer player) {
		super(e, player);
		this.selector.menu = new UISelector<ControlUIElement>(ElementKind.Menu,
				player, ControlUIElement.class).parent(getElement());
		this.selector.region = new UISelector<ControlUIElement>(
				ElementKind.Region, player, ControlUIElement.class)
				.parent(getElement());
	}

	protected void updateAfter(Element e) {
		selector.menu.after = e;
	}

	public void show() {
		Show cmd = factory.createShow();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);

	}

	public ControlUIElement menu(String[] path, Integer index) {
		return selector.menu.path(path).find(index);
	}

	// public ControlUIElement region(byte[] image) {
	// return selector.region.image(image).find();
	// }

	public ControlUIElement region(byte[] image, int x, int y) {
		return selector.region.image(image).indexes(x, y).find();
	}

	public void executeMouseCommand(int x, int y, int button,
			MouseCommandKind kind, int width, int height, int stateMask) {
		MouseCommand command = DiagramFactory.eINSTANCE.createMouseCommand();
		command.setKind(kind);
		command.setButton(button);
		command.setElement(getElement());
		command.setX(x);
		command.setY(y);
		command.setBoundsHeight(height);
		command.setBoundsWidth(width);
		command.setStateMask(stateMask);
		player.safeExecuteCommand(command);
	}

	public String getText() {
		GetText cmd = factory.createGetText();
		cmd.setElement(getElement());
		GetTextResponse response = (GetTextResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return null;
		}
		if (response.getStatus().equals(ResponseStatus.OK)) {
			return response.getText();
		}
		return null;
	}

	public boolean isDisposed() {
		IsDisposed cmd = factory.createIsDisposed();
		cmd.setElement(getElement());
		BooleanResponse response = (BooleanResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return false;
		}
		if (response.getStatus().equals(ResponseStatus.OK)) {
			return response.isResult();
		}
		return false;
	}

	public boolean isDisabled() {
		IsEnabled cmd = factory.createIsEnabled();
		cmd.setElement(getElement());
		BooleanResponse response = (BooleanResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return false;
		}
		if (response.getStatus().equals(ResponseStatus.OK)) {
			return !response.isResult();
		}
		return true;
	}

	public void click() {
		click(false, false, false, EMPTY_MASK);
	}

	public void clickArrow() {
		click(false, false, true, EMPTY_MASK);
	}

	public void click(boolean defaultClick) {
		click(false, defaultClick, false, EMPTY_MASK);
	}

	public void click(boolean wait, boolean defaultClick, boolean arrow, int metaKeys) {
		Click click = factory.createClick();
		click.setElement(getElement());
		click.setDefault(defaultClick);
		click.setWithWait(wait);
		click.setArrow(arrow);
		click.setMetaKeys(metaKeys);
		player.safeExecuteCommand(click);
	}

	public void check(boolean state) {
		Check check = factory.createCheck();
		check.setElement(getElement());
		check.setState(state);
		player.safeExecuteCommand(check);
	}

	// Click and wait for context to be same if it is changed.
	public void clickAndWait() {
		clickAndWait(false, EMPTY_MASK);
	}

	public void clickAndWait(boolean defaultClick, int metaKeys) {
		click(true, defaultClick, false, metaKeys);
	}

	public void clickArrowAndWait() {
		clickArrowAndWait(false);
	}

	public void clickArrowAndWait(boolean defaultClick) {
		click(true, defaultClick, true, EMPTY_MASK);
	}

	public void doubleClick() {
		doubleClick(false);
	}

	public void doubleClick(boolean wait) {
		DoubleClick click = factory.createDoubleClick();
		click.setElement(getElement());
		player.safeExecuteCommand(click);
	}

	// Click and wait for context to be same if it is changed.
	public void doubleClickAndWait() {
		doubleClick(true);
	}

	public void type(String text, int modifier, boolean fromDisplay) {
		TypeText type = factory.createTypeText();
		type.setState(modifier);
		type.setText(text);
		type.setElement(getElement());
		type.setFromDisplay(fromDisplay);
		player.safeExecuteCommand(type);
	}

	public void typeAction(String actionId) {
		TypeAction typeAction = factory.createTypeAction();
		typeAction.setActionId(actionId);
		typeAction.setElement(getElement());
		player.safeExecuteCommand(typeAction);
	}

	public void press(int code, int modifier, boolean fromDisplay,
			char character, int meta, boolean isTraverse, int times) {
		Type type = factory.createType();
		type.setState(modifier);
		type.setCode(code);
		type.setElement(getElement());
		type.setFromDisplay(fromDisplay);
		type.setCharacter(character);
		type.setMeta(meta);
		type.setTraverse(isTraverse);
		type.setTimes(times);
		player.safeExecuteCommand(type);
	}

	public void press(int code, int modifier, boolean fromDisplay,
			char character, int meta, boolean isTraverse) {
		press(code, modifier, fromDisplay, character, meta, isTraverse, 1);
	}

	public void traverse(int code, char character) {
		press(code, 0, false, character, 0, true);
	}

	public void traverse(int code, char character, int times) {
		press(code, 0, false, character, 0, true, times);
	}

	public void press(int code, int modifier, boolean fromDisplay,
			char character, int meta) {
		press(code, modifier, fromDisplay, character, meta, false);
	}

	public void press(int code, int modifier, boolean fromDisplay,
			char character) {
		press(code, modifier, fromDisplay, character, 0);
	}

	public void type(String text, int modifier) {
		type(text, modifier, false);
	}

	public void press(int code, int modifier, char character) {
		press(code, modifier, false, character);
	}

	public void press(int code, int modifier) {
		press(code, modifier, false, (char) (code & 0xff));
	}

	public void press(int code, int mask, int character) {
		press(code, mask, (char) (character & 0xFF));
	}

	public void type(String text) {
		type(text, 0, false);
	}

	public void press(int code, boolean fromDisplay, char character) {
		press(code, 0, fromDisplay, character);
	}

	public void type(String text, boolean fromDisplay) {
		type(text, 0, fromDisplay);
	}

	public boolean isKind(ElementKind text) {
		return getElement().getKind().equals(text.name());
	}

	public void drag(DragKind kind, Integer x, Integer y, String style) {
		DragCommand drag = factory.createDragCommand();
		drag.setElement(getElement());
		drag.setKind(kind);
		drag.setStyle(style);
		drag.setX(x);
		drag.setY(y);
		player.safeExecuteCommand(drag);
	}

	public void close() {
		Close cmd = factory.createClose();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void minimize() {
		Minimize cmd = factory.createMinimize();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void maximize() {
		Maximize cmd = factory.createMaximize();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void restore() {
		Restore cmd = factory.createRestore();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void showTabList() {
		ShowTabList cmd = factory.createShowTabList();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void RulerClick(int line, int button, int stateMask) {
		RulerClick doubleClick = factory.createRulerClick();
		doubleClick.setElement(getElement());
		doubleClick.setLine(line);
		doubleClick.setButton(button);
		doubleClick.setStateMask(stateMask);
		player.safeExecuteCommand(doubleClick);
	}

	public void RulerDoubleClick(int line, int button, int stateMask) {
		RulerDoubleClick doubleClick = factory.createRulerDoubleClick();
		doubleClick.setElement(getElement());
		doubleClick.setLine(line);
		doubleClick.setButton(button);
		doubleClick.setStateMask(stateMask);
		player.safeExecuteCommand(doubleClick);
	}

	public void RulerHover(int line, int stateMask) {
		RulerHover rulerHover = factory.createRulerHover();
		rulerHover.setElement(getElement());
		rulerHover.setLine(line);
		rulerHover.setStateMask(stateMask);
		player.safeExecuteCommand(rulerHover);
	}

	public void setFocus() {
		SetFocus cmd = factory.createSetFocus();
		cmd.setValue(true);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}
	public void unfocus() {
		SetFocus cmd = factory.createSetFocus();
		cmd.setValue(false);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void clickText(String start, String end, String button) {
		ClickText cmd = factory.createClickText();
		cmd.setStart(start);
		cmd.setEnd(end);
		cmd.setButton(button);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void doubleClickText(String position, String button) {
		DoubleClickText cmd = factory.createDoubleClickText();
		cmd.setPosition(position);
		cmd.setButton(button);
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public BoundsResponse getBounds() {
		GetBounds cmd = factory.createGetBounds();
		cmd.setElement(getElement());
		return (BoundsResponse) player.safeExecuteCommand(cmd);
	}

	public void clickColumn(String name, int index) {
		ClickColumn cmd = factory.createClickColumn();
		cmd.setElement(getElement());
		cmd.setName(name);
		cmd.setIndex(index);
		player.safeExecuteCommand(cmd);
	}

	public void setSortColumn(String name, boolean descending) {
		SetSortColumn cmd = factory.createSetSortColumn();
		cmd.setName(name);
		cmd.setDescending(descending);
		player.safeExecuteCommand(cmd);
	}
}
