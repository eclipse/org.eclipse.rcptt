/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************//**
 * 
 */
package org.eclipse.rcptt.core.workspace;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.archive.ArchiveURLConnection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * @author Artem Kovalev
 *
 */
public class WorkspaceSynchronizer {

	/**
	 * Obtains the workspace file corresponding to the specified resource, if
	 * it has a platform-resource URI. Note that the resulting file, if not
	 * <code>null</code>, may nonetheless not actually exist (as the file is
	 * just a handle).
	 * <p>
	 * Note that, if the <tt>resource</tt> is in an archive (such as a ZIP file)
	 * then it does not map to a workspace file. In this case, however, the
	 * workspace file (if any) corresponding to the containing archive can be
	 * obtained via the {@link #getUnderlyingFile(Resource)} method.
	 * </p>
	 * 
	 * @param resource
	 *            an EMF resource
	 * 
	 * @return the corresponding workspace file, or <code>null</code> if the
	 *         resource's URI is not a platform-resource URI
	 * 
	 * @see #getUnderlyingFile(Resource)
	 */
	public static IFile getFile(Resource resource) {
		if (resource == null) {
			return null;
		}
		ResourceSet rset = resource.getResourceSet();

		return getFile(
				resource.getURI(),
				(rset != null) ? rset.getURIConverter() : null,
				false);
	}

	private static IFile getFile(URI uri, URIConverter converter, boolean considerArchives) {
		IFile result = null;

		if (considerArchives && uri.isArchive()) {
			class MyArchiveURLConnection extends ArchiveURLConnection {
				public MyArchiveURLConnection(String url) {
					super(url);
				}

				public String getNestedURI() {
					try {
						return getNestedURL();
					} catch (IOException exception) {
						return ""; //$NON-NLS-1$
					}
				}
			}
			MyArchiveURLConnection archiveURLConnection = new MyArchiveURLConnection(uri.toString());
			result = getFile(URI.createURI(archiveURLConnection.getNestedURI()), converter, considerArchives);
		} else if (uri.isPlatformPlugin()) {
			/* resource with platform plug-in URI could not be in the workspace */
			return result;
		} else if (uri.isPlatformResource()) {
			IPath path = new Path(uri.toPlatformString(true));
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		} else if (uri.isFile() && !uri.isRelative()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
					new Path(uri.toFileString()));
		} else {
			// normalize, to see whether may we can resolve it this time
			if (converter != null) {
				URI normalized = converter.normalize(uri);

				if (!uri.equals(normalized)) {
					// recurse on the new URI
					result = getFile(normalized, converter, considerArchives);
				}
			}
		}

		if ((result == null) && !uri.isRelative()) {
			try {
				java.net.URI location = new java.net.URI(uri.toString());

				if (hasRegisteredEFS(location)) {
					IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
							.findFilesForLocationURI(new java.net.URI(uri.toString()));
					if (files.length > 0) {
						// set the result to be the first file found
						result = files[0];
					}
				}
			} catch (URISyntaxException e) {
				// won't get this because EMF provides a well-formed URI
			}
		}

		return result;
	}

	private static boolean hasRegisteredEFS(java.net.URI location) {
		try {
			if (EFS.getStore(location) != null) {
				return true;
			}
		} catch (CoreException ex) {

			return false;
		}
		return false;
	}
}
