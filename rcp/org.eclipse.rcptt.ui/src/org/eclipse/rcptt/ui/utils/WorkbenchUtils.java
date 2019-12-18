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
package org.eclipse.rcptt.ui.utils;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class WorkbenchUtils {

	public static Shell getShell() {
		IWorkbenchWindow wbw = getWindow();
		if (wbw == null)
			return null;
		return wbw.getShell();
	}

	public static IWorkbenchPage getPage() {
		IWorkbenchWindow ww = getWindow();
		return ww == null ? null : ww.getActivePage();
	}

	public static IWorkbenchWindow getWindow() {
		IWorkbench wb = getWorkbench();
		return wb == null ? null : wb.getActiveWorkbenchWindow();
	}

	public static IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}

	public static Display getDisplay() {
		return getWorkbench().getDisplay();
	}

	public static void uiRun(final Runnable runnable) {
		uiRun(null, runnable);
	}

	public static void uiRun(final Control control, final Runnable runnable) {
		if (control != null && control.isDisposed()) {
			return;
		}
		Display display = control == null ? getDisplay() : control.getDisplay();
		if (!display.isDisposed()) {
			if (display.getThread() == Thread.currentThread()) {
				runnable.run();
			} else {
				display.asyncExec(new Runnable() {
					public void run() {
						if (control == null || !control.isDisposed()) {
							runnable.run();
						}
					}
				});
			}
		}
	}

}
