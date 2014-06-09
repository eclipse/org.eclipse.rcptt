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
package org.eclipse.rcptt.core.ecl.parser.ast;

public abstract class Node {
	public final int begin;
	public final int end;
	public final String text;

	public Node(String text, int begin, int end) {
		this.begin = begin;
		this.end = end;
		this.text = text;
	}

	public void accept(NodeVisitor visitor) {
		visitor.enter(this);
		visitor.exit(this);
	}

	public String getText(String text) {
		return text.substring(begin, end);
	}

	public boolean contains(int offset) {
		return begin <= offset && offset < end;
	}

	public boolean containsOrEnds(int offset) {
		return begin <= offset && offset <= end;
	}

	public int length() {
		return end - begin;
	}
	
	@Override
	public String toString() {
		return String.format("Text: %s,  begin: %d, end: %d", this.text, this.begin, this.end);
	}
}
