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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;

public class NamedElementActionsAdapter implements INamedElementActions {

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public boolean canRedo() {
		return false;
	}

	@Override
	public void copy() {
	}

	@Override
	public void paste() {
	}

	@Override
	public void cut() {
	}

	@Override
	public boolean canCopy() {
		return false;
	}

	@Override
	public boolean canPaste() {
		return false;
	}

	@Override
	public boolean canCut() {
		return false;
	}
}
