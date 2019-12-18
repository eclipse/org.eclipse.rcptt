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
package org.eclipse.rcptt.internal.core;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;

import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.workspace.Q7Utils;

@SuppressWarnings({ "rawtypes", "restriction" })
public class NamedElementAdapterFactory implements IAdapterFactory {

	private static final Class[] SupportedTypes = new Class[] {
			IResource.class, ResourceMapping.class };

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof NamedElement) {
			IFile file = Q7Utils.getLocation((NamedElement) adaptableObject);
			if (adapterType == IResource.class) {
				return file;
			} else if (adapterType == ResourceMapping.class && file != null) {
				return new SimpleResourceMapping(file);
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return SupportedTypes;
	}

}
