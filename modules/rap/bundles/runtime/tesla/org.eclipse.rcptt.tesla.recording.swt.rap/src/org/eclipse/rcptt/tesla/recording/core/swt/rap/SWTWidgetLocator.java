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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.core.protocol.CompositeUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.core.protocol.IWindowProvider;
import org.eclipse.rcptt.tesla.core.protocol.ItemUIElement;
import org.eclipse.rcptt.tesla.core.protocol.PartUIElement;
import org.eclipse.rcptt.tesla.core.protocol.UISelector;
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.WindowUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.WorkbenchUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessorExtension;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.rap.BasicRecordingHelper.ElementEntry;
import org.eclipse.rcptt.tesla.swt.util.GetWindowUtil;
import org.eclipse.rcptt.tesla.swt.util.IndexUtil;
import org.eclipse.rcptt.tesla.swt.workbench.EclipseWorkbenchProvider;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.PerspectiveBarContributionItem;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPartReference;
import org.eclipse.ui.part.WorkbenchPart;

@SuppressWarnings("restriction")
public final class SWTWidgetLocator {

	private static final String ELEMENT_TEXT = "element_text";
	private static final String ATTR_TEXT = "text";

	private final SWTUIPlayer player;
	private TeslaRecorder recorder;
	private List<IRecordingProcessorExtension> recorderExtensions;

	public synchronized void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	protected String getWidgetID(Widget widget) {
		try { // eat all possible exceptions here.
			if (widget == null) {
				return "";
			}
			List<Widget> parents = SWTUIPlayer.collectParents(widget,
					EclipseWorkbenchProvider.getProvider().getWorkbenchReference(getPlayer()));
			Collections.reverse(parents);
			StringBuilder builder = new StringBuilder();
			for (Widget w : parents) {
				builder.append(getWidgetIdentifier(w)).append('/');
			}
			builder.append(getWidgetIdentifier(widget));
			return builder.toString();
		} catch (Throwable e) {
			// ignore
			return "";
		} finally {

		}
	}

	public SWTUIPlayer getPlayer() {
		return player;
	}

	private String getWidgetIdentifier(Widget w) {
		StringBuilder b = new StringBuilder();
		b.append(w.getClass().getSimpleName());
		if (w instanceof Control) {
			Composite parent = ((Control) w).getParent();
			if (parent != null) {
				int i = Arrays.asList(parent.getChildren()).indexOf(w);
				b.append("|").append(Integer.toString(i));
			}
			// String text =
			// SWTUIPlayer.replaceNonUnicode(SWTUIPlayer.getText(getPlayer().wrap(w)));
			// if (text != null) {
			// b.append(':').append(text.replace('/', '_'));
			// }
		} else if (w instanceof Item) {
			if (w instanceof TreeItem && !w.isDisposed()) {
				String[] text = Viewers.getPathByTreeItem((TreeItem) w);
				b.append(':').append(Arrays.toString(text));
			} else if (w instanceof TableItem && !w.isDisposed()) {
				String[] text = Viewers.getPathByTableItem((TableItem) w);
				b.append(':').append(Arrays.toString(text));
			}
		}
		String id = b.toString();
		return id;
	}

	private static CellEditor getCellEditorFromColumnEditor(ColumnViewerEditor editor) {
		return TeslaSWTAccess.getCellEditorFromColumnEditor(editor);
	}

	/**
	 * Maps {@link SWTUIElement} into a {@link FindResult} containing a
	 * reference to the corresponding tesla raw protocol {@link Element}, which
	 * later can be used wrapped into some {@link BasicUIElement} subclass
	 * instance to record actions with the element.
	 * <p>
	 * There is also a convenience method receiving a {@link Widget} instance:
	 * {@link #findElement(Widget, boolean, boolean, boolean)}
	 * <p>
	 * See
	 * {@link IWidgetLocatorExtension#findElement(SWTUIPlayer, SWTUIElement, boolean, boolean, boolean)}
	 * for notes about the extensibility.
	 */
	public FindResult findElement(SWTUIElement widget, boolean unknownAllowed, boolean alwaysFindLeaf,
			boolean supportEclipseWorkbench) {
		if (widget == null) {
			return null;
		}

		// Do clean of disposed items phase
		SWTRecordingHelper.getHelper().cleanDisposed();

		// check extensions
		for (IWidgetLocatorExtension ext : extensions) {
			FindResult result = ext.findElement(widget, unknownAllowed, alwaysFindLeaf, supportEclipseWorkbench);
			if (result != null)
				return result;
		}

		//

		if (widget.unwrap() instanceof Canvas) {
			Canvas canvas = (Canvas) widget.unwrap();
			FindResult result = tryFindDiagram(canvas);
			if (result != null) {
				return result;
			}
		}

		if (widget instanceof WorkbenchUIElement) {
			WorkbenchUIElement ee = (WorkbenchUIElement) widget;
			IWorkbenchPart part = ee.reference.getPart(true);
			PartUIElement element = findPartElement(part, alwaysFindLeaf);
			if (element != null) {
				return new FindResult(widget, element.getElement());
			}
		}
		if (widget.getKind().is(ElementKind.Window)) {
			WindowUIElement shellObject = getShell((Shell) widget.unwrap(), alwaysFindLeaf);
			if (shellObject != null) {
				return new FindResult(player.wrap(widget), shellObject.getElement());
			}
		}
		if (widget.unwrap() instanceof Control) {
			Control control = (Control) widget.unwrap();
			Shell shell = control.getShell();

			if (checkSkipWorkbenchTabs(supportEclipseWorkbench, control, shell)) {
				return null;
			}

			// SWTUIElement realWindow = player.wrap(shell);
			SWTUIElement uiElement = player.wrap(control);
			ElementEntry element = SWTRecordingHelper.getHelper().get(uiElement);
			// Check for text are changed for this control, in this case we need
			// to locate it one more time
			element = checkTextFieldChange(uiElement, element);

			if (element != null) {
				// check after text is changed
				SWTUIElement afterElement = (SWTUIElement) element.getObj("after");
				if (afterElement != null) {
					ElementEntry afterEntry = SWTRecordingHelper.getHelper().get(afterElement);
					if (afterEntry != null) {
						if (checkTextFieldChange(afterElement, afterEntry) == null
								|| checkParentsTextFieldChange(afterElement, false)) {
							element = null;
						}
					}
				}
			}
			if (element != null) {
				if (checkParentsTextFieldChange(uiElement, false)) {
					element = null;
				}
			}

			SWTUIElement parentElement = getPlayer().getParentElement(uiElement);
			// Skip invisible elements

			FindResult parentResult = findElement(parentElement, unknownAllowed, alwaysFindLeaf,
					supportEclipseWorkbench);

			if (element != null && !alwaysFindLeaf) {
				FindResult result = new FindResult(uiElement, element.getElement());
				if (isElementTextFieldChange(uiElement, element)) {
					element.set(ELEMENT_TEXT, PlayerTextUtils.getText(uiElement));
					updateControl(result, widget);
				}
				return result;
			}
			GenericElementKind kind = SWTUIPlayer.getKind(control);

			// Search in top level components, like editor, view

			if (parentResult != null && parentResult.element != null) {
				// Check for editor/view element itself
				if (checkForViewEditor(control, shell, parentElement)) {
					return new FindResult(parentElement, parentResult.element);
				}
				if (kind.is(ElementKind.Unknown)) {
					if (unknownAllowed) {
						return findUnknownElement(control, parentElement, parentResult.element);
					}
					return null;
				}
				return findGenericElement(widget.unwrap(), control, uiElement, kind, parentElement,
						parentResult.element);
			}
		} else if (widget.unwrap() instanceof MenuItem) {
			return findMenuItem(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		} else if (widget.unwrap() instanceof ToolItem) {
			return findToolItem(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		} else if (widget.unwrap() instanceof CoolItem) {
			return findCoolItem(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		} else if (widget.unwrap() instanceof TreeItem || widget.unwrap() instanceof TableItem) {
			return findTableOrTreeItem(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		} else if (widget.unwrap() instanceof TreeColumn) {
			return findTreeColumn(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		} else if (widget.unwrap() instanceof TableColumn) {
			return findTableColumn(widget.unwrap(), alwaysFindLeaf, supportEclipseWorkbench);
		}

		return null;
	}

	private void updateControl(FindResult result, SWTUIElement widget) {
		Control control = (Control) widget.unwrap();
		recorder.setControls(SWTModelMapper.map(player.wrap(control)));
		GenericElementKind kind = SWTUIPlayer.getKind(control);
		UISelector<BasicUIElement> selector = new UISelector<BasicUIElement>(kind, recorder, BasicUIElement.class)
				.parent(result.element);
		selector.update(result.element);
	}

	private FindResult findTableColumn(Widget widget, boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {
		SWTUIElement uiElement = player.wrap(widget);
		ElementEntry element = SWTRecordingHelper.getHelper().get(uiElement);
		if (element != null && !alwaysFindLeaf) {
			return new FindResult(player.wrap(widget), element.getElement());
		}
		TableColumn column = (TableColumn) widget;
		Table parent = column.getParent();
		FindResult tableSearch = findElement(getPlayer().wrap(parent), false, false, supportEclipseWorkbench);
		ViewerUIElement tableView = new ViewerUIElement(tableSearch.element, recorder);
		recorder.setControls(SWTModelMapper.map(player.wrap(column)));
		ControlUIElement columnElement = tableView.column(column.getText(), calculateIndex(uiElement, null));
		SWTRecordingHelper.getHelper().put(player.wrap(widget), new ElementEntry(columnElement.getElement()));
		return new FindResult(player.wrap(column), columnElement.getElement());
	}

	private FindResult findTreeColumn(Widget widget, boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {
		SWTUIElement uiElement = player.wrap(widget);
		ElementEntry element = SWTRecordingHelper.getHelper().get(uiElement);
		if (element != null && !alwaysFindLeaf) {
			return new FindResult(player.wrap(widget), element.getElement());
		}
		TreeColumn column = (TreeColumn) widget;
		Tree parent = column.getParent();
		FindResult treeSearch = findElement(getPlayer().wrap(parent), false, false, supportEclipseWorkbench);
		ViewerUIElement treeView = new ViewerUIElement(treeSearch.element, recorder);
		recorder.setControls(SWTModelMapper.map(player.wrap(column)));
		ControlUIElement columnElement = treeView.column(column.getText(), calculateIndex(uiElement, null));
		SWTRecordingHelper.getHelper().put(player.wrap(widget), new ElementEntry(columnElement.getElement()));
		return new FindResult(player.wrap(column), columnElement.getElement());
	}

	public boolean checkParentsTextFieldChange(SWTUIElement uiElement, boolean self) {
		List<SWTUIElement> parentsList = getPlayer().getParentsList(uiElement);
		boolean changeRequired = false;
		if (self) {
			parentsList.add(0, uiElement);
		}
		for (SWTUIElement swtuiElement : parentsList) {
			SWTRecordingHelper helper = SWTRecordingHelper.getHelper();
			ElementEntry entry = helper.get(swtuiElement);
			if (entry != null) {
				ElementEntry change = checkTextFieldChange(swtuiElement, entry);
				if (change == null) {
					helper.remove(swtuiElement);
					changeRequired = true;
					// empty all items based on this parent
					helper.clearAllWithParent(swtuiElement);
					// Go over all items in helper in parents of who this
					// swtuielement and also clearout
				}
			}
		}
		return changeRequired;
	}

	private ItemUIElement findItemUIElement(Widget widget, SWTUIElement uiElement, boolean supportEclipseWorkbench) {

		ItemUIElement itemElement = null;
		FindResult treeSearch = findElement(findParent(widget), false, false, supportEclipseWorkbench);
		ViewerUIElement treeView = new ViewerUIElement(treeSearch.element, recorder);
		recorder.setControls(SWTModelMapper.map(uiElement));
		if (widget instanceof TableItem) {
			itemElement = treeView.item(Viewers.getPathByTableItem((TableItem) widget));
		} else if (widget instanceof TreeItem) {
			itemElement = treeView.item(Viewers.getPathByTreeItem((TreeItem) widget));
		}
		return itemElement;
	}

	private SWTUIElement findParent(Widget widget) {
		SWTUIElement result = null;
		if (widget instanceof TableItem) {
			TableItem item = (TableItem) widget;
			Table parent = item.getParent();
			result = getPlayer().wrap(parent);
		} else if (widget instanceof TreeItem) {
			TreeItem item = (TreeItem) widget;
			Tree parent = item.getParent();
			result = getPlayer().wrap(parent);
		}
		return result;
	}

	private FindResult findTableOrTreeItem(Widget widget, boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {
		ElementEntry element = SWTRecordingHelper.getHelper().get(player.wrap(widget));
		SWTUIElement uiElement = player.wrap(widget);
		if (element != null && !alwaysFindLeaf) {
			FindResult result = new FindResult(uiElement, element.getElement());
			if (isElementTextFieldChange(uiElement, element)) {
				element.set(ELEMENT_TEXT, PlayerTextUtils.getText(uiElement));
			} else {
				return result;
			}
		}
		ItemUIElement itemElement = findItemUIElement(widget, uiElement, supportEclipseWorkbench);

		ElementEntry newElement = new ElementEntry(itemElement.getElement());
		SWTRecordingHelper.getHelper().put(uiElement, newElement);
		newElement.set(ELEMENT_TEXT, PlayerTextUtils.getText(uiElement));
		return new FindResult(uiElement, itemElement.getElement());
	}

	private FindResult findCoolItem(Widget widget, boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {
		SWTUIElement uiElement = player.wrap(widget);
		ElementEntry element = SWTRecordingHelper.getHelper().get(uiElement);
		element = checkTextFieldChange(uiElement, element);
		if (element != null && !alwaysFindLeaf) {
			return new FindResult(uiElement, element.getElement());
		}
		CoolItem item = (CoolItem) widget;
		CoolBar parent = item.getParent();
		// CoolItem[] items = parent.getItems();
		// int index = 0;
		// for (CoolItem toolItem : items) {
		// if (toolItem.equals(item)) {
		// break;
		// }
		// index++;
		// }
		SWTUIElement semanticParent = getPlayer().getParentElement(getPlayer().wrap(parent));
		FindResult result = findElement(semanticParent, false, false, supportEclipseWorkbench);
		CompositeUIElement ee = new CompositeUIElement(result.element, recorder);
		String text = PlayerTextUtils.getText(player.wrap(item));
		ControlUIElement button = null;
		recorder.setControls(uiElement.getModel());
		boolean needText = false;
		int index = calculateIndex(uiElement, null);
		if (text != null && text.trim().length() > 0) {
			if (index == 0) {
				button = ee.button(text);
			} else {
				button = ee.button(text, index);
			}
			needText = true;
		} else {
			// Indexed
			button = ee.button(index);
		}
		ElementEntry entry = new ElementEntry(button.getElement());
		if (needText) {
			entry.set(ATTR_TEXT, text);
		}
		SWTRecordingHelper.getHelper().put(uiElement, entry);
		return new FindResult(player.wrap(item), entry.getElement());
	}

	private FindResult findToolItem(Widget widget, boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {
		SWTUIElement uiElement = player.wrap(widget);
		ElementEntry element = SWTRecordingHelper.getHelper().get(uiElement);
		element = checkTextFieldChange(uiElement, element);
		if (element != null && !alwaysFindLeaf) {
			return new FindResult(uiElement, element.getElement());
		}
		ToolItem item = (ToolItem) widget;
		ToolBar parent = item.getParent();
		// ToolItem[] items = parent.getItems();
		// int index = 0;
		// for (ToolItem toolItem : items) {
		// if (toolItem.equals(item)) {
		// break;
		// }
		// index++;
		// }
		SWTUIElement parentElement = getPlayer().getParentElement(getPlayer().wrap(parent));
		FindResult result = findElement(parentElement, false, alwaysFindLeaf, supportEclipseWorkbench);
		if (result == null) {
			return null;
		}
		CompositeUIElement ee = new CompositeUIElement(result.element, recorder);
		String text = PlayerTextUtils.getText(player.wrap(item));
		ControlUIElement button = null;
		recorder.setControls(uiElement.getModel());
		boolean needText = false;
		int index = calculateIndex(uiElement, null);
		if (text != null && text.trim().length() > 0) {
			if (index != 0) {
				button = ee.button(text, index);
			} else {
				button = ee.button(text);
			}
			needText = true;
		} else {
			// Indexed
			button = ee.button(index);
		}
		ElementEntry buttonEntry = new ElementEntry(button.getElement());
		if (needText) {
			buttonEntry.set(ATTR_TEXT, text);
		}
		SWTRecordingHelper.getHelper().put(uiElement, buttonEntry);
		return new FindResult(player.wrap(item), buttonEntry.getElement());
	}

	private FindResult findMenuItem(Widget widget, boolean alwaysFindLeaf, boolean supportEclipseWorkbench) {
		MenuItem item = (MenuItem) widget;
		Shell shell = item.getParent().getShell();
		// String text = item.getText();
		Map<Widget, Widget> parentsMap = new HashMap<Widget, Widget>();
		fillParents(parentsMap, item);
		// List<RecordedEvent> events = takeMenuEvents(lastEvents);
		// // Take hides
		// for (RecordedEvent e : events) {
		// fillParents(parentsMap, e.widget);
		// }
		// Collect parents
		List<Widget> path = new ArrayList<Widget>();
		Widget current = item;
		while (current != null) {
			if (current instanceof MenuItem) {
				path.add(0, current);
			}
			current = parentsMap.get(current);
		}
		List<String> selection = new ArrayList<String>();
		boolean doItemCorrection = false;
		for (Widget w : path) {
			String text = player.wrap(w).getText();
			Object data = w.getData();
			if (data != null) {
				if (data instanceof ActionContributionItem) {
					ActionContributionItem contribution = (ActionContributionItem) data;
					String id = contribution.getId();
					if ("org.eclipse.debug.ui.contextualLaunch.run.submenu".equals(id)) {
						doItemCorrection = true;
					}
					if (doItemCorrection) {
						if (text.matches("\\d+ .*")) {
							int pos = text.indexOf(' ');
							text = "\\d+ " + text.substring(pos + 1);
						}
					}
				}
			}
			selection.add(text);
		}

		int intIndex = 0;
		MenuItem[] menuItems = item.getParent().getItems();
		for (MenuItem menuItem : menuItems) {
			String menuItemText = PlayerTextUtils.getMenuText(menuItem.getText());
			String itemText = PlayerTextUtils.getMenuText(item.getText());
			if (menuItemText.equals(itemText)) {
				if (menuItem.equals(item)) {
					break;
				}
				intIndex++;
			}
		}
		Integer index = intIndex == 0 ? null : Integer.valueOf(intIndex);

		// Do recording stuff here
		WindowUIElement recordingShell = getShell(shell, false);

		// SWTUIElement lowerParent = player.wrap(shell);
		CompositeUIElement lowerParentElement = recordingShell;

		Menu upperMenu = item.getParent();
		while (upperMenu.getParentMenu() != null) {
			upperMenu = upperMenu.getParentMenu();
		}

		// update loweParent
		SWTUIElement element = getPlayer().wrap(SWTEventManager.getMenuSource(upperMenu));

		// Filter toolbars as menu source for menu from toolbar buttons with
		// drop down arrows
		if (element != null && element.widget instanceof ToolBar
				&& !upperMenu.equals(((ToolBar) element.widget).getMenu()) && isParentEclipseWindow(upperMenu)) {
			element = null;
		}

		if (element != null) {
			FindResult result = findElement(element, false, alwaysFindLeaf, supportEclipseWorkbench);
			if (result == null) {
				return null;
			}
			lowerParentElement = new CompositeUIElement(result.element, recorder);
			if (element.isTree()) {
				String[][] pathSelection = element.getMultiPathSelection();
				if (pathSelection.length > 0) {
					ViewerUIElement view = new ViewerUIElement(result.element, recorder);
					view.setMultiSelection(pathSelection);
				}
			}
		}
		String[] sel = selection.toArray(new String[selection.size()]);
		recorder.setControls(player.wrap(widget).getModel());
		if (lowerParentElement != null) {
			return new FindResult(player.wrap(item), lowerParentElement.menu(sel, index).getElement());
		}
		return null;
	}

	private FindResult findGenericElement(Widget widget, Control control, SWTUIElement realElement,
			GenericElementKind kind, SWTUIElement lowerParent, Element parentElement) {
		int widgetIndex = -1;
		SWTUIElement realAfter = null;
		SWTUIElement[] realChildren = player.children.collectFor(lowerParent, null, true, getSearchClasses(control));
		// don't try search -after for top level tab folders
		boolean isTopLevelTabFolder = widget instanceof CTabFolder && lowerParent.isWorkbenchWindow();
		// Search for widget
		for (SWTUIElement i : realChildren) {
			String text = i.getText();
			if (i.getKind().is(kind)) {
				widgetIndex++;
			}
			if (i.match(widget)) {
				realElement = i;
				break;
			}
			GenericElementKind iKind = i.getKind();
			if (iKind != null && iKind.isLabel() && text != null && couldBeAfterItem(text.trim())
					&& !isTopLevelTabFolder) {
				SWTUIElement afterParent = player.getParentElement(i);
				// after could be only on same level as control itself
				if (afterParent != null && afterParent.equals(lowerParent)) {
					boolean isPartOfParent = false;
					for (IRecordingProcessorExtension extension : getRecorderExtensions()) {
						if (extension.isPartOfParent(i.unwrap(), afterParent.unwrap())) {
							isPartOfParent = true;
							break;
						}
					}
					if (!isPartOfParent) {
						realAfter = i;
						widgetIndex = -1;
					}
				}
			}
		}
		if (widgetIndex == -1) {
			return null;
		}
		if (realElement != null && realElement.getKind() != null) {
			return selectRequiredElementToBeFocused(realElement, widget, kind, realAfter, parentElement, widgetIndex);
		}
		return null;
	}

	private FindResult selectRequiredElementToBeFocused(SWTUIElement realElement, Widget widget,
			GenericElementKind kind, SWTUIElement realAfter, Element parentElement, int widgetIndex) {

		int absIndex = calculateIndex(realElement, null);
		ElementEntry after = null;
		if (absIndex == 0 && kind.skipFirstAfter()) {
			/*
			 * after are not required in this case
			 */
			realAfter = null;
		}
		// See "QS-1382 At the reproducing the test value is inserted in
		// another field"
		// else {
		// Check if realAfter are between this control and previous one.
		// Otherwise it is not necessary to use after
		// if (realAfter != null
		// && !isAfterBetween(realElement, realAfter)) {
		// realAfter = null;
		// }
		// }
		if (realAfter != null) {
			after = getLabel(realAfter, parentElement);
		}
		String text = realElement.getText();
		UISelector<BasicUIElement> selector = new UISelector<BasicUIElement>(kind, recorder, BasicUIElement.class)
				.parent(parentElement);
		recorder.setControls(realElement.getModel());

		if (after != null) {
			selector = selector.after(after.getElement());
		}
		Set<ElementKind> indexKinds = genIndexKinds();
		ElementEntry result = createElementEntry(indexKinds, selector, text, kind, realElement, widgetIndex, realAfter);

		if (after != null) {
			result.set("after", realAfter);
		} else {
			result.set("after", realElement);
		}
		if (text != null) {
			result.set(ELEMENT_TEXT, text);
		}

		if (widget instanceof Text && widget == EclipseWorkbenchProvider.getProvider().getQuickAccess())
			result.getElement().setDescription("quick-access");

		SWTRecordingHelper.getHelper().put(realElement, result);
		return new FindResult(realElement, result.getElement());
	}

	private ElementEntry createElementEntry(Set<ElementKind> indexKinds, UISelector<BasicUIElement> selector,
			String text, GenericElementKind kind, SWTUIElement realElement, int widgetIndex, SWTUIElement realAfter) {

		ElementEntry result = null;
		if (!indexKinds.contains(kind.kind) && text != null) {
			int i = calculateIndex(realElement, realAfter);
			if (i == -1 || i == 0) {
				result = new ElementEntry(selector.find(text).getElement());
			} else {
				result = new ElementEntry(selector.find(text, i).getElement());
			}
			if (text != null) {
				result.set(ATTR_TEXT, text);
			}
		} else {
			if (widgetIndex == 0) {
				result = new ElementEntry(selector.find().getElement());
			} else {
				result = new ElementEntry(selector.find(widgetIndex).getElement());
			}
		}
		return result;
	}

	private boolean couldBeAfterItem(String text) {
		if (text.length() == 0) {
			return false;
		}
		if (text.matches(".*\\(\\d*%\\).*")) { // Could be progress indicator
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private boolean isAfterBetween(SWTUIElement realElement, SWTUIElement realAfter) {
		SWTUIElement p = player.getParentElement(realElement);
		Widget realWidget = realElement.unwrap();
		Widget realAfterWidget = realAfter.unwrap();
		List<SWTUIElement> elements = new ArrayList<SWTUIElement>(Arrays.asList(player.children.collectFor(p, null,
				true, getSearchableClass(realWidget), getSearchableClass(realAfterWidget))));
		GenericElementKind kind = realElement.getKind();
		int itemIndex = elements.indexOf(realElement);
		int afterIndex = elements.indexOf(realAfter);
		for (int i = afterIndex + 1; i < itemIndex; i++) {
			SWTUIElement element = elements.get(i);
			if (kind.is(element.getKind())) {
				return false;
			}
		}
		return true;
	}

	private FindResult findUnknownElement(Control control, SWTUIElement lowerParent, Element lowerParentElement) {
		SWTUIElement realAfter = null;
		SWTUIElement[] realChildren = player.children.collectFor(lowerParent, null, true);
		int indexOf = -1;
		int afterIndex = -1;
		boolean supportAnyLabels = true;
		Rectangle bounds = control.getBounds();
		Point controlBounds = control.toDisplay(new Point(bounds.x, bounds.y));
		bounds.x = controlBounds.x;
		bounds.y = controlBounds.y;

		for (int i = 0; i < realChildren.length; i++) {
			String text = realChildren[i].getText();
			if (realChildren[i].match(control)) {
				indexOf = i;
				break;
			}
			if (supportAnyLabels) {
				GenericElementKind iKind = realChildren[i].getKind();
				if (iKind != null && iKind.isLabel() && text != null && couldBeAfterItem(text.trim())) {
					SWTUIElement afterParent = player.getParentElement(realChildren[i]);
					// after could be only on same level as control itself
					if (afterParent != null && afterParent.equals(lowerParent)) {
						boolean isPartOfParent = false;
						for (IRecordingProcessorExtension extension : getRecorderExtensions()) {
							if (extension.isPartOfParent(realChildren[i].unwrap(), afterParent.unwrap())) {
								isPartOfParent = true;
								break;
							}
						}
						if (isPartOfParent) {
							continue;
						}
						// check for label bounds be upper control bounds.
						Rectangle afterBounds = realChildren[i].getBounds();
						// If label is placed above control
						if (afterBounds.y <= bounds.y + bounds.height) {
							realAfter = realChildren[i];
							afterIndex = i;
						}
					}
				}
			}
		}
		if (indexOf != -1) {
			ElementEntry result = null;
			ElementEntry after = null;
			UISelector<BasicUIElement> selector = new UISelector<BasicUIElement>(ElementKind.Any, recorder,
					BasicUIElement.class).parent(lowerParentElement);
			if (realAfter != null) {
				after = getLabel(realAfter, lowerParentElement);
				if (after != null) {
					selector = selector.after(after.getElement());
				}
			}
			SWTUIElement item = realChildren[indexOf];
			recorder.setControls(item.getModel());
			int i = indexOf - (afterIndex + 1);
			String text = item.getText();
			if (text != null && text.trim().length() == 0) {
				text = null;
			}
			if (i == -1 || i == 0) {
				result = new ElementEntry(selector.find(text).getElement());
			} else {
				result = new ElementEntry(selector.find(text, i).getElement());
			}
			result.set(ATTR_TEXT, text);
			if (after != null) {
				result.set("after", realAfter);
			}
			SWTRecordingHelper.getHelper().put(item, result);
			return new FindResult(item, result.getElement());
		}
		return null;
	}

	private boolean checkForViewEditor(Control control, Shell shell, SWTUIElement lowerParent) {
		IWorkbench wb = RWTUtils.getWorkbench();
		if (wb != null) {
			IWorkbenchWindow[] workbenchWindows = wb.getWorkbenchWindows();
			if (lowerParent instanceof WorkbenchUIElement) {
				IWorkbenchPage lowerParentPage = ((WorkbenchUIElement) lowerParent).getReference().getPage();
				for (IWorkbenchWindow iWorkbenchWindow : workbenchWindows) {
					Shell wshell = iWorkbenchWindow.getShell();
					if (wshell == shell) {
						WorkbenchPage page = (WorkbenchPage) iWorkbenchWindow.getActivePage();
						if (page.equals(lowerParentPage)) {
							IViewReference[] views = page.getViewReferences();
							for (IViewReference iViewPart : views) {
								Control composite = ((WorkbenchPartReference) iViewPart).getPane().getControl();
								if (control.equals(composite)) {
									return true;
								}
							}
							IEditorReference[] editors = page.getEditorReferences();
							for (IEditorReference iEditorPart : editors) {
								Control composite = ((WorkbenchPartReference) iEditorPart).getPane().getControl();
								if (control.equals(composite)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private boolean checkSkipWorkbenchTabs(boolean supportEclipseWorkbench, Control control, Shell shell) {
		if (control instanceof CTabFolder) {
			// Check for tab folder activation(click) for Workbench.
			// List<Widget> parents = SWTUIPlayer.collectParents(widget);
			// Check for workbench internal element click
			IWorkbenchWindow[] workbenchWindows = RWTUtils.getWorkbenchWindows();
			for (IWorkbenchWindow iWorkbenchWindow : workbenchWindows) {
				Shell wshell = iWorkbenchWindow.getShell();
				if (wshell == shell) {
					WorkbenchPage page = (WorkbenchPage) iWorkbenchWindow.getActivePage();
					Composite composite = page.getClientComposite();
					if (control.getParent().equals(composite)) {
						// Skip click on views/editors tab folder
						// hasViewEditorCTabFolderClick = true;
						if (!supportEclipseWorkbench) {
							return true;
						}
					}
					// e46 checks.
					Object o = control.getData("modelElement");
					if (o != null && o.getClass().getName()
							.contains("org.eclipse.e4.ui.model.application.ui.basic.impl.PartStackImpl")) {
						return true;
					}
					break;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	private Class[] getSearchClasses(Control control) {
		List<Class> classes = new ArrayList<Class>();
		classes.add(Label.class);
		classes.add(CLabel.class);
		classes.add(Link.class);
		classes.add(getSearchableClass(control));
		// if (control instanceof StyledText) {
		// classes.add(Text.class);
		// }
		// if (control instanceof Text) {
		// classes.add(StyledText.class);
		// }
		if (control instanceof Spinner) {
			classes.add(Spinner.class);
		}
		if (control instanceof CCombo) {
			classes.add(Combo.class);
		}
		if (control instanceof Combo) {
			classes.add(CCombo.class);
		}
		if (control instanceof Button) {
			classes.add(ToolItem.class);
		}
		return classes.toArray(new Class[classes.size()]);
	}

	@SuppressWarnings("rawtypes")
	private Class getSearchableClass(Object cl) {
		return SWTUIPlayer.getSearchableClass(cl);
	}

	private Set<ElementKind> genIndexKinds() {
		Set<ElementKind> indexKinds = new HashSet<ElementKind>();
		indexKinds.add(ElementKind.Text);
		indexKinds.add(ElementKind.Tree);
		indexKinds.add(ElementKind.List);
		indexKinds.add(ElementKind.Table);
		indexKinds.add(ElementKind.Combo);
		indexKinds.add(ElementKind.TabFolder);
		indexKinds.add(ElementKind.CBanner);
		indexKinds.add(ElementKind.Toolbar);
		indexKinds.add(ElementKind.CoolBar);
		indexKinds.add(ElementKind.Canvas);
		indexKinds.add(ElementKind.Browser);
		indexKinds.add(ElementKind.DateTime);
		indexKinds.add(ElementKind.Slider);
		indexKinds.add(ElementKind.TextViewer);
		return indexKinds;
	}

	/**
	 * is public for extensions, should not be used elsewhere
	 */
	@SuppressWarnings("rawtypes")
	public int calculateIndex(SWTUIElement semanticParent, SWTUIElement afterLabel) {
		String text = semanticParent.getText();
		// if (text == null || text.length() == 0) {
		// return -1;
		// }
		Widget w = PlayerWrapUtils.unwrapWidget(semanticParent);
		SWTUIElement p = player.getParentElement(semanticParent);
		if (p != null) {
			List<Class> classes = new ArrayList<Class>();
			classes.add(getSearchableClass(w));
			// if (w instanceof StyledText)
			// classes.add(Text.class);
			// if (w instanceof Text)
			// classes.add(StyledText.class);
			if (w instanceof Spinner)
				classes.add(Spinner.class);
			if (w instanceof Button)
				classes.add(ToolItem.class);
			if (afterLabel != null) {
				classes.add(Label.class);
				classes.add(CLabel.class);
				classes.add(Link.class);
			}
			SWTUIElement[] children = player.children.collectFor(p, null, true,
					classes.toArray(new Class[classes.size()]));
			int index = 0;
			// Filter out all items before label
			int pos = 0;
			if (afterLabel != null) {
				Widget label = PlayerWrapUtils.unwrapWidget(afterLabel);
				for (int i = 0; i < children.length; i++) {
					if (children[i].match(label)) {
						pos = i + 1;
						break;
					}
				}
			}
			Set<ElementKind> indexKinds = genIndexKinds();
			ElementKind kind = semanticParent.getKind().kind;
			for (int i = pos; i < children.length; i++) {
				if (children[i].match(w)) {
					return index;
				}
				if (indexKinds.contains(kind) && children[i].getKind().is(kind)) {
					index++;
				} else if (text != null && text.equals(children[i].getText()) && children[i].getKind().is(kind)) {
					index++;
				} else if ((text == null) && children[i].getKind().is(kind)) {
					index++;
				}
			}
		}
		return 0;
	}

	private void fillParents(Map<Widget, Widget> parentsMap, Widget e) {
		if (e.isDisposed()) {
			return;
		}
		if (parentsMap.containsKey(e)) {
			return;
		}
		if (e instanceof MenuItem) {
			MenuItem menuItem = (MenuItem) e;
			parentsMap.put(e, menuItem.getParent());
			Menu menu = menuItem.getMenu();
			if (menu != null) {
				parentsMap.put(menu, e);
				fillParents(parentsMap, menu);
			}
			Menu parent = menuItem.getParent();
			if (parent != null) {
				parentsMap.put(menuItem, parent);
				fillParents(parentsMap, parent);
			}
		} else if (e instanceof Menu) {
			Menu m = (Menu) e;
			// MenuItem[] items = m.getItems();
			// for (MenuItem menuItem : items) {
			// fillParents(parentsMap, menuItem);
			// }
			MenuItem parentItem = m.getParentItem();
			if (parentItem != null) {
				fillParents(parentsMap, parentItem);
			}
		}
	}

	private ElementEntry getLabel(SWTUIElement realAfter, Element parent) {
		ElementEntry after = SWTRecordingHelper.getHelper().get(realAfter);
		after = checkTextFieldChange(realAfter, after);
		if (after == null) {
			recorder.setControls(realAfter.getModel());
			FindResult afterElement = findElement(realAfter, false, false, true);
			String realAfterText = realAfter.getText();
			// if (realAfter.getKind().is(ElementKind.Label)) {
			// after = new ElementEntry(controlUIElement(parent).label(
			// realAfterText).getElement());
			// } else if (realAfter.getKind().is(ElementKind.Link)) {
			// after = new ElementEntry(controlUIElement(parent).link(
			// realAfterText).getElement());
			// }
			after = new ElementEntry(afterElement.element);
			after.set(ATTR_TEXT, realAfterText);
			SWTRecordingHelper.getHelper().put(realAfter, after);
		}
		return after;
	}

	@SuppressWarnings("unused")
	private CompositeUIElement controlUIElement(Element window) {
		return new CompositeUIElement(window, recorder);
	}

	public WindowUIElement getShell(Shell shell, boolean alwaysFindLeaf) {
		if (shell == null) {
			return null;
		}
		if (!shell.isVisible()) {
			return null;
		}
		String pattern = shell.getText();
		SWTUIElement wrappedShell = player.wrap(shell);
		ElementEntry window = SWTRecordingHelper.getHelper().get(wrappedShell);
		window = checkTextFieldChange(wrappedShell, window);
		if (window == null || alwaysFindLeaf) {
			// Check this is SDK window and only one window.
			IWorkbench wb = RWTUtils.getWorkbench();
			IWorkbenchWindow[] windows = wb != null ? wb.getWorkbenchWindows() : new IWorkbenchWindow[0];

			int ind = 0;
			boolean found = false;
			for (IWorkbenchWindow iWorkbenchWindow : windows) {
				if (shell.equals(iWorkbenchWindow.getShell())) {
					int sdkIndex = pattern.indexOf("- Eclipse SDK");
					if (sdkIndex != -1) {
						pattern = ".*- Eclipse SDK";
					}
					found = true;
					break;// We found correct window
				}
				ind++;
			}
			// Iterate shell parents
			Composite parent = shell.getParent();
			pattern = pattern.trim();
			WindowUIElement win = null;
			if (found && parent == null) {
				recorder.setControls(wrappedShell.getModel());
				win = ind == 0 ? recorder.eclipseWindow() : recorder.eclipseWindow(ind);
			} else {
				IWindowProvider parentWindow = getShell((Shell) parent, alwaysFindLeaf);
				if (parentWindow == null) {
					parentWindow = recorder;
				}
				recorder.setControls(wrappedShell.getModel());

				// by title text
				if (pattern.length() != 0) {
					int i = calculateIndex(wrappedShell, null);
					if (i != 0) {
						win = parentWindow.window(pattern, i);
					} else {
						win = parentWindow.window(pattern);
					}
				}

				// by -class
				if (win == null) {
					String className = GetWindowUtil.getWindowClassName(shell);
					if (className != null) {
						SWTUIElement[] children = player.children.collectFor(getPlayer().wrap(parent), null, true,
								Shell.class);
						int index = IndexUtil.calcIndexFor(shell, children, GetWindowUtil.byClass(className));

						if (index != 0) {
							win = parentWindow.classedWindow(className, index);
						} else {
							win = parentWindow.classedWindow(className);
						}
					}
				}

				// by -from
				if (win == null) {
					String methodName = GetWindowUtil.getShellCreationMethodName(shell);
					if (methodName != null) {
						SWTUIElement[] children = player.children.collectFor(getPlayer().wrap(parent), null, true,
								Shell.class);
						int index = IndexUtil.calcIndexFor(shell, children, GetWindowUtil.byFrom(methodName));

						if (index != 0) {
							win = parentWindow.fromedWindow(methodName, index);
						} else {
							win = parentWindow.fromedWindow(methodName);
						}
					}
				}

				if (win == null) {
					throw new RuntimeException("Failed to locate shell element:" + shell.toString());
				}
			}

			window = new ElementEntry(win.getElement());
			if (!(found && parent == null)) {
				window.set(ATTR_TEXT, pattern);
			}
			window.getElement().setDescription(pattern);
			SWTRecordingHelper.getHelper().put(wrappedShell, window);
		}
		return new WindowUIElement(window.getElement(), recorder);
	}

	private ElementEntry checkTextFieldChange(SWTUIElement uiElement, ElementEntry element) {
		if (element == null) {
			return null;
		}
		String text = element.get(ATTR_TEXT);
		if (text != null) {
			String pattern = PlayerTextUtils.getText(uiElement);
			if (pattern != null && !pattern.equals(text)) {
				SWTRecordingHelper.getHelper().remove(uiElement);
				SWTRecordingHelper.getHelper().clearAllWithParent(uiElement);
				element = null;
			}
		}
		return element;
	}

	private boolean isElementTextFieldChange(SWTUIElement uiElement, ElementEntry element) {
		if (element != null) {
			String text = element.get(ELEMENT_TEXT);
			if (text != null) {
				String pattern = PlayerTextUtils.getText(uiElement);
				if (pattern != null && !pattern.equals(text)) {
					return true;
				}
			}
		}
		return false;
	}

	public PartUIElement findPartElement(IWorkbenchPart part, boolean alwaysFindLeaf) {
		SWTUIElement wrap = player.wrap(part);
		ElementEntry result = SWTRecordingHelper.getHelper().get(wrap);
		result = checkTextFieldChange(wrap, result);
		if (result != null && !alwaysFindLeaf) {
			return new PartUIElement(result.getElement(), recorder);
		}
		IWorkbenchWindow window = part.getSite().getWorkbenchWindow();
		if (part instanceof IViewPart) {
			IViewPart viewPart = (IViewPart) part;
			String title = ((WorkbenchPart) viewPart).getPartName();
			WindowUIElement shellElement = getShell(window.getShell(), false);
			if (shellElement == null) {
				return null;
			}
			getRecorder().setControls(SWTModelMapper.map(wrap));
			int ViewIdx = calcViewIndex(part);
			if (ViewIdx > 0) {
				result = new ElementEntry(shellElement.view(title, ViewIdx).getElement());
			} else {
				result = new ElementEntry(shellElement.view(title).getElement());
			}
			result.set(ATTR_TEXT, title);
		}
		if (part instanceof IEditorPart) {
			IEditorPart editorPart = (IEditorPart) part;
			String title = ((WorkbenchPart) editorPart).getPartName();
			FindResult element = findElement(getPlayer().wrap(window.getShell()), false, false, false);
			WindowUIElement windowElement = new WindowUIElement(element.element, recorder);
			getRecorder().setControls(SWTModelMapper.map(wrap));

			EditorLocation location = getEditorLocation(editorPart);
			result = new ElementEntry(
					windowElement.editor(location.title, location.label, location.index).getElement());

			result.set(ATTR_TEXT, title);
		}
		if (result != null) {
			SWTRecordingHelper.getHelper().put(wrap, result);
			return new PartUIElement(result.getElement(), recorder);
		}
		return null;
	}

	private static class EditorLocation {
		public String title;
		public String label;
		public Integer index;

		public EditorLocation(String title, String label, Integer index) {
			this.title = title;
			this.label = label;
			this.index = index;
		}
	}

	private EditorLocation getEditorLocation(IEditorPart editor) {
		IEditorReference[] refs = editor.getSite().getWorkbenchWindow().getActivePage().getEditorReferences();

		String name = ((WorkbenchPart) editor).getPartName();
		String id = editor.getSite().getId();
		String label = editor.getSite().getWorkbenchWindow().getWorkbench().getEditorRegistry().findEditor(id)
				.getLabel();

		// -- locate by name only

		int counter = 0;
		for (IEditorReference ref : refs) {
			if (ref.getPartName() != null && ref.getPartName().equals(name))
				++counter;
		}
		if (counter < 2) {
			return new EditorLocation(name, null, null);
		}

		// -- by name, editor type and maybe by index

		counter = 0;
		int index = 0; // this will select first editor
		int globalIndex = 0;
		boolean typeDiversity = false;
		for (int i = 0; i < refs.length; ++i) {
			IEditorReference ref = refs[i];
			if (ref.getPartName() != null && ref.getPartName().equals(name)) {
				if (ref.getId() != null && ref.getId().equals(id)) {
					if (editor == ref.getEditor(false)) {
						index = counter;
						globalIndex = i;
					}
					++counter;
				} else
					typeDiversity = true;
			}
		}
		if (counter < 2)
			return new EditorLocation(name, label, null);

		// if all editors of a resource are of same type, use only name and
		// index
		if (!typeDiversity)
			return new EditorLocation(name, null, index == 0 ? null : index);

		return new EditorLocation(name, globalIndex == 0 ? null : label, index == 0 || globalIndex == 0 ? null : index);
	}

	private int calcViewIndex(IWorkbenchPart part) {

		String title = ((WorkbenchPart) part).getPartName();
		int currIdx = 0;
		IViewReference[] views = RWTUtils.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();

		for (IViewReference iViewRef : views) {
			String label = iViewRef.getPartName();

			if (label != null && label.equals(title)) {
				if (iViewRef.getPart(false).equals(part))
					return currIdx;
				currIdx++;
			}
		}
		return -1;
	}

	public int getColumnFromCellEditor(Object cellEditorObj, ControlEditor editor, CellEditor cellEditor) {
		if (editor instanceof TreeEditor) {
			int col = ((TreeEditor) editor).getColumn();
			if (col != -1) {
				return col;
			}
		} else if (editor instanceof TableEditor) {
			int col = ((TableEditor) editor).getColumn();
			if (col != -1) {
				return col;
			}
		}
		ColumnViewerEditor cve = null;
		if (cellEditorObj instanceof ColumnViewerEditor) {
			cve = (ColumnViewerEditor) cellEditorObj;
		}
		if (cve == null) {
			cve = getColumnViewerEditor(cellEditor);
		}
		if (cve != null) {
			ViewerCell cell = cve.getFocusCell();
			if (cell != null) {
				return cell.getColumnIndex();
			}
		}
		return -1;
	}

	private ColumnViewerEditor getColumnViewerEditor(CellEditor cellEditor) {
		return TeslaSWTAccess.getColumnViewerEditor(cellEditor);
	}

	public SWTWidgetLocator(SWTUIPlayer player) {
		super();
		this.player = player;
	}

	protected CellEditor getCellEditor(Object cellEditorObj) {
		CellEditor cellEditor = null;
		if (cellEditorObj instanceof CellEditor) {
			cellEditor = (CellEditor) cellEditorObj;
		} else if (cellEditorObj instanceof ColumnViewerEditor) {
			cellEditor = getCellEditorFromColumnEditor((ColumnViewerEditor) cellEditorObj);
		}
		return cellEditor;
	}

	public void cleanMenuSources() {
		SWTEventManager.cleanMenuSources();
	}

	public TeslaRecorder getRecorder() {
		return recorder;
	}

	/**
	 * @see #findElement(SWTUIElement, boolean, boolean, boolean)
	 */
	public FindResult findElement(Widget widget, boolean unknownAllowed, boolean alwaysFindLeaf,
			boolean supportEclipseWorkbench) {
		return findElement(getPlayer().wrap(widget), unknownAllowed, alwaysFindLeaf, supportEclipseWorkbench);
	}

	private FindResult tryFindDiagram(Canvas canvas) {
		List<ICanvasDiagramHelper> processors = recorder.getProcessors(ICanvasDiagramHelper.class);
		for (ICanvasDiagramHelper processor : processors) {
			Element element = processor.findDiagramElement(canvas);
			if (element != null) {
				return new FindResult(getPlayer().wrap(canvas), element);
			}
		}
		return null;
	}

	public static IWorkbenchPart findViewMenuSource(Widget widget) {
		IWorkbench workbench = RWTUtils.getWorkbench();
		if (workbench == null)
			return null;
		IWorkbenchWindow[] workbenchWindows = workbench.getWorkbenchWindows();
		for (IWorkbenchWindow iWorkbenchWindow : workbenchWindows) {
			WorkbenchPage page = (WorkbenchPage) iWorkbenchWindow.getActivePage();
			IViewReference[] viewReferences = page.getViewReferences();
			for (IViewReference viewReference : viewReferences) {
				IWorkbenchPart workbenchPart = viewReference.getPart(false);
				if (workbenchPart != null) {
					PartSite site = (PartSite) workbenchPart.getSite();
					if (site != null) {
						Menu menu = EclipseWorkbenchProvider.getProvider().getViewMenu(workbenchPart, viewReference,
								false);
						if (menu != null && menu.equals(widget)) {
							return workbenchPart;
						}
					}
				}
			}
		}
		return null;
	}

	public static boolean isOpenPespectiveButton(ToolItem item) {
		return TeslaSWTAccess.getThis(PerspectiveBarContributionItem.class, item, SWT.Selection) != null;
	}

	public static boolean isCTabFolderListMenuItem(MenuItem menuItem) {
		CTabFolder tabFolder = getCTabFolder(menuItem);
		if (tabFolder != null) {
			Menu tabFolderItemListMenu = TeslaSWTAccess.getCTabFolderItemListMenu(tabFolder);
			return (menuItem.getParent().equals(tabFolderItemListMenu));
		}
		return false;
	}

	public static CTabFolder getCTabFolder(MenuItem menuItem) {
		return TeslaSWTAccess.getThis(CTabFolder.class, menuItem, SWT.Selection);
	}

	private static boolean isParentEclipseWindow(Menu menu) {
		return RWTUtils.getWorkbench().getActiveWorkbenchWindow().getShell().equals(menu.getParent());
	}

	// extensions stuff

	List<IWidgetLocatorExtension> extensions = new ArrayList<IWidgetLocatorExtension>();

	public void addExtension(IWidgetLocatorExtension ext) {
		extensions.add(ext);
	}

	public List<IRecordingProcessorExtension> getRecorderExtensions() {
		if (recorderExtensions == null) {
			recorderExtensions = recorder.getProcessors(IRecordingProcessorExtension.class);
		}
		return recorderExtensions;
	}
}
