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
		private final TreeNode<Row> parent;

		public RowNodeAdapter(Row item, TreeNode<Row> parent) {
			this.parent = parent;
			if (item == null)
				throw new NullPointerException();
			model = item;
		}

		@Override
		public Collection<? extends TreeNode<Row>> getChildren() {
			return convert(model.getChildren(), this);
		}

		@Override
		public Row payload() {
			return model;
		}

		@Override
		public TreeNode<Row> getParent() {
			return parent;
		}

	}

	private static List<RowNodeAdapter> convert(List<Row> children, TreeNode<Row> parent) {
		List<RowNodeAdapter> rv = new ArrayList<RowNodeAdapter>(children.size());
		for (Row item : children) {
			rv.add(new RowNodeAdapter(item, parent));
		}
		return rv;
	}

	@Override
	public Row payload() {
		return null;
	}

	@Override
	public Collection<? extends TreeNode<Row>> getChildren() {
		return convert(model.getRows(), this);
	}

	@Override
	public TreeNode<Row> getParent() {
		return null;
	}

}
