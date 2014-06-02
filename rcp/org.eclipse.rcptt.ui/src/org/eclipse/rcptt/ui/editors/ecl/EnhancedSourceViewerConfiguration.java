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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class EnhancedSourceViewerConfiguration extends
		TextSourceViewerConfiguration {

	protected ColorManager colorManager = new ColorManager();
	protected EditorToolkit toolkit;
	private EnhancedRuleScanner[] scanners;

	public EnhancedSourceViewerConfiguration(EditorToolkit toolkit) {
		super(toolkit.getPreferenceStore());
		this.toolkit = toolkit;		
	}

	public EditorToolkit getEditorToolkit() {
		return toolkit;
	}

	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return toolkit.getContentTypes();
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		String[] contentTypes = toolkit.getContentTypes();
		scanners = new EnhancedRuleScanner[contentTypes.length];
		for (int i = 0; i < contentTypes.length; i++) {
			String ct = contentTypes[i];
			scanners[i] = toolkit.getScanner(ct);
			scanners[i].initialize();
			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanners[i]);
			reconciler.setDamager(dr, ct);
			reconciler.setRepairer(dr, ct);
		}
		return reconciler;
	}

	public boolean affectsTextPresentation(PropertyChangeEvent event) {
		for (EnhancedRuleScanner s : scanners) {
			if (s.affectsBehavior(event))
				return true;
		}
		return false;
	}

	public void handlePropertyChangeEvent(PropertyChangeEvent event) {
		for (EnhancedRuleScanner s : scanners) {
			if (s.affectsBehavior(event))
				s.adaptToPreferenceChange(event);
		}
	}

	// @Override
	// public IReconciler getReconciler(ISourceViewer sourceViewer) {
	// if (fEditor != null && fEditor.isEditable()) {
	// IReconcilingStrategy s = new IReconcilingStrategy() {
	// HPBasicEditor e = fEditor;
	//
	// public void reconcile(IRegion partition) {
	// e.updateFolding();
	// }
	//
	// public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
	// e.updateFolding();
	// }
	//
	// public void setDocument(IDocument document) {
	// e.updateFolding();
	// }
	//
	// };
	// MonoReconciler reconciler = new MonoReconciler(s, false);
	// reconciler.setIsIncrementalReconciler(false);
	// reconciler.setProgressMonitor(new NullProgressMonitor());
	// reconciler.setDelay(500);
	// return reconciler;
	// }
	// return null;
	// }

}
