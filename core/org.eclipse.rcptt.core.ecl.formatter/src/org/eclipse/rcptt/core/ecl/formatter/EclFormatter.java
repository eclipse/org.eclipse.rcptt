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
package org.eclipse.rcptt.core.ecl.formatter;

import org.eclipse.rcptt.core.ecl.formatter.internal.ParsingFormatter;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;

public class EclFormatter {

	private final EclFormatterOptions options;

	public EclFormatter() {
		this(new EclFormatterOptions());
	}

	public EclFormatter(EclFormatterOptions options) {
		if (options == null)
			throw new IllegalArgumentException("options cannot be null.");

		this.options = options;
	}

	public String format(String text) {
		if (text == null)
			throw new IllegalArgumentException("text cannot be null.");

		return new ParsingFormatter(options).format(new EclScanner(text));
	}
}
