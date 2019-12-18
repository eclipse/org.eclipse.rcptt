/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.tree.test;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Iterables.toArray;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.Assert.assertEquals;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.rcptt.verifications.status.StatusFactory;
import org.eclipse.rcptt.verifications.status.TreeItemVerificationError;
import org.eclipse.rcptt.verifications.tree.TreeComparison;
import org.eclipse.rcptt.verifications.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.primitives.Ints;

public class TreeComparisonTest {

	static class NumberNode implements TreeNode<Integer> {
		private final NumberNode[] children;
		private final Integer payload;
		private final boolean expanded;

		public NumberNode(int payload, NumberNode... children) {
			if (children == null)
				throw new NullPointerException();
			this.children = children;
			this.payload = payload;
			this.expanded = payload > 0;
		}

		@Override
		public Collection<? extends TreeNode<Integer>> getChildren() {
			Assert.assertTrue("getChildren() should only be called if isExpanded() returns true", expanded);
			return asList(children);
		}

		@Override
		public Integer payload() {
			return payload;
		}

		public static Function<Integer, NumberNode> wrapPayload = new Function<Integer, TreeComparisonTest.NumberNode>() {
			@Override
			public NumberNode apply(Integer input) {
				return new NumberNode(input);
			}
		};

		@Override
		public String toString() {
			return payload.toString();
		}
	}

	class NumberTreeComparison extends TreeComparison<Integer> {

		public NumberTreeComparison(boolean allowUnmatched) {
			super(allowUnmatched);
		}

		@Override
		public String getName(Integer payload) {
			return payload.toString();
		}

		@Override
		public List<TreeItemVerificationError> compare(Integer expected, Integer actual) {
			if (expected == null && actual == null)
				return Collections.emptyList();
			if (Objects.equal(expected, actual))
				return Collections.emptyList();
			TreeItemVerificationError error = StatusFactory.eINSTANCE.createTreeItemVerificationError();
			error.setMessage(format("Expected to be %d, but actual is %d", expected, actual));
			return singletonList(error);
		}

		@Override
		public boolean isChildrenVerificationRequired(Integer expectedChild) {
			return expectedChild > 0;
		}
	}

	private static NumberNode create(int payload, int... children) {
		return new NumberNode(payload, wrapArray(children));
	}

	private static NumberNode[] wrapArray(int... children) {
		return toArray(wrap(children), NumberNode.class);
	}

	private static Collection<NumberNode> wrap(int... children) {
		return transform(Ints.asList(children), NumberNode.wrapPayload);
	}

	private final List<Integer> emptyIntegerList = Collections.<Integer> emptyList();

	@Test
	public void testChildrenAllowedForUnexpanded() {
		NumberTreeComparison comparison = new NumberTreeComparison(false);
		List<NumberNode> expected = asList(new NumberNode(-1));
		List<NumberNode> actual = asList(create(-1, 2));
		List<TreeItemVerificationError> result = comparison.assertChildren(expected, actual, emptyIntegerList, "");
		assertEquals(0, result.size());
		expected = asList(new NumberNode(1));
		actual = asList(create(1, 2));
		result = comparison.assertChildren(expected, actual, emptyIntegerList, "");
		assertEquals(1, result.size());
		assertEquals("Different row children amount, expected 0, but was 1", result.get(0).getMessage());
		assertEquals(asList(0), result.get(0).getItemIndexPath());
	}

	@Test
	public void testDescent() {
		NumberTreeComparison comparison = new NumberTreeComparison(false);
		List<NumberNode> expected = asList(create(1, 2), create(1, 2));
		List<TreeItemVerificationError> result = comparison.assertChildren(expected, expected, emptyIntegerList, "");
		assertEquals(0, result.size());
		result = comparison.assertChildren(expected, asList(create(1, 2), create(1, 3)),
				emptyIntegerList, "");
		assertEquals(1, result.size());
		assertEquals("Expected to be 2, but actual is 3", result.get(0).getMessage());
		assertEquals(asList(1, 0), result.get(0).getItemIndexPath());
	}

	@Test
	public void testAssertChildren() {
		NumberTreeComparison comparison = new NumberTreeComparison(false);
		universalTests(comparison);
		List<TreeItemVerificationError> result = comparison.assertChildren(wrap(1, 2), wrap(1, 2, 3), emptyIntegerList,
				"");
		assertEquals(1, result.size());
		assertEquals("Different row children amount, expected 2, but was 3", result.get(0).getMessage());
		result = comparison.assertChildren(wrap(1, 3, 2), wrap(1, 2, 3), emptyIntegerList, "");
		assertEquals(1, result.size());
		assertEquals("Expected to be 3, but actual is 2", result.get(0).getMessage());
		assertEquals(asList(1), result.get(0).getItemIndexPath());
	}

	@Test
	public void testAllowUnmatched() {
		NumberTreeComparison comparison = new NumberTreeComparison(true);
		universalTests(comparison);
		List<TreeItemVerificationError> result = comparison.assertChildren(wrap(1, 2, 3), wrap(1, 2, 4, 3),
				emptyIntegerList, "");
		assertEquals(0, result.size());
		result = comparison.assertChildren(wrap(1, 2, 3, 4), wrap(1, 2, 3), emptyIntegerList, "");
		assertEquals(2, result.size());
		assertEquals(Collections.emptyList(), result.get(0).getItemIndexPath());
		assertEquals("Different row children amount, expected 4, but was 3", result.get(0).getMessage());
		result = comparison.assertChildren(wrap(1, 3, 2), wrap(1, 2, 3), emptyIntegerList, "");
		assertEquals(1, result.size());
		assertEquals("Expected 2, but no more elements left", result.get(0).getMessage());
		assertEquals(asList(2), result.get(0).getItemIndexPath());
	}

	private void universalTests(NumberTreeComparison comparison) {
		List<TreeItemVerificationError> result = comparison.assertChildren(wrap(1, 2, 3), wrap(1, 2, 3),
				emptyIntegerList, "");
		assertEquals(0, result.size());
		result = comparison.assertChildren(wrap(1, 2, 3), wrap(4, 2, 3), emptyIntegerList, "");
		assertEquals(1, result.size());
		assertEquals(asList(0), result.get(0).getItemIndexPath());
		assertEquals("Expected to be 1, but actual is 4", result.get(0).getMessage());
		result = comparison.assertChildren(wrap(1, 2, 3), wrap(1, 2, 4), emptyIntegerList, "");
		assertEquals(1, result.size());
		assertEquals(asList(2), result.get(0).getItemIndexPath());
		assertEquals("Expected to be 3, but actual is 4", result.get(0).getMessage());
	}

}
