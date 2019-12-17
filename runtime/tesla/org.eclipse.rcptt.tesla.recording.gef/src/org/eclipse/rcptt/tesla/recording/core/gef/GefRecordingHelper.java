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
package org.eclipse.rcptt.tesla.recording.core.gef;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.gef.GefModelMapper;
import org.eclipse.rcptt.tesla.gef.RawFigureUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper;

public class GefRecordingHelper extends BasicRecordingHelper<Object> {
	public static class GraphicalViewerEntry {
		SWTUIElement lowerParent;
		public DiagramViewerUIElement diagramViewer;
	}

	private static GefRecordingHelper mapper;
	private static Map<EditPartViewer, GraphicalViewerEntry> entries = new HashMap<EditPartViewer, GraphicalViewerEntry>();

	public static Map<EditPartViewer, GraphicalViewerEntry> getGraphicalViewerEntries() {
		return entries;
	}

	public synchronized static GefRecordingHelper getHelper() {
		if (mapper == null) {
			mapper = new GefRecordingHelper();
		}
		return mapper;
	}

	public void clearAllWithParent(Object part) {
		Set<Object> keySet = new HashSet<Object>(this.elements.keySet());
		for (Object e : keySet) {
			if (e instanceof EditPart) {
				List<EditPart> list = getParentsList((EditPart) e);
				if (list.contains(part)) {
					this.elements.remove(e);
					// Remove all figures of this edit part
					if (e instanceof GraphicalEditPart) {
						IFigure figure = ((GraphicalEditPart) e).getFigure();
						List<IFigure> figuresList = getFiguresList(figure);
						for (IFigure ef : figuresList) {
							this.elements.remove(ef);
						}
					}
				}
			}
		}
		// Remove all figures of this edit part
		if (part instanceof GraphicalEditPart) {
			IFigure figure = ((GraphicalEditPart) part).getFigure();
			List<IFigure> figuresList = getFiguresList(figure);
			for (IFigure ef : figuresList) {
				this.elements.remove(ef);
			}
		}
	}

	private List<EditPart> getParentsList(EditPart e) {
		List<EditPart> items = new ArrayList<EditPart>();
		while (e != null) {
			EditPart parent = e.getParent();
			if (parent != null) {
				items.add(parent);
			}
			e = parent;
		}
		return items;
	}

	@SuppressWarnings("rawtypes")
	private List<IFigure> getFiguresList(IFigure figure) {
		List<IFigure> items = new ArrayList<IFigure>();
		if (items.contains(figure)) {
			return new ArrayList<IFigure>();
		}
		items.add(figure);
		List children = figure.getChildren();
		for (Object object : children) {
			if (object instanceof IFigure) {
				IFigure fig = (IFigure) object;
				items.addAll(getFiguresList(fig));
			}
		}
		return items;
	}

	@Override
	public void clear() {
		super.clear();
		entries.clear();
	}

	@Override
	public PropertyNodeList getNodeProperties(Element element, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Object original = findByElement(element);
		if (original instanceof EditPart) {
			if (TeslaFeatures.isActivityLogging()) {
				Q7LoggingManager
						.logMessage(
								IQ7ActivityLogs.PROPERTIES,
								"fill list of extra properties for element: "
										+ original.getClass()
										+ ((nodePath != null && nodePath.length() > 0) ? " with prefix: "
												+ nodePath
												: ""));
			}
			GefFigureLocator locator = getLocator();
			if (locator != null) {
				PropertyNodeList propertyNodeList = locator.getNodeProperties(
						(EditPart) original, nodePath);
				if (propertyNodeList != null) {
					return propertyNodeList;
				}

			}
		}
		if (original instanceof RawFigureUIElement) {
			PropertyNodeList propertyNodeList = GefModelMapper
					.getPropertyNodes(
							((RawFigureUIElement) original).getFigure(),
							nodePath);
			if (propertyNodeList != null) {
				return propertyNodeList;
			}
		}
		GraphicalViewerEntry originalElement = entries.get(original);
		if (originalElement != null && originalElement.lowerParent != null) {
			return SWTModelMapper.getPropertyNodes(originalElement.lowerParent,
					nodePath);
		}
		return null;
	}

	private GefFigureLocator getLocator() {
		List<GefEventRecorder> recorders = TeslaRecorder.getInstance()
				.getProcessors(GefEventRecorder.class);
		if (recorders.size() > 0) {
			return recorders.get(0).getLocator();
		}
		return null;
	}

	public String getWidgetDetails(Element element) {
		// TODO Auto-generated method stub
		return null;
	}
}
