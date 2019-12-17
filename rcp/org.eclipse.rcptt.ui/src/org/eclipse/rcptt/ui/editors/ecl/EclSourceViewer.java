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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.ecl.model.Q7ElementContainer;

public class EclSourceViewer extends EnhancedSourceViewer {

	private Q7ElementContainer elementContainer;
	private IQ7NamedElement element;

	public EclSourceViewer(Composite parent, IVerticalRuler ruler) {
		this(parent, ruler, null, false, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
	}

	public EclSourceViewer(Composite parent, IVerticalRuler ruler,
			IOverviewRuler overviewRuler, boolean showsAnnotationOverview,
			int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {		
		super.configure(configuration);
	};
	
	@Override
	public Composite getControl() {
		return (Composite) super.getControl();
	}

	public static EclSourceViewer createEclSourceViewer(Composite parent) {
		CompositeRuler ruler = new CompositeRuler();
		LineNumberRulerColumn column = new LineNumberRulerColumn() {
			@Override
			public int getWidth() {
				return super.getWidth() + 10;
			}
		};
		Font font = JFaceResources.getTextFont();
		column.setFont(font);
		column.setForeground(parent.getDisplay().getSystemColor(
				SWT.COLOR_DARK_GRAY));
		ruler.addDecorator(0, column);
		return new EclSourceViewer(parent, ruler);
	}
	public void ignoreAutoEditStrategies(boolean ignore) {
		super.ignoreAutoEditStrategies(ignore);
	}

	public synchronized Q7ElementContainer getElementContainer() {
		if( elementContainer != null && this.element != null) {
			if( !elementContainer.isSameContent(getDocument().get(), element) ) {
				elementContainer = null;
			}
		}
		if( elementContainer == null) {
			elementContainer = new Q7ElementContainer(element, getDocument().get(), getDocument()
					.getLength(), true);
		}
		return elementContainer;
	}

	public synchronized void clearElementContainer() {
		if( elementContainer != null && this.element != null) {
			if( elementContainer.isSameContent(getDocument().get(), element) ) {
				return; // Don't need to clear it is same.
			}
		}
		this.elementContainer = null;
	}

	public IQ7NamedElement getElement() {
		return this.element;
	}
	public void setElement(IQ7NamedElement element) {
		if( elementContainer != null) {
			this.elementContainer = null;
		}
		this.element = element;
	}
}
