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
package org.eclipse.rcptt.tesla.nebula;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.grid.parts.GridPart;


public class NebulaPartUIElement extends NebulaUIElement {

	public final GridPart part;

	public NebulaPartUIElement(GridPart part, SWTUIPlayer p) {
		super(null, p);
		this.part = part;
	}

	//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NebulaPartUIElement other = (NebulaPartUIElement) obj;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + part;
	}

	//

	@Override
	public boolean isDisposed() {
		return part.grid().isDisposed();
	}

}
