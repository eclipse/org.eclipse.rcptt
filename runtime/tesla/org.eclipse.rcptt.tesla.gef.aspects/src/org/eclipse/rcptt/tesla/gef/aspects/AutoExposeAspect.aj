package org.eclipse.rcptt.tesla.gef.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.gef.editparts.ViewportAutoexposeHelper;
import org.eclipse.gef.tools.TargetingTool;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.gef.AutoExpandLevels;
import org.eclipse.rcptt.tesla.gef.GefAspectsActivator;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect AutoExposeAspect {
	public AutoExposeAspect() {
		AspectManager.activateAspect(GefAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(TargetingTool tool):
		execution(void org.eclipse.gef.tools.TargetingTool.doAutoexpose()) && target(tool) {
		if (TeslaEventManager.getManager().hasListeners()) {
			// Do not allow auto expose
			if (!AutoExpandLevels.check(tool)) {
				return null;
			}
		}
		return proceed(tool);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ViewportAutoexposeHelper helper):
		execution(boolean org.eclipse.gef.editparts.ViewportAutoexposeHelper.step(org.eclipse.draw2d.geometry.Point)) && target(helper) {
		if (TeslaEventManager.getManager().hasListeners()) {
			// Do not allow auto expose
			if (!AutoExpandLevels.check(helper)) {
				return Boolean.FALSE;
			}
		}
		return proceed(helper);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(TargetingTool tool): execution( void org.eclipse.gef.tools.TargetingTool.deactivate()) && target(tool) {
		AutoExpandLevels.clear(tool);
	}
}
