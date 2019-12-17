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
package org.eclipse.rcptt.internal.core.model;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.ProjectMetadata;
import org.eclipse.rcptt.core.workspace.RcpttCore;

public class Q7ProjectInfo extends OpenableElementInfo {
	/**
	 * A array with all the non-q7 resources contained by this Project fragment
	 */
	private Object[] foreignResources;
	private ProjectMetadata metadata;

	public Q7ProjectInfo() {
	}

	public void setForeignResources(Object[] resources) {
		this.foreignResources = resources;
	}

	public Object[] getForeignResources(IContainer container)
			throws ModelException {
		if (this.foreignResources == null) {
			this.foreignResources = computeFolderForeignResources(container);
		}
		return this.foreignResources;
	}

	public static Object[] computeFolderForeignResources(IContainer folder)
			throws ModelException {
		Object[] nonQ7Resources = new IResource[5];
		int nonQ7ResourcesCounter = 0;
		try {
			IResource[] members = folder.members();
			nextResource: for (int i = 0, max = members.length; i < max; i++) {
				IResource member = members[i];
				switch (member.getType()) {
				case IResource.FILE:
					if (RcpttCore.isQ7File(member.getFullPath())) {
						continue nextResource;
					}
					break;
				}
				if (nonQ7Resources.length == nonQ7ResourcesCounter) {
					// resize
					System.arraycopy(
							nonQ7Resources,
							0,
							(nonQ7Resources = new IResource[nonQ7ResourcesCounter * 2]),
							0, nonQ7ResourcesCounter);
				}
				nonQ7Resources[nonQ7ResourcesCounter++] = member;

			}
			if (nonQ7Resources.length != nonQ7ResourcesCounter) {
				System.arraycopy(
						nonQ7Resources,
						0,
						(nonQ7Resources = new IResource[nonQ7ResourcesCounter]),
						0, nonQ7ResourcesCounter);
			}
			return nonQ7Resources;
		} catch (CoreException e) {
			throw new ModelException(e);
		}

	}
}
