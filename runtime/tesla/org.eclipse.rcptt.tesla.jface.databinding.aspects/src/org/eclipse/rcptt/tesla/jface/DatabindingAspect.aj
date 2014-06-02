package org.eclipse.rcptt.tesla.jface;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect DatabindingAspect {

	public DatabindingAspect() {
		AspectManager.activateAspect(DataBindingAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(int delay, Runnable runnable):
		execution(void org.eclipse.jface.databinding.swt.SWTObservables.DisplayRealm.timerExec(int, Runnable)) && args(delay, runnable) {
		if (TeslaEventManager.getManager().hasListeners()) {
			return proceed(0, runnable);
		}
		return proceed(delay, runnable);
	}
}
