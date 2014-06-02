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
package org.eclipse.rcptt.tesla.internal.ui.processors;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import java.util.WeakHashMap;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.internal.ui.SWTElementMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;
import org.eclipse.rcptt.tesla.jface.TeslaCellEditorManager;

public class CellEditorSupport {

	private SWTUIProcessor processor;

	protected WeakHashMap<Widget, CellEditor> cellEditorActivations = new WeakHashMap<Widget, CellEditor>();

	public CellEditorSupport(SWTUIProcessor processor) {
		this.processor = processor;
	}

	protected Response handleActivateCellEditor(final ActivateCellEditor command) {
		final Element element = command.getElement();
		final SWTUIElement uiElement = getMapper().get(element);
		// Check for already activated
		if (uiElement != null) {
			final int column = command.getColumn();
			if (uiElement.isTree()) {
				final Tree tree = (Tree) unwrapWidget(uiElement);
				final String[] path = uiElement.getPathSelection();
				final Object current = Viewers.getTreeItem(tree, path);
				if (current != null) {
					getPlayer().exec("Run cell editor", new Runnable() {

						public void run() {
							final TreeViewer viewer = TeslaSWTAccess
									.getTreeViewer(tree);

							if (current instanceof TreeItem && viewer != null) {
								final TreeItem ti = (TreeItem) current;
								if (!edit(uiElement, column, viewer, ti))
									edit(uiElement, column, viewer, ti);

							}
							// Try to check for property pages
							final Object vv = TeslaSWTAccess
									.getPropertySheet(tree);
							final TeslaCellEditorManager instance = TeslaCellEditorManager
									.getInstance();
							if (vv != null) {
								final TreeItem[] selection = tree
										.getSelection();
								if (selection.length == 1) {
									instance.makeNewAsForced(true);
									TeslaSWTAccess.callHandleSelect(vv,
											selection);
									cellEditorActivations.put(uiElement.widget,
											instance.getLastActivated());
									instance.makeNewAsForced(false);
								}
							}
						}

						private boolean edit(final SWTUIElement uiElement,
								final int column, final TreeViewer viewer,
								final TreeItem ti) {
							final TeslaCellEditorManager instance = TeslaCellEditorManager
									.getInstance();

							if (viewer.isCellEditorActive()) {
								CellEditor[] editors = viewer.getCellEditors();
								if (editors != null && editors.length == 1) {
									cellEditorActivations.put(uiElement.widget,
											editors[0]);
									return true;
								}
								ColumnViewerEditor cve = viewer
										.getColumnViewerEditor();
								if (cve != null) {
									if (cve.getFocusCell() != null && cve.getFocusCell().getColumnIndex() == column) {
										CellEditor editor = TeslaSWTAccess
												.getCellEditorFromColumnEditor(cve);
										if (editor != null) {
											cellEditorActivations.put(
													uiElement.widget, editor);
											return true;
										}
									}
									else {
										viewer.cancelEditing();
									}
								}
								// viewer.cancelEditing();
							}
							try {
								instance.makeNewAsForced(true);
								Object toEdit = ti.getData();
								if (toEdit == null)
									// TODO: Need a way to activate cell
									// editor from TableItem without data
									toEdit = ti;
								viewer.editElement(toEdit, column);
								if (instance.getLastActivated() != null) {
									cellEditorActivations.put(uiElement.widget,
											instance.getLastActivated());
								} else {
									return false;
								}
							} finally {
								instance.makeNewAsForced(false);
							}
							return true;
						}
					});
				}
			} else if (uiElement.isTable()) {
				final Table table = (Table) unwrapWidget(uiElement);
				final String[] path = uiElement.getPathSelection();
				String curPath = "";
				if (path != null && path.length > 0) {
					curPath = path[0];
				}
				final Object current = Viewers.getTableItem(table, curPath);
				if (current != null) {
					final TableViewer viewer = TeslaSWTAccess
							.getTableViewer(table);
					final TeslaCellEditorManager instance = TeslaCellEditorManager
							.getInstance();
					if (viewer != null) {
						getPlayer().exec("Run cell editor", new Runnable() {

							public void run() {
								boolean done = false;
								if (current instanceof TableItem) {
									final TableItem ti = (TableItem) current;
									if (ti.getData() != null) {
										done = true;
										if (viewer.isCellEditorActive()) {
											CellEditor[] editors = viewer
													.getCellEditors();
											if (editors != null
													&& editors.length == 1) {
												cellEditorActivations.put(
														uiElement.widget,
														editors[0]);
												return;
											}
											ColumnViewerEditor cve = viewer
													.getColumnViewerEditor();
											if (cve != null) {
												if (cve.getFocusCell() != null && cve.getFocusCell()
														.getColumnIndex() == column) {
													CellEditor editor = TeslaSWTAccess
															.getCellEditorFromColumnEditor(cve);
													if (editor != null) {
														cellEditorActivations
																.put(uiElement.widget,
																		editor);
														return;
													}
												}
												else {
													viewer.cancelEditing();
												}
											}
										}
										instance.makeNewAsForced(true);
										try {
											viewer.editElement(ti.getData(),
													column);
											cellEditorActivations.put(
													uiElement.widget,
													instance.getLastActivated());
										} finally {
											instance.makeNewAsForced(false);
										}
									}
								}
								if (!done) {
									if (viewer.isCellEditorActive()) {
										viewer.cancelEditing();
									}
									try {
										instance.makeNewAsForced(true);
										if (current instanceof TableItem
												&& ((TableItem) current)
														.getData() != null) {
											viewer.editElement(
													((TableItem) current)
															.getData(), column);
										} else {
											// TODO: Need a way to activate cell
											// editor from TableItem without
											// data
											viewer.editElement(current, column);
										}
										cellEditorActivations.put(
												uiElement.widget,
												instance.getLastActivated());
									} finally {
										instance.makeNewAsForced(false);
									}
								}
							}
						});
					} else {
						// Try to check for property pages
						final Object vv = TeslaSWTAccess
								.getPropertySheet(table);
						if (vv != null) {
							final TableItem[] selection = table.getSelection();
							if (selection.length == 1) {
								instance.makeNewAsForced(true);
								TeslaSWTAccess.callHandleSelect(vv, selection);
								cellEditorActivations.put(uiElement.widget,
										instance.getLastActivated());
								instance.makeNewAsForced(false);
							}
						}
					}
				}
			}
		}

		return ProtocolFactory.eINSTANCE.createBooleanResponse();
	}

	private SWTElementMapper getMapper() {
		return processor.getMapper();
	}

	private SWTUIPlayer getPlayer() {
		return processor.getPlayer();
	}

	protected Response handleApplyCellEditor(final ApplyCellEditor command) {
		final Element element = command.getElement();
		final SWTUIElement uiElement = getMapper().get(element);
		if (uiElement != null) {
			final CellEditor cellEditor = cellEditorActivations
					.get(uiElement.widget);
			if (cellEditor != null) {
				getPlayer().exec("Apply direct edit", new Runnable() {
					public void run() {
						// TeslaCellEditorManager.getInstance().forceRemove(
						// cellEditor);
						TeslaSWTAccess.callMethodValueChanged(cellEditor,
								"valueChanged", cellEditor.isValueValid(), true);
						// Check if there is modal dialog, then no deactivate is
						// required.
						TeslaSWTAccess.callMethod(cellEditor,
								"fireApplyEditorValue");
						if (cellEditor instanceof ComboBoxViewerCellEditor) {
							TeslaSWTAccess.callMethod(
									ComboBoxViewerCellEditor.class, cellEditor,
									"applyEditorValueAndDeactivate");
						}
						if (command.isDeactivate()) {
							cellEditor.deactivate();
							cellEditorActivations.remove(uiElement.widget);
						}
					}
				});
			}
		}

		return ProtocolFactory.eINSTANCE.createBooleanResponse();
	}

	protected Response handleCancelCellEditor(final CancelCellEditor command) {
		final Element element = command.getElement();
		final SWTUIElement uiElement = getMapper().get(element);
		if (uiElement != null) {
			final CellEditor cellEditor = cellEditorActivations
					.get(uiElement.widget);
			if (cellEditor != null) {
				getPlayer().exec("Cancel direct edit", new Runnable() {
					public void run() {
						// TeslaCellEditorManager.getInstance().forceRemove(
						// cellEditor);
						TeslaSWTAccess.callMethod(cellEditor,
								"fireCancelEditor");
					}
				});
			}
		}
		return ProtocolFactory.eINSTANCE.createBooleanResponse();
	}

	protected Response handleDeactivateCellEditor(
			final DeactivateCellEditor command) {
		final Element element = command.getElement();
		final SWTUIElement uiElement = getMapper().get(element);
		if (uiElement != null) {
			final CellEditor cellEditor = cellEditorActivations
					.get(uiElement.widget);
			if (cellEditor != null) {
				getPlayer().exec("Deactivate cell edit", new Runnable() {
					public void run() {
						cellEditor.deactivate();
						getPlayer().getEvents().sendFocus(uiElement.unwrap());
						cellEditorActivations.remove(uiElement.widget);
					}
				});
			}
		}
		return ProtocolFactory.eINSTANCE.createBooleanResponse();
	}

	public void clear() {
		cellEditorActivations.clear();
	}

}
