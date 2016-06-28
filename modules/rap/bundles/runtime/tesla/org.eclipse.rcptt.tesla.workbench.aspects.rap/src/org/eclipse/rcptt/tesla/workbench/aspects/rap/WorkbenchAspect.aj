package org.eclipse.rcptt.tesla.workbench.aspects.rap;

import java.util.WeakHashMap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBook.PageBookLayout;
import org.eclipse.ui.presentations.IStackPresentationSite;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.SWTEventManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;


@SuppressWarnings("all")
public aspect WorkbenchAspect {
	public WorkbenchAspect() {
		AspectManager.activateAspect(WorkbenchAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Workbench wb):
		execution(int org.eclipse.ui.internal.Workbench.runUI()) && target(wb) {
		TeslaEventManager.getManager().setLastWorkbench(wb);
		if (wb != null) {
			TeslaEventManager.getManager().setLastDisplay(wb.getDisplay());
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
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

	/*
	@SuppressAjWarnings("adviceDidNotMatch")
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
	*/

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(org.eclipse.ui.internal.PageLayout layout, String partId):
		execution(boolean org.eclipse.ui.internal.PageLayout.checkPartInLayout(String)) &&target(layout) && args(partId) {
		try {
			if (TeslaEventManager.getManager().hasListeners()) {
				try {
					Object refPart = TeslaSWTAccess.callMethod(
							org.eclipse.ui.internal.PageLayout.class, layout,
							"getRefPart", partId);
					if (refPart != null) {
						return true;
					}
					Boolean fastView = (Boolean) TeslaSWTAccess.callMethod(
							org.eclipse.ui.internal.PageLayout.class, layout,
							"isFastViewId", partId);

					if (fastView) {
						return true;
					}
					return false;
				} catch (Throwable e) {
					WorkbenchAspectActivator.log(e);
				}
			}
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
		return proceed(layout, partId);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(org.eclipse.ui.internal.presentations.PaneFolder paneFolder,
			int buttonId): execution(void org.eclipse.ui.internal.presentations.PaneFolder.notifyButtonListeners(int)) && target(paneFolder) && args(buttonId) {
		try {
			int eventId = -1;
			if (buttonId == IStackPresentationSite.STATE_MINIMIZED) {
				eventId = SWTEventManager.EVENT_TAB_MINIMIZE;
			} else if (buttonId == IStackPresentationSite.STATE_MAXIMIZED) {
				eventId = SWTEventManager.EVENT_TAB_MAXIMIZE;
			} else if (buttonId == IStackPresentationSite.STATE_RESTORED) {
				eventId = SWTEventManager.EVENT_TAB_RESTORE;
			}
			if (eventId != -1) {
				SWTEventManager.recordTabFolderEvent(paneFolder.getControl(),
						eventId);
			}
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(org.eclipse.ui.internal.presentations.PaneFolder paneFolder,
			CTabFolderEvent event): execution(void org.eclipse.ui.internal.presentations.PaneFolder.notifyShowListeners(CTabFolderEvent)) && target(paneFolder) && args(event) {
		try {
			SWTEventManager.recordTabFolderEvent(paneFolder.getControl(),
					SWTEventManager.EVENT_TAB_SHOW_LIST);
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
	}

//	@SuppressAjWarnings("adviceDidNotMatch")
//	boolean around(OutOfOrderListener listener, int time):
//		execution(boolean org.eclipse.ui.internal.keys.OutOfOrderListener.isActive(int)) && target(listener) && args(time) {
//		if (TeslaEventManager.getManager().hasListeners()) {
//			try {
//				if (lastWidgets.containsKey(time)) {
//					Listener[] listeners = lastWidgets.get(time).getListeners(
//							SWT.KeyDown);
//					boolean returnFalse = false;
//					if (listeners != null) {
//						for (Listener l : listeners) {
//							if (l instanceof OutOfOrderListener) {
//								returnFalse = true;
//								break;
//							}
//						}
//					}
//					// Return true if listener required to be added and false
//					// overwize.
//					return returnFalse;
//				}
//			} catch (Throwable e) {
//				WorkbenchAspectActivator.log(e);
//			}
//		}
//		return proceed(listener, time);
//	}

	WeakHashMap<Integer, Widget> lastWidgets = new WeakHashMap<Integer, Widget>();

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Event event):
		execution(void org.eclipse.ui.internal.keys.WorkbenchKeyboard.filterKeySequenceBindings(Event)) && args(event) {
		try {
			lastWidgets.put(event.time, event.widget);
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Event event):
		execution(void org.eclipse.ui.internal.keys.WorkbenchKeyboard.filterKeySequenceBindings(Event)) && args(event) {
		try {
			lastWidgets.remove(event.time);
		} catch (Throwable e) {
			WorkbenchAspectActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.ui.internal.keys.WorkbenchKeyboard wk,
			@SuppressWarnings("rawtypes") java.util.List potentialKeyStrokes,
			org.eclipse.swt.widgets.Event event) returning (boolean result):
				execution(boolean org.eclipse.ui.internal.keys.WorkbenchKeyboard.press(java.util.List, org.eclipse.swt.widgets.Event)) && target(wk) && args(potentialKeyStrokes, event) {
		SWTUIPlayer.lastWorkbenchKeyboardPressResult = result;
	}
}
