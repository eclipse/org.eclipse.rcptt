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
package org.eclipse.rcptt.util.swt;

import org.eclipse.rcptt.util.ShellUtils;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("restriction")
public class ShellUtilsImpl implements ShellUtils {
	
	//On windows there is no way to make a window foreground by convetional means
	//It just blinks in tray, but may be hidden behide another window.
	//http://jira4.xored.com/browse/QS-3205
	//https://bugs.eclipse.org/bugs/show_bug.cgi?id=192036#c4
	@Override
	public void forceActive(Object sh) {
		Shell shell = (Shell)sh;

	    long hFrom = OS.GetForegroundWindow();


	    if (shell.handle == hFrom) {
	      return;
	    }

	    if (hFrom <= 0) {
	    	OS.SetForegroundWindow(shell.handle);
	    	return;
	    }

	    int pid = OS.GetWindowThreadProcessId(hFrom, null);
	    int _threadid = OS.GetWindowThreadProcessId(shell.handle, null);

	    if (_threadid == pid) {
	      OS.SetForegroundWindow(shell.handle);
	      return;
	    }


	    OS.BringWindowToTop(shell.handle);
	    OS.UpdateWindow(shell.handle);
	    OS.SetActiveWindow(shell.handle);
	  }
	
}
