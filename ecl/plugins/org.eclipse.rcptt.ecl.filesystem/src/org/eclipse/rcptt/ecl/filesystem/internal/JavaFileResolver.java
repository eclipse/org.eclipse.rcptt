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
package org.eclipse.rcptt.ecl.filesystem.internal;

import java.io.File;
import java.net.URI;

import org.eclipse.rcptt.ecl.filesystem.EclFile;

public class JavaFileResolver implements EclFileResolver {

	@Override
	public EclFile resolve(URI uri) {
		final String scheme = uri.getScheme();
		if (scheme == null) {
			return null;
		}
		if (scheme.equals("file"))
			return new JavaFile(new File(uri));
		return null;
	}
}
