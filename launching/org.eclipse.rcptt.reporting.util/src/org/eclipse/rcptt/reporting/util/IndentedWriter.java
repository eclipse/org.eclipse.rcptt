/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.reporting.util;

import java.io.PrintWriter;
import java.io.Writer;

public abstract class IndentedWriter extends PrintWriter {
	private boolean newLine = true;

	public IndentedWriter(Writer out) {
		super(out);
	}

	@Override
	public void println() {
		super.println();
		newLine = true;
	}

	@Override
	public void write(String s, int off, int len) {
		if (newLine) {
			newLine = false;
			writeIndent();
		}
		super.write(s, off, len);
	}

	public abstract void writeIndent();
}