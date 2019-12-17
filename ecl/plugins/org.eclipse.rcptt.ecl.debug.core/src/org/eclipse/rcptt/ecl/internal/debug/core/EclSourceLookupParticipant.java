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
package org.eclipse.rcptt.ecl.internal.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

public class EclSourceLookupParticipant extends AbstractSourceLookupParticipant {

	public String getSourceName(Object object) throws CoreException {
		if (object instanceof EclStackFrame) {
			return ((EclStackFrame) object).getFile();
		}
		return null;
	}
}
