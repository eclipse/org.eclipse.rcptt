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

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlinkPresenter;
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.rcptt.ui.editors.quickfix.EclSourceQuickAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;

public class EclSourceViewerConfiguration extends
		EnhancedSourceViewerConfiguration {

	private EclEditor textEditor;

	public EclSourceViewerConfiguration(EclEditor textEditor) {
		super(EclEditorToolkit.getInstance());
		this.textEditor = textEditor;
	}

	public EclSourceViewerConfiguration() {
		super(EclEditorToolkit.getInstance());
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant assistant = new ContentAssistant();

		assistant.enableAutoActivation(ECLEditorPlugin.getECLScriptContentAssistActivationState());
		assistant.setAutoActivationDelay(ECLEditorPlugin.getECLScriptContentAssistDelay());
		assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_REMOVE);
		assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);

		IContentAssistProcessor generalContentAssistProcessor = new EclContentAssistProcessor();
		assistant.setContentAssistProcessor(generalContentAssistProcessor, IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
		return assistant;
	}

	@Override
	public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
		IQuickAssistAssistant quickAssist = new QuickAssistAssistant();
		quickAssist.setQuickAssistProcessor(new EclSourceQuickAssistProcessor());
		quickAssist.setInformationControlCreator(getInformationControlCreator(sourceViewer));
		return quickAssist;
	};

	@Override
	public IInformationControlCreator getInformationControlCreator(
			ISourceViewer sourceViewer) {

		return new AbstractReusableInformationControlCreator() {
			protected IInformationControl doCreateInformationControl(
					Shell parent) {
				if (!EclInformationContol.isAvailable(parent))
					return new DefaultInformationControl(parent);

				return new EclInformationContol(parent, false) {
					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return new AbstractReusableInformationControlCreator() {

							@Override
							protected IInformationControl doCreateInformationControl(
									Shell parent) {
								if (!EclInformationContol.isAvailable(parent))
									return new DefaultInformationControl(parent);

								return new EclInformationContol(parent, true);
							}

						};
					}
				};
			}
		};
	}

	public int getTabWidth(ISourceViewer sourceViewer) {
		return 4;
	}

	@Override
	protected boolean isShowInVerticalRuler(Annotation annotation) {
		return true;
	}

	@Override
	public String[] getDefaultPrefixes(ISourceViewer sourceViewer,
			String contentType) {
		return new String[] { "//", "" }; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer,
			String contentType) {
		return new EclTextHover();
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		if (sourceViewer != null && sourceViewer.isEditable()
				&& sourceViewer instanceof EclSourceViewer) {
			EclCompositeReconcilingStrategy strategy = new EclCompositeReconcilingStrategy(
					(EclSourceViewer) sourceViewer,
					getConfiguredDocumentPartitioning(sourceViewer));
			MonoReconciler reconciler = new MonoReconciler(strategy, false);
			reconciler.setIsAllowedToModifyDocument(false);
			reconciler.setDelay(500);

			return reconciler;
		}
		return super.getReconciler(sourceViewer);
	}

	@Override
	public IHyperlinkPresenter getHyperlinkPresenter(ISourceViewer sourceViewer) {
		return new MultipleHyperlinkPresenter(new RGB(0, 0, 255));
	};

	@Override
	public int getHyperlinkStateMask(ISourceViewer sourceViewer) {
		return SWT.MOD1;
	}

	@Override
	protected Map<String, IAdaptable> getHyperlinkDetectorTargets(ISourceViewer sourceViewer) {
		if (textEditor == null) {
			return super.getHyperlinkDetectorTargets(sourceViewer);
		}

		Map<String, IAdaptable> targets = super.getHyperlinkDetectorTargets(sourceViewer);
		targets.put("org.eclipse.rcptt.ui.ecltexthyperlinkdetectortarget", textEditor); //$NON-NLS-1$

		return targets;
	}

	@Override
	public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
		return getRegisteredHyperlinkDetectors(sourceViewer);
	};

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		MultiPassContentFormatter formatter = new MultiPassContentFormatter(
				getConfiguredDocumentPartitioning(sourceViewer), IDocument.DEFAULT_CONTENT_TYPE);
		formatter.setMasterStrategy(new EclFormattingStrategy());
		return formatter;
	}
}
