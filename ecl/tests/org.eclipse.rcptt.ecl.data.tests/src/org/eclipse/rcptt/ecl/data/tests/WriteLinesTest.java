/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.parser.test.TestSession;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;

public class WriteLinesTest extends TestWithSession {
	private final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	private final IProject project = root.getProject("project");

	@Before
	@After
	public void deleteProject() throws CoreException {
		project.delete(true, null);
	}

	@Test
	public void writeToNewProject() throws CoreException {
		runScript("emit first \"second second\" third | write-lines \"workspace:/project/data.txt\"");
		runScript("read-lines \"workspace:/project/data.txt\" | to-list | eq [list first \"second second\" third] | assert-true");
	}

	@Test
	public void writeToNewFolder() throws CoreException {
		runScript("emit fixirst | write-lines \"workspace:/project/folder/data.txt\"");
		runScript("read-lines \"workspace:/project/folder/data.txt\" | eq fixirst | assert-true");
	}

	@Test
	public void writeToClosedProject() throws CoreException {
		project.create(null);
		project.close(null);
		runScript("emit fiiirst | write-lines \"workspace:/project/data.txt\"");
		runScript("read-lines \"workspace:/project/data.txt\" | eq fiiirst | assert-true");
	}

	@Test(expected = CoreException.class)
	public void failToWriteInDir() throws CoreException {
		project.create(null);
		project.open(null);
		project.getFolder("folder").create(true, false, null);
		runScript("emit fiiirst | write-lines \"workspace:/project/folder\"");
	}
	
	@Test
	public void writeToNewFilesystemFolder() throws CoreException {
		File parent = Files.createTempDir();
		File dirToCreate = new File(parent, "toCreate");
		File fileToCreate = new File(dirToCreate, "data.txt");
		try {
			runScript("emit first | write-lines \"" + fileToCreate.toURI().toASCIIString() + "\"");
			assertTrue(fileToCreate.exists());
		} finally {
			fileToCreate.delete();
			dirToCreate.delete();
			parent.delete();
		}
	}

	@Test
	public void writeToExistingFilesystemFolder() throws CoreException {
		File parent = Files.createTempDir();
		parent.mkdirs();
		File fileToCreate = new File(parent, "data.txt");
		try {
			runScript("emit first | write-lines \"" + fileToCreate.toURI().toASCIIString() + "\"");
		} finally {
			fileToCreate.delete();
			parent.delete();
		}
	}

	@Test
	public void writeTwiceToFilesystem() throws CoreException {
		File parent = Files.createTempDir();
		File fileToCreate = new File(parent, "data.txt");
		try {
			String command = "emit first | write-lines \"" + fileToCreate.toURI().toASCIIString() + "\"";
			runScript(command + "; " + command);
		} finally {
			fileToCreate.delete();
			parent.delete();
		}
	}

	@Test
	public void appendToFilesystem() throws Exception {
		File parent = Files.createTempDir();
		File fileToCreate = new File(parent, "data.txt");
		try {
			runScript("emit first | write-lines \"" + fileToCreate.toURI().toASCIIString() + "\"");
			runScript("emit second | write-lines \"" + fileToCreate.toURI().toASCIIString() + "\" -append true");
			String content = TestSession.toString(new FileInputStream(fileToCreate));
			assertEquals("first\nsecond\n", content.replaceAll("\r", ""));
		} finally {
			fileToCreate.delete();
			parent.delete();
		}
	}

}
