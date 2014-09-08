package org.eclipse.rcptt.ecl.filesystem.internal;

import java.io.IOException;
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
	public void delete() throws IOException {
		IResource member = root.findMember(path);
		if (member == null)
			return;
		try {
			member.delete(true, null);
		} catch (CoreException e) {
			throw new IOException(e);
		}
	}

	public void refresh() throws IOException {
		IResource member = root.findMember(path);
		if (member == null)
			return;
		try {
			member.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			throw new IOException(e);
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
	public void append(InputStream data) throws IOException {
		IFile file = getFileForWrite();
		try {
			if (!file.exists())
				file.create(data, true, null);
			else
				file.appendContents(data, IFile.FORCE, null);
		} catch (CoreException e) {
			throw new IOException(e);
		}
	}

	@Override
	public void write(InputStream data) throws IOException {
		IFile file = getFileForWrite();
		try {
			if (!file.exists())
				file.create(data, true, null);
			else
				file.setContents(data, IFile.FORCE, null);
		} catch (CoreException e) {
			throw new IOException(e);
		}
	}

	private IFile getFileForWrite() throws IOException {
		IFile file = root.getFile(path);
		refresh();
		try {
			createFolder(file.getParent());
		} catch (CoreException e) {
			throw new IOException(e);
		}
		if (isDirectory())
			throw new IOException("" + path + " is a directory.");
		return file;
	}

	@Override
	public InputStream read() throws IOException {
		IFile file = root.getFile(path);
		try {
			refresh();
			return file.getContents();
		} catch (CoreException e) {
			throw new IOException(e);
		}
	}

	IContainer getContainer() {
		if (path.segmentCount() > 1) {
			return root.getFolder(path);
		}
		if (path.segmentCount() == 1) {
			return root.getProject(path.lastSegment());
		}
		throw new IllegalStateException("Can get folder " + path);
	}

	@Override
	public Collection<EclFile> getChildren() throws IOException {
		try {
			refresh();
			IResource[] members = getContainer().members();
			List<EclFile> rv = new ArrayList<EclFile>(members.length);
			for (IResource resource : members) {
				rv.add(new ResourceFile(resource.getFullPath()));
			}
			return rv;
		} catch (CoreException e) {
			throw new IOException(e);
		}
	}

	@Override
	public boolean isDirectory() {
		IResource member = root.findMember(path);
		if (member == null)
			return false;
		return member instanceof IContainer;
	}
}
