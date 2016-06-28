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
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;

public class ResourceFile implements EclFile {
	private final IPath path;
	private static final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

	protected ResourceFile(IPath path) {
		if (path == null)
			throw new NullPointerException();
		this.path = path;
	}

	@Override
	public String getName() {
		IResource member = root.findMember(path);
		if (member != null)
			return member.getName();
		return path.lastSegment();
	}

	@Override
	public boolean exists() {
		IResource member = root.findMember(path);
		if (member == null)
			return false;
		return member.exists();
	}

	@Override
	public URI toURI() {
		try {
			return new URI("workspace", path.toPortableString(), null);
		} catch (URISyntaxException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void delete() throws CoreException {
		IResource member = root.findMember(path);
		if (member == null)
			return;
		try {
			member.delete(true, null);
		} catch (CoreException e) {
			throwError("Failed to delete %s", e);
		}
	}

	public void refresh() throws CoreException {
		IResource member = root.findMember(path);
		if (member == null)
			return;
		try {
			member.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			throwError("Failed to refresh %s", e);
		}
	}

	private void createFolder(IContainer container) throws CoreException {
		container.refreshLocal(IResource.DEPTH_ZERO, null);
		if (container instanceof IProject) {
			if (!container.exists())
				((IProject) container).create(null);
			((IProject) container).open(null);
			return;
		}
		if (container.exists())
			return;
		createFolder(container.getParent());
		if (container instanceof IFolder) {
			((IFolder) container).create(true, false, null);
		} else {
			throw new IllegalArgumentException("Unknown container type: " + container.getClass().getName());
		}

	}

	@Override
	public void append(InputStream data) throws CoreException {
		IFile file = getFileForWrite();
		try {
			if (!file.exists())
				file.create(data, true, null);
			else
				file.appendContents(data, IFile.FORCE, null);
		} catch (CoreException e) {
			throwError("failed to append %s", e);
		}
	}

	@Override
	public void write(InputStream data) throws CoreException {
		IFile file = getFileForWrite();
		try {
			if (!file.exists())
				file.create(data, true, null);
			else
				file.setContents(data, IFile.FORCE, null);
		} catch (CoreException e) {
			throwError("Fialed to write %s", e);
		}
	}

	private IFile getFileForWrite() throws CoreException {
		IFile file = root.getFile(path);
		refresh();
		try {
			createFolder(file.getParent());
		} catch (CoreException e) {
			throwError("Failed to create folder " + file.getParent() + " to write %s", e);
		}
		if (isDirectory())
			throwError("%s is a directory", null);
		return file;
	}

	@Override
	public InputStream read() throws CoreException {
		IFile file = root.getFile(path);
		try {
			refresh();
			return file.getContents();
		} catch (CoreException e) {
			throw new CoreException(CorePlugin.err("Failed to read " + this, e));
		}
	}

	IContainer getContainer() {
		if (path.segmentCount() > 1) {
			return root.getFolder(path);
		} else if (path.segmentCount() == 1) {
			return root.getProject(path.lastSegment());
		} else if (path.segmentCount() == 0) {
			return root;
		}
		throw new IllegalStateException("Path can't be a container " + path);
	}

	@Override
	public Collection<EclFile> getChildren() throws CoreException {
		try {
			refresh();
			IResource[] members = getContainer().members();
			List<EclFile> rv = new ArrayList<EclFile>(members.length);
			for (IResource resource : members) {
				rv.add(new ResourceFile(resource.getFullPath()));
			}
			return rv;
		} catch (CoreException e) {
			throw new CoreException(CorePlugin.err("Failed to read childen of " + this, e));
		}
	}

	@Override
	public boolean isDirectory() {
		IResource member = root.findMember(path);
		if (member == null)
			return false;
		return member instanceof IContainer;
	}

	private void throwError(String message, Throwable reason) throws CoreException {
		assert message.contains("%s");
		String formatted = String.format(message, this.toString());
		throw new CoreException(CorePlugin.err(formatted, reason));
	}

	@Override
	public String toString() {
		return path.makeAbsolute().toPortableString();
	}

	@Override
	public File toFile() {
		return new File(root.getLocation().append(path).makeAbsolute().toPortableString()); 
	}

}
