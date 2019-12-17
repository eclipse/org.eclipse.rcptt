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

public class VerificationRefSearchPattern extends SearchPattern {
	private String id;

	public VerificationRefSearchPattern(String id) {
		this.id = id;
	}

	@Override
	public IKeyQuery getPattern() {
		return new IKeyQuery() {
			public boolean accept(String key, String value) {
				if (IQ7IndexConstants.VERIFICATION_REF.equals(key)
						&& id.equals(value)) {
					return true;
				}
				return false;
			}
		};
	}

	@Override
	public String[] getKeys() {
		return new String[] { IQ7IndexConstants.VERIFICATION_REF };
	}

}
