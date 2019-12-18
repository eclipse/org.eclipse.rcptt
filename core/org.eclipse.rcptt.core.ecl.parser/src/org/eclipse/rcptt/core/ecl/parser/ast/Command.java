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
package org.eclipse.rcptt.core.ecl.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Command extends Node {
	public Command(String text, Id name, int begin, int end) {
		super(text, begin, end);
		this.name = name;
	}

	public final Id name;

	public List<Arg> args = new ArrayList<Arg>();

	@Override
	public void accept(NodeVisitor visitor) {
		if (visitor.enter(this)) {
			name.accept(visitor);
			for (Arg arg : args) {
				if( arg != null) {
					arg.accept(visitor);
				}
			}
		}
		visitor.exit(name);
	}

	/**
	 * @return last arg or null if no args
	 */
	public Arg lastArg() {
		return args.isEmpty() ? null : args.get(args.size() - 1);
	}

}
