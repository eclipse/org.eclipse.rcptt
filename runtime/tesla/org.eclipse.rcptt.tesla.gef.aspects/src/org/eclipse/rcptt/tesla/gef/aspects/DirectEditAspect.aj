package org.eclipse.rcptt.tesla.gef.aspects;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gef.ui.parts.ContentOutlinePage;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.gef.GefAspectsActivator;
import org.eclipse.rcptt.tesla.gef.TeslaDirectEditManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect DirectEditAspect {
	public DirectEditAspect() {
		AspectManager.activateAspect(GefAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(DirectEditManager manager): execution(void DirectEditManager.show ()) && target(manager) {
		try {
			TeslaDirectEditManager.getInstance().addManager(manager);
		} catch (Throwable e) {
			GefAspectsActivator.log(e);
		}
	}

	private Set<Object> nonHooked = new HashSet<Object>();

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(DirectEditManager manager): execution(void DirectEditManager.bringDown ()) && target(manager) {
		if (TeslaEventManager.getManager().hasListeners()
				&& TeslaDirectEditManager.getInstance().removeManager(manager)) {
			return proceed(manager);
		}
		if (!TeslaEventManager.getManager().hasListeners()) {
			return proceed(manager);
		}
		return null;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(EditDomain domain, FocusEvent e, EditPartViewer viewer): execution(void org.eclipse.gef.EditDomain.focusLost(FocusEvent, EditPartViewer)) && target(domain) && args(e,viewer) {
		if (TeslaEventManager.getManager().hasListeners()) {
			// Disable focus lost event on replay
			return null;
		}
		return proceed(domain, e, viewer);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Object helper): execution(void org.eclipse.gef.tools.DelayedDirectEditHelper.run()) && target(helper) {
		if (TeslaEventManager.getManager().hasListeners()) {
			// Disable delayed direct edit because we handle it in scenarios.
			nonHooked.add(helper);
			return null;
		}
		try {
			Field declaredField = helper.getClass().getDeclaredField("focus");
			declaredField.setAccessible(true);
			Object value = declaredField.get(helper);
			if (value == null) {
				return null;
			}
		} catch (Throwable e) {
		}
		return proceed(helper);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Object helper): execution(void org.eclipse.gef.tools.DelayedDirectEditHelper.hookControl(org.eclipse.swt.widgets.Control)) && target(helper) {
		if (nonHooked.contains(helper)) {
			nonHooked.remove(helper);
			return null;
		}
		if (TeslaEventManager.getManager().hasListeners()) {
			// Disable delayed direct edit because we handle it in scenarios.
			return null;
		}
		return proceed(helper);
	}

	// Content outline fix
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ContentOutlinePage page): execution(void org.eclipse.gef.ui.parts.ContentOutlinePage.setFocus()) && target(page) {
		if (page.getControl() == null || page.getControl().isDisposed()) {
			return null;
		}
		return proceed(page);
	}
}
