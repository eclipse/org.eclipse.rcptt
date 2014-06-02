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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;

public abstract class CompositeNamedElementActions implements INamedElementActions {
	private final INamedElementActions[] actions;

	public CompositeNamedElementActions(INamedElementActions... actions) {
		this.actions = actions;
	}

	public abstract void update();

	@Override
	public void undo() {
		for (INamedElementActions e : actions) {
			if( e != null && e.canUndo()) {
				e.undo();
			}
		}
		update();
	}

	@Override
	public void redo() {
		for (INamedElementActions e : actions) {
			if( e != null && e.canRedo()) {
				e.redo();
			}
		}
		update();
	}

	@Override
	public void paste() {
		for (INamedElementActions e : actions) {
			if( e != null && e.canPaste()) {
				e.paste();
			}
		}
		update();
	}

	@Override
	public void cut() {
		for (INamedElementActions e : actions) {
			if( e != null && e.canCut()) {
				e.cut();
			}
		}
		update();
	}

	@Override
	public void copy() {
		for (INamedElementActions e : actions) {
			if( e != null && e.canCopy()) {
				e.copy();
			}
		}
		update();
	}

	@Override
	public boolean canUndo() {
		boolean result = false;
		for (INamedElementActions e : actions) {
			if (e != null) {
				result |= e.canUndo();
			}
		}
		return result;
	}

	@Override
	public boolean canRedo() {
		boolean result = false;
		for (INamedElementActions e : actions) {
			if( e != null) {
				result |= e.canRedo();
			}
		}
		return result;
	}

	@Override
	public boolean canPaste() {
		boolean result = false;
		for (INamedElementActions e : actions) {
			if( e != null) {
				result |= e.canPaste();
			}
		}
		return result;
	}

	@Override
	public boolean canCut() {
		boolean result = false;
		for (INamedElementActions e : actions) {
			if( e != null) {
				result |= e.canCut();
			}
		}
		return result;
	}

	@Override
	public boolean canCopy() {
		boolean result = false;
		for (INamedElementActions e : actions) {
			if( e != null) {
				result |= e.canCopy();
			}
		}
		return result;
	}
}