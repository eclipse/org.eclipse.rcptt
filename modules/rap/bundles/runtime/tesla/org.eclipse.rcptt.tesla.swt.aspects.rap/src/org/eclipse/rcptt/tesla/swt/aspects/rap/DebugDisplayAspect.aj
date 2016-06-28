package org.eclipse.rcptt.tesla.swt.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;

public aspect DebugDisplayAspect {
	public DebugDisplayAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
		logStackTrace("DebugDisplayAspect activated");
	}

	public static void logStackTrace(String message) {
		Exception e = new RuntimeException(message);
		SWTAspectActivator.getDefault().getLog().log(new Status(IStatus.INFO, SWTAspectActivator.PLUGIN_ID, message, e));
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Display display): execution(void Display.register(Display)) && args(display) {
		// Runnable called
		try {
			logStackTrace("Display register called. This is not an error.");
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Display display): execution(void Display.unregister(Display)) && args(display) {
		// Runnable called
		try {
			logStackTrace("Display unregister called. This is not an error.");
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Display display): execution(void Display.deregister(Display)) && args(display) {
		// Runnable called
		try {
			logStackTrace("Display deregister called. This is not an error.");
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

//	@SuppressAjWarnings("adviceDidNotMatch")
//	before(Device device): execution(void Device.dispose()) && this(device) {
//		try {
//		logStackTrace("Device is disposed. This is not an error.");
//		} catch (Throwable e) {
//			SWTAspectActivator.log(e);
//		}
//	}
}
