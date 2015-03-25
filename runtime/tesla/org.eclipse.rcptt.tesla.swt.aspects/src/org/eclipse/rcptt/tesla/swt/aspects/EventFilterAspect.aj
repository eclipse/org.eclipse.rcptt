package org.eclipse.rcptt.tesla.swt.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect EventFilterAspect {
	public EventFilterAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(): 
	 	execution(* *windowProc(..)) {
		if (!TeslaEventManager.getManager().isFiltering()) {
			return proceed();
		}
		try {
			if (Platform.getWS().equals(Platform.WS_GTK)) {
				if (TeslaEventManager.getManager().hasListeners()) {
					Object[] args = thisJoinPoint.getArgs();
					Object arg = args[args.length - 1];
					if (arg instanceof Integer) {
						int userData = ((Integer) arg).intValue();
						switch (userData) {
						case GTK.BUTTON_PRESS_EVENT:
						case GTK.BUTTON_RELEASE_EVENT:
						case GTK.BUTTON_PRESS_EVENT_INVERSE:
						case GTK.BUTTON_RELEASE_EVENT_INVERSE:
						case GTK.KEY_PRESS_EVENT:
						case GTK.KEY_RELEASE_EVENT:
						case GTK.CLICKED:
						case GTK.MOTION_NOTIFY_EVENT:
						case GTK.CHANGED:
						case GTK.DELETE_TEXT:
						case GTK.INPUT:
						case GTK.INSERT_TEXT:
						case GTK.CHANGE_VALUE:
						case GTK.SELECT:
						case GTK.MOTION_NOTIFY_EVENT_INVERSE:
						case GTK.EVENT_AFTER:
							// case GTK.EVENT:
							// case GTK.EXPOSE_EVENT:
						case GTK.LEAVE_NOTIFY_EVENT:
							// case GTK.EXPOSE_EVENT_INVERSE:
						case GTK.ENTER_NOTIFY_EVENT:
						case GTK.MAP:
						case GTK.MAP_EVENT:
							return 0;
						}
					}
				}
			}
			if (Platform.getWS().equals(Platform.WS_WIN32)) {
				if (TeslaEventManager.getManager().hasListeners()) {
					Object[] args = thisJoinPoint.getArgs();
					if (args.length == 4) {
						if (args[1] instanceof Integer) {
							int value = ((Integer) args[1]).intValue();
							switch (value) {
							case WinOS.WM_MOUSEMOVE:
							case WinOS.WM_LBUTTONUP:
							case WinOS.WM_LBUTTONDOWN:
							case WinOS.WM_KEYDOWN:
							case WinOS.WM_KEYUP:
							case WinOS.WM_MOUSEHOVER:
							case WinOS.WM_RBUTTONDOWN:
							case WinOS.WM_RBUTTONUP:
							case WinOS.WM_MBUTTONUP:
							case WinOS.WM_MBUTTONDOWN:
							case WinOS.WM_MBUTTONDBLCLK:
							case WinOS.WM_LBUTTONDBLCLK:
							case WinOS.WM_RBUTTONDBLCLK:
								// case WinOS.WM_ACTIVATE:
							case WinOS.WM_COPY:
							case WinOS.WM_PASTE:
							case WinOS.WM_CUT:
							case WinOS.WM_MENUSELECT:
							case WinOS.WM_HOTKEY:
							case WinOS.WM_CHAR:
							case WinOS.WM_IME_CHAR:
							case WinOS.WM_HSCROLL:
							case WinOS.WM_VSCROLL:
							case WinOS.WM_SETFOCUS:
								// It was commented out for some reason, but now the problem of double invoke
								// occurred because of this. Bug 462813
							case WinOS.WM_KILLFOCUS:
							case WinOS.WM_SETCURSOR:
								// case WinOS.WM_ACTIVATEAPP:
							case WinOS.WM_NCHITTEST:
							case WinOS.WM_NCLBUTTONDOWN:
								// case WinOS.WM_NCACTIVATE:
								// System.out.println("Filtered:" + new
								// WinOS.RecordedEvent(value).toString());
								return 0;
							}
						}
					}
				}
			}
			if (Platform.getOS().equals(Platform.OS_MACOSX)) {
				Object[] args = thisJoinPoint.getArgs();
				if (args.length > 1 && args[1] instanceof Long) {
					long value = ((Long) args[1]).longValue();

					// if need to filter some other events see
					// swt.widgets.Display class, windowProc methods
					// and add eventIDs to MacOS.java
					if (value == MacOS.sel_keyDown_
							|| value == MacOS.sel_keyUp_
							|| value == MacOS.sel_keyCode

							|| value == MacOS.sel_mouseDown_
							|| value == MacOS.sel_mouseUp_
							|| value == MacOS.sel_mouseDragged_
							|| value == MacOS.sel_mouseEntered_
							|| value == MacOS.sel_mouseExited_
							|| value == MacOS.sel_mouseMoved_

							|| value == MacOS.sel_rightMouseDown_
							|| value == MacOS.sel_rightMouseUp_
							|| value == MacOS.sel_rightMouseDragged_

							|| value == MacOS.sel_otherMouseDown_
							|| value == MacOS.sel_otherMouseUp_
							|| value == MacOS.sel_otherMouseDragged_

							|| value == MacOS.sel_hitTest_
							|| value == MacOS.sel_hitPart
							|| value == MacOS.sel_hitTestForEvent_inRect_ofView_

							|| value == MacOS.sel_cut_
							|| value == MacOS.sel_copy_
							|| value == MacOS.sel_paste_
							|| value == MacOS.sel_insertText_

							|| value == MacOS.sel_pageDown_
							|| value == MacOS.sel_pageUp_

							|| value == MacOS.sel_scrollWheel_
							|| value == MacOS.sel_wheelDelta

							|| value == MacOS.sel_windowWillClose_
							|| value == MacOS.sel_windowShouldClose_) {
						return 0;
					}
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed();
	}
}
