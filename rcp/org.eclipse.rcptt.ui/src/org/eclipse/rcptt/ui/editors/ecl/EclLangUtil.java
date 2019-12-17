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
package org.eclipse.rcptt.ui.editors.ecl;

public class EclLangUtil {

	private EclLangUtil() {
	}

	public static boolean isCommandNameStart(int ch) {
		return Character.isJavaIdentifierStart(ch);
	}

	public static boolean isCommandNamePart(int ch) {
		return Character.isJavaIdentifierPart(ch) || ch == '.' || ch == '-'
				|| ch == '/' || ch == ':';
	}

	public static boolean isCommandDelimiter(int ch) {
		return ch == '|' || ch == '&' || ch == ';' || ch == '{' || ch == '[';
	}

	public static boolean isWhiteSpace(int ch) {
		return ch == ' ' || ch == '\t';
	}

	public static boolean isParamNameStart(int ch) {
		return ch == '-';
	}

	public static boolean isParamNamePart(int ch) {
		return isCommandNamePart(ch);
	}
}
