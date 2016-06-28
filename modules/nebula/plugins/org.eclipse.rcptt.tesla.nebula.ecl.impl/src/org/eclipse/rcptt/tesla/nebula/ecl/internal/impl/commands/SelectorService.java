/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.nebula.ecl.internal.impl.commands;

import static org.eclipse.rcptt.tesla.nebula.ecl.NebulaEmptyAreaQualifiers.pathFromSelector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.Selector;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea;
import org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell;
import org.eclipse.rcptt.tesla.ecl.nebula.GetNebulaGrid;
import org.eclipse.rcptt.tesla.ecl.nebula.GetRowHeader;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;

public class SelectorService implements ICommandService {

	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();

		ControlHandler handler = TeslaFactory.eINSTANCE.createControlHandler();
		Selector selector = (Selector) command;
		handler.setParent(selector.getParent());
		handler.setAfter(selector.getAfter());
		handler.setIndex(selector.getIndex());

		handler.setKind(ElementKind.Custom);
		handler.setCustomKindId(customKindIdFrom(selector));

		// additional parameters
		if (selector instanceof GetItemCell) {
			String columnTitle = ((GetItemCell) selector).getColumn();
			handler.setText(columnTitle);
		}
		else if (selector instanceof GetEmptyArea) {
			handler.setPath(pathFromSelector((GetEmptyArea) selector));
		}

		context.getOutput().write(handler);
		TeslaBridge.waitExecution();
		return Status.OK_STATUS;
	}

	private static String customKindIdFrom(Selector s) {
		if (s instanceof GetNebulaGrid)
			return NebulaElementKinds.GRID;
		if (s instanceof GetRowHeader)
			return NebulaElementKinds.ROW_HEADER;
		if (s instanceof GetItemCell)
			return NebulaElementKinds.ITEM_CELL;
		if (s instanceof GetEmptyArea)
			return NebulaElementKinds.EMPTY_AREA;

		throw new IllegalArgumentException("don't know such selector type");
	}

}
