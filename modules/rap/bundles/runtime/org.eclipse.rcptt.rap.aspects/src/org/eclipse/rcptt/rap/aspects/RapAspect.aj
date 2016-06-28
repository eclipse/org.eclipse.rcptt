package org.eclipse.rcptt.rap.aspects;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.internal.application.ApplicationContextImpl;
import org.eclipse.rap.rwt.internal.lifecycle.IUIThreadHolder;
import org.eclipse.rap.rwt.internal.serverpush.ServerPushServiceHandler;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.runtime.ui.rap.AutEventManager;
import org.eclipse.rcptt.runtime.ui.rap.Q7ServerStarter;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect RapAspect {
	public RapAspect() {
		AspectManager.activateAspect(RapAspectActivator.PLUGIN_ID, this.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(ApplicationContextImpl app):
		execution(void org.eclipse.rap.rwt.internal.application.ApplicationContextImpl.activate ()) && target(app) {
		if (app.allowsRequests()) {
			Q7ServerStarter.INSTANCE.start();
			// Send a started object
			AutEventManager.getInstance().sendStartup();
		} else {
			// log error
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(ApplicationContextImpl app):
		execution(void org.eclipse.rap.rwt.internal.application.ApplicationContextImpl.deactivate ()) && target(app) {

		ReportManager.storeState();
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(IUIThreadHolder holder):
		execution(void org.eclipse.rap.rwt.internal.lifecycle.IUIThreadHolder.terminateThread()) && target(holder) {

		TeslaEventManager.getManager().deactivatePushSession();
	}

	@SuppressWarnings("restriction")
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ServerPushServiceHandler handler, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse responce) throws IOException:
		execution(public void org.eclipse.rap.rwt.internal.serverpush.ServerPushServiceHandler.service(HttpServletRequest, HttpServletResponse) throws IOException)
		&& target(handler)
		&& args(request, responce) {
		if(RWT.getUISession() != null)
			return proceed(handler, request, responce);
		return null;
	}
}
