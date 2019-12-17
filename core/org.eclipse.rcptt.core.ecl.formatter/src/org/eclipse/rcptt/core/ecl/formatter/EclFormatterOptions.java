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
package org.eclipse.rcptt.core.ecl.formatter;

public class EclFormatterOptions {

	public boolean useTabs = true;
	public int tabSize = 4;
	public int wrapAt = 80;
	public int indent = 4;
	public int wrapIndent = 8;

	public int minLiteralLengthToWrap = 7;
	public int minLiteralLengthToStayOnWrap = 10; // must be >= 5

	public EclFormatterOptions useTabs(boolean on) {
		this.useTabs = on;
		return this;
	}

	public EclFormatterOptions tabSize(int spaces) {
		if (spaces < 0)
			throw new IllegalArgumentException("spaces must be non-negative.");

		this.tabSize = spaces;
		return this;
	}

	public EclFormatterOptions wrapAt(int column) {
		if (column <= 0)
			throw new IllegalArgumentException("column must be greater than 0.");

		this.wrapAt = column;
		return this;
	}

	public EclFormatterOptions indent(int spaces) {
		if (spaces < 0)
			throw new IllegalArgumentException("spaces must be non-negative.");

		this.indent = spaces;
		return this;
	}

	public EclFormatterOptions wrapIndent(int spaces) {
		if (spaces < 0)
			throw new IllegalArgumentException("spaces must be non-negative.");

		this.wrapIndent = spaces;
		return this;
	}
}
