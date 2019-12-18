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
package org.eclipse.rcptt.ui.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;

public class ResourceSelectionUtil {
	/*
	 * (non-Javadoc) Private constructor to block instantiation.
	 */
	private ResourceSelectionUtil() {
	}

	/**
	 * Returns whether the types of the resources in the given selection are
	 * among the specified resource types.
	 * 
	 * @param selection
	 *            the selection
	 * @param resourceMask
	 *            resource mask formed by bitwise OR of resource type constants
	 *            (defined on <code>IResource</code>)
	 * @return <code>true</code> if all selected elements are resources of the
	 *         right type, and <code>false</code> if at least one element is
	 *         either a resource of some other type or a non-resource
	 * @see IResource#getType()
	 */
	public static boolean allResourcesAreOfType(IStructuredSelection selection,
			int resourceMask) {
		Iterator<?> resources = selection.iterator();
		while (resources.hasNext()) {
			Object next = resources.next();
			if (!(next instanceof IResource)) {
				return false;
			}
			if (!resourceIsType((IResource) next, resourceMask)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns whether the type of the given resource is among the specified
	 * resource types.
	 * 
	 * @param resource
	 *            the resource
	 * @param resourceMask
	 *            resource mask formed by bitwise OR of resource type constants
	 *            (defined on <code>IResource</code>)
	 * @return <code>true</code> if the resources has a matching type, and
	 *         <code>false</code> otherwise
	 * @see IResource#getType()
	 */
	public static boolean resourceIsType(IResource resource, int resourceMask) {
		return (resource.getType() & resourceMask) != 0;
	}

}
