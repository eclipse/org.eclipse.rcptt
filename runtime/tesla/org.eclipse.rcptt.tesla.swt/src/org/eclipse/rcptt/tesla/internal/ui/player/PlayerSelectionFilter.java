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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.util.Arrays;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;

public class PlayerSelectionFilter {

	public final SWTUIElement parent;
	public final GenericElementKind kind;
	public final String pattern;
	public final String[] path;
	public final Integer index;
	public final SWTUIElement after;
	public final Integer[] indexes;
	public final String classPattern;

	public PlayerSelectionFilter(SWTUIElement parent, GenericElementKind kind,
			String pattern, String[] path, Integer index,
			SWTUIElement after, Integer[] indexes, String classPattern) {
		this.parent = parent;
		this.kind = kind;
		this.pattern = pattern;
		this.path = path;
		this.index = index;
		this.after = after;
		this.indexes = indexes;
		this.classPattern = classPattern;
	}

	public PlayerSelectionFilter(SWTUIElement parent, ElementKind kind,
			String pattern) {
		this(parent, new GenericElementKind(kind), pattern, null, null, null, null, null);
	}

	public PlayerSelectionFilter withoutPattern() {
		return new PlayerSelectionFilter(parent, kind, null,
				path, index, after, indexes, classPattern);
	}

	public PlayerSelectionFilter withoutKind() {
		return new PlayerSelectionFilter(parent, null, pattern, path,
				index, after, indexes, classPattern);
	}

	@Override
	public String toString() {
		return String.format("Kind: %s, Path: %s", kind == null ? null : kind.kind,
				path == null ? null : Arrays.toString(path));
	}
}
