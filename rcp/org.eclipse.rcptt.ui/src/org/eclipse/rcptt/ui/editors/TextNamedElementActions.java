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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.swt.widgets.Text;

public class TextNamedElementActions extends NamedElementActionsAdapter {

	private Text text;

	/**
	 * @param widgetVerificationEditor
	 */
	public TextNamedElementActions(Text text) {
		this.text = text;
	}

	@Override
	public boolean canCopy() {
		if (text.isFocusControl()) {
			return TextUtils.canCopy(text);
		}
		return false;
	}

	@Override
	public boolean canPaste() {
		if (text.isFocusControl()) {
			return TextUtils.canPaste(text);
		}
		return false;
	}

	@Override
	public boolean canCut() {
		if (text.isFocusControl()) {
			return TextUtils.canCut(text);
		}
		return false;
	}

	@Override
	public void copy() {
		if (text.isFocusControl()) {
			TextUtils.copy(text);
		}
	}

	@Override
	public void paste() {
		if (text.isFocusControl()) {
			TextUtils.paste(text);
		}
	}

	@Override
	public void cut() {
		if (text.isFocusControl()) {
			TextUtils.cut(text);
		}
	}
}