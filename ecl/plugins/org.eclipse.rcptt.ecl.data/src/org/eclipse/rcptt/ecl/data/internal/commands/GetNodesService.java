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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.GetNodes;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class GetNodesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		GetNodes gn = (GetNodes) command;
		String name = gn.getName();
		int pos = gn.getPos();
		int len = gn.getLen();
		
		EObject object = gn.getObject();
		EList<EObject> nodes;
		if (object instanceof Tree) {
			Tree tree = (Tree) object;
			nodes = getNodesFromTree(tree, name);
		} else {
			return EclDataPlugin.createErr("This type of object is not supported by the command");
		}

		if (nodes.size() == 0) {
			return Status.OK_STATUS;
		}

		int maxPos = getAndValidateMaxPosIndex(pos, len, nodes.size());
		for (; pos < maxPos; pos++) {
			context.getOutput().write(nodes.get(pos));
		}
		return Status.OK_STATUS;
	}

	private EList<EObject> getNodesFromTree(Tree tree, String name) {
		EList<EObject> nodes = new BasicEList<EObject>();
		if (name != null && !name.equals("")) {
			for (Tree child : tree.getChildren()) {
				if (child.getName().equals(name)) {
					nodes.add(child);
				}
			}
			return nodes;
		}
		for (Tree child : tree.getChildren()) {
			nodes.add(child);
		}
		return nodes;
	}

	private int getAndValidateMaxPosIndex(int pos, int len, int size) throws CoreException {
		if (pos < 0 || pos >= size) {
			throw new CoreException(EclDataPlugin.createErr(
					"Invalid value of the 'pos' parameter. It should be in the range [%d, %d].",
					0, size - 1));
		}

		// -1 means max length
		int maxLen = size - pos;
		if (len == -1) {
			len = maxLen;
		}
		if (len < 0 || len > maxLen) {
			throw new CoreException(EclDataPlugin.createErr(
					"Invalid value of the 'len' parameter. It should be in the range [%d, %d].",
					0, maxLen));
		}

		int maxPos = len + pos;
		return maxPos;
	}

}
