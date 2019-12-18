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
package org.eclipse.rcptt.ecl.filesystem.internal;

import java.io.IOException;
import java.net.URI;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.ecl.filesystem.EclFile;

public class ResourceFileResolver implements EclFileResolver {
	{
		// Creation should fail if resource plug-in is not available
		ResourcesPlugin.getWorkspace().getRoot();
	}

	@Override
	public EclFile resolve(URI uri) throws IOException {
		IPath path = toPath(uri);
		final String scheme = uri.getScheme();
		if (scheme == null) {
			return null;
		}
		if (scheme.equals("workspace")) {
			return new ResourceFile(path);
		}
		return null;
	}

	private static IPath toPath(URI uri) {
		final String path = uri.getPath().substring(1); // removes leading slash
		if (path == null) {
			throw new NullPointerException("Bad URI: " + uri);
		}
		return Path.fromPortableString(path);
	}
}

