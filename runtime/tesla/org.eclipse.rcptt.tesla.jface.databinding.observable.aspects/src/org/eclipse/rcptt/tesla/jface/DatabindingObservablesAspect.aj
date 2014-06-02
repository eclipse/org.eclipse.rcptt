package org.eclipse.rcptt.tesla.jface;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.core.databinding.observable.Realm;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect DatabindingObservablesAspect {

	public DatabindingObservablesAspect() {
		AspectManager.activateAspect(
				DataBindingObservableasActivator.PLUGIN_ID, this.getClass()
						.getName());
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	before(Realm realm): execution(org.eclipse.core.databinding.observable.Realm.new(..)) && target(realm) {
		try {
			DatabindingObservableManager.getInstance().newRealm(realm);
		} catch (Throwable e) {
			DataBindingObservableasActivator.log(e);
		}
	}
}
