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
package org.eclipse.rcptt.maven;

import org.apache.maven.artifact.versioning.ComparableVersion;

public class RunnerVersionDispatcher {

	private static final String RUNNER_GROUP_ID = "org.eclipse.rcptt.runner";
	private static final String RUNNER_ARTIFACT_ID = "rcptt.runner";
	private static final String RUNNER_APPLICATION_ID = "org.eclipse.rcptt.runner.headless";

	public static ComparableVersion parseVersion(String version) {
		if (version == null || version.trim().isEmpty())
			return null;
		return new ComparableVersion(version);
	}

	public static String getApplicationId(ComparableVersion runnerVersion) {
		return RunnerVersionDispatcher.RUNNER_APPLICATION_ID;
	}

	public static String getDefaultArtifact(ComparableVersion runnerVersion) {
		return RUNNER_ARTIFACT_ID;
	}

	public static String getDefaultGroup(ComparableVersion runnerVersion) {
		return RUNNER_GROUP_ID;
	}

}
