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
package org.eclipse.rcptt.core.ecl.scanner;

public class EclToken {
	public Type type;
	public String text;
	public Object value;
	public String message;
	public int begin;
	public int end;

	@Override
	public String toString() {
		return String.format("%s %s %s %s", type, text, value, message);
	}

	public static enum Type {
		Invalid,
		Eof,

		Spacing,
		Linebreak,
		SlComment,
		MlComment,

		Pipe,
		Semicolon,
		Plus,

		SquareOpen,
		SquareClose,
		CurlyOpen,
		CurlyClose,

		Option,

		Identifier,
		Number,
		String,
		Variable
	}
}
