/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ui;

import org.eclipse.core.commands.contexts.ContextManager;
import org.eclipse.rap.rwt.internal.service.ContextProvider;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

public class RWTUtils {

	public static Display findDisplay() {
		Display display = TeslaEventManager.getManager().getDisplay();
		return display == null || display.isDisposed() ? null : display;
	}

	public static IWorkbench getWorkbench() {
		IWorkbench workbench = (IWorkbench) TeslaEventManager.getManager().getWorkbench();
		return workbench == null || !ContextProvider.hasContext() || workbench.isClosing() ? null : workbench;
	}

	public static IWorkbenchWindow[] getWorkbenchWindows() {
		return getWorkbench() == null ? new IWorkbenchWindow[0] : getWorkbench().getWorkbenchWindows();
	}

	public static IWorkbench getWorkbenchNotSafe(){
		return (IWorkbench) TeslaEventManager.getManager().getWorkbench();
	}

	public static boolean isValidThread(Widget widget)
	{
		return widget != null && widget.getDisplay().getThread() == Thread.currentThread();
	}


	public interface IChangeWorkbench
	{
		void change(IWorkbench workbench);
	}

}
