package org.eclipse.rcptt.tesla.recording.aspects;

import static org.eclipse.rcptt.tesla.core.utils.TeslaUtils.isMac;

import java.io.File;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.core.utils.TeslaUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.swt.logging.SwtEventLog;

public aspect RecordingAspect {
	private boolean wasSendEvent = false;

	public RecordingAspect() {
		AspectManager.activateAspect(RecordingSWTActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget, int type, Event event, boolean send): 
	 	execution(void Widget.sendEvent (int, Event, boolean)) && target(widget) && args(type, event, send) {
		SWTEventManager.setCurrentEvent(event);
		if (SWTEventManager.isShouldProceed(widget, type)) {
			SwtEventLog.getInstance().logProceed(widget, type, event, send);
			return proceed(widget, type, event, send);
		}
		boolean needProceed = !SWTEventManager.skipEvent(widget, type, event,
				send);
		try {
			if (SWTEventManager.isFreeze(widget, type, event)) {
				if (!SWTEventManager.handleEventInFreeze(widget, type, event)) {
					if (event != null && !needProceedEvent(widget, type)) {
						SwtEventLog.getInstance().logSkip(widget, type, event, send);						
						event.doit = false;
					}
					return null;
				}
			}
			wasSendEvent = true;
			SwtEventLog.getInstance().logRecord(widget, type, event, send);
			if (!isMac || (isMac && send) || (isMac && type == SWT.Modify)) {
				// II: I have changed event processing logic on Mac, see details below
				// however I did not change handling of Modify event, so left it
				// as it was in previous version, but probably this is not needed
				// anymore
				//
				// Event sequence for usual push button might look like this:
				// With listeners:
				// 1. sendSelectionEvent() <-- captured by aspect below
				// 2. sendEvent(int, event, false) <-- captured by this aspect,
				//    will set 'wasSendEvent' to true, so that selection aspect
				//    won't record it
				// 3. sendEvent(int, event, true) <-- captured by this aspect, will be recorded
				// Without listeners:
				// 1. sendSelectionEvent() <-- that's it, no listeners and event won't go any further
				// So we need to record it in selection aspect
				SWTEventManager.recordEvent(widget, type, event);
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		if (needProceed) {
			SwtEventLog.getInstance().logProceed(widget, type, event, send);
			proceed(widget, type, event, send);
		} else {
			if (event != null) {
				SwtEventLog.getInstance().logSkip(widget, type, event, send);
				event.doit = false;
			}
		}
		return null;
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget, Event event): 
	 	execution(void Widget.sendEvent (Event)) && target(widget) && args(event) {
		SWTEventManager.setCurrentEvent(event);
		if (event != null
				&& SWTEventManager.isShouldProceed(widget, event.type)) {
			SwtEventLog.getInstance().logProceed(widget, -1, event, true);
			return proceed(widget, event);
		}
		try {
			if (event != null
					&& SWTEventManager.isFreeze(widget, event.type, event)) {
				if (!SWTEventManager.handleEventInFreeze(widget, event.type,
						event)) {
					if (event != null && !needProceedEvent(widget, event.type)) {
						SwtEventLog.getInstance().logSkip(widget, -1, event, true);						
						event.doit = false;
					}
					return null;
				}
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		
		SwtEventLog.getInstance().logProceed(widget, -1, event, true);
		return proceed(widget, event);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget, int x, int y):
		execution(boolean org.eclipse.swt.widgets.Widget.showMenu(int, int)) && target(widget) && args(x,y) {
		if (SWTEventManager.isShouldProceed(widget, SWT.Show)) {
			return proceed(widget, x, y);
		}
		try {
			if (SWTEventManager.isFreeze(widget, 0, null)) {
				return Boolean.FALSE;
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return proceed(widget, x, y);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Control ctrl, int x, int y):
		execution( boolean org.eclipse.swt.widgets.Control.showMenu(int, int)) && target(ctrl) && args(x,y) {
		if (SWTEventManager.isShouldProceed(ctrl, SWT.Show)) {
			return proceed(ctrl, x, y);
		}
		try {
			if (SWTEventManager.isFreeze(ctrl, 0, null)) {
				return Boolean.FALSE;
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}

		return proceed(ctrl, x, y);

	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Display display, Event event): execution(boolean Display.filterEvent(Event)) && target(display) && args(event) {
		try {
			if (event != null
					&& SWTEventManager
							.isFreeze(event.widget, event.type, event)) {
				return false;
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}

		return proceed(display, event);
	}

	private boolean needProceedEvent(Widget widget, int type) {
		try {
			if (widget instanceof Tree
					&& (type != SWT.Selection || type != SWT.DefaultSelection)) {
				return !((Tree) widget).isVisible();
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return false;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget, int type): execution(boolean Widget.hooks (int)) && args(type) && target(widget) {
		if (SWTEventManager.isShouldProceed(widget, type)) {
			return proceed(widget, type);
		}
		Object result = proceed(widget, type);
		try {
			if (SWTEventManager.isFreeze(widget, type, null)) {
				if ((widget instanceof Tree) || (widget instanceof StyledText)
						|| (widget instanceof Table)) {
					return result;
				}
				return true; // Assume is hooked
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget): execution( boolean Widget.sendKeyEvent (..)) && target(widget) {
		if (SWTEventManager.isShouldProceed(widget, SWT.KeyDown)) {
			return proceed(widget);
		}
		try {
			if (SWTEventManager.isFreeze(widget, SWT.KeyDown, null)) {
				proceed(widget);
				return false;
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return proceed(widget);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Control ctrl): execution( boolean Control.sendMouseEvent (..)) && target(ctrl) {
		if (SWTEventManager.isShouldProceed(ctrl, SWT.MouseMove)) {
			return proceed(ctrl);
		}
		try {
			if (SWTEventManager.isFreeze(ctrl, SWT.MouseMove, null)) {
				Event e = new Event();
				Point loc = Display.getCurrent().getCursorLocation();
				loc = ctrl.toControl(loc.x, loc.y);
				e.x = loc.x;
				e.y = loc.y;
				SWTEventManager.handleEventInFreeze(ctrl, SWT.MouseMove, e);
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return proceed(ctrl);
	}

	/**
	 * Prevent in assert mode changing selection state of menu items
	 */
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(MenuItem item, boolean selected): 
		execution(void org.eclipse.swt.widgets.MenuItem.setSelection(boolean)) && target(item) && args(selected) {
		try {
			if (SWTEventManager.getFreeze()) {
				return null;
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return proceed(item, selected);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget, int type, Event event, boolean send): 
		execution(void org.eclipse.swt.widgets.Widget.sendSelectionEvent(int, Event, boolean)) && target(widget) && args(type, event, send) {
		if (SWTEventManager.isShouldProceed(widget, type)) {
			return proceed(widget, type, event, send);
		}
		try {
			if (SWTEventManager.isFreeze(widget, type, event)) {
				if (!SWTEventManager.handleEventInFreeze(widget, type, event)) {
					if (event != null && !needProceedEvent(widget, type)) {
						event.doit = false;
					}
					return null;
				}
			}
			wasSendEvent = false;
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		boolean needProceed = !SWTEventManager.skipEvent(widget, type, event,
				send);
		Object result = null;
		if (needProceed) {
			result = proceed(widget, type, event, send);
		} else {
			if (event != null) {
				event.doit = false;
			}
		}
		try {
			// Ivan Inozemtsev, July, 5, 2013:
			// Previously there was a condition that event is being recorded
			// only when send == true, or OS is not Mac
			// However in this case if there are no selection listeners
			// (and for instance for TabFolders there's no need for
			// selection listeners)
			// event will not be recorded on Mac OS X
			//
			// wasSendEvent flag might be set to 'true' if 'sendSelectionEvent'
			// invokes 'sendEvent(int,event,boolean)'. In this case, aspect
			// above will capture this invocation and record event by
			// itself (and set 'wasSendEvent' to true
			//
			if (!wasSendEvent) {
				SWTEventManager.recordEvent(widget, type, event);
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Control ctrl, int type):
		execution(void org.eclipse.swt.widgets.Control.sendFocusEvent(int)) && target(ctrl) && args(type) {
		try {
			if (SWTEventManager.isFreeze(ctrl, type, null)) {
				if (!SWTEventManager.handleEventInFreeze(ctrl, type, null)) {
					return null;
				}
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return proceed(ctrl, type);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(FileDialog dialog): execution(String FileDialog.open()) && target(dialog) {
		Object dialogResult = proceed(dialog);
		try {
			String[] result = dialog.getFileNames().clone();
			for (int i = 0; i < result.length; i++) {
				result[i] = dialog.getFilterPath() + File.separator + result[i];
			}
			SWTEventManager.recordSWTDialog(dialog, result);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return dialogResult;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(DirectoryDialog dialog): execution(String DirectoryDialog.open()) && target(dialog) {
		Object result = proceed(dialog);
		try {
			SWTEventManager.recordSWTDialog(dialog, result);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(FontDialog dialog): execution(org.eclipse.swt.graphics.FontData FontDialog.open()) && target(dialog) {
		Object result = proceed(dialog);
		try {
			SWTEventManager.recordSWTDialog(dialog, result);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ColorDialog dialog): execution(org.eclipse.swt.graphics.RGB ColorDialog.open()) && target(dialog) {
		Object result = proceed(dialog);
		try {
			SWTEventManager.recordSWTDialog(dialog, result);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(MessageBox dialog): execution(int MessageBox.open()) && target(dialog) {
		Object result = proceed(dialog);
		try {
			SWTEventManager.recordSWTDialog(dialog, result);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(CCombo combo): execution(void org.eclipse.swt.custom.CCombo.createPopup(String[], int)) && target(combo) {
		try {
			SWTEventManager.recordCombo(combo);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(StyledText text, int action): execution(void org.eclipse.swt.custom.StyledText.invokeAction(int)) && target(text) && args(action) {
		try {
			SWTEventManager.recordStyledTextActionAfter(text, action);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(StyledText text, int action): execution(void org.eclipse.swt.custom.StyledText.invokeAction(int)) && target(text) && args(action) {
		try {
			SWTEventManager.recordStyledTextActionBefore(text, action);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(StyledText text): execution(void org.eclipse.swt.custom.StyledText.setCaretOffset(int, int)) && target(text) {
		try {
			SWTEventManager.recordStyledTextOffset(text);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// eclipse 3.4 support:
	// setCaretOffset(int, int) - no such method in 3.4
	// added after setCaretLocation()
	@SuppressAjWarnings("adviceDidNotMatch")
	after(StyledText text): execution(void org.eclipse.swt.custom.StyledText.setCaretLocation()) && target(text) {
		try {
			if (TeslaUtils.getEclipseVersion().getMajor() <= 3
					&& TeslaUtils.getEclipseVersion().getMinor() <= 4)
				SWTEventManager.recordStyledTextOffset(text);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// Collect menu sources
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Menu menu,
			org.eclipse.swt.widgets.Control parent): execution(org.eclipse.swt.widgets.Menu.new(org.eclipse.swt.widgets.Control)) && target(menu) && args(parent) {
		try {
			SWTEventManager.setMenuSource(menu, parent);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// Collect menu sources
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Menu menu,
			org.eclipse.swt.widgets.Decorations parent, int style): execution(org.eclipse.swt.widgets.Menu.new(org.eclipse.swt.widgets.Decorations,int)) && target(menu) && args(parent, style) {
		try {
			SWTEventManager.setMenuSource(menu, parent);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// Collect menu sources
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Control control,
			org.eclipse.swt.widgets.Menu menu): execution(void org.eclipse.swt.widgets.Control.setMenu(org.eclipse.swt.widgets.Menu)) && target(control) && args(menu) {
		try {
			SWTEventManager.setMenuSource(menu, control);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// Collect menu sources
	// after(org.eclipse.swt.widgets.TaskBar control,
	// org.eclipse.swt.widgets.Menu menu): execution(void
	// org.eclipse.swt.widgets.TaskBar.setMenu(org.eclipse.swt.widgets.Menu)) &&
	// target(control) && args(menu) {
	// SWTEventManager.processMenuCreation(menu, control);
	// }
	
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Shell shell, boolean visible):
		execution(void org.eclipse.swt.widgets.Shell.setVisible(boolean))
		&& target(shell) && args(visible) {
		if (!visible) {
			try {
				SWTUIElement wrappedShell = SWTUIPlayer.getPlayer().wrap(shell);
				SWTEventManager.removeClosedShell(wrappedShell);
			} catch (Throwable e) {
				RecordingSWTActivator.log(e);
			}
		}
	}
	
// -- THE CODE BELLOW USED FOR CUSTOM BUILDS
	
//	before(org.eclipse.ui.views.properties.PropertySheet sheet):
//		call (* *.*(..)) && this(sheet) {
//		SwtEventLog.getInstance().logMethodCallFrom(thisJoinPoint);
//	}
//	
//	before(org.eclipse.ui.views.properties.PropertySheet sheet):
//		execution (* *.*(..)) && target(sheet) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	private DisposeListener disposeListener = new DisposeListener() {
//		public void widgetDisposed(DisposeEvent e) {
//			SwtEventLog.getInstance().logTypedEvent(e);
//			e.widget.removeDisposeListener(this);
//		}
//	};
//	
//	after(Tree tree) returning: this(tree) && execution (Tree.new(..)) {
//		tree.addDisposeListener(disposeListener);
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
	
//	before(Widget widget):
//		execution (public void Widget.dispose()) && target(widget) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
	
//	before(Combo combo):
//	execution (public void setItems(String[])) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(Combo combo):
//	execution (public void setItem(int, String)) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(Combo combo):
//	execution (public void add(String)) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(Combo combo):
//	execution (public void add(String, int)) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(CCombo combo):
//	execution (public void setItems(String[])) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(CCombo combo):
//	execution (public void setItem(int, String)) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(CCombo combo):
//	execution (public void add(String)) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(CCombo combo):
//	execution (public void add(String, int)) && target(combo) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
	
//	after(Shell shell) returning: this(shell) && initialization(Shell.new(..)) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//    }	
//	
//	before(Shell shell):
//	execution (public void open()) && target(shell) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(Shell shell):
//	execution (public void close()) && target(shell) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
//	
//	before(Shell shell):
//	execution (public void dispose()) && target(shell) {
//		SwtEventLog.getInstance().logMethodCallTo(thisJoinPoint);
//	}
}
