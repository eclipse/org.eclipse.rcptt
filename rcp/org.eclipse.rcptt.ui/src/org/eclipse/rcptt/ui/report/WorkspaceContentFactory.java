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
package org.eclipse.rcptt.ui.report;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.reporting.core.IReportRenderer.IContentFactory;

public class WorkspaceContentFactory implements IContentFactory {
	private IPath root;

	public WorkspaceContentFactory(IPath folder) {
		this.root = folder;
	}

	public IContentFactory createFolder(String name) {
		return new WorkspaceContentFactory(root.append(name));
	}

	public OutputStream createFileStream(final String fname) throws CoreException {
		try {
			final File tmpFile = File.createTempFile("q7_workspace_report_temp", "tmp");
		return new BufferedOutputStream(new FileOutputStream(tmpFile)) {
			@Override
			public void close() throws IOException {
				super.close();
				IFile file = getFile(fname);
				if (file.exists()) {
					try {
						file.setContents(
								new BufferedInputStream(new FileInputStream(tmpFile)),
								true, true, new NullProgressMonitor());
					} catch (CoreException e) {
						Q7UIPlugin.log(e);
					}
				} else {
					try {
						file.create(
								new BufferedInputStream(new FileInputStream(tmpFile)),
								true, new NullProgressMonitor());
					} catch (CoreException e) {
						Q7UIPlugin.log(e);
					}
				}
				tmpFile.delete();
			}
		};
		} catch (IOException e1) {
			Q7UIPlugin.log(e1.getMessage(), e1);
			throw new CoreException(Q7UIPlugin.createStatus(e1.getMessage(), e1));
		}
	}

	public boolean isFileExist(String fname) {
		return getFile(fname).exists();
	}

	private IFile getFile(final String fname) {
		// Ensure folders are exist
		getRootFolder();

		IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(root.append(fname));
		return file;
	}

	private IContainer getRootFolder() {
		IContainer folder = null;
		if (root.segmentCount() > 1) {
			folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(root);
		} else if (root.segmentCount() == 1) {
			folder = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(root.segment(0));
		}
		if (folder != null) {
			checkCreateFolders(folder);
		}
		return folder;
	}

	private void checkCreateFolders(IContainer folder) {
		if (!folder.exists()) {
			IContainer parent = folder.getParent();
			if (parent instanceof IFolder) {
				checkCreateFolders((IFolder) parent);
			}
			if (folder instanceof IFolder) {
				try {
					((IFolder) folder).create(true, true,
							new NullProgressMonitor());
				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}
		}
	}

	public List<String> matchFiles(final String fname) {
		final Set<String> result = new HashSet<String>();
		if (isFileExist(fname)) {
			result.add(fname);
		}
		// Match with regular expression
		try {
			getRootFolder().accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					String name = resource.getFullPath()
							.removeFirstSegments(root.segmentCount())
							.toString();
					if (Pattern.matches(fname, name)) {
						result.add(name);
					}
					return true;
				}
			});
		} catch (Exception e) {
			RcpttPlugin.log(e);
		}

		return new ArrayList<String>(result);
	}

	public void removeFileOrFolder(String name) throws CoreException {
		IResource member = getRootFolder().findMember(name);
		if (member.exists()) {
			member.delete(true, null);
		}
	}
}
