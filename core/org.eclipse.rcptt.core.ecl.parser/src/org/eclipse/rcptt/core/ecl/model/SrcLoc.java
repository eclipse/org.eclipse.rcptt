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
package org.eclipse.rcptt.core.ecl.model;

public class SrcLoc {
	public SrcLoc(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	public final int begin;
	public final int end;

	public int length() {
		return end - begin;
	}

	public static SrcLoc shrinkLeft(SrcLoc loc, int delta) {
		return new SrcLoc(loc.begin + delta, loc.end);
	}

	public static SrcLoc shrinkRight(SrcLoc loc, int delta) {
		return new SrcLoc(loc.begin, loc.end - delta);
	}
}
