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
