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
package org.eclipse.rcptt.core.ecl.highlighter.internal;

import org.eclipse.rcptt.core.ecl.highlighter.EclHighlighter.RunType;
import org.eclipse.rcptt.core.ecl.highlighter.EclHighlighter.Strategy;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;
import org.eclipse.rcptt.core.ecl.scanner.EclToken;

// Applicable only for one-liners like selectors.
public class ScanningHighlighter {

	public void highlight(EclScanner scanner, Strategy strategy) {
		int p = 0;
		boolean commandStart = true;

		loop: while (true) {
			RunType type = RunType.Invalid;
			EclToken t = scanner.next();

			switch (t.type) {
			case Eof:
				break loop;

			case Linebreak:
				commandStart = true;
				// this case intentionally left with no break
			case Spacing:
				type = RunType.Spacing;
				break;
			case SlComment:
			case MlComment:
				type = RunType.Comment;
				break;

			case Pipe:
			case Semicolon:
			case CurlyOpen:
			case SquareOpen:
				commandStart = true;
				// these cases intentionally left with no break
			case SquareClose:
			case CurlyClose:
			case Plus:
				type = RunType.Punctuation;
				break;

			case Option:
				type = RunType.Option;
				break;

			case Identifier:
				if (commandStart) {
					type = RunType.Command;
					commandStart = false;
					break;
				}
				// this case intentionally left with no break
			case Number:
			case String:
				type = RunType.Literal;
				break;

			case Variable:
				type = RunType.Variable;
				commandStart = false;
				break;

			}

			strategy.highlight(type, p, p + t.text.length());
			p += t.text.length();
		}
	}
}
