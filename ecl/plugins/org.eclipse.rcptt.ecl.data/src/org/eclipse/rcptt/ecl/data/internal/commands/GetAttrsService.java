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
package org.eclipse.rcptt.ecl.data.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.data.commands.GetAttrs;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Attribute;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetAttrsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetAttrs gs = (GetAttrs) command;
		EObject object = gs.getObject();
		if (object instanceof Tree) {
			Tree tree = (Tree) object;
			EclMap map = getAttrsFromTree(tree);
			context.getOutput().write(map);
			return Status.OK_STATUS;
		}
		return EclDataPlugin.createErr("This type of object is not supported by the command");
	}

	private EclMap getAttrsFromTree(Tree tree) {
		EclMap map = CoreFactory.eINSTANCE.createEclMap();
		for (Attribute attr : tree.getAttributes()) {
			EclMapEntry entry = createMapEntry(attr.getName(), attr.getValue());
			map.getEntries().add(entry);
		}
		return map;
	}

	private static EclMapEntry createMapEntry(String key, String value) {
		EclString keyString = CoreFactory.eINSTANCE.createEclString();
		keyString.setValue(key);
		EclString valueString = CoreFactory.eINSTANCE.createEclString();
		valueString.setValue(value);

		EclMapEntry entry = CoreFactory.eINSTANCE.createEclMapEntry();
		entry.setKey(keyString);
		entry.setValue(valueString);
		return entry;
	}

}
