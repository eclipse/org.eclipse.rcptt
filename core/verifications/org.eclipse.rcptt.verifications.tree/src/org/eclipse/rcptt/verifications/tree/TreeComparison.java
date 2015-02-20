package org.eclipse.rcptt.verifications.tree;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.rcptt.verifications.status.StatusFactory;
import org.eclipse.rcptt.verifications.status.TreeItemVerificationError;

public abstract class TreeComparison<T> {
	private boolean allowUnmatched;

	public TreeComparison(boolean allowUnmatched) {
		this.allowUnmatched = allowUnmatched;
	}

	public List<TreeItemVerificationError> assertNode(TreeNode<T> expected, TreeNode<T> actual) {
		List<TreeItemVerificationError> res = compare(expected.payload(), actual.payload());
		String name = getName(expected.payload());
		if (!res.isEmpty()) {
			setPath(res, Collections.<Integer> emptyList(), name);
			return res;
		}
		Collection<? extends TreeNode<T>> childrenE = expected.getChildren();
		List<TreeNode<T>> childrenA = new ArrayList<TreeNode<T>>(actual.getChildren());
		return assertChildren(childrenE, childrenA, Collections.<Integer> emptyList(), name);
	}

	private boolean isChildrenCountValid(int expected, int actual) {
		if (expected == actual)
			return true;
		if (!allowUnmatched)
			return false;
		return actual > expected;
	}

	public List<TreeItemVerificationError> assertChildren(Collection<? extends TreeNode<T>> childrenExpected,
			Collection<? extends TreeNode<T>> childrenActual, List<Integer> itemIndPath, String fullItemPath) {
		if (!isChildrenCountValid(childrenExpected.size(), childrenActual.size())) {
			return singletonList(createError(
					format("Different row children amount, expected %d, but was %d", childrenExpected.size(),
							childrenActual.size()),
					itemIndPath, fullItemPath));
		}
		Iterator<? extends TreeNode<T>> actualIter = childrenActual.iterator();
		List<TreeItemVerificationError> rv = new ArrayList<TreeItemVerificationError>();
		int i = 0;
		for (TreeNode<T> expectedChild : childrenExpected) {
			List<TreeItemVerificationError> firstDifference = null;
			TreeNode<T> next = null;
			ArrayList<Integer> indPath = new ArrayList<Integer>(itemIndPath.size() + 1);
			indPath.addAll(itemIndPath);
			indPath.add(i);
			String fullPath = fullItemPath + "/" + getName(expectedChild.payload());
			while (actualIter.hasNext()) {
				next = actualIter.next();
				List<TreeItemVerificationError> childRes = compare(expectedChild.payload(), next.payload());
				if (childRes.isEmpty()) {
					firstDifference = null;
					break;
				}
				if (firstDifference == null)
					firstDifference = childRes;
				if (!allowUnmatched) {
					break;
				}
			}
			if (firstDifference != null) {
				setPath(firstDifference, indPath, fullPath);
				rv.addAll(firstDifference);
				break;
			}
			if (next == null) {
				return singletonList(createError(
						format("Expected %s, but no more elements left", getName(expectedChild.payload())),
						indPath, fullPath));
			}
			if (isChildrenVerificationRequired(expectedChild.payload())) {
				Collection<? extends TreeNode<T>> exchildren = expectedChild.getChildren();
				rv.addAll(assertChildren(exchildren, next.getChildren(), indPath, fullPath));
			}
			i++;
		}
		return rv;
	}

	public abstract boolean isChildrenVerificationRequired(T expectedChild);

	private void setPath(List<TreeItemVerificationError> data, List<Integer> indPath, String fullPath) {
		for (TreeItemVerificationError error : data) {
			error.getItemIndexPath().addAll(indPath);
			error.setItemPath(fullPath);
		}
	}

	private TreeItemVerificationError createError(String firstDifference, List<Integer> indPath, String fullPath) {
		TreeItemVerificationError error = StatusFactory.eINSTANCE.createTreeItemVerificationError();
		error.setMessage(firstDifference);
		error.getItemIndexPath().addAll(indPath);
		error.setItemPath(fullPath);
		return error;
	}

	public abstract String getName(T payload);

	public abstract List<TreeItemVerificationError> compare(T expected, T actual);

}
