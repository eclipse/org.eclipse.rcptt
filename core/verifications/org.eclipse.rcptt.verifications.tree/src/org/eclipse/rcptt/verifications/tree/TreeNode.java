package org.eclipse.rcptt.verifications.tree;

import java.util.Collection;

public interface TreeNode<T> {
	Collection<? extends TreeNode<T>> getChildren();
	T payload();
	TreeNode<T> getParent();
}
