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
package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.rcptt.ecl.filesystem.File;

public class FileAdapterFactory implements IAdapterFactory {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof File) {
			File file = (File) adaptableObject;
			if (adapterType.isAssignableFrom(String.class)) {
				return file.getUri();
			}
		}
		return null;
	}

	private static final Class<?>[] adapters = new Class<?>[] { String.class };
	@Override
	public Class<?>[] getAdapterList() {
		return adapters;
	}

}
