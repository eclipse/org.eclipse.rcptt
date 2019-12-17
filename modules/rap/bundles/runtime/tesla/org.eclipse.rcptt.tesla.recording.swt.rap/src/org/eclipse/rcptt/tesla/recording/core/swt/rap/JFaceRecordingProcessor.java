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
package org.eclipse.rcptt.tesla.recording.core.swt.rap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.CheckItem;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ItemUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;
import org.eclipse.rcptt.tesla.recording.aspects.jface.rap.IJFaceEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.jface.rap.JFaceEventManager;
import org.eclipse.rcptt.tesla.recording.core.ICellEditsProcessor;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;

public class JFaceRecordingProcessor implements IRecordingProcessor,
		IJFaceEventListener {
	private Set<CellEditor> activeCellEditors = new HashSet<CellEditor>();
	private TeslaRecorder recorder;

	public JFaceRecordingProcessor() {
		JFaceEventManager.addListener(this);
	}

	private SWTEventRecorder getSWTProcessor() {
		return recorder.getProcessor(SWTEventRecorder.class);
	}

	public void activateCellEditor(Object cellEditorObj) {
		if (checkCellEditorOP()) {
			return;
		}
		CellEditor cellEditor = getLocator().getCellEditor(cellEditorObj);
		if (cellEditor == null) {
			return;
		}
		if (activeCellEditors.contains(cellEditor)) {
			return;
		}
		Control control = cellEditor.getControl();
		lastCellEditorControl = null;
		if (control == null) {
			return;
		}
		activeCellEditors.add(cellEditor);
		Composite parent = control.getParent();

		if (parent instanceof Tree || parent instanceof Table) {
			ControlEditor editor = TeslaSWTAccess.getControlEditor(parent);
			int column = getLocator().getColumnFromCellEditor(cellEditorObj,
					editor, cellEditor);
			ViewerUIElement e = getTreeTableElement(parent);
			if (e != null) {
				String[][] selection = Viewers.getMultiPathSelection(getPlayer()
						.wrap(parent));
				e.setMultiSelection(selection);
				e.activateCellEditor(column);
			}
		} else {
			List<ICellEditsProcessor> processors = TeslaRecorder.getInstance()
					.getProcessors(ICellEditsProcessor.class);

			for (ICellEditsProcessor p : processors)
				if (p.activateCellEdit(cellEditor, null))
					break;
		}
	}

	private ViewerUIElement getTreeTableElement(Control parent) {
		FindResult result = getLocator().findElement(parent, true, false,
				false);
		if (result != null && result.element != null) {
			return new ViewerUIElement(result.element,
					getRecorder());
		}
		return null;
	}

	public static Control lastCellEditorControl = null;

	private static Composite getCheckboxCellEditorSource(
			ColumnViewerEditorActivationEvent event) {
		if (event == null)
			return null;

		if (!(event.getSource() instanceof ViewerCell))
			return null;

		ViewerRow row = TeslaSWTAccess.getField(ViewerRow.class,
				event.getSource(), "row");
		if (row == null)
			return null;

		Item item = TeslaSWTAccess.getField(Item.class, row, "item");
		if (item == null)
			return null;

		Composite parent = TeslaSWTAccess.getField(Composite.class, item,
				"parent");

		if (!(parent instanceof Table || parent instanceof Tree))
			return null;

		return parent;
	}

	public void activateCellEditor(CellEditor cellEditor,
			ColumnViewerEditorActivationEvent activationEvent) {
		if (cellEditor == null)
			return;
		if (checkCellEditorOP()) {
			return;
		}
		if (activeCellEditors.contains(cellEditor)) {
			return;
		}
		boolean checkbox = cellEditor instanceof CheckboxCellEditor;
		Control control = cellEditor.getControl();
		lastCellEditorControl = null;
		if (control == null && !checkbox) {
			return;
		}
		Composite parent = null;
		if (checkbox) {
			parent = getCheckboxCellEditorSource(activationEvent);
		}
		else {
			parent = control.getParent();
		}
		if (parent == null) {
			return;
		}

		activeCellEditors.add(cellEditor);
		// Control[] children = parent.getChildren();
		if (parent instanceof Tree || parent instanceof Table) {
			String[][] selection = Viewers.getMultiPathSelection(getPlayer()
					.wrap(parent));
			ControlEditor editor = TeslaSWTAccess.getControlEditor(parent);
			int column = -1;
			if (activationEvent.getSource() instanceof ViewerCell) {
				ViewerCell cell = (ViewerCell) activationEvent.getSource();
				column = cell.getColumnIndex();
				Widget item = cell.getItem();
				if (item instanceof TreeItem) {
					selection = new String[][] { Viewers
							.getPathByTreeItem((TreeItem) item) };
				} else if (item instanceof TableItem) {
					selection = new String[][] { Viewers
							.getPathByTableItem((TableItem) item) };
				}
			} else {
				if (editor instanceof TreeEditor) {
					column = ((TreeEditor) editor).getColumn();
				} else if (editor instanceof TableEditor) {
					column = ((TableEditor) editor).getColumn();
				}
			}
			FindResult result = getLocator().findElement(parent, true, false,
					false);
			if (result != null
					&& (result.realElement.isTable() || result.realElement
							.isTree())) {
				ViewerUIElement e = new ViewerUIElement(result.element,
						getRecorder());
				if (!checkbox) {
					e.setMultiSelection(selection);
					e.activateCellEditor(column);
				} else {
					CheckboxCellEditor checkboxCellEditor = (CheckboxCellEditor) cellEditor;

					int row = -1;
					if (parent instanceof Tree) {
						Tree tree = (Tree) parent;
						if (tree.getSelectionCount() > 0)
							row = tree.indexOf(tree.getSelection()[0]);
					} else if (parent instanceof Table) {
						Table table = (Table) parent;
						row = table.getSelectionIndex();
					}

					if (row != -1 && checkboxCellEditor.getValue() != null) {
						ItemUIElement item = e.item(column, row);

						CheckItem checkItem = ProtocolFactory.eINSTANCE
								.createCheckItem();
						checkItem.setElement(item.getElement());
						checkItem.setState((Boolean) checkboxCellEditor
								.getValue());
						getRecorder().safeExecuteCommand(checkItem);
					}
				}
			}
		} else {
			List<ICellEditsProcessor> processors = TeslaRecorder.getInstance()
					.getProcessors(ICellEditsProcessor.class);

			for (ICellEditsProcessor p : processors)
				if (p.activateCellEdit(cellEditor, activationEvent))
					break;
		}
	}

	private TeslaRecorder getRecorder() {
		return getSWTProcessor().getRecorder();
	}

	private SWTWidgetLocator getLocator() {
		return getSWTProcessor().getLocator();
	}

	private SWTUIPlayer getPlayer() {
		return getSWTProcessor().getPlayer();
	}

	@SuppressWarnings("unused")
	private static Composite getCheckboxCellEditorSource(CellEditor cellEditor) {
		ListenerList listeners = TeslaSWTAccess.getField(ListenerList.class,
				cellEditor, "listeners");
		for (Object o : listeners.getListeners()) {
			ColumnViewerEditor viewerEditor = TeslaSWTAccess.getField(
					ColumnViewerEditor.class, o, "this$0");
			if (viewerEditor == null)
				continue;

			ColumnViewer viewer = TeslaSWTAccess.getField(ColumnViewer.class,
					viewerEditor, "viewer");
			if (viewer == null)
				continue;

			if (viewer instanceof TableViewer)
				return ((TableViewer) viewer).getTable();
			else if (viewer instanceof TreeViewer)
				return ((TreeViewer) viewer).getTree();
		}

		return null;
	}

	public void applyCellEditor(Object cellEditorObj) {
		if (checkCellEditorOP()) {
			return;
		}
		CellEditor cellEditor = getLocator().getCellEditor(cellEditorObj);
		if (cellEditor == null) {
			return;
		}

		boolean checkbox = cellEditor instanceof CheckboxCellEditor;
		Control control = lastCellEditorControl = cellEditor.getControl();
		if (control == null && !checkbox) {
			return;
		}
		if (!activeCellEditors.contains(cellEditor)) {
			return;// Already deactivated
		}
		Composite parent = null;
		if (checkbox)
			// no need in recording of apply-cell-edit for checkboxes, they are
			// special
			// parent = getCheckboxCellEditorSource(cellEditor);
			return;
		else
			parent = control.getParent();

		if (parent == null)
			return;

		if (parent instanceof Tree || parent instanceof Table) {
			FindResult result = getLocator().findElement(parent, true, false,
					false);
			if (result != null
					&& (result.realElement.isTable() || result.realElement
							.isTree())) {
				ViewerUIElement e = new ViewerUIElement(result.element,
						getRecorder());
				e.applyCellEditor();
			}
		} else {
			List<ICellEditsProcessor> processors = TeslaRecorder.getInstance()
					.getProcessors(ICellEditsProcessor.class);

			for (ICellEditsProcessor p : processors)
				if (p.applyCellEdit(cellEditor))
					break;
		}
	}

	public void deactivateCellEditor(Object cellEditorObj) {
		if (checkCellEditorOP()) {
			return;
		}
		CellEditor cellEditor = getLocator().getCellEditor(cellEditorObj);
		if (cellEditor == null) {
			return;
		}

		boolean checkbox = cellEditor instanceof CheckboxCellEditor;
		if (activeCellEditors.contains(cellEditor)) {
			activeCellEditors.remove(cellEditor);
		} else {
			// Not in active, can't apply. Already applied.
			if (!checkbox)
				return;
		}
		Control control = lastCellEditorControl = cellEditor.getControl();
		if (control == null && !checkbox) {
			return;
		}

		Composite parent = null;
		if (checkbox)
			// no need in recording of apply-cell-edit for checkboxes, they are
			// special
			// parent = getCheckboxCellEditorSource(cellEditor);
			return;
		else
			parent = control.getParent();

		if (parent == null)
			return;

		if (parent instanceof Tree || parent instanceof Table) {
			FindResult result = getLocator().findElement(parent, true, false,
					false);
			if (result != null
					&& (result.realElement.isTable() || result.realElement
							.isTree())) {
				ViewerUIElement e = new ViewerUIElement(result.element,
						getRecorder());
				e.deactivateCellEditor();
			}
		} else {
			List<ICellEditsProcessor> processors = TeslaRecorder.getInstance()
					.getProcessors(ICellEditsProcessor.class);

			for (ICellEditsProcessor p : processors)
				if (p.deactivateCellEdit(cellEditor))
					break;
		}
	}

	private boolean checkCellEditorOP() {
		if (getRecorder() == null) {
			return true;
		}
		if (!getRecorder().hasListeners()) {
			return true;
		}
		Context ctx = ContextManagement.currentContext();
		if (ctx.contains("org.eclipse.jface.viewers.AbstractTableViewer",
				"internalRefresh")) {
			return true;
		}
		return false;
	}

	public void cancelCellEditor(Object cellEditorObj) {
		if (checkCellEditorOP()) {
			return;
		}
		// Disable if called after apply cell editor
		Command last = getRecorder().getContainer().getLast();
		if (last != null && last instanceof ApplyCellEditor) {
			return;
		}
		CellEditor cellEditor = getLocator().getCellEditor(cellEditorObj);
		if (cellEditor == null) {
			return;
		}
		Control control = lastCellEditorControl = cellEditor.getControl();
		if (control == null) {
			return;
		}
		Composite parent = control.getParent();
		if (parent instanceof Tree || parent instanceof Table) {
			FindResult result = getLocator().findElement(parent, true, false,
					false);
			if (result != null
					&& (result.realElement.isTable() || result.realElement
							.isTree())) {
				ViewerUIElement e = new ViewerUIElement(result.element,
						getRecorder());
				e.cancelCellEditor();
			}
		} else {
			List<ICellEditsProcessor> processors = TeslaRecorder.getInstance()
					.getProcessors(ICellEditsProcessor.class);

			for (ICellEditsProcessor p : processors)
				if (p.cancelCellEdit(cellEditor))
					break;
		}
	}

	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	public int getInitLevel() {
		return 100;
	};

	public void clear() {
		activeCellEditors.clear();
	}

	public void setFreeze(boolean value, SetMode command) {
	}

	public void resetAssertSelection() {
	}

	public IRecordingHelper<?> getHelper() {
		return null;
	}

	public void recordOpenStrategyEvent(OpenStrategy str, SelectionEvent e) {
		if (OpenStrategy.getOpenMethod() == OpenStrategy.SINGLE_CLICK) {
			if (e.widget != null) {
				FindResult element = getSWTProcessor().getLocator()
						.findElement(e.widget, false, false, false);
				if (element != null) {
					ControlUIElement el = new ControlUIElement(element.element,
							getRecorder());
					el.click();
				}
			}
		}
	}
}
