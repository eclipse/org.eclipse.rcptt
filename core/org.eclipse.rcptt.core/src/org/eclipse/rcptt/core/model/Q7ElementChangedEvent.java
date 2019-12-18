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
package org.eclipse.rcptt.core.model;

import java.util.EventObject;

public class Q7ElementChangedEvent extends EventObject {

	private static final long serialVersionUID = -8876465148756188700L;

	public static final int POST_CHANGE = 1;

	public static final int POST_RECONCILE = 4;

	private int type;

	public Q7ElementChangedEvent(IQ7ElementDelta delta, int type) {
		super(delta);
		this.type = type;
	}

	public IQ7ElementDelta getDelta() {
		return (IQ7ElementDelta) this.source;
	}

	public int getType() {
		return this.type;
	}
}
