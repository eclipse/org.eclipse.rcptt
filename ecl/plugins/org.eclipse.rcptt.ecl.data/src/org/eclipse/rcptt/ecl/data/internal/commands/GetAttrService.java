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
package org.eclipse.rcptt.ecl.data.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.GetAttr;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Attribute;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetAttrService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetAttr ga = (GetAttr) command;
		String name = ga.getName();
		EObject object = ga.getObject();
		if (object instanceof Tree) {
			Tree tree = (Tree) object;
			String value = getAttrFromTree(tree, name);
			context.getOutput().write(value);
			return Status.OK_STATUS;
		}
		return EclDataPlugin.createErr("This type of object is not supported by the command");
	}

	private String getAttrFromTree(Tree tree, String name) throws CoreException {
		for (Attribute attr : tree.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		throw new CoreException(EclDataPlugin.createErr(
				"There is no attribute with name %s in the tree", name));
	}

}
