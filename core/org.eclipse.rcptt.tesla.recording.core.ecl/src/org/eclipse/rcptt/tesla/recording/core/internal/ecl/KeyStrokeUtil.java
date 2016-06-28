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
package org.eclipse.rcptt.tesla.recording.core.internal.ecl;

public class KeyStrokeUtil {


	public static String formatTraverse(int keyCode) {

		switch (keyCode) {
		case SWTCopy.TRAVERSE_NONE:
			return "TRAVERSE_NONE";
		case SWTCopy.TRAVERSE_ESCAPE:
			return "TRAVERSE_ESCAPE";
		case SWTCopy.TRAVERSE_RETURN:
			return "TRAVERSE_RETURN";
		case SWTCopy.TRAVERSE_TAB_NEXT:
			return "TRAVERSE_TAB_NEXT";
		case SWTCopy.TRAVERSE_TAB_PREVIOUS:
			return "TRAVERSE_TAB_PREVIOUS";
		case SWTCopy.TRAVERSE_ARROW_NEXT:
			return "TRAVERSE_ARROW_NEXT";
		case SWTCopy.TRAVERSE_ARROW_PREVIOUS:
			return "TRAVERSE_ARROW_PREVIOUS";
		case SWTCopy.TRAVERSE_MNEMONIC:
			return "TRAVERSE_MNEMONIC";
		case SWTCopy.TRAVERSE_PAGE_NEXT:
			return "TRAVERSE_PAGE_NEXT";
		case SWTCopy.TRAVERSE_PAGE_PREVIOUS:
			return "TRAVERSE_PAGE_PREVIOUS";
		default:
			return "TRAVERSE_UNKNOWN";
		}
	}


	private KeyStrokeUtil() {
		throw new AssertionError();
	}
}
