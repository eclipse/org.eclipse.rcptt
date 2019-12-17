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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetItem;
import org.eclipse.rcptt.tesla.ecl.model.Selector;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.nebula.ecl.NebulaElementKinds;
import org.eclipse.rcptt.util.TableTreeItemPathUtil;

/**
 * Special logic for getting Nebula Grid items.
 */
public class SelectorServiceExtension implements IScriptletExtension {

	@Override
	public boolean canHandle(Command c) {
		if (c instanceof GetItem) {
			ControlHandler parent = ((GetItem) c).getParent();
			while (parent != null) {
				if (ElementKind.Item == parent.getKind()) // subitems too
					parent = parent.getParent();
				else
					return NebulaElementKinds.GRID.equals(parent.getCustomKindId());
			}
		}
		return false;
	}

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();

		ControlHandler handler = TeslaFactory.eINSTANCE.createControlHandler();
		Selector selector = (Selector) command;
		ControlHandler parent = selector.getParent();

		if (selector instanceof GetItem
				// && ((GetItem) selector).getPath() != null
				&& ElementKind.Item.equals(parent.getKind())
				&& parent.getPath() != null) {
			String path = parent.getPath();

			// if path isn't specified, any item is matched
			String childPath = ((GetItem) selector).getPath();
			path += "/" + (childPath == null ? ".*" : childPath);
			//

			Integer index = ((GetItem) selector).getIndex();
			String column = ((GetItem) selector).getColumn();
			if (index != null) {
				path += "%" + index + "%";
			}
			if (column != null) {
				path += TableTreeItemPathUtil.COLUMN_DELIMITER
						+ column
						+ TableTreeItemPathUtil.COLUMN_DELIMITER;
			}
			handler.setKind(ElementKind.Item);
			handler.setParent(parent.getParent());
			handler.setPath(path);
			TeslaBridge.find(handler);
			context.getOutput().write(handler);
			return Status.OK_STATUS;
		}

		handler.setParent(selector.getParent());
		handler.setAfter(selector.getAfter());
		if (selector instanceof GetItem) {
			GetItem ge = (GetItem) selector;

			// if path isn't specified, any item is matched
			if (ge.getPath() == null)
				ge.setPath(".*");
			//

			if (selector.getIndex() != null) {
				ge.setPath(ge.getPath() + "%" + selector.getIndex() + "%");
			}
			String column = ge.getColumn();
			if (column != null) {
				ge.setPath(TableTreeItemPathUtil.appendFullPathColumnName(ge.getPath(), column));
			}

			//
			handler.setKind(ElementKind.Item);
			handler.setPath(((GetItem) selector).getPath());
		}

		//
		TeslaBridge.find(handler);

		context.getOutput().write(handler);
		TeslaBridge.waitExecution();
		return Status.OK_STATUS;
	}



}
