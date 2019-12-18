/*******************************************************************************
 * Copyright (c) 2009, 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import static org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin.err;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.tesla.core.protocol.GetItems;
import org.eclipse.rcptt.tesla.core.protocol.GetItemsResponse;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.ecl.impl.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.GetComboItems;

public class GetComboItemsService extends AbstractActionService {

	@Override
	protected Object exec(final Command command) throws CoreException {
		final GetComboItems gci = (GetComboItems) command;
		final Element element = TeslaBridge.find(gci.getControl(), getContext());

		final GetItems getItems = ProtocolFactory.eINSTANCE.createGetItems();
		getItems.setElement(element);
		final Response response = TeslaBridge.getPlayer().safeExecuteCommand(getItems);
		if (!(response instanceof GetItemsResponse) || response.getStatus().equals(ResponseStatus.FAILED)) {
			String errorMessage = response.getMessage() == null
					? "Failed to get combobox items"
					: String.format("Failed to get combobox items: %s", response.getMessage());
			throw new CoreException(err(errorMessage));
		}
		
		final GetItemsResponse getItemsResponse = (GetItemsResponse) response;		
		for (String item : getItemsResponse.getResult()) {
			getContext().getOutput().write(item);
		}
		return null; // prevents writing to output pipe
	}

}
