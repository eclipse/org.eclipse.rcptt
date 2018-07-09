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
package org.eclipse.rcptt.ecl.filesystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.eclipse.core.runtime.CoreException;

public class Util {
	public static Writer getWriter(final EclFile file, final boolean append, final String encode) {
		StringWriter writer = new StringWriter() {
			@Override
			public void close() throws IOException {
				super.close();
				try {
					String encoding = encode != null && encode.length() != 0 ? encode : StandardCharsets.UTF_8.name();
					InputStream is = new ByteArrayInputStream(toString().getBytes(encoding));
					if (append)
						file.append(is);
					else
						file.write(is);
				} catch (CoreException e) {
					throw new IOException("Failed to write " + file.toURI().toString(), e);
				}
			}
		};
		return writer;
	}

	public static Writer getWriter(final EclFile file, final boolean append) {
		return getWriter(file, append, StandardCharsets.UTF_8.name());
	}
}
