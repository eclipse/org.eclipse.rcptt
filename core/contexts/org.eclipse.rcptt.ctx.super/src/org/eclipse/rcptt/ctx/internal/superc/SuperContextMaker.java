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
package org.eclipse.rcptt.ctx.internal.superc;

import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;

public class SuperContextMaker extends DefaultContextMaker {

	@Override
	public boolean canMake() {
		return false;
	}

	@Override
	public void makeExecutable(Context context, IQ7NamedElement source)
			throws ModelException {
	}
}
