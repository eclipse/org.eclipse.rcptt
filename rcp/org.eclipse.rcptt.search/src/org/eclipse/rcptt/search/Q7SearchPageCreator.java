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
package org.eclipse.rcptt.search;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;

import org.eclipse.rcptt.replace.Q7SearchPageReplaceImpl;

public class Q7SearchPageCreator implements IExecutableExtensionFactory {

	public Q7SearchPageCreator() {
	}

	public Object create() throws CoreException {
		return new Q7SearchPageReplaceImpl();
	}
}
