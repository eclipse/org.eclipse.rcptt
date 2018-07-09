package org.eclipse.rcptt.tesla.recording.aspects.swt.rap;

import static org.eclipse.rcptt.tesla.core.utils.TeslaUtils.isMac;

import java.io.File;
import java.lang.reflect.Field;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.ClientFileLoader;
import org.eclipse.rap.rwt.client.service.JavaScriptLoader;
import org.eclipse.rap.rwt.internal.application.ApplicationContextImpl;
import org.eclipse.rap.rwt.internal.lifecycle.CurrentPhase;
import org.eclipse.rap.rwt.internal.lifecycle.PhaseId;
import org.eclipse.rap.rwt.internal.service.ServiceManagerImpl;
import org.eclipse.rap.rwt.service.ResourceManager;
import org.eclipse.rap.rwt.service.ServiceHandler;
import org.eclipse.rap.rwt.widgets.DialogCallback;
import org.eclipse.rap.rwt.widgets.WidgetUtil;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.swt.dialogs.SWTDialogManager;
import org.eclipse.rcptt.tesla.swt.download.RapDownloadHandlerManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.core.utils.TeslaUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.swt.dialogs.SWTDialogManager;
import org.eclipse.rcptt.tesla.swt.download.RapDownloadHandlerManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.logging.SwtEventLog;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.internal.lifecycle.CurrentPhase;
import org.eclipse.rap.rwt.internal.lifecycle.PhaseId;
import org.eclipse.rap.rwt.internal.service.ServiceManagerImpl;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.rap.rwt.osgi.ApplicationLauncher;
import org.eclipse.rap.rwt.service.ServiceHandler;
import org.eclipse.rap.rwt.widgets.DialogCallback;

privileged public aspect RecordingAspect {
	private boolean wasSendEvent = false;

	public RecordingAspect() {
		AspectManager.activateAspect(RecordingSWTActivator.PLUGIN_ID, this.getClass().getName());
	}

	private static boolean isEventProcessingPhase() {
		PhaseId currentPhase = CurrentPhase.get();
		return PhaseId.PREPARE_UI_ROOT.equals(currentPhase) || PhaseId.PROCESS_ACTION.equals(currentPhase);
	}

	boolean around(Widget widget, int type):
		execution(boolean Widget.isListening(int)) && target(widget) && args(type) {
		if (proceed(widget, type)) {
			return true;
		}
		if (widget instanceof ToolItem && (widget.getStyle() & SWT.SEPARATOR) != 0) {
			// see rap bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=422104
			return false;
		}

		return (SWTEventManager.needProceedEvents()
				// all UI changes must be made in Render phase otherwise (in
				// read phase)
				// changes will be not be provided to the client (JS),
				// because server will not find changes (after Read and Render
				// no UI
				// difference, see WidgetLCAUtil.hasChanged).
				&& CurrentPhase.get() == PhaseId.RENDER);

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
			if (event != null && SWTEventManager.isFreeze(event.widget, event.type, event)) {
				return false;
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}

		return proceed(display, event);
	}

	private boolean needProceedEvent(Widget widget, int type) {
		try {
			if (widget instanceof Tree && (type != SWT.Selection || type != SWT.DefaultSelection)) {
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
				if ((widget instanceof Tree) || (widget instanceof Table)) {
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
		try {
			if (SWTEventManager.isFreeze(ctrl, 0, null)) {
				Event e = new Event();
				Point loc = Display.getCurrent().getCursorLocation();
				loc = ctrl.toControl(loc.x, loc.y);
				e.x = loc.x;
				e.y = loc.y;
				SWTEventManager.handleEventInFreeze(ctrl, 0, e);
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

	private List<Event> current = new ArrayList<Event>();

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Widget widget, Event event):
	 	execution(void Widget.sendEvent (Event)) && target(widget) && args(event) {
		boolean send = true;
		int type = event.type;

		if (current.contains(event) || SWTEventManager.isShouldProceed(widget, type) || !isEventProcessingPhase()) {
			return proceed(widget, event);
		}

		try {
			current.add(event);
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
			Object result = null;
			boolean needProceed = !SWTEventManager.skipEvent(widget, type, event, send);
			if (!needProceed) {
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
				// wasSendEvent flag might be set to 'true' if
				// 'sendSelectionEvent'
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

			if (needProceed)
				return proceed(widget, event);
			return result;
		} finally {
			current.remove(event);
		}
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
	Object around(FileDialog dialog):
		execution(* org.eclipse.swt.widgets.FileDialog.open())
		&& target(dialog)
	{
		if (TeslaEventManager.getManager().hasListeners()) {
			return 0;
		}

		Object dialogResult = 0;
		try {
			SWTDialogManager.setFileDialogOpen(true);
			dialogResult = proceed(dialog);
		} finally {
			SWTDialogManager.setFileDialogOpen(false);
		}
		String[] result = dialog.getFileNames().clone();
		SWTEventManager.recordSWTDialog(dialog, result);
		return dialogResult;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(FileDialog dialog, DialogCallback callback):
		execution(void Dialog.open(DialogCallback))
		&& target(dialog)
		&& args(callback)
	{
		if (TeslaEventManager.getManager().hasListeners()) {
			return 0;
		}

		SWTDialogManager.setFileDialogOpen(true);
		final FileDialog dlg = dialog;
		final DialogCallback real = callback;
		final DialogCallback wrapper = new DialogCallback() {
			private static final long serialVersionUID = 1L;

			public void dialogClosed(int returnCode) {
				real.dialogClosed(returnCode);
				SWTDialogManager.setFileDialogOpen(false);

				if (returnCode == SWT.OK) {
					String[] result = dlg.getFileNames().clone();
					SWTEventManager.recordSWTDialog(dlg, result);
				}

			}
		};

		Object dialogResult = proceed(dialog, wrapper);
		return dialogResult;
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
	after(CCombo combo, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.custom.CCombo.new(org.eclipse.swt.widgets.Composite,int)) && target(combo) && args(composite, style){
		try {
			SWTEventManager.recordCombo(combo);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Button button, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.widgets.Button.new(org.eclipse.swt.widgets.Composite,int)) && target(button) && args(composite, style){
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
			}
		});
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(TabFolder tab, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.widgets.TabFolder.new(org.eclipse.swt.widgets.Composite,int)) && target(tab) && args(composite, style){
		tab.addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
			}
		});
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(CTabFolder tab, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.custom.CTabFolder.new(org.eclipse.swt.widgets.Composite,int)) && target(tab) && args(composite, style){
		tab.addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
			}
		});
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Browser browser, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.browser.Browser.new(org.eclipse.swt.widgets.Composite,int)) && target(browser) && args(composite, style){
		browser.addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
			}
		});
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Group group, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.widgets.Group.new(org.eclipse.swt.widgets.Composite,int)) && target(group) && args(composite, style){
		group.addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
			}
		});
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Text text, org.eclipse.swt.widgets.Composite composite, int style):
		execution(org.eclipse.swt.widgets.Text.new(org.eclipse.swt.widgets.Composite,int)) && target(text) && args(composite, style){
		text.addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
			}
		});
	}

	 after(ApplicationContextImpl context):
			execution(* org.eclipse.rap.rwt.internal.application.ApplicationContextImpl.activate())
			&& target(context) {
		 context.getServiceManager().registerServiceHandler(AssertionServiceHandler.HANDLER_ID, new AssertionServiceHandler());
		 try {
			RcpttJSRegistrar.registrate(context.getStartupPage(), context.getResourceManager());
		} catch (IOException e) {
			RecordingSWTActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ServiceManagerImpl manager, String customId):
		execution(ServiceHandler org.eclipse.rap.rwt.internal.service.ServiceManagerImpl.getCustomHandlerChecked(String))
		&& target(manager)
		&& args(customId) {
		Object result = proceed(manager, customId);
		try {
			if (!TeslaEventManager.getManager().hasListeners() && RapDownloadHandlerManager.contains(customId)) {
				return new ServiceHandlerWrapper((ServiceHandler) result, customId);
			}
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
		return result;
	}

	// Collect menu sources
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Menu menu, org.eclipse.swt.widgets.Control parent): execution(org.eclipse.swt.widgets.Menu.new(org.eclipse.swt.widgets.Control)) && target(menu) && args(parent) {
		try {
			SWTEventManager.setMenuSource(menu, parent);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// Collect menu sources
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Menu menu, org.eclipse.swt.widgets.Decorations parent, int style): execution(org.eclipse.swt.widgets.Menu.new(org.eclipse.swt.widgets.Decorations,int)) && target(menu) && args(parent, style) {
		try {
			SWTEventManager.setMenuSource(menu, parent);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

	// Collect menu sources
	@SuppressAjWarnings("adviceDidNotMatch")
	after(org.eclipse.swt.widgets.Control control, org.eclipse.swt.widgets.Menu menu): execution(void org.eclipse.swt.widgets.Control.setMenu(org.eclipse.swt.widgets.Menu)) && target(control) && args(menu) {
		try {
			SWTEventManager.setMenuSource(menu, control);
		} catch (Throwable e) {
			RecordingSWTActivator.log(e);
		}
	}

}
