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
package org.eclipse.rcptt.internal.core.model.index;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;

public class NamedElementRequest extends IndexRequest {

	protected final IQ7NamedElement element;

	public NamedElementRequest(IProjectIndexer indexer, IQ7NamedElement element) {
		super(indexer);
		this.element = element;
	}

	@Override
	protected String getName() {
		return element.getName();
	}

	@Override
	public boolean belongsTo(String jobFamily) {
		return jobFamily.equals(element.getQ7Project().getName());
	}

	@Override
	protected void run() throws CoreException, IOException {
		final IQ7Project project = element.getQ7Project();
		final Index index = getIndexer().getProjectIndex(project);
		final ReadWriteMonitor imon = index.monitor;
		imon.enterWrite();
		try {
			getIndexer().indexNamedElement(index, element);
			index.save();
		} finally {
			imon.exitWrite();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NamedElementRequest other = (NamedElementRequest) obj;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		return true;
	}
}
