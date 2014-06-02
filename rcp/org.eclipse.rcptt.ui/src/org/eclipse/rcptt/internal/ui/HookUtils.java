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
package org.eclipse.rcptt.internal.ui;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Section;

public class HookUtils {
	public static void textHook(Composite composite, final Runnable r) {
		FocusListener focusListener = new FocusListener() {
			public void focusGained(FocusEvent e) {
				r.run();
			}

			public void focusLost(FocusEvent e) {
				r.run();
			}
		};
		textHook(composite, r, focusListener);
	}

	public static void textHook(Composite composite, final Runnable r, FocusListener focusListener) {
		KeyAdapter keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				r.run();
			}
		};
		SelectionAdapter selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				r.run();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				r.run();
			}
		};
		ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				r.run();
			}
		};

		for (Control child : composite.getChildren()) {
			hookControl(r, focusListener, keyListener, selectionListener, modifyListener, child);
		}
	}

	private static void hookControl(final Runnable r, FocusListener focusListener, KeyAdapter keyListener,
			SelectionAdapter selectionListener, ModifyListener modifyListener, Control child) {
		if (child instanceof Text) {
			child.addFocusListener(focusListener);
			child.addKeyListener(keyListener);
			((Text) child).addSelectionListener(selectionListener);
			((Text) child).addModifyListener(modifyListener);
		}
		if (child instanceof StyledText) {
			child.addFocusListener(focusListener);
			((StyledText) child).addModifyListener(modifyListener);
			child.addKeyListener(keyListener);
			((StyledText) child).addSelectionListener(selectionListener);
		}
		if (child instanceof Table) {
			Table table = (Table) child;
			table.addFocusListener(focusListener);
			table.addSelectionListener(selectionListener);
			table.addKeyListener(keyListener);
		}
		else if (child instanceof Tree) {
			Tree tree = (Tree) child;
			tree.addFocusListener(focusListener);
			tree.addSelectionListener(selectionListener);
			tree.addKeyListener(keyListener);
		}
		else if (child instanceof Section) {
			Section s = (Section) child;
			Control descr = s.getDescriptionControl();
			if (descr != null) {
				hookControl(r, focusListener, keyListener, selectionListener, modifyListener, descr);
			}
			Control textClient = s.getTextClient();
			if (textClient != null) {
				hookControl(r, focusListener, keyListener, selectionListener, modifyListener, textClient);
			}
			textHook(s, r, focusListener);
		}
		else if (child instanceof ToolBar) {
			ToolBar toolbar = (ToolBar) child;
			ToolItem[] items = toolbar.getItems();
			for (ToolItem toolItem : items) {
				toolItem.addSelectionListener(selectionListener);
			}
		}
		else if (child instanceof Composite) {
			textHook((Composite) child, r, focusListener);
		}
	}
}
