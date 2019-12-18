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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.ecl.filesystem.EclFile;

public class CompositeEclFileResolver implements EclFileResolver {

	private final List<EclFileResolver> children = new ArrayList<EclFileResolver>();
	
	public void add(EclFileResolver resolver) {
		children.add(resolver);
	}
	
	@Override
 	public EclFile resolve(URI uri) throws IOException {
		EclFile result = resolveRaw(uri);
		if (result != null) {
			return result;
		}
		try {
			uri = new URI("file", null, uri.getPath(), null);
		} catch (URISyntaxException e) {
			throw new IOException(e.getMessage());
		}
		result = resolveRaw(uri);
		if (result != null) {
			return result;
		}
		throw new IOException("failed to resolve " + uri);
	}
	
	private EclFile resolveRaw(URI uri) throws IOException {
 		for (EclFileResolver child : children) {
 			EclFile rv = child.resolve(uri);
 			if (rv != null)
 				return rv;
 		}
		return null;
 	}

}
