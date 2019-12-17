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
package org.eclipse.rcptt.tesla.core.protocol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class ViewerUIElement extends ControlUIElement {
	private static class Selector {
		public UISetSelector set_item;
		public UISelector<ItemUIElement> item;
		public UISelector<ControlUIElement> column;
	}

	Selector selector = new Selector();

	public ViewerUIElement(Element e, UIPlayer player) {
		super(e, player);
		this.selector.set_item = new UISetSelector(player).parent(element);
		this.selector.item = new UISelector<ItemUIElement>(ElementKind.Item, player, ItemUIElement.class)
				.parent(getElement());
		this.selector.column = new UISelector<ControlUIElement>(ElementKind.ColumnHeader, player,
				ControlUIElement.class).parent(getElement());
	}

	@Override
	protected void updateAfter(Element e) {
		super.updateAfter(e);
		this.selector.item.after = e;
	}

	public ItemUIElement item(String... pattern) {
		return this.selector.item.path(pattern).find();
	}

	public ItemUIElement item(Integer... index) {
		return this.selector.item.indexes(index).find();
	}

	public ControlUIElement column(String pattern, Integer index) {
		return this.selector.column.find(pattern, index != null && index == 0 ? null : index);
	}

	/**
	 * Such selection kind are valid mostly for trees
	 */
	public boolean setSelection(String... selection) {
		return this.selector.set_item.path(selection).select();
	}

	public boolean setSelectionList(List<String> selection) {
		return this.selector.set_item.pathList(selection).select();
	}

	public boolean setMultiSelection(String[]... selection) {
		return fillSelection(selection).select();
	}

	public boolean setMultiSelectionList(List<List<String>> selection, boolean all) {
		final String[][] converted = new String[selection.size()][];
		final int size = selection.size() - 1;
		// reverse for replay
		for (int i = 0; i <= size; i++) {
			List<String> each = selection.get(i);
			converted[size - i] = each.toArray(new String[each.size()]);
		}
		return fillSelection(converted).select(all);
	}

	/**
	 * @deprecated
	 * @param path
	 * @return
	 */
	public boolean selectItem(String... path) {
		return this.selector.set_item.path(path).select();
	}

	public boolean checkItem(String... path) {
		return checkItem(true, path);
	}

	public boolean checkItem(boolean state, String... path) {
		return checkItemList(state, Arrays.asList(path));
	}

	public boolean checkItemList(boolean state, List<String> path) {
		CheckItem cmd = factory.createCheckItem();
		if (path != null) {
			cmd.getPath().addAll(path);
		}
		cmd.setState(state);
		cmd.setElement(getElement());
		BooleanResponse res = (BooleanResponse) player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (res == null) {
			return true;
		}
		return res.isResult();
	}

	public int countItems() {
		CountItems cmd = factory.createCountItems();
		cmd.setElement(getElement());
		IntResponse response = (IntResponse) player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return 0;
		}
		return response.getResult();
	}

	public String[][] getSelection() {
		GetSelection cmd = factory.createGetSelection();
		cmd.setElement(getElement());
		SelectionResponse response = (SelectionResponse) player.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return null;
		}
		EList<SelectionItem> values = response.getValues();
		List<String[]> result = new ArrayList<String[]>();
		for (SelectionItem item : values) {
			EList<String> text = item.getText();
			result.add(text.toArray(new String[text.size()]));
		}
		return result.toArray(new String[result.size()][]);
	}

	public int countItems(String... path) {
		CountItems cmd = factory.createCountItems();
		if (path != null) {
			cmd.getPath().addAll(Arrays.asList(path));
		}
		cmd.setElement(getElement());
		IntResponse res = (IntResponse) player.safeExecuteCommand(cmd);
		player.clearFailures();
		return res.getResult();
	}

	public void activateCellEditor(int column) {
		ActivateCellEditor cmd = factory.createActivateCellEditor();
		cmd.setElement(getElement());
		cmd.setColumn(column);
		player.safeExecuteCommand(cmd);
	}

	public void activateCellEditor(int column, ActivationEventType type, int button) {
		ActivateCellEditor cmd = factory.createActivateCellEditor();
		cmd.setElement(getElement());
		cmd.setColumn(column);
		cmd.setType(type);
		cmd.setButton(button);
		player.safeExecuteCommand(cmd);
	}

	public void applyCellEditor() {
		ApplyCellEditor cmd = factory.createApplyCellEditor();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void deactivateCellEditor() {
		DeactivateCellEditor cmd = factory.createDeactivateCellEditor();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void cancelCellEditor() {
		CancelCellEditor cmd = factory.createCancelCellEditor();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	/**
	 * @deprecated
	 * @param index
	 */
	public void cellClick(int index) {
		CellClick click = factory.createCellClick();
		click.setColumn(index);
		click.setElement(getElement());
		player.safeExecuteCommand(click);
	}

	private UISetSelector fillSelection(String[]... selection) {
		UISetSelector e = this.selector.set_item;
		if (selection.length > 0) {
			int last = selection.length - 1;
			e = e.path(selection[last]);
			for (int i = --last; i >= 0; i--) {
				e = e.additional(selection[i]);
			}
		}
		return e;
	}
}
