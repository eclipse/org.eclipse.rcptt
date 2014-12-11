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
package org.eclipse.rcptt.ecl.filesystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

public class Util {
	public static Writer getWriter(final EclFile file, final boolean append) {
		StringWriter writer = new StringWriter() {
			@Override
			public void close() throws IOException {
				super.close();
				InputStream is = new ByteArrayInputStream(toString().getBytes());
				if (append)
					file.append(is);
				else
					file.write(is);
			}
		};
		return writer;
	}
}
