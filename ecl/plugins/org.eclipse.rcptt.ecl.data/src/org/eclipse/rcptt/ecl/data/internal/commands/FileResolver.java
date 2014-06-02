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
package org.eclipse.rcptt.ecl.data.internal.commands;

import static org.eclipse.rcptt.ecl.data.internal.EclDataPlugin.createErr;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

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

	public static File resolve(String uri) throws CoreException {
		try {
			return resolve(new URI(uri));
		} catch (URISyntaxException e) {
			throw new CoreException(createErr(e, "Cannot parse URI %s", uri));
		}
	}

	public static File resolve(URI uri) throws CoreException {
		Resolver resolver = resolvers.get(uri.getScheme());
		if (resolver == null) {
			throw new CoreException(createErr("Usupported scheme %s",
					uri.getScheme()));
		}
		return resolver.resolve(uri);
	}

	private static interface Resolver {
		File resolve(URI uri) throws CoreException;
	}

	private static Map<String, Resolver> resolvers = new HashMap<String, Resolver>();
	static {
		resolvers.put("file", new Resolver() {
			public File resolve(URI uri) {
				return new File(uri);
			}

		});
		resolvers.put("workspace", new Resolver() {
			public File resolve(URI uri) throws CoreException {
				try {
					return ResourcesPlugin.getWorkspace().getRoot()
							.getFile(Path.fromPortableString(uri.getPath()))
							.getLocation().toFile();
				} catch (NoClassDefFoundError e) {
					throw new CoreException(
							createErr("Resources plugin is not available, "
									+ "cannot use 'workspace:' scheme"));
				}
			}
		});
	}

}
