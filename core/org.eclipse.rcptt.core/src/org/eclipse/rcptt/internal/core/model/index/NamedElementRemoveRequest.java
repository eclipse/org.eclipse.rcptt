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
package org.eclipse.rcptt.internal.core.model.index;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.rcptt.core.model.IQ7Project;

public class NamedElementRemoveRequest extends IndexRequest {

	private final IQ7Project project;
	private final String path;

	/**
	 * @param project
	 * @param path
	 * @param name
	 */
	public NamedElementRemoveRequest(IProjectIndexer indexer,
			IQ7Project project, String path) {
		super(indexer);
		this.project = project;
		this.path = path;
	}

	@Override
	protected String getName() {
		return path;
	}

	@Override
	public boolean belongsTo(String jobFamily) {
		return jobFamily.equals(project.getName());
	}

	@Override
	protected void run() throws CoreException, IOException {
		final Index index = getIndexer().getProjectIndex(project);
		final ReadWriteMonitor imon = index.monitor;
		imon.enterWrite();
		try {
			index.remove(path);
		} finally {
			imon.exitWrite();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NamedElementRemoveRequest other = (NamedElementRemoveRequest) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

}
