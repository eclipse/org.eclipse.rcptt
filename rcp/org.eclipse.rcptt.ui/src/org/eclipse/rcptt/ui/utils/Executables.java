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
package org.eclipse.rcptt.ui.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcptt.launching.IExecutable;

public class Executables {

	private IExecutable[] executables;
	private Map<IExecutable, IExecutable> childToParent;

	public Executables(IExecutable[] executables) {
		this.executables = executables;
	}

	public IExecutable getParent(IExecutable executable) {
		if (childToParent == null) {
			initialize();
		}
		return childToParent.get(executable);
	}

	public IExecutable[] getRoots() {
		return executables;
	}

	private void initialize() {
		synchronized (this) {
			if (childToParent == null) {
				childToParent = new HashMap<IExecutable, IExecutable>();
				for (IExecutable executable : executables) {
					for (IExecutable child : executable.getChildren()) {
						childToParent.put(child, executable);
					}
				}
			}
		}
	}
}
