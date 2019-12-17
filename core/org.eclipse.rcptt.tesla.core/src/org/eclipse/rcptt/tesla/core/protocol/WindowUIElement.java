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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class WindowUIElement extends CompositeUIElement
		implements
		IWindowProvider {
	UISelector<WindowUIElement> window;

	public WindowUIElement(Element e, UIPlayer player) {
		super(e, player);
		window = new UISelector<WindowUIElement>(ElementKind.Window, player,
				WindowUIElement.class).parent(element);
	}

	public WindowUIElement window() {
		return window.find();
	}

	public WindowUIElement window(String pattern) {
		return window.find(pattern);
	}

	public WindowUIElement window(String pattern, int index) {
		return window.find(pattern, index);
	}

	public WindowUIElement fromedWindow(String from) {
		return window.path(FROM_PATH_MARK, from).find();
	}

	public WindowUIElement fromedWindow(String from, int index) {
		return window.path(FROM_PATH_MARK, from).find(index);
	}

	public WindowUIElement classedWindow(String klass) {
		return window.path(CLASS_PATH_MARK, klass).find();
	}

	public WindowUIElement classedWindow(String klass, int index) {
		return window.path(CLASS_PATH_MARK, klass).find(index);
	}
}
