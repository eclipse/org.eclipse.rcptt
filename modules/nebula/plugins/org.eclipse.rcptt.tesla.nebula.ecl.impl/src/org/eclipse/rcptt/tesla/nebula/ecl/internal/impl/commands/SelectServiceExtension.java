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
package org.eclipse.rcptt.tesla.nebula.ecl.internal.impl.commands;

import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds.GRID;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;

import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.Select;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;

public class SelectServiceExtension extends NebulaActionService implements IScriptletExtension {

	@Override
	public boolean canHandle(Command c) {
		if (c instanceof Select) {
			Select s = (Select) c;

			// handle only the item part selection case
			ControlHandler control = s.getControl();
			if (GRID.equals(control.getCustomKindId())) {
				List<Object> items = s.getItems();
				// checking only the first item, assuming all of them to be parts;
				// mixed items & parts are not supported
				return (items.size() >= 1) && isItemPart(items.get(0));
			}
		}
		return false;
	}

	@Override
	protected Object exec(Command c) throws CoreException {
		Select s = (Select) c;
		
		List<Object> items = s.getItems();
		Assert.isTrue(items.size() >= 1); // should be checked in #canHandle
	
		List<MultiSelectionItemEx> msies = new ArrayList<MultiSelectionItemEx>(items.size());
		for (Object it : items) {
			if (!isItemPart(it))
				throwMixedViolation();

			ControlHandler part = (ControlHandler) it;
			msies.add(msieFromControlHandler(part));
		}
			
		getNebulaGridUIElement(s.getControl()).setMultiSelectionEx(msies);

		return s.getControl();
	}



}
