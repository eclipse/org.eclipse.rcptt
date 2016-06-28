package org.eclipse.rcptt.tesla.ui.ide.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.ui.ide.events.UIIDEManager;

public aspect IDEAspects {
	public IDEAspects() {
		AspectManager.activateAspect(UIIDEAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(String location):
		execution(void org.eclipse.rap.ui.internal.ide.actions.OpenWorkspaceAction.restart(String)) && args(location) {
		UIIDEManager.registerNewLocation(location);
	}
}
