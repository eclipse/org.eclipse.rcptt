/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModelTreeNodeAdapter implements TreeNode<Row> {
	private final Tree model;

	public ModelTreeNodeAdapter(Tree model) {
		this.model = model;
	}

	private static class RowNodeAdapter implements TreeNode<Row> {
		private final Row model;

		public RowNodeAdapter(Row item) {
			if (item == null)
				throw new NullPointerException();
			model = item;
		}

		@Override
		public Collection<? extends TreeNode<Row>> getChildren() {
			return convert(model.getChildren());
		}

		@Override
		public Row payload() {
			return model;
		}
	}

	private static List<RowNodeAdapter> convert(List<Row> children) {
		List<RowNodeAdapter> rv = new ArrayList<RowNodeAdapter>(children.size());
		for (Row item : children) {
			rv.add(new RowNodeAdapter(item));
		}
		return rv;
	}

	@Override
	public Row payload() {
		return null;
	}

	@Override
	public Collection<? extends TreeNode<Row>> getChildren() {
		return convert(model.getRows());
	}
}
