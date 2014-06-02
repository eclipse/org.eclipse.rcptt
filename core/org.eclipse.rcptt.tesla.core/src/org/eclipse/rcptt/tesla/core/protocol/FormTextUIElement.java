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

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class FormTextUIElement extends ControlUIElement {

	public UISelector<ControlUIElement> link;

	public FormTextUIElement(Element e, UIPlayer player) {
		super(e, player);
		link = new UISelector<ControlUIElement>(ElementKind.Link, player,
				ControlUIElement.class).parent(element);
	}

	public ControlUIElement link() {
		return link.find();
	}

	public ControlUIElement link(String text) {
		return link.find(text);
	}

	public ControlUIElement link(int index) {
		return link.find(index);
	}

}
