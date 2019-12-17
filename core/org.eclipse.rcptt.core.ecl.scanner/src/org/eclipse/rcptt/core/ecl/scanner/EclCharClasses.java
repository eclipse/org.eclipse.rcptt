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

public class EclCharClasses {

	private EclCharClasses() {

	}

	public static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isIdentifierStart(char c) {
		return (c >= 'a' && c <= 'z')
				|| (c >= 'A' && c <= 'Z')
				|| c == '_';
	}

	public static boolean isIdentifier(char c) {
		return isIdentifierStart(c)
				|| isDigit(c)
				|| c == '-';
	}

	public static boolean isWhitespace(char c) {
		return c == ' ' || c == '\t' || c == '\n' || c == '\r';
	}

}
