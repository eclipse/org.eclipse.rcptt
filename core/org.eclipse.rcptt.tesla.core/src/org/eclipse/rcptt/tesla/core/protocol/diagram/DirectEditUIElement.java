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

import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.TextUIElement;
import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class DirectEditUIElement extends ControlUIElement {

	public DirectEditUIElement(Element e, UIPlayer player) {
		super(e, player);
	}

	public void cancelDirectEdit() {
		CancelDirectEdit cmd = DiagramFactory.eINSTANCE
				.createCancelDirectEdit();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void commitDirectEdit() {
		CommitDirectEdit cmd = DiagramFactory.eINSTANCE
				.createCommitDirectEdit();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void setText(String value) {
		setText(value, true);
	}

	public void setText(String value, Boolean commit) {
		if (this.isKind(ElementKind.Text)) {
			TextUIElement e = new TextUIElement(this.getElement(), player);
			e.setText(value);
			if (commit) {
				commitDirectEdit();
			}
		}
	}
}
