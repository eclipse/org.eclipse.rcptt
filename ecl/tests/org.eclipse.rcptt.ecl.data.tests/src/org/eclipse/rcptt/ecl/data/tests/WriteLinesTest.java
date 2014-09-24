package org.eclipse.rcptt.ecl.data.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
}
