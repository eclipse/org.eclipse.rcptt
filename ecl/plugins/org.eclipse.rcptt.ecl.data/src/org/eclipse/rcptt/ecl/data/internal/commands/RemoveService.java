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
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.data.commands.Remove;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class RemoveService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		Remove remove = (Remove) command;
		int index = remove.getIndex();

		EObject object = remove.getObject();
		if (object instanceof Tree) {
			Tree tree = (Tree) object;
			removeFromTree(tree, index);
		} else if (object instanceof EclList) {
			EclList list = (EclList) object;
			removeFromList(list, index);
		} else {
			return EclDataPlugin.createErr("This type of object is not supported by the command");
		}

		context.getOutput().write(object);
		return Status.OK_STATUS;
	}

	private void removeFromTree(Tree tree, int index) throws CoreException {
		EList<Tree> childs = tree.getChildren();
		if (childs.size() == 0) {
			throw new CoreException(EclDataPlugin.createErr(
					"The tree has no children to remove"));
		}
		index = getAndValidateIndex(index, childs.size());
		childs.remove(index);
	}

	private void removeFromList(EclList list, int index) throws CoreException {
		EList<EObject> childs = list.getElements();
		if (childs.size() == 0) {
			throw new CoreException(EclDataPlugin.createErr(
					"The list has no children to remove"));
		}
		index = getAndValidateIndex(index, childs.size());
		childs.remove(index);
	}

	private int getAndValidateIndex(int index, int size) throws CoreException {
		// -1 means max index
		if (index == -1) {
			index = size - 1;
		}
		if (index < 0 || index >= size) {
			throw new CoreException(EclDataPlugin.createErr(
					"Invalid value of the index. Index should be in the range [%d, %d].",
					0, size - 1));
		}
		return index;
	}

}
