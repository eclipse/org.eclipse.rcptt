package org.eclipse.rcptt.tesla.jface;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.text.reconciler.AbstractReconciler;
import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect TextReconcilerAspect {

	public TextReconcilerAspect() {
		AspectManager.activateAspect(
				TextReconcilerActivator.PLUGIN_ID, this.getClass()
						.getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(AbstractReconciler reconciler): execution(org.eclipse.jface.text.reconciler.AbstractReconciler.new(..)) && target(reconciler) {
		TextReconcilerManager.getInstance().newReconciler(reconciler);
	}
}
