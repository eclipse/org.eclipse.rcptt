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
package org.eclipse.rcptt.internal.core.model.deltas;

import org.eclipse.rcptt.core.model.IQ7ElementDelta;

/**
 * A simple model element delta that remembers the kind of changes only.
 */
public class SimpleDelta {

	/*
	 * @see IModelElementDelta#getKind()
	 */
	protected int kind = 0;

	/*
	 * @see IModelElementDelta#getFlags()
	 */
	protected int changeFlags = 0;

	/*
	 * Marks this delta as added
	 */
	public void added() {
		this.kind = IQ7ElementDelta.ADDED;
	}

	/*
	 * Marks this delta as changed with the given change flag
	 */
	public void changed(int flags) {
		this.kind = IQ7ElementDelta.CHANGED;
		this.changeFlags |= flags;
	}

	/*
	 * @see IModelElementDelta#getFlags()
	 */
	public int getFlags() {
		return this.changeFlags;
	}

	/*
	 * @see IModelElementDelta#getKind()
	 */
	public int getKind() {
		return this.kind;
	}

	/*
	 * Mark this delta has a having a modifiers change
	 */
	public void modifiers() {
		changed(IQ7ElementDelta.F_MODIFIERS);
	}

	/*
	 * Marks this delta as removed
	 */
	public void removed() {
		this.kind = IQ7ElementDelta.REMOVED;
		this.changeFlags = 0;
	}

	protected void toDebugString(StringBuffer buffer) {
		buffer.append("["); //$NON-NLS-1$
		switch (getKind()) {
		case IQ7ElementDelta.ADDED:
			buffer.append('+');
			break;
		case IQ7ElementDelta.REMOVED:
			buffer.append('-');
			break;
		case IQ7ElementDelta.CHANGED:
			buffer.append('*');
			break;
		default:
			buffer.append('?');
			break;
		}
		buffer.append("]: {"); //$NON-NLS-1$
		toDebugString(buffer, getFlags());
		buffer.append("}"); //$NON-NLS-1$
	}

	protected boolean toDebugString(StringBuffer buffer, int flags) {
		boolean prev = false;
		if ((flags & IQ7ElementDelta.F_MODIFIERS) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("MODIFIERS CHANGED"); //$NON-NLS-1$
			prev = true;
		}
		return prev;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		toDebugString(buffer);
		return buffer.toString();
	}
}
