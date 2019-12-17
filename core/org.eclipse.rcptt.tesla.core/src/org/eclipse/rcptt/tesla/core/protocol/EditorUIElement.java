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
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;

public class EditorUIElement extends PartUIElement {

	public EditorUIElement(Element e, UIPlayer player) {
		super(e, player);
	}

	public void save() {
		Save save = factory.createSave();
		save.setElement(getElement());
		Response response = player.safeExecuteCommand(save);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return;
		}
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute save");
		}
	}

	public boolean isDirty() {
		IsDirty isDirty = factory.createIsDirty();
		isDirty.setElement(getElement());
		BooleanResponse response = (BooleanResponse) player
				.safeExecuteCommand(isDirty);
		player.clearFailures();
		if (!response.getStatus().equals(ResponseStatus.OK)) {
			throw new RuntimeException("Failed to execute save");
		}
		return response.isResult();
	}

}
