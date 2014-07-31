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
package org.eclipse.rcptt.internal.runtime.ui;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.swt.dialogs.SWTDialogManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class Utils {

	public static void closeDialogs() {
		doCloseDialogs();
	}

	private static boolean doCloseDialogs() {
		SWTDialogManager.setCancelMessageBoxesDisplay(true);
		try {
			boolean closed = false;
			final IWorkbench workbench = PlatformUI.getWorkbench();
			final Display display = workbench.getDisplay();

			// Dummy call for E4, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=440850
			workbench.getActiveWorkbenchWindow();

			IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
			Set<Shell> windowShells = new HashSet<Shell>();
			for (IWorkbenchWindow window : windows) {
				Shell shell = window.getShell();
				if (shell != null) {
					windowShells.add(shell);
				}
			}
			// Close all shells for non workbench display
			Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
			for (Thread t : map.keySet()) {
				final Display dd = Display.findDisplay(t);
				if (dd != null && !dd.equals(display)) {
					t.interrupt();
				}
			}

			Shell[] shells = display.getShells();
			for (int i = shells.length - 1; i >= 0; i--) {
				Shell shell = shells[i];
				if (!windowShells.contains(shell) && !shell.isDisposed()
						&& shell.isVisible()) {
					Object data = shell.getData();
					if (data != null && data instanceof WizardDialog) {
						try {
							WizardDialog dialog = (WizardDialog) data;
							if (TeslaSWTAccess
									.getWizardDialogHasActiveOperations(dialog)) {
								// try to cancel active operations
								ProgressMonitorPart part = TeslaSWTAccess
										.getProgressMonitorPart(dialog);
								if (part != null) {
									part.setCanceled(true);
									part.clearBlocked();
								}
							}
							TeslaSWTAccess.setWizardDialogHasActiveOperations(
									dialog, 0);
							dialog.close();
							// try to cancel monitor if there is one
						} catch (Throwable e) {
							TeslaCore.log(e);
						}
					} else {
						shell.close();
					}
					closed = true;
				}
			}
			return closed;
		} finally {
			SWTDialogManager.setCancelMessageBoxesDisplay(false);
		}
	}
}
