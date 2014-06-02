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
package org.eclipse.rcptt.internal.core.model;

import org.eclipse.core.runtime.IPath;

import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.search.ISearchScope;

public class OneProjectScope implements ISearchScope {
	private IPath path;

	public OneProjectScope(IQ7Project project) {
		path = project.getPath();
	}

	public IPath[] getPaths() {
		return new IPath[] { path };
	}

	public boolean contains(IPath path) {
		if (this.path.isPrefixOf(path)) {
			return true;
		}
		return false;
	}
}
