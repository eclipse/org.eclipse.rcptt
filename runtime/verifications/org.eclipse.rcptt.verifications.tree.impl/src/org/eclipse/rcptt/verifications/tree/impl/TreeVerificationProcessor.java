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
package org.eclipse.rcptt.verifications.tree.impl;

import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.verifications.status.StatusFactory;
import org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError;
import org.eclipse.rcptt.verifications.status.TreeItemVerificationError;
import org.eclipse.rcptt.core.VerificationProcessor;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam;
import org.eclipse.rcptt.util.swt.TableTreeUtil;
import org.eclipse.rcptt.verifications.runtime.ErrorList;
import org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData;
import org.eclipse.rcptt.verifications.tree.Cell;
import org.eclipse.rcptt.verifications.tree.Column;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.Tree;
import org.eclipse.rcptt.verifications.tree.TreeFactory;
import org.eclipse.rcptt.verifications.tree.TreeVerificationUtils;
import org.eclipse.rcptt.verifications.tree.VerifyStyleType;
import org.eclipse.rcptt.verifications.tree.VerifyTreeData;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.core.utils.WidgetModels;
import org.eclipse.rcptt.tesla.core.utils.WidgetModels.StyleDiff;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;

public class TreeVerificationProcessor extends VerificationProcessor {
	@Override
	public Object start(Verification verification, IProcess process) throws CoreException {
		return new Date();
	}

	@Override
	public void finish(Verification verification, Object data, IProcess process) throws CoreException {
		final VerifyTreeData treeVerification = (VerifyTreeData)
				verification;
		final SWTUIElement swtuiElement =
				TeslaBridge.resolveSWTUIElement(treeVerification.getSelector(), process);
		final Widget widget = swtuiElement.widget;
		final ErrorList errors = new ErrorList();

		widget.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				Tree expectedTree = treeVerification.getTree();
				Tree actualTree = TreeVerificationModeller.getTreeData(widget, false);

				compareTrees(widget,
						errors, expectedTree, actualTree,
						treeVerification.isAllowUncapturedChildren(),
						treeVerification.isAllowExtraColumns(),
						treeVerification.isAllowMissingColumns(),
						treeVerification.isVerifyIcons(),
						treeVerification.getVerifyStyle());
			}
		});
		errors.throwIfAny("Tree widget verification failed:",
				this.getClass().getPackage().getName(), verification.getId());
	}

	private void compareTrees(final Widget widget,
			final ErrorList errors,
			Tree expectedTree, Tree actualTree,
			final boolean allowUnverifiedChildren,
			final boolean allowExtra, final boolean allowMissing,
			final boolean verifyIcons, final VerifyStyleType verifyStyle) {
		if (expectedTree == null) {
			errors.add("Expected tree is undefined");
			return;
		}

		EList<Column> expectingColumns = expectedTree.getColumns();
		EList<Column> actualColumns = actualTree.getColumns();
		final int[] mappedInds = (expectingColumns.size() > 0)
				? new int[expectingColumns.size()]
				: new int[] { 0 };
		boolean[] mappedActualCols = new boolean[actualColumns.size()];
		boolean correctMapping = true;

		for (int i = 0; i < expectingColumns.size(); i++) {
			boolean mapped = false;

			for (int j = 0; j < actualColumns.size(); j++) {
				if (!mappedActualCols[j]
						&& expectingColumns.get(i).getName().equals(actualColumns.get(j).getName())
						&& isEqualStrings(expectingColumns.get(i).getTooltip(), actualColumns.get(i).getTooltip())) {
					mappedInds[i] = j;
					mappedActualCols[j] = true;
					mapped = true;
					break;
				}
			}
			if (!mapped) {
				if (allowMissing) {
					mappedInds[i] = -1;
				} else {
					correctMapping = false;
					errors.add("Expected column \"%s\" %s was not found in actual columns list ",
							expectingColumns.get(i).getName(),
							(expectingColumns.get(i).getTooltip() == null)
									? ""
									: String.format("with tooltip", expectingColumns.get(i)));
				}
			}
		}
		for (int i = 0; i < mappedActualCols.length; i++) {
			if (!mappedActualCols[i] && !allowExtra) {
				correctMapping = false;
				errors.add("Column \"%s\" %s is undefined in expected columns list", actualColumns.get(i).getName(),
						(actualColumns.get(i).getTooltip() == null)
								? ""
								: String.format("with tooltip", actualColumns.get(i)));
			}
		}
		if (correctMapping) {
			if (verifyIcons) {
				for (int i = 0; i < expectingColumns.size(); i++) {
					String expImgName = TreeVerificationUtils.
							getDecoratedImagePath(expectingColumns.get(i).getImage());
					String actImgName = TreeVerificationUtils.
							getDecoratedImagePath(expectingColumns.get(mappedInds[i]).getImage());

					if ((expImgName == null && actImgName != null)
							|| (expImgName != null && !expImgName.equals(actImgName))) {
						errors.add(
								"Expected %s for column \"%s\" but was %s",
								(expImgName == null) ? "no icon" : String.format("icon \"%s\"", expImgName),
								expectingColumns.get(i).getName(),
								(actImgName == null) ? "no icon" : String.format("\"%s\"", actImgName));
					}
				}
			}

			TreeIterator actIter = new TreeIterator(widget);
			TreeVerificationModelIterator expIter = new TreeVerificationModelIterator(expectedTree);
			int columnCount = TableTreeUtil.getColumnCount(widget);

			if (expIter.getItemsCount() != actIter.getItemsCount()) {
				errors.add("Different rows amount, expected %d, but was %d", expIter.getItemsCount(),
						actIter.getItemsCount());
			} else {
				while (!expIter.isEnd()) {
					Row expRow = expIter.getItem();
					Row actRow = TreeVerificationModeller.getRow(actIter.getItem(), columnCount, false);
					List<Integer> itemIndPath = expIter.getItemIndexPath();

					boolean equal = compareRows(errors, expRow, actRow, widget.getDisplay(), verifyStyle, verifyIcons,
							expIter.getItemIndex(), expectingColumns, mappedInds, itemIndPath,
							expIter.getNonBlankItemPath());
					if (equal) {
						expIter.nextInto();
						actIter.nextInto();
					} else {
						if (expIter.nextOver() == null) {
							expIter.stepReturn();
						}
						if (actIter.nextOver() == null) {
							actIter.stepReturn();
						}
					}
					if (expIter.getNestingLevel() < actIter.getNestingLevel()) {
						if (!allowUnverifiedChildren) {
							TreeItemVerificationError error = StatusFactory.eINSTANCE.createTreeItemVerificationError();
							error.setMessage(
									String.format("Different row children amount, expected %d, but was %d",
											0, actIter.getItemsCount()));
							error.getItemIndexPath().addAll(itemIndPath);
							error.setItemPath(actIter.getNonBlankPath());
							errors.add(error);
						}
						actIter.stepReturn();
					} else if (expIter.getNestingLevel() > actIter.getNestingLevel()) {
						TreeItemVerificationError error = StatusFactory.eINSTANCE.createTreeItemVerificationError();
						error.setMessage(
								String.format("Different row children amount, expected %d, but was %d",
										expIter.getItemsCount(), 0));
						error.getItemIndexPath().addAll(itemIndPath);
						error.setItemPath(expIter.getNonBlankPath());
						errors.add(error);
						expIter.stepReturn();
					}
				}
			}
		}
	}

	private boolean isEqualStrings(String left, String right) {
		return !((left == null && right != null)
		|| (left != null && !left.equals(right)));
	}

	private boolean compareRows(ErrorList errors,
			Row expectedRow, Row actualRow,
			Display display, VerifyStyleType verifyStyle,
			boolean verifyIcons, int rowsInd,
			List<Column> columns,
			int[] mappedInds, List<Integer> itemIndPath, String fullItemPath) {
		boolean equal = true;
		if (expectedRow.isChecked() != actualRow.isChecked()) {
			equal = false;
			TreeItemVerificationError error = StatusFactory.eINSTANCE.createTreeItemVerificationError();
			error.setMessage(
					String.format("Expected to be %s, but actual row is %s",
							expectedRow.isChecked() ? "checked" : "unchecked",
							actualRow.isChecked() ? "checked" : "unchecked"));
			error.getItemIndexPath().addAll(itemIndPath);
			error.setItemPath(fullItemPath);
			errors.add(error);
		}
		for (int j = 0; j < mappedInds.length; j++) {
			if (mappedInds[j] != -1) {
				Cell expVal = expectedRow.getValues().get(j);
				Cell actVal = actualRow.getValues().get(mappedInds[j]);
				if (verifyIcons) {
					String expImg = TreeVerificationUtils.getDecoratedImagePath(expVal.getData()
							.getImage());
					String actImg = TreeVerificationUtils.getDecoratedImagePath(actVal.getData()
							.getImage());
					if (!isEqualStrings(expImg, actImg)) {
						equal = false;
						TreeItemVerificationError error = StatusFactory.eINSTANCE.
								createTreeItemVerificationError();
						error.setMessage(
								String.format("Expected %s, but was %s",
										(expImg == null) ? "no icon" : String.format("icon \"%s\"", expImg),
										(actImg == null) ? "no icon" : String.format("\"%s\"", actImg)));
						error.getItemIndexPath().addAll(itemIndPath);
						if (columns.size() > j) {
							error.setColumn(columns.get(j).getName());
						}
						error.setItemPath(fullItemPath);
						errors.add(error);
					}
				}
				String expText = expVal.getData().getText();
				String actText = actVal.getData().getText();
				Iterable<StyleRangeEntry> expectedStyles = expVal.getStyle();
				Iterable<StyleRangeEntry> actualStyles = actVal.getStyle();

				if (verifyStyle == VerifyStyleType.IGNORE_STYLED_TEXT) {
					expText = WidgetModels.getTextWithoutStyle(expectedStyles, expText);
					actText = WidgetModels.getTextWithoutStyle(actualStyles, actText);
				}
				if (!expText.equals(actText)) {
					equal = false;
					TreeItemVerificationError error = StatusFactory.eINSTANCE.createTreeItemVerificationError();
					error.setMessage(
							String.format("Expected \"%s\", but was \"%s\"",
									expVal.getData().getText(), actVal.getData().getText()));
					error.getItemIndexPath().addAll(itemIndPath);
					if (columns.size() > j) {
						error.setColumn(columns.get(j).getName());
					}
					error.setItemPath(fullItemPath);
					errors.add(error);
				} else if (verifyStyle == VerifyStyleType.ALL) {
					StyleDiff diff = WidgetModels.getDiff(0, expText.length(), expectedStyles, actualStyles);

					if (diff != null) {
						equal = false;
						TreeItemStyleVerificationError error = StatusFactory.eINSTANCE
								.createTreeItemStyleVerificationError();
						error.setMessage(String.format("Different text style from position %d.", diff.at));
						if (columns.size() > j) {
							error.setColumn(columns.get(j).getName());
						}
						error.getItemIndexPath().addAll(itemIndPath);
						error.setItemPath(fullItemPath);
						error.setExpectedStyle(diff.expected);
						error.setActualStyle(diff.actual);
						errors.add(error);
					}
				}
			}
		}
		return equal;
	}

	@Override
	public Verification create(EObject param, IProcess process) throws CoreException {
		final CreateWidgetVerificationParam p = (CreateWidgetVerificationParam) param;
		final SWTUIElement swtuiElement =
				TeslaBridge.resolveSWTUIElement(p.getSelector(), process);
		final Widget widget = swtuiElement.widget;
		final CaptureTreeVerificationData result = TreeFactory.eINSTANCE.createCaptureTreeVerificationData();

		widget.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				result.getImages().clear();
				result.getImages().putAll(TreeVerificationModeller.extractImages(widget));
				result.setSelector(p.getSelector());
				result.setTree(TreeVerificationModeller.getTreeData(widget, true));
			}
		});

		return result;
	}
}
