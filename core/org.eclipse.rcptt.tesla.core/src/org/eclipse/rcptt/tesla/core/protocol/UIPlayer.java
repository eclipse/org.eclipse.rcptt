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
package org.eclipse.rcptt.tesla.core.protocol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public abstract class UIPlayer implements IUIPlayer, IWindowProvider {
	static class Selector {
		UISelector<WindowUIElement> window;
		UISelector<WindowUIElement> eclipseWindow;
	};

	public abstract Response executeCommand(Command command) throws IOException;

	Selector selector = new Selector();
	private List<Response> failures = new ArrayList<Response>();
	private static ProtocolFactory factory = ProtocolFactory.eINSTANCE;

	public UIPlayer() {
		selector.window = new UISelector<WindowUIElement>(ElementKind.Window,
				this, WindowUIElement.class);
		selector.eclipseWindow = new UISelector<WindowUIElement>(
				ElementKind.EclipseWindow, this, WindowUIElement.class);
	}

	public WindowUIElement window() {
		return selector.window.find();
	}

	public WindowUIElement window(String pattern) {
		return selector.window.find(pattern);
	}

	public WindowUIElement window(String pattern, int index) {
		return selector.window.find(pattern, index);
	}

	public WindowUIElement fromedWindow(String from) {
		return selector.window.path(FROM_PATH_MARK, from).find();
	}

	public WindowUIElement fromedWindow(String from, int index) {
		return selector.window.path(FROM_PATH_MARK, from).find(index);
	}

	public WindowUIElement classedWindow(String klass) {
		return selector.window.path(CLASS_PATH_MARK, klass).find();
	}

	public WindowUIElement classedWindow(String klass, int index) {
		return selector.window.path(CLASS_PATH_MARK, klass).find(index);
	}

	public WindowUIElement eclipseWindow() {
		return selector.eclipseWindow.find();
	}

	public WindowUIElement eclipseWindow(int index) {
		return selector.eclipseWindow.find(index);
	}

	/**
	 * Retrieve failures list, and clear it
	 * 
	 * @return
	 */
	public List<Response> getFailures() {
		List<Response> oldFailures = failures;
		failures = new ArrayList<Response>();
		return oldFailures;
	}

	public Response safeExecuteCommand(Command command) {
		try {

			Response response = executeCommand(command);
			if (response != null
					&& !response.getStatus().equals(ResponseStatus.OK)) {
				failures.add(response);
			}
			return response;
		} catch (Throwable e) {
			if (e.getMessage() != null
					&& !e.getMessage().contains("socket closed")) {
				TeslaCore.log(e);
			}
			handleFailure(e);
		}
		return null;
	}

	protected void handleFailure(Throwable e) {
	}

	public void nop() {
		Nop nop = factory.createNop();
		safeExecuteCommand(nop);
		this.clearFailures();
	}

	public void shutdown() {
		// Shutdown shutdown = factory.createShutdown();
		// safeExecuteCommand(shutdown);
		failures.clear();
	}

	public void closeWorkspace() {
		CloseWorkbench closeWorkbench = factory.createCloseWorkbench();
		safeExecuteCommand(closeWorkbench);
	}

	public void clearFailures() {
		failures.clear();
	}
}
