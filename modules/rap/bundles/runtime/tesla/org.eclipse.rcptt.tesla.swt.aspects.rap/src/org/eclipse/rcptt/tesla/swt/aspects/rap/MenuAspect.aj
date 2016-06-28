package org.eclipse.rcptt.tesla.swt.aspects.rap;

import java.lang.ref.WeakReference;
import java.util.List;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect MenuAspect {
	public MenuAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Menu menu, boolean value): 
		execution(void org.eclipse.swt.widgets.Menu.setVisible(boolean)) && target(menu) && args(value) {
		Object result = Boolean.FALSE;
		if (TeslaEventManager.getManager().isIgnoreMenuShow()) {
			return result;
		}
		boolean proceedMenu = false;
		try {
			proceedMenu = TeslaEventManager.getManager().proceedMenu(menu,
					value);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		if (!proceedMenu) {
			result = proceed(menu, value);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Menu menu): 
		execution(boolean org.eclipse.swt.widgets.Menu.getVisible()) && target(menu) {
		try {
			List<WeakReference<Menu>> menus = TeslaEventManager.getManager()
					.getPopupMenus();
			boolean contains = false;
			for (WeakReference<Menu> weakReference : menus) {
				Menu val = weakReference.get();
				if (val != null && val.equals(menu)) {
					contains = true;
				}
			}
			if (contains) {
				return true;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(menu);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Menu menu,
			org.eclipse.swt.widgets.Control parent): execution(org.eclipse.swt.widgets.Menu.new(org.eclipse.swt.widgets.Control)) && target(menu) && args(parent) {
		try {
			TeslaEventManager.getManager().addMenuControl(menu, parent);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Menu menu,
			org.eclipse.swt.widgets.Decorations parent): execution(org.eclipse.swt.widgets.Menu.new(org.eclipse.swt.widgets.Decorations,int)) && target(menu) && args(parent) {
		try {
			TeslaEventManager.getManager().addMenuControl(menu, parent);
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}
}
