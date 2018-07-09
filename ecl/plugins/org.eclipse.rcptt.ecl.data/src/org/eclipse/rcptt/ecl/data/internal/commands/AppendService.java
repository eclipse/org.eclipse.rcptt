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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.data.commands.Append;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class AppendService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		Append append = (Append) command;
		int index = append.getIndex();
		EList<EObject> childs = append.getChildren();

		EObject object = append.getObject();
		if (object instanceof Tree) {
			Tree tree = (Tree) object;
			EList<Tree> treeChilds = getAndValidateTreeChilds(childs);
			appendToTree(tree, treeChilds, index);
		} else if (object instanceof EclList) {
			EclList list = (EclList) object;
			appendToList(list, childs, index);
		} else {
			return EclDataPlugin.createErr("This type of object is not supported by the command");
		}

		context.getOutput().write(object);
		return Status.OK_STATUS;
	}

	private void appendToTree(Tree tree, EList<Tree> childs, int index) throws CoreException {
		index = getAndValidateIndex(index, tree.getChildren().size());
		tree.getChildren().addAll(index, childs);
	}

	private void appendToList(EclList list, EList<EObject> elements, int index) throws CoreException {
		index = getAndValidateIndex(index, list.getElements().size());
		list.getElements().addAll(index, elements);
	}

	private EList<Tree> getAndValidateTreeChilds(EList<EObject> childs) throws CoreException {
		EList<Tree> treeChilds = new BasicEList<Tree>();
		for (EObject child : childs) {
			if (!(child instanceof Tree)) {
				throw new CoreException(EclDataPlugin.createErr(
						"Children of the tree must be Tree object"));
			}
			treeChilds.add((Tree) child);
		}
		return treeChilds;
	}

	private int getAndValidateIndex(int index, int size) throws CoreException {
		// -1 means max index + 1
		if (index == -1) {
			index = size;
		}
		if (index < 0 || index > size) {
			throw new CoreException(EclDataPlugin.createErr(
					"Invalid value of the index. Index should be in the range [%d, %d].",
					0, size));
		}
		return index;
	}

}
