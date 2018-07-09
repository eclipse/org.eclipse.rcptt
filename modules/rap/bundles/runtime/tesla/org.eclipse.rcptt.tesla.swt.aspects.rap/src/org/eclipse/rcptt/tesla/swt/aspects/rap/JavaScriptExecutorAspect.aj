package org.eclipse.rcptt.tesla.swt.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.rap.rwt.internal.client.JavaScriptExecutorImpl;
import org.eclipse.rcptt.tesla.swt.js.JavaScriptExecutionManager;

public aspect JavaScriptExecutorAspect {

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(JavaScriptExecutorImpl executor, String code) :
		execution(public void org.eclipse.rap.rwt.internal.client.JavaScriptExecutorImpl.execute(String))
		&& target(executor)
		&& args(code){

		if (JavaScriptExecutionManager.getManager().isActive()) {
			return proceed(executor, code);
		}
		return null;
	}
}
