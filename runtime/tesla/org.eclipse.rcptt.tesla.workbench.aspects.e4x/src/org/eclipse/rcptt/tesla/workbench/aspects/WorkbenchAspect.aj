package org.eclipse.rcptt.tesla.workbench.aspects;

import java.util.WeakHashMap;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBook.PageBookLayout;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect WorkbenchAspect {
	public WorkbenchAspect() {
		AspectManager.activateAspect(WorkbenchAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	Object around(WorkbenchStatusDialogManager mgr, StatusAdapter adapter,
			boolean modal):
		execution(void org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager.addStatusAdapter(StatusAdapter, boolean))
		&& target(mgr) && args(adapter, modal) {
		if (!TeslaEventManager.getManager().hasListeners()) {
			return proceed(mgr, adapter, modal);
		} else if (TeslaEventManager.getManager().isStatusDialogModeAllowed()) {
			return proceed(mgr, adapter, modal);
		}

		return null;
	}

	Object around(PageBookLayout layout, Composite ctrl, boolean flushCache):
		execution(void org.eclipse.ui.part.PageBook.PageBookLayout.layout(Composite, boolean)) && target(layout) && args(ctrl,flushCache) {
		try {
			Object object = TeslaSWTAccess.getThis(layout);
			if (object != null) {
				PageBook book = (PageBook) object;
				Control page = TeslaSWTAccess.getBookPage(book);
				if (page != null && page.isDisposed()) {
					return null; // Ignore layout if page is disposed.
				}
			}
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}

		return proceed(layout, ctrl, flushCache);
	}

	WeakHashMap<Integer, Widget> lastWidgets = new WeakHashMap<Integer, Widget>();

	before(Event event):
		execution(void org.eclipse.ui.internal.keys.WorkbenchKeyboard.filterKeySequenceBindings(Event)) && args(event) {
		try {
			lastWidgets.put(event.time, event.widget);
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
	}

	after(Event event):
		execution(void org.eclipse.ui.internal.keys.WorkbenchKeyboard.filterKeySequenceBindings(Event)) && args(event) {
		try {
			lastWidgets.remove(event.time);
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
	}

	after(org.eclipse.ui.internal.keys.WorkbenchKeyboard wk,
			java.util.List potentialKeyStrokes,
			org.eclipse.swt.widgets.Event event) returning (boolean result):
				execution(boolean org.eclipse.ui.internal.keys.WorkbenchKeyboard.press(java.util.List, org.eclipse.swt.widgets.Event)) && target(wk) && args(potentialKeyStrokes, event) {
		SWTUIPlayer.lastWorkbenchKeyboardPressResult = result;
	}
}
