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

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.data.commands.CommandsFactory;
import org.eclipse.rcptt.ecl.data.commands.ReadCsvFile;
import org.eclipse.rcptt.ecl.data.internal.commands.ReadCsvFileService;
import org.eclipse.rcptt.ecl.parser.test.TestSession;
import org.eclipse.rcptt.ecl.parser.test.TestWithSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadCsvFileTests  extends TestWithSession {
	private final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	private final IProject project = root.getProject("project");
	private final IFile file = project.getFile("data.csv");
	private final String uri = "workspace:/project/data.csv";

	@Before
	public void deleteProject() throws CoreException {
		project.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT, null);
		project.create(null);
		Assert.assertFalse(file.exists());
	}

	@Test
	public void testSimple() throws InterruptedException, CoreException {
		ReadCsvFile cmd = CommandsFactory.eINSTANCE.createReadCsvFile();
		cmd.setUri("workspace:/foo/bar");
		ReadCsvFileService service = new ReadCsvFileService();
		service.service(cmd, null);
	}
	
	@Test
	public void write() throws CoreException, IOException {
		runScript("emit [entry from to] [entry a b] | as-table-data | write-csv-file \"%s\"", uri);
		Assert.assertEquals("host,bindings,key,value\nnull,[],from,to\nnull,[],a,b\n",
				TestSession.toString(file.getContents()));
	}

	// TODO: rest read-csv-file
}
