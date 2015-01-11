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

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;

import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.tests.CoreTestsPlugin;

public class ModelMembersTests extends AbstractModelTestbase {
	private static final String PRJ_NAME = "ModelMembersq";

	public ModelMembersTests(String name) {
		super(CoreTestsPlugin.PLUGIN_ID, name);
	}

	public static Test suite() {
		return new Suite(ModelMembersTests.class);
	}

	public void setUpSuite() throws Exception {
		super.setUpSuite();
		setUpQ7ProjectTo(PRJ_NAME, "ModelMembers");
	}

	public void tearDownSuite() throws Exception {
		deleteProject(PRJ_NAME);
		super.tearDownSuite();
	}

	public void testElementExistance() throws ModelException {
		IQ7Project prj = getQ7Project(PRJ_NAME);
		waitUntilIndexesReady();
		TestCase.assertTrue(prj.exists());

		IQ7Folder testsFolder = prj.getFolder(new Path("tests"));
		TestCase.assertTrue(testsFolder.exists());

		IQ7Folder contextsFolder = prj.getFolder(new Path("contexts"));
		TestCase.assertTrue(contextsFolder.exists());

		IQ7NamedElement element = testsFolder.getNamedElement("scenario1.test");
		TestCase.assertTrue(element.exists());
		TestCase.assertEquals("scenario1_2", element.getElementName());

		element = contextsFolder.getNamedElement("workspace.ctx");
		TestCase.assertTrue(element.exists());
		TestCase.assertEquals("workspace", element.getElementName());
		TestCase.assertTrue(element instanceof IContext);
		IContext ctx = (IContext) element;
		TestCase.assertEquals("org.eclipse.rcptt.ctx.workspace", ctx.getType()
				.getId());
	}

	public void testFindContext() throws ModelException {
		IQ7Project prj = getQ7Project(PRJ_NAME);

		IQ7NamedElement workspaceCtx = prj.getFolder(new Path("contexts"))
				.getNamedElement("workspace.ctx");
		String id = workspaceCtx.getID();
		List<IContext> context = prj.find(IContext.class, id);
		TestCase.assertEquals(1, context.size());
		TestCase.assertNotNull(context.get(0));
		TestCase.assertEquals(workspaceCtx, context.get(0));
	}
}
