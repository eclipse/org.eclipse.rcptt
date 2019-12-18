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
package org.eclipse.rcptt.internal.launching;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.launching.AutLaunch;

public abstract class ContextExecutable extends DataExecutable {

	public ContextExecutable(AutLaunch launch, IContext context, boolean debug) {
		super(launch, context, debug);
	}

	@Override
	public IContext getActualElement() {
		return (IContext) super.getActualElement();
	}

	public int getType() {
		return TYPE_CONTEXT;
	}

	@Override
	public String toString() {
		return "Context: " + getActualElement();
	}
}
