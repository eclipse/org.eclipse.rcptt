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
package org.eclipse.rcptt.tesla.properties.view;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.Click;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.player.AbstractSWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.WorkbenchUIElement;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.internal.WorkbenchPartReference;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyComposite;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList;

@SuppressWarnings("restriction")
public class PropertiesViewProcessor implements ITeslaCommandProcessor {

	private AbstractTeslaClient client;
	private SWTUIProcessor swtUIProcessor;

	private ISWTUIPlayerExtension extension = new AbstractSWTUIPlayerExtension() {
		@Override
		public GenericElementKind getKind(Object w) {
			if (w instanceof TabbedPropertyList.ListElement)
				return new GenericElementKind(ElementKind.PropertyTab);
			return null;
		}
	};

	public int getPriority() {
		return 125;
	}

	public PropertiesViewProcessor() {
		SWTUIPlayer.addExtension(extension);
	}

	public String getFeatureID() {
		return "swt.properties.view";
	}

	public boolean isSelectorSupported(String kind) {
		return kind.equals(ElementKind.PropertyTab.name());
	}

	public SelectResponse select(SelectCommand cmd, ElementGenerator generator,
			IElementProcessorMapper mapper) {
		if (!cmd.getData().getKind().equals(ElementKind.PropertyTab.name()))
			return null;

		SWTUIElement swtuiElement = getSWTUIProcessor().getMapper().get(
				cmd.getData().getParent());
		if (swtuiElement == null)
			return selectError("Unable to resolve parent element (SWTUIElement).");

		if (!(swtuiElement instanceof WorkbenchUIElement))
			return selectError("Unable to resolve parent element (WorkbenchUIElement).");

		WorkbenchUIElement workbenchUIElement = (WorkbenchUIElement) swtuiElement;
		IWorkbenchPartReference iWorkbenchPartReference = workbenchUIElement
				.getReference();
		if (!(iWorkbenchPartReference instanceof WorkbenchPartReference))
			return selectError("Unable to resolve parent element (WorkbenchPartReference).");

		WorkbenchPartReference workbenchPartReference = (WorkbenchPartReference) iWorkbenchPartReference;
		final Control control = workbenchPartReference.getPane().getControl();
		if (control == null || !(control instanceof Composite))
			return selectError("Unable to resolve parent element (Control).");

		final String text = cmd.getData().getPattern();
		final AtomicReference<Object> tab = new AtomicReference<Object>();
		control.getDisplay().syncExec(new Runnable() {
			public void run() {
				final TabbedPropertyComposite tabbedPropertyComposite = findVisibleChild(
						TabbedPropertyComposite.class, (Composite) control);
				if (tabbedPropertyComposite == null)
					return;

				TabbedPropertyList list = tabbedPropertyComposite.getList();
				int i = 0;
				while (true) { // we do not know item count ahead
					Object e = list.getElementAt(i);

					if (e == null)
						break;

					if (e instanceof TabbedPropertyList.ListElement) {
						TabbedPropertyList.ListElement listElement = (TabbedPropertyList.ListElement) e;
						if (listElement.getTabItem().getText().equals(text)) {
							tab.set(listElement);
							break;
						}
					}

					++i;
				}
			}
		});

		if (tab.get() == null)
			return selectError("Property tab \"%s\" is not found.", text);

		swtuiElement = getSWTUIProcessor().getPlayer().wrap(tab.get());
		Element element = getSWTUIProcessor().getMapper().get(swtuiElement);

		SelectResponse selectResponse = ProtocolFactory.eINSTANCE
				.createSelectResponse();
		selectResponse.getElements().add(element);

		return selectResponse;
	}

	public boolean isCommandSupported(Command cmd) {
		return cmd instanceof Click;
	}

	public Response executeCommand(Command command,
			IElementProcessorMapper mapper) {
		if (!(command instanceof Click))
			return null;

		Click click = (Click) command;
		SWTUIElement swtuiElement = getSWTUIProcessor().getMapper().get(
				click.getElement());
		Widget widget = swtuiElement.widget;
		if (!(widget instanceof TabbedPropertyList.ListElement))
			return executeError("Unsupported widget class \"%s\".", widget
					.getClass().getName());

		TabbedPropertyList.ListElement listElement = (TabbedPropertyList.ListElement) widget;

		final TabbedPropertyComposite tabbedPropertyComposite = findParent(
				TabbedPropertyComposite.class, listElement);
		if (tabbedPropertyComposite == null)
			return executeError("Tabbed property composite is not found.");

		final TabbedPropertyList tabbedPropertyList = tabbedPropertyComposite
				.getList();
		int i = 0;
		while (true) { // we do not know item count ahead
			Object e = tabbedPropertyList.getElementAt(i);
			if (e == listElement) {
				final int index = i;
				final AtomicBoolean success = new AtomicBoolean(false);
				tabbedPropertyList.getDisplay().syncExec(new Runnable() {
					public void run() {
						if (tabbedPropertyComposite.isVisible()) {
							TeslaSWTAccess.callMethod(TabbedPropertyList.class,
									tabbedPropertyList, "select",
									new Class[] { int.class }, index);
							success.set(true);
						}
					}
				});
				if (success.get())
					return executeSuccess();
				else
					return executeError("Property tab \"%s\" is not visible.",
							listElement.getTabItem().getText());
			}

			if (e == null)
				break;

			++i;
		}

		return executeError("Property tab \"%s\" is not found.", listElement
				.getTabItem().getText());
	}

	public PreExecuteStatus preExecute(Command command,
			PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	public void initialize(AbstractTeslaClient client, String id) {
		this.client = client;
	}

	public void postSelect(Element element, IElementProcessorMapper mapper) {
	}

	public boolean isInactivityRequired() {
		return false;
	}

	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		return true;
	}

	public void clean() {
	}

	public void terminate() {
		SWTUIPlayer.removeExtension(extension);
	}

	public void checkHang() {
	}

	public void collectInformation(AdvancedInformation information,
			Command lastCommand) {
	}

	public void notifyUI() {
	}

	// --

	private SWTUIProcessor getSWTUIProcessor() {
		if (swtUIProcessor == null) {
			swtUIProcessor = client.getProcessor(SWTUIProcessor.class);
		}
		return swtUIProcessor;
	}

	@SuppressWarnings("unused")
	private static Status error(String message, Object... args) {
		return new Status(Status.ERROR, PropertiesViewPlugin.PLUGIN_ID,
				String.format(message, args));
	}

	private static SelectResponse selectError(String message, Object... args) {
		SelectResponse selectResponse = ProtocolFactory.eINSTANCE
				.createSelectResponse();
		selectResponse.setStatus(ResponseStatus.FAILED);
		selectResponse.setMessage(String.format(message, args));
		return selectResponse;
	}

	private static Response executeError(String message, Object... args) {
		Response response = RawFactory.eINSTANCE.createResponse();
		response.setStatus(ResponseStatus.FAILED);
		response.setMessage(String.format(message, args));
		return response;
	}

	private static Response executeSuccess() {
		Response response = RawFactory.eINSTANCE.createResponse();
		response.setStatus(ResponseStatus.OK);
		return response;
	}

	private static <T> T findVisibleChild(Class<T> class_, Composite parent) {
		for (Control c : parent.getChildren()) {
			if (class_ == c.getClass() && c.isVisible())
				return class_.cast(c);
			else if (c instanceof Composite) {
				T result = findVisibleChild(class_, (Composite) c);
				if (result != null)
					return result;
			}
		}
		return null;
	}

	private static <T> T findParent(Class<T> class_, Control child) {
		do {
			child = child.getParent();
			if (child.getClass() == class_)
				return class_.cast(child);
		} while (child != null);

		return null;
	}
}
