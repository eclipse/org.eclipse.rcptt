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

import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.internal.core.jobs.IJob;

public interface IProjectIndexer {

	public interface Internal extends IProjectIndexer {

		void indexNamedElement(Index index, IQ7NamedElement change);

		void request(IJob request);

		void requestIfNotWaiting(IJob job);

		Index getProjectIndex(IQ7Project project);

		IndexManager getIndexManager();

	}

	void indexProject(IQ7Project project);

	void removeNamedElement(IQ7Project project, String path);

	void removeProject(IPath projectPath);

	boolean wantRefreshOnStart();

}
