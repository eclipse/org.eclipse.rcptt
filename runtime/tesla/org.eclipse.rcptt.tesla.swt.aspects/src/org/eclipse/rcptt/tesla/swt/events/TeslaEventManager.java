/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.events;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.am.RecordingModeFeature;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.swt.aspects.SWTAspectActivator;

public class TeslaEventManager {
	private static TeslaEventManager manager = new TeslaEventManager();
	private static Shell activeShell;
	private Set<ITeslaEventListener> listeners = new HashSet<ITeslaEventListener>();
	private List<WeakReference<Menu>> popupMenus = new ArrayList<WeakReference<Menu>>();
	private Map<Menu, Control> popupMenuParents = new WeakHashMap<Menu, Control>();
	private Widget lastWidget;
	private int lastWidgetX;
	private int lastWidgetY;
	private List<Context> syncExecs = new ArrayList<ContextManagement.Context>();
	private WeakReference<Control> forceFocusControl;
	private boolean ignoreMenuShow = false;
	private Map<Shell, String> shellMethodsMap = new WeakHashMap<Shell, String>();
	private boolean statusDialogModeAllowed = false;
	private boolean showingAlert = false;

	public static enum HasEventKind {
		async, sync, timer
	}

	public void setShowingAlert(boolean showing) {
		showingAlert = showing;
	}

	public boolean getShowingAlert() {
		return showingAlert;
	}

	public interface IUnhandledNativeDialogHandler {
		@SuppressWarnings("rawtypes")
		void handle(Class clazz, String message);
	}

	private IUnhandledNativeDialogHandler unhandledNativeDialogHandler;

	private volatile boolean unfreeze;
	private boolean noWaitForJob = false;

	public boolean isUnfreeze() {
		return unfreeze;
	}

	public void setUnfreeze(boolean unfreeze) {
		this.unfreeze = unfreeze;
	}

	private TeslaEventManager() {
	}

	public static TeslaEventManager getManager() {
		return manager;
	}

	public void addEventListener(ITeslaEventListener listener) {
		synchronized (listeners) {
			this.listeners.add(listener);
		}
	}

	public void removeEventListener(ITeslaEventListener listener) {
		synchronized (listeners) {
			this.listeners.remove(listener);
		}
	}

	public void clearListeners() {
		synchronized (listeners) {
			this.listeners.clear();
		}
	}

	public boolean doProcessing(Context currentContext) {
		boolean hasEvent = false;
		List<ITeslaEventListener> copy = getListeners();
		for (ITeslaEventListener listener : copy) {
			if (listener.doProcessing(currentContext)) {
				hasEvent = true;
			}
		}
		return hasEvent;
	}

	@SuppressWarnings("unused")
	private boolean hasTimerProces() {
		Class<? extends Display> class1 = Display.getCurrent().getClass();
		try {
			Field field = class1.getDeclaredField("timerList");
			field.setAccessible(true);
			Runnable[] runnables = (Runnable[]) field.get(Display.getCurrent());

			Field timerIds = class1.getDeclaredField("timerIds");
			timerIds.setAccessible(true);
			int[] timers = (int[]) timerIds.get(Display.getCurrent());

			if (runnables != null && runnables.length > 0) {
				// Check if all less timeout
				for (int i = 0; i < runnables.length; ++i) {
					if (runnables[i] != null) {
						if (timers[i] <= 200) {
							System.out.println("Wait for timer proc:"
									+ runnables[i].getClass().getName());
							return true;
						}
					}
				}
				return false;
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private List<ITeslaEventListener> getListeners() {
		List<ITeslaEventListener> copy = null;
		synchronized (listeners) {
			copy = new ArrayList<ITeslaEventListener>(listeners);
		}
		return copy;
	}

	public boolean hasListeners() {
		synchronized (listeners) {
			return !listeners.isEmpty();
		}
	}

	public synchronized boolean proceedMenu(Menu menu, boolean value) {
		if (hasListeners() && !isUnfreeze()) {
			// TODO: Support only one popup menu at once
			if (value) {
				if ((menu.getStyle() & (SWT.BAR | SWT.DROP_DOWN)) != 0) {
					return false;
				}
				popupMenus.clear();
				popupMenus.add(new WeakReference<Menu>(menu));

			} else {
				popupMenus.clear();
			}
			return true;
		}
		return false;
	}

	public List<WeakReference<Menu>> getPopupMenus() {
		return popupMenus;
	}

	public Map<Menu, Control> getPopupMenuParents() {
		return popupMenuParents;
	}

	public Point getCursotLocation(Point point) {
		if (listeners.size() == 0) {
			return point;
		}
		if (this.lastWidget != null
				&& this.lastWidget instanceof org.eclipse.swt.widgets.Control
				&& !this.lastWidget.isDisposed()) {
			org.eclipse.swt.widgets.Control ctrl = (org.eclipse.swt.widgets.Control) this.lastWidget;
			return ctrl.toDisplay(this.lastWidgetX, this.lastWidgetY);
		}
		return point;
	}

	public void setLastWidget(Widget widget, int x, int y) {
		this.lastWidget = widget;
		this.lastWidgetX = x;
		this.lastWidgetY = y;
	}

	public void addMenuControl(Menu menu, Control parent) {
		popupMenuParents.put(menu, parent);
	}

	public synchronized void syncExecCalled(Context ctx) {
		syncExecs.add(ctx);
	}

	public void hasEvent(HasEventKind hasEventKind, String name) {
		List<ITeslaEventListener> copy = getListeners();
		for (ITeslaEventListener listener : copy) {
			listener.hasEvent(hasEventKind, name);
		}
	}

	public synchronized void syncExecEnd(Context ctx) {
		syncExecs.remove(ctx);
	}

	public synchronized List<Context> getSyncExecs() {
		return new ArrayList<ContextManagement.Context>(syncExecs);
	}

	public static void setActiveShell(Shell shell) {
		activeShell = shell;
		updateActiveShell();
	}

	public static void updateActiveShell() {
		if (Platform.getOS().equals(Platform.OS_LINUX) && activeShell != null
				&& !activeShell.isDisposed()) {
			try {
				Field field = Display.class.getDeclaredField("activeShell");
				field.setAccessible(true);
				field.set(activeShell.getDisplay(), activeShell);
			} catch (Throwable e) {
				SWTAspectActivator.log(e);
			}
		}
	}

	public static Shell getActiveShell() {
		return activeShell;
	}

	public synchronized boolean isJobInSyncExec(Job job, Context context) {
		for (Context context2 : syncExecs) {
			String clName = job.getClass().getName();
			if (context2.containsClass(clName)) {
				return true;// If job called sync exec
			}
		}
		return false;
	}

	public boolean isFiltering() {
		return TeslaEventManager.getManager().hasListeners()
				&& !RecordingModeFeature.isRecordingModeActive()
				&& !isUnfreeze();
	}
	
	public Control getForceFocusControl() {
		Control ctrl = forceFocusControl == null ? null : forceFocusControl.get();
		if (ctrl != null && ctrl.isDisposed()) {
			return null;
		}
		return ctrl;
	}
	public boolean setForceFocusControl(Control focusControl) {
		if (this.forceFocusControl == null || focusControl != this.forceFocusControl.get()) {
			this.forceFocusControl = new WeakReference<Control>(focusControl);
			// Send focus to selected control
			return true;
		}
		return false;
	}



	public void ignoreMenuShow(boolean b) {
		this.ignoreMenuShow = b;
	}

	public boolean isIgnoreMenuShow() {
		return ignoreMenuShow;
	}

	public void setShellCreationMethod(Shell shell, String clName, String methodName) {
		for (Shell sh : new HashSet<Shell>(shellMethodsMap.keySet())) {
			if (sh != null && sh.isDisposed()) {
				shellMethodsMap.remove(sh);
			}
		}
		shellMethodsMap.put(shell, clName + "." + methodName);
	}

	public String getShellCreationMethod(Shell shell) {
		return shellMethodsMap.get(shell);
	}

	public boolean isStatusDialogModeAllowed() {
		return statusDialogModeAllowed;
	}

	public void setStatusDialogModeAllowed(boolean value) {
		statusDialogModeAllowed = value;
	}

	public void setNoWaitForJobs(boolean disableJobWaiting) {
		this.noWaitForJob = disableJobWaiting;
	}

	public boolean isNoWaitForJob() {
		return noWaitForJob;
	}

	@SuppressWarnings("rawtypes")
	public void unhandledNativeDialog(Class clazz, String message) {
		if (unhandledNativeDialogHandler != null) {
			unhandledNativeDialogHandler.handle(clazz, message);
		}
	}

	public void setUnhandledNativeDialogHandler(
			IUnhandledNativeDialogHandler unhandledNativeDialogHandler) {
		this.unhandledNativeDialogHandler = unhandledNativeDialogHandler;
	}
}
