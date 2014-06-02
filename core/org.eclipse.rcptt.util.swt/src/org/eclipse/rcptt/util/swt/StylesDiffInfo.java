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
package org.eclipse.rcptt.util.swt;

public class StylesDiffInfo {
	private int diffIndexStart;
	private int expectedStyleRangeIndex;
	private int actualStyleRangeIndex;

	public StylesDiffInfo(int diffIndexStart,
			int expectedStyleRangeIndex,
			int actualStyleRangeIndex) {
		this.diffIndexStart = diffIndexStart;
		this.expectedStyleRangeIndex = expectedStyleRangeIndex;
		this.actualStyleRangeIndex = actualStyleRangeIndex;
	}

	public int getDiffIndexStart() {
		return diffIndexStart;
	}

	public int getExpectedStyleRangeIndex() {
		return expectedStyleRangeIndex;
	}

	public int getActualStyleRangeIndex() {
		return actualStyleRangeIndex;
	}
}