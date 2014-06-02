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
package org.eclipse.rcptt.ui.editors.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import org.eclipse.rcptt.internal.core.RcpttPlugin;

public abstract class QuickFixer implements ICompletionProposal, IMarkerResolution, IMarkerResolution2 {

	protected String label;
	protected Image image;
	protected int start;
	protected int end;

	public QuickFixer(String label, Image image, int start, int end)
	{
		this.label = label;
		this.image = image;
		this.start = start;
		this.end = end;
	}

	public abstract void quickFix(IDocument doc);

	@Override
	public void run(IMarker marker) {
		try {
			IFile file = (IFile) marker.getResource();
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().
					getEditorRegistry().getDefaultEditor(file.getName());
			IEditorPart part = page.openEditor(new FileEditorInput(file), desc.getId());
			if (part != null) {
				ITextOperationTarget target =
						(ITextOperationTarget) part.getAdapter(ITextOperationTarget.class);
				if (target instanceof ITextViewer) {
					ITextViewer textViewer = (ITextViewer) target;
					quickFix(textViewer.getDocument());
				}
			}
		} catch (Throwable e) {
			RcpttPlugin.log(e);
		}
	}

	@Override
	public void apply(IDocument document) {
		quickFix(document);
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public Point getSelection(IDocument document) {
		return null;
	}

	@Override
	public String getAdditionalProposalInfo() {
		return null;
	}

	@Override
	public String getDisplayString() {
		return label;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public IContextInformation getContextInformation() {
		return null;
	}

}
