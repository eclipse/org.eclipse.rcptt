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
package org.eclipse.rcptt.ui.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;

public class SearchFilter extends ViewerFilter {
	private boolean enabled = false;
	private List<IQ7NamedElement> allowed = new ArrayList<IQ7NamedElement>();

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (!enabled) {
			return true;
		}

		if (element instanceof IContainer) {
			final IContainer container = (IContainer) element;
			synchronized (allowed) {
				for (final IQ7NamedElement o : allowed) {
					final IPath path = o.getResource().getFullPath();
					final IPath containerPath = container.getFullPath();
					if (containerPath.isPrefixOf(path)) {
						return true;
					}
				}
			}
			return false;
		}

		if (element instanceof IFile) {
			final IQ7Element namedElement = RcpttCore.create((IFile) element);
			if (namedElement != null) {
				synchronized (allowed) {
					return allowed.contains(namedElement);
				}
			} else {
				return false;
			}
		}

		return true;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void clear() {
		synchronized (allowed) {
			allowed.clear();
		}
	}

	public void add(final IQ7NamedElement o) {
		synchronized (allowed) {
			allowed.add(o);
		}
	}
}
