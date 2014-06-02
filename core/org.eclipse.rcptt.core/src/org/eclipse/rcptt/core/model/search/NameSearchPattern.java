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
package org.eclipse.rcptt.core.model.search;

import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;

public class NameSearchPattern extends SearchPattern {
	private String name;

	public NameSearchPattern(String name) {
		this.name = name;
	}

	@Override
	public IKeyQuery getPattern() {
		return new IKeyQuery() {
			public boolean accept(String key, String value) {
				if (IQ7IndexConstants.NAME.equals(key) && name.equals(value)) {
					return true;
				}
				return false;
			}
		};
	}

	@Override
	public String[] getKeys() {
		return new String[] { IQ7IndexConstants.NAME };
	}

}
