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

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.ecl.filesystem.internal.CompositeEclFileResolver;
import org.eclipse.rcptt.ecl.filesystem.internal.JavaFileResolver;
import org.eclipse.rcptt.ecl.filesystem.internal.ResourceFileResolver;

public class FileResolver {

	/**
	 * If file is in workspace, refresh it
	 * 
	 * @param file
	 */
	public static void refresh(File file) {
		try {
			IFile ifile = ResourcesPlugin
					.getWorkspace()
					.getRoot()
					.getFileForLocation(
							Path.fromOSString(file.getAbsolutePath()));
			if (ifile != null) {
				try {
					ifile.refreshLocal(IResource.DEPTH_ZERO,
							new NullProgressMonitor());
				} catch (CoreException e) {
					// do nothing
				}
			}
		} catch (NoClassDefFoundError e) {
			// do nothing
		}
	}

	public static EclFile resolve(String uri) throws CoreException {
		uri = uri.replaceAll("(/{2,})|(\\\\{1,})", "/");
		try {
			return resolve(new URI(uri));
		} catch (URISyntaxException e) {
			throw new CoreException(createError(e, "Cannot parse URI %s", uri));
		}
	}

	public static EclFile resolve(URI uri) throws CoreException {
		if (uri == null)
			throw new NullPointerException();
		try {
			return resolvers.resolve(uri);
		} catch (IOException e) {
			if (e.getCause() instanceof CoreException)
				throw (CoreException) e.getCause();
			throw new CoreException(createError(e, "Failed to resolve " + uri));
		}
	}

	private static CompositeEclFileResolver resolvers = new CompositeEclFileResolver();

	static {
		try {
			resolvers.add(new ResourceFileResolver());
		} catch (NoClassDefFoundError e) {
			// No resources plugin. OK.
		}
		resolvers.add(new JavaFileResolver());
	}

}
