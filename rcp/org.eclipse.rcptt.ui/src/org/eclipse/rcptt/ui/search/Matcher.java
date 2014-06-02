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
package org.eclipse.rcptt.ui.search;

import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.rcptt.core.model.IQ7NamedElement;

public interface Matcher {
	public boolean matches(final IQ7NamedElement object, final String query,
			final SubMonitor monitor);
}
