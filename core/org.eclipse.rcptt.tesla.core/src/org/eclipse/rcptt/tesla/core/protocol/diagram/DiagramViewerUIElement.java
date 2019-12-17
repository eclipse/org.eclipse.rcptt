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
package org.eclipse.rcptt.tesla.core.protocol.diagram;

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class DiagramViewerUIElement extends FigureUIElement {
	
	public DiagramViewerUIElement(Element e, UIPlayer player) {
		super(e, player);
	}

	public void assertFigureExists(List<Integer> address) {
		AssertFigureExists fec = DiagramFactory.eINSTANCE
				.createAssertFigureExists();
		fec.setElement(getElement());
		fec.getPartPath().addAll(address);
		player.safeExecuteCommand(fec);
	}	
}
