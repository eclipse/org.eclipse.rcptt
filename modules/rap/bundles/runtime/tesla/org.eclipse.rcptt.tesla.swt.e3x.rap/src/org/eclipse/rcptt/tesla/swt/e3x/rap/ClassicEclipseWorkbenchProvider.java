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
package org.eclipse.rcptt.tesla.swt.e3x.rap;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.PartPane;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.PartStack;
import org.eclipse.ui.internal.Perspective;
import org.eclipse.ui.internal.ViewPane;
import org.eclipse.ui.internal.ViewStackTrimToolBar;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPartReference;
import org.eclipse.ui.internal.presentations.PaneFolder;
import org.eclipse.ui.internal.presentations.PaneFolderButtonListener;
import org.eclipse.ui.internal.presentations.defaultpresentation.DefaultTabFolder;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.swt.workbench.IEclipseWorkbenchProvider;
import org.eclipse.rcptt.tesla.ui.RWTUtils;

@SuppressWarnings("restriction")
public class ClassicEclipseWorkbenchProvider implements
		IEclipseWorkbenchProvider {
	
	private Version rapVersion;

	public Menu getViewMenu(IWorkbenchPart workbenchPart,
			IWorkbenchPartReference reference, boolean create) {
		if (workbenchPart.getSite() == null) {
			return null;
		}

		PartPane pane = ((PartSite) workbenchPart.getSite()).getPane();
		if (!(pane instanceof ViewPane)) {
			return null;
		}

		MenuManager menuManager = ((ViewPane) pane).getMenuManager();
		if (menuManager == null) {
			return null;
		}

		Menu menu = menuManager.getMenu();
		if (menu != null && !menu.isDisposed()) {
			return menu;
		}

		if (!create) {
			return null;
		}

		menuManager.createContextMenu(pane.getControl().getParent());
		return menuManager.getMenu();
	}

	public List<?> getPaneFolderButtonListeners(Object paneFolder) {
		try {
			Field field = PaneFolder.class.getDeclaredField("buttonListeners");
			field.setAccessible(true);
			return (List<?>) field.get(paneFolder);
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public Control getToolbar(IWorkbenchPartReference reference) {
		return ((WorkbenchPartReference) reference).getPane().getToolBar();
	}

	public boolean canClickView(IWorkbenchPartReference reference) {
		IWorkbenchPage page = reference.getPage();
		Perspective perspective = ((WorkbenchPage) page).getActivePerspective();
		IWorkbenchPart part = reference.getPart(true);
		if (part != null && part instanceof IViewPart) {
			if (!perspective.containsView((IViewPart) part)) {
				return false;
			}
		}
		return true;
	}

	public Map<Control, SWTUIElement> getWorkbenchReference(SWTUIPlayer player) {
		if(RWTUtils.getWorkbench() == null) {
			return Collections.emptyMap();
		}
		IWorkbenchWindow[] windows = RWTUtils.getWorkbench().getWorkbenchWindows();


		if (!Display.getCurrent()
				.equals(RWTUtils.getWorkbench().getDisplay())) {
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
				if (ref.getVisible()) {
					Control control = ref.getPane().getControl();
					references.put(control, player.wrap(ref));
					Control toolBar = ref.getPane().getToolBar();
					if (toolBar != null) {
						references.put(toolBar, player.wrap(ref));
					}
				}
			}
			for (IEditorReference iEditorReference : editors) {
				WorkbenchPartReference ref = ((WorkbenchPartReference) iEditorReference);
				if (ref.getVisible()) {
					Control control = ref.getPane().getControl();
					references.put(control, player.wrap(ref));
					Control toolBar = ref.getPane().getToolBar();
					if (toolBar != null) {
						references.put(toolBar, player.wrap(ref));
					}
				}
			}
		}
		return references;
	}

	public void processTabFolderButton(Widget widget, int buttonId) {
		if (!(widget instanceof CTabFolder)) {
			if (widget instanceof Control) {
				Composite parent = ((Control) widget).getParent();
				if (parent == null)
					return;
				for (Control c : parent.getChildren())
					if (c instanceof CTabFolder && !c.isDisposed()) {
						Object data = ((CTabFolder) c).getData();
						if (data instanceof PartStack) {
							PartStack stack = (PartStack) data;
							PartPane selection = stack.getSelection();
							if (selection != null
									&& selection.getControl() == widget)
								widget = c;
						}
					}
			}
		}

		if (!(widget instanceof CTabFolder))
			return;

		// --

		PaneFolder paneFolder = TeslaSWTAccess.getThis(PaneFolder.class,
				widget, SWT.Dispose);
		if (paneFolder != null) {
			List<?> listenters = getPaneFolderButtonListeners(paneFolder);
			for (Object listener : listenters) {
				if (listener instanceof PaneFolderButtonListener) {
					((PaneFolderButtonListener) listener)
							.stateButtonPressed(buttonId);
				}
			}
		}
	}

	public void processTabShowList(Widget widget) {
		if (!(widget instanceof CTabFolder)) {
			if (widget instanceof Control) {
				Composite parent = ((Control) widget).getParent();
				if (parent == null)
					return;
				for (Control c : parent.getChildren())
					if (c instanceof CTabFolder && !c.isDisposed()) {
						Object data = ((CTabFolder) c).getData();
						if (data instanceof PartStack) {
							PartStack stack = (PartStack) data;
							PartPane selection = stack.getSelection();
							if (selection != null
									&& selection.getControl() == widget)
								widget = c;
						}
					}
			}
		}

		if (!(widget instanceof CTabFolder))
			return;

		// --

		PaneFolder paneFolder = TeslaSWTAccess.getThis(PaneFolder.class,
				widget, SWT.Dispose);
		if (paneFolder != null) {
			List<?> listenters = getPaneFolderButtonListeners(paneFolder);
			for (Object listener : listenters) {
				if (listener instanceof PaneFolderButtonListener) {
					CTabFolderEvent event = TeslaSWTAccess
							.createCTabFolderEvent(widget);
					((PaneFolderButtonListener) listener).showList(event);
				}
			}
		}
	}

	public boolean isVisible(IWorkbenchPartReference reference) {
		return reference instanceof WorkbenchPartReference
				&& ((WorkbenchPartReference) reference).getVisible();
	}

	public boolean isActiveContainsView(IWorkbenchPage page,
			IWorkbenchPartReference reference) {
		Perspective perspective = ((WorkbenchPage) page).getActivePerspective();
		IWorkbenchPart part = reference.getPart(true);
		if (part != null && part instanceof IViewPart) {
			if (!perspective.containsView((IViewPart) part)) {
				return false;
			}
		}
		return true;
	}

	public boolean isSupported() {
		if (rapVersion == null) {
			Bundle rapUIBundle = Platform.getBundle("org.eclipse.rap.ui");
			if (rapUIBundle != null) {
				rapVersion = rapUIBundle.getVersion();
			} else {
				rapVersion = Version.emptyVersion;
			}
		}
        return rapVersion.getMajor() == 3;
	}

	private static final List<String> viewTooltips = Arrays.asList("View Menu",
			"Maximize", "Minimize", "Restore");

	public boolean isViewOrEditorButton(Widget widget) {
		if (!(widget instanceof ToolItem))
			return false;

		ToolItem item = (ToolItem) widget;
		if (!viewTooltips.contains(item.getToolTipText())) {
			return false;
		}

		// view menu
		if (TeslaSWTAccess.getThis(DefaultTabFolder.class, item.getParent(),
				SWT.MouseDown) != null)
			return true;

		// restore button
		if (TeslaSWTAccess.getThis(ViewStackTrimToolBar.class, item.getData()) != null)
			return true;

		return false;
	}

	public Widget extractViewOrEditorControl(CTabFolder tabFolder) {
		Object data = tabFolder.getData();
		if (data instanceof PartStack) {
			PartStack stack = (PartStack) data;
			PartPane selection = stack.getSelection();
			if (selection != null)
				return selection.getControl();
		}

		return null;
	}

	public CTabFolder getTabFolderFromButton(ToolItem button) {
		// TODO Restore button support
		return null;
	}

	public Text getQuickAccess() {
		// no quick access on e3
		return null;
	}

	public void updateActiveSelection(List<Object> selectionData,
			SWTUIElement parent) {
	}

	public String getViewId(Widget widget) {
		if (widget instanceof Composite)
			for (Listener l : widget.getListeners(SWT.Activate))
				if (l instanceof ViewPane)
					return ((ViewPane) l).getID();

		return null;
	}
}
