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
package org.eclipse.rcptt.ui.editors.ecl.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.ecl.model.Declaration;
import org.eclipse.rcptt.core.ecl.parser.ast.Reference;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.context.ContextEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclTextHyperLinkDetector;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;

public class EclOpenDeclarationAction extends Action {

	private EclEditor eclEditor;

	public EclOpenDeclarationAction(EclEditor editor) {
		super("Open Declaration");
		this.eclEditor = editor;
	}

	@Override
	public boolean isEnabled() {
		return getReference() != null;

	}

	private Reference getReference() {
		// boolean editorsActive = !this.eclEditor.viewer.getControl()
		// .isFocusControl()
		// && (this.eclEditor.header.isInFocus() || this.eclEditor.editorContent
		// .isInFocus());
		// if (editorsActive) {
		// return null;
		// }
		ISelectionProvider selectionProvider = eclEditor.getSelectionProvider();
		if (selectionProvider == null) {
			return null;
		}
		ISelection selection = selectionProvider.getSelection();
		// offset
		int offset = ((ITextSelection) selection).getOffset();
		ITextViewer viewer = eclEditor.doGetSourceViewer();
		Reference reference = EclTextHyperLinkDetector.getReferenceAtPoint(viewer, offset);
		return reference;

	}

	public void run() {
		Reference reference = getReference();
		if (reference != null) {
			openDeclaration(reference.dest);
		}
	}

	public static void openDeclaration(Declaration reference) {
		IQ7NamedElement element = Q7SearchCore.findById(reference.container.getResource());

		IResource resource = element.getResource();
		if (!(resource instanceof IFile)) {
			return;
		}
		try {
			IEditorPart editor = IDE.openEditor(WorkbenchUtils.getPage(), (IFile) element.getResource());
			if (editor instanceof EclEditor) {
				// test case editor
				((EclEditor) editor).selectAndReveal(reference.location.begin,
						reference.location.length());
			} else {
				if (editor instanceof ContextEditor) {
					IEditorPart innerPart = ((ContextEditor) editor).getEditor();
					if (innerPart instanceof EclEditor) {
						// ECL context editor
						((EclEditor) innerPart).selectAndReveal(reference.location.begin,
								reference.location.length());
					} else {
						// Parameters context editor
						((ContextEditor) editor).setSelectionAtLine(reference.location.begin);
					}
				}
			}
		} catch (PartInitException e) {
			Q7UIPlugin.log("Error opening editor", e);
			return;
		}
	}
}