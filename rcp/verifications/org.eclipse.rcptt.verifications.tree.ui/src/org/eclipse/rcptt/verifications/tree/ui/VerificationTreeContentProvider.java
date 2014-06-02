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
package org.eclipse.rcptt.verifications.tree.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.rcptt.verifications.tree.Row;

public class VerificationTreeContentProvider implements ITreeContentProvider {

	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		EList<Row> rows = (EList<Row>) inputElement;
		return rows.toArray(new Row[rows.size()]);
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		Row row = (Row) element;
		if (row.getChildren().size() > 0) {
			return true;
		}
		return false;
	}

	public Object[] getChildren(Object parentElement) {
		Row row = (Row) parentElement;
		if (row.getChildren().size() > 0) {
			return row.getChildren().toArray(new Row[row.getChildren().size()]);
		}
		return null;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}