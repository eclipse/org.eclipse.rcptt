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

public class Script extends Node {

	public Script(String text, int begin, int end) {
		super(text, begin, end);
	}

	public List<Pipeline> pipelines = new ArrayList<Pipeline>();
	public List<Comment> comments = new ArrayList<Comment>();

	@Override
	public void accept(NodeVisitor visitor) {
		if (visitor.enter(this)) {
			for (Pipeline pipeline : pipelines) {
				pipeline.accept(visitor);
			}
			for (Comment comment : comments) {
				comment.accept(visitor);
			}
		}
		visitor.exit(this);
	}

	/**
	 * Returns comment that describes procedure (proc).
	 * 
	 * @param procBegin
	 *            Procedure begin position
	 * @return String
	 */
	public String findProcDescription(int procBegin) {
		String description = "";
		for (int i = 0; i < comments.size(); i++) {
			Comment comment = comments.get(i);
			if (comment.nextCommandAt == procBegin) {
				description = comment.text;
				break;
			}
		}

		return description;
	}

}
