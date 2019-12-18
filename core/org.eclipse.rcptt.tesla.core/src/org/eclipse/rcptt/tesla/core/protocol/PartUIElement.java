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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class PartUIElement extends CompositeUIElement {

	private static class Selectors {
		public UISelector<CompositeUIElement> propertyTab;
	}

	private final Selectors selector = new Selectors();

	public PartUIElement(Element e, UIPlayer player) {
		super(e, player);
		selector.propertyTab = new UISelector<CompositeUIElement>(
				ElementKind.PropertyTab, player, CompositeUIElement.class)
				.parent(element);
	}

	public CompositeUIElement propertyTab(String pattern) {
		return selector.propertyTab.find(pattern);
	}

}
