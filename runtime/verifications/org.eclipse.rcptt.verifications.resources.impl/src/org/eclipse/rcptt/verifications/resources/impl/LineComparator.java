/*******************************************************************************
 * Copyright (c) 2009, 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.resources.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.eclipse.compare.rangedifferencer.IRangeComparator;

public class LineComparator implements IRangeComparator {

	private String[] lines;
	private boolean ignoreWhiteSpace;

	public LineComparator(InputStream is, boolean ignoreWhiteSpace) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		final ArrayList<String> lines = new ArrayList<String>();
		
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		this.lines = (String[]) lines.toArray(new String[lines.size()]);
		this.ignoreWhiteSpace = ignoreWhiteSpace;
	}

	public String getLine(int index) {
		return lines[index];
	}

	@Override
	public int getRangeCount() {
		return lines.length;
	}

	@Override
	public boolean skipRangeComparison(int length, int maxLength, IRangeComparator other) {
		return false;
	}

	@Override
	public boolean rangesEqual(int thisIndex, IRangeComparator other, int otherIndex) {
		String line1 = lines[thisIndex];
		String line2 = ((LineComparator) other).lines[otherIndex];

		return ignoreWhiteSpace ? compare(line1, line2) : line1.equals(line2);
	}

	private boolean compare(String line1, String line2) {
		int c1 = 0, c2 = 0;
		int i1 = 0, i2 = 0;
		int l1 = line1.length();
		int l2 = line2.length();

		while (c1 != -1) {
			c1 = -1;
			while (i1 < l1) {
				char c = line1.charAt(i1++);
				if (!Character.isWhitespace(c)) {
					c1 = c;
					break;
				}
			}

			c2 = -1;
			while (i2 < l2) {
				char c = line2.charAt(i2++);
				if (!Character.isWhitespace(c)) {
					c2 = c;
					break;
				}
			}

			if (c1 != c2) {
				return false;
			}
		}
		return true;
	}

}
