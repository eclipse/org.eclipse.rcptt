package org.eclipse.rcptt.tesla.recording.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import org.eclipse.rcptt.tesla.core.am.AspectManager;


public privileged aspect UIIDERecordingAspect {

	public UIIDERecordingAspect() {
		AspectManager.activateAspect(UIIDEWorkbenchActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(String location):
		execution(void org.eclipse.ui.internal.ide.actions.OpenWorkspaceAction.restart(String)) && args(location) {
		UIIDEEventManager.restartEclipse();
	}
}
