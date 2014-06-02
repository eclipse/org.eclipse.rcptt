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
package org.eclipse.rcptt.compare;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.ui.editors.ecl.EclSourceViewer;
import org.eclipse.rcptt.ui.editors.ecl.EclSourceViewerConfiguration;

public class ECLMergeViewerCreator implements IViewerCreator {

	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		return new ECLMergeViewer(parent, config);
	}

	class ECLMergeViewer extends TextMergeViewer {

		public static final String ECL_COMPARE_TITLE = "ECL Compare"; //$NON-NLS-1$

		public ECLMergeViewer(Composite parent,
				CompareConfiguration configuration) {
			super(parent, configuration);
		}

		@Override
		protected SourceViewer createSourceViewer(Composite parent,
				int textOrientation) {
			return EclSourceViewer.createEclSourceViewer(parent);
		}

		@Override
		protected void configureTextViewer(TextViewer textViewer) {
			if (textViewer instanceof EclSourceViewer) {
				((EclSourceViewer) textViewer)
						.configure(new EclSourceViewerConfiguration());
			}
		}

		@Override
		public String getTitle() {
			return ECL_COMPARE_TITLE;
		}

	}
}
