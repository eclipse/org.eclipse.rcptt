package org.eclipse.rcptt.tesla.swt.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.swt.dnd.DNDManager;

public aspect DNDAspect {
	public DNDAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(DropTarget target): execution(new(..)) && target(target) {
		try {
			DNDManager.getInstance().addTarget(target);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(DragSource source): execution(new(..)) && target(source) {
		try {
			DNDManager.getInstance().addSource(source);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}
}
