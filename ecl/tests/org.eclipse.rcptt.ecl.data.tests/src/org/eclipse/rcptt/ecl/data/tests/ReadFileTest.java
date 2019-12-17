/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.tests;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.Assert;
import org.junit.Test;


public class ReadFileTest extends TestWithSession{
	private final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	private final IProject project = root.getProject("project");
	private final IFolder folder = project.getFolder("folder");
	private final IFile file = folder.getFile("data.txt");
	private static final String workspacePath = "project/folder/data.txt";
	private static final String uri = "workspace:/" + workspacePath;
	
	@Test
	public void testReadFile() throws CoreException {
		createWorkspaceFile();
		runScript("read-file \"%s\" | eq \"File content\" | assert-true", uri);
	}

	@Test
	public void testNotExists() {
		try {
			runScript("read-file \"file:/unknown\"");
		} catch (CoreException exc) {
			String message = exc.getMessage();
			Assert.assertTrue(message != null && message.startsWith("Failed to read"));
		}
	}

	private void createWorkspaceFile() throws CoreException {
		project.delete(true, null);
		project.create(null);
		project.open(null);
		folder.create(true, true, null);
		file.create(null, true, null);
		file.setContents(new ByteArrayInputStream("File content".getBytes()), false, false, null);
		runScript("get-file \"%s\" | get exists | assert-true", uri);
	}
}
