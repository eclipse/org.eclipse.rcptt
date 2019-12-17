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
package org.eclipse.rcptt.ecl.data.internal.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.SetAttr;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Attribute;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class SetAttrService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		SetAttr sa = (SetAttr) command;
		String name = sa.getName();
		String value = sa.getValue();
		EObject object = sa.getObject();
		if (object instanceof Tree) {
			Tree tree = (Tree) object;
			setAttrToTree(tree, name, value);
			context.getOutput().write(tree);
			return Status.OK_STATUS;
		}
		return EclDataPlugin.createErr("This type of object is not supported by the command");
	}

	private void setAttrToTree(Tree tree, String name, String value) {
		Attribute attribute = null;
		EList<Attribute> attrs = tree.getAttributes();
		for (Attribute attr : attrs) {
			if (attr.getName().equals(name)) {
				attribute = attr;
			}
		}

		// add a new attribute
		if (attribute == null && value != null && !value.equals("")) {
			attribute = ObjectsFactory.eINSTANCE.createAttribute();
			attribute.setName(name);
			attribute.setValue(value);
			tree.getAttributes().add(attribute);
		// replace the value
		} else if (attribute != null && value != null && !value.equals("")) {
			attribute.setValue(value);
		// remove the attribute
		} else if (attribute != null && (value == null || value.equals(""))) {
			tree.getAttributes().remove(attribute);
		}
	}

}
