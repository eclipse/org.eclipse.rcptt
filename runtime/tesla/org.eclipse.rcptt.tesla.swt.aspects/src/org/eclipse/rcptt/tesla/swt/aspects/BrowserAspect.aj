package org.eclipse.rcptt.tesla.swt.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaBrowserManager;

/**
 * Aspect to support web browser functionality
 * 
 * @author haiodo
 * 
 */
public aspect BrowserAspect {
	public BrowserAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.browser.Browser browser): execution(org.eclipse.swt.browser.Browser.new(..)) && target(browser) {
		try {
			TeslaBrowserManager.getManager().addBrowser(browser);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.browser.Browser browser): execution(boolean org.eclipse.swt.browser.Browser.setText(String)) && target(browser) {
		try {
			TeslaBrowserManager.getManager().browserSetText(browser);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(org.eclipse.swt.browser.Browser browser): execution(boolean org.eclipse.swt.browser.Browser.setUrl(..)) && target(browser) {
		try {
			TeslaBrowserManager.getManager().beginChanging(browser);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}
}
