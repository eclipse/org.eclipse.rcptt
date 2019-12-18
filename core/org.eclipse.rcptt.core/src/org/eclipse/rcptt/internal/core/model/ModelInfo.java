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
package org.eclipse.rcptt.internal.core.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.rcptt.core.workspace.RcpttCore;

public class ModelInfo extends OpenableElementInfo {
	/**
	 * A array with all the foreign projects contained by this model
	 */
	public Object[] foreignResources;

	private Object[] computeForeignResources() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		int length = projects.length;
		Object[] resources = null;
		int index = 0;
		for (int i = 0; i < length; i++) {
			IProject project = projects[i];
			if (!RcpttCore.hasRcpttNature(project)) {
				if (resources == null) {
					resources = new Object[length];
				}
				resources[index++] = project;
			}
		}
		if (index == 0)
			return NO_NON_Q7_RESOURCES;
		if (index < length) {
			System.arraycopy(resources, 0, resources = new Object[index], 0,
					index);
		}
		return resources;
	}

	public Object[] getForeignResources() {
		if (this.foreignResources == null) {
			this.foreignResources = computeForeignResources();
		}
		return this.foreignResources;
	}
}
