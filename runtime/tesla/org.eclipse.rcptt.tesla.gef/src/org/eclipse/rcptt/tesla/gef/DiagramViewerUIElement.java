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
package org.eclipse.rcptt.tesla.gef;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.swt.widgets.Canvas;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;

public class DiagramViewerUIElement extends SWTUIElement {

	private GraphicalViewer viewer;
	private Canvas canvas;
	private EventDispatcher dispatcher;
	private EditPartFactory factory;
	private EditDomain domain;

	public DiagramViewerUIElement(SWTUIPlayer p, GraphicalViewer viewer) {
		super(viewer.getControl(), p);
		this.viewer = viewer;
		canvas = (Canvas) viewer.getControl();
		if (canvas instanceof FigureCanvas) {
			dispatcher = ((FigureCanvas) canvas).getLightweightSystem().getRootFigure()
					.internalGetEventDispatcher();
		}
		else {
			if (viewer instanceof GraphicalViewerImpl) {
				dispatcher = TeslaSWTAccess.getField(EventDispatcher.class, viewer, "eventDispatcher");
				if (dispatcher == null) {
					LightweightSystem lws = TeslaSWTAccess.getField(LightweightSystem.class, viewer, "lws");
					if (lws != null) {
						dispatcher = lws.getRootFigure().internalGetEventDispatcher();
					}
				}
			}
		}
		factory = viewer.getEditPartFactory();
		domain = viewer.getEditDomain();
	}

	@Override
	public GenericElementKind getKind() {
		return new GenericElementKind(ElementKind.DiagramViewer);
	}

	public EventDispatcher getDispatcher() {
		return dispatcher;
	}

	public EditDomain getDomain() {
		return domain;
	}

	public EditPartFactory getFactory() {
		return factory;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public GraphicalViewer getViewer() {
		return viewer;
	}

	public List<ToolEntry> listToolbarEntries() {
		PaletteViewer paletteViewer = domain.getPaletteViewer();
		List<ToolEntry> entries = new ArrayList<ToolEntry>();
		if (paletteViewer != null) {
			PaletteRoot root = paletteViewer.getPaletteRoot();
			fillPaletteFrom(root, entries);
			// System.out.println();
		}
		return entries;
	}

	@SuppressWarnings("rawtypes")
	private void fillPaletteFrom(PaletteContainer root, List<ToolEntry> entries) {
		List children = root.getChildren();
		for (Object object : children) {
			if (object instanceof PaletteContainer) {
				PaletteContainer con = (PaletteContainer) object;
				fillPaletteFrom(con, entries);
			} else if (object instanceof ToolEntry) {
				entries.add((ToolEntry) object);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((canvas == null) ? 0 : canvas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiagramViewerUIElement other = (DiagramViewerUIElement) obj;
		if (canvas == null) {
			if (other.canvas != null)
				return false;
		} else if (!canvas.equals(other.canvas))
			return false;
		return true;
	}

	public IFigure getFigureContents() {
		if (canvas instanceof FigureCanvas) {
			return ((FigureCanvas) canvas).getContents();
		}
		if (viewer instanceof GraphicalViewerImpl) {
			LightweightSystem lws = TeslaSWTAccess.getField(LightweightSystem.class, viewer, "lws");
			if (lws != null) {
				return lws.getRootFigure();
			}
		}
		return null;
	}

}
