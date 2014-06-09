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
package org.eclipse.rcptt.tesla.nebula.ecl.internal.impl.commands;

import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds.ITEM_CELL;
import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds.ROW_HEADER;

import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.core.protocol.nebula.NebulaGridUIElement;
import org.eclipse.rcptt.tesla.ecl.impl.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.tesla.nebula.ecl.impl.Activator;
import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaFactory;

public abstract class NebulaActionService extends AbstractActionService {


	//

	protected static boolean isItemPart(Object o) {
		if (o instanceof ControlHandler) {
			String kind = ((ControlHandler) o).getCustomKindId();
			return ROW_HEADER.equals(kind) || ITEM_CELL.equals(kind);
		}
		return false;
	}
	
	protected static NebulaGridUIElement getNebulaGridUIElement(ControlHandler control) throws CoreException {
		NebulaGridUIElement element = new NebulaGridUIElement(TeslaBridge.find(control), TeslaBridge.getPlayer());
		TeslaBridge.storeLastControlUIElement(element);
		return element;
	}
	
	protected static MultiSelectionItemEx msieFromControlHandler(ControlHandler part) throws CoreException {
		ControlHandler item = part.getParent();
		String[] itemPath = TeslaBridge.parsePath(item.getPath()).toArray(new String[] {});

		MultiSelectionItemEx msie = NebulaFactory.eINSTANCE.createMultiSelectionItemEx();
		msie.getPath().addAll(Arrays.asList(itemPath));
		if (NebulaElementKinds.ROW_HEADER.equals(part.getCustomKindId()))
			msie.setRowHeader(true);
		if (NebulaElementKinds.ITEM_CELL.equals(part.getCustomKindId()))
			msie.setCellColumn(part.getText());
		return msie;
	}

	protected void throwMixedViolation() throws CoreException {
		throw new CoreException(
				Activator.err("Mixed parameters are not supported, please use either items or item parts"));
	}

	@Override
	protected IStatus handleWithExtensions(Command command, IProcess context)
			throws InterruptedException, CoreException {
		return null;
	}

	
}