/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.launching.ext;

import com.google.common.base.Predicate;

public class StartsWith implements Predicate<String> {
	private final String prefix;

	public StartsWith(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean apply(String input) {
		return input.startsWith(prefix);
	}

}