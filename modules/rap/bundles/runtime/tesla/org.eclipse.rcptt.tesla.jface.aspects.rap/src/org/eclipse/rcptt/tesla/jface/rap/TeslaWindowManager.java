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
package org.eclipse.rcptt.tesla.jface.rap;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

public class TeslaWindowManager {

	private TeslaWindowManager() { }
	
	private static TeslaWindowManager instance;
	public static TeslaWindowManager getInstance() {
		if (instance == null) {
			instance = new TeslaWindowManager();
		}
		return instance;
	}
	
	//
	

	/* Now we are storing only class names here.
	 * If we'll need some other data in the future, we should probably use
	 * some tiny structure filling from the Window instance.
	 */
	private Map<Shell, String> shellWindowClassNames = new WeakHashMap<Shell,
			String>();
	
	public void setWindowForShell(Shell shell, Window win) {
		shellWindowClassNames.put(shell, win.getClass().getSimpleName());
	}
	
	public String getWindowClassNameByShell(Shell shell) {
		return shellWindowClassNames.get(shell);
	}
	
}
