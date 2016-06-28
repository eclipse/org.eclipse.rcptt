/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.ui.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.EventBuilder;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.swt.dnd.DNDManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.ui.describers.DescriberManager;
import org.eclipse.rcptt.tesla.ui.describers.IWidgetDescriber;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEffect;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class DragSupport {

	private static final int DETAIL = 0;
	private static final int BUTTON = 1;
	private static final int MASK = 2;
	private static final int OPERATIONS = 3;

	private AbstractTeslaClient client;
	private String id;
	private DragSource currentSource;
	private DropTarget currentTarget;
	private Object currentData;
	private Object dataType;
	// private Object types;
	// private int operations;
	private int feedback;
	private Widget currentItem;

	public DragSupport() {
	}

	public String getFeatureID() {
		return id;
	}

	public void initialize(AbstractTeslaClient client, String id) {
		this.client = client;
		this.id = id;
	}

	private static boolean isSourceRelated(DragKind kind) {
		return kind == DragKind.START || kind == DragKind.SET_DATA
				|| kind == DragKind.END;
	}

	private static boolean isTargetRelated(DragKind kind) {
		return !isSourceRelated(kind);
	}

	private int[] parseStyleIntoStates(String style) {
		final int states[] = new int[] { 0, 0, 0, 0 };

		if (style != null) {
			String[] split = style.split(",");
			for (String var : split) {
				String[] strings = var.split(":");
				if (strings[0].equals("detail")) {
					states[DETAIL] = Integer.parseInt(strings[1]);
				}
				if (strings[0].equals("button")) {
					states[BUTTON] = Integer.parseInt(strings[1]);
				}
				if (strings[0].equals("mask")) {
					states[MASK] = Integer.parseInt(strings[1]);
				}
				if (strings[0].equals("operations")) {
					int ops = Integer.parseInt(strings[1]);
					if (ops == -1) {
						if (currentSource != null
								&& !currentSource.isDisposed())
							ops = currentSource.getStyle();
						else
							ops = DND.DROP_NONE | DND.DROP_COPY | DND.DROP_MOVE
									| DND.DROP_LINK;
					}
					states[OPERATIONS] = ops;
				}
			}
		}

		return states;
	}

	private Widget getItem(DropTarget target, Point displayPoint) {
		DropTargetEffect effect = target.getDropTargetEffect();
		if (effect == null)
			return null;
		return effect.getItem(displayPoint.x, displayPoint.y);
	}

	public Response handleUniversalDrag(final DragCommand command) {
		Response response = RawFactory.eINSTANCE.createResponse();

		SWTUIProcessor processor = client.getProcessor(SWTUIProcessor.class);
		SWTUIElement swtuiElement = processor.getMapper().get(
				command.getElement());
		Widget widget = PlayerWrapUtils.unwrapWidget(swtuiElement);
		if (!(widget instanceof Control)) {
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage("Widget is not a control.");
			return response;
		}
		final Control control = (Control) widget;

		getPlayer().exec("DND", new Runnable() {
			@Override
			public void run() {
				DNDEventAdapter a;

				Integer x = command.getX(), y = command.getY();
				Rectangle bounds = control.getBounds();
				Point clientPoint = new Point(x == null ? bounds.width / 2 : x,
						y == null ? bounds.height / 2 : y);
				Point displayPoint = control.toDisplay(clientPoint);

				int[] states = parseStyleIntoStates(command.getStyle());
				switch (command.getKind()) {
				case START:
					control.forceFocus();
					currentSource = getDragSource(control);
					a = createDNDEvent(DND.DragStart, currentSource,
							clientPoint, states, null);
					currentSource.notifyListeners(DND.DragStart,
							(Event) a.getEvent());
					break;
				case ENTER:
					currentTarget = getDropTarget(control);
					a = createDNDEvent(DND.DragEnter, currentTarget,
							displayPoint, states,
							getItem(currentTarget, displayPoint));
					currentTarget.notifyListeners(DND.DragEnter,
							(Event) a.getEvent());
					updateInfo(a);
					break;
				case OVER:
					currentTarget = getDropTarget(control);
					a = createDNDEvent(DND.DragOver, currentTarget,
							displayPoint, states,
							getItem(currentTarget, displayPoint));
					currentTarget.notifyListeners(DND.DragOver,
							(Event) a.getEvent());
					updateInfo(a);
					break;
				case LEAVE:
					currentTarget = getDropTarget(control);
					a = createDNDEvent(DND.DragLeave, currentTarget,
							displayPoint, states, currentItem);
					currentTarget.notifyListeners(DND.DragLeave,
							(Event) a.getEvent());
					break;
				case ACCEPT:
					currentTarget = getDropTarget(control);
					a = createDNDEvent(DND.DropAccept, currentTarget,
							displayPoint, states,
							getItem(currentTarget, displayPoint));
					currentTarget.notifyListeners(DND.DropAccept,
							(Event) a.getEvent());
					break;
				case SET_DATA:
					doDragSetData(control, clientPoint, states);
					break;
				case DROP:
					currentTarget = getDropTarget(control);
					a = createDNDEvent(DND.Drop, currentTarget, displayPoint,
							states, getItem(currentTarget, displayPoint));
					new EventBuilder((Event) a.getEvent()).data(currentData)
							.send(currentTarget);
					break;
				case END:
					currentSource = getDragSource(control);
					a = createDNDEvent(DND.DragEnd, currentSource, clientPoint,
							states, null);
					currentSource.notifyListeners(DND.DragEnd,
							(Event) a.getEvent());
					break;
				}
			}
		});

		return response;
	}

	public Response handleDrag(final DragCommand command) {
		IWidgetDescriber describer = DescriberManager.getDescriber(
				command.getElement(), client);

		if (describer == null)
			return reportFailed("Failed to locate element for drag");

		if (!describer.supportsDND()) {
			Widget commandWidget = describer.getWidget();
			if (((isSourceRelated(command.getKind()) && getDragSource(commandWidget) != null)
					|| (isTargetRelated(command
							.getKind()) && getDropTarget(commandWidget) != null))) {
				return handleUniversalDrag(command);
			}
		}

		Point point = describer.getRealPoint();
		if (point == null)
			return reportFailed("Failed to locate element for drag");

		Integer x = command.getX(), y = command.getY();
		point.x += x == null ? describer.getBounds().width / 2 : x;
		point.y += y == null ? y = describer.getBounds().height / 2 : y;

		Control widget = (Control) describer.getControl().getWidget();
		if (command.getKind().equals(DragKind.START)
				|| command.getKind().equals(DragKind.SET_DATA)
				|| command.getKind().equals(DragKind.END)) {
			point = widget.toControl(point);
		}
		if (point == null) {
			return RawFactory.eINSTANCE.createResponse();
		}
		final Point destinationPoint;
		final IWidgetDescriber controlDescriber = describer.getControl();

		final IWidgetDescriber itemDescriber;
		if (controlDescriber.equals(describer)) {
			itemDescriber = null;
		} else {
			itemDescriber = describer;
		}
		if (command.getKind().equals(DragKind.LEAVE)) {
			point = new Point(0, 0);
		}
		// TODO: I suppose we need to correct point if we miss destination
		// widget
		destinationPoint = point;
		// }

		final int states[] = parseStyleIntoStates(command.getStyle());
		switch (command.getKind()) {
		case ACCEPT:
		case DROP:
		case ENTER:
		case OVER: {
			currentTarget = getDropTarget(controlDescriber.getWidget());
			if (currentTarget == null) {
				Response response = RawFactory.eINSTANCE.createResponse();
				response.setStatus(ResponseStatus.FAILED);
				StringBuilder msg = new StringBuilder();
				msg.append("Failed to locate drag target.\n");
				msg.append("Widget selected as target is:"
						+ describer.getWidget().getClass().getName());
				response.setMessage(msg.toString());
				return response;
			}
		}
		}
		getPlayer().exec("DND", new Runnable() {

			@Override
			public void run() {
				if (itemDescriber != null) {
					showItemBeforeDrag(itemDescriber);
				}
				switch (command.getKind()) {
				case DETECT: {
					doDragDetect(controlDescriber, destinationPoint);
					break;
				}
				case START: {
					doDragStart(controlDescriber, destinationPoint, states);
					break;
				}
				case ACCEPT: {
					doDragAccept(controlDescriber, itemDescriber,
							destinationPoint, states);
					break;
				}
				case DROP: {
					doDrop(controlDescriber, itemDescriber, destinationPoint,
							states);
					break;
				}
				case OVER: {
					doDragOver(controlDescriber, itemDescriber,
							destinationPoint, states);
					break;
				}
				case ENTER: {
					doDragEnter(controlDescriber, itemDescriber,
							destinationPoint, states);
					break;
				}
				case LEAVE: {
					doDragLeave(destinationPoint, states);
					break;
				}
				case END: {
					doDragEnd(controlDescriber, destinationPoint, states);
					break;
				}
				case SET_DATA: {
					doDragSetData(controlDescriber.getWidget(),
							destinationPoint, states);
					break;
				}
				}
			}

		});
		return RawFactory.eINSTANCE.createResponse();
	}

	private void doDragDetect(IWidgetDescriber controlDescriber,
			Point destinationPoint) {
		Widget widget = controlDescriber.getWidget();
		if (widget instanceof Control) {
			((Control) widget).forceFocus();
		}
		getPlayer().getEvents().sendEvent(widget, SWT.DragDetect,
				destinationPoint.x, destinationPoint.y, 1);
	}

	private void doDragStart(IWidgetDescriber controlDescriber,
			Point destinationPoint, int[] states) {
		currentSource = getDragSource(controlDescriber.getWidget());

		currentSource.getControl().forceFocus();
		DNDEventAdapter event = createDNDEvent(destinationPoint, states,
				DND.DragStart);
		TeslaEventManager.getManager().setForceFocusControl(
				currentSource.getControl());
		getPlayer().getEvents().sendEvent(currentSource,
				(Event) event.getEvent());
		TeslaEventManager.getManager().setForceFocusControl(null);
	}

	private void doDragAccept(IWidgetDescriber controlDescriber,
			IWidgetDescriber itemDescriber, Point destinationPoint, int[] states) {
		currentTarget = getDropTarget(controlDescriber.getWidget());
		if (currentTarget != null) {
			DNDEventAdapter adapter = createDNDEvent(destinationPoint, states,
					DND.DropAccept);
			Event e = (Event) adapter.getEvent();
			if (itemDescriber != null) {
				e.item = itemDescriber.getItemWidget();
			}
			currentTarget.getControl().forceFocus();
			getPlayer().getEvents().sendEvent(currentTarget,
					(Event) adapter.getEvent());
		}
	}

	private void doDrop(IWidgetDescriber controlDescriber,
			IWidgetDescriber itemDescriber, Point destinationPoint, int[] states) {

		if (currentSource != null) {
			Transfer[] transfers = currentSource.getTransfer();
			if (transfers != null)
				for (Transfer t : transfers)
					if (t.getClass()
							.getName()
							.equals("org.eclipse.emf.edit.ui.dnd.LocalTransfer")) {
						TeslaSWTAccess.setField(t, "object", currentData);
					}
		}

		currentTarget = getDropTarget(controlDescriber.getWidget());
		if (currentTarget != null) {
			DNDEventAdapter adapter = createDNDEvent(destinationPoint, states,
					DND.Drop);
			Event e = (Event) adapter.getEvent();
			if (itemDescriber != null) {
				e.item = itemDescriber.getItemWidget();
			}
			e.data = currentData;
			currentTarget.getControl().forceFocus();
			getPlayer().getEvents().sendEvent(currentTarget,
					(Event) adapter.getEvent());
		}
	}

	private void doDragOver(IWidgetDescriber controlDescriber,
			IWidgetDescriber itemDescriber, Point destinationPoint, int[] states) {
		currentTarget = getDropTarget(controlDescriber.getWidget());
		if (currentTarget != null) {
			DNDEventAdapter adapter = createDNDEvent(destinationPoint, states,
					DND.DragOver);
			Event e = (Event) adapter.getEvent();
			if (itemDescriber != null) {
				e.item = itemDescriber.getItemWidget();
			}
			currentTarget.getControl().forceFocus();
			getPlayer().getEvents().sendEvent(currentTarget,
					(Event) adapter.getEvent());
			updateInfo(adapter);
		}
	}

	private void doDragEnter(IWidgetDescriber controlDescriber,
			IWidgetDescriber itemDescriber, Point destinationPoint, int[] states) {
		currentTarget = getDropTarget(controlDescriber.getWidget());
		if (currentTarget != null) {
			DNDEventAdapter adapter = createDNDEvent(destinationPoint, states,
					DND.DragEnter);
			Event e = (Event) adapter.getEvent();
			if (itemDescriber != null) {
				e.item = itemDescriber.getItemWidget();
			}
			currentTarget.getControl().forceFocus();
			getPlayer().getEvents().sendEvent(currentTarget,
					(Event) adapter.getEvent());
			updateInfo(adapter);
		}
	}

	private void doDragLeave(Point destinationPoint, int[] states) {
		if (currentTarget != null) {
			DNDEventAdapter adapter = createDNDEvent(destinationPoint, states,
					DND.DragLeave);
			currentTarget.getControl().forceFocus();
			getPlayer().getEvents().sendEvent(currentTarget,
					(Event) adapter.getEvent());
		}
	}

	private void doDragEnd(IWidgetDescriber controlDescriber,
			Point destinationPoint, int[] states) {
		DragSource source = getDragSource(controlDescriber.getWidget());
		DNDEventAdapter adapter = createDNDEvent(destinationPoint, states,
				DND.DragEnd);
		source.getControl().forceFocus();
		getPlayer().getEvents().sendEvent(source, (Event) adapter.getEvent());
	}

	private void doDragSetData(Widget widget, Point point, int[] states) {
		currentSource = getDragSource(widget);
		boolean isDataTypeSupported = false;
		if (dataType instanceof TransferData) {
			Transfer[] transfers = currentTarget.getTransfer();
			for (Transfer transfer : transfers) {
				if (transfer.isSupportedType((TransferData) dataType)) {
					isDataTypeSupported = true;
					break;
				}
			}

		}
		if (!isDataTypeSupported) {
			if (currentTarget != null) {
				List<Transfer> fromTransfer = Arrays.asList(currentSource
						.getTransfer());
				Transfer[] transfer = currentTarget.getTransfer();
				for (Transfer t : transfer) {
					if (fromTransfer.contains(t)) {
						TransferData[] supportedTypes = t.getSupportedTypes();
						for (TransferData td : supportedTypes) {
							dataType = td;
							break;
						}
						break;
					}
				}
			}
		}

		if (dataType == null) {
			TeslaCore.log("Failed to locate transfer for D&D ");
		}
		DNDEventAdapter event = createDNDEvent(point, states, DND.DragSetData);
		// currentSource.getControl().forceFocus();
		getPlayer().getEvents().sendEvent(currentSource,
				(Event) event.getEvent());
		Event e = (Event) event.getEvent();
		currentData = e.data;
	}

	private void showItemBeforeDrag(IWidgetDescriber itemDescriber) {
		if (itemDescriber.getWidget() instanceof TableItem) {
			TableItem tableItem = (TableItem) itemDescriber.getWidget();
			tableItem.getParent().showItem(tableItem);
		} else if (itemDescriber.getWidget() instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) itemDescriber.getWidget();
			treeItem.getParent().showItem(treeItem);
		}
	}

	private void updateInfo(DNDEventAdapter event) {
		dataType = event.getDataType();
		// types = event.getDataTypes();
		// operations = event.getOperations();
		feedback = event.getFeedback();
		currentItem = ((Event) event.getEvent()).item;
	}

	private DNDEventAdapter createDNDEvent(int kind, Widget widget,
			Point point, int[] states, Widget item) {
		DNDEventAdapter a = createDNDEvent(point, states, kind);
		Event e = (Event) a.getEvent();
		e.widget = widget;
		e.item = item;
		return a;
	}

	private DNDEventAdapter createDNDEvent(Point point, int[] states, int kind) {
		DNDEventAdapter adapter = DNDEventAdapter.createAdapter();
		new EventBuilder((Event) adapter.getEvent()).widget(currentSource)
				.xy(point).type(kind).button(states[BUTTON])
				.stateMask(states[MASK]).detail(states[DETAIL]).doit(true);
		if (currentSource != null) {
			Transfer[] transfer = currentSource.getTransfer();
			List<TransferData> resultDatas = new ArrayList<TransferData>();
			for (Transfer transfer2 : transfer) {
				resultDatas
						.addAll(Arrays.asList(transfer2.getSupportedTypes()));
			}
			adapter.setDataTypes(resultDatas
					.toArray(new TransferData[resultDatas.size()]));
		}
		adapter.setOperations(states[OPERATIONS]);
		adapter.setDataType(dataType);
		adapter.setFeedback(feedback);
		return adapter;
	}

	private DropTarget getDropTarget(Widget widget) {
		List<DropTarget> targets = DNDManager.getInstance().getTargets();
		for (DropTarget dropTarget : targets) {
			if (dropTarget.getControl().equals(widget)) {
				return dropTarget;
			}
		}
		return currentTarget;
	}

	private DragSource getDragSource(Widget widget) {
		List<DragSource> sources = DNDManager.getInstance().getSources();
		for (DragSource dragSource : sources) {
			if (dragSource.getControl().equals(widget)) {
				return dragSource;
			}
		}
		return null;
	}

	private SWTUIPlayer getPlayer() {
		return client.getProcessor(SWTUIProcessor.class).getPlayer();
	}

	private Response reportFailed(String msg) {
		BooleanResponse response = ProtocolFactory.eINSTANCE
				.createBooleanResponse();
		response.setMessage(msg);
		response.setStatus(ResponseStatus.FAILED);
		return response;
	}
}
