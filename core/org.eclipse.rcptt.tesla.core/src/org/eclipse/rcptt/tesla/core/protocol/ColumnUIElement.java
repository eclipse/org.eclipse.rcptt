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

public class ColumnUIElement extends BasicUIElement {

	public ColumnUIElement(Element e, UIPlayer player) {
		super(e, player);
	}

	//

	public void setWidth(int width) {
		SetWidth c = ProtocolFactory.eINSTANCE.createSetWidth();
		c.setElement(getElement());
		c.setWidth(width);
		player.safeExecuteCommand(c);
	}

	public void setPosition(int index) {
		SetPosition c = ProtocolFactory.eINSTANCE.createSetPosition();
		c.setElement(getElement());
		c.setIndex(index);
		player.safeExecuteCommand(c);
	}

}
