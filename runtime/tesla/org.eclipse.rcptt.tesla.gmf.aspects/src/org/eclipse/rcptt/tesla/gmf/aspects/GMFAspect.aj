package org.eclipse.rcptt.tesla.gmf.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect GMFAspect {
	public GMFAspect() {
		AspectManager.activateAspect(GMFAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	// Object around(DiagramAssistantEditPolicy policy, boolean value):
	// execution(void
	// org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy.setAvoidHidingDiagramAssistant(boolean))
	// && target(policy) && args(value) {
	// if (TeslaEventManager.getManager().hasListeners()) {
	// return proceed(policy, true);
	// }
	// return proceed(policy, value);
	// }

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(DiagramAssistantEditPolicy policy, int value):
		execution(void org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy.showDiagramAssistantAfterDelay(int)) 
		&& target(policy) && args(value) {
		if (TeslaEventManager.getManager().hasListeners()) {
			return null; // Disable showing using jobs if some listeners are
			// registered
			// return proceed(policy, 0);
		}
		return proceed(policy, value);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(DiagramAssistantEditPolicy policy, int value):
		execution(void org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy.hideDiagramAssistantAfterDelay(int)) 
		&& target(policy) && args(value) {
		if (TeslaEventManager.getManager().hasListeners()) {
			// return proceed(policy, 10000); // ten seconds
			return null;// Disable hiding using jobs.
		}
		return proceed(policy, value);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ConnectionHandleEditPolicy policy):
		execution(void org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy.hideDiagramAssistant()) && target(policy) {
		try {
			if (TeslaEventManager.getManager().hasListeners()) {
				Context context = ContextManagement.currentContext();
				if (!context.containsClass("org.eclipse.rcptt.tesla.gmf.GMFProcessor")) {
					return null;
				}
			}
		} catch (Throwable e) {
			GMFAspectsActivator.log(e);
		}
		return proceed(policy);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(PopupBarEditPolicy policy):
		execution(void org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy.hideDiagramAssistant()) && target(policy) {
		try {
			if (TeslaEventManager.getManager().hasListeners()) {
				Context context = ContextManagement.currentContext();
				if (!context.containsClass("org.eclipse.rcptt.tesla.gmf.GMFProcessor")) {
					return null;
				}
			}
		} catch (Throwable e) {
			GMFAspectsActivator.log(e);
		}
		return proceed(policy);
	}

}
