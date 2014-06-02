package org.eclipse.rcptt.tesla.jface;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect WindowAspect {

	public WindowAspect() {
		AspectManager.activateAspect(JFaceAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}
	
	
	// relate Window instances with their Shell instances
	@SuppressAjWarnings("adviceDidNotMatch")
	after(Window window) returning (Shell shell): execution(Shell Window.createShell ()) && target(window) {
		TeslaWindowManager.getInstance().setWindowForShell(shell, window);
	}
	
}
