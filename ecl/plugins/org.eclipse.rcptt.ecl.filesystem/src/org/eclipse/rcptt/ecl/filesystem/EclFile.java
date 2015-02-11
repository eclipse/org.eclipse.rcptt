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

import java.io.InputStream;
import java.net.URI;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

public interface EclFile {

	String getName();

	boolean exists();

	Collection<? extends EclFile> getChildren() throws CoreException;

	URI toURI();

	boolean isDirectory();

	void delete() throws CoreException;
	
	void append(InputStream data) throws CoreException;

	void write(InputStream data) throws CoreException;

	InputStream read() throws CoreException;
}
