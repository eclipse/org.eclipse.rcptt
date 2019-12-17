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
package org.eclipse.rcptt.tesla.nebula.ecl.internal.impl.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;

import org.eclipse.rcptt.tesla.ecl.impl.ServiceUtil;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;

public class SelectGridRangeService extends NebulaActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		if (!(command instanceof SelectGridRange))
			throw new IllegalArgumentException("this service is only for SelectGridRange scriptlet");

		SelectGridRange s = (SelectGridRange) command;
		if (!NebulaElementKinds.GRID.equals(s.getControl().getCustomKindId()))
			throw new IllegalArgumentException("SelectGridRange is only applicable for Nebula Grid");
		
		//
		
		if (isItemPart(s.getFrom())) {
			if (!isItemPart(s.getTo()))
				throwMixedViolation();
			// item parts

			MultiSelectionItemEx from = msieFromControlHandler((ControlHandler) s.getFrom());
			MultiSelectionItemEx to = msieFromControlHandler((ControlHandler) s.getTo());

			getNebulaGridUIElement(s.getControl()).setSelectionRange(from, to);
		} else {
			if (isItemPart(s.getTo()))
				throwMixedViolation();
			// paths or items

			List<String> fromPath = ServiceUtil.processSelectItems(s.getFrom(), null);
			List<String> toPath = ServiceUtil.processSelectItems(s.getTo(), null);

			getNebulaGridUIElement(s.getControl()).setSelectionRange(fromPath, toPath);
		}

		return s.getControl();
	}

}
