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
package org.eclipse.rcptt.core.tests.builder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import junit.framework.Test;
import junit.framework.TestCase;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.core.internal.builder.Q7Builder;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.tests.CoreTestsPlugin;
import org.eclipse.rcptt.core.tests.model.AbstractModelTestbase;
import org.eclipse.rcptt.internal.core.model.ModelManager;
import org.eclipse.rcptt.internal.core.model.index.Index;
import org.eclipse.rcptt.internal.core.model.index.ProjectIndexerManager;
import org.eclipse.rcptt.util.FileUtil;

public class BuilderIndexerTest extends AbstractModelTestbase {
	private static final String PRJ_NAME = "ModelMembers_builder";

	public BuilderIndexerTest(String name) {
		super(CoreTestsPlugin.PLUGIN_ID, name);
	}

	public static Test suite() {
		return new Suite(BuilderIndexerTest.class);
	}

	public void setUpSuite() throws Exception {
		super.setUpSuite();
		setUpQ7ProjectTo(PRJ_NAME, "ModelMembers");
	}

	public void tearDownSuite() throws Exception {
		deleteProject(PRJ_NAME);
		super.tearDownSuite();
	}

	public void testBuilderAndIndexer() throws Exception {
		final IQ7Project prj = getQ7Project(PRJ_NAME);
		ITestCase testCase = prj.getRootFolder().createTestCase("mytestcase",
				true, new NullProgressMonitor());
		waitUntilIndexesReady();
		waitForAutoBuild();

		File file = testCase.getResource().getLocation().toFile();

		String content = new String(
				FileUtil.getStreamContent(new BufferedInputStream(
						new FileInputStream(file))));
		content = content.replace("Element-Name: ", "Element-Name: MyName");
		OutputStream fout = new BufferedOutputStream(new FileOutputStream(file));
		fout.write(content.getBytes());
		fout.close();
		testCase.close();
		try {
			Thread builderThread = new Thread(new Runnable() {
				public void run() {
					try {
						Q7Builder.debug_sleep = true;
						prj.getProject().build(
								IncrementalProjectBuilder.FULL_BUILD,
								new NullProgressMonitor());
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			});
			builderThread.start();
			builderThread.join(1000); // To be sure it is already running
			Index index = ModelManager.getModelManager().getIndexManager()
					.getIndex(prj.getPath());
			index.dispose();
			ProjectIndexerManager.indexProject(prj);
			builderThread.join(1000);
			// Indexer should lock already
			Q7Builder.debug_sleep = false;
			builderThread.join(1000);
			// Check there is at least 2 jobs
			int jobsCount = ModelManager.getModelManager().getIndexManager()
					.awaitingJobsCount();
			builderThread.interrupt();
			TestCase.assertEquals(0, jobsCount);
		} finally {
			Q7Builder.debug_sleep = false;
		}
	}
}
