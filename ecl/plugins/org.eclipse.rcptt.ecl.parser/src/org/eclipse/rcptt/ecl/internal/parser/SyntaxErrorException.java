/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.internal.parser;

public class SyntaxErrorException extends RuntimeException {

	private static final long serialVersionUID = -3597387509846380248L;

	public final int line;
	public final int col;

	public SyntaxErrorException(int line, int col) {
		this(line, col, null);
	}

	public SyntaxErrorException(int line, int col, String msg) {
		super(msg);
		this.line = line;
		this.col = col;
	}

	@Override
	public String toString() {
		String result = "Syntax error on line " + line + ", col " + col;
		if (getMessage() != null && getMessage().length() > 0)
			result += ". " + getMessage();
		return result;
	}
}
