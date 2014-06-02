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
package org.eclipse.rcptt.ui.commons;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.internal.ide.misc.ContainerContentProvider;

import org.eclipse.rcptt.core.nature.RcpttNature;

@SuppressWarnings("restriction")
public class Q7ContainerContentProvider extends ContainerContentProvider {

	@Override
	public Object[] getChildren(Object element) {
		Object[] children = super.getChildren(element);
		List<Object> q7Children = new LinkedList<Object>();

		for (Object child : children) {
			if (child instanceof IProject) {
				try {
					if (!RcpttNature.isRcpttProject((IProject) child)) {
						continue;
					}
				} catch (CoreException e) {
					continue;
				}
			}
			q7Children.add(child);
		}

		return q7Children.toArray();
	}

}
