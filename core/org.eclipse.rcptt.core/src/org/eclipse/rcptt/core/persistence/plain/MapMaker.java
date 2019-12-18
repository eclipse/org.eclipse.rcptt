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
package org.eclipse.rcptt.core.persistence.plain;

import java.util.HashMap;

public class MapMaker<A, B> extends HashMap<A, B> {
	private static final long serialVersionUID = 3055187588462133784L;

	public MapMaker() {
	}

	public MapMaker<A, B> set(A name, B value) {
		put(name, value);
		return this;
	}
}
