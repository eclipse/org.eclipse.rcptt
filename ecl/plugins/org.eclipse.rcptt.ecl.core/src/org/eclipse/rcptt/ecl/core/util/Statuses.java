/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.core.util;

import org.eclipse.core.runtime.IStatus;

public class Statuses {
	public interface Visitor {
		/** @true is argument's children should be inspected too */
		boolean visit(IStatus status);
	}

	public static void visit(IStatus status, Visitor visitor) {
		if (status == null)
			return;
		if (visitor.visit(status)) {
			if (status.isMultiStatus()) {
				for (IStatus child : status.getChildren()) {
					visit(child, visitor);
				}
			}
		}
	}

	public static boolean hasCode(IStatus status, final int code) {
		final boolean[] rv = new boolean[] { false };
		visit(status, new Visitor() {

			@Override
			public boolean visit(IStatus status) {
				if (status.getCode() == code)
					rv[0] = true;
				return !rv[0];
			}
		});
		return rv[0];
	}
}
