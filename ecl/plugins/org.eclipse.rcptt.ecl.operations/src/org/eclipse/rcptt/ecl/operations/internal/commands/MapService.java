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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.operations.Entry;
import org.eclipse.rcptt.ecl.operations.Map;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class MapService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		Map map = (Map) command;

		EclMap result = CoreFactory.eINSTANCE.createEclMap();
		for (Entry entry : map.getEntries()) {
			put(result, entry.getKey(), entry.getValue());
		}
		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	private static void put(EclMap map, EObject key, EObject val) {
		boolean found = false;
		for (EclMapEntry entry : map.getEntries()) {
			if (EcoreUtil.equals(key, entry.getKey())) {
				entry.setValue(val);
				found = true;
				break;
			}
		}
		if (!found) {
			EclMapEntry newEntry = CoreFactory.eINSTANCE.createEclMapEntry();
			newEntry.setKey(key);
			newEntry.setValue(val);
			map.getEntries().add(newEntry);
		}

	}
}
