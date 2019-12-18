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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

public class EnhancedSourceViewer extends ProjectionViewer implements
		IPropertyChangeListener, ISourceViewer {

	protected EditorToolkit toolkit;

	public EnhancedSourceViewer(Composite parent, IVerticalRuler ruler,
			IOverviewRuler overviewRuler, boolean showsAnnotationOverview,
			int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}

	public void propertyChange(PropertyChangeEvent event) {
		// Do nothing
	}

	public IContentAssistant getContentAssistant() {
		return super.fContentAssistant;
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		StyledText textWidget = getTextWidget();
		// reset foreground & background colors
		if (textWidget != null && !textWidget.isDisposed()) {
			Color foregroundColor = textWidget.getForeground();
			if (foregroundColor != null && foregroundColor.isDisposed())
				textWidget.setForeground(null);
			Color backgroundColor = textWidget.getBackground();
			if (backgroundColor != null && backgroundColor.isDisposed())
				textWidget.setBackground(null);
		}
		super.configure(configuration);
		// set font from preferences
		if (configuration instanceof EnhancedSourceViewerConfiguration) {
			toolkit = ((EnhancedSourceViewerConfiguration) configuration)
					.getEditorToolkit();
			if (textWidget != null) {
				textWidget.setFont(JFaceResources.getFont(toolkit
						.getEditorTextFont()));
			}
			IDocument document = getDocument();
			if (document != null) {
				IDocumentPartitioner partitioner = new FastPartitioner(
						toolkit.getPartitionScanner(), toolkit.getPartitions());
				partitioner.connect(document);
				document.setDocumentPartitioner(partitioner);
			}
		}
	}

	@Override
	public void resetVisibleRegion() {
		super.resetVisibleRegion();
		enableProjection();
	}

	@Override
	public void setDocument(IDocument document,
			IAnnotationModel annotationModel, int modelRangeOffset,
			int modelRangeLength) {
		if (document != null && toolkit != null) {
			IDocumentPartitioner partitioner = new FastPartitioner(
					toolkit.getPartitionScanner(), toolkit.getPartitions());
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		super.setDocument(document, annotationModel, modelRangeOffset,
				modelRangeLength);
	}

	@Override
	protected void disposeVisualAnnotationModel() {
		super.disposeVisualAnnotationModel();
		if (toolkit != null)
			toolkit.dispose();
	}
}
