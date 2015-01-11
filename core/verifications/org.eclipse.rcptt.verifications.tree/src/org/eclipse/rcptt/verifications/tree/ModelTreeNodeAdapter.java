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
