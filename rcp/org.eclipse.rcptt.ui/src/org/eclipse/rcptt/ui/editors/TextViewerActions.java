/*******************************************************************************
 * Copyright (c) 2018, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.ui.PlatformUI;

public final class TextViewerActions implements INamedElementActions {

	private final TextViewer textViewer;

	public TextViewerActions(TextViewer textViewer) {
		this.textViewer = textViewer;
		textViewer.setDocument(new Document());
		textViewer.setUndoManager(new TextViewerUndoManager(25));
		textViewer.activatePlugins();
	}

	@Override
	public void undo() {
		final IUndoContext ctx = getUndoContext();
		if (ctx != null) {
			try {
				getHistory().undo(ctx, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	@Override
	public void redo() {
		final IUndoContext ctx = getUndoContext();
		if (ctx != null) {
			try {
				getHistory().redo(ctx, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	@Override
	public boolean canUndo() {
		final IUndoContext ctx = getUndoContext();
		if (ctx != null) {
			return getHistory().canUndo(ctx);
		}
		return false;
	}

	@Override
	public boolean canRedo() {
		final IUndoContext ctx = getUndoContext();
		if (ctx != null) {
			return getHistory().canRedo(ctx);
		}
		return false;
	}

	IOperationHistory getHistory() {
		if (PlatformUI.getWorkbench() == null) {
			return null;
		}

		return PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
	}

	private IUndoContext getUndoContext() {
		if (getTextViewer() instanceof ITextViewerExtension6) {
			final IUndoManager undoManager = ((ITextViewerExtension6) getTextViewer()).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension)
				return ((IUndoManagerExtension) undoManager).getUndoContext();
		}
		return null;
	}

	private TextViewer getTextViewer() {
		return textViewer;
	}

	private StyledText getTextControl() {
		return getTextViewer().getTextWidget();
	}

	@Override
	public void copy() {
		TextUtils.copy(getTextControl());
	}

	@Override
	public void paste() {
		TextUtils.paste(getTextControl());
	}

	@Override
	public void cut() {
		TextUtils.cut(getTextControl());
	}

	@Override
	public boolean canCopy() {
		return TextUtils.canCopy(getTextControl());
	}

	@Override
	public boolean canPaste() {
		return TextUtils.canPaste(getTextControl());
	}

	@Override
	public boolean canCut() {
		return TextUtils.canCut(getTextControl());
	}
}
