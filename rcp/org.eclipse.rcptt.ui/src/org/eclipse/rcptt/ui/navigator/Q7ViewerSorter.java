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
package org.eclipse.rcptt.ui.navigator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.Q7ProjectMetadata;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public class Q7ViewerSorter extends TreePathViewerSorter {

	private static final int METADATA = 1;
	private static final int CONTAINER = 2;
	private static final int CONTEXT = 3;
	private static final int SCENARIO = 4;
	private static final int OTHER = 5;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ViewerSorter#category(java.lang.Object)
	 */
	public int category(Object element) {
		if (element instanceof IContainer) {
			return CONTAINER;
		}
		if (element instanceof IFile) {
			try {
				IQ7Element namedElement = RcpttCore.create((IFile) element);
				if (namedElement instanceof IContext)
					return CONTEXT;
				if (namedElement instanceof ITestCase)
					return SCENARIO;
				if (namedElement instanceof Q7ProjectMetadata) {
					return METADATA;
				}
			} catch (Exception e) {
			}
		}
		return OTHER;
	}

	private static String nameOf(IQ7Element e) {
		return ModelUtils.getText(e);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof IFile && e2 instanceof IFile) {
			try {
				IQ7Element namedElement1 = RcpttCore.create((IFile) e1);
				IQ7Element namedElement2 = RcpttCore.create((IFile) e2);
				if (namedElement1 != null && namedElement2 != null) {
					int cat1 = category(e1);
					int cat2 = category(e2);

					if (cat1 != cat2) {
						return cat1 - cat2;
					}
					String n1 = nameOf(namedElement1);
					String n2 = nameOf(namedElement2);

					return n1.compareToIgnoreCase(n2);
				}
			} catch (Exception e) {
			}
		}
		return super.compare(viewer, e1, e2);
	}

	public boolean isSorterProperty(Object element, String property) {
		return true;
	}
}
