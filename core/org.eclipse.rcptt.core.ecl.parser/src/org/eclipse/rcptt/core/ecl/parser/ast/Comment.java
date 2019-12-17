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
package org.eclipse.rcptt.core.ecl.parser.ast;

public class Comment extends Node {
	public Comment(String text, int begin, int end) {
		super(text, begin, end);
	}

	/**
	 * Uses to remember next command position because
	 * line break can be "\n" or "\n\r".
	 */
	public int nextCommandAt;

}
