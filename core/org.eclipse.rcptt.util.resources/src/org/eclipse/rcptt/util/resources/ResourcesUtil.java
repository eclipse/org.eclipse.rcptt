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
package org.eclipse.rcptt.util.resources;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class ResourcesUtil {
	/**
	 * Returns child from container by case-insensitive name. 
	 * 
	 * @return Resource with given name or <code>null</code>
	 * @throws CoreException 
	 */
	public static IResource getCaseInsensitiveChild(IContainer c, String name) throws CoreException {
		if (c == null || name == null) {
			return null;
		}

		for (IResource r : c.members()) {
			if (r.getName().equalsIgnoreCase(name)) {
				return r;
			}
		}

		return null;
	}

	public static <T extends IResource> T getCaseInsensitiveChild(IContainer c,
			String name, Class<T> clazz) throws CoreException {
		return clazz.cast(getCaseInsensitiveChild(c, name));
	}

}
