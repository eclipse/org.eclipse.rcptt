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
package org.eclipse.rcptt.core.ecl.highlighter;

import org.eclipse.rcptt.core.ecl.highlighter.internal.ScanningHighlighter;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;

public class EclHighlighter {

	public enum RunType {
		Invalid,

		Spacing,
		Comment,

		Punctuation,

		Command,
		Option,

		Literal,
		Variable
	}

	public interface Strategy {
		public void highlight(RunType type, int start, int end);
	}

	public void highlight(String text, Strategy strategy) {
		if (text == null)
			throw new IllegalArgumentException("text cannot be null.");

		if (strategy == null)
			throw new IllegalArgumentException("strategy cannot be null.");

		new ScanningHighlighter().highlight(new EclScanner(text), strategy);
	}

}
