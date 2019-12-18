/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.events;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.service.ServerPushSession;
import org.eclipse.rap.rwt.service.UISessionEvent;
import org.eclipse.rap.rwt.service.UISessionListener;
import org.eclipse.rcptt.tesla.core.am.rap.RecordingModeFeature;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

public class TeslaEventManager {
	private static TeslaEventManager manager = new TeslaEventManager();
	private static Shell activeShell;
	private Set<ITeslaEventListener> listeners = new HashSet<ITeslaEventListener>();
	private Set<IRwtWorkbenchListener> workbenchListeners = new HashSet<IRwtWorkbenchListener>();
	private List<WeakReference<Menu>> popupMenus = new ArrayList<WeakReference<Menu>>();
	private final List<Menu> allRegisteredMenu = new ArrayList<Menu>();
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
	private Display lastDisplay;
	private Object lastWorkbench;

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
		startSynchronizer();
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

	private List<ITeslaEventListener> getListeners() {
		List<ITeslaEventListener> copy = null;
		synchronized (listeners) {
			copy = new ArrayList<ITeslaEventListener>(listeners);
		}
		return copy;
	}

	private List<IRwtWorkbenchListener> getWorkbenchListeners() {
		List<IRwtWorkbenchListener> copy = null;
		synchronized (listeners) {
			copy = new ArrayList<IRwtWorkbenchListener>(workbenchListeners);
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

	public synchronized void registerPopupMenu(Menu menu)
	{
		allRegisteredMenu.add(menu);
	}

	public synchronized void clearRegisteredPopupMenu()
	{
		this.allRegisteredMenu.clear();
	}

	public List<WeakReference<Menu>> getPopupMenus() {
		return popupMenus;
	}

	public List<Menu> getAllRegisteredMenus() {
		return Collections.unmodifiableList(this.allRegisteredMenu);
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
		for (int i = 0; i < syncExecs.size(); i++) {
			if (syncExecs.get(i) == ctx) {
				syncExecs.remove(i);
				return;
			}
		}
		// Backup based on equals
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

	public Object getWorkbench() {
		return lastWorkbench;
	}

	public Display getDisplay() {
		return lastDisplay;
	}

	Map<Display, Boolean> synced = new HashMap<Display, Boolean>();

	public void setLastDisplay(Display lastDisplay) {
		if (this.lastDisplay != lastDisplay) {

			Display old = this.lastDisplay;
			this.lastDisplay = lastDisplay;

			synced.remove(old);
			popupMenuParents.clear();
			popupMenus.clear();
			allRegisteredMenu.clear();

			if (lastDisplay != null) {

				RWT.getUISession().addUISessionListener(new UISessionListener() {
					private static final long serialVersionUID = 1L;

					public void beforeDestroy(UISessionEvent event) {
						synchronized (needSync) {
							session = null;
						}
					}
				});
				this.session = new ServerPushSession();
				this.session.start();
				synced.put(lastDisplay, true);
			}
		}
	}

	public void setLastWorkbench(Object lastWorkbench) {
		Object old = this.lastWorkbench;
		this.lastWorkbench = lastWorkbench;

		for (IRwtWorkbenchListener listener : getWorkbenchListeners()) {
			listener.workbenchChnage(old, lastWorkbench);
		}
	}

	private ServerPushSession session;
	private Boolean needSync = false;

	public void sync() {
		synchronized (needSync) {
			if (!needSync) {
				if (session != null) {
					session.start();
					needSync = true;
				}
			}
		}
	}

	private void startSynchronizer() {

		final Runnable bgRunnable = new Runnable() {
			public void run() {

				while (!Thread.currentThread().isInterrupted()) {
					try {
						push();
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			private void push() {
				synchronized (needSync) {
					if (needSync && lastDisplay != null && !lastDisplay.isDisposed()
							&& Boolean.TRUE.equals(synced.get(lastDisplay))) {

						final Display executor = lastDisplay;
						executor.asyncExec(new Runnable() {
							public void run() {

								try {
									if (RWT.getUISession() != null && session != null) {
										session.stop();
									}
								} finally {
									if (synced.containsKey(executor)) {
										synced.put(executor, true);
									}
									needSync = false;
								}
							}
						});
						synced.put(executor, false);
					}
				}
			}
		};

		Thread bgThread = new Thread(bgRunnable);
		bgThread.setDaemon(true);
		bgThread.start();
	}

	public void addWorkbenchListener(IRwtWorkbenchListener listener) {
		synchronized (workbenchListeners) {
			workbenchListeners.add(listener);
		}
	}

	public void removeWorkbenchListener(IRwtWorkbenchListener listener) {
		synchronized (workbenchListeners) {
			workbenchListeners.add(listener);
		}
	}

	public void deactivatePushSession() {
		synchronized(needSync)
		{
			session.stop();
			this.lastDisplay = null;
			this.lastWorkbench = null;
			session = null;
		}
	}

}
