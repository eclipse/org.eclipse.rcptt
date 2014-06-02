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
package org.eclipse.rcptt.ui.editors.ecl.actions;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.TextNavigationAction;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class EclTextNavigationAction extends TextNavigationAction {
	protected final EclEditor eclEditor;
	private int fAction;

	public EclTextNavigationAction(EclEditor eclEditor, StyledText textWidget,
			int action) {
		super(textWidget, action);
		this.eclEditor = eclEditor;
		this.fAction = action;
	}

	protected void internalRun(TextViewer viewer) {
		Point selection = viewer.getTextWidget().getSelection();
		viewer.getTextWidget().invokeAction(getAction());
		fireSelectionChanged(selection);
	}

	protected int getAction() {
		return fAction;
	}

	@Override
	public void run() {
		boolean editorsActive = !this.eclEditor.viewer.getControl()
				.isFocusControl()
				&& (this.eclEditor.header.isInFocus() || this.eclEditor.editorContent
						.isInFocus());
		if (!editorsActive) {
			internalRun(eclEditor.doGetSourceViewer());
		} else {
			if (this.eclEditor.header.isInFocus()) {
				this.eclEditor.header.doTextCommand(getAction());
			}
			if (this.eclEditor.editorContent.isInFocus()) {
				TextViewer textViewer = this.eclEditor.editorContent
						.getTextViewer();
				if (textViewer != null) {
					internalRun(textViewer);
				} else {
					this.eclEditor.editorContent.doTextCommand(getAction());
				}
			}
		}
	}

	@Override
	public void addPropertyChangeListener(final IPropertyChangeListener listener) {
		addListenerObject(listener);
	}

	public void removePropertyChangeListener(
			final IPropertyChangeListener listener) {
		removeListenerObject(listener);
	}

	private boolean enabled = true;

	@Override
	public void setEnabled(boolean enabled) {
		if (enabled != this.enabled) {
			Boolean oldVal = this.enabled ? Boolean.TRUE : Boolean.FALSE;
			Boolean newVal = enabled ? Boolean.TRUE : Boolean.FALSE;
			this.enabled = enabled;
			firePropertyChange(ENABLED, oldVal, newVal);
		}
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}