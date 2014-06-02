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
package org.eclipse.rcptt.ecl.operations.internal.commands;

import static org.eclipse.rcptt.ecl.operations.internal.OperationsPlugin.createErr;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.core.Get;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetFromMapService implements IScriptletExtension {

	public GetFromMapService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		Get get = (Get) command;
		EclMap map = (EclMap) get.getInput();
		EObject value = get(map, get.getKey(), get.getDefault());
		if (value == null) {
			return createErr("Map does not contain key %s and default value is not specified",
					BoxedValues.unbox(get.getKey()));
		}
		context.getOutput().write(EcoreUtil.copy(value));
		return Status.OK_STATUS;
	}

	@Override
	public boolean canHandle(Command c) {
		return (c instanceof Get) && ((Get) c).getInput() instanceof EclMap;
	}

	private static EObject get(EclMap map, EObject key, EObject def) {
		for (EclMapEntry entry : map.getEntries()) {
			if (EcoreUtil.equals(entry.getKey(), key)) {
				return entry.getValue();
			}
		}
		return def;
	}
}
