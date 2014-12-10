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

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;

public interface EclFile {

	String getName();

	boolean exists();

	Collection<EclFile> getChildren() throws IOException;

	URI toURI();

	boolean isDirectory();

	void delete() throws IOException;
	
	void append(InputStream data) throws IOException;

	void write(InputStream data) throws IOException;

	InputStream read() throws IOException;
}
