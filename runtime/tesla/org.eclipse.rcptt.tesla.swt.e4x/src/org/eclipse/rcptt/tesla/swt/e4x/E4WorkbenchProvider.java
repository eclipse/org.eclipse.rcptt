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
package org.eclipse.rcptt.tesla.swt.e4x;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.impl.AreaImpl;
import org.eclipse.e4.ui.model.application.ui.advanced.impl.PlaceholderImpl;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.impl.PartImpl;
import org.eclipse.e4.ui.model.application.ui.basic.impl.PartStackImpl;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.e4.ui.workbench.addons.minmax.TrimStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.WorkbenchUIElement;
import org.eclipse.rcptt.tesla.swt.workbench.IEclipseWorkbenchProvider;
import org.eclipse.rcptt.util.ReflectionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.ViewSite;
import org.eclipse.ui.internal.WorkbenchPartReference;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.internal.e4.compatibility.ActionBars;
import org.eclipse.ui.internal.e4.compatibility.SelectionService;
import org.eclipse.ui.internal.quickaccess.SearchField;
import org.osgi.framework.Version;

public class E4WorkbenchProvider implements IEclipseWorkbenchProvider {

	private static <T> T as(Class<T> class_, Object object) {
		if (class_.isInstance(object))
			return class_.cast(object);
		return null;
	}

	public Menu getViewMenu(IWorkbenchPart workbenchPart,
			IWorkbenchPartReference reference, boolean create) {

		ViewSite site = as(ViewSite.class, workbenchPart.getSite());
		if (site == null)
			return null;

		ActionBars bars = as(ActionBars.class, site.getActionBars());
		if (bars == null)
			return null;

		MenuManager man = as(MenuManager.class, bars.getMenuManager());
		if (man == null)
			return null;

		Menu menu = man.getMenu();
		if ((menu == null || menu.isDisposed()) && create)
			man.createContextMenu(site.getShell());

		return man.getMenu();
	}

	@SuppressWarnings("restriction")
	public Control getToolbar(IWorkbenchPartReference reference) {
		try {
			return ((ToolBarManager) ((PartSite) ((WorkbenchPartReference) reference)
					.getPart(false).getSite()).getActionBars()
					.getToolBarManager()).getControl();
		} catch (Exception e) {
			// II: don't bother with NPE and class casts if internal API will
			// change
			return null;
		}
	}

	public boolean canClickView(IWorkbenchPartReference reference) {
		return true;
	}

	public Map<Control, SWTUIElement> getWorkbenchReference(SWTUIPlayer player) {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench()
				.getWorkbenchWindows();
		if (!Display.getCurrent()
				.equals(PlatformUI.getWorkbench().getDisplay())) {
			return new HashMap<Control, SWTUIElement>();
		}
		Map<Control, SWTUIElement> references = new HashMap<Control, SWTUIElement>();
		for (IWorkbenchWindow iWorkbenchWindow : windows) {
			// This is workbench window
			IWorkbenchPage page = iWorkbenchWindow.getActivePage();
			IEditorReference[] editors = page.getEditorReferences();
			IViewReference[] views = page.getViewReferences();
			for (IViewReference iViewReference : views) {
				WorkbenchPartReference ref = ((WorkbenchPartReference) iViewReference);
				IWorkbenchPart refPart = ref.getPart(false);
				if (refPart != null && ref.getPane().getControl() != null) {
					Control control = ref.getPane().getControl();
					references.put(control, player.wrap(ref));
					Control toolbar = getToolbar(ref);
					if (toolbar != null) {
						references.put(toolbar, player.wrap(ref));
					}
				}
			}
			for (IEditorReference iEditorReference : editors) {
				WorkbenchPartReference ref = ((WorkbenchPartReference) iEditorReference);
				IWorkbenchPart refPart = ref.getPart(false);
				if (refPart != null && ref.getPane().getControl() != null) {
					Control control = ref.getPane().getControl();
					references.put(control, player.wrap(ref));
					// Control toolBar = ref.getPane().getToolBar();
					// if (toolBar != null) {
					// references.put(toolBar, player.wrap(ref));
					// }
				}
			}
		}
		return references;
	}

	private CTabFolder getCTabFolder(Widget widget) {
		if (widget instanceof CTabFolder) {
			return (CTabFolder) widget;
		}
		if (widget instanceof Control && widget.getData("modelElement") != null) {
			Composite parent = ((Control) widget).getParent();
			if (parent == null || parent instanceof CTabFolder)
				return (CTabFolder) parent;
			parent = parent.getParent();
			if (parent instanceof CTabFolder)
				return (CTabFolder) parent;
		}
		return null;
	}

	public void processTabFolderButton(Widget widget, int buttonId) {
		CTabFolder tabFolder = getCTabFolder(widget);
		if (tabFolder == null)
			return;

		ToolItem maxItem = null, minItem = null;
		try {
			Field field = CTabFolder.class.getDeclaredField("maxItem");
			field.setAccessible(true);
			maxItem = (ToolItem) field.get(tabFolder);

			field = CTabFolder.class.getDeclaredField("minItem");
			field.setAccessible(true);
			minItem = (ToolItem) field.get(tabFolder);
		} catch (Exception e) {
			TeslaCore.log(e);
		}

		if (maxItem == null
				|| (minItem == null && buttonId == IWorkbenchPage.STATE_MINIMIZED))
			return;

		Event e = new Event();
		switch (buttonId) {
		case IWorkbenchPage.STATE_MAXIMIZED:
			if (tabFolder.getMaximized())
				return;
			e.widget = maxItem;
			e.type = SWT.Selection;
			maxItem.notifyListeners(SWT.Selection, e);
			break;
		case IWorkbenchPage.STATE_MINIMIZED:
			if (tabFolder.getMinimized())
				return;
			e.widget = minItem;
			e.type = SWT.Selection;
			minItem.notifyListeners(SWT.Selection, e);
			break;
		case IWorkbenchPage.STATE_RESTORED:
			if (!tabFolder.getMinimized() && !tabFolder.getMaximized())
				return;
			e.widget = maxItem;
			e.type = SWT.Selection;
			maxItem.notifyListeners(SWT.Selection, e);
			break;
		}
	}

	public void processTabShowList(Widget widget) {
		CTabFolder tabFolder = getCTabFolder(widget);
		if (tabFolder == null)
			return;

		ToolItem chevronItem = null;
		try {
			Field field = CTabFolder.class.getDeclaredField("chevronItem");
			field.setAccessible(true);
			chevronItem = (ToolItem) field.get(tabFolder);
		} catch (Exception e) {
			TeslaCore.log(e);
		}

		if (chevronItem == null)
			return;

		if (!chevronItem.getParent().isVisible())
			return;

		Event e = new Event();
		e.widget = chevronItem;
		e.type = SWT.Selection;
		chevronItem.notifyListeners(SWT.Selection, e);
	}

	public boolean isVisible(IWorkbenchPartReference reference) {
		IWorkbenchPart part = reference.getPart(false);
		if (part != null) {
			return ((WorkbenchPartReference) reference).getPane().getControl()
					.isVisible();
		}
		return false;
	}

	public boolean isActiveContainsView(IWorkbenchPage page,
			IWorkbenchPartReference reference) {
		// return isVisible(reference);
		return true;
	}

	public boolean isViewOrEditorButton(Widget widget) {
		if (!(widget instanceof ToolItem))
			return false;

		ToolItem item = (ToolItem) widget;
		String tooltip = item.getToolTipText();
		if (!(tooltip == null || tooltip.equals("View Menu")
				|| tooltip.equals("Maximize") || tooltip.equals("Minimize")
				|| tooltip.equals("Restore") || tooltip.equals("Show List")))
			return false;

		if (item.getData("theMenu") != null) // view menu
			return true;

		// restore button
		if (item.getParent() instanceof ToolBar
				&& TeslaSWTAccess.getThis(TrimStack.class, item, SWT.Selection) != null)
			return true;

		Composite parent = item.getParent().getParent();
		if (!(parent instanceof CTabFolder))
			return false;

		Widget control = extractViewOrEditorControl((CTabFolder) parent);
		return control != null;
	}

	public boolean isSupported() {
		Version version = TeslaCore.getPlatformVersion();
		if (version.getMajor() == 3 && version.getMinor() >= 103) {
			return true;
		}
		return false;
	}

	public Widget extractViewOrEditorControl(CTabFolder tabFolder) {
		if (tabFolder.getSelection() == null)
			return null;

		Control selection = tabFolder.getSelection().getControl();

		if (selection instanceof Composite) {

			Object data = selection.getData("modelElement");
			if (data instanceof PartImpl)
				return selection; // editors

			// views
			Control[] children = ((Composite) selection).getChildren();
			for (Control c : children) {
				if (!(c instanceof Composite))
					continue;

				data = c.getData("modelElement");
				if (!(data instanceof PartImpl))
					continue;

				return c;
			}

			return null;
		} else
			return null;
	}

	public CTabFolder getTabFolderFromButton(ToolItem button) {
		Composite parent = button.getParent().getParent();
		if (parent instanceof CTabFolder)
			return (CTabFolder) parent;

		// view menu
		if (parent != null && button.getData("theMenu") != null) {
			parent = parent.getParent();
			if (parent instanceof CTabFolder)
				return (CTabFolder) parent;
		}

		// restore button
		TrimStack trimStack = TeslaSWTAccess.getThis(TrimStack.class, button,
				SWT.Selection);
		if (trimStack != null) {
			try {
				Field field = TrimStack.class
						.getDeclaredField("minimizedElement");
				field.setAccessible(true);
				Object minimizedElement = field.get(trimStack);

				if (minimizedElement instanceof PartStackImpl) { // views
					Object widget = ((PartStackImpl) minimizedElement)
							.getWidget();
					if (widget instanceof CTabFolder)
						return (CTabFolder) widget;
				} else if (minimizedElement instanceof PlaceholderImpl) { // editors
					MUIElement ref = ((PlaceholderImpl) minimizedElement)
							.getRef();
					if (ref instanceof AreaImpl) {
						Object selected = ((AreaImpl) ref).getSelectedElement();
						if (selected instanceof PartStackImpl) {
							Object widget = ((PartStackImpl) selected)
									.getWidget();
							if (widget instanceof CTabFolder)
								return (CTabFolder) widget;
						}
					}
				}

			} catch (Exception e) {
			}
		}

		return null;
	}

	private static final String JUNO_TEXT_FIELD = "getFilterText";
	private static final String KEPLER_TEXT_FIELD = "getQuickAccessSearchText";

	public Text getQuickAccess() {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window == null)
			return null;

		MWindow mWindow = ((WorkbenchWindow) window).getModel();
		if (mWindow == null)
			return null;

		EModelService modelService = mWindow.getContext().get(
				EModelService.class);
		if (modelService == null)
			return null;

		MToolControl searchField = (MToolControl) modelService.find(
				"SearchField", mWindow);
		if (searchField == null)
			return null;

		if (!(searchField.getObject() instanceof SearchField))
			return null;

		SearchField field = (SearchField) searchField.getObject();
		if (field == null)
			return null;

		Object result = ReflectionUtil.callMethod(field, JUNO_TEXT_FIELD);
		if (result == null) {
			result = ReflectionUtil.callMethod(field, KEPLER_TEXT_FIELD);
		}
		return result == null ? null : (Text) result;
	}

	public void updateActiveSelection(List<Object> selectionData,
			SWTUIElement parent) {
		List<SWTUIElement> parentsList = parent.getPlayer().getParentsList(
				parent);
		parentsList.add(parent);
		for (SWTUIElement e : parentsList) {
			final GenericElementKind kind = e.getKind();
			if (kind.is(ElementKind.View) || kind.is(ElementKind.Editor)) {
				if (e instanceof WorkbenchUIElement) {
					final IWorkbenchPartReference reference = ((WorkbenchUIElement) e)
							.getReference();
					IWorkbenchWindow window = reference.getPage()
							.getWorkbenchWindow();
					IWorkbenchPart part = reference.getPart(true);
					ISelectionService selectionService = window
							.getSelectionService();

					((SelectionService) selectionService).updateSelection(part);
				}
			}
		}
	}

	public String getViewId(Widget widget) {
		// not supported for now
		return null;
	}
}
