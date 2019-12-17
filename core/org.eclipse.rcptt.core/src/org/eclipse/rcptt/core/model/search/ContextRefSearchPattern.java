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
package org.eclipse.rcptt.core.model.search;

import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;

public class ContextRefSearchPattern extends SearchPattern {
	private String cid;

	public ContextRefSearchPattern(String cid) {
		this.cid = cid;
	}

	@Override
	public IKeyQuery getPattern() {
		return new IKeyQuery() {
			public boolean accept(String key, String value) {
				if (IQ7IndexConstants.CONTEXT_REF.equals(key)
						&& cid.equals(value)) {
					return true;
				}
				return false;
			}
		};
	}

	@Override
	public String[] getKeys() {
		return new String[] { IQ7IndexConstants.CONTEXT_REF };
	}

}
