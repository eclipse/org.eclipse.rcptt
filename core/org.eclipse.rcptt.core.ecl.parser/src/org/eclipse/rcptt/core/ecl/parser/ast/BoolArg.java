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

public class BoolArg extends Arg {

	public BoolArg(String text, Id name, int begin, int end) {
		super(text, begin, end);
		this.name = name;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		if (visitor.enter(this)) {
			name.accept(visitor);
		}
		visitor.exit(this);
	}

}
