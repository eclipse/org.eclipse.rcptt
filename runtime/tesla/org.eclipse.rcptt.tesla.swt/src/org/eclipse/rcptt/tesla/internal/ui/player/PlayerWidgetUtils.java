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
package org.eclipse.rcptt.tesla.internal.ui.player;

import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrap;
import static org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils.unwrapWidget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.rcptt.tesla.swt.workbench.EclipseWorkbenchProvider;

public class PlayerWidgetUtils {

	public static boolean isVisible(Control control) {
		if (control == null) {
			return false;
		}
		return control.isVisible();
	}

	public static boolean canClick(SWTUIElement w) {
		if (unwrap(w) instanceof IWorkbenchPartReference) {
			if (!canClickView(w)) {
				return false;
			}
			return true;
		} else {
			boolean visible = true;
			Widget control = unwrapWidget(w);
			if (control instanceof Control) {
				visible = !control.isDisposed() && isVisible((Control) control);
			}

			return !isDisabled(w) && visible;
		}
	}

	public static boolean canClickView(SWTUIElement w) {
		if (w instanceof WorkbenchUIElement) {
			IWorkbenchPartReference reference = ((WorkbenchUIElement) w)
					.getReference();
			return EclipseWorkbenchProvider.getProvider().canClickView(
					reference);
		}
		return true;
	}

	public static boolean isDisabled(SWTUIElement uiElement) {
		// disabled, because unwrapWidget method already consider the case of
		// WorkbenchUIElement

		// if (uiElement instanceof WorkbenchUIElement) {
		// @SuppressWarnings("restriction")
		// Control control = ((WorkbenchPartReference) (((WorkbenchUIElement)
		// uiElement).reference))
		// .getPane().getControl();
		// return isDisabled(player.wrap(control), player);
		// }

		Widget w = unwrapWidget(uiElement);
		boolean result = false;
		if (w != null && w instanceof Control && !w.isDisposed()) {
			result = !((Control) w).isEnabled();
		} else if (w != null && w instanceof MenuItem) {
			result = !((MenuItem) w).isEnabled();
		} else if (w != null && w instanceof ToolItem) {
			result = !((ToolItem) w).isEnabled();
		}
		return result;
	}

	//

	public static Shell getModalChild(SWTUIElement control) {
		Widget w = unwrapWidget(control);
		if (w == null) {
			return null;
		}
		if (w.isDisposed()) {
			return null;
		}
		if (w instanceof ToolItem) {
			w = ((ToolItem) w).getParent();
		} else if (w instanceof MenuItem) {
			w = ((MenuItem) w).getParent();
		} else if (w instanceof TreeItem) {
			w = ((TreeItem) w).getParent();
		} else if (w instanceof TableItem) {
			w = ((TableItem) w).getParent();
		} else if (w instanceof CoolItem) {
			w = ((CoolItem) w).getParent();
		} else if (w instanceof CTabItem) {
			w = ((CTabItem) w).getParent();
		} else if (w instanceof ExpandItem) {
			w = ((ExpandItem) w).getParent();
		}

		if (w instanceof Control) {
			Shell shell = ((Control) w).getShell();
			Shell[] shells = shell.getShells();
			for (Shell shell2 : shells) {
				if (isModal(shell2)) {
					return shell2;
				}
			}
		}
		return null;
	}

	public static boolean isModal(Shell shell) {
		if (!shell.isVisible()) {
			return false;
		}
		int style = shell.getStyle();
		int mask = SWT.SYSTEM_MODAL | SWT.APPLICATION_MODAL | SWT.PRIMARY_MODAL
				| SWT.MODELESS;
		String text = shell.getText();
		if (text != null
				&& (text.trim().equalsIgnoreCase("problem occurred") || text
						.trim().equalsIgnoreCase("Operation failed"))) {
			return true;
		}
		return (style & mask) > 0;
	}

}
