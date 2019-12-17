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
package org.eclipse.rcptt.verifications.tree;

import java.util.List;

import org.eclipse.rcptt.tesla.core.ui.Image;

public class TreeVerificationUtils {

	public static String getDecoratedImagePath(Image img) {
		if (img == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(img.getPath());

		for (Image decorImg : img.getDecorations()) {
			sb.append('_').append(decorImg.getPath());
		}
		return sb.toString();
	}

	public static boolean isExcludedColumn(VerifyTreeData tree, int ind) {
		List<Integer> excludedColumns = tree.getExcludedColumns();
		return excludedColumns.contains(ind);
	}

	public static void addExcludedColumn(VerifyTreeData tree, int excludedColumnIndex) {
		tree.getExcludedColumns().add(excludedColumnIndex);
	}

	public static void removeExcludedColumn(VerifyTreeData tree, int excludedColumnIndex) {
		List<Integer> excludedColumns = tree.getExcludedColumns();
		int index = excludedColumns.indexOf(Integer.valueOf(excludedColumnIndex));
		excludedColumns.remove(index);
	}

}
