/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Files;

public class DeleteFileTest extends TestWithSession {
	private final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	private final IProject project = root.getProject("project");
	private final IFolder folder = project.getFolder("folder");
	private final IFile file = folder.getFile("data.csv");
	private static final String uri = "workspace:/project/folder/data.csv";
	private static final String folderUri = "workspace:/project/folder";
	private static final String projectUri = "workspace:/project";

	@Test
	public void testDeleteFilesystemFile() throws IOException, CoreException {
		File tempFile = File.createTempFile("junit", "txt");
		final URI uri = tempFile.toURI();
		assertTrue(tempFile.exists());
		runScript("delete-file \"%s\"", uri.toASCIIString());
		assertFalse(tempFile.exists());
	}

	@Test
	public void testDeleteFilesystemFolder() throws IOException, CoreException {
		File folder = Files.createTempDir();
		final URI uri = folder.toURI();
		assertTrue(folder.exists());
		assertTrue(folder.isDirectory());
		// Non-empty folders are a special case
		File file = new File(folder, "file-in-folder.txt");
		file.createNewFile();
		Assert.assertTrue(file.exists());
		runScript("delete-file \"%s\"", uri.toASCIIString());
		assertFalse(folder.exists());
	}

	@Test
	public void testDeleteWorkspace() throws IOException, CoreException {
		createWorkspaceFile();
		runScript("delete-file [get-file \"%s\"]", uri);
		runScript("get-file \"%s\" | get exists | not | assert-true", uri);
	}

	private void createWorkspaceFile() throws CoreException {
		project.delete(true, null);
		project.create(null);
		project.open(null);
		folder.create(true, true, null);
		file.create(null, true, null);
		runScript("get-file \"%s\" | get exists | assert-true", uri);
	}

	@Test
	public void testInput() throws IOException, CoreException {
		createWorkspaceFile();
		runScript("get-file \"%s\"|delete-file", uri);
		runScript("get-file \"%s\" | get exists |  not | assert-true", uri);
	}

	@Test
	public void testProject() throws IOException, CoreException {
		createWorkspaceFile();
		runScript("get-file \"%s\"|delete-file", projectUri);
		runScript("get-file \"%s\" | get exists |  not | assert-true", projectUri);
	}

	@Test
	public void testWorkspaceFolder() throws IOException, CoreException {
		createWorkspaceFile();
		runScript("get-file \"%s\"| delete-file", folderUri);
		runScript("get-file \"%s\" | get exists |  not | assert-true", folderUri);
	}
}
