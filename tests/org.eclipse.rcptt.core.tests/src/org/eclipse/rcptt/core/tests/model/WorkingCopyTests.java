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
package org.eclipse.rcptt.core.tests.model;

import junit.framework.Test;
import junit.framework.TestCase;

import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.tests.CoreTestsPlugin;

public class WorkingCopyTests extends AbstractModelTestbase {
	String PRJ_NAME = "workingCopyTests";

	public WorkingCopyTests(String name) {
		super(CoreTestsPlugin.PLUGIN_ID, name);
	}

	public static Test suite() {
		return new Suite(WorkingCopyTests.class);
	}

	public void setUpSuite() throws Exception {
		super.setUpSuite();
		createQ7Project(PRJ_NAME, new String[] {});
	}

	public void tearDownSuite() throws Exception {
		deleteProject(PRJ_NAME);
		super.tearDownSuite();
	}

	public void testNewTestcaseAppear() throws ModelException {
		IQ7Project prj = getQ7Project(PRJ_NAME);
		startDeltas();
		ITestCase testcase = prj.getRootFolder().createTestCase("mytestcase",
				true, new NullProgressMonitor());

		ITestCase copy = (ITestCase) testcase
				.getWorkingCopy(new NullProgressMonitor());

		copy.setElementName("new test case name");
		copy.setTags("tag0");

		TestCase.assertEquals("mytestcase", testcase.getElementName());
		TestCase.assertEquals("new test case name", copy.getElementName());

		copy.commitWorkingCopy(true, new NullProgressMonitor());
		TestCase.assertEquals("new test case name", testcase.getElementName());

		stopDeltas();
	}

	public void _testWorkingCopyForNewResource() throws ModelException {
		IQ7Project prj = getQ7Project(PRJ_NAME);
		startDeltas();
		ITestCase testcase = prj.getRootFolder().getTestCase("newTestCase.test");
		TestCase.assertTrue(!testcase.exists());
		ITestCase copy = (ITestCase) testcase
				.getWorkingCopy(new NullProgressMonitor());

		copy.setElementName("new test case name");
		copy.setTags("tag0");

		TestCase.assertEquals("new test case name", copy.getElementName());

		copy.commitWorkingCopy(true, new NullProgressMonitor());
		TestCase.assertEquals("new test case name", testcase.getElementName());

		stopDeltas();
	}
}
