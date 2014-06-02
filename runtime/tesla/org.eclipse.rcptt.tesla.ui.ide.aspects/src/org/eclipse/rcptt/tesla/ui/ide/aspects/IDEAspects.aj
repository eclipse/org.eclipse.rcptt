package org.eclipse.rcptt.tesla.ui.ide.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.ui.ide.events.UIIDEManager;

public aspect IDEAspects {
	public IDEAspects() {
		AspectManager.activateAspect(UIIDEAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(String location):
		execution(void org.eclipse.ui.internal.ide.actions.OpenWorkspaceAction.restart(String)) && args(location) {
		UIIDEManager.registerNewLocation(location);
	}
}
