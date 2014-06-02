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
package org.eclipse.rcptt.ctx.parameters.ui;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;

public class ParametersTransfer extends LocalTransfer {

	protected static final String TYPE_NAME = "org.eclipse.rcptt.ctx.parameters.ui.ParametersTransfer";
	protected static final int TYPE_ID = registerType(TYPE_NAME);
	public static ParametersTransfer INSTANCE = new ParametersTransfer();
	
	@Override
	protected int[] getTypeIds() {
		return new int[]{TYPE_ID};
	}

	@Override
	public String[] getTypeNames() {
		return new String[]{TYPE_NAME};
	}
	
}
