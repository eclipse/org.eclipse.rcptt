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
package org.eclipse.rcptt.tesla.swt.properties;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.IPageSite;

public class EmptyPageSite implements IPageSite {
	private Shell shell;
	private IWorkbenchWindow window;

	public EmptyPageSite(Shell shell, IWorkbenchWindow window) {
		this.shell = shell;
		this.window = window;
	}

	public IActionBars getActionBars() {
		return null;
	}

	public void registerContextMenu(String menuId, MenuManager menuManager,
			ISelectionProvider selectionProvider) {
	}

	public IWorkbenchPage getPage() {
		return window.getActivePage();
	}

	public ISelectionProvider getSelectionProvider() {
		return null;
	}

	public Shell getShell() {
		return shell;
	}

	public IWorkbenchWindow getWorkbenchWindow() {
		return window;
	}

	public void setSelectionProvider(ISelectionProvider provider) {
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Object getService(Class api) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public boolean hasService(Class api) {
		return false;
	}

}
