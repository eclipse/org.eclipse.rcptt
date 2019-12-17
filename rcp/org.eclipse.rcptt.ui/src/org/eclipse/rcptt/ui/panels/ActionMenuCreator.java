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
package org.eclipse.rcptt.ui.panels;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

public class ActionMenuCreator implements IMenuCreator {
	private MenuManager manager;

	private void createMenuManager() {
		if (manager == null) {
			manager = new MenuManager();
			fill(manager);
		}
	}

	protected void fill(MenuManager manager) {

	}

	public Menu getMenu(Control parent) {
		createMenuManager();
		return manager.createContextMenu(parent);
	}

	public Menu getMenu(Menu parent) {
		createMenuManager();
		final Menu menu = new Menu(parent);
		IContributionItem[] items = manager.getItems();
		for (IContributionItem item : items) {
			IContributionItem newItem = item;
			if (item instanceof ActionContributionItem) {
				newItem = new ActionContributionItem(
						((ActionContributionItem) item).getAction());
			}
			newItem.fill(menu, -1);
		}
		return menu;
	}

	public void dispose() {
		if (manager != null) {
			manager.dispose();
			manager = null;
		}
	}
}