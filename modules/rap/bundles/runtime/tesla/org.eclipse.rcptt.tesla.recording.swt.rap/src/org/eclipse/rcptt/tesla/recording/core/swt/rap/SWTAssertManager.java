/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.swt.rap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.rap.rwt.widgets.WidgetUtil;
import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.features.IMLFeatures;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.ui.Item;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.IAssertSWTEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.ISkipAwareEventListener;
import org.eclipse.rcptt.tesla.recording.aspects.swt.rap.SWTEventManager;
import org.eclipse.rcptt.tesla.recording.aspects.workbench.rap.WorkbenchEventManager;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.util.RecordedEvent;
import org.eclipse.rcptt.tesla.swt.events.RcpttMouseEvents;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.rcptt.util.ShellUtilsProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class SWTAssertManager implements IRecordingProcessor, IAssertSWTEventListener, ISkipAwareEventListener {

	private static Set<Integer> FREEZED_EVENTS;
	{
		Set<Integer> events = new HashSet<Integer>();
		events.add(SWT.MouseDown);
		events.add(SWT.MouseUp);
		events.add(SWT.KeyDown);
		events.add(SWT.KeyUp);
		events.add(SWT.Selection);
		events.add(SWT.DefaultSelection);
		events.add(SWT.MouseDoubleClick);
		events.add(SWT.Deactivate);
		events.add(SWT.Activate);
		events.add(SWT.FocusIn);
		events.add(SWT.FocusOut);
		events.add(SWT.Collapse);
		events.add(SWT.Expand);
		events.add(SWT.Modify);
		events.add(SWT.MenuDetect);
		events.add(SWT.Traverse);

		FREEZED_EVENTS = Collections.unmodifiableSet(events);
	}

	private Set<String> widgetClasses = new HashSet<String>();

	private TeslaRecorder recorder;

	private IRecordingDescriber freezedCtrl;

	private Widget freezedCtrlWidget;
	private Point freezedPoint;

	private Shell selectionShell;
	private Canvas selectionCanvas;
	private IRecordingDescriber lastFocusedWidget;
	private int lastX;
	private int lastY;

	private SWTUIPlayer player;

	private List<IRecordingDescriber> widgetsOnMove = new ArrayList<IRecordingDescriber>();

	private Set<Shell> menuShells = new HashSet<Shell>();

	private Composite bar;

	private Map<MenuItem, MenuItem> menuMap = new HashMap<MenuItem, MenuItem>();
	private List<Menu> menus = new ArrayList<Menu>();

	private Control beforeFreezeFocus = null;

	@Override
	public void clear() {
		lastFocusedWidget = null;
		freezedCtrl = null;
	}

	@Override
	public void initialize(TeslaRecorder teslaRecorder) {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "");
		}
		this.recorder = teslaRecorder;
		player = SWTRecordingHelper.getHelper().getPlayer();
		SWTEventManager.addListener(this);
	}

	@Override
	public int getInitLevel() {
		return 300;
	};

	@Override
	public void setFreeze(final boolean value, SetMode command) {
		widgetClasses.clear();
		if (command != null)
			widgetClasses.addAll(command.getWidgetClasses());

		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "set freeze mode to: " + value);
		}
		final Display display = RWTUtils.findDisplay();
		boolean oldValue = SWTEventManager.getFreeze();
		if (display.isDisposed()) {
			SWTEventManager.setFreeze(false);
			WorkbenchEventManager.setFreeze(false);
			return;
		}
		SWTEventManager.setIgnoreFreeze(player.getIgnored());
		SWTEventManager.setFreeze(value);
		WorkbenchEventManager.setFreeze(value);
		if (value == false) {
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					callCreateHover(value, null);
					disposeMenuPopups();
					clearPopupMenus();
				}

			});
		}
		if (value != oldValue) {
			if (value == false && !display.isDisposed()) {
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						Shell shell = display.getActiveShell();
						if (shell != null) {
							try {
								ShellUtilsProvider.getShellUtils().forceActive(shell);
							} catch (CoreException e) {
								throw new RuntimeException(e);
							}
							if (beforeFreezeFocus != null) {
								// beforeFreezeFocus.forceFocus();
								// beforeFreezeFocus = null;
								Shell[] shells = display.getShells();
								for (Shell s : shells) {
									String creationMethod = TeslaEventManager.getManager().getShellCreationMethod(s);
									if ("AbstractTableInformationControl.<init>()".equals(creationMethod)) {
										try {
											ShellUtilsProvider.getShellUtils().forceActive(s);
										} catch (CoreException e) {
											throw new RuntimeException(e);
										}
										s.forceFocus();
										// new SWTEvents(display).sendEvent(s,
										// SWT.Activate);
									}
								}
							}
						}
					}
				});
			} else {
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						beforeFreezeFocus = display.getFocusControl();
					}
				});
			}
		}
		if (value == false) {
			freezedCtrl = null;
			lastFocusedWidget = null;
		}
	}

	private void disposeMenuPopups() {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "dispose popup menus");
		}
		for (Shell menuShell : menuShells) {
			if (menuShell != null) {
				menuShell.dispose();
			}
		}
		menuShells.clear();
	}

	private Widget getChild(Widget parent, int x, int y) {
		if (!(parent instanceof Control)) {
			return parent;
		}
		Control control = (Control) parent;

		int relX = x - control.getBounds().x;
		int relY = y - control.getBounds().y;

		if (!(parent instanceof Composite)) {
			return parent;
		}
		Composite c = (Composite) parent;
		for (Control ctrl : c.getChildren()) {
			if (ctrl.getBounds().contains(relX, relY) && ctrl.isVisible()) {
				return getChild(ctrl, relX, relY);
			}
		}
		return parent;
	}

	@Override
	public synchronized boolean handleEventInFreeze(Widget widget, int type, Event event) {

		if (event.type == SWT.MouseUp && widget == selectionCanvas) {
			// transparent event
			event.widget = lastFocusedWidget.getWidget();
			widget = lastFocusedWidget.getWidget();
			event.x = lastX;
			event.y = lastY;
			event.type = widget instanceof org.eclipse.swt.widgets.Item && type == SWT.MouseUp ? SWT.Selection : type;
			type = event.type;
		}

		if (widget == selectionCanvas || widget == selectionShell) {
			return true;
		}

		if (TeslaFeatures.isActivityLogging()) {
			try {
				RecordedEvent toRecording = new RecordedEvent(recorder.getProcessor(SWTUIProcessor.class).getPlayer(),
						event, type, widget);
				Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS + ".events", "event: " + toRecording.toString());
			} catch (Throwable e) {
				// ignore
			}
		}
		try {
			SWTEventManager.setShouldProceed(true);

			// Send this command to recorder as a signal to switch mode
			// send request after KeyUp event (if sending after KeyDown, KeyUp
			// recorded as key-type into test case)
			if (type == SWT.KeyUp && event != null) {
				if (isShortcutRequest(event, recorder.getRecordModeShortcuts())) {
					assertionLog("send record mode request");
					recorder.executeCommand(ProtocolFactory.eINSTANCE.createRecordingModeRequest());
				}
				if (isShortcutRequest(event, recorder.getStopRecordShortcuts())) {
					assertionLog("send stop record request");
					Type stopType = ProtocolFactory.eINSTANCE.createType();
					stopType.setState(event.stateMask);
					stopType.setCharacter(event.character);
					stopType.setCode(event.keyCode);
					recorder.executeCommand(stopType);
				}
			}
			if (widget instanceof Control) {
				Control ctrl = (Control) widget;
				for (Shell menuShell : menuShells) {
					if (ctrl.getShell().equals(menuShell)) {
						return true;
					}
				}
			}
			if (widget instanceof Control) {
				if (!((Control) widget).isVisible()) {
					return false;
				}
			}
			if (event == null) {
				event = new Event();
			}

			callCreateHover(true, getShell(widget));
			if (widget instanceof MenuItem) {
				if (menuMap.containsKey(widget)) {
					widget = menuMap.get(widget);
				}
			}

			if (widget instanceof ToolBar) {
				Point point = new Point(event.x, event.y);
				point = ((ToolBar) widget).toControl(point);
				widget = ((ToolBar) widget).getItem(new Point(event.x, event.y));
			}

			if (type == SWT.Show && widget instanceof Menu) {
				type = SWT.Selection;
				widget = ((Menu) widget).getParentItem();
			}

			final IRecordingDescriber assertDescr = selectAllowedParent(
					RecordingDescriberManager.getDescriber(widget, event.x, event.y, true));

			if (type == SWT.Selection && (widget instanceof org.eclipse.swt.widgets.MenuItem)) {
				assertionLog(
						"assertion target locked for menu item: " + ((org.eclipse.swt.widgets.Item) widget).getText());
				seachForElement(assertDescr.searchForElement(recorder), true, assertDescr);
				freezedCtrl = assertDescr;
			}

			if (type == SWT.Selection && widget instanceof ToolItem) {
				assertionLog(
						"assertion target locked for tool item: " + ((org.eclipse.swt.widgets.Item) widget).getText());

				final Event updateEvent = event;
				widget.getDisplay().timerExec(150, new Runnable() {
					public void run() {
						updateHoverAccordingTo(freezedCtrl, updateEvent.x, updateEvent.y);
					}
				});
				freezedCtrl = assertDescr;
			}
			if (type == SWT.KeyDown) {
				if (freezedCtrl != null) {
					switch (event.keyCode) {
					case SWT.ARROW_UP:
						assertionLog("switch assertion target lock to control parent");
						freezedCtrl = freezedCtrl.getParent();
						updateHoverAccordingTo(freezedCtrl, freezedPoint.x, freezedPoint.y);
						break;
					case SWT.ARROW_DOWN:
						assertionLog("switch assertion target lock to child");
						IRecordingDescriber child = RecordingDescriberManager.getDescriber(freezedCtrlWidget,
								freezedPoint.x, freezedPoint.y, true);
						if (!child.equals(freezedCtrl)) {
							while (true) {
								IRecordingDescriber parent = child.getParent();
								if (freezedCtrl.equals(parent)) {
									freezedCtrl = child;
									updateHoverAccordingTo(freezedCtrl, freezedPoint.x, freezedPoint.y);
									break;
								}
								if (parent.equals(child)) {
									freezedCtrl = child;
									updateHoverAccordingTo(freezedCtrl, freezedPoint.x, freezedPoint.y);
									break;
								}
								child = parent;
							}
						}
						break;
					}
				}
			}
			if ((type == SWT.MouseUp && !(widget instanceof ToolItem))
					|| (widget instanceof Label && type == SWT.Activate)) {
				for (Shell menuShell : menuShells) {
					if (menuShell != null) {
						if (widget instanceof Control && !((Control) widget).getShell().equals(menuShell)) {
							menuShells.remove(menuShell);
							menuShell.dispose();
						}
					}
				}
				if (event.button == 1 || type == SWT.FocusIn || type == SWT.Activate) {
					if (freezedCtrl == null) {
						assertionLog("assertion target locked"); //$NON-NLS-1$

						freezedCtrl = assertDescr;
						freezedPoint = new Point(event.x, event.y);
						freezedCtrlWidget = widget;
						final Event updateEvent = event;
						widget.getDisplay().timerExec(150, new Runnable() {
							public void run() {
								updateHoverAccordingTo(freezedCtrl, updateEvent.x, updateEvent.y);
							}
						});

					} else {
						assertionLog("unlock assertion target"); //$NON-NLS-1$

						IRecordingDescriber lastFreezed = freezedCtrl;
						freezedCtrl = null;
						final Event updateEvent = event;
						final IRecordingDescriber updateAssert = assertDescr;
						widget.getDisplay().timerExec(150, new Runnable() {
							public void run() {
								updateHoverAccordingTo(updateAssert, updateEvent.x, updateEvent.y);
							}
						});
						if (lastFreezed != null) {
							lastFreezed.redraw();
						}
					}
				} else if (event.button == 3) {
					// try to freeze control

					if (widget instanceof Control) {
						assertionLog("show popup menu"); //$NON-NLS-1$
						showPopupMenu(event, (Control) widget, assertDescr);
					}
				}
			}
			if ((type == SWT.MouseDown || type == SWT.Activate || type == RcpttMouseEvents.MouseEnter
					|| type == RcpttMouseEvents.MouseExit) && freezedCtrl == null) {

				final Event fevent = event;
				if (widget != null) {
					lastX = fevent.x;
					lastY = fevent.y;
					handleUpdateHover(widget, new Rectangle(0, 0, lastX, lastY));
				}
			}

			return !(FREEZED_EVENTS.contains(type) || (type == 0 && widget instanceof Canvas));
		} finally {
			SWTEventManager.setShouldProceed(false);
		}
	}

	private void assertionLog(String message) {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, message);
		}
	}

	public void handleUpdateHover(Control widget) {
		handleUpdateHover(widget, widget.getBounds());
	}

	private void handleUpdateHover(Widget widget, Rectangle bounds) {
		IRecordingDescriber describer = RecordingDescriberManager.getDescriber(widget, bounds.x, bounds.y, true);
		describer = selectAllowedParent(describer);

		if (describer == null)
			return;

		widgetsOnMove.clear();
		widgetsOnMove.add(describer);
		synchronized (widgetsOnMove) {
			try {
				if (widgetsOnMove.size() > 0 && freezedCtrl == null) {
					IRecordingDescriber last = widgetsOnMove.get(widgetsOnMove.size() - 1);
					if (!last.equals(lastFocusedWidget) || !selectionShell.isVisible()) {
						Widget w = last.getWidget();
						if (!w.isDisposed()) {
							updateHoverAccordingTo(last, bounds.x, bounds.y);
						}
					}
					lastFocusedWidget = last;
				}
			} finally {
				widgetsOnMove.clear();
			}
		}
	}

	public boolean isShortcutRequest(Event e, String[] shortcuts) {
		if (shortcuts == null) {
			return false;
		}
		int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(e);
		KeySequence sequence = KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
		if (shortcuts != null) {
			for (String formatted : shortcuts) {
				try {
					KeySequence shortcut = KeySequence.getInstance(formatted);
					if (sequence.equals(shortcut)) {
						return true;
					}
				} catch (ParseException e1) {
					TeslaCore.log("Invalid shortcut: " + formatted);
				}
			}
		}
		return false;
	}

	private void showPopupMenu(Event event, Control c, IRecordingDescriber describer) {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "show popup menu for: " + c.getClass().toString());
		}
		Menu menu = null;
		player.getEvents().sendEvent(c, SWT.MenuDetect, event.x, event.y, SWT.BUTTON2);
		menu = c.getMenu();
		if (menu != null && !menu.isDisposed()) {
			player.getEvents().sendEvent(menu, SWT.Show);
			// menu.setVisible(true);
			Menu popupMenu = new Menu(getShell(c), SWT.POP_UP);
			clearPopupMenus();
			copyMenuTo(menu, popupMenu);
			menus.add(popupMenu);
			popupMenu.setVisible(true);

			// showMenuAt(event, c, menu);
		}
	}

	private void clearPopupMenus() {
		for (MenuItem item : menuMap.keySet()) {
			if (!item.isDisposed()) {
				item.dispose();
			}
		}
		menuMap.clear();
		for (Menu menu : menus) {
			if (!menu.isDisposed()) {
				menu.dispose();
			}
		}
		menus.clear();

	}

	private void copyMenuTo(Menu menu, Menu popupMenu) {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "copy popup menu");
		}
		for (MenuItem i : menu.getItems()) {
			MenuItem copy = new MenuItem(popupMenu, i.getStyle());
			menuMap.put(copy, i);

			String text = "" + (i.getText());
			String text2 = "";
			if (text.contains("\t")) {
				int tabIndex = text.indexOf('\t');
				text2 = text.substring(tabIndex + 1);
				text = text.substring(0, tabIndex);
			}
			copy.setText(text + (!i.getEnabled() ? " (disabled)" : "") + "\t" + text2);
			if (i.getImage() != null) {
				copy.setImage(new Image(i.getDisplay(), i.getImage(), SWT.IMAGE_COPY));
			}
			copy.setSelection(i.getSelection());
			if ((copy.getStyle() & SWT.CASCADE) != 0) {
				player.getEvents().sendEvent(i, SWT.Arm);
				if (i.getMenu() != null) {
					player.getEvents().sendEvent(i.getMenu(), SWT.Show);
					Menu menuCopy = new Menu(copy);
					copyMenuTo(i.getMenu(), menuCopy);
					copy.setMenu(menuCopy);
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void showMenuAt(Event event, Control c, Menu menu) {
		Shell menuShell = new Shell(getShell(c), SWT.NO_TRIM | SWT.TOOL | SWT.MODELESS);
		menuShells.add(menuShell);
		menuShell.setLayout(new FillLayout());
		bar = new Composite(menuShell, SWT.BORDER);
		bar.setLayout(new GridLayout(1, false));
		Color color = c.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		bar.setBackground(color);
		menuShell.setBackground(color);
		for (MenuItem i : menu.getItems()) {
			if (i.getStyle() == SWT.SEPARATOR) {
				Label l = new Label(bar, SWT.SEPARATOR | SWT.HORIZONTAL);
				GridDataFactory.fillDefaults().grab(true, false).span(1, 1).applyTo(l);
				continue;
			}
			Composite line = new Composite(bar, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(3).applyTo(line);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(line);

			Label l = new Label(line, SWT.NONE);
			Image img = i.getImage();
			if (img != null) {
				l.setImage(new Image(c.getDisplay(), img, SWT.IMAGE_COPY));
			}
			Label l2 = new Label(line, SWT.NONE);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(l2);
			String text = "" + (i.getText());
			String text2 = "";
			if (text.contains("\t")) {
				int tabIndex = text.indexOf('\t');
				text2 = text.substring(tabIndex + 1);
				text = text.substring(0, tabIndex);
			}
			l2.setText(text);
			Label l3 = new Label(line, SWT.NONE);
			l3.setText(text2);
			l.setEnabled(i.getEnabled());
			l2.setEnabled(i.getEnabled());
			line.setBackground(color);
			l.setBackground(color);
			l2.setBackground(color);
			l3.setBackground(color);
		}
		Point pos = c.toDisplay(event.x, event.y);
		Point size = bar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		menuShell.setBounds(pos.x, pos.y, size.x + 5, size.y + 5);
		// sh.setMenuBar(bar);
		menuShell.layout();
		menuShell.open();
	}

	private Shell getShell(Widget widget) {
		if (widget instanceof TreeItem) {
			return (((TreeItem) widget).getParent()).getShell();
		}
		if (widget instanceof TableItem) {
			return (((TableItem) widget).getParent()).getShell();
		}
		if (widget instanceof ToolItem) {
			return (((ToolItem) widget).getParent()).getShell();
		}
		if (widget instanceof CoolItem) {
			return (((CoolItem) widget).getParent()).getShell();
		}
		if (widget instanceof ScrollBar) {
			return ((ScrollBar) widget).getParent().getShell();
		}
		if (widget instanceof ToolTip) {
			return (((ToolTip) widget)).getParent();
		}
		if (widget instanceof Control) {
			return ((Control) widget).getShell();
		}
		if (widget instanceof Menu) {
			return ((Menu) widget).getShell();
		}
		if (widget instanceof MenuItem) {
			return ((MenuItem) widget).getParent().getShell();
		}

		return null;
	}

	private synchronized void updateHover(Rectangle bounds, Point point, boolean controlEquals, boolean inactive) {
		if (selectionShell == null || selectionShell.isDisposed()
				|| (selectionShell.getParent() != null && selectionShell.getParent().isDisposed())) {
			selectionShell = null;
			freezedCtrl = null;
			return;
		}
		bounds.width += 6;
		bounds.height += 6;
		int px = point.x - 3;
		int py = point.y - 3;

		Rectangle displayBounds = selectionShell.getDisplay().getBounds();
		if (px + bounds.width > displayBounds.width) {
			bounds.width = displayBounds.width - px;
			if (bounds.width < 0) {
				bounds.width = 1;
			}
		}
		if (py + bounds.height > displayBounds.height) {
			bounds.height = displayBounds.height - py;
			if (bounds.height < 0) {
				bounds.height = 1;
			}
		}
		hookSelectionCanvas(selectionShell, inactive);

		if (!selectionShell.isVisible()) {
			selectionShell.setVisible(true);
			// selectionShell.open();
		}

		selectionShell.moveAbove(null);
		selectionShell.setAlpha(127);
		selectionShell.setBackground(null);

		selectionShell.setBounds(px, py, bounds.width, bounds.height);
		if (!selectionCanvas.isDisposed()) {
			selectionCanvas.setBounds(0, 0, bounds.width, bounds.height);
		}

		selectionShell.redraw();
		if (!selectionCanvas.isDisposed()) {
			selectionCanvas.redraw();
		}



	}

	private synchronized void callCreateHover(final boolean value, Shell parent) {
		if (!menuShells.isEmpty()) {
			return;
		}
		if (selectionShell != null && !selectionShell.isDisposed()
				&& !selectionShell.getDisplay().equals(RWTUtils.findDisplay())) {
			selectionShell.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					selectionShell.dispose();
				}
			});
			lastFocusedWidget = null;
			selectionShell = null;
			widgetsOnMove.clear();
		}
		if (selectionShell != null && selectionShell.isDisposed()) {
			selectionShell = null;
		} else {
			if (selectionShell != null) {
				Composite composite = selectionShell.getParent();
				if (composite != null && composite.isDisposed()) {
					selectionShell = null;
					freezedCtrl = null;
				}
			}
		}
		if (selectionShell == null && value == true) {

			selectionShell = new Shell(SWT.NO_TRIM | SWT.ON_TOP | SWT.TOOL);
			hookSelectionCanvas(selectionShell, false);

			selectionShell.setText("Hover");

		} else if (value == false) {
			if (selectionShell != null) {
				selectionShell.dispose();
				selectionShell = null;
			}
		}
	}

	private void hookSelectionCanvas(final Shell selectionShell, final boolean inactive) {
		if (selectionCanvas != null) {
			selectionCanvas.dispose();
		}

		selectionCanvas = new Canvas(selectionShell, SWT.NONE);
		selectionCanvas.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		WidgetUtil.registerDataKeys("ASSERT_CANVAS");
		selectionCanvas.setData("ASSERT_CANVAS", "true");
		selectionCanvas.addPaintListener(new PaintListener() {
			private static final long serialVersionUID = -1787041824559654007L;

			@Override
			public void paintControl(PaintEvent event) {
				event.gc.setForeground(
						selectionShell.getDisplay().getSystemColor(!inactive ? SWT.COLOR_RED : SWT.COLOR_BLACK));
				event.gc.setLineWidth(2);
				final Rectangle bounds = selectionCanvas.getBounds();

				int m0x = 1;
				int m0y = 1;

				int p0x = 7;
				int p0y = 7;

				event.gc.drawLine(m0x, m0y, p0x + m0x, m0y);
				event.gc.drawLine(m0x, m0y, m0y, m0y + p0y);

				event.gc.drawLine(bounds.width - p0x - m0x, m0y, bounds.width - m0x, m0y);
				event.gc.drawLine(bounds.width - m0x, m0y, bounds.width - m0x, m0y + p0y);

				event.gc.drawLine(bounds.width - m0x, bounds.height - p0y - m0y, bounds.width - m0x,
						bounds.height - m0y);
				event.gc.drawLine(bounds.width - m0x, bounds.height - m0y, bounds.width - p0x - m0x,
						bounds.height - m0y);

				event.gc.drawLine(m0x, bounds.height - m0y - p0y, m0x, bounds.height - m0y);
				event.gc.drawLine(m0x, bounds.height - m0y, m0x + p0x, bounds.height - m0y);
			}
		});
	}

	private void updateHoverAccordingTo(IRecordingDescriber descr, int x, int y) {

		if (selectionShell == null || descr == null) {
		} else {
			Rectangle rectangle = descr.getBounds();
			Point point = descr.getPoint();
			boolean fixed = descr.equals(freezedCtrl);
			if (point != null) {
				boolean isAllowedToSelect = isAllowedToSelect(descr);
				updateHover(rectangle, point, fixed, !isAllowedToSelect);
				if (isAllowedToSelect) {
					descr.setNeedLogging(fixed);
					seachForElement(descr.searchForElement(recorder), fixed, descr);
				}
			}
		}
	}

	private IRecordingDescriber selectAllowedParent(IRecordingDescriber widget) {
		if (widgetClasses.size() == 0) {
			return widget;
		}
		IRecordingDescriber descr = null;
		IRecordingDescriber parent = widget;
		do {
			if (isAllowedToSelect(parent)) {
				return parent;
			}
			descr = parent;
			parent = parent.getParent();
		} while (descr.getWidget() != parent.getWidget());
		return widget;
	}

	private boolean isAllowedToSelect(IRecordingDescriber descr) {
		if (widgetClasses.size() == 0)
			return true;
		return widgetClasses.contains(descr.getWidget().getClass().getCanonicalName());
	}

	private void seachForElement(Element element, boolean fixed, IRecordingDescriber descr) {
		if (element != null) {
			AssertionFocus focus = RawFactory.eINSTANCE.createAssertionFocus();
			// eclipse 3.4 compatibility:
			// EcoreUtil.copy raise exception if argument is null
			focus.setElement(EcoreUtil.copy(element));
			focus.setPointFixed(fixed);
			if (fixed) {
				if (TeslaFeatures.isActivityLogging()) {
					Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "assert properties of element: ");
				}
				if (TeslaFeatures.getInstance().isTrue(IMLFeatures.USE_IMAGING)) {
					Image img = descr.captureImage();
					if (img != null)
						focus.setImageCapture(SWTUIPlayer.captureControlImage(img));
				}
			}
			recorder.safeExecuteCommand(focus);
		}
	}

	@Override
	public void resetAssertSelection() {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.ASSERTIONS, "reset assert target lock");
		}
		freezedCtrl = null;
		lastFocusedWidget = null;
		Display display = RWTUtils.findDisplay();
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				if (selectionShell != null) {
					selectionShell.dispose();
					selectionShell = null;
				}
				selectionShell = new Shell(SWT.NO_TRIM | SWT.ON_TOP | SWT.TOOL);
				hookSelectionCanvas(selectionShell, false);
				selectionShell.setText("Hover");
				disposeMenuPopups();
				clearPopupMenus();
			}
		});
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IRecordingHelper getHelper() {
		return null;
	}

	@Override
	public boolean isSkipEvent(Widget widget, int type, Event event, boolean send) {
		if (event != null && type == SWT.KeyDown) {
			return isShortcutRequest(event, recorder.getAssertModeShortcuts());
		}
		return false;
	}

}
